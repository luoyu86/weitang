package cn.admobiletop.adsuyi.adapter.tianmu.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.tianmu.ad.bean.NativeExpressAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.NativeExpressAdListener;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n extends b<ADSuyiNativeAdListener> implements NativeExpressAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ADSuyiNativeAdInfo> f3817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ADSuyiBidAdapterCallback f3818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f3819g;

    public n(String str, String str2, ADSuyiNativeAdListener aDSuyiNativeAdListener, ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        super(str2, aDSuyiNativeAdListener);
        this.f3819g = new Handler(Looper.getMainLooper());
        this.f3816d = str;
        this.f3818f = aDSuyiBidAdapterCallback;
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onAdClose(NativeExpressAdInfo nativeExpressAdInfo) {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (getAdListener() == 0 || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3817e, nativeExpressAdInfo)) == null) {
            return;
        }
        ((ADSuyiNativeAdListener) getAdListener()).onAdClose(aDSuyiNativeAdInfo);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onAdExpose(NativeExpressAdInfo nativeExpressAdInfo) {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (getAdListener() == 0 || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3817e, nativeExpressAdInfo)) == null) {
            return;
        }
        ((ADSuyiNativeAdListener) getAdListener()).onAdExpose(aDSuyiNativeAdInfo);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3818f;
        if (aDSuyiBidAdapterCallback != null) {
            aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(tianmuError == null ? ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY : tianmuError.getCode(), tianmuError == null ? "返回的广告数据为空" : tianmuError.getError()).toString());
        } else if (tianmuError != null) {
            onAdFailed(tianmuError.getCode(), tianmuError.getError());
        }
    }

    @Override // com.tianmu.ad.listener.AdInfoListListener
    public void onAdReceive(List<NativeExpressAdInfo> list) {
        if (list == null || list.isEmpty()) {
            ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3818f;
            if (aDSuyiBidAdapterCallback != null) {
                aDSuyiBidAdapterCallback.onFailed("tianmu", new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空").toString());
                return;
            } else {
                onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
                return;
            }
        }
        if (getAdListener() != 0) {
            this.f3817e = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                NativeExpressAdInfo nativeExpressAdInfo = list.get(i2);
                if (nativeExpressAdInfo != null) {
                    cn.admobiletop.adsuyi.adapter.tianmu.a.f fVar = new cn.admobiletop.adsuyi.adapter.tianmu.a.f(this.f3816d, getPlatformPosId());
                    fVar.setAdapterAdInfo(nativeExpressAdInfo);
                    fVar.setAdListener(getAdListener());
                    this.f3817e.add(fVar);
                }
            }
            if (this.f3818f == null) {
                a();
            } else if (list.get(0).getBidPrice() <= 0) {
                this.f3818f.onFailed("tianmu", new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION, ADSuyiErrorConfig.MSG_AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION).toString());
            } else {
                this.f3818f.onSuccess(new s(list.get(0), list.get(0).getBidPrice()));
            }
        }
    }

    @Override // com.tianmu.ad.listener.NativeExpressAdListener
    public void onRenderFailed(NativeExpressAdInfo nativeExpressAdInfo, TianmuError tianmuError) {
        Handler handler = this.f3819g;
        if (handler != null) {
            handler.post(new m(this, nativeExpressAdInfo, tianmuError));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        ADSuyiAdUtil.releaseList(this.f3817e);
        this.f3817e = null;
        Handler handler = this.f3819g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3819g = null;
        }
    }

    public void a() {
        if (getAdListener() != 0) {
            ((ADSuyiNativeAdListener) getAdListener()).onAdReceive(this.f3817e);
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdClick(NativeExpressAdInfo nativeExpressAdInfo) {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (getAdListener() == 0 || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3817e, nativeExpressAdInfo)) == null) {
            return;
        }
        ((ADSuyiNativeAdListener) getAdListener()).onAdClick(aDSuyiNativeAdInfo);
    }
}
