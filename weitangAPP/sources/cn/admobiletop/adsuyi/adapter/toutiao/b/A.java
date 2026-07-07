package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.a.C0278h;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdNative;

/* JADX INFO: loaded from: classes.dex */
public class A extends C0313s<ADSuyiSplashAdListener> implements TTAdNative.CSJSplashAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0278h f3922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f3923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.toutiao.d.c f3924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CSJSplashAd f3925g;

    public A(String str, ADSuyiSplashAdListener aDSuyiSplashAdListener, cn.admobiletop.adsuyi.adapter.toutiao.d.c cVar) {
        super(str, aDSuyiSplashAdListener);
        this.f3923e = new Handler(Looper.getMainLooper());
        this.f3924f = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashLoadFail(CSJAdError cSJAdError) {
        if (this.f3924f != null) {
            Handler handler = this.f3923e;
            if (handler != null) {
                handler.post(new RunnableC0317w(this, cSJAdError));
                return;
            }
            return;
        }
        Handler handler2 = this.f3923e;
        if (handler2 != null) {
            handler2.post(new RunnableC0318x(this, cSJAdError));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
        this.f3925g = cSJSplashAd;
        if (this.f3924f == null) {
            a();
            return;
        }
        Handler handler = this.f3923e;
        if (handler != null) {
            handler.post(new RunnableC0316v(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
        if (this.f3924f != null) {
            Handler handler = this.f3923e;
            if (handler != null) {
                handler.post(new RunnableC0319y(this, cSJAdError));
                return;
            }
            return;
        }
        Handler handler2 = this.f3923e;
        if (handler2 != null) {
            handler2.post(new RunnableC0320z(this, cSJAdError));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
    public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        C0278h c0278h = this.f3922d;
        if (c0278h != null) {
            c0278h.release();
            this.f3922d = null;
        }
        Handler handler = this.f3923e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3923e = null;
        }
        if (this.f3925g != null) {
            this.f3925g = null;
        }
    }

    public void a() {
        cn.admobiletop.adsuyi.adapter.toutiao.d.c cVar = this.f3924f;
        if (cVar != null) {
            cVar.release();
            this.f3924f = null;
        }
        if (this.f3925g == null) {
            Handler handler = this.f3923e;
            if (handler != null) {
                handler.post(new RunnableC0314t(this));
                return;
            }
            return;
        }
        Handler handler2 = this.f3923e;
        if (handler2 != null) {
            handler2.post(new RunnableC0315u(this));
        }
    }
}
