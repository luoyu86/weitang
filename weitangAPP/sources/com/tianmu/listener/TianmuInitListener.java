package com.tianmu.listener;

import com.tianmu.ad.error.TianmuError;

/* JADX INFO: loaded from: classes2.dex */
public interface TianmuInitListener {
    void onInitFailed(TianmuError tianmuError);

    void onInitFinished();
}
