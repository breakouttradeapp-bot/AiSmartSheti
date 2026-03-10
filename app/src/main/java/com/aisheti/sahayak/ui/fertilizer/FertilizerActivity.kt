package com.aisheti.sahayak.ui.fertilizer

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.aisheti.sahayak.databinding.ActivityFertilizerBinding
import com.aisheti.sahayak.utils.Resource
import com.aisheti.sahayak.utils.showToast
import com.aisheti.sahayak.viewmodel.FertilizerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FertilizerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFertilizerBinding
    private val viewModel: FertilizerViewModel by viewModels()

    private val crops = arrayOf("Cotton", "Sugarcane", "Soybean", "Wheat", "Corn", "Rice", "Onion", "Tomato", "Chilli", "Groundnut")
    private val soilTypes = arrayOf("Black Soil", "Red Soil", "Sandy Soil", "Loamy Soil", "Clay Soil", "Alluvial Soil")
    private val growthStages = arrayOf("Germination", "Seedling", "Vegetative", "Flowering", "Fruiting", "Harvesting")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFertilizerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpinners()
        setupClickListeners()
        observeViewModel()
    }

    private fun setupSpinners() {
        binding.spinnerCrop.setSimpleItems(crops)
        binding.spinnerSoil.setSimpleItems(soilTypes)
        binding.spinnerStage.setSimpleItems(growthStages)
    }

    private fun setupClickListeners() {
        binding.btnBack.setOnClickListener { finish() }
        binding.btnGetAdvice.setOnClickListener {
            val crop = binding.spinnerCrop.text.toString().ifBlank { crops[0] }
            val soil = binding.spinnerSoil.text.toString().ifBlank { soilTypes[0] }
            val stage = binding.spinnerStage.text.toString().ifBlank { growthStages[0] }
            viewModel.getFertilizerAdvice(crop, soil, stage)
        }
        binding.btnSave.setOnClickListener {
            viewModel.saveCurrentAdvice()
            showToast("Advice saved!")
        }
    }

    private fun observeViewModel() {
        viewModel.fertilizerResult.observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.resultCard.visibility = View.GONE
                }
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.resultCard.visibility = View.VISIBLE
                    val f = resource.data
                    binding.tvCropName.text = "${f.crop} - ${f.stage} Stage"
                    binding.tvRecommendations.text = f.recommendations.joinToString("\n") {
                        "• ${it.name}: ${it.quantity} ${it.unit} per acre"
                    }
                    binding.tvApplicationMethod.text = f.applicationMethod
                    binding.tvTiming.text = f.timing
                    binding.tvWarnings.text = f.warnings
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    showToast(resource.message)
                }
            }
        }
    }
}
