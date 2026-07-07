package cn.admobiletop.adsuyi.adapter.gdt.b;

import android.R;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class v extends c<ADSuyiSplashAdListener> implements SplashADZoomOutListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Activity f3674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ADSuyiSplashAdContainer f3675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewGroup f3676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3677g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.a.l f3678h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f3679i;
    public long j;
    public SplashAD k;
    public ADSuyiSplashAd l;
    public cn.admobiletop.adsuyi.adapter.gdt.d.c m;

    public v(ADSuyiSplashAd aDSuyiSplashAd, Activity activity, ADSuyiSplashAdContainer aDSuyiSplashAdContainer, String str, ADSuyiSplashAdListener aDSuyiSplashAdListener, cn.admobiletop.adsuyi.adapter.gdt.d.c cVar) {
        super(str, aDSuyiSplashAdListener);
        this.f3679i = new Handler(Looper.getMainLooper());
        this.l = aDSuyiSplashAd;
        this.f3674d = activity;
        this.f3675e = aDSuyiSplashAdContainer;
        this.m = cVar;
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public boolean isSupportZoomOut() {
        return true;
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADClicked() {
        if (getAdListener() == 0 || this.f3678h == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdClick(this.f3678h);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADDismissed() {
        ADSuyiSplashAdContainer aDSuyiSplashAdContainer;
        ViewGroup viewGroup;
        if (this.f3677g && (viewGroup = this.f3676f) != null) {
            cn.admobiletop.adsuyi.adapter.gdt.e.f.a(viewGroup);
        }
        if (getAdListener() == 0 || this.f3678h == null) {
            return;
        }
        if (this.j > 0 && (aDSuyiSplashAdContainer = this.f3675e) != null && !aDSuyiSplashAdContainer.isTimeover()) {
            ((ADSuyiSplashAdListener) getAdListener()).onAdSkip(this.f3678h);
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdClose(this.f3678h);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADExposure() {
        if (getAdListener() == 0 || this.f3678h == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdExpose(this.f3678h);
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADLoaded(long j) {
        if (getAdListener() == 0 || this.f3675e == null) {
            return;
        }
        cn.admobiletop.adsuyi.adapter.gdt.a.l lVar = new cn.admobiletop.adsuyi.adapter.gdt.a.l(getPlatformPosId());
        this.f3678h = lVar;
        lVar.setAdapterAdInfo(this.k);
        this.f3675e.setSplashAdListener((ADSuyiSplashAdListener) getAdListener());
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.m;
        if (cVar != null) {
            cVar.a(this.k);
        } else {
            a();
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADPresent() {
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onADTick(long j) {
        this.j = j;
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void onAdFailed(int i2, String str) {
        Handler handler = this.f3679i;
        if (handler != null) {
            handler.post(new t(this, i2, str));
        }
    }

    @Override // com.qq.e.ads.splash.SplashADListener
    public void onNoAD(AdError adError) {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.m;
        if (cVar != null) {
            cVar.a(adError, this.k);
        } else {
            onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public void onZoomOut() {
        this.f3677g = true;
        cn.admobiletop.adsuyi.adapter.gdt.c.i iVarB = cn.admobiletop.adsuyi.adapter.gdt.c.i.b();
        View childAt = this.f3675e.getChildAt(0);
        if (childAt == null) {
            ADSuyiLogUtil.d("在开屏展示的过程中进行了新的拉取，导致广告View被清空了");
            return;
        }
        childAt.setVisibility(0);
        ViewGroup viewGroup = (ViewGroup) this.f3674d.findViewById(R.id.content);
        this.f3676f = iVarB.a(childAt, viewGroup, viewGroup, new u(this));
    }

    @Override // com.qq.e.ads.splash.SplashADZoomOutListener
    public void onZoomOutPlayFinish() {
        ADSuyiLogUtil.d("onPlayFinish");
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f3675e = null;
        Handler handler = this.f3679i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3679i = null;
        }
        cn.admobiletop.adsuyi.adapter.gdt.a.l lVar = this.f3678h;
        if (lVar != null) {
            lVar.release();
            this.f3678h = null;
        }
        b();
    }

    public void a(SplashAD splashAD) {
        this.k = splashAD;
    }

    public final void b() {
        ViewGroup viewGroup = this.f3676f;
        if (viewGroup != null) {
            cn.admobiletop.adsuyi.adapter.gdt.e.f.a(viewGroup);
            this.f3676f = null;
        }
    }

    public void a() {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.m;
        if (cVar != null) {
            cVar.release();
            this.m = null;
        }
        ADSuyiSplashAd aDSuyiSplashAd = this.l;
        if (aDSuyiSplashAd != null) {
            aDSuyiSplashAd.setAllowCustomSkipView(false);
        }
        if (this.f3678h != null) {
            if (this.k != null && cn.admobiletop.adsuyi.adapter.gdt.c.c.a()) {
                this.k.setDownloadConfirmListener(cn.admobiletop.adsuyi.adapter.gdt.c.c.f3680a);
            }
            ((ADSuyiSplashAdListener) getAdListener()).onAdReceive(this.f3678h);
            return;
        }
        onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
    }
}
