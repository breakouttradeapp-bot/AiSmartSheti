package com.aisheti.sahayak.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/aisheti/sahayak/viewmodel/HistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/aisheti/sahayak/data/repository/ShetiRepository;", "(Lcom/aisheti/sahayak/data/repository/ShetiRepository;)V", "savedAdvice", "Landroidx/lifecycle/LiveData;", "", "Lcom/aisheti/sahayak/data/models/SavedAdvice;", "getSavedAdvice", "()Landroidx/lifecycle/LiveData;", "scanHistory", "Lcom/aisheti/sahayak/data/models/ScanHistory;", "getScanHistory", "deleteHistory", "Lkotlinx/coroutines/Job;", "item", "deleteSaved", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.data.repository.ShetiRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.aisheti.sahayak.data.models.ScanHistory>> scanHistory = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.aisheti.sahayak.data.models.SavedAdvice>> savedAdvice = null;
    
    @javax.inject.Inject()
    public HistoryViewModel(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.repository.ShetiRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.aisheti.sahayak.data.models.ScanHistory>> getScanHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.aisheti.sahayak.data.models.SavedAdvice>> getSavedAdvice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteHistory(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.models.ScanHistory item) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteSaved(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.models.SavedAdvice item) {
        return null;
    }
}