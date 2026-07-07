package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class la extends C0313s<ADSuyiSplashAdListener> implements TTAdNative.NativeExpressAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.toutiao.a.U f4009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TTNativeExpressAd f4010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Activity f4011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ADSuyiSplashAdContainer f4012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f4013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.toutiao.d.c f4014i;

    public la(Activity activity, ADSuyiSplashAdContainer aDSuyiSplashAdContainer, String str, ADSuyiSplashAdListener aDSuyiSplashAdListener, cn.admobiletop.adsuyi.adapter.toutiao.d.c cVar) {
        super(str, aDSuyiSplashAdListener);
        this.f4013h = new Handler(Looper.getMainLooper());
        this.f4011f = activity;
        this.f4012g = aDSuyiSplashAdContainer;
        this.f4014i = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i2, String str) {
        onAdFailed(i2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        if (list != null && !list.isEmpty()) {
            this.f4010e = list.get(0);
            if (this.f4014i == null) {
                a();
                return;
            }
            Handler handler = this.f4013h;
            if (handler != null) {
                handler.post(new ha(this));
                return;
            }
            return;
        }
        if (this.f4014i != null) {
            Handler handler2 = this.f4013h;
            if (handler2 != null) {
                handler2.post(new fa(this));
                return;
            }
            return;
        }
        Handler handler3 = this.f4013h;
        if (handler3 != null) {
            handler3.post(new ga(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f4012g = null;
        cn.admobiletop.adsuyi.adapter.toutiao.a.U u = this.f4009d;
        if (u != null) {
            u.release();
            this.f4009d = null;
        }
        Handler handler = this.f4013h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f4013h = null;
        }
        if (this.f4010e != null) {
            this.f4010e = null;
        }
    }

    public void a() {
        cn.admobiletop.adsuyi.adapter.toutiao.d.c cVar = this.f4014i;
        if (cVar != null) {
            cVar.release();
            this.f4014i = null;
        }
        if (this.f4010e == null) {
            Handler handler = this.f4013h;
            if (handler != null) {
                handler.post(new ia(this));
                return;
            }
            return;
        }
        ADSuyiSplashAdContainer aDSuyiSplashAdContainer = this.f4012g;
        if (aDSuyiSplashAdContainer == null) {
            Handler handler2 = this.f4013h;
            if (handler2 != null) {
                handler2.post(new ja(this));
                return;
            }
            return;
        }
        aDSuyiSplashAdContainer.setSplashAdListener((ADSuyiSplashAdListener) getAdListener());
        cn.admobiletop.adsuyi.adapter.toutiao.a.U u = new cn.admobiletop.adsuyi.adapter.toutiao.a.U(getPlatformPosId());
        this.f4009d = u;
        u.setAdListener(getAdListener());
        this.f4009d.setAdapterAdInfo(this.f4010e);
        if (getAdListener() != 0) {
            ((ADSuyiSplashAdListener) getAdListener()).onAdReceive(this.f4009d);
        }
        b();
    }

    public final void b() {
        TTNativeExpressAd tTNativeExpressAd;
        Activity activity = this.f4011f;
        if (activity == null || activity.isFinishing() || (tTNativeExpressAd = this.f4010e) == null) {
            return;
        }
        tTNativeExpressAd.setDislikeCallback(this.f4011f, new ka(this));
    }
}
