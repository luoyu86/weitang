package cn.admobiletop.adsuyi.ad.api;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.exception.ADSuyiInitException;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes.dex */
public class BaiduSplashAdRequestInfo extends ADSuyiNetworkRequestInfo {
    public BaiduSplashAdRequestInfo(String str, String str2, String str3, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            throw new ADSuyiInitException(new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_AD_FAILED_DEFAULT_AD_EMPTY, ADSuyiErrorConfig.MSG_AD_FAILED_AD_FAILED_DEFAULT_AD_EMPTY));
        }
        this.mPlatform = MediationConstant.ADN_BAIDU;
        this.mAdType = ADSuyiAdType.TYPE_SPLASH;
        this.mRenderType = 1;
        this.mAppId = str;
        this.mAdNetworkSlotId = str2;
        this.mNetworkAdPosListID = Long.parseLong(str3);
        this.mDownloadTip = i2;
    }
}
