package cn.admobiletop.adsuyi.adapter.gdt.a;

import android.app.Activity;
import cn.admobiletop.adsuyi.ad.data.ADSuyiFullScreenVodAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;

/* JADX INFO: loaded from: classes.dex */
public class d extends b<ADSuyiFullScreenVodAdListener, UnifiedInterstitialAD> implements ADSuyiFullScreenVodAdInfo {
    public boolean k;

    public d(String str) {
        super(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(UnifiedInterstitialAD unifiedInterstitialAD) {
        super.setAdapterAdInfo(unifiedInterstitialAD);
        if (unifiedInterstitialAD == null || !cn.admobiletop.adsuyi.adapter.gdt.c.c.a()) {
            return;
        }
        unifiedInterstitialAD.setDownloadConfirmListener(cn.admobiletop.adsuyi.adapter.gdt.c.c.f3681b);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean isReady() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.a.b, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo(null);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiFullScreenVodAdInfo
    public void showFullScreenVod(Activity activity) {
        if (activity == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        this.k = true;
        getAdapterAdInfo().showFullScreenAD(activity);
    }
}
