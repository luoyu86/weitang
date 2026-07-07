package cn.admobiletop.adsuyi.a.j;

import android.os.Handler;
import cn.admobiletop.adsuyi.a.b.n;
import cn.admobiletop.adsuyi.ad.ADSuyiDrawVodAd;

/* JADX INFO: loaded from: classes.dex */
public class c extends n<ADSuyiDrawVodAd, cn.admobiletop.adsuyi.a.k.c> {
    public c(ADSuyiDrawVodAd aDSuyiDrawVodAd) {
        super(aDSuyiDrawVodAd);
    }

    @Override // cn.admobiletop.adsuyi.a.b.n
    public boolean l() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.a.b.n
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public cn.admobiletop.adsuyi.a.k.c a(ADSuyiDrawVodAd aDSuyiDrawVodAd, Handler handler) {
        return new cn.admobiletop.adsuyi.a.k.c(aDSuyiDrawVodAd, handler);
    }
}
