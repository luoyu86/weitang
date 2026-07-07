package com.tianmu.ad.base;

import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.error.TianmuError;

/* JADX INFO: loaded from: classes2.dex */
public interface BaseAdListener<T extends BaseAdInfo> {
    void onAdClick(T t);

    void onAdClose(T t);

    void onAdExpose(T t);

    void onAdFailed(TianmuError tianmuError);
}
