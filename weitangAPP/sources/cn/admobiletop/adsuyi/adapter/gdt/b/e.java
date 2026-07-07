package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class e implements UnifiedInterstitialMediaListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f3633a;

    public e(f fVar) {
        this.f3633a = fVar;
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoComplete() {
        if (this.f3633a.getAdListener() == 0 || this.f3633a.f3635e == null) {
            return;
        }
        ((ADSuyiFullScreenVodAdListener) this.f3633a.getAdListener()).onVideoComplete(this.f3633a.f3635e);
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoError(AdError adError) {
        if (this.f3633a.getAdListener() == 0 || this.f3633a.f3635e == null) {
            return;
        }
        ((ADSuyiFullScreenVodAdListener) this.f3633a.getAdListener()).onVideoError(this.f3633a.f3635e, new ADSuyiError(adError.getErrorCode(), adError.getErrorMsg()));
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageClose() {
        if (this.f3633a.getAdListener() == 0 || this.f3633a.f3635e == null) {
            return;
        }
        ((ADSuyiFullScreenVodAdListener) this.f3633a.getAdListener()).onAdClose(this.f3633a.f3635e);
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPageOpen() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoPause() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoReady(long j) {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
    public void onVideoStart() {
    }
}
