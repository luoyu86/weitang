package com.chinavisionary.core.app.ad.manager;

import com.chinavisionary.core.app.ad.BannerAd;
import com.chinavisionary.core.app.ad.InterstitialAd;
import com.chinavisionary.core.app.ad.SplashAd;
import com.chinavisionary.core.app.ad.base.BaseAd;

/* JADX INFO: loaded from: classes.dex */
public class AdFactory {
    public static BaseAd createAd(String str) {
        BaseAd bannerAd;
        str.hashCode();
        switch (str) {
            case "banner":
                bannerAd = new BannerAd(str);
                break;
            case "splash":
                bannerAd = new SplashAd(str);
                break;
            case "interstitial":
                bannerAd = new InterstitialAd(str);
                break;
            default:
                return null;
        }
        return bannerAd;
    }
}
