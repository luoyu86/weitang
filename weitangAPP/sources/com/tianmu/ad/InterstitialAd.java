package com.tianmu.ad;

import android.content.Context;
import android.os.Handler;
import com.tianmu.ad.base.BaseAd;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.InterstitialAdListener;
import com.tianmu.c.b.a;
import com.tianmu.c.i.e;
import com.tianmu.c.i.l;
import com.tianmu.c.k.f.c;
import com.tianmu.c.m.b;
import com.tianmu.c.n.n;
import com.tianmu.config.TianmuErrorConfig;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialAd extends BaseAd<InterstitialAdListener> {
    private static int s = 5;
    private static int t = 3;
    private static int u = 100;
    private static int v = 1;
    private b m;
    private e n;
    private InterstitialAdInfo o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f10548q;
    private int r;

    public InterstitialAd(Context context) {
        super(context);
        this.f10548q = 1;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public String getAdType() {
        return "interstitial";
    }

    @Override // com.tianmu.ad.base.BaseAd
    public int getRenderType() {
        return 0;
    }

    public void loadAd(String str) {
        super.loadAd(str, 1);
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void onAdClose(BaseAdInfo baseAdInfo) {
        com.tianmu.c.c.e eVar = this.f10628h;
        if (eVar != null && !eVar.a(baseAdInfo)) {
            this.f10628h.onAdExpose(baseAdInfo);
        }
        super.onAdClose(baseAdInfo);
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void release() {
        super.release();
        Handler handler = this.f10621a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f10621a = null;
        }
        InterstitialAdInfo interstitialAdInfo = this.o;
        if (interstitialAdInfo != null) {
            interstitialAdInfo.release();
            this.o = null;
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void requestAdInfo(com.tianmu.c.c.e eVar) {
        a.a(getPosId(), getAdType(), new c(getPosId(), getAdType(), this.f10621a) { // from class: com.tianmu.ad.InterstitialAd.1
            @Override // com.tianmu.c.k.f.c
            public void a(l lVar) {
                if (lVar == null || lVar.a() == null || lVar.a().size() == 0) {
                    InterstitialAd.this.onAdFailed(new TianmuError(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
                    return;
                }
                Iterator<com.tianmu.c.i.c> it = lVar.a().iterator();
                while (it.hasNext()) {
                    it.next().b(2 == InterstitialAd.this.f10548q);
                }
                InterstitialAd interstitialAd = InterstitialAd.this;
                InterstitialAdListener listener = interstitialAd.getListener();
                InterstitialAd interstitialAd2 = InterstitialAd.this;
                interstitialAd.o = new InterstitialAdInfo(lVar, listener, interstitialAd2, interstitialAd2.getAdPosId().j(), InterstitialAd.this.m);
                InterstitialAd.this.o.setMute(InterstitialAd.this.p);
                InterstitialAd.this.o.setShowDirection(InterstitialAd.this.f10548q);
                InterstitialAd.this.o.setAutoCloseSecond(InterstitialAd.this.r);
                InterstitialAd.this.m.onAdReceive(InterstitialAd.this.o);
            }

            @Override // com.tianmu.c.k.f.c
            public void a(int i2, String str) {
                InterstitialAd.this.onAdFailed(new TianmuError(i2, str));
            }
        });
    }

    public void setAutoClose(boolean z) {
        if (z) {
            this.r = s + v;
        } else {
            this.r = 0;
        }
    }

    public void setMute(boolean z) {
        this.p = z;
    }

    public void setSensorDisable(boolean z) {
        this.f10629i = z;
    }

    public void setShowDirection(int i2) {
        this.f10548q = i2;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void startLoopLoadAd() {
        b bVar = this.m;
        if (bVar != null) {
            bVar.a(this.n, getCount());
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public com.tianmu.c.c.e a() {
        this.n = n.D().a(getPosId());
        b bVar = new b(this, this.f10621a);
        this.m = bVar;
        return bVar;
    }

    public void setAutoClose(boolean z, int i2) {
        if (z) {
            int i3 = t;
            if (i2 < i3) {
                i2 = i3;
            }
            int i4 = u;
            if (i2 > i4) {
                i2 = i4;
            }
            this.r = i2 + v;
            return;
        }
        this.r = 0;
    }
}
