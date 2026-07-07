package cn.admobiletop.adsuyi.a.j;

import android.os.Handler;
import cn.admobiletop.adsuyi.a.b.n;
import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;

/* JADX INFO: loaded from: classes.dex */
public class h extends n<ADSuyiNativeAd, cn.admobiletop.adsuyi.a.k.g> {
    public h(ADSuyiNativeAd aDSuyiNativeAd) {
        super(aDSuyiNativeAd);
    }

    @Override // cn.admobiletop.adsuyi.a.b.n
    public boolean l() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.a.b.n
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public cn.admobiletop.adsuyi.a.k.g a(ADSuyiNativeAd aDSuyiNativeAd, Handler handler) {
        return new cn.admobiletop.adsuyi.a.k.g(aDSuyiNativeAd, handler);
    }
}
