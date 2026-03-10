package com.aisheti.sahayak.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0013R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/aisheti/sahayak/viewmodel/VoiceViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/aisheti/sahayak/data/repository/ShetiRepository;", "prefs", "Lcom/aisheti/sahayak/utils/PreferencesManager;", "(Lcom/aisheti/sahayak/data/repository/ShetiRepository;Lcom/aisheti/sahayak/utils/PreferencesManager;)V", "_aiResponse", "Landroidx/lifecycle/MutableLiveData;", "Lcom/aisheti/sahayak/utils/Resource;", "Lcom/aisheti/sahayak/data/models/AiResponse;", "aiResponse", "Landroidx/lifecycle/LiveData;", "getAiResponse", "()Landroidx/lifecycle/LiveData;", "lastQuestion", "", "lastResponse", "askAI", "", "question", "saveCurrentResponse", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class VoiceViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.data.repository.ShetiRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.utils.PreferencesManager prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.AiResponse>> _aiResponse = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.AiResponse>> aiResponse = null;
    @org.jetbrains.annotations.Nullable()
    private com.aisheti.sahayak.data.models.AiResponse lastResponse;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String lastQuestion = "";
    
    @javax.inject.Inject()
    public VoiceViewModel(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.repository.ShetiRepository repository, @org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.utils.PreferencesManager prefs) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.AiResponse>> getAiResponse() {
        return null;
    }
    
    public final void askAI(@org.jetbrains.annotations.NotNull()
    java.lang.String question) {
    }
    
    public final void saveCurrentResponse() {
    }
}