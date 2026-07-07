package com.bytedance.sdk.openadsdk.mediation;

import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediationPrivacyConfigImpl extends MediationPrivacyConfig implements Bridge {
    private IMediationPrivacyConfig ok;

    public MediationPrivacyConfigImpl(IMediationPrivacyConfig iMediationPrivacyConfig) {
        this.ok = iMediationPrivacyConfig;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    @Nullable
    public List<String> getCustomAppList() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.ok;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.getCustomAppList();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    @Nullable
    public List<String> getCustomDevImeis() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.ok;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.getCustomDevImeis();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isCanUseOaid() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.ok;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.isCanUseOaid();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isLimitPersonalAds() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.ok;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.isLimitPersonalAds();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
    public boolean isProgrammaticRecommend() {
        IMediationPrivacyConfig iMediationPrivacyConfig = this.ok;
        if (iMediationPrivacyConfig != null) {
            return iMediationPrivacyConfig.isProgrammaticRecommend();
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationValueSetBuilder mediationValueSetBuilderCreate = MediationValueSetBuilder.create();
        mediationValueSetBuilderCreate.add(8476, getCustomAppList());
        mediationValueSetBuilderCreate.add(8477, getCustomDevImeis());
        mediationValueSetBuilderCreate.add(8478, isCanUseOaid());
        mediationValueSetBuilderCreate.add(8027, isLimitPersonalAds());
        mediationValueSetBuilderCreate.add(8028, isProgrammaticRecommend());
        return mediationValueSetBuilderCreate.build();
    }
}
