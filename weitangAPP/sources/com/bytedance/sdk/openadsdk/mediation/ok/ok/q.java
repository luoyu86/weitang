package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* JADX INFO: loaded from: classes.dex */
public class q extends com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.s {
    private IMediationSplashRequestInfo ok;

    public q(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        super(iMediationSplashRequestInfo);
        this.ok = iMediationSplashRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.s, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        String adnName = "";
        switch (i2) {
            case 267001:
                IMediationSplashRequestInfo iMediationSplashRequestInfo = this.ok;
                if (iMediationSplashRequestInfo != null && iMediationSplashRequestInfo.getAdnName() != null) {
                    adnName = this.ok.getAdnName();
                }
                return (T) String.valueOf(adnName);
            case 267002:
                IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.ok;
                if (iMediationSplashRequestInfo2 != null && iMediationSplashRequestInfo2.getAdnSlotId() != null) {
                    adnName = this.ok.getAdnSlotId();
                }
                return (T) String.valueOf(adnName);
            case 267003:
                IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.ok;
                if (iMediationSplashRequestInfo3 != null && iMediationSplashRequestInfo3.getAppId() != null) {
                    adnName = this.ok.getAppId();
                }
                return (T) String.valueOf(adnName);
            case 267004:
                IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.ok;
                if (iMediationSplashRequestInfo4 != null && iMediationSplashRequestInfo4.getAppkey() != null) {
                    adnName = this.ok.getAppkey();
                }
                return (T) String.valueOf(adnName);
            default:
                return (T) super.call(i2, valueSet, cls);
        }
    }
}
