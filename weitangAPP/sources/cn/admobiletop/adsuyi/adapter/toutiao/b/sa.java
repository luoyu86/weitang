package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* JADX INFO: loaded from: classes.dex */
public class sa extends C0313s<ADSuyiRewardVodAdListener> implements TTAdNative.RewardVideoAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.toutiao.a.ba f4042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f4043e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.toutiao.d.c f4044f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TTRewardVideoAd f4045g;

    public sa(String str, ADSuyiRewardVodAdListener aDSuyiRewardVodAdListener, cn.admobiletop.adsuyi.adapter.toutiao.d.c cVar) {
        super(str, aDSuyiRewardVodAdListener);
        this.f4043e = new Handler(Looper.getMainLooper());
        this.f4044f = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onError(int i2, String str) {
        if (this.f4044f != null) {
            Handler handler = this.f4043e;
            if (handler != null) {
                handler.post(new ma(this, i2, str));
                return;
            }
            return;
        }
        Handler handler2 = this.f4043e;
        if (handler2 != null) {
            handler2.post(new na(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
        this.f4045g = tTRewardVideoAd;
        if (this.f4044f == null) {
            a();
            return;
        }
        Handler handler = this.f4043e;
        if (handler != null) {
            handler.post(new oa(this, tTRewardVideoAd));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
    public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
        Handler handler;
        if (this.f4044f == null && (handler = this.f4043e) != null) {
            handler.post(new ra(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        cn.admobiletop.adsuyi.adapter.toutiao.a.ba baVar = this.f4042d;
        if (baVar != null) {
            baVar.release();
            this.f4042d = null;
        }
        Handler handler = this.f4043e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f4043e = null;
        }
        if (this.f4045g != null) {
            this.f4045g = null;
        }
    }

    public void a() {
        cn.admobiletop.adsuyi.adapter.toutiao.d.c cVar = this.f4044f;
        if (cVar != null) {
            cVar.release();
            this.f4044f = null;
        }
        if (this.f4045g == null) {
            Handler handler = this.f4043e;
            if (handler != null) {
                handler.post(new pa(this));
                return;
            }
            return;
        }
        Handler handler2 = this.f4043e;
        if (handler2 != null) {
            handler2.post(new qa(this));
        }
    }
}
