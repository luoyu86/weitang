package com.tianmu.biz.widget;

import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tianmu.ad.SplashAd;
import com.tianmu.ad.bean.SplashAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.widget.splashview.SplashView;
import com.tianmu.ad.widget.splashview.base.SplashSkipAdView;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuViewUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j extends SplashSkipAdView implements com.tianmu.c.l.e {
    private FrameLayout D;
    private boolean E;

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public j(@NonNull SplashAd splashAd, @NonNull SplashAdInfo splashAdInfo) {
        super(splashAd, splashAdInfo);
        this.E = false;
        ((SplashAdInfo) this.o).setRenderListener(this);
        FrameLayout frameLayout = new FrameLayout(splashAd.getContext());
        this.D = frameLayout;
        addView(frameLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.m = new HashMap();
        for (String str : splashAdInfo.getAdDataMap().keySet()) {
            this.m.put(str, new SplashView(splashAd, splashAdInfo, splashAdInfo.getAdDataMap().get(str), this));
        }
    }

    @Override // com.tianmu.c.c.g
    public void a(boolean z) {
        try {
            String nextKey = ((SplashAdInfo) this.o).getNextKey();
            Map<String, V> map = this.m;
            if (map != 0 && map.containsKey(nextKey)) {
                SplashView splashView = (SplashView) this.m.get(nextKey);
                splashView.setClosePosition(e());
                splashView.init();
                TianmuViewUtil.addAdViewToAdContainer(this.D, splashView);
                splashView.render();
            } else if (z) {
                a(TianmuErrorConfig.AD_GIVE_POLISH_IMAGE_ERROR, TianmuErrorConfig.MSG_AD_GIVE_POLISH_IMAGE_ERROR);
            } else {
                a(TianmuErrorConfig.AD_FAILED_AD_RENDER_EXCEPTION, TianmuErrorConfig.MSG_AD_FAILED_AD_RENDER_EXCEPTION);
            }
        } catch (Exception unused) {
            a(TianmuErrorConfig.AD_FAILED_AD_RENDER_UNKNOWN_EXCEPTION, TianmuErrorConfig.MSG_AD_FAILED_AD_RENDER_UNKNOWN_EXCEPTION);
        }
    }

    @Override // com.tianmu.c.l.e
    public void b() {
        ((SplashAdInfo) this.o).resetKeyPosition();
        if (this.E) {
            a(TianmuErrorConfig.AD_FAILED_AD_RENDER_UNKNOWN_EXCEPTION, TianmuErrorConfig.MSG_AD_FAILED_AD_RENDER_UNKNOWN_EXCEPTION);
            return;
        }
        this.E = true;
        try {
            TianmuViewUtil.addAdViewToAdContainer(this.D, (SplashView) this.m.get(((SplashAdInfo) this.o).getKeys().get(0)));
        } catch (Exception unused) {
            a(TianmuErrorConfig.AD_FAILED_AD_RENDER_UNKNOWN_EXCEPTION, TianmuErrorConfig.MSG_AD_FAILED_AD_RENDER_UNKNOWN_EXCEPTION);
        }
    }

    @Override // com.tianmu.ad.widget.splashview.base.SplashSkipAdView
    public void g() {
        cancelTask();
        AD ad = this.n;
        if (ad != 0) {
            ((SplashAd) ad).onAdExpose(this.o);
            ((SplashAd) this.n).materialSkip(this.o);
        }
    }

    @Override // com.tianmu.ad.widget.splashview.base.SplashSkipAdView
    public void h() {
        super.h();
        cancelTask();
    }

    @Override // com.tianmu.ad.widget.splashview.base.BaseSplashAdViewContainer, com.tianmu.c.c.g
    public void init() {
        Map<String, V> map = this.m;
        if (map == 0 || !map.containsKey(((SplashAdInfo) this.o).getKey())) {
            return;
        }
        SplashView splashView = (SplashView) this.m.get(((SplashAdInfo) this.o).getKey());
        splashView.setClosePosition(e());
        splashView.init();
        TianmuViewUtil.addAdViewToAdContainer(this.D, splashView);
    }

    @Override // com.tianmu.ad.widget.splashview.base.SplashSkipAdView, com.tianmu.c.c.g, com.tianmu.ad.base.IBaseRelease
    public void release() {
        super.release();
        TianmuViewUtil.removeSelfFromParent(this);
        removeAllViews();
        cancelTask();
    }

    @Override // com.tianmu.ad.widget.splashview.base.SplashSkipAdView, com.tianmu.ad.widget.splashview.base.BaseSplashAdViewContainer, com.tianmu.c.c.g
    public void render() {
        super.render();
        Map<String, V> map = this.m;
        if (map != 0 && map.containsKey(((SplashAdInfo) this.o).getKey())) {
            ((SplashView) this.m.get(((SplashAdInfo) this.o).getKey())).render();
        }
        d();
    }

    public void a(int i2, String str) {
        AD ad = this.n;
        if (ad != 0) {
            ((SplashAd) ad).onAdFailed(new TianmuError(i2, str));
        }
    }

    @Override // com.tianmu.c.l.e
    public void a() {
        a(TianmuErrorConfig.AD_FAILED_AD_RENDER_EXCEPTION, TianmuErrorConfig.MSG_AD_FAILED_AD_RENDER_EXCEPTION);
    }
}
