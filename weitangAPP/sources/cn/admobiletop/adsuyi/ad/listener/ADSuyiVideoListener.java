package cn.admobiletop.adsuyi.ad.listener;

import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiVideoListener<T extends ADSuyiAdInfo> {
    void onVideoComplete(T t);

    void onVideoError(T t, ADSuyiError aDSuyiError);

    void onVideoLoad(T t);

    void onVideoPause(T t);

    void onVideoStart(T t);
}
