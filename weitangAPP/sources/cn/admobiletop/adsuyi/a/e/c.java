package cn.admobiletop.adsuyi.a.e;

import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class c implements Comparator<ADSuyiPlatformPosId> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiPlatformPosId aDSuyiPlatformPosId2) {
        return (int) (aDSuyiPlatformPosId.getFrequencyFinishTime() - aDSuyiPlatformPosId2.getFrequencyFinishTime());
    }
}
