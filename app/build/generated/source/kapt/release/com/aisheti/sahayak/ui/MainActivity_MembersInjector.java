package com.aisheti.sahayak.ui;

import com.aisheti.sahayak.utils.AdManager;
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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<PreferencesManager> preferencesManagerProvider;

  private final Provider<AdManager> adManagerProvider;

  public MainActivity_MembersInjector(Provider<PreferencesManager> preferencesManagerProvider,
      Provider<AdManager> adManagerProvider) {
    this.preferencesManagerProvider = preferencesManagerProvider;
    this.adManagerProvider = adManagerProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<PreferencesManager> preferencesManagerProvider,
      Provider<AdManager> adManagerProvider) {
    return new MainActivity_MembersInjector(preferencesManagerProvider, adManagerProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectPreferencesManager(instance, preferencesManagerProvider.get());
    injectAdManager(instance, adManagerProvider.get());
  }

  @InjectedFieldSignature("com.aisheti.sahayak.ui.MainActivity.preferencesManager")
  public static void injectPreferencesManager(MainActivity instance,
      PreferencesManager preferencesManager) {
    instance.preferencesManager = preferencesManager;
  }

  @InjectedFieldSignature("com.aisheti.sahayak.ui.MainActivity.adManager")
  public static void injectAdManager(MainActivity instance, AdManager adManager) {
    instance.adManager = adManager;
  }
}
