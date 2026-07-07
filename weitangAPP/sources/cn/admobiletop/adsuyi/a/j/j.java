package cn.admobiletop.adsuyi.a.j;

import android.os.Handler;
import cn.admobiletop.adsuyi.a.b.n;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.api.ADSuyiNetworkRequestInfo;

/* JADX INFO: loaded from: classes.dex */
public class j extends n<ADSuyiSplashAd, cn.admobiletop.adsuyi.a.k.i> {
    public j(ADSuyiSplashAd aDSuyiSplashAd) {
        super(aDSuyiSplashAd);
    }

    @Override // cn.admobiletop.adsuyi.a.b.n
    public boolean l() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.a.b.n
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public cn.admobiletop.adsuyi.a.k.i a(ADSuyiSplashAd aDSuyiSplashAd, Handler handler) {
        return new cn.admobiletop.adsuyi.a.k.i(aDSuyiSplashAd, handler);
    }

    @Override // cn.admobiletop.adsuyi.a.b.n, cn.admobiletop.adsuyi.a.b.w
    public void a(String str, int i2) {
        ADSuyiSplashAd aDSuyiSplashAdA = a();
        if (aDSuyiSplashAdA != null && aDSuyiSplashAdA.getContainer() != null) {
            aDSuyiSplashAdA.getContainer().setPosId(str);
        }
        super.a(str, i2);
    }

    @Override // cn.admobiletop.adsuyi.a.b.n
    public void a(String str, int i2, ADSuyiNetworkRequestInfo aDSuyiNetworkRequestInfo) {
        ADSuyiSplashAd aDSuyiSplashAdA = a();
        if (aDSuyiSplashAdA != null && aDSuyiSplashAdA.getContainer() != null) {
            aDSuyiSplashAdA.getContainer().setPosId(str);
        }
        super.a(str, i2, aDSuyiNetworkRequestInfo);
    }
}
