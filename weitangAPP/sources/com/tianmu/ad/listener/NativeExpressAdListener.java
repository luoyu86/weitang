package com.tianmu.ad.listener;

import com.tianmu.ad.bean.NativeExpressAdInfo;
import com.tianmu.ad.error.TianmuError;

/* JADX INFO: loaded from: classes2.dex */
public interface NativeExpressAdListener extends AdInfoListListener<NativeExpressAdInfo> {
    void onRenderFailed(NativeExpressAdInfo nativeExpressAdInfo, TianmuError tianmuError);
}
