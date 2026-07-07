package cn.admobiletop.adsuyi.adapter.tianmu.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiSplashAdContainer;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import com.tianmu.ad.bean.SplashAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.SplashAdListener;

/* JADX INFO: loaded from: classes.dex */
public class q extends b<ADSuyiSplashAdListener> implements SplashAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiSplashAdContainer f3825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.tianmu.a.g f3826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ADSuyiBidAdapterCallback f3827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f3829h;

    public q(String str, ADSuyiSplashAdListener aDSuyiSplashAdListener, ADSuyiSplashAdContainer aDSuyiSplashAdContainer, ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        super(str, aDSuyiSplashAdListener);
        this.f3829h = new Handler(Looper.getMainLooper());
        this.f3825d = aDSuyiSplashAdContainer;
        this.f3827f = aDSuyiBidAdapterCallback;
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onAdClose(SplashAdInfo splashAdInfo) {
        if (getAdListener() == 0 || this.f3826e == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdClose(this.f3826e);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onAdExpose(SplashAdInfo splashAdInfo) {
        if (getAdListener() == 0 || this.f3826e == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdExpose(this.f3826e);
    }

    @Override // com.tianmu.ad.listener.AdInfoListener
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onAdReceive(SplashAdInfo splashAdInfo) {
        if (getAdListener() == 0 || this.f3825d == null) {
            return;
        }
        if (splashAdInfo == null) {
            ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3827f;
            if (aDSuyiBidAdapterCallback != null) {
                aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(-1, "SplashAdInfo is null").toString());
                return;
            } else {
                super.onAdFailed(-1, "开屏广告对象不存在");
                return;
            }
        }
        cn.admobiletop.adsuyi.adapter.tianmu.a.g gVar = new cn.admobiletop.adsuyi.adapter.tianmu.a.g(getPlatformPosId());
        this.f3826e = gVar;
        gVar.setAdapterAdInfo(splashAdInfo);
        this.f3825d.setSplashAdListener((ADSuyiSplashAdListener) getAdListener());
        if (this.f3827f == null) {
            a();
        } else if (splashAdInfo.getBidPrice() <= 0) {
            this.f3827f.onFailed("tianmu", new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION, ADSuyiErrorConfig.MSG_AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION).toString());
        } else {
            this.f3827f.onSuccess(new s(splashAdInfo, splashAdInfo.getBidPrice()));
        }
    }

    @Override // com.tianmu.ad.listener.AdInfoSkipListener
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onAdSkip(SplashAdInfo splashAdInfo) {
        if (getAdListener() == 0 || this.f3826e == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdSkip(this.f3826e);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        Handler handler;
        ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3827f;
        if (aDSuyiBidAdapterCallback != null && !this.f3828g) {
            aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(tianmuError == null ? ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY : tianmuError.getCode(), tianmuError == null ? "返回的广告数据为空" : tianmuError.getError()).toString());
        } else if (!this.f3828g || (handler = this.f3829h) == null) {
            onAdFailed(tianmuError.getCode(), tianmuError.getError());
        } else {
            handler.post(new p(this, tianmuError));
        }
    }

    @Override // com.tianmu.ad.listener.SplashAdListener
    public void onAdTick(long j) {
        if (getAdListener() == 0 || this.f3826e == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onADTick(j);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        cn.admobiletop.adsuyi.adapter.tianmu.a.g gVar = this.f3826e;
        if (gVar != null) {
            gVar.release();
            this.f3826e = null;
        }
        Handler handler = this.f3829h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3829h = null;
        }
    }

    public void a() {
        this.f3828g = true;
        if (getAdListener() == 0 || this.f3826e == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdReceive(this.f3826e);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdClick(SplashAdInfo splashAdInfo) {
        if (getAdListener() == 0 || this.f3826e == null) {
            return;
        }
        ((ADSuyiSplashAdListener) getAdListener()).onAdClick(this.f3826e);
    }
}
