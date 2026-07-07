package cn.admobiletop.adsuyi.ad.listener;

import cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiRewardVodAdListener extends ADSuyiAdInfoListener<ADSuyiRewardVodAdInfo> {
    void onReward(ADSuyiRewardVodAdInfo aDSuyiRewardVodAdInfo);

    void onVideoCache(ADSuyiRewardVodAdInfo aDSuyiRewardVodAdInfo);

    void onVideoComplete(ADSuyiRewardVodAdInfo aDSuyiRewardVodAdInfo);

    void onVideoError(ADSuyiRewardVodAdInfo aDSuyiRewardVodAdInfo, ADSuyiError aDSuyiError);
}
