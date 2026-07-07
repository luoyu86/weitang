package cn.admobiletop.adsuyi.ad.listener;

import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiAdInfoListener<T extends ADSuyiAdInfo> extends ADSuyiAdListener<T> {
    void onAdReceive(T t);
}
