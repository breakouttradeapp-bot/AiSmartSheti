package com.aisheti.sahayak.data.repository;

import com.aisheti.sahayak.data.api.ShetiApiService;
import com.aisheti.sahayak.data.db.SavedAdviceDao;
import com.aisheti.sahayak.data.db.ScanHistoryDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class ShetiRepository_Factory implements Factory<ShetiRepository> {
  private final Provider<ShetiApiService> apiProvider;

  private final Provider<ScanHistoryDao> scanHistoryDaoProvider;

  private final Provider<SavedAdviceDao> savedAdviceDaoProvider;

  public ShetiRepository_Factory(Provider<ShetiApiService> apiProvider,
      Provider<ScanHistoryDao> scanHistoryDaoProvider,
      Provider<SavedAdviceDao> savedAdviceDaoProvider) {
    this.apiProvider = apiProvider;
    this.scanHistoryDaoProvider = scanHistoryDaoProvider;
    this.savedAdviceDaoProvider = savedAdviceDaoProvider;
  }

  @Override
  public ShetiRepository get() {
    return newInstance(apiProvider.get(), scanHistoryDaoProvider.get(), savedAdviceDaoProvider.get());
  }

  public static ShetiRepository_Factory create(Provider<ShetiApiService> apiProvider,
      Provider<ScanHistoryDao> scanHistoryDaoProvider,
      Provider<SavedAdviceDao> savedAdviceDaoProvider) {
    return new ShetiRepository_Factory(apiProvider, scanHistoryDaoProvider, savedAdviceDaoProvider);
  }

  public static ShetiRepository newInstance(ShetiApiService api, ScanHistoryDao scanHistoryDao,
      SavedAdviceDao savedAdviceDao) {
    return new ShetiRepository(api, scanHistoryDao, savedAdviceDao);
  }
}
