package com.aisheti.sahayak.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/aisheti/sahayak/viewmodel/WeatherViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/aisheti/sahayak/data/repository/ShetiRepository;", "prefs", "Lcom/aisheti/sahayak/utils/PreferencesManager;", "locationHelper", "Lcom/aisheti/sahayak/utils/LocationHelper;", "(Lcom/aisheti/sahayak/data/repository/ShetiRepository;Lcom/aisheti/sahayak/utils/PreferencesManager;Lcom/aisheti/sahayak/utils/LocationHelper;)V", "_weatherResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/aisheti/sahayak/utils/Resource;", "Lcom/aisheti/sahayak/data/models/WeatherResponse;", "weatherResult", "Landroidx/lifecycle/LiveData;", "getWeatherResult", "()Landroidx/lifecycle/LiveData;", "fetchWeather", "", "app_release"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class WeatherViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.data.repository.ShetiRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.utils.PreferencesManager prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final com.aisheti.sahayak.utils.LocationHelper locationHelper = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.WeatherResponse>> _weatherResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.WeatherResponse>> weatherResult = null;
    
    @javax.inject.Inject()
    public WeatherViewModel(@org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.data.repository.ShetiRepository repository, @org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.utils.PreferencesManager prefs, @org.jetbrains.annotations.NotNull()
    com.aisheti.sahayak.utils.LocationHelper locationHelper) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.aisheti.sahayak.utils.Resource<com.aisheti.sahayak.data.models.WeatherResponse>> getWeatherResult() {
        return null;
    }
    
    public final void fetchWeather() {
    }
}