package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX INFO: loaded from: classes.dex */
public class MediationTTLiveAuthCallBackImpl implements TTLiveAuthCallback {
    private Bridge ok;

    public MediationTTLiveAuthCallBackImpl(Bridge bridge) {
        this.ok = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
    public void onAuth(TTLiveToken tTLiveToken) {
        if (this.ok == null || tTLiveToken == null) {
            return;
        }
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8520, tTLiveToken.name);
        mediationValueSetBuilderCreate.add(8521, tTLiveToken.accessToken);
        mediationValueSetBuilderCreate.add(8522, tTLiveToken.openId);
        mediationValueSetBuilderCreate.add(8523, tTLiveToken.expireAt);
        mediationValueSetBuilderCreate.add(8524, tTLiveToken.refreshToken);
        this.ok.call(8527, mediationValueSetBuilderCreate.build(), null);
    }

    @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
    public void onFailed(Throwable th) {
        if (this.ok == null || th == null) {
            return;
        }
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8014, th);
        this.ok.call(8528, mediationValueSetBuilderCreate.build(), null);
    }
}
