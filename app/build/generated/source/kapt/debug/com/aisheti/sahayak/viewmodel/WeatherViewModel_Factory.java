package com.aisheti.sahayak.viewmodel;

import com.aisheti.sahayak.data.repository.ShetiRepository;
import com.aisheti.sahayak.utils.LocationHelper;
import com.aisheti.sahayak.utils.PreferencesManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class WeatherViewModel_Factory implements Factory<WeatherViewModel> {
  private final Provider<ShetiRepository> repositoryProvider;

  private final Provider<PreferencesManager> prefsProvider;

  private final Provider<LocationHelper> locationHelperProvider;

  public WeatherViewModel_Factory(Provider<ShetiRepository> repositoryProvider,
      Provider<PreferencesManager> prefsProvider, Provider<LocationHelper> locationHelperProvider) {
    this.repositoryProvider = repositoryProvider;
    this.prefsProvider = prefsProvider;
    this.locationHelperProvider = locationHelperProvider;
  }

  @Override
  public WeatherViewModel get() {
    return newInstance(repositoryProvider.get(), prefsProvider.get(), locationHelperProvider.get());
  }

  public static WeatherViewModel_Factory create(Provider<ShetiRepository> repositoryProvider,
      Provider<PreferencesManager> prefsProvider, Provider<LocationHelper> locationHelperProvider) {
    return new WeatherViewModel_Factory(repositoryProvider, prefsProvider, locationHelperProvider);
  }

  public static WeatherViewModel newInstance(ShetiRepository repository, PreferencesManager prefs,
      LocationHelper locationHelper) {
    return new WeatherViewModel(repository, prefs, locationHelper);
  }
}
