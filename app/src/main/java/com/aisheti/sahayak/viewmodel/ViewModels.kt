package com.aisheti.sahayak.viewmodel

import androidx.lifecycle.*
import com.aisheti.sahayak.data.models.*
import com.aisheti.sahayak.data.repository.ShetiRepository
import com.aisheti.sahayak.utils.PreferencesManager
import com.aisheti.sahayak.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

// ─── Disease ViewModel ────────────────────────────────────────────────────────

@HiltViewModel
class DiseaseViewModel @Inject constructor(
    private val repository: ShetiRepository,
    private val prefs: PreferencesManager
) : ViewModel() {

    private val _diseaseResult = MutableLiveData<Resource<DiseaseResponse>>()
    val diseaseResult: LiveData<Resource<DiseaseResponse>> = _diseaseResult

    private var lastResult: DiseaseResponse? = null

    fun analyzeImage(imageFile: File, cropType: String = "unknown") {
        viewModelScope.launch {
            _diseaseResult.value = Resource.Loading()
            val lang = prefs.languageCode.first()
            _diseaseResult.value = repository.detectCropDisease(imageFile, lang, cropType)
            if (_diseaseResult.value is Resource.Success) {
                lastResult = (_diseaseResult.value as Resource.Success).data
            }
        }
    }

    fun saveCurrentResult() {
        lastResult?.let { d ->
            viewModelScope.launch {
                repository.saveAdvice(
                    title = "Disease: ${d.diseaseName}",
                    content = "${d.problem}\n\nSolution: ${d.solution}\n\nSpray: ${d.sprayRecommendation}",
                    category = "disease"
                )
            }
        }
    }
}

// ─── Weather ViewModel ────────────────────────────────────────────────────────

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: ShetiRepository,
    private val prefs: PreferencesManager,
    private val locationHelper: com.aisheti.sahayak.utils.LocationHelper
) : ViewModel() {

    private val _weatherResult = MutableLiveData<Resource<WeatherResponse>>()
    val weatherResult: LiveData<Resource<WeatherResponse>> = _weatherResult

    fun fetchWeather() {
        viewModelScope.launch {
            _weatherResult.value = Resource.Loading()
            val lang = prefs.languageCode.first()
            val location = locationHelper.getLastLocation()
            if (location != null) {
                _weatherResult.value = repository.getWeatherAdvice(location.latitude, location.longitude, lang)
            } else {
                _weatherResult.value = Resource.Error("Unable to get location. Please enable GPS.")
            }
        }
    }
}

// ─── Fertilizer ViewModel ─────────────────────────────────────────────────────

@HiltViewModel
class FertilizerViewModel @Inject constructor(
    private val repository: ShetiRepository,
    private val prefs: PreferencesManager
) : ViewModel() {

    private val _fertilizerResult = MutableLiveData<Resource<FertilizerResponse>>()
    val fertilizerResult: LiveData<Resource<FertilizerResponse>> = _fertilizerResult

    private var lastResult: FertilizerResponse? = null

    fun getFertilizerAdvice(cropType: String, soilType: String, growthStage: String) {
        viewModelScope.launch {
            _fertilizerResult.value = Resource.Loading()
            val lang = prefs.languageCode.first()
            _fertilizerResult.value = repository.getFertilizerAdvice(cropType, soilType, growthStage, lang)
            if (_fertilizerResult.value is Resource.Success) {
                lastResult = (_fertilizerResult.value as Resource.Success).data
            }
        }
    }

    fun saveCurrentAdvice() {
        lastResult?.let { f ->
            viewModelScope.launch {
                repository.saveAdvice(
                    title = "Fertilizer: ${f.crop} ${f.stage}",
                    content = f.recommendations.joinToString("\n") { "• ${it.name}: ${it.quantity}${it.unit}/acre" },
                    category = "fertilizer"
                )
            }
        }
    }
}

// ─── Voice / AI ViewModel ─────────────────────────────────────────────────────

@HiltViewModel
class VoiceViewModel @Inject constructor(
    private val repository: ShetiRepository,
    private val prefs: PreferencesManager
) : ViewModel() {

    private val _aiResponse = MutableLiveData<Resource<AiResponse>>()
    val aiResponse: LiveData<Resource<AiResponse>> = _aiResponse

    private var lastResponse: AiResponse? = null
    private var lastQuestion: String = ""

    fun askAI(question: String) {
        lastQuestion = question
        viewModelScope.launch {
            _aiResponse.value = Resource.Loading()
            val lang = prefs.languageCode.first()
            _aiResponse.value = repository.askAi(question, lang, "general")
            if (_aiResponse.value is Resource.Success) {
                lastResponse = (_aiResponse.value as Resource.Success).data
            }
        }
    }

    fun saveCurrentResponse() {
        lastResponse?.let { r ->
            viewModelScope.launch {
                repository.saveAdvice(
                    title = lastQuestion.take(50),
                    content = r.response,
                    category = "ai"
                )
            }
        }
    }
}

// ─── History ViewModel ────────────────────────────────────────────────────────

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: ShetiRepository
) : ViewModel() {
    val scanHistory = repository.getScanHistory()
    val savedAdvice = repository.getSavedAdvice()

    fun deleteHistory(item: ScanHistory) = viewModelScope.launch { repository.deleteScanHistory(item) }
    fun deleteSaved(item: SavedAdvice) = viewModelScope.launch { repository.deleteSavedAdvice(item) }
}
