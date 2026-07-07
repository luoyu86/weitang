package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p extends c<ADSuyiSplashAdListener> implements NativeExpressAD.NativeExpressADListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiSplashAdContainer f3653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NativeExpressADView f3654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.a.j f3655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ADSuyiSplashAd f3656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.d.c f3657h;

    public p(ADSuyiSplashAd aDSuyiSplashAd, ADSuyiSplashAdContainer aDSuyiSplashAdContainer, String str, ADSuyiSplashAdListener aDSuyiSplashAdListener, cn.admobiletop.adsuyi.adapter.gdt.d.c cVar) {
        super(str, aDSuyiSplashAdListener);
        this.f3656g = aDSuyiSplashAd;
        this.f3653d = aDSuyiSplashAdContainer;
        this.f3657h = cVar;
    }

    public void a() {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3657h;
        if (cVar != null) {
            cVar.release();
            this.f3657h = null;
        }
        ADSuyiSplashAd aDSuyiSplashAd = this.f3656g;
        if (aDSuyiSplashAd != null) {
            aDSuyiSplashAd.setAutoSkip(true);
            this.f3656g.setAllowCustomSkipView(true);
        }
        if (this.f3655f == null) {
            onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
        } else {
            this.f3653d.setAlpha(0.0f);
            ((ADSuyiSplashAdListener) getAdListener()).onAdReceive(this.f3655f);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClicked(NativeExpressADView nativeExpressADView) {
        if (getAdListener() == 0 || this.f3655f == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdClick(this.f3655f);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClosed(NativeExpressADView nativeExpressADView) {
        if (getAdListener() == 0 || this.f3655f == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdClose(this.f3655f);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADExposure(NativeExpressADView nativeExpressADView) {
        if (getAdListener() == 0 || this.f3655f == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdExpose(this.f3655f);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLoaded(List<NativeExpressADView> list) {
        if (list == null || list.size() <= 0 || this.f3653d == null) {
            if (this.f3657h == null) {
                onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
                return;
            } else {
                this.f3657h.a(new AdError(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"), null);
                return;
            }
        }
        this.f3654e = list.get(0);
        cn.admobiletop.adsuyi.adapter.gdt.a.j jVar = new cn.admobiletop.adsuyi.adapter.gdt.a.j(getPlatformPosId());
        this.f3655f = jVar;
        jVar.setAdapterAdInfo(this.f3654e);
        this.f3653d.setSplashAdListener((ADSuyiSplashAdListener) getAdListener());
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3657h;
        if (cVar != null) {
            cVar.a(this.f3654e);
        } else {
            a();
        }
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3657h;
        if (cVar != null) {
            cVar.a(adError, null);
            return;
        }
        if (this.f3655f == null) {
            onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
        } else if (getAdListener() != 0) {
            ADSuyiLogUtil.d(adError.getErrorMsg());
            ((ADSuyiSplashAdListener) getAdListener()).onAdClose(this.f3655f);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderFail(NativeExpressADView nativeExpressADView) {
        if (this.f3655f == null) {
            onAdFailed(-1, "render fail");
        } else if (getAdListener() != 0) {
            ADSuyiLogUtil.d("render fail");
            ((ADSuyiSplashAdListener) getAdListener()).onAdClose(this.f3655f);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
        ADSuyiSplashAdContainer aDSuyiSplashAdContainer = this.f3653d;
        if (aDSuyiSplashAdContainer != null) {
            aDSuyiSplashAdContainer.setAlpha(1.0f);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f3653d = null;
        NativeExpressADView nativeExpressADView = this.f3654e;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
            this.f3654e = null;
        }
        cn.admobiletop.adsuyi.adapter.gdt.a.j jVar = this.f3655f;
        if (jVar != null) {
            jVar.release();
            this.f3655f = null;
        }
    }
}
