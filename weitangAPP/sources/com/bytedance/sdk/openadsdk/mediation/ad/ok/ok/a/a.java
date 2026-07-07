package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;

/* JADX INFO: loaded from: classes.dex */
public class a implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IMediationDislikeCallback f6410a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public a(IMediationDislikeCallback iMediationDislikeCallback) {
        this.f6410a = iMediationDislikeCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        IMediationDislikeCallback iMediationDislikeCallback = this.f6410a;
        if (iMediationDislikeCallback == null) {
            return null;
        }
        switch (i2) {
            case 268013:
                this.f6410a.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 268014:
                iMediationDislikeCallback.onCancel();
                break;
            case 268015:
                iMediationDislikeCallback.onShow();
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
