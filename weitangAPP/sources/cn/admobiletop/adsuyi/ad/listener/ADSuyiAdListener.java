package cn.admobiletop.adsuyi.ad.listener;

import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiAdListener<T extends ADSuyiAdInfo> {
    void onAdClick(T t);

    void onAdClose(T t);

    void onAdExpose(T t);

    void onAdFailed(ADSuyiError aDSuyiError);
}
