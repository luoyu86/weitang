package com.bytedance.sdk.openadsdk.a.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.CSJSplashAd;

/* JADX INFO: loaded from: classes.dex */
public class a implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CSJSplashAd.SplashCardListener f6317a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public a(CSJSplashAd.SplashCardListener splashCardListener) {
        this.f6317a = splashCardListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        CSJSplashAd.SplashCardListener splashCardListener = this.f6317a;
        if (splashCardListener == null) {
            return null;
        }
        switch (i2) {
            case 112102:
                splashCardListener.onSplashCardClick();
                break;
            case 112103:
                splashCardListener.onSplashCardClose();
                break;
            case 121201:
                this.f6317a.onSplashCardReadyToShow(new com.bytedance.sdk.openadsdk.bl.ok.ok.a((Bridge) valueSet.objectValue(0, Bridge.class)));
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
