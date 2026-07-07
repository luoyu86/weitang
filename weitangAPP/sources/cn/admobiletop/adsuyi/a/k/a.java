package cn.admobiletop.adsuyi.a.k;

import android.os.Handler;
import cn.admobiletop.adsuyi.a.b.o;
import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.bytedance.android.live.base.api.push.ILivePush;

/* JADX INFO: loaded from: classes.dex */
public class a extends cn.admobiletop.adsuyi.a.b.b<o, ADSuyiAdInfo, ADSuyiBannerAdListener, ADSuyiBannerAd> implements ADSuyiBannerAdListener {
    public boolean K;

    public a(ADSuyiBannerAd aDSuyiBannerAd, Handler handler) {
        super(aDSuyiBannerAd, handler);
        this.K = true;
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    public void m0() {
        cn.admobiletop.adsuyi.a.a.f.a(ILivePush.ClickType.CLOSE, i(), 1, N(), V(), g());
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    public o n() {
        return new o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.a.b.k, cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    public void onAdFailed(ADSuyiError aDSuyiError) {
        if (!ADSuyiAdUtil.isReleased(f0()) && ((ADSuyiBannerAd) f0()).getContainer() != null) {
            ((ADSuyiBannerAd) f0()).getContainer().removeAllViews();
        }
        super.onAdFailed(aDSuyiError);
    }

    @Override // cn.admobiletop.adsuyi.a.b.b, cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListener
    public void onAdReceive(ADSuyiAdInfo aDSuyiAdInfo) {
        if (C(Integer.valueOf(aDSuyiAdInfo.hashCode()))) {
            E().clear();
            E().put(Integer.valueOf(aDSuyiAdInfo.hashCode()), new o());
            J(false);
        }
        super.onAdReceive(aDSuyiAdInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cn.admobiletop.adsuyi.a.b.k, cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        ADSuyiBannerAd aDSuyiBannerAd = (ADSuyiBannerAd) f0();
        if (aDSuyiBannerAd != null && aDSuyiBannerAd.getContainer() != null) {
            ADSuyiViewUtil.removeSelfFromParent(aDSuyiBannerAd.getContainer());
            aDSuyiBannerAd.getContainer().removeAllViews();
        }
        super.release();
    }

    @Override // cn.admobiletop.adsuyi.a.b.b
    public void x0() {
        if (this.K) {
            this.K = false;
        } else {
            cn.admobiletop.adsuyi.a.a.e.a("request", i(), 1, N(), g(), d0());
            cn.admobiletop.adsuyi.a.a.f.a("request", i(), 1, N(), V(), g(), d0());
        }
    }
}
