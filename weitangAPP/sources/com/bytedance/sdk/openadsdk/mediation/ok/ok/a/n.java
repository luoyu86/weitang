package com.bytedance.sdk.openadsdk.mediation.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;

/* JADX INFO: loaded from: classes.dex */
public class n implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationAppDialogClickListener f6443a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public n(MediationAppDialogClickListener mediationAppDialogClickListener) {
        this.f6443a = mediationAppDialogClickListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6443a == null) {
            return null;
        }
        if (i2 == 270025) {
            this.f6443a.onButtonClick(valueSet.intValue(0));
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
