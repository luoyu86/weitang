package cn.admobiletop.adsuyi.a.k;

import android.os.Handler;
import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.android.live.base.api.push.ILivePush;

/* JADX INFO: loaded from: classes.dex */
public class g extends cn.admobiletop.adsuyi.a.b.a<cn.admobiletop.adsuyi.a.g.h, ADSuyiNativeAdInfo, ADSuyiNativeAdListener, ADSuyiNativeAd> implements ADSuyiNativeAdListener {
    public g(ADSuyiNativeAd aDSuyiNativeAd, Handler handler) {
        super(aDSuyiNativeAd, handler);
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    public boolean l0() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    public void m0() {
        cn.admobiletop.adsuyi.a.a.f.a(ILivePush.ClickType.CLOSE, i(), 1, N(), V(), g());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener
    public void onRenderFailed(ADSuyiNativeAdInfo aDSuyiNativeAdInfo, ADSuyiError aDSuyiError) {
        cn.admobiletop.adsuyi.a.g.h hVar;
        if (aDSuyiNativeAdInfo == null || E() == null || (hVar = (cn.admobiletop.adsuyi.a.g.h) o(aDSuyiNativeAdInfo)) == null || hVar.d()) {
            return;
        }
        hVar.d(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiNativeAdListener) a0()).onRenderFailed(aDSuyiNativeAdInfo, aDSuyiError);
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public cn.admobiletop.adsuyi.a.g.h n() {
        return new cn.admobiletop.adsuyi.a.g.h();
    }
}
