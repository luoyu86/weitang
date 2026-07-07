package cn.admobiletop.adsuyi.bid.manager;

import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.bid.ADSuyiBidParams;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiBidManager {
    void bid(ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback);

    void init(ADSuyiPlatformPosId aDSuyiPlatformPosId, String str, ADSuyiBidParams aDSuyiBidParams);
}
