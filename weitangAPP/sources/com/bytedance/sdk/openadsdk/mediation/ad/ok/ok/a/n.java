package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;

/* JADX INFO: loaded from: classes.dex */
public class n implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IMediationViewBinder f6414a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public n(IMediationViewBinder iMediationViewBinder) {
        this.f6414a = iMediationViewBinder;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        IMediationViewBinder iMediationViewBinder = this.f6414a;
        if (iMediationViewBinder == null) {
            return null;
        }
        switch (i2) {
            case 271021:
                break;
            case 271022:
                break;
            case 271023:
                break;
            case 271024:
                break;
            case 271025:
                break;
            case 271026:
                break;
            case 271027:
                break;
            case 271028:
                break;
            case 271029:
                break;
            case 271030:
                break;
            case 271031:
                break;
            case 271032:
                break;
            case 271033:
                break;
            case 271034:
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
