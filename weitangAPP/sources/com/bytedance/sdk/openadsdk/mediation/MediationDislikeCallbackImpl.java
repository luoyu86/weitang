package com.bytedance.sdk.openadsdk.mediation;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;

/* JADX INFO: loaded from: classes.dex */
public class MediationDislikeCallbackImpl implements Bridge, IMediationDislikeCallback {
    private IMediationDislikeCallback ok;

    public MediationDislikeCallbackImpl(IMediationDislikeCallback iMediationDislikeCallback) {
        this.ok = iMediationDislikeCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 8188) {
            onSelected(valueSet.intValue(8038), valueSet.stringValue(8039));
            return null;
        }
        if (i2 == 8189) {
            onCancel();
            return null;
        }
        if (i2 != 8190) {
            return null;
        }
        onShow();
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i2, String str) {
        IMediationDislikeCallback iMediationDislikeCallback = this.ok;
        if (iMediationDislikeCallback != null) {
            iMediationDislikeCallback.onSelected(i2, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
