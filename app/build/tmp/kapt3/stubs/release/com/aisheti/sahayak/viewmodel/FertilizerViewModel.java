package com.aisheti.sahayak.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0011R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/aisheti/sahayak/viewmodel/FertilizerViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/aisheti/sahayak/data/repository/ShetiRepository;", "prefs", "Lcom/aisheti/sahayak/utils/PreferencesManager;", "(Lcom/aisheti/sahayak/data/repository/ShetiRepository;Lcom/aisheti/sahayak/utils/PreferencesManager;)V", "_fertilizerResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/aisheti/sahayak/utils/Resource;", "Lcom/aisheti/sahayak/data/models/FertilizerResponse;", "fertilizerResult", "Landroidx/lifecycle/LiveData;", "getFertilizerResult", "()Landroidx/lifecycle/LiveData;", "lastResult", "getFertilizerAdvice", "", "cropType", "", "soilType", "growthStage", "saveCurrentAdvice", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FertilizerViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.data.repository.ShetiRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.utils.PreferencesManager prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.FertilizerResponse>> _fertilizerResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.FertilizerResponse>> fertilizerResult = null;
    @org.jetbrains.annotations.Nullable()
    private com.aisheti.sahayak.data.models.FertilizerResponse lastResult;
    
    @javax.inject.Inject()
    public FertilizerViewModel(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.repository.ShetiRepository repository, @org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.utils.PreferencesManager prefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.FertilizerResponse>> getFertilizerResult() {
        return null;
    }
    
    public final void getFertilizerAdvice(@org.jetbrains.annotations.NotNull()
    java.lang.String cropType, @org.jetbrains.annotations.NotNull()
    java.lang.String soilType, @org.jetbrains.annotations.NotNull()
    java.lang.String growthStage) {
    }
    
    public final void saveCurrentAdvice() {
    }
}