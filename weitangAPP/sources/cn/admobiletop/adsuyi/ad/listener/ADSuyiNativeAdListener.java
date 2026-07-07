package cn.admobiletop.adsuyi.ad.listener;

import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiNativeAdListener extends ADSuyiAdInfoListListener<ADSuyiNativeAdInfo> {
    void onRenderFailed(ADSuyiNativeAdInfo aDSuyiNativeAdInfo, ADSuyiError aDSuyiError);
}
