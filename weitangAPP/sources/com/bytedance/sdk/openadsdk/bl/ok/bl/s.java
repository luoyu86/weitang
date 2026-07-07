package com.bytedance.sdk.openadsdk.bl.ok.bl;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTCustomController;

/* JADX INFO: loaded from: classes.dex */
public class s {
    public static final ValueSet ok(final TTCustomController tTCustomController) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok();
        if (tTCustomController == null) {
            return null;
        }
        aVarOk.ok(262101, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUseLocation());
            }
        });
        aVarOk.ok(262102, new ValueSet.ValueGetter<ValueSet>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public ValueSet get() {
                return bl.ok(tTCustomController.getTTLocation());
            }
        });
        aVarOk.ok(262103, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.alist());
            }
        });
        aVarOk.ok(262104, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUsePhoneState());
            }
        });
        aVarOk.ok(262105, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tTCustomController.getDevImei();
            }
        });
        aVarOk.ok(262106, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUseWifiState());
            }
        });
        aVarOk.ok(262107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tTCustomController.getMacAddress();
            }
        });
        aVarOk.ok(262108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.11
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUseWriteExternal());
            }
        });
        aVarOk.ok(262109, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.12
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tTCustomController.getDevOaid();
            }
        });
        aVarOk.ok(262110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUseAndroidId());
            }
        });
        aVarOk.ok(262113, tTCustomController.getMediationPrivacyConfig() != null ? com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.a.ok(tTCustomController.getMediationPrivacyConfig()) : null);
        aVarOk.ok(262112, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public String get() {
                return tTCustomController.getAndroidId();
            }
        });
        aVarOk.ok(262111, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.bl.ok.bl.s.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(tTCustomController.isCanUsePermissionRecordAudio());
            }
        });
        return aVarOk.a();
    }
}
