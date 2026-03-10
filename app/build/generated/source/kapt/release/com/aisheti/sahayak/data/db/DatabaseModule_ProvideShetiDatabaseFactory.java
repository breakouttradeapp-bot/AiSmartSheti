package com.aisheti.sahayak.data.db;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvideShetiDatabaseFactory implements Factory<ShetiDatabase> {
  private final Provider<Context> contextProvider;

  public DatabaseModule_ProvideShetiDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ShetiDatabase get() {
    return provideShetiDatabase(contextProvider.get());
  }

  public static DatabaseModule_ProvideShetiDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new DatabaseModule_ProvideShetiDatabaseFactory(contextProvider);
  }

  public static ShetiDatabase provideShetiDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideShetiDatabase(context));
  }
}
