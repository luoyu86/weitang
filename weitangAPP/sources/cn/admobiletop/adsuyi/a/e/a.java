package cn.admobiletop.adsuyi.a.e;

import cn.admobiletop.adsuyi.a.l.h;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class a implements Comparator<ADSuyiPlatformPosId> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiPlatformPosId aDSuyiPlatformPosId2) {
        if (aDSuyiPlatformPosId.getECPM() - aDSuyiPlatformPosId2.getECPM() > 0.0d) {
            return -1;
        }
        if (aDSuyiPlatformPosId.getECPM() - aDSuyiPlatformPosId2.getECPM() < 0.0d) {
            return 1;
        }
        ADSuyiPlatform aDSuyiPlatformC = h.l().c(aDSuyiPlatformPosId.getPlatform());
        ADSuyiPlatform aDSuyiPlatformC2 = h.l().c(aDSuyiPlatformPosId2.getPlatform());
        if (aDSuyiPlatformC == null || aDSuyiPlatformC2 == null || !(aDSuyiPlatformC instanceof cn.admobiletop.adsuyi.a.g.c) || !(aDSuyiPlatformC2 instanceof cn.admobiletop.adsuyi.a.g.c)) {
            return 0;
        }
        return ((cn.admobiletop.adsuyi.a.g.c) aDSuyiPlatformC).a() - ((cn.admobiletop.adsuyi.a.g.c) aDSuyiPlatformC2).a();
    }
}
