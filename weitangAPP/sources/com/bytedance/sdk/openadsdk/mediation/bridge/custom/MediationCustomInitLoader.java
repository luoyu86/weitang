package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.IMediationInit;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediationCustomInitLoader implements IMediationInit {
    private Bridge ok;

    private void ok() {
        if (this.ok != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8402, this);
            this.ok.call(8216, mediationValueSetBuilderCreate.build(), String.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 8240) {
            initAdn((Context) valueSet.objectValue(8009, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        } else {
            if (i2 == 8139) {
                return (T) getBiddingToken((Context) valueSet.objectValue(8009, Context.class), (Map) valueSet.objectValue(8075, Map.class));
            }
            if (i2 == 8217) {
                return (T) getSdkInfo((Context) valueSet.objectValue(8009, Context.class), (Map) valueSet.objectValue(8075, Map.class));
            }
            if (i2 == 8218) {
                return (T) getNetworkSdkVersion();
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public final void callInitSuccess() {
        Bridge bridge = this.ok;
        if (bridge != null) {
            bridge.call(8219, null, String.class);
        }
    }

    public String getBiddingToken(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract String getNetworkSdkVersion();

    public String getSdkInfo(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.IMediationInit
    public final void initAdn(Context context, ValueSet valueSet) {
        MediationInitConfig mediationInitConfigCreate = MediationInitConfig.create(valueSet);
        initInnerADN(context, new MediationCustomInitConfig(mediationInitConfigCreate.getCustomInitConfigValueSet()), mediationInitConfigCreate.getCustomInitMap(), mediationInitConfigCreate.getCustomGMConfiguration());
    }

    public final void initInnerADN(Context context, MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map, Bridge bridge) {
        this.ok = bridge;
        ok();
        try {
            initializeADN(context, mediationCustomInitConfig, map);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public abstract void initializeADN(Context context, MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map);

    public final boolean isInit() {
        Bridge bridge = this.ok;
        if (bridge != null) {
            return ((Boolean) bridge.call(8220, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
