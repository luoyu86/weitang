package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.a.C0294y;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX INFO: loaded from: classes.dex */
public class S extends C0313s<ADSuyiInterstitialAdListener> implements TTAdNative.FullScreenVideoAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0294y f3956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TTFullScreenVideoAd f3957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f3958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.toutiao.d.c f3959g;

    public S(String str, ADSuyiInterstitialAdListener aDSuyiInterstitialAdListener, cn.admobiletop.adsuyi.adapter.toutiao.d.c cVar) {
        super(str, aDSuyiInterstitialAdListener);
        this.f3958f = new Handler(Looper.getMainLooper());
        this.f3959g = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onError(int i2, String str) {
        if (this.f3959g != null) {
            Handler handler = this.f3958f;
            if (handler != null) {
                handler.post(new L(this, i2, str));
                return;
            }
            return;
        }
        Handler handler2 = this.f3958f;
        if (handler2 != null) {
            handler2.post(new M(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
        this.f3957e = tTFullScreenVideoAd;
        if (this.f3959g == null) {
            b();
            return;
        }
        Handler handler = this.f3958f;
        if (handler != null) {
            handler.post(new N(this, tTFullScreenVideoAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        if (this.f3959g != null) {
            return;
        }
        a();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        C0294y c0294y = this.f3956d;
        if (c0294y != null) {
            c0294y.release();
            this.f3956d = null;
        }
        Handler handler = this.f3958f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3958f = null;
        }
        if (this.f3957e != null) {
            this.f3957e = null;
        }
    }

    public void a() {
        Handler handler = this.f3958f;
        if (handler != null) {
            handler.post(new Q(this));
        }
    }

    public void b() {
        cn.admobiletop.adsuyi.adapter.toutiao.d.c cVar = this.f3959g;
        if (cVar != null) {
            cVar.release();
            this.f3959g = null;
        }
        if (this.f3957e == null) {
            Handler handler = this.f3958f;
            if (handler != null) {
                handler.post(new O(this));
                return;
            }
            return;
        }
        C0294y c0294y = new C0294y(getPlatformPosId());
        this.f3956d = c0294y;
        c0294y.setAdapterAdInfo(this.f3957e);
        this.f3956d.setAdListener(getAdListener());
        Handler handler2 = this.f3958f;
        if (handler2 != null) {
            handler2.post(new P(this));
        }
    }
}
