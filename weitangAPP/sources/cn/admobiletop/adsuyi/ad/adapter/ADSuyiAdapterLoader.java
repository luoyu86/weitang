package cn.admobiletop.adsuyi.ad.adapter;

import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiAdapterLoader<R extends ADSuyiAd, T extends ADSuyiAdListener> {
    void loadAd(R r, ADSuyiAdapterParams aDSuyiAdapterParams, T t);

    void onPaused();

    void onResumed();

    void release();
}
