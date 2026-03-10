package com.aisheti.sahayak.ui.language;

import com.aisheti.sahayak.utils.PreferencesManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class LanguageActivity_MembersInjector implements MembersInjector<LanguageActivity> {
  private final Provider<PreferencesManager> preferencesManagerProvider;

  public LanguageActivity_MembersInjector(Provider<PreferencesManager> preferencesManagerProvider) {
    this.preferencesManagerProvider = preferencesManagerProvider;
  }

  public static MembersInjector<LanguageActivity> create(
      Provider<PreferencesManager> preferencesManagerProvider) {
    return new LanguageActivity_MembersInjector(preferencesManagerProvider);
  }

  @Override
  public void injectMembers(LanguageActivity instance) {
    injectPreferencesManager(instance, preferencesManagerProvider.get());
  }

  @InjectedFieldSignature("com.aisheti.sahayak.ui.language.LanguageActivity.preferencesManager")
  public static void injectPreferencesManager(LanguageActivity instance,
      PreferencesManager preferencesManager) {
    instance.preferencesManager = preferencesManager;
  }
}
