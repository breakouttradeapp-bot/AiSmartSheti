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
public final class VoiceViewModel_Factory implements Factory<VoiceViewModel> {
  private final Provider<ShetiRepository> repositoryProvider;

  private final Provider<PreferencesManager> prefsProvider;

  public VoiceViewModel_Factory(Provider<ShetiRepository> repositoryProvider,
      Provider<PreferencesManager> prefsProvider) {
    this.repositoryProvider = repositoryProvider;
    this.prefsProvider = prefsProvider;
  }

  @Override
  public VoiceViewModel get() {
    return newInstance(repositoryProvider.get(), prefsProvider.get());
  }

  public static VoiceViewModel_Factory create(Provider<ShetiRepository> repositoryProvider,
      Provider<PreferencesManager> prefsProvider) {
    return new VoiceViewModel_Factory(repositoryProvider, prefsProvider);
  }

  public static VoiceViewModel newInstance(ShetiRepository repository, PreferencesManager prefs) {
    return new VoiceViewModel(repository, prefs);
  }
}
