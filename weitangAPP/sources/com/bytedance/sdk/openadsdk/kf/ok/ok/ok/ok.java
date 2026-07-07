package com.bytedance.sdk.openadsdk.kf.ok.ok.ok;

import c.d.a.a.a.a.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdDislike;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTAdDislike.DislikeInteractionCallback f6386a;
    private ValueSet ok = a.f918a;

    public ok(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        this.f6386a = dislikeInteractionCallback;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback = this.f6386a;
        if (dislikeInteractionCallback == null) {
            return null;
        }
        switch (i2) {
            case 244101:
                dislikeInteractionCallback.onShow();
                break;
            case 244102:
                this.f6386a.onSelected(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class), valueSet.booleanValue(2));
                break;
            case 244103:
                dislikeInteractionCallback.onCancel();
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
