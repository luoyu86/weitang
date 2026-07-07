package com.bytedance.sdk.openadsdk.bl.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTAdInteractionListener f6356a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public ok(TTAdInteractionListener tTAdInteractionListener) {
        this.f6356a = tTAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6356a == null) {
            return null;
        }
        if (i2 == 100101) {
            this.f6356a.onAdEvent(valueSet.intValue(0), (Map) valueSet.objectValue(1, Map.class));
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
