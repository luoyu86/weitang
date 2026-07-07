package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX INFO: loaded from: classes.dex */
public class MediationLocationImpl implements Bridge {
    private IMediationLocation ok;

    public MediationLocationImpl(IMediationLocation iMediationLocation) {
        this.ok = iMediationLocation;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        IMediationLocation iMediationLocation = this.ok;
        mediationValueSetBuilderCreate.add(8481, iMediationLocation != null ? iMediationLocation.getLatitude() : 0.0d);
        IMediationLocation iMediationLocation2 = this.ok;
        mediationValueSetBuilderCreate.add(8482, iMediationLocation2 != null ? iMediationLocation2.getLongitude() : 0.0d);
        return mediationValueSetBuilderCreate.build();
    }
}
