package com.aisheti.sahayak.ui;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/aisheti/sahayak/ui/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adManager", "Lcom/aisheti/sahayak/utils/AdManager;", "getAdManager", "()Lcom/aisheti/sahayak/utils/AdManager;", "setAdManager", "(Lcom/aisheti/sahayak/utils/AdManager;)V", "binding", "Lcom/aisheti/sahayak/databinding/ActivityMainBinding;", "preferencesManager", "Lcom/aisheti/sahayak/utils/PreferencesManager;", "getPreferencesManager", "()Lcom/aisheti/sahayak/utils/PreferencesManager;", "setPreferencesManager", "(Lcom/aisheti/sahayak/utils/PreferencesManager;)V", "getGreeting", "", "language", "loadGreeting", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupClickListeners", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.aisheti.sahayak.databinding.ActivityMainBinding binding;
    @javax.inject.Inject()
    public com.aisheti.sahayak.utils.PreferencesManager preferencesManager;
    @javax.inject.Inject()
    public com.aisheti.sahayak.utils.AdManager adManager;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aisheti.sahayak.utils.PreferencesManager getPreferencesManager() {
        return null;
    }
    
    public final void setPreferencesManager(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.utils.PreferencesManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.aisheti.sahayak.utils.AdManager getAdManager() {
        return null;
    }
    
    public final void setAdManager(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.utils.AdManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadGreeting() {
    }
    
    private final java.lang.String getGreeting(java.lang.String language) {
        return null;
    }
    
    private final void setupClickListeners() {
    }
}