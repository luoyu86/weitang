package cn.admobiletop.adsuyi.a.j;

import android.os.Handler;
import cn.admobiletop.adsuyi.a.b.n;
import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiInterceptContainer;

/* JADX INFO: loaded from: classes.dex */
public class a extends n<ADSuyiBannerAd, cn.admobiletop.adsuyi.a.k.a> {
    public a(ADSuyiBannerAd aDSuyiBannerAd) {
        super(aDSuyiBannerAd);
    }

    @Override // cn.admobiletop.adsuyi.a.b.n
    public boolean l() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.a.b.n
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public cn.admobiletop.adsuyi.a.k.a a(ADSuyiBannerAd aDSuyiBannerAd, Handler handler) {
        return new cn.admobiletop.adsuyi.a.k.a(aDSuyiBannerAd, handler);
    }

    @Override // cn.admobiletop.adsuyi.a.b.n, cn.admobiletop.adsuyi.a.b.w
    public void a(String str, int i2) {
        ADSuyiBannerAd aDSuyiBannerAdA = a();
        if (aDSuyiBannerAdA != null && aDSuyiBannerAdA.getContainer() != null && (aDSuyiBannerAdA.getContainer() instanceof ADSuyiInterceptContainer)) {
            ((ADSuyiInterceptContainer) aDSuyiBannerAdA.getContainer()).setPosId(str);
        }
        super.a(str, i2);
    }
}
