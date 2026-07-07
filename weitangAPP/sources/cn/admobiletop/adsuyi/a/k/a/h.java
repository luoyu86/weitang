package cn.admobiletop.adsuyi.a.k.a;

import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class h implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cn.admobiletop.adsuyi.a.e.b f3364a = new cn.admobiletop.adsuyi.a.e.b();

    @Override // cn.admobiletop.adsuyi.a.k.a.f
    public void a(ADSuyiPosId aDSuyiPosId, List<ADSuyiPlatformPosId> list, String str, ADSuyiAd aDSuyiAd, ADSuyiAdListener aDSuyiAdListener) {
        cn.admobiletop.adsuyi.a.f.c.b().a(aDSuyiPosId.getPosId(), list);
        c(list);
        b(list);
        d(list);
    }

    public final void b(List<ADSuyiPlatformPosId> list) {
        ArrayList arrayList = new ArrayList();
        for (ADSuyiPlatformPosId aDSuyiPlatformPosId : list) {
            if (aDSuyiPlatformPosId.isBidType()) {
                arrayList.add(aDSuyiPlatformPosId);
            }
        }
        list.removeAll(arrayList);
    }

    public final void c(List<ADSuyiPlatformPosId> list) {
        ArrayList arrayList = new ArrayList();
        for (ADSuyiPlatformPosId aDSuyiPlatformPosId : list) {
            if (aDSuyiPlatformPosId.isFrequencyFinished()) {
                arrayList.add(aDSuyiPlatformPosId);
            }
        }
        list.removeAll(arrayList);
    }

    public final void d(List<ADSuyiPlatformPosId> list) {
        Collections.sort(list, this.f3364a);
    }
}
