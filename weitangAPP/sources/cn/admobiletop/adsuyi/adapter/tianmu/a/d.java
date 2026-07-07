package cn.admobiletop.adsuyi.adapter.tianmu.a;

import android.app.Activity;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import com.tianmu.ad.bean.InterstitialAdInfo;

/* JADX INFO: loaded from: classes.dex */
public class d extends a<ADSuyiInterstitialAdListener, InterstitialAdInfo> implements ADSuyiInterstitialAdInfo {
    public boolean k;

    public d(String str) {
        super(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return getAdapterAdInfo().isOvertime();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean isReady() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.adapter.tianmu.a.a, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo(null);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo
    public void showInterstitial(@NonNull Activity activity) {
        if (activity == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        this.k = true;
        getAdapterAdInfo().showInterstitial(activity);
    }
}
