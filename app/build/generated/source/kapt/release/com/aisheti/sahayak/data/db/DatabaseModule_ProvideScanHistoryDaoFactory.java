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
public final class DatabaseModule_ProvideScanHistoryDaoFactory implements Factory<ScanHistoryDao> {
  private final Provider<ShetiDatabase> dbProvider;

  public DatabaseModule_ProvideScanHistoryDaoFactory(Provider<ShetiDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ScanHistoryDao get() {
    return provideScanHistoryDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideScanHistoryDaoFactory create(
      Provider<ShetiDatabase> dbProvider) {
    return new DatabaseModule_ProvideScanHistoryDaoFactory(dbProvider);
  }

  public static ScanHistoryDao provideScanHistoryDao(ShetiDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideScanHistoryDao(db));
  }
}
