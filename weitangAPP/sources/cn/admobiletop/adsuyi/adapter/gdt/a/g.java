package cn.admobiletop.adsuyi.adapter.gdt.a;

import android.app.Activity;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;

/* JADX INFO: loaded from: classes.dex */
public class g extends b<ADSuyiInterstitialAdListener, UnifiedInterstitialAD> implements ADSuyiInterstitialAdInfo {
    public boolean k;
    public int l;

    public g(String str, int i2) {
        super(str);
        this.l = i2;
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
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().destroy();
        }
        setAdapterAdInfo(null);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo
    public void showInterstitial(Activity activity) {
        if (activity == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        this.k = true;
        if (1 == this.l) {
            getAdapterAdInfo().show(activity);
        } else {
            getAdapterAdInfo().showFullScreenAD(activity);
        }
    }
}
