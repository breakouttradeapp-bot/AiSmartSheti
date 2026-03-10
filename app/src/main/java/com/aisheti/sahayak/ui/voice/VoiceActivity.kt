package com.aisheti.sahayak.ui.voice

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.aisheti.sahayak.databinding.ActivityVoiceBinding
import com.aisheti.sahayak.utils.Resource
import com.aisheti.sahayak.utils.showToast
import com.aisheti.sahayak.viewmodel.VoiceViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class VoiceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVoiceBinding
    private val viewModel: VoiceViewModel by viewModels()
    private var speechRecognizer: SpeechRecognizer? = null
    private var isListening = false

    private val micPermLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) startListening()
        else showToast("Microphone permission required")
    }

    companion object {
        private const val EXTRA_PROMPT = "extra_prompt"
        fun startWithPrompt(context: Context, prompt: String) {
            context.startActivity(Intent(context, VoiceActivity::class.java).apply {
                putExtra(EXTRA_PROMPT, prompt)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpeechRecognizer()
        setupClickListeners()
        observeViewModel()

        // Handle prompt passed from home screen
        intent.getStringExtra(EXTRA_PROMPT)?.let { prompt ->
            binding.etQuestion.setText(prompt)
            viewModel.askAI(prompt)
        }
    }

    private fun setupSpeechRecognizer() {
        if (!SpeechRecognizer.isRecognitionAvailable(this)) {
            binding.btnMic.isEnabled = false
            return
        }
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        speechRecognizer?.setRecognitionListener(object : RecognitionListener {
            override fun onReadyForSpeech(params: Bundle?) {
                binding.tvStatus.text = "🎤 Listening..."
                binding.btnMic.isActivated = true
            }
            override fun onResults(results: Bundle?) {
                isListening = false
                binding.btnMic.isActivated = false
                val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                val text = matches?.firstOrNull() ?: return
                binding.etQuestion.setText(text)
                binding.tvStatus.text = "Processing..."
                viewModel.askAI(text)
            }
            override fun onError(error: Int) {
                isListening = false
                binding.btnMic.isActivated = false
                binding.tvStatus.text = "Tap mic to speak"
                showToast("Speech recognition error. Try again.")
            }
            override fun onBeginningOfSpeech() {}
            override fun onRmsChanged(rmsdB: Float) {}
            override fun onBufferReceived(buffer: ByteArray?) {}
            override fun onEndOfSpeech() { binding.tvStatus.text = "Processing..." }
            override fun onPartialResults(partialResults: Bundle?) {}
            override fun onEvent(eventType: Int, params: Bundle?) {}
        })
    }

    private fun startListening() {
        if (isListening) {
            speechRecognizer?.stopListening()
            isListening = false
            return
        }
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
            putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
            putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
            putExtra(RecognizerIntent.EXTRA_PROMPT, "Ask your farming question...")
        }
        speechRecognizer?.startListening(intent)
        isListening = true
    }

    private fun setupClickListeners() {
        binding.btnBack.setOnClickListener { finish() }
        binding.btnMic.setOnClickListener {
            val hasMic = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) == PackageManager.PERMISSION_GRANTED
            if (hasMic) startListening()
            else micPermLauncher.launch(Manifest.permission.RECORD_AUDIO)
        }
        binding.btnAsk.setOnClickListener {
            val question = binding.etQuestion.text.toString().trim()
            if (question.isNotEmpty()) viewModel.askAI(question)
            else showToast("Please enter or speak a question")
        }
        binding.btnSave.setOnClickListener {
            viewModel.saveCurrentResponse()
            showToast("Advice saved!")
        }

        // Quick suggestion chips
        binding.chipSugarcane.setOnClickListener { viewModel.askAI("Sugarcane disease treatment") }
        binding.chipWheat.setOnClickListener { viewModel.askAI("Wheat fertilizer advice") }
        binding.chipPest.setOnClickListener { viewModel.askAI("How to control pests organically") }
        binding.chipSoil.setOnClickListener { viewModel.askAI("How to improve soil quality") }
    }

    private fun observeViewModel() {
        viewModel.aiResponse.observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.tvResponse.text = "Getting AI advice..."
                    binding.responseCard.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvResponse.text = resource.data.response
                    binding.tvStatus.text = "Tap mic to speak"
                    binding.btnSave.visibility = View.VISIBLE
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvResponse.text = "Error: ${resource.message}"
                    showToast(resource.message)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        speechRecognizer?.destroy()
    }
}
