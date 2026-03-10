package com.aisheti.sahayak.data.models

import com.google.gson.annotations.SerializedName
import androidx.room.Entity
import androidx.room.PrimaryKey

// ─── AI Request / Response ────────────────────────────────────────────────────

data class AiRequest(
@SerializedName("message") val message: String,
@SerializedName("language") val language: String = "en",
@SerializedName("type") val type: String = "general"   // general | disease | fertilizer | weather
)

data class AiResponse(
@SerializedName("success") val success: Boolean,
@SerializedName("response") val response: String,
@SerializedName("language") val language: String
)

// ─── Crop Disease ─────────────────────────────────────────────────────────────

data class DiseaseResponse(
@SerializedName("success") val success: Boolean,
@SerializedName("disease_name") val diseaseName: String,
@SerializedName("confidence") val confidence: Double,
@SerializedName("problem") val problem: String,
@SerializedName("solution") val solution: String,
@SerializedName("spray_recommendation") val sprayRecommendation: String,
@SerializedName("prevention_tips") val preventionTips: String,
@SerializedName("language") val language: String
)

// ─── Weather ──────────────────────────────────────────────────────────────────

data class WeatherResponse(
@SerializedName("success") val success: Boolean,
@SerializedName("location") val location: String,
@SerializedName("temperature") val temperature: Double,
@SerializedName("feels_like") val feelsLike: Double,
@SerializedName("humidity") val humidity: Int,
@SerializedName("wind_speed") val windSpeed: Double,
@SerializedName("description") val description: String,
@SerializedName("rain_forecast") val rainForecast: String,
@SerializedName("ai_farming_advice") val aiFarmingAdvice: String,
@SerializedName("icon") val icon: String
)

// ─── Fertilizer ───────────────────────────────────────────────────────────────

data class FertilizerRequest(
@SerializedName("crop_type") val cropType: String,
@SerializedName("soil_type") val soilType: String,
@SerializedName("growth_stage") val growthStage: String,
@SerializedName("language") val language: String = "en"
)

data class FertilizerResponse(
@SerializedName("success") val success: Boolean,
@SerializedName("crop") val crop: String,
@SerializedName("stage") val stage: String,
@SerializedName("recommendations") val recommendations: List<FertilizerItem>,
@SerializedName("application_method") val applicationMethod: String,
@SerializedName("timing") val timing: String,
@SerializedName("warnings") val warnings: String
)

data class FertilizerItem(
@SerializedName("name") val name: String,
@SerializedName("quantity") val quantity: String,
@SerializedName("unit") val unit: String
)

// ─── Room Database Entities ───────────────────────────────────────────────────

@Entity(tableName = "scan_history")
data class ScanHistory(
@PrimaryKey(autoGenerate = true) val id: Long = 0,
val type: String,           // disease | fertilizer | weather | ai
val query: String,
val response: String,
val imagePath: String? = null,
val timestamp: Long = System.currentTimeMillis(),
val language: String = "en"
)

@Entity(tableName = "saved_advice")
data class SavedAdvice(
@PrimaryKey(autoGenerate = true) val id: Long = 0,
val title: String,
val content: String,
val category: String,
val timestamp: Long = System.currentTimeMillis()
)

