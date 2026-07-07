package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationShakeViewListener;

/* JADX INFO: loaded from: classes.dex */
public class h implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationShakeViewListener f6412a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public h(MediationShakeViewListener mediationShakeViewListener) {
        this.f6412a = mediationShakeViewListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        MediationShakeViewListener mediationShakeViewListener = this.f6412a;
        if (mediationShakeViewListener == null) {
            return null;
        }
        if (i2 == 270012) {
            mediationShakeViewListener.onDismissed();
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
