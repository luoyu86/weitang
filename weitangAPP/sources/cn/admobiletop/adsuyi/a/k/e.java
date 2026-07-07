package cn.admobiletop.adsuyi.a.k;

import android.os.Handler;
import cn.admobiletop.adsuyi.ad.ADSuyiInnerNoticeAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInnerNoticeAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;

/* JADX INFO: loaded from: classes.dex */
public class e extends cn.admobiletop.adsuyi.a.b.c<cn.admobiletop.adsuyi.a.g.f, ADSuyiInnerNoticeAdInfo, ADSuyiInnerNoticeAdListener, ADSuyiInnerNoticeAd> implements ADSuyiInnerNoticeAdListener {
    public e(ADSuyiInnerNoticeAd aDSuyiInnerNoticeAd, Handler handler) {
        super(aDSuyiInnerNoticeAd, handler);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [cn.admobiletop.adsuyi.ad.ADSuyiAd] */
    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener
    public void onAdReady(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
        cn.admobiletop.adsuyi.a.g.f fVar;
        if (aDSuyiInnerNoticeAdInfo == null || E() == null || (fVar = (cn.admobiletop.adsuyi.a.g.f) o(aDSuyiInnerNoticeAdInfo)) == null || fVar.f()) {
            return;
        }
        fVar.f(true);
        if (ADSuyiAdUtil.canCallBack(f0())) {
            ((ADSuyiInnerNoticeAdListener) a0()).onAdReady(aDSuyiInnerNoticeAdInfo);
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.k
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public cn.admobiletop.adsuyi.a.g.f n() {
        return new cn.admobiletop.adsuyi.a.g.f();
    }
}
