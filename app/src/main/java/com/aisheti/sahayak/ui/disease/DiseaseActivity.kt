package com.aisheti.sahayak.ui.disease

import android.Manifest
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import com.aisheti.sahayak.databinding.ActivityDiseaseBinding
import com.aisheti.sahayak.utils.Resource
import com.aisheti.sahayak.utils.showToast
import com.aisheti.sahayak.viewmodel.DiseaseViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@AndroidEntryPoint
class DiseaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDiseaseBinding
    private val viewModel: DiseaseViewModel by viewModels()

    private var imageCapture: ImageCapture? = null
    private lateinit var cameraExecutor: ExecutorService
    private var capturedImageFile: File? = null

    private val cameraPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) startCamera()
        else showToast("Camera permission required")
    }

    private val galleryLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { analyzeFromUri(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiseaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cameraExecutor = Executors.newSingleThreadExecutor()

        setupClickListeners()
        observeViewModel()
        checkCameraPermission()
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            startCamera()
        } else {
            cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build().also {
                it.setSurfaceProvider(binding.cameraPreview.surfaceProvider)
            }
            imageCapture = ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MAXIMIZE_QUALITY)
                .build()

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this, CameraSelector.DEFAULT_BACK_CAMERA, preview, imageCapture)
            } catch (e: Exception) {
                Log.e("CameraX", "Binding failed", e)
            }
        }, ContextCompat.getMainExecutor(this))
    }

    private fun capturePhoto() {
        val imageCapture = imageCapture ?: return
        val photoFile = createTempImageFile()

        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
        imageCapture.takePicture(outputOptions, ContextCompat.getMainExecutor(this),
            object : ImageCapture.OnImageSavedCallback {
                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    capturedImageFile = photoFile
                    binding.cameraPreview.visibility = View.GONE
                    binding.capturedImageView.visibility = View.VISIBLE
                    binding.capturedImageView.setImageURI(Uri.fromFile(photoFile))
                    binding.btnAnalyze.visibility = View.VISIBLE
                    binding.btnRetake.visibility = View.VISIBLE
                    binding.btnCapture.visibility = View.GONE
                }
                override fun onError(exc: ImageCaptureException) {
                    showToast("Photo capture failed")
                }
            })
    }

    private fun analyzeFromUri(uri: Uri) {
        val file = createTempImageFile()
        contentResolver.openInputStream(uri)?.use { input ->
            file.outputStream().use { output -> input.copyTo(output) }
        }
        capturedImageFile = file
        binding.capturedImageView.visibility = View.VISIBLE
        binding.capturedImageView.setImageURI(uri)
        binding.btnAnalyze.visibility = View.VISIBLE
    }

    private fun setupClickListeners() {
        binding.btnBack.setOnClickListener { finish() }
        binding.btnCapture.setOnClickListener { capturePhoto() }
        binding.btnGallery.setOnClickListener { galleryLauncher.launch("image/*") }
        binding.btnRetake.setOnClickListener {
            binding.cameraPreview.visibility = View.VISIBLE
            binding.capturedImageView.visibility = View.GONE
            binding.btnCapture.visibility = View.VISIBLE
            binding.btnRetake.visibility = View.GONE
            binding.btnAnalyze.visibility = View.GONE
            binding.resultCard.visibility = View.GONE
        }
        binding.btnAnalyze.setOnClickListener {
            capturedImageFile?.let { viewModel.analyzeImage(it) }
                ?: showToast("Please capture an image first")
        }
        binding.btnSaveResult.setOnClickListener {
            viewModel.saveCurrentResult()
            showToast("Advice saved!")
        }
    }

    private fun observeViewModel() {
        viewModel.diseaseResult.observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.resultCard.visibility = View.GONE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.resultCard.visibility = View.VISIBLE
                    val d = resource.data
                    binding.tvDiseaseName.text = d.diseaseName
                    binding.tvConfidence.text = "Confidence: ${(d.confidence * 100).toInt()}%"
                    binding.tvProblem.text = d.problem
                    binding.tvSolution.text = d.solution
                    binding.tvSpray.text = d.sprayRecommendation
                    binding.tvPrevention.text = d.preventionTips
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    showToast(resource.message)
                }
            }
        }
    }

    private fun createTempImageFile(): File {
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
        val storageDir = cacheDir
        return File.createTempFile("CROP_${timestamp}_", ".jpg", storageDir)
    }

    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }
}
