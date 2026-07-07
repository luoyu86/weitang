package com.bytedance.sdk.openadsdk.z.ok.ok.ok;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTRewardVideoAd.RewardAdInteractionListener f6458a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public ok(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        this.f6458a = rewardAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = this.f6458a;
        if (rewardAdInteractionListener == null) {
            return null;
        }
        switch (i2) {
            case 121101:
                rewardAdInteractionListener.onAdShow();
                break;
            case 121102:
                rewardAdInteractionListener.onAdVideoBarClick();
                break;
            case 121103:
                rewardAdInteractionListener.onAdClose();
                break;
            case 121104:
                rewardAdInteractionListener.onVideoComplete();
                break;
            case 121105:
                rewardAdInteractionListener.onVideoError();
                break;
            case 121106:
                this.f6458a.onRewardVerify(valueSet.booleanValue(0), valueSet.intValue(1), (String) valueSet.objectValue(2, String.class), valueSet.intValue(3), (String) valueSet.objectValue(4, String.class));
                break;
            case 121107:
                this.f6458a.onRewardArrived(valueSet.booleanValue(0), valueSet.intValue(1), (Bundle) valueSet.objectValue(2, Bundle.class));
                break;
            case 121108:
                rewardAdInteractionListener.onSkippedVideo();
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
