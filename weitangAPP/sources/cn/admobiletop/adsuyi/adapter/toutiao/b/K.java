package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.a.C0293x;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX INFO: loaded from: classes.dex */
public class K extends C0313s<ADSuyiFullScreenVodAdListener> implements TTAdNative.FullScreenVideoAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0293x f3943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f3944e;

    public K(String str, ADSuyiFullScreenVodAdListener aDSuyiFullScreenVodAdListener) {
        super(str, aDSuyiFullScreenVodAdListener);
        this.f3944e = new Handler(Looper.getMainLooper());
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onError(int i2, String str) {
        Handler handler = this.f3944e;
        if (handler != null) {
            handler.post(new G(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
        if (tTFullScreenVideoAd == null) {
            Handler handler = this.f3944e;
            if (handler != null) {
                handler.post(new H(this));
                return;
            }
            return;
        }
        C0293x c0293x = new C0293x(getPlatformPosId());
        this.f3943d = c0293x;
        c0293x.setAdapterAdInfo(tTFullScreenVideoAd);
        this.f3943d.setAdListener(getAdListener());
        Handler handler2 = this.f3944e;
        if (handler2 != null) {
            handler2.post(new I(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        Handler handler = this.f3944e;
        if (handler != null) {
            handler.post(new J(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        C0293x c0293x = this.f3943d;
        if (c0293x != null) {
            c0293x.release();
            this.f3943d = null;
        }
        Handler handler = this.f3944e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3944e = null;
        }
    }
}
