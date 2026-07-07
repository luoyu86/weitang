package com.bytedance.sdk.openadsdk.a.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CSJSplashAd.SplashAdListener f6319a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public ok(CSJSplashAd.SplashAdListener splashAdListener) {
        this.f6319a = splashAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6319a == null) {
            return null;
        }
        switch (i2) {
            case 111101:
                this.f6319a.onSplashAdShow(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 111102:
                this.f6319a.onSplashAdClick(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 111103:
                this.f6319a.onSplashAdClose(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)), valueSet.intValue(1));
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
