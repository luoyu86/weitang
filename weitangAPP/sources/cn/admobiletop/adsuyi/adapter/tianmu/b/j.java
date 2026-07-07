package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.InterstitialAdListener;

/* JADX INFO: loaded from: classes.dex */
public class j extends b<ADSuyiInterstitialAdListener> implements InterstitialAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.tianmu.a.d f3803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ADSuyiBidAdapterCallback f3804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3805f;

    public j(String str, ADSuyiInterstitialAdListener aDSuyiInterstitialAdListener, ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        super(str, aDSuyiInterstitialAdListener);
        this.f3804e = aDSuyiBidAdapterCallback;
    }

    public void a() {
        this.f3805f = true;
        if (getAdListener() == 0 || this.f3803d == null) {
            return;
        }
        ((ADSuyiInterstitialAdListener) getAdListener()).onAdReceive(this.f3803d);
        ((ADSuyiInterstitialAdListener) getAdListener()).onAdReady(this.f3803d);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onAdClose(InterstitialAdInfo interstitialAdInfo) {
        if (getAdListener() == 0 || this.f3803d == null) {
            return;
        }
        ((ADSuyiInterstitialAdListener) getAdListener()).onAdClose(this.f3803d);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onAdExpose(InterstitialAdInfo interstitialAdInfo) {
        if (getAdListener() == 0 || this.f3803d == null) {
            return;
        }
        ((ADSuyiInterstitialAdListener) getAdListener()).onAdExpose(this.f3803d);
    }

    @Override // com.tianmu.ad.listener.AdInfoListener
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onAdReceive(InterstitialAdInfo interstitialAdInfo) {
        if (getAdListener() != 0) {
            if (interstitialAdInfo == null) {
                ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3804e;
                if (aDSuyiBidAdapterCallback != null) {
                    aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(-1, "InterstitialAdInfo is null").toString());
                    return;
                } else {
                    super.onAdFailed(-1, "插屏广告对象不存在");
                    return;
                }
            }
            cn.admobiletop.adsuyi.adapter.tianmu.a.d dVar = new cn.admobiletop.adsuyi.adapter.tianmu.a.d(getPlatformPosId());
            this.f3803d = dVar;
            dVar.setAdapterAdInfo(interstitialAdInfo);
            if (this.f3804e == null) {
                a();
            } else if (interstitialAdInfo.getBidPrice() <= 0) {
                this.f3804e.onFailed("tianmu", new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION, ADSuyiErrorConfig.MSG_AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION).toString());
            } else {
                this.f3804e.onSuccess(new s(interstitialAdInfo, interstitialAdInfo.getBidPrice()));
            }
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3804e;
        if (aDSuyiBidAdapterCallback != null && !this.f3805f) {
            aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(tianmuError == null ? ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY : tianmuError.getCode(), tianmuError == null ? "返回的广告数据为空" : tianmuError.getError()).toString());
        } else if (tianmuError != null) {
            super.onAdFailed(tianmuError.getCode(), tianmuError.getError());
        }
    }

    @Override // com.tianmu.ad.listener.InterstitialAdListener
    public void onVideoError(InterstitialAdInfo interstitialAdInfo) {
    }

    @Override // com.tianmu.ad.listener.InterstitialAdListener
    public void onVideoFinish(InterstitialAdInfo interstitialAdInfo) {
    }

    @Override // com.tianmu.ad.listener.InterstitialAdListener
    public void onVideoPause(InterstitialAdInfo interstitialAdInfo) {
    }

    @Override // com.tianmu.ad.listener.InterstitialAdListener
    public void onVideoStart(InterstitialAdInfo interstitialAdInfo) {
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdClick(InterstitialAdInfo interstitialAdInfo) {
        if (getAdListener() == 0 || this.f3803d == null) {
            return;
        }
        ((ADSuyiInterstitialAdListener) getAdListener()).onAdClick(this.f3803d);
    }
}
