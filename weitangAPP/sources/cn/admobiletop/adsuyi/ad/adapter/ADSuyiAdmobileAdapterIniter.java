package cn.admobiletop.adsuyi.ad.adapter;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiAdmobileAdapterIniter extends ADSuyiAdapterIniter {
    boolean apiLoad(String str);

    void boot();

    void initForcedPrintLog(boolean z);

    void initMachineId(String str);

    void initQuickAppKeywords(List<String> list);

    void initQuickAppMonitor(boolean z);
}
