package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationResultBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediationInitImpl implements IMediationInit {
    public MediationInitConfig mInitConfig;

    private void ok() {
        Bridge initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8021, this);
            initCallback.call(8266, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 8240) {
            initAdn((Context) valueSet.objectValue(8009, Context.class), (ValueSet) valueSet.objectValue(8424, ValueSet.class));
        }
        return (T) callFunction(i2, valueSet, cls);
    }

    public <T> T callFunction(int i2, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.init.IMediationInit
    public final void initAdn(Context context, ValueSet valueSet) {
        this.mInitConfig = MediationInitConfig.create(valueSet);
        ok();
        realInitAdn(context, this.mInitConfig);
    }

    public void notifyFail(int i2, String str) {
        Bridge initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            MediationResultBuilder mediationResultBuilderCreate = MediationResultBuilder.create();
            mediationResultBuilderCreate.setSuccess(false);
            mediationResultBuilderCreate.setCode(i2);
            mediationResultBuilderCreate.setMessage(str);
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8022, mediationResultBuilderCreate);
            initCallback.call(8123, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public void notifySuccess() {
        Bridge initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
            mediationValueSetBuilderCreate.add(8021, this);
            initCallback.call(8122, mediationValueSetBuilderCreate.build(), Void.class);
        }
    }

    public abstract void realInitAdn(Context context, MediationInitConfig mediationInitConfig);

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public void notifyFail(String str) {
        notifyFail(MediationConstant.ErrorCode.ADN_INIT_FAIL, str);
    }
}
