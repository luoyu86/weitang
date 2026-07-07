package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;

/* JADX INFO: loaded from: classes.dex */
public class k implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationAdDislike f6446a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public k(MediationAdDislike mediationAdDislike) {
        this.f6446a = mediationAdDislike;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike mediationAdDislike = this.f6446a;
        if (mediationAdDislike == null) {
            return null;
        }
        switch (i2) {
            case 270032:
                mediationAdDislike.showDislikeDialog();
                break;
            case 270033:
                this.f6446a.setDislikeCallback(new kf((Bridge) valueSet.objectValue(0, Bridge.class)));
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
