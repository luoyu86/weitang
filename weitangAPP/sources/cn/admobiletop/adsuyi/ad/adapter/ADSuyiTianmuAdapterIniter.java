package cn.admobiletop.adsuyi.ad.adapter;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiTianmuAdapterIniter extends ADSuyiAdapterIniter {
    boolean apiLoad(String str);

    void initMachineId(String str);

    void initQuickAppKeywords(List<String> list);

    void initQuickAppMonitor(boolean z);
}
