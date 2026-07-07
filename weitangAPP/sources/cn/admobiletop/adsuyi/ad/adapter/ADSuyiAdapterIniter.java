package cn.admobiletop.adsuyi.ad.adapter;

import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiAdapterIniter {
    String getAdapterVersion();

    List<String> getSupportADSuyiSdkVersions();

    ADSuyiAdapterLoader getSuyiAdapterLoader(String str);

    void init(ADSuyiPlatform aDSuyiPlatform, ADSuyiAdapterIniterExtParams aDSuyiAdapterIniterExtParams);

    boolean inited();
}
