package com.aisheti.sahayak.data.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007J2\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u0013J2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u00172\b\b\u0003\u0010\f\u001a\u00020\u0019H\u00a7@\u00a2\u0006\u0002\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/aisheti/sahayak/data/api/ShetiApiService;", "", "askAi", "Lretrofit2/Response;", "Lcom/aisheti/sahayak/data/models/AiResponse;", "request", "Lcom/aisheti/sahayak/data/models/AiRequest;", "(Lcom/aisheti/sahayak/data/models/AiRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCropDisease", "Lcom/aisheti/sahayak/data/models/DiseaseResponse;", "image", "Lokhttp3/MultipartBody$Part;", "language", "Lokhttp3/RequestBody;", "cropType", "(Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFertilizerAdvice", "Lcom/aisheti/sahayak/data/models/FertilizerResponse;", "Lcom/aisheti/sahayak/data/models/FertilizerRequest;", "(Lcom/aisheti/sahayak/data/models/FertilizerRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWeather", "Lcom/aisheti/sahayak/data/models/WeatherResponse;", "lat", "", "lon", "", "(DDLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ShetiApiService {
    
    @retrofit2.http.POST(value = "ask-ai")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object askAi(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.models.AiRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.aisheti.sahayak.data.models.AiResponse>> $completion);
    
    @retrofit2.http.Multipart()
    @retrofit2.http.POST(value = "crop-disease")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object detectCropDisease(@retrofit2.http.Part()
    @org.jetbrains.annotations.NotNull()
    okhttp3.MultipartBody.Part image, @retrofit2.http.Part(value = "language")
    @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody language, @retrofit2.http.Part(value = "crop_type")
    @org.jetbrains.annotations.NotNull()
    okhttp3.RequestBody cropType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.aisheti.sahayak.data.models.DiseaseResponse>> $completion);
    
    @retrofit2.http.GET(value = "weather")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getWeather(@retrofit2.http.Query(value = "lat")
    double lat, @retrofit2.http.Query(value = "lon")
    double lon, @retrofit2.http.Query(value = "language")
    @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.aisheti.sahayak.data.models.WeatherResponse>> $completion);
    
    @retrofit2.http.POST(value = "fertilizer")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getFertilizerAdvice(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.models.FertilizerRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.aisheti.sahayak.data.models.FertilizerResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}