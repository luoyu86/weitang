package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo;

/* JADX INFO: loaded from: classes.dex */
public class s implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IMediationSplashRequestInfo f6416a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public s(IMediationSplashRequestInfo iMediationSplashRequestInfo) {
        this.f6416a = iMediationSplashRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        IMediationSplashRequestInfo iMediationSplashRequestInfo = this.f6416a;
        if (iMediationSplashRequestInfo == null) {
            return null;
        }
        switch (i2) {
            case 267001:
                break;
            case 267002:
                break;
            case 267003:
                break;
            case 267004:
                break;
            default:
                ok(i2, valueSet, cls);
                break;
        }
        return null;
    }

    public void ok(int i2, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
