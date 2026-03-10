package com.aisheti.sahayak.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.aisheti.sahayak.databinding.ActivityMainBinding
import com.aisheti.sahayak.ui.disease.DiseaseActivity
import com.aisheti.sahayak.ui.fertilizer.FertilizerActivity
import com.aisheti.sahayak.ui.history.HistoryActivity
import com.aisheti.sahayak.ui.voice.VoiceActivity
import com.aisheti.sahayak.ui.weather.WeatherActivity
import com.aisheti.sahayak.utils.AdManager
import com.aisheti.sahayak.utils.PreferencesManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var preferencesManager: PreferencesManager

    @Inject
    lateinit var adManager: AdManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adManager.loadBannerAd(binding.adView)
        adManager.loadInterstitialAd(this)

        setupClickListeners()
        loadGreeting()
    }

    private fun loadGreeting() {
        lifecycleScope.launch {
            val lang = preferencesManager.selectedLanguage.first()
            binding.tvGreeting.text = getGreeting(lang)
        }
    }

    private fun getGreeting(language: String): String {
        return when (language) {
            "Marathi" -> "नमस्कार! आज मी तुम्हाला कशी मदत करू?"
            "Hindi" -> "नमस्ते! आज मैं आपकी कैसे मदद करूं?"
            "Gujarati" -> "નમસ્તે! આજે હું તમને કેવી રીતે મદદ કરી શકું?"
            "Punjabi" -> "ਸਤ ਸ੍ਰੀ ਅਕਾਲ! ਅੱਜ ਮੈਂ ਤੁਹਾਡੀ ਕਿਵੇਂ ਮਦਦ ਕਰਾਂ?"
            "Tamil" -> "வணக்கம்! இன்று நான் உங்களுக்கு எப்படி உதவலாம்?"
            "Telugu" -> "నమస్కారం! ఈరోజు నేను మీకు ఎలా సహాయం చేయగలను?"
            "Kannada" -> "ನಮಸ್ಕಾರ! ಇಂದು ನಾನು ನಿಮಗೆ ಹೇಗೆ ಸಹಾಯ ಮಾಡಬಹುದು?"
            else -> "Hello! How can I help you today?"
        }
    }

    private fun setupClickListeners() {
        binding.cardCropDisease.setOnClickListener {
            startActivity(Intent(this, DiseaseActivity::class.java))
        }
        binding.cardWeather.setOnClickListener {
            startActivity(Intent(this, WeatherActivity::class.java))
        }
        binding.cardFertilizer.setOnClickListener {
            startActivity(Intent(this, FertilizerActivity::class.java))
        }
        binding.cardVoiceAI.setOnClickListener {
            startActivity(Intent(this, VoiceActivity::class.java))
        }
        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        // Quick action chips
        binding.chipDiseaseHelp.setOnClickListener {
            VoiceActivity.startWithPrompt(this, "Crop disease help")
        }
        binding.chipFertilizer.setOnClickListener {
            VoiceActivity.startWithPrompt(this, "Fertilizer advice")
        }
        binding.chipPestControl.setOnClickListener {
            VoiceActivity.startWithPrompt(this, "Pest control")
        }
        binding.chipSoil.setOnClickListener {
            VoiceActivity.startWithPrompt(this, "Soil improvement")
        }
    }
}
