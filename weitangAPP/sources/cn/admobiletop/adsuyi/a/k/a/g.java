package cn.admobiletop.adsuyi.a.k.a;

import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cn.admobiletop.adsuyi.a.e.c f3363a = new cn.admobiletop.adsuyi.a.e.c();

    @Override // cn.admobiletop.adsuyi.a.k.a.f
    public void a(ADSuyiPosId aDSuyiPosId, List<ADSuyiPlatformPosId> list, String str, ADSuyiAd aDSuyiAd, ADSuyiAdListener aDSuyiAdListener) {
        cn.admobiletop.adsuyi.a.f.c.b().a(aDSuyiPosId.getPosId(), list);
        if (aDSuyiPosId.isLoopFrequencyType()) {
            b(list);
        }
    }

    public final void b(List<ADSuyiPlatformPosId> list) {
        try {
            for (ADSuyiPlatformPosId aDSuyiPlatformPosId : list) {
                if (!aDSuyiPlatformPosId.isFrequencyFinished()) {
                    aDSuyiPlatformPosId.setFrequencyFinishTime(0L);
                }
            }
            Collections.sort(list, this.f3363a);
        } catch (Exception unused) {
        }
    }
}
