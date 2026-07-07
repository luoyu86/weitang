package cn.admobiletop.adsuyi.a.e;

import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class b implements Comparator<ADSuyiPlatformPosId> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiPlatformPosId aDSuyiPlatformPosId2) {
        if (aDSuyiPlatformPosId.getECPM() - aDSuyiPlatformPosId2.getECPM() > 0.0d) {
            return -1;
        }
        return aDSuyiPlatformPosId.getECPM() - aDSuyiPlatformPosId2.getECPM() < 0.0d ? 1 : 0;
    }
}
