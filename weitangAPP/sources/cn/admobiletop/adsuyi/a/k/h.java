package cn.admobiletop.adsuyi.a.k;

import android.os.Handler;
import cn.admobiletop.adsuyi.a.g.k;
import cn.admobiletop.adsuyi.ad.ADSuyiRewardVodAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;

/* JADX INFO: loaded from: classes.dex */
public class h extends cn.admobiletop.adsuyi.a.b.b<k, ADSuyiRewardVodAdInfo, ADSuyiRewardVodAdListener, ADSuyiRewardVodAd> implements ADSuyiRewardVodAdListener {
    public h(ADSuyiRewardVodAd aDSuyiRewardVodAd, Handler handler) {
        super(aDSuyiRewardVodAd, handler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener
    public void onReward(ADSuyiRewardVodAdInfo aDSuyiRewardVodAdInfo) {
        k kVar;
        if (aDSuyiRewardVodAdInfo == null || E() == null || (kVar = (k) o(aDSuyiRewardVodAdInfo)) == null || kVar.i()) {
            return;
        }
        kVar.i(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            cn.admobiletop.adsuyi.a.a.f.a("rewarded", i(), 1, N(), V(), g(), d0());
            ((ADSuyiRewardVodAdListener) a0()).onReward(aDSuyiRewardVodAdInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener
    public void onVideoCache(ADSuyiRewardVodAdInfo aDSuyiRewardVodAdInfo) {
        k kVar;
        if (aDSuyiRewardVodAdInfo == null || E() == null || (kVar = (k) o(aDSuyiRewardVodAdInfo)) == null || kVar.f()) {
            return;
        }
        kVar.f(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiRewardVodAdListener) a0()).onVideoCache(aDSuyiRewardVodAdInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener
    public void onVideoComplete(ADSuyiRewardVodAdInfo aDSuyiRewardVodAdInfo) {
        k kVar;
        if (aDSuyiRewardVodAdInfo == null || E() == null || (kVar = (k) o(aDSuyiRewardVodAdInfo)) == null || kVar.g()) {
            return;
        }
        kVar.g(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiRewardVodAdListener) a0()).onVideoComplete(aDSuyiRewardVodAdInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener
    public void onVideoError(ADSuyiRewardVodAdInfo aDSuyiRewardVodAdInfo, ADSuyiError aDSuyiError) {
        k kVar;
        if (aDSuyiRewardVodAdInfo == null || E() == null || (kVar = (k) o(aDSuyiRewardVodAdInfo)) == null || kVar.h()) {
            return;
        }
        kVar.h(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiRewardVodAdListener) a0()).onVideoError(aDSuyiRewardVodAdInfo, aDSuyiError);
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public k n() {
        return new k();
    }
}
