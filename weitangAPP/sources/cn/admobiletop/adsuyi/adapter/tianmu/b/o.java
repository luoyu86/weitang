package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import com.tianmu.ad.bean.RewardAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.RewardAdListener;

/* JADX INFO: loaded from: classes.dex */
public class o extends b<ADSuyiRewardVodAdListener> implements RewardAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.tianmu.a.h f3820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ADSuyiBidAdapterCallback f3821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3822f;

    public o(String str, ADSuyiRewardVodAdListener aDSuyiRewardVodAdListener, ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        super(str, aDSuyiRewardVodAdListener);
        this.f3821e = aDSuyiBidAdapterCallback;
    }

    public void a() {
        this.f3822f = true;
        if (getAdListener() == 0 || this.f3820d == null) {
            return;
        }
        ((ADSuyiRewardVodAdListener) getAdListener()).onAdReceive(this.f3820d);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onAdClose(RewardAdInfo rewardAdInfo) {
        if (getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) getAdListener()).onAdClose(this.f3820d);
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onAdExpose(RewardAdInfo rewardAdInfo) {
        if (getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) getAdListener()).onAdExpose(this.f3820d);
        }
    }

    @Override // com.tianmu.ad.listener.AdInfoListener
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onAdReceive(RewardAdInfo rewardAdInfo) {
        if (getAdListener() != 0) {
            if (rewardAdInfo == null) {
                ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3821e;
                if (aDSuyiBidAdapterCallback != null) {
                    aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(-1, "RewardAdInfo is null").toString());
                    return;
                } else {
                    super.onAdFailed(-1, "激励视频广告对象不存在");
                    return;
                }
            }
            cn.admobiletop.adsuyi.adapter.tianmu.a.h hVar = new cn.admobiletop.adsuyi.adapter.tianmu.a.h(getPlatformPosId());
            this.f3820d = hVar;
            hVar.setAdapterAdInfo(rewardAdInfo);
            if (this.f3821e == null) {
                a();
            } else if (rewardAdInfo.getBidPrice() <= 0) {
                this.f3821e.onFailed("tianmu", new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION, ADSuyiErrorConfig.MSG_AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION).toString());
            } else {
                this.f3821e.onSuccess(new s(rewardAdInfo, rewardAdInfo.getBidPrice()));
            }
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3821e;
        if (aDSuyiBidAdapterCallback != null && !this.f3822f) {
            aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(tianmuError == null ? ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY : tianmuError.getCode(), tianmuError == null ? "返回的广告数据为空" : tianmuError.getError()).toString());
        } else if (tianmuError != null) {
            super.onAdFailed(tianmuError.getCode(), tianmuError.getError());
        }
    }

    @Override // com.tianmu.ad.listener.RewardAdListener
    public void onAdReward(RewardAdInfo rewardAdInfo) {
        if (getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) getAdListener()).onReward(this.f3820d);
        }
    }

    @Override // com.tianmu.ad.listener.RewardAdListener
    public void onVideoCompleted(RewardAdInfo rewardAdInfo) {
        if (getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) getAdListener()).onVideoComplete(this.f3820d);
        }
    }

    @Override // com.tianmu.ad.listener.RewardAdListener
    public void onVideoError(RewardAdInfo rewardAdInfo, String str) {
        if (getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) getAdListener()).onVideoError(this.f3820d, new ADSuyiError(-1, str));
        }
    }

    @Override // com.tianmu.ad.listener.RewardAdListener
    public void onVideoSkip(RewardAdInfo rewardAdInfo) {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        cn.admobiletop.adsuyi.adapter.tianmu.a.h hVar = this.f3820d;
        if (hVar != null) {
            hVar.release();
            this.f3820d = null;
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdClick(RewardAdInfo rewardAdInfo) {
        if (getAdListener() != 0) {
            ((ADSuyiRewardVodAdListener) getAdListener()).onAdClick(this.f3820d);
        }
    }
}
