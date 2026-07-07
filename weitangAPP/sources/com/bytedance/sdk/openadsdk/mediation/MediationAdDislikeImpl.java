package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX INFO: loaded from: classes.dex */
public class MediationAdDislikeImpl implements Bridge, MediationAdDislike {
    private Bridge ok;

    public MediationAdDislikeImpl(Bridge bridge) {
        this.ok = bridge;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        if (this.ok != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8317, new MediationDislikeCallbackImpl(iMediationDislikeCallback));
            this.ok.call(6085, mediationValueSetBuilderCreate.build(), null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        Bridge bridge = this.ok;
        if (bridge != null) {
            bridge.call(8184, null, null);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
