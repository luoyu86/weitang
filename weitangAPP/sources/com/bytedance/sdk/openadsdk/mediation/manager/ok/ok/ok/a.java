package com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;

/* JADX INFO: loaded from: classes.dex */
public class a implements MediationAdLoadInfo {
    private final Bridge ok;

    public a(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdType() {
        return (String) this.ok.values().objectValue(271003, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getAdnName() {
        return (String) this.ok.values().objectValue(271002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public int getErrCode() {
        return this.ok.values().intValue(271004);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getErrMsg() {
        return (String) this.ok.values().objectValue(271005, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo
    public String getMediationRit() {
        return (String) this.ok.values().objectValue(271001, String.class);
    }
}
