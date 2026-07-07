package com.tianmu.ad.bean;

import android.content.Context;
import android.text.TextUtils;
import com.tianmu.ad.RewardAd;
import com.tianmu.ad.activity.RewardVodActivity;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.listener.RewardAdListener;
import com.tianmu.ad.listener.RewardListener;
import com.tianmu.ad.model.INativeRewardAd;
import com.tianmu.c.i.f;
import com.tianmu.c.i.l;
import com.tianmu.c.m.e;
import com.tianmu.config.TianmuErrorConfig;

/* JADX INFO: loaded from: classes2.dex */
public class RewardAdInfo extends BaseAdInfo implements RewardListener {
    private RewardAdListener t;
    private RewardAd u;
    private int v;
    private int w;
    private e x;

    public RewardAdInfo(l lVar, RewardAdListener rewardAdListener, RewardAd rewardAd, int i2, int i3, e eVar) {
        super(eVar);
        a(lVar);
        this.t = rewardAdListener;
        this.u = rewardAd;
        this.v = i2;
        this.w = i3;
        this.x = eVar;
    }

    private boolean c() {
        return this.w == 1;
    }

    @Override // com.tianmu.ad.listener.RewardListener
    public INativeRewardAd getAdmNativeRewardAd() {
        return (f) getAdData();
    }

    @Override // com.tianmu.ad.listener.RewardListener
    public void onAdClick() {
        e eVar = this.x;
        if (eVar != null) {
            eVar.onAdClick(this);
        }
    }

    @Override // com.tianmu.ad.listener.RewardListener
    public void onAdClose() {
        RewardAdListener rewardAdListener = this.t;
        if (rewardAdListener != null) {
            rewardAdListener.onAdClose(this);
        }
    }

    @Override // com.tianmu.ad.listener.RewardListener
    public void onAdExposure() {
        e eVar = this.x;
        if (eVar != null) {
            eVar.onAdExpose(this);
        }
    }

    @Override // com.tianmu.ad.listener.RewardListener
    public void onAdReward() {
        e eVar = this.x;
        if (eVar != null) {
            eVar.onAdReward(this);
        }
    }

    @Override // com.tianmu.ad.listener.RewardListener
    public void onVideoCache() {
    }

    @Override // com.tianmu.ad.listener.RewardListener
    public void onVideoCompleted() {
        RewardAdListener rewardAdListener = this.t;
        if (rewardAdListener != null) {
            rewardAdListener.onVideoCompleted(this);
        }
    }

    @Override // com.tianmu.ad.listener.RewardListener
    public void onVideoError() {
        RewardAdListener rewardAdListener = this.t;
        if (rewardAdListener != null) {
            rewardAdListener.onVideoError(this, "视频播放异常");
        }
    }

    @Override // com.tianmu.ad.listener.RewardListener
    public void onVideoSkip() {
        RewardAdListener rewardAdListener = this.t;
        if (rewardAdListener != null) {
            rewardAdListener.onVideoSkip(this);
        }
    }

    public void setOrientation(int i2) {
    }

    @Deprecated
    public void showReward(Context context) {
        showRewardAd(context);
    }

    public void showRewardAd(Context context) {
        com.tianmu.c.n.l.a().a(getKey(), this.t, this.u, this);
        if (hasShow()) {
            a(TianmuErrorConfig.AD_ALREADY_SHOW_ERROR, TianmuErrorConfig.MSG_AD_ALREADY_SHOW_ERROR);
            return;
        }
        if (isAvailable()) {
            if (context != null && getAdData() != null && (getAdData() instanceof f)) {
                f fVar = (f) getAdData();
                RewardVodActivity.start(context, getKey(), TextUtils.isEmpty(fVar.getVideoCacheUrl()) ? fVar.getVideoUrl() : fVar.getVideoCacheUrl(), this.v, this.f10637f, c());
            }
            setHasShow(true);
        }
    }
}
