package com.aisheti.sahayak.utils;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class UtilsModule_ProvideAdManagerFactory implements Factory<AdManager> {
  @Override
  public AdManager get() {
    return provideAdManager();
  }

  public static UtilsModule_ProvideAdManagerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AdManager provideAdManager() {
    return Preconditions.checkNotNullFromProvides(UtilsModule.INSTANCE.provideAdManager());
  }

  private static final class InstanceHolder {
    private static final UtilsModule_ProvideAdManagerFactory INSTANCE = new UtilsModule_ProvideAdManagerFactory();
  }
}
