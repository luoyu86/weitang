package cn.admobiletop.adsuyi.ad.api;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.exception.ADSuyiInitException;

/* JADX INFO: loaded from: classes.dex */
public class TTSplashAdRequestInfo extends ADSuyiNetworkRequestInfo {
    public TTSplashAdRequestInfo(String str, String str2, String str3, int i2, int i3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            throw new ADSuyiInitException(new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_AD_FAILED_DEFAULT_AD_EMPTY, ADSuyiErrorConfig.MSG_AD_FAILED_AD_FAILED_DEFAULT_AD_EMPTY));
        }
        this.mAppId = str;
        this.mAdNetworkSlotId = str2;
        this.mPlatform = ADSuyiIniter.PLATFORM;
        this.mAdType = ADSuyiAdType.TYPE_SPLASH;
        this.mNetworkAdPosListID = Long.parseLong(str3);
        this.mDownloadTip = i2;
        this.mRenderType = i3;
    }
}
