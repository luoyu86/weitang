package com.tianmu.ad.listener;

import com.tianmu.ad.model.INativeRewardAd;

/* JADX INFO: loaded from: classes2.dex */
public interface RewardListener {
    INativeRewardAd getAdmNativeRewardAd();

    void onAdClick();

    void onAdClose();

    void onAdExposure();

    void onAdReward();

    void onVideoCache();

    void onVideoCompleted();

    void onVideoError();

    void onVideoSkip();
}
