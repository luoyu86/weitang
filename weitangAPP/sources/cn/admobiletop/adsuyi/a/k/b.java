package cn.admobiletop.adsuyi.a.k;

import android.os.Handler;
import cn.admobiletop.adsuyi.ad.ADSuyiContentAllianceAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiContentAllianceAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiContentAllianceAdListener;

/* JADX INFO: loaded from: classes.dex */
public class b extends cn.admobiletop.adsuyi.a.b.b<cn.admobiletop.adsuyi.a.g.h, ADSuyiContentAllianceAdInfo, ADSuyiContentAllianceAdListener, ADSuyiContentAllianceAd> implements ADSuyiContentAllianceAdListener {
    public b(ADSuyiContentAllianceAd aDSuyiContentAllianceAd, Handler handler) {
        super(aDSuyiContentAllianceAd, handler);
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public cn.admobiletop.adsuyi.a.g.h n() {
        return new cn.admobiletop.adsuyi.a.g.h();
    }
}
