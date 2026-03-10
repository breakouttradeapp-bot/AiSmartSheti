package com.aisheti.sahayak.data.api

import com.aisheti.sahayak.data.models.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ShetiApiService {

    @POST("ask-ai")
    suspend fun askAi(@Body request: AiRequest): Response<AiResponse>

    @Multipart
    @POST("crop-disease")
    suspend fun detectCropDisease(
        @Part image: MultipartBody.Part,
        @Part("language") language: RequestBody,
        @Part("crop_type") cropType: RequestBody
    ): Response<DiseaseResponse>

    @GET("weather")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("language") language: String = "en"
    ): Response<WeatherResponse>

    @POST("fertilizer")
    suspend fun getFertilizerAdvice(@Body request: FertilizerRequest): Response<FertilizerResponse>
}
