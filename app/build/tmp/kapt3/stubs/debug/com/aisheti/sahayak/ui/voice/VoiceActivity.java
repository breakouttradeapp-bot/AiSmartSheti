package com.aisheti.sahayak.ui.voice;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/aisheti/sahayak/ui/voice/VoiceActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/aisheti/sahayak/databinding/ActivityVoiceBinding;", "isListening", "", "micPermLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "speechRecognizer", "Landroid/speech/SpeechRecognizer;", "viewModel", "Lcom/aisheti/sahayak/viewmodel/VoiceViewModel;", "getViewModel", "()Lcom/aisheti/sahayak/viewmodel/VoiceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupClickListeners", "setupSpeechRecognizer", "startListening", "Companion", "app_debug"})
public final class VoiceActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.aisheti.sahayak.databinding.ActivityVoiceBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private android.speech.SpeechRecognizer speechRecognizer;
    private boolean isListening = false;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> micPermLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String EXTRA_PROMPT = "extra_prompt";
    @org.jetbrains.annotations.NotNull()
    public static final com.aisheti.sahayak.ui.voice.VoiceActivity.Companion Companion = null;
    
    public VoiceActivity() {
        super();
    }
    
    private final com.aisheti.sahayak.viewmodel.VoiceViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupSpeechRecognizer() {
    }
    
    private final void startListening() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void observeViewModel() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/aisheti/sahayak/ui/voice/VoiceActivity$Companion;", "", "()V", "EXTRA_PROMPT", "", "startWithPrompt", "", "context", "Landroid/content/Context;", "prompt", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void startWithPrompt(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        java.lang.String prompt) {
        }
    }
}