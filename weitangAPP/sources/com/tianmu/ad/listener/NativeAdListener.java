package com.tianmu.ad.listener;

import com.tianmu.ad.bean.NativeAdInfo;
import com.tianmu.ad.error.TianmuError;

/* JADX INFO: loaded from: classes2.dex */
public interface NativeAdListener extends AdInfoListListener<NativeAdInfo> {
    void onRenderFailed(NativeAdInfo nativeAdInfo, TianmuError tianmuError);
}
