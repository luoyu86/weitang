package cn.admobiletop.adsuyi.a.k;

import android.os.Handler;
import cn.admobiletop.adsuyi.a.g.k;
import cn.admobiletop.adsuyi.ad.ADSuyiFullScreenVodAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiFullScreenVodAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;

/* JADX INFO: loaded from: classes.dex */
public class d extends cn.admobiletop.adsuyi.a.b.b<k, ADSuyiFullScreenVodAdInfo, ADSuyiFullScreenVodAdListener, ADSuyiFullScreenVodAd> implements ADSuyiFullScreenVodAdListener {
    public d(ADSuyiFullScreenVodAd aDSuyiFullScreenVodAd, Handler handler) {
        super(aDSuyiFullScreenVodAd, handler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener
    public void onVideoCache(ADSuyiFullScreenVodAdInfo aDSuyiFullScreenVodAdInfo) {
        k kVar;
        if (aDSuyiFullScreenVodAdInfo == null || E() == null || (kVar = (k) o(aDSuyiFullScreenVodAdInfo)) == null || kVar.f()) {
            return;
        }
        kVar.f(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiFullScreenVodAdListener) a0()).onVideoCache(aDSuyiFullScreenVodAdInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener
    public void onVideoComplete(ADSuyiFullScreenVodAdInfo aDSuyiFullScreenVodAdInfo) {
        k kVar;
        if (aDSuyiFullScreenVodAdInfo == null || E() == null || (kVar = (k) o(aDSuyiFullScreenVodAdInfo)) == null || kVar.g()) {
            return;
        }
        kVar.g(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiFullScreenVodAdListener) a0()).onVideoComplete(aDSuyiFullScreenVodAdInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener
    public void onVideoError(ADSuyiFullScreenVodAdInfo aDSuyiFullScreenVodAdInfo, ADSuyiError aDSuyiError) {
        k kVar;
        if (aDSuyiFullScreenVodAdInfo == null || E() == null || (kVar = (k) o(aDSuyiFullScreenVodAdInfo)) == null || kVar.h()) {
            return;
        }
        kVar.h(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiFullScreenVodAdListener) a0()).onVideoError(aDSuyiFullScreenVodAdInfo, aDSuyiError);
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public k n() {
        return new k();
    }
}
