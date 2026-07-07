package com.bytedance.sdk.openadsdk.mediation.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;

/* JADX INFO: loaded from: classes.dex */
public class bl implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IMediationNativeAdTokenCallback f6442a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public bl(IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        this.f6442a = iMediationNativeAdTokenCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6442a == null) {
            return null;
        }
        switch (i2) {
            case 270026:
                this.f6442a.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), new com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.bl((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 270027:
                this.f6442a.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
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
