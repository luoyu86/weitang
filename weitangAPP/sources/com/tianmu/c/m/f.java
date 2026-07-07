package com.tianmu.c.m;

import android.os.Handler;
import com.tianmu.ad.SplashAd;
import com.tianmu.ad.bean.SplashAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.SplashAdListener;
import com.tianmu.biz.widget.j;
import com.tianmu.c.i.n;
import com.tianmu.utils.TianmuAdUtil;
import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class f extends com.tianmu.c.c.d<n, SplashAdInfo, SplashAdListener, SplashAd> implements SplashAdListener {
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f11825q;
    private SplashAdInfo r;
    private j s;

    public f(SplashAd splashAd, Handler handler) {
        super(splashAd, handler);
        this.p = true;
        this.f11825q = false;
    }

    private void r() {
        if (this.p && this.f11825q) {
            super.onAdClose(this.r);
        }
    }

    @Override // com.tianmu.c.c.e, com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onAdClose(SplashAdInfo splashAdInfo) {
        this.f11825q = true;
        r();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tianmu.c.c.c, com.tianmu.ad.listener.AdInfoListener
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onAdReceive(SplashAdInfo splashAdInfo) {
        if (!g() && splashAdInfo != null) {
            this.r = splashAdInfo;
            j jVar = new j((SplashAd) d(), this.r);
            this.s = jVar;
            this.r.setSplashAdView(jVar);
        }
        super.onAdReceive(this.r);
    }

    @Override // com.tianmu.c.c.e
    public boolean k() {
        return false;
    }

    @Override // com.tianmu.c.c.e
    public void m() {
        n nVar;
        if (this.r == null || c() == null || (nVar = (n) c().get(this.r)) == null || nVar.e()) {
        }
    }

    @Override // com.tianmu.c.c.e, com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        if (h() && !g() && !TianmuAdUtil.isReleased(this.f11236b)) {
            a(tianmuError);
        } else {
            super.onAdFailed(tianmuError);
            TianmuLogUtil.d(tianmuError.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tianmu.ad.listener.SplashAdListener
    public void onAdTick(long j) {
        ((SplashAd) d()).getListener().onAdTick(j);
    }

    @Override // com.tianmu.c.c.e, com.tianmu.ad.base.IBaseRelease
    public void release() {
        this.r = null;
        j jVar = this.s;
        if (jVar != null) {
            jVar.release();
            this.s = null;
        }
        super.release();
    }

    @Override // com.tianmu.c.c.e, com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdClick(SplashAdInfo splashAdInfo) {
        super.onAdClick(splashAdInfo);
        this.f11825q = true;
    }

    @Override // com.tianmu.c.c.e
    public n a() {
        return new n();
    }

    @Override // com.tianmu.c.c.d
    public boolean a(n nVar) {
        return nVar != null && nVar.a();
    }
}
