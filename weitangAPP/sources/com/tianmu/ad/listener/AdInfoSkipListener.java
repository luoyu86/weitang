package com.tianmu.ad.listener;

import com.tianmu.ad.base.BaseAdInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface AdInfoSkipListener<T extends BaseAdInfo> extends AdInfoListener<T> {
    void onAdSkip(T t);
}
