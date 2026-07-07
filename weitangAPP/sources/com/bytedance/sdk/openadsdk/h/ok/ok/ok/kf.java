package com.bytedance.sdk.openadsdk.h.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.bl.ok.ok.i;

/* JADX INFO: loaded from: classes.dex */
public class kf implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTAdNative.RewardVideoAdListener f6378a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public kf(TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this.f6378a = rewardVideoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        TTAdNative.RewardVideoAdListener rewardVideoAdListener = this.f6378a;
        if (rewardVideoAdListener == null) {
            return null;
        }
        switch (i2) {
            case 124101:
                this.f6378a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 124102:
                this.f6378a.onRewardVideoAdLoad(new i((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124103:
                this.f6378a.onRewardVideoCached(new i((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 124104:
                rewardVideoAdListener.onRewardVideoCached();
                break;
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
