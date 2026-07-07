package com.bytedance.sdk.openadsdk.mediation.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;

/* JADX INFO: loaded from: classes.dex */
public class s implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IMediationPreloadRequestInfo f6445a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public s(IMediationPreloadRequestInfo iMediationPreloadRequestInfo) {
        this.f6445a = iMediationPreloadRequestInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        IMediationPreloadRequestInfo iMediationPreloadRequestInfo = this.f6445a;
        if (iMediationPreloadRequestInfo == null) {
            return null;
        }
        switch (i2) {
            case 271044:
                break;
            case 271045:
                break;
            case 271046:
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
