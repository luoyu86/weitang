package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* JADX INFO: loaded from: classes.dex */
public class MediationSplashRequestInfoImpl implements Bridge {
    private IMediationSplashRequestInfo ok;

    public MediationSplashRequestInfoImpl(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.ok = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo;
        if (i2 == 8530) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo2 = this.ok;
            if (iMediationSplashRequestInfo2 != null) {
                return (T) iMediationSplashRequestInfo2.getAdnName();
            }
            return null;
        }
        if (i2 == 8532) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo3 = this.ok;
            if (iMediationSplashRequestInfo3 != null) {
                return (T) iMediationSplashRequestInfo3.getAppId();
            }
            return null;
        }
        if (i2 == 8533) {
            IMediationSplashRequestInfo iMediationSplashRequestInfo4 = this.ok;
            if (iMediationSplashRequestInfo4 != null) {
                return (T) iMediationSplashRequestInfo4.getAppkey();
            }
            return null;
        }
        if (i2 != 8531 || (iMediationSplashRequestInfo = this.ok) == null) {
            return null;
        }
        return (T) iMediationSplashRequestInfo.getAdnSlotId();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
