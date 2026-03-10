package com.aisheti.sahayak.utils;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/aisheti/sahayak/utils/AdManager;", "", "()V", "interstitialAd", "Lcom/google/android/gms/ads/interstitial/InterstitialAd;", "loadBannerAd", "", "adView", "Lcom/google/android/gms/ads/AdView;", "loadInterstitialAd", "activity", "Landroid/app/Activity;", "showInterstitialIfReady", "app_debug"})
public final class AdManager {
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.ads.interstitial.InterstitialAd interstitialAd;
    
    @javax.inject.Inject()
    public AdManager() {
        super();
    }
    
    public final void loadBannerAd(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.ads.AdView adView) {
    }
    
    public final void loadInterstitialAd(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
    
    public final void showInterstitialIfReady(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
    }
}