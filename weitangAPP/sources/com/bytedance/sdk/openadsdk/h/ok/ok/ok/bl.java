package com.bytedance.sdk.openadsdk.h.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.bl.ok.ok.j;

/* JADX INFO: loaded from: classes.dex */
public class bl implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTAdNative.FullScreenVideoAdListener f6377a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public bl(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.f6377a = fullScreenVideoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener = this.f6377a;
        if (fullScreenVideoAdListener == null) {
            return null;
        }
        switch (i2) {
            case 132101:
                this.f6377a.onError(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 132102:
                this.f6377a.onFullScreenVideoAdLoad(new j((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132103:
                this.f6377a.onFullScreenVideoCached(new j((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 132104:
                fullScreenVideoAdListener.onFullScreenVideoCached();
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
