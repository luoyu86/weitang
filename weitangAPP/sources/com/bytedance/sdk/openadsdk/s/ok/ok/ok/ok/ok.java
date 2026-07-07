package com.bytedance.sdk.openadsdk.s.ok.ok.ok.ok;

import android.os.Bundle;
import c.d.a.a.a.a.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* JADX INFO: loaded from: classes.dex */
public class ok implements TTRewardVideoAd.RewardAdPlayAgainController.Callback {
    private final Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge == null ? a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdPlayAgainController.Callback
    public void onConditionReturn(Bundle bundle) {
        a aVarOk = a.ok(1);
        aVarOk.ok(0, bundle);
        this.ok.call(123101, aVarOk.a(), Void.class);
    }
}
