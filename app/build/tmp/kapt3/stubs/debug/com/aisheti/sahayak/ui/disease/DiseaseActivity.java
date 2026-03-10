package com.aisheti.sahayak.ui.disease;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0016H\u0014J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006#"}, d2 = {"Lcom/aisheti/sahayak/ui/disease/DiseaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/aisheti/sahayak/databinding/ActivityDiseaseBinding;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "cameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "capturedImageFile", "Ljava/io/File;", "galleryLauncher", "imageCapture", "Landroidx/camera/core/ImageCapture;", "viewModel", "Lcom/aisheti/sahayak/viewmodel/DiseaseViewModel;", "getViewModel", "()Lcom/aisheti/sahayak/viewmodel/DiseaseViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "analyzeFromUri", "", "uri", "Landroid/net/Uri;", "capturePhoto", "checkCameraPermission", "createTempImageFile", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setupClickListeners", "startCamera", "app_debug"})
public final class DiseaseActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.aisheti.sahayak.databinding.ActivityDiseaseBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.core.ImageCapture imageCapture;
    private java.util.concurrent.ExecutorService cameraExecutor;
    @org.jetbrains.annotations.Nullable()
    private java.io.File capturedImageFile;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> cameraPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> galleryLauncher = null;
    
    public DiseaseActivity() {
        super();
    }
    
    private final com.aisheti.sahayak.viewmodel.DiseaseViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkCameraPermission() {
    }
    
    private final void startCamera() {
    }
    
    private final void capturePhoto() {
    }
    
    private final void analyzeFromUri(android.net.Uri uri) {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void observeViewModel() {
    }
    
    private final java.io.File createTempImageFile() {
        return null;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
}