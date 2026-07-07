package com.bytedance.sdk.openadsdk.z.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* JADX INFO: loaded from: classes.dex */
public class a implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTRewardVideoAd.RewardAdPlayAgainController f6457a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public a(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        this.f6457a = rewardAdPlayAgainController;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6457a == null) {
            return null;
        }
        if (i2 == 122101) {
            this.f6457a.getPlayAgainCondition(valueSet.intValue(0), new com.bytedance.sdk.openadsdk.s.ok.ok.ok.ok.ok((Bridge) valueSet.objectValue(1, Bridge.class)));
        }
        ok(i2, valueSet, cls);
        return null;
    }

    public void ok(int i2, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
