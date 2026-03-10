package com.aisheti.sahayak.ui.fertilizer;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/aisheti/sahayak/ui/fertilizer/FertilizerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/aisheti/sahayak/databinding/ActivityFertilizerBinding;", "crops", "", "", "[Ljava/lang/String;", "growthStages", "soilTypes", "viewModel", "Lcom/aisheti/sahayak/viewmodel/FertilizerViewModel;", "getViewModel", "()Lcom/aisheti/sahayak/viewmodel/FertilizerViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupClickListeners", "setupSpinners", "app_debug"})
public final class FertilizerActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.aisheti.sahayak.databinding.ActivityFertilizerBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] crops = {"Cotton", "Sugarcane", "Soybean", "Wheat", "Corn", "Rice", "Onion", "Tomato", "Chilli", "Groundnut"};
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] soilTypes = {"Black Soil", "Red Soil", "Sandy Soil", "Loamy Soil", "Clay Soil", "Alluvial Soil"};
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] growthStages = {"Germination", "Seedling", "Vegetative", "Flowering", "Fruiting", "Harvesting"};
    
    public FertilizerActivity() {
        super();
    }
    
    private final com.aisheti.sahayak.viewmodel.FertilizerViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupSpinners() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void observeViewModel() {
    }
}