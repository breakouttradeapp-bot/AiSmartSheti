package com.aisheti.sahayak;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.aisheti.sahayak.data.api.NetworkModule_ProvideApiServiceFactory;
import com.aisheti.sahayak.data.api.NetworkModule_ProvideOkHttpClientFactory;
import com.aisheti.sahayak.data.api.NetworkModule_ProvideRetrofitFactory;
import com.aisheti.sahayak.data.api.ShetiApiService;
import com.aisheti.sahayak.data.db.DatabaseModule_ProvideSavedAdviceDaoFactory;
import com.aisheti.sahayak.data.db.DatabaseModule_ProvideScanHistoryDaoFactory;
import com.aisheti.sahayak.data.db.DatabaseModule_ProvideShetiDatabaseFactory;
import com.aisheti.sahayak.data.db.SavedAdviceDao;
import com.aisheti.sahayak.data.db.ScanHistoryDao;
import com.aisheti.sahayak.data.db.ShetiDatabase;
import com.aisheti.sahayak.data.repository.ShetiRepository;
import com.aisheti.sahayak.ui.MainActivity;
import com.aisheti.sahayak.ui.MainActivity_MembersInjector;
import com.aisheti.sahayak.ui.disease.DiseaseActivity;
import com.aisheti.sahayak.ui.fertilizer.FertilizerActivity;
import com.aisheti.sahayak.ui.history.HistoryActivity;
import com.aisheti.sahayak.ui.language.LanguageActivity;
import com.aisheti.sahayak.ui.language.LanguageActivity_MembersInjector;
import com.aisheti.sahayak.ui.splash.SplashActivity;
import com.aisheti.sahayak.ui.splash.SplashActivity_MembersInjector;
import com.aisheti.sahayak.ui.voice.VoiceActivity;
import com.aisheti.sahayak.ui.weather.WeatherActivity;
import com.aisheti.sahayak.utils.AdManager;
import com.aisheti.sahayak.utils.LocationHelper;
import com.aisheti.sahayak.utils.PreferencesManager;
import com.aisheti.sahayak.utils.UtilsModule_ProvideAdManagerFactory;
import com.aisheti.sahayak.utils.UtilsModule_ProvideLocationHelperFactory;
import com.aisheti.sahayak.utils.UtilsModule_ProvidePreferencesManagerFactory;
import com.aisheti.sahayak.viewmodel.DiseaseViewModel;
import com.aisheti.sahayak.viewmodel.DiseaseViewModel_HiltModules;
import com.aisheti.sahayak.viewmodel.FertilizerViewModel;
import com.aisheti.sahayak.viewmodel.FertilizerViewModel_HiltModules;
import com.aisheti.sahayak.viewmodel.HistoryViewModel;
import com.aisheti.sahayak.viewmodel.HistoryViewModel_HiltModules;
import com.aisheti.sahayak.viewmodel.VoiceViewModel;
import com.aisheti.sahayak.viewmodel.VoiceViewModel_HiltModules;
import com.aisheti.sahayak.viewmodel.WeatherViewModel;
import com.aisheti.sahayak.viewmodel.WeatherViewModel_HiltModules;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class DaggerShetiApplication_HiltComponents_SingletonC {
  private DaggerShetiApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public ShetiApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements ShetiApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public ShetiApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements ShetiApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public ShetiApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements ShetiApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public ShetiApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements ShetiApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public ShetiApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements ShetiApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public ShetiApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements ShetiApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public ShetiApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements ShetiApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public ShetiApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends ShetiApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends ShetiApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends ShetiApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends ShetiApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
      injectMainActivity2(mainActivity);
    }

    @Override
    public void injectDiseaseActivity(DiseaseActivity diseaseActivity) {
    }

    @Override
    public void injectFertilizerActivity(FertilizerActivity fertilizerActivity) {
    }

    @Override
    public void injectHistoryActivity(HistoryActivity historyActivity) {
    }

    @Override
    public void injectLanguageActivity(LanguageActivity languageActivity) {
      injectLanguageActivity2(languageActivity);
    }

    @Override
    public void injectSplashActivity(SplashActivity splashActivity) {
      injectSplashActivity2(splashActivity);
    }

    @Override
    public void injectVoiceActivity(VoiceActivity voiceActivity) {
    }

    @Override
    public void injectWeatherActivity(WeatherActivity weatherActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(ImmutableMap.<String, Boolean>of(LazyClassKeyProvider.com_aisheti_sahayak_viewmodel_DiseaseViewModel, DiseaseViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_aisheti_sahayak_viewmodel_FertilizerViewModel, FertilizerViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_aisheti_sahayak_viewmodel_HistoryViewModel, HistoryViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_aisheti_sahayak_viewmodel_VoiceViewModel, VoiceViewModel_HiltModules.KeyModule.provide(), LazyClassKeyProvider.com_aisheti_sahayak_viewmodel_WeatherViewModel, WeatherViewModel_HiltModules.KeyModule.provide()));
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @CanIgnoreReturnValue
    private MainActivity injectMainActivity2(MainActivity instance) {
      MainActivity_MembersInjector.injectPreferencesManager(instance, singletonCImpl.providePreferencesManagerProvider.get());
      MainActivity_MembersInjector.injectAdManager(instance, singletonCImpl.provideAdManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private LanguageActivity injectLanguageActivity2(LanguageActivity instance) {
      LanguageActivity_MembersInjector.injectPreferencesManager(instance, singletonCImpl.providePreferencesManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private SplashActivity injectSplashActivity2(SplashActivity instance) {
      SplashActivity_MembersInjector.injectPreferencesManager(instance, singletonCImpl.providePreferencesManagerProvider.get());
      return instance;
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_aisheti_sahayak_viewmodel_VoiceViewModel = "com.aisheti.sahayak.viewmodel.VoiceViewModel";

      static String com_aisheti_sahayak_viewmodel_FertilizerViewModel = "com.aisheti.sahayak.viewmodel.FertilizerViewModel";

      static String com_aisheti_sahayak_viewmodel_HistoryViewModel = "com.aisheti.sahayak.viewmodel.HistoryViewModel";

      static String com_aisheti_sahayak_viewmodel_WeatherViewModel = "com.aisheti.sahayak.viewmodel.WeatherViewModel";

      static String com_aisheti_sahayak_viewmodel_DiseaseViewModel = "com.aisheti.sahayak.viewmodel.DiseaseViewModel";

      @KeepFieldType
      VoiceViewModel com_aisheti_sahayak_viewmodel_VoiceViewModel2;

      @KeepFieldType
      FertilizerViewModel com_aisheti_sahayak_viewmodel_FertilizerViewModel2;

      @KeepFieldType
      HistoryViewModel com_aisheti_sahayak_viewmodel_HistoryViewModel2;

      @KeepFieldType
      WeatherViewModel com_aisheti_sahayak_viewmodel_WeatherViewModel2;

      @KeepFieldType
      DiseaseViewModel com_aisheti_sahayak_viewmodel_DiseaseViewModel2;
    }
  }

  private static final class ViewModelCImpl extends ShetiApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<DiseaseViewModel> diseaseViewModelProvider;

    private Provider<FertilizerViewModel> fertilizerViewModelProvider;

    private Provider<HistoryViewModel> historyViewModelProvider;

    private Provider<VoiceViewModel> voiceViewModelProvider;

    private Provider<WeatherViewModel> weatherViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.diseaseViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.fertilizerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.historyViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.voiceViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.weatherViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(ImmutableMap.<String, javax.inject.Provider<ViewModel>>of(LazyClassKeyProvider.com_aisheti_sahayak_viewmodel_DiseaseViewModel, ((Provider) diseaseViewModelProvider), LazyClassKeyProvider.com_aisheti_sahayak_viewmodel_FertilizerViewModel, ((Provider) fertilizerViewModelProvider), LazyClassKeyProvider.com_aisheti_sahayak_viewmodel_HistoryViewModel, ((Provider) historyViewModelProvider), LazyClassKeyProvider.com_aisheti_sahayak_viewmodel_VoiceViewModel, ((Provider) voiceViewModelProvider), LazyClassKeyProvider.com_aisheti_sahayak_viewmodel_WeatherViewModel, ((Provider) weatherViewModelProvider)));
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<Class<?>, Object>of();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_aisheti_sahayak_viewmodel_VoiceViewModel = "com.aisheti.sahayak.viewmodel.VoiceViewModel";

      static String com_aisheti_sahayak_viewmodel_HistoryViewModel = "com.aisheti.sahayak.viewmodel.HistoryViewModel";

      static String com_aisheti_sahayak_viewmodel_DiseaseViewModel = "com.aisheti.sahayak.viewmodel.DiseaseViewModel";

      static String com_aisheti_sahayak_viewmodel_FertilizerViewModel = "com.aisheti.sahayak.viewmodel.FertilizerViewModel";

      static String com_aisheti_sahayak_viewmodel_WeatherViewModel = "com.aisheti.sahayak.viewmodel.WeatherViewModel";

      @KeepFieldType
      VoiceViewModel com_aisheti_sahayak_viewmodel_VoiceViewModel2;

      @KeepFieldType
      HistoryViewModel com_aisheti_sahayak_viewmodel_HistoryViewModel2;

      @KeepFieldType
      DiseaseViewModel com_aisheti_sahayak_viewmodel_DiseaseViewModel2;

      @KeepFieldType
      FertilizerViewModel com_aisheti_sahayak_viewmodel_FertilizerViewModel2;

      @KeepFieldType
      WeatherViewModel com_aisheti_sahayak_viewmodel_WeatherViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.aisheti.sahayak.viewmodel.DiseaseViewModel 
          return (T) new DiseaseViewModel(singletonCImpl.shetiRepositoryProvider.get(), singletonCImpl.providePreferencesManagerProvider.get());

          case 1: // com.aisheti.sahayak.viewmodel.FertilizerViewModel 
          return (T) new FertilizerViewModel(singletonCImpl.shetiRepositoryProvider.get(), singletonCImpl.providePreferencesManagerProvider.get());

          case 2: // com.aisheti.sahayak.viewmodel.HistoryViewModel 
          return (T) new HistoryViewModel(singletonCImpl.shetiRepositoryProvider.get());

          case 3: // com.aisheti.sahayak.viewmodel.VoiceViewModel 
          return (T) new VoiceViewModel(singletonCImpl.shetiRepositoryProvider.get(), singletonCImpl.providePreferencesManagerProvider.get());

          case 4: // com.aisheti.sahayak.viewmodel.WeatherViewModel 
          return (T) new WeatherViewModel(singletonCImpl.shetiRepositoryProvider.get(), singletonCImpl.providePreferencesManagerProvider.get(), singletonCImpl.provideLocationHelperProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends ShetiApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends ShetiApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends ShetiApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<PreferencesManager> providePreferencesManagerProvider;

    private Provider<AdManager> provideAdManagerProvider;

    private Provider<OkHttpClient> provideOkHttpClientProvider;

    private Provider<Retrofit> provideRetrofitProvider;

    private Provider<ShetiApiService> provideApiServiceProvider;

    private Provider<ShetiDatabase> provideShetiDatabaseProvider;

    private Provider<ShetiRepository> shetiRepositoryProvider;

    private Provider<LocationHelper> provideLocationHelperProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private ScanHistoryDao scanHistoryDao() {
      return DatabaseModule_ProvideScanHistoryDaoFactory.provideScanHistoryDao(provideShetiDatabaseProvider.get());
    }

    private SavedAdviceDao savedAdviceDao() {
      return DatabaseModule_ProvideSavedAdviceDaoFactory.provideSavedAdviceDao(provideShetiDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.providePreferencesManagerProvider = DoubleCheck.provider(new SwitchingProvider<PreferencesManager>(singletonCImpl, 0));
      this.provideAdManagerProvider = DoubleCheck.provider(new SwitchingProvider<AdManager>(singletonCImpl, 1));
      this.provideOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 5));
      this.provideRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 4));
      this.provideApiServiceProvider = DoubleCheck.provider(new SwitchingProvider<ShetiApiService>(singletonCImpl, 3));
      this.provideShetiDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<ShetiDatabase>(singletonCImpl, 6));
      this.shetiRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ShetiRepository>(singletonCImpl, 2));
      this.provideLocationHelperProvider = DoubleCheck.provider(new SwitchingProvider<LocationHelper>(singletonCImpl, 7));
    }

    @Override
    public void injectShetiApplication(ShetiApplication shetiApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.aisheti.sahayak.utils.PreferencesManager 
          return (T) UtilsModule_ProvidePreferencesManagerFactory.providePreferencesManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.aisheti.sahayak.utils.AdManager 
          return (T) UtilsModule_ProvideAdManagerFactory.provideAdManager();

          case 2: // com.aisheti.sahayak.data.repository.ShetiRepository 
          return (T) new ShetiRepository(singletonCImpl.provideApiServiceProvider.get(), singletonCImpl.scanHistoryDao(), singletonCImpl.savedAdviceDao());

          case 3: // com.aisheti.sahayak.data.api.ShetiApiService 
          return (T) NetworkModule_ProvideApiServiceFactory.provideApiService(singletonCImpl.provideRetrofitProvider.get());

          case 4: // retrofit2.Retrofit 
          return (T) NetworkModule_ProvideRetrofitFactory.provideRetrofit(singletonCImpl.provideOkHttpClientProvider.get());

          case 5: // okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient();

          case 6: // com.aisheti.sahayak.data.db.ShetiDatabase 
          return (T) DatabaseModule_ProvideShetiDatabaseFactory.provideShetiDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 7: // com.aisheti.sahayak.utils.LocationHelper 
          return (T) UtilsModule_ProvideLocationHelperFactory.provideLocationHelper(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
