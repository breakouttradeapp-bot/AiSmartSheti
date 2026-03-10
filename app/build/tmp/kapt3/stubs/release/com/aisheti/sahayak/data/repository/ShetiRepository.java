package com.aisheti.sahayak.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ.\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u0019J.\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u001fJ4\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\n2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010$J\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\'0&J\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\'0&J,\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\n2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u000e\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010.J&\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\r2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/aisheti/sahayak/data/repository/ShetiRepository;", "", "api", "Lcom/aisheti/sahayak/data/api/ShetiApiService;", "scanHistoryDao", "Lcom/aisheti/sahayak/data/db/ScanHistoryDao;", "savedAdviceDao", "Lcom/aisheti/sahayak/data/db/SavedAdviceDao;", "(Lcom/aisheti/sahayak/data/api/ShetiApiService;Lcom/aisheti/sahayak/data/db/ScanHistoryDao;Lcom/aisheti/sahayak/data/db/SavedAdviceDao;)V", "askAi", "Lcom/aisheti/sahayak/utils/Resource;", "Lcom/aisheti/sahayak/data/models/AiResponse;", "message", "", "language", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSavedAdvice", "", "advice", "Lcom/aisheti/sahayak/data/models/SavedAdvice;", "(Lcom/aisheti/sahayak/data/models/SavedAdvice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteScanHistory", "history", "Lcom/aisheti/sahayak/data/models/ScanHistory;", "(Lcom/aisheti/sahayak/data/models/ScanHistory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectCropDisease", "Lcom/aisheti/sahayak/data/models/DiseaseResponse;", "imageFile", "Ljava/io/File;", "cropType", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFertilizerAdvice", "Lcom/aisheti/sahayak/data/models/FertilizerResponse;", "soilType", "growthStage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSavedAdvice", "Landroidx/lifecycle/LiveData;", "", "getScanHistory", "getWeatherAdvice", "Lcom/aisheti/sahayak/data/models/WeatherResponse;", "lat", "", "lon", "(DDLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveAdvice", "title", "content", "category", "app_release"})
public final class ShetiRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.data.api.ShetiApiService api = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.data.db.ScanHistoryDao scanHistoryDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.data.db.SavedAdviceDao savedAdviceDao = null;
    
    @javax.inject.Inject()
    public ShetiRepository(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.api.ShetiApiService api, @org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.db.ScanHistoryDao scanHistoryDao, @org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.db.SavedAdviceDao savedAdviceDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object askAi(@org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.lang.String type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.AiResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object detectCropDisease(@org.jetbrains.annotations.NotNull()
    java.io.File imageFile, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.lang.String cropType, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.DiseaseResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getWeatherAdvice(double lat, double lon, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.WeatherResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFertilizerAdvice(@org.jetbrains.annotations.NotNull()
    java.lang.String cropType, @org.jetbrains.annotations.NotNull()
    java.lang.String soilType, @org.jetbrains.annotations.NotNull()
    java.lang.String growthStage, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.FertilizerResponse>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.aisheti.sahayak.data.models.ScanHistory>> getScanHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.aisheti.sahayak.data.models.SavedAdvice>> getSavedAdvice() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveAdvice(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteScanHistory(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.models.ScanHistory history, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteSavedAdvice(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.models.SavedAdvice advice, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}