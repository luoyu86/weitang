package com.tianmu.ad.listener;

import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.base.BaseAdListener;

/* JADX INFO: loaded from: classes2.dex */
public interface AdInfoListener<T extends BaseAdInfo> extends BaseAdListener<T> {
    void onAdReceive(T t);
}
