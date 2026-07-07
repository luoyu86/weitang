package com.bytedance.sdk.openadsdk.mediation.ad;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediationSplashRequestInfo implements IMediationSplashRequestInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6406a;
    private String bl;
    private String ok;
    private String s;

    public MediationSplashRequestInfo(String str, String str2, String str3, String str4) {
        this.ok = str;
        this.f6406a = str2;
        this.bl = str3;
        this.s = str4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnName() {
        return this.ok;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAdnSlotId() {
        return this.f6406a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppId() {
        return this.bl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationSplashRequestInfo
    @Nullable
    public String getAppkey() {
        return this.s;
    }
}
