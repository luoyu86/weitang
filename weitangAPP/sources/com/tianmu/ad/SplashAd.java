package com.tianmu.ad;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import androidx.annotation.NonNull;
import com.tianmu.ad.base.BaseAd;
import com.tianmu.ad.bean.SplashAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.SplashAdListener;
import com.tianmu.c.b.a;
import com.tianmu.c.c.e;
import com.tianmu.c.i.l;
import com.tianmu.c.k.f.c;
import com.tianmu.c.m.f;
import com.tianmu.config.TianmuErrorConfig;

/* JADX INFO: loaded from: classes2.dex */
public class SplashAd extends BaseAd<SplashAdListener> {
    private View m;
    private long n;
    private boolean o;
    private f p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private SplashAdInfo f10551q;

    public SplashAd(@NonNull Context context) {
        super(context);
        this.n = 5000L;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public String getAdType() {
        return "splash";
    }

    public long getCountDownTime() {
        return this.n;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public int getRenderType() {
        return 0;
    }

    public View getSkipView() {
        return this.m;
    }

    public boolean isImmersive() {
        return this.o;
    }

    public void loadAd(String str) {
        super.loadAd(str, 1);
    }

    public void onAdSkip(SplashAdInfo splashAdInfo) {
        f fVar = this.p;
        if (fVar != null) {
            fVar.onAdSkip(splashAdInfo);
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void release() {
        super.release();
        Handler handler = this.f10621a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f10621a = null;
        }
        SplashAdInfo splashAdInfo = this.f10551q;
        if (splashAdInfo != null) {
            splashAdInfo.release();
            this.f10551q = null;
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void requestAdInfo(e eVar) {
        a.a(getPosId(), getAdType(), new c(getPosId(), getAdType(), this.f10621a) { // from class: com.tianmu.ad.SplashAd.1
            @Override // com.tianmu.c.k.f.c
            public void a(l lVar) {
                if (lVar == null || lVar.a() == null || lVar.a().size() == 0) {
                    SplashAd.this.p.onAdFailed(new TianmuError(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
                    return;
                }
                SplashAd splashAd = SplashAd.this;
                splashAd.f10551q = new SplashAdInfo(lVar, splashAd.p);
                SplashAd.this.p.onAdReceive(SplashAd.this.f10551q);
            }

            @Override // com.tianmu.c.k.f.c
            public void a(int i2, String str) {
                SplashAd.this.onAdFailed(new TianmuError(i2, str));
            }
        });
    }

    public void setCountDownTime(long j) {
        if (j < 3000) {
            j = 3000;
        } else if (j > 5000) {
            j = 5000;
        }
        this.n = j + 500;
    }

    public void setImmersive(boolean z) {
        this.o = z;
    }

    public void setSensorDisable(boolean z) {
        this.f10629i = z;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void startLoopLoadAd() {
        f fVar = this.p;
        if (fVar != null) {
            fVar.a(getAdPosId(), 1);
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void setListener(SplashAdListener splashAdListener) {
        super.setListener(splashAdListener);
    }

    public SplashAd(@NonNull Context context, @NonNull View view) {
        super(context);
        this.n = 5000L;
        this.m = view;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public e a() {
        f fVar = new f(this, this.f10621a);
        this.p = fVar;
        return fVar;
    }
}
