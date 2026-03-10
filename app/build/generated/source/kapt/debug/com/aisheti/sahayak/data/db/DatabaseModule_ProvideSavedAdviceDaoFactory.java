package com.aisheti.sahayak.data.db;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideSavedAdviceDaoFactory implements Factory<SavedAdviceDao> {
  private final Provider<ShetiDatabase> dbProvider;

  public DatabaseModule_ProvideSavedAdviceDaoFactory(Provider<ShetiDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public SavedAdviceDao get() {
    return provideSavedAdviceDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideSavedAdviceDaoFactory create(
      Provider<ShetiDatabase> dbProvider) {
    return new DatabaseModule_ProvideSavedAdviceDaoFactory(dbProvider);
  }

  public static SavedAdviceDao provideSavedAdviceDao(ShetiDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideSavedAdviceDao(db));
  }
}
