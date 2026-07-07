package com.bytedance.sdk.openadsdk.a.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* JADX INFO: loaded from: classes.dex */
public class bl implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CSJSplashAd.SplashClickEyeListener f6318a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public bl(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        this.f6318a = splashClickEyeListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashClickEyeListener splashClickEyeListener = this.f6318a;
        if (splashClickEyeListener == null) {
            return null;
        }
        switch (i2) {
            case 113101:
                this.f6318a.onSplashClickEyeReadyToShow(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 113102:
                splashClickEyeListener.onSplashClickEyeClick();
                break;
            case 113103:
                splashClickEyeListener.onSplashClickEyeClose();
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
