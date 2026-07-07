package cn.admobiletop.adsuyi.ad;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import cn.admobiletop.adsuyi.a.b.u;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd;

/* JADX INFO: loaded from: classes.dex */
public final class ADSuyiRewardVodAd extends u<ADSuyiRewardVodAdListener> implements ADSuyiSceneAd {
    public ADSuyiExtraParams m;
    public String n;

    public ADSuyiRewardVodAd(@NonNull Activity activity) {
        super(activity);
        setTimeout(60000L);
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public String getAdType() {
        return "rewardvod";
    }

    public ADSuyiExtraParams getLocalExtraParams() {
        return this.m;
    }

    @Override // cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd
    public String getSceneId() {
        return this.n;
    }

    public boolean isMute() {
        ADSuyiExtraParams aDSuyiExtraParams = this.m;
        return aDSuyiExtraParams == null || aDSuyiExtraParams.isAdPlayWithMute();
    }

    @Override // cn.admobiletop.adsuyi.a.b.u
    public void loadAd(String str, int i2) {
        super.loadAd(str, 1);
    }

    public void setLocalExtraParams(ADSuyiExtraParams aDSuyiExtraParams) {
        this.m = aDSuyiExtraParams;
    }

    @Override // cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd
    public void setSceneId(String str) {
        this.n = str;
    }

    public ADSuyiRewardVodAd(@NonNull Fragment fragment) {
        super(fragment);
        setTimeout(60000L);
    }
}
