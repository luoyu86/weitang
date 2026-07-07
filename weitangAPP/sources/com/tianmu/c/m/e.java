package com.tianmu.c.m;

import android.os.Handler;
import com.tianmu.ad.RewardAd;
import com.tianmu.ad.bean.RewardAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.RewardAdListener;
import com.tianmu.c.b.g;
import com.tianmu.utils.TianmuAdUtil;
import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.tianmu.c.c.c<com.tianmu.c.c.f, RewardAdInfo, RewardAdListener, RewardAd> implements RewardAdListener {
    public e(RewardAd rewardAd, Handler handler) {
        super(rewardAd, handler);
    }

    @Override // com.tianmu.c.c.e
    public com.tianmu.c.c.f a() {
        return new com.tianmu.c.c.f();
    }

    @Override // com.tianmu.c.c.e, com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        if (h() && !g() && !TianmuAdUtil.isReleased(this.f11236b)) {
            a(tianmuError);
        } else {
            super.onAdFailed(tianmuError);
            TianmuLogUtil.d(tianmuError.toString());
        }
    }

    @Override // com.tianmu.ad.listener.RewardAdListener
    public void onAdReward(RewardAdInfo rewardAdInfo) {
        if (!h() || rewardAdInfo == null) {
            return;
        }
        com.tianmu.c.c.f fVar = (com.tianmu.c.c.f) this.k.get(rewardAdInfo);
        if (fVar != null && !fVar.d()) {
            fVar.d(true);
            g.a("rewarded", this.f11243i, this.j);
        }
        if (TianmuAdUtil.canCallBack(this.f11236b)) {
            ((RewardAd) this.f11236b).getListener().onAdReward(rewardAdInfo);
        }
    }

    @Override // com.tianmu.ad.listener.RewardAdListener
    public void onVideoCompleted(RewardAdInfo rewardAdInfo) {
    }

    @Override // com.tianmu.ad.listener.RewardAdListener
    public void onVideoError(RewardAdInfo rewardAdInfo, String str) {
    }

    @Override // com.tianmu.ad.listener.RewardAdListener
    public void onVideoSkip(RewardAdInfo rewardAdInfo) {
    }

    @Override // com.tianmu.c.c.e, com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdClick(RewardAdInfo rewardAdInfo) {
        super.onAdClick(rewardAdInfo);
    }
}
