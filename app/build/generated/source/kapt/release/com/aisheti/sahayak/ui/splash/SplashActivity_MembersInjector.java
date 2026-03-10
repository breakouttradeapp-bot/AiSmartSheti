package com.aisheti.sahayak.ui.splash;

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
public final class SplashActivity_MembersInjector implements MembersInjector<SplashActivity> {
  private final Provider<PreferencesManager> preferencesManagerProvider;

  public SplashActivity_MembersInjector(Provider<PreferencesManager> preferencesManagerProvider) {
    this.preferencesManagerProvider = preferencesManagerProvider;
  }

  public static MembersInjector<SplashActivity> create(
      Provider<PreferencesManager> preferencesManagerProvider) {
    return new SplashActivity_MembersInjector(preferencesManagerProvider);
  }

  @Override
  public void injectMembers(SplashActivity instance) {
    injectPreferencesManager(instance, preferencesManagerProvider.get());
  }

  @InjectedFieldSignature("com.aisheti.sahayak.ui.splash.SplashActivity.preferencesManager")
  public static void injectPreferencesManager(SplashActivity instance,
      PreferencesManager preferencesManager) {
    instance.preferencesManager = preferencesManager;
  }
}
