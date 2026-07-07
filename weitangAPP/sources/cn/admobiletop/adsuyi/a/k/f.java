package cn.admobiletop.adsuyi.a.k;

import android.os.Handler;
import cn.admobiletop.adsuyi.ad.ADSuyiInterstitialAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;

/* JADX INFO: loaded from: classes.dex */
public class f extends cn.admobiletop.adsuyi.a.b.b<cn.admobiletop.adsuyi.a.g.f, ADSuyiInterstitialAdInfo, ADSuyiInterstitialAdListener, ADSuyiInterstitialAd> implements ADSuyiInterstitialAdListener {
    public f(ADSuyiInterstitialAd aDSuyiInterstitialAd, Handler handler) {
        super(aDSuyiInterstitialAd, handler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener
    public void onAdReady(ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo) {
        cn.admobiletop.adsuyi.a.g.f fVar;
        if (aDSuyiInterstitialAdInfo == null || E() == null || (fVar = (cn.admobiletop.adsuyi.a.g.f) o(aDSuyiInterstitialAdInfo)) == null || fVar.f()) {
            return;
        }
        fVar.f(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiInterstitialAdListener) a0()).onAdReady(aDSuyiInterstitialAdInfo);
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public cn.admobiletop.adsuyi.a.g.f n() {
        return new cn.admobiletop.adsuyi.a.g.f();
    }
}
