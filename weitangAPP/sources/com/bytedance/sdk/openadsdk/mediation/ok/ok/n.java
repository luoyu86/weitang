package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* JADX INFO: loaded from: classes.dex */
public class n extends com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.ok {
    private IMediationAdSlot ok;

    public n(IMediationAdSlot iMediationAdSlot) {
        super(iMediationAdSlot);
        this.ok = iMediationAdSlot;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.ok, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.ok == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i2 == 266101) {
            return (T) new com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.bl((IMediationNativeToBannerListener) super.call(i2, null, IMediationNativeToBannerListener.class));
        }
        if (i2 != 266102) {
            return (T) super.call(i2, valueSet, cls);
        }
        IMediationSplashRequestInfo iMediationSplashRequestInfo = (IMediationSplashRequestInfo) super.call(i2, null, IMediationSplashRequestInfo.class);
        if (iMediationSplashRequestInfo != null) {
            return (T) new q(iMediationSplashRequestInfo);
        }
        return null;
    }
}
