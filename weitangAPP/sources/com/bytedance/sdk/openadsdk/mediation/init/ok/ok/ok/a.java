package com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static final ValueSet ok(final IMediationPrivacyConfig iMediationPrivacyConfig) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok();
        if (iMediationPrivacyConfig == null) {
            return null;
        }
        aVarOk.ok(262114, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public List get() {
                return iMediationPrivacyConfig.getCustomAppList();
            }
        });
        aVarOk.ok(262115, new ValueSet.ValueGetter<List>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public List get() {
                return iMediationPrivacyConfig.getCustomDevImeis();
            }
        });
        aVarOk.ok(262116, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isCanUseOaid());
            }
        });
        aVarOk.ok(262117, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isLimitPersonalAds());
            }
        });
        aVarOk.ok(262118, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationPrivacyConfig.isProgrammaticRecommend());
            }
        });
        return aVarOk.a();
    }
}
