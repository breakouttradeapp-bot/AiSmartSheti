package com.aisheti.sahayak.viewmodel;

import com.aisheti.sahayak.data.repository.ShetiRepository;
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
public final class DiseaseViewModel_Factory implements Factory<DiseaseViewModel> {
  private final Provider<ShetiRepository> repositoryProvider;

  private final Provider<PreferencesManager> prefsProvider;

  public DiseaseViewModel_Factory(Provider<ShetiRepository> repositoryProvider,
      Provider<PreferencesManager> prefsProvider) {
    this.repositoryProvider = repositoryProvider;
    this.prefsProvider = prefsProvider;
  }

  @Override
  public DiseaseViewModel get() {
    return newInstance(repositoryProvider.get(), prefsProvider.get());
  }

  public static DiseaseViewModel_Factory create(Provider<ShetiRepository> repositoryProvider,
      Provider<PreferencesManager> prefsProvider) {
    return new DiseaseViewModel_Factory(repositoryProvider, prefsProvider);
  }

  public static DiseaseViewModel newInstance(ShetiRepository repository, PreferencesManager prefs) {
    return new DiseaseViewModel(repository, prefs);
  }
}
