package cn.admobiletop.adsuyi.adapter.tianmu.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.tianmu.ad.bean.NativeAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.NativeAdListener;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l extends b<ADSuyiNativeAdListener> implements NativeAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiNativeAd f3809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ADSuyiNativeAdInfo> f3810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ADSuyiBidAdapterCallback f3811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f3812g;

    public l(ADSuyiNativeAd aDSuyiNativeAd, String str, ADSuyiNativeAdListener aDSuyiNativeAdListener, ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        super(str, aDSuyiNativeAdListener);
        this.f3812g = new Handler(Looper.getMainLooper());
        this.f3809d = aDSuyiNativeAd;
        this.f3811f = aDSuyiBidAdapterCallback;
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onAdClose(NativeAdInfo nativeAdInfo) {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (getAdListener() == 0 || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3810e, nativeAdInfo)) == null) {
            return;
        }
        ((ADSuyiNativeAdListener) getAdListener()).onAdClose(aDSuyiNativeAdInfo);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onAdExpose(NativeAdInfo nativeAdInfo) {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (getAdListener() == 0 || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3810e, nativeAdInfo)) == null) {
            return;
        }
        ((ADSuyiNativeAdListener) getAdListener()).onAdExpose(aDSuyiNativeAdInfo);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3811f;
        if (aDSuyiBidAdapterCallback != null) {
            aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(tianmuError == null ? ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY : tianmuError.getCode(), tianmuError == null ? "返回的广告数据为空" : tianmuError.getError()).toString());
        } else if (tianmuError != null) {
            onAdFailed(tianmuError.getCode(), tianmuError.getError());
        }
    }

    @Override // com.tianmu.ad.listener.AdInfoListListener
    public void onAdReceive(List<NativeAdInfo> list) {
        if (list == null || list.isEmpty()) {
            ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3811f;
            if (aDSuyiBidAdapterCallback != null) {
                aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空").toString());
                return;
            } else {
                onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
                return;
            }
        }
        if (getAdListener() == 0 || ADSuyiAdUtil.isReleased(this.f3809d)) {
            return;
        }
        this.f3810e = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            NativeAdInfo nativeAdInfo = list.get(i2);
            if (nativeAdInfo != null) {
                cn.admobiletop.adsuyi.adapter.tianmu.a.e eVar = new cn.admobiletop.adsuyi.adapter.tianmu.a.e(getPlatformPosId());
                eVar.setAdapterAdInfo(nativeAdInfo);
                eVar.setAdListener(getAdListener());
                this.f3810e.add(eVar);
            }
        }
        if (this.f3811f == null) {
            a();
        } else if (list.get(0).getBidPrice() <= 0) {
            this.f3811f.onFailed("tianmu", new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION, ADSuyiErrorConfig.MSG_AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION).toString());
        } else {
            this.f3811f.onSuccess(new s(list.get(0), list.get(0).getBidPrice()));
        }
    }

    @Override // com.tianmu.ad.listener.NativeAdListener
    public void onRenderFailed(NativeAdInfo nativeAdInfo, TianmuError tianmuError) {
        Handler handler = this.f3812g;
        if (handler != null) {
            handler.post(new k(this, nativeAdInfo, tianmuError));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f3809d = null;
        ADSuyiAdUtil.releaseList(this.f3810e);
        this.f3810e = null;
        Handler handler = this.f3812g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3812g = null;
        }
    }

    public void a() {
        if (getAdListener() != 0) {
            ((ADSuyiNativeAdListener) getAdListener()).onAdReceive(this.f3810e);
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdClick(NativeAdInfo nativeAdInfo) {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (getAdListener() == 0 || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3810e, nativeAdInfo)) == null) {
            return;
        }
        ((ADSuyiNativeAdListener) getAdListener()).onAdClick(aDSuyiNativeAdInfo);
    }
}
