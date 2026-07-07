package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;

/* JADX INFO: loaded from: classes.dex */
public class MediationNativeAppInfoImpl implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationValueSetBuilder f6423a = MediationValueSetBuilder.create();
    private MediationNativeAdAppInfo ok;

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.ok = mediationNativeAdAppInfo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.ok;
        if (mediationNativeAdAppInfo != null) {
            this.f6423a.add(8505, mediationNativeAdAppInfo.getAppName());
            this.f6423a.add(8506, this.ok.getAuthorName());
            this.f6423a.add(8507, this.ok.getPackageSizeBytes());
            this.f6423a.add(8508, this.ok.getPermissionsUrl());
            this.f6423a.add(8509, this.ok.getPermissionsMap());
            this.f6423a.add(8510, this.ok.getPrivacyAgreement());
            this.f6423a.add(8511, this.ok.getVersionName());
            this.f6423a.add(8512, this.ok.getAppInfoExtra());
        }
        return this.f6423a.build();
    }
}
