package com.bytedance.sdk.openadsdk.mediation.custom;

import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: classes.dex */
public class MediationCustomInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6426a;
    private String bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f6427h;
    private String k;
    private String kf;
    private String n;
    private String ok;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f6428q;
    private String r;
    private String s;

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.bl = str;
        this.ok = str2;
        this.f6426a = str3;
        this.s = str4;
        this.n = str5;
        this.kf = str6;
        this.f6427h = str7;
        this.p = str8;
        this.f6428q = str9;
        this.k = str10;
        this.r = str11;
    }

    public String getADNName() {
        return this.bl;
    }

    public String getAdnInitClassName() {
        return this.s;
    }

    public String getAppId() {
        return this.ok;
    }

    public String getAppKey() {
        return this.f6426a;
    }

    public String getBannerClassName() {
        return this.n;
    }

    public String getDrawClassName() {
        return this.r;
    }

    public String getFeedClassName() {
        return this.k;
    }

    public String getFullVideoClassName() {
        return this.p;
    }

    public String getInterstitialClassName() {
        return this.kf;
    }

    public String getRewardClassName() {
        return this.f6427h;
    }

    public String getSplashClassName() {
        return this.f6428q;
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.ok + "', mAppKey='" + this.f6426a + "', mADNName='" + this.bl + "', mAdnInitClassName='" + this.s + "', mBannerClassName='" + this.n + "', mInterstitialClassName='" + this.kf + "', mRewardClassName='" + this.f6427h + "', mFullVideoClassName='" + this.p + "', mSplashClassName='" + this.f6428q + "', mFeedClassName='" + this.k + "', mDrawClassName='" + this.r + "'}";
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.bl = valueSet.stringValue(8003);
            this.ok = valueSet.stringValue(8534);
            this.f6426a = valueSet.stringValue(8535);
            this.s = valueSet.stringValue(8536);
            this.n = valueSet.stringValue(8537);
            this.kf = valueSet.stringValue(8538);
            this.f6427h = valueSet.stringValue(8539);
            this.p = valueSet.stringValue(8540);
            this.f6428q = valueSet.stringValue(8541);
            this.k = valueSet.stringValue(8542);
            this.r = valueSet.stringValue(8543);
        }
    }
}
