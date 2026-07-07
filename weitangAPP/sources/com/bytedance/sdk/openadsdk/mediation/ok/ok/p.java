package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* JADX INFO: loaded from: classes.dex */
public class p extends com.bytedance.sdk.openadsdk.mediation.ok.ok.a.s {
    private IMediationPreloadRequestInfo ok;

    public p(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        super(iMediationPreloadRequestInfo);
        this.ok = iMediationPreloadRequestInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ok.ok.a.s, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.ok;
        if (iMediationPreloadRequestInfo == null) {
            return (T) MediationValueUtil.checkClassType(cls);
        }
        if (i2 != 271045) {
            return (T) super.call(i2, valueSet, cls);
        }
        if (iMediationPreloadRequestInfo != null) {
            return (T) ok.ok(iMediationPreloadRequestInfo.getAdSlot());
        }
        return null;
    }
}
