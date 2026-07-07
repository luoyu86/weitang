package cn.admobiletop.adsuyi.ad.listener;

import cn.admobiletop.adsuyi.ad.data.ADSuyiFullScreenVodAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiFullScreenVodAdListener extends ADSuyiAdInfoListener<ADSuyiFullScreenVodAdInfo> {
    void onVideoCache(ADSuyiFullScreenVodAdInfo aDSuyiFullScreenVodAdInfo);

    void onVideoComplete(ADSuyiFullScreenVodAdInfo aDSuyiFullScreenVodAdInfo);

    void onVideoError(ADSuyiFullScreenVodAdInfo aDSuyiFullScreenVodAdInfo, ADSuyiError aDSuyiError);
}
