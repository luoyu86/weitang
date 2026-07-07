package cn.admobiletop.adsuyi.ad.listener;

import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiSplashAdListener extends ADSuyiAdInfoSkipListener<ADSuyiAdInfo> {
    void onADTick(long j);

    void onReward(ADSuyiAdInfo aDSuyiAdInfo);
}
