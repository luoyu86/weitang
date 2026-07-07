package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IMediationAdSlot f6415a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public ok(IMediationAdSlot iMediationAdSlot) {
        this.f6415a = iMediationAdSlot;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        IMediationAdSlot iMediationAdSlot = this.f6415a;
        if (iMediationAdSlot == null) {
            return null;
        }
        switch (i2) {
            case 266001:
                break;
            case 266002:
                break;
            case 266003:
                break;
            case 266004:
                break;
            case 266005:
                break;
            case 266006:
                break;
            case 266007:
                break;
            case 266008:
                break;
            case 266009:
                break;
            case 266010:
                break;
            case 266011:
                break;
            case 266012:
                break;
            default:
                switch (i2) {
                    case 266101:
                        break;
                    case 266102:
                        break;
                    case 266103:
                        break;
                    case 266104:
                        break;
                    default:
                        ok(i2, valueSet, cls);
                        break;
                }
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
