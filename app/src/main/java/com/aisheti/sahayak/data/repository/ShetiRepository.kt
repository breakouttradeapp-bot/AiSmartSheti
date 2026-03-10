package com.aisheti.sahayak.data.repository

import com.aisheti.sahayak.data.api.ShetiApiService
import com.aisheti.sahayak.data.db.SavedAdviceDao
import com.aisheti.sahayak.data.db.ScanHistoryDao
import com.aisheti.sahayak.data.models.*
import com.aisheti.sahayak.utils.Resource
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShetiRepository @Inject constructor(
    private val api: ShetiApiService,
    private val scanHistoryDao: ScanHistoryDao,
    private val savedAdviceDao: SavedAdviceDao
) {

    // ─── AI Ask ───────────────────────────────────────────────────────────────

    suspend fun askAi(message: String, language: String, type: String = "general"): Resource<AiResponse> {
        return try {
            val response = api.askAi(AiRequest(message, language, type))
            if (response.isSuccessful && response.body() != null) {
                val body = response.body()!!
                // Save to history
                scanHistoryDao.insert(
                    ScanHistory(type = "ai", query = message, response = body.response, language = language)
                )
                Resource.Success(body)
            } else {
                Resource.Error("Server error: ${response.code()}")
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "Network error. Check your connection.")
        }
    }

    // ─── Crop Disease ─────────────────────────────────────────────────────────

    suspend fun detectCropDisease(imageFile: File, language: String, cropType: String = "unknown"): Resource<DiseaseResponse> {
        return try {
            val requestFile = imageFile.asRequestBody("image/jpeg".toMediaTypeOrNull())
            val imagePart = MultipartBody.Part.createFormData("image", imageFile.name, requestFile)
            val langBody = language.toRequestBody("text/plain".toMediaTypeOrNull())
            val cropBody = cropType.toRequestBody("text/plain".toMediaTypeOrNull())

            val response = api.detectCropDisease(imagePart, langBody, cropBody)
            if (response.isSuccessful && response.body() != null) {
                val body = response.body()!!
                scanHistoryDao.insert(
                    ScanHistory(
                        type = "disease",
                        query = "Crop disease scan - $cropType",
                        response = "${body.diseaseName}: ${body.solution}",
                        imagePath = imageFile.absolutePath,
                        language = language
                    )
                )
                Resource.Success(body)
            } else {
                Resource.Error("Analysis failed: ${response.code()}")
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "Image upload failed.")
        }
    }

    // ─── Weather ──────────────────────────────────────────────────────────────

    suspend fun getWeatherAdvice(lat: Double, lon: Double, language: String): Resource<WeatherResponse> {
        return try {
            val response = api.getWeather(lat, lon, language)
            if (response.isSuccessful && response.body() != null) {
                val body = response.body()!!
                scanHistoryDao.insert(
                    ScanHistory(type = "weather", query = "Weather at $lat,$lon", response = body.aiFarmingAdvice, language = language)
                )
                Resource.Success(body)
            } else {
                Resource.Error("Weather fetch failed: ${response.code()}")
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "Cannot fetch weather.")
        }
    }

    // ─── Fertilizer ───────────────────────────────────────────────────────────

    suspend fun getFertilizerAdvice(cropType: String, soilType: String, growthStage: String, language: String): Resource<FertilizerResponse> {
        return try {
            val response = api.getFertilizerAdvice(FertilizerRequest(cropType, soilType, growthStage, language))
            if (response.isSuccessful && response.body() != null) {
                val body = response.body()!!
                scanHistoryDao.insert(
                    ScanHistory(type = "fertilizer", query = "$cropType - $growthStage stage", response = body.recommendations.joinToString { "${it.name}: ${it.quantity}${it.unit}" }, language = language)
                )
                Resource.Success(body)
            } else {
                Resource.Error("Fertilizer advice failed: ${response.code()}")
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "Cannot fetch fertilizer advice.")
        }
    }

    // ─── Local DB ─────────────────────────────────────────────────────────────

    fun getScanHistory() = scanHistoryDao.getAllHistory()
    fun getSavedAdvice() = savedAdviceDao.getAllSaved()

    suspend fun saveAdvice(title: String, content: String, category: String) {
        savedAdviceDao.insert(SavedAdvice(title = title, content = content, category = category))
    }

    suspend fun deleteScanHistory(history: ScanHistory) = scanHistoryDao.delete(history)
    suspend fun deleteSavedAdvice(advice: SavedAdvice) = savedAdviceDao.delete(advice)
}
