package com.bytedance.sdk.openadsdk.bl.ok.bl;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;

/* JADX INFO: loaded from: classes.dex */
public class ok {
    public static final ValueSet ok(final AdConfig adConfig) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok();
        if (adConfig == null) {
            return null;
        }
        aVarOk.ok(261001, adConfig.getAppId());
        aVarOk.ok(261002, adConfig.getAppName());
        aVarOk.ok(261003, adConfig.isPaid());
        aVarOk.ok(261004, adConfig.getKeywords());
        aVarOk.ok(261005, adConfig.getData());
        aVarOk.ok(261006, adConfig.getTitleBarTheme());
        aVarOk.ok(261007, adConfig.isAllowShowNotify());
        aVarOk.ok(261008, adConfig.isDebug());
        aVarOk.ok(261009, adConfig.getDirectDownloadNetworkType());
        aVarOk.ok(261010, adConfig.isUseTextureView());
        aVarOk.ok(261011, adConfig.isSupportMultiProcess());
        aVarOk.ok(261012, adConfig.getCustomController() != null ? s.ok(adConfig.getCustomController()) : null);
        aVarOk.ok(261013, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.ok.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getPluginUpdateConfig());
            }
        });
        aVarOk.ok(261014, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.ok.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getAgeGroup());
            }
        });
        aVarOk.ok(261015, new ValueSet.ValueGetter<Integer>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.ok.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(adConfig.getThemeStatus());
            }
        });
        aVarOk.ok(261016, adConfig.getMediationConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.ok(adConfig.getMediationConfig()) : null);
        aVarOk.ok(261017, adConfig.isUseMediation());
        return aVarOk.a();
    }
}
