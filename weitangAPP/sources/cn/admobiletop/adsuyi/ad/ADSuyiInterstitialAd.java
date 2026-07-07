package cn.admobiletop.adsuyi.ad;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import cn.admobiletop.adsuyi.a.b.u;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd;

/* JADX INFO: loaded from: classes.dex */
public final class ADSuyiInterstitialAd extends u<ADSuyiInterstitialAdListener> implements ADSuyiSceneAd {
    public String m;
    public ADSuyiExtraParams n;

    public ADSuyiInterstitialAd(@NonNull Activity activity) {
        super(activity);
        setTimeout(10000L);
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public String getAdType() {
        return "interstitial";
    }

    public ADSuyiExtraParams getLocalExtraParams() {
        return this.n;
    }

    @Override // cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd
    public String getSceneId() {
        return this.m;
    }

    public boolean isMute() {
        ADSuyiExtraParams aDSuyiExtraParams = this.n;
        return aDSuyiExtraParams == null || aDSuyiExtraParams.isAdPlayWithMute();
    }

    @Override // cn.admobiletop.adsuyi.a.b.u
    public void loadAd(String str, int i2) {
        super.loadAd(str, 1);
    }

    public void setLocalExtraParams(ADSuyiExtraParams aDSuyiExtraParams) {
        this.n = aDSuyiExtraParams;
    }

    @Override // cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd
    public void setSceneId(String str) {
        this.m = str;
    }

    public ADSuyiInterstitialAd(@NonNull Fragment fragment) {
        super(fragment);
        setTimeout(10000L);
    }
}
