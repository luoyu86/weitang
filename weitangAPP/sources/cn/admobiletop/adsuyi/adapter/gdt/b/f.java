package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class f extends c<ADSuyiFullScreenVodAdListener> implements UnifiedInterstitialADListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UnifiedInterstitialAD f3634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.a.d f3635e;

    public f(String str, ADSuyiFullScreenVodAdListener aDSuyiFullScreenVodAdListener) {
        super(str, aDSuyiFullScreenVodAdListener);
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClicked() {
        if (getAdListener() == 0 || this.f3635e == null) {
            return;
        }
        ((ADSuyiFullScreenVodAdListener) getAdListener()).onAdClick(this.f3635e);
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClosed() {
        if (getAdListener() == 0 || this.f3635e == null) {
            return;
        }
        ((ADSuyiFullScreenVodAdListener) getAdListener()).onAdClose(this.f3635e);
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADExposure() {
        if (getAdListener() == 0 || this.f3635e == null) {
            return;
        }
        ((ADSuyiFullScreenVodAdListener) getAdListener()).onAdExpose(this.f3635e);
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADLeftApplication() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADOpened() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADReceive() {
        if (getAdListener() != 0) {
            if (this.f3634d == null) {
                onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
                return;
            }
            cn.admobiletop.adsuyi.adapter.gdt.a.d dVar = new cn.admobiletop.adsuyi.adapter.gdt.a.d(getPlatformPosId());
            this.f3635e = dVar;
            dVar.setAdapterAdInfo(this.f3634d);
            a();
            ((ADSuyiFullScreenVodAdListener) getAdListener()).onAdReceive(this.f3635e);
            ((ADSuyiFullScreenVodAdListener) getAdListener()).onVideoCache(this.f3635e);
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onNoAD(AdError adError) {
        onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderFail() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderSuccess() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onVideoCached() {
        if (getAdListener() == 0 || this.f3635e == null) {
            return;
        }
        ((ADSuyiFullScreenVodAdListener) getAdListener()).onVideoCache(this.f3635e);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f3634d = null;
        cn.admobiletop.adsuyi.adapter.gdt.a.d dVar = this.f3635e;
        if (dVar != null) {
            dVar.release();
            this.f3635e = null;
        }
    }

    public void a(UnifiedInterstitialAD unifiedInterstitialAD) {
        this.f3634d = unifiedInterstitialAD;
    }

    public final void a() {
        this.f3634d.setMediaListener(new e(this));
    }
}
