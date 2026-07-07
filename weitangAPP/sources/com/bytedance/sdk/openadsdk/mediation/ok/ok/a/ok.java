package com.bytedance.sdk.openadsdk.mediation.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IMediationDrawAdTokenCallback f6444a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public ok(IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        this.f6444a = iMediationDrawAdTokenCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6444a == null) {
            return null;
        }
        switch (i2) {
            case 270029:
                this.f6444a.onAdTokenLoaded((String) valueSet.objectValue(0, String.class), new com.bytedance.sdk.openadsdk.mediation.ok.ok.ok.ok((Bridge) valueSet.objectValue(1, Bridge.class)));
                break;
            case 270030:
                this.f6444a.onAdTokenLoadedFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
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
