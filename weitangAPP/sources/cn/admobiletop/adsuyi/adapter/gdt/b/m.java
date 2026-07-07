package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class m extends c<ADSuyiInterstitialAdListener> implements UnifiedInterstitialADListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public UnifiedInterstitialAD f3643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.a.g f3644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.d.c f3646g;

    public m(String str, ADSuyiInterstitialAdListener aDSuyiInterstitialAdListener, int i2, cn.admobiletop.adsuyi.adapter.gdt.d.c cVar) {
        super(str, aDSuyiInterstitialAdListener);
        this.f3645f = i2;
        this.f3646g = cVar;
    }

    public void a(UnifiedInterstitialAD unifiedInterstitialAD) {
        this.f3643d = unifiedInterstitialAD;
    }

    public final void b() {
        if (this.f3643d.getAdPatternType() == 2) {
            this.f3643d.setMediaListener(new l(this));
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClicked() {
        if (getAdListener() == 0 || this.f3644e == null) {
            return;
        }
        ((ADSuyiInterstitialAdListener) getAdListener()).onAdClick(this.f3644e);
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADClosed() {
        if (getAdListener() == 0 || this.f3644e == null) {
            return;
        }
        ((ADSuyiInterstitialAdListener) getAdListener()).onAdClose(this.f3644e);
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADExposure() {
        if (getAdListener() == 0 || this.f3644e == null) {
            return;
        }
        ((ADSuyiInterstitialAdListener) getAdListener()).onAdExpose(this.f3644e);
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADLeftApplication() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADOpened() {
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onADReceive() {
        if (getAdListener() == 0 || this.f3643d == null) {
            return;
        }
        cn.admobiletop.adsuyi.adapter.gdt.a.g gVar = new cn.admobiletop.adsuyi.adapter.gdt.a.g(getPlatformPosId(), this.f3645f);
        this.f3644e = gVar;
        gVar.setAdapterAdInfo(this.f3643d);
        b();
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onNoAD(AdError adError) {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3646g;
        if (cVar != null) {
            cVar.a(adError, this.f3643d);
        } else {
            onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderFail() {
        onAdFailed(-1, "插屏广告渲染失败");
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onRenderSuccess() {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3646g;
        if (cVar != null) {
            cVar.a(this.f3643d);
        } else {
            a();
        }
    }

    @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
    public void onVideoCached() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        UnifiedInterstitialAD unifiedInterstitialAD = this.f3643d;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.f3643d = null;
        }
        cn.admobiletop.adsuyi.adapter.gdt.a.g gVar = this.f3644e;
        if (gVar != null) {
            gVar.release();
            this.f3644e = null;
        }
    }

    public void a() {
        if (getAdListener() == 0 || this.f3644e == null) {
            return;
        }
        ((ADSuyiInterstitialAdListener) getAdListener()).onAdReceive(this.f3644e);
        ((ADSuyiInterstitialAdListener) getAdListener()).onAdReady(this.f3644e);
    }
}
