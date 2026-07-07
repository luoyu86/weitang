package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediationNativeAdAppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6403a;
    private long bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f6404h;
    private String kf;
    private Map<String, String> n;
    private String ok;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map<String, Object> f6405q;
    private String s;

    public Map<String, Object> getAppInfoExtra() {
        return this.f6405q;
    }

    public String getAppName() {
        return this.ok;
    }

    public String getAuthorName() {
        return this.f6403a;
    }

    public String getFunctionDescUrl() {
        return this.p;
    }

    public long getPackageSizeBytes() {
        return this.bl;
    }

    public Map<String, String> getPermissionsMap() {
        return this.n;
    }

    public String getPermissionsUrl() {
        return this.s;
    }

    public String getPrivacyAgreement() {
        return this.kf;
    }

    public String getVersionName() {
        return this.f6404h;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.f6405q = map;
    }

    public void setAppName(String str) {
        this.ok = str;
    }

    public void setAuthorName(String str) {
        this.f6403a = str;
    }

    public void setFunctionDescUrl(String str) {
        this.p = str;
    }

    public void setPackageSizeBytes(long j) {
        this.bl = j;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.n = map;
    }

    public void setPermissionsUrl(String str) {
        this.s = str;
    }

    public void setPrivacyAgreement(String str) {
        this.kf = str;
    }

    public void setVersionName(String str) {
        this.f6404h = str;
    }
}
