package com.aisheti.sahayak.ui.weather

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.aisheti.sahayak.databinding.ActivityWeatherBinding
import com.aisheti.sahayak.utils.Resource
import com.aisheti.sahayak.utils.showToast
import com.aisheti.sahayak.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWeatherBinding
    private val viewModel: WeatherViewModel by viewModels()

    private val locationPermLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { perms ->
        if (perms[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
            perms[Manifest.permission.ACCESS_COARSE_LOCATION] == true) {
            viewModel.fetchWeather()
        } else {
            showToast("Location permission required for weather")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener { finish() }
        binding.btnRefresh.setOnClickListener { checkLocationAndFetch() }
        observeViewModel()
        checkLocationAndFetch()
    }

    private fun checkLocationAndFetch() {
        val fine = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
        val coarse = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        if (fine == PackageManager.PERMISSION_GRANTED || coarse == PackageManager.PERMISSION_GRANTED) {
            viewModel.fetchWeather()
        } else {
            locationPermLauncher.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION))
        }
    }

    private fun observeViewModel() {
        viewModel.weatherResult.observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                is Resource.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.weatherCard.visibility = View.VISIBLE
                    val w = resource.data
                    binding.tvLocation.text = w.location
                    binding.tvTemperature.text = "${w.temperature}°C"
                    binding.tvHumidity.text = "Humidity: ${w.humidity}%"
                    binding.tvWind.text = "Wind: ${w.windSpeed} km/h"
                    binding.tvDescription.text = w.description
                    binding.tvRainForecast.text = w.rainForecast
                    binding.tvFarmingAdvice.text = w.aiFarmingAdvice
                }
                is Resource.Error -> {
                    binding.progressBar.visibility = View.GONE
                    showToast(resource.message)
                }
            }
        }
    }
}
