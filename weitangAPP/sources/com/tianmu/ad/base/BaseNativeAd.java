package com.tianmu.ad.base;

import android.content.Context;
import android.os.Handler;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.base.BaseAdListener;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.biz.bean.VideoAutoPlayType;
import com.tianmu.c.b.a;
import com.tianmu.c.c.b;
import com.tianmu.c.i.e;
import com.tianmu.c.i.l;
import com.tianmu.c.k.f.c;
import com.tianmu.config.TianmuErrorConfig;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseNativeAd<T extends BaseAdListener, E extends BaseAdInfo, F extends b> extends BaseAd<T> {
    public int m;
    public boolean n;
    public List<E> o;
    public List<E> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e f10661q;
    public F r;
    public int s;
    public int t;
    public boolean u;
    public Runnable v;

    public BaseNativeAd(Context context) {
        super(context);
        this.m = VideoAutoPlayType.AUTO_PLAY;
        this.n = true;
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.v = new Runnable() { // from class: com.tianmu.ad.base.BaseNativeAd.2
            @Override // java.lang.Runnable
            public void run() {
                BaseNativeAd.this.d();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        this.t++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        this.s++;
    }

    private void h() {
        a.a(getPosId(), getAdType(), new c(getPosId(), getAdType(), this.f10621a) { // from class: com.tianmu.ad.base.BaseNativeAd.1
            @Override // com.tianmu.c.k.f.c
            public void a(l lVar) {
                if (lVar == null || lVar.a() == null || lVar.a().size() == 0) {
                    BaseNativeAd.this.onAdFailed(new TianmuError(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
                    return;
                }
                if (lVar.a().size() > 1) {
                    com.tianmu.c.i.c cVar = lVar.a().get(0);
                    lVar.a().clear();
                    lVar.a().add(cVar);
                }
                BaseNativeAd.this.g();
                BaseNativeAd.this.a(lVar);
                if (BaseNativeAd.this.c()) {
                    BaseNativeAd.this.d();
                }
            }

            @Override // com.tianmu.c.k.f.c
            public void a(int i2, String str) {
                BaseNativeAd.this.f();
                BaseNativeAd.this.a(i2, str);
            }
        });
    }

    private void i() {
        Runnable runnable;
        Handler handler = this.f10621a;
        if (handler == null || (runnable = this.v) == null) {
            return;
        }
        handler.postDelayed(runnable, getTimeout() - 100);
    }

    public abstract void a(l lVar);

    public synchronized boolean c() {
        if (this.r == null) {
            return false;
        }
        return this.s + this.t >= getCount();
    }

    public synchronized void d() {
        b();
        List<E> list = this.o;
        if (list == null || list.size() <= 0) {
            onAdFailed(new TianmuError(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
        } else {
            this.u = false;
            List<E> list2 = this.p;
            if (list2 != null) {
                list2.addAll(this.o);
            }
            this.r.onAdReceive(this.o);
        }
    }

    public void e() {
        i();
        this.s = 0;
        this.t = 0;
        this.u = true;
        this.o = new ArrayList();
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void onAdFailed(TianmuError tianmuError) {
        this.u = false;
        b();
        super.onAdFailed(tianmuError);
    }

    public void onDestroy() {
        Handler handler = this.f10621a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f10621a = null;
        }
        List<E> list = this.p;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.p.size(); i2++) {
                E e2 = this.p.get(i2);
                if (e2 != null) {
                    e2.release();
                }
            }
            this.p.clear();
            this.p = null;
        }
        List<E> list2 = this.o;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        this.o.clear();
        this.o = null;
    }

    public void pause() {
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            this.p.get(i2).pause();
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void release() {
        super.release();
        b();
        onDestroy();
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void requestAdInfo(com.tianmu.c.c.e eVar) {
        if (this.u) {
            onAdFailed(new TianmuError(TianmuErrorConfig.AD_REQUEST_REPEAT_ERROR, TianmuErrorConfig.MSG_AD_REQUEST_REPEAT_ERROR));
            return;
        }
        e();
        for (int i2 = 0; i2 < getCount(); i2++) {
            h();
        }
    }

    public void resume() {
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            this.p.get(i2).resume();
        }
    }

    public void setMute(boolean z) {
        this.n = z;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void startLoopLoadAd() {
        F f2 = this.r;
        if (f2 != null) {
            f2.a(this.f10661q, getCount());
        }
    }

    public synchronized void a(int i2, String str) {
        if (this.r == null) {
            return;
        }
        if (this.s + this.t < getCount()) {
            return;
        }
        if (this.t == getCount()) {
            onAdFailed(new TianmuError(i2, str));
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void b() {
        Runnable runnable;
        Handler handler = this.f10621a;
        if (handler == null || (runnable = this.v) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }
}
