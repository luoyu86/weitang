package cn.admobiletop.adsuyi.ad.listener;

import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiAdInfoSkipListener<T extends ADSuyiAdInfo> extends ADSuyiAdInfoListener<T> {
    void onAdSkip(T t);
}
