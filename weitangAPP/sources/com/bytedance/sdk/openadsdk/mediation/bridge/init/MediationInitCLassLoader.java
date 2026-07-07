package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;

/* JADX INFO: loaded from: classes.dex */
public class MediationInitCLassLoader implements Bridge {
    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 8100) {
            MediationInitConfig mediationInitConfigCreate = MediationInitConfig.create(valueSet);
            try {
                Object objNewInstance = ((!mediationInitConfigCreate.isCustom() || mediationInitConfigCreate.getCustomInitConfigValueSet() == null) ? Class.forName(mediationInitConfigCreate.getClassName()) : Class.forName(mediationInitConfigCreate.getCustomInitConfigValueSet().stringValue(8536))).newInstance();
                if (objNewInstance instanceof Bridge) {
                    MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
                    mediationValueSetBuilderCreate.add(8009, TTAppContextHolder.getContext());
                    mediationValueSetBuilderCreate.add(8424, valueSet);
                    ((Bridge) objNewInstance).call(8240, mediationValueSetBuilderCreate.build(), null);
                }
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InstantiationException e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
