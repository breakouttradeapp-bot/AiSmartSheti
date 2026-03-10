package com.aisheti.sahayak.ui.language;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/aisheti/sahayak/ui/language/LanguageActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/aisheti/sahayak/databinding/ActivityLanguageBinding;", "preferencesManager", "Lcom/aisheti/sahayak/utils/PreferencesManager;", "getPreferencesManager", "()Lcom/aisheti/sahayak/utils/PreferencesManager;", "setPreferencesManager", "(Lcom/aisheti/sahayak/utils/PreferencesManager;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupRecyclerView", "app_debug"})
public final class LanguageActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.aisheti.sahayak.databinding.ActivityLanguageBinding binding;
    @javax.inject.Inject()
    public com.aisheti.sahayak.utils.PreferencesManager preferencesManager;
    
    public LanguageActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aisheti.sahayak.utils.PreferencesManager getPreferencesManager() {
        return null;
    }
    
    public final void setPreferencesManager(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.utils.PreferencesManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerView() {
    }
}