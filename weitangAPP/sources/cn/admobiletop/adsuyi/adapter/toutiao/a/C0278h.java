package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import cn.admobiletop.adsuyi.adapter.toutiao.R;
import cn.admobiletop.adsuyi.util.ADSuyiDisplayUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0278h extends C0273c<ADSuyiSplashAdListener, CSJSplashAd> implements ADSuyiSplashAdInfo, CSJSplashAd.SplashAdListener {
    public boolean k;
    public Handler l;

    public C0278h(String str) {
        super(str);
        this.l = new Handler(Looper.getMainLooper());
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(CSJSplashAd cSJSplashAd) {
        super.setAdapterAdInfo(cSJSplashAd);
        a();
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

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void onCloseClick(View view) {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new RunnableC0274d(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClick(CSJSplashAd cSJSplashAd) {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new RunnableC0276f(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdClose(CSJSplashAd cSJSplashAd, int i2) {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new RunnableC0277g(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
    public void onSplashAdShow(CSJSplashAd cSJSplashAd) {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new RunnableC0275e(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo(null);
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.l = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiSplashAdInfo
    public void showSplash(ADSuyiSplashAdContainer aDSuyiSplashAdContainer) {
        if (aDSuyiSplashAdContainer == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        if (aDSuyiSplashAdContainer.isSetSkipView()) {
            getAdapterAdInfo().hideSkipButton();
        }
        aDSuyiSplashAdContainer.addView(getAdapterAdInfo().getSplashView());
        if (aDSuyiSplashAdContainer.isSetSkipView()) {
            aDSuyiSplashAdContainer.addSkipView();
            aDSuyiSplashAdContainer.startCountDown();
        } else {
            aDSuyiSplashAdContainer.removeCustomSkipView();
        }
        ADSuyiViewUtil.addLogoToAdView(aDSuyiSplashAdContainer, 0, R.drawable.adsuyi_toutiao_platform_icon2, ADSuyiDisplayUtil.dp2px(10), ADSuyiDisplayUtil.dp2px(16), ADSuyiDisplayUtil.dp2px(16), 0.5f);
        this.k = true;
    }

    public final void a() {
        if (getAdapterAdInfo() != null) {
            if (4 == getAdapterAdInfo().getInteractionType()) {
                getAdapterAdInfo().setDownloadListener(new cn.admobiletop.adsuyi.adapter.toutiao.b.B());
            }
            getAdapterAdInfo().setSplashAdListener(this);
        }
    }
}
