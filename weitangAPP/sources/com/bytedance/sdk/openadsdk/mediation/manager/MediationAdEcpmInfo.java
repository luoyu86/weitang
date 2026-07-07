package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediationAdEcpmInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6438a;
    private String bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f6439h;
    private String j;
    private String k;
    private int kf;
    private String n;
    private String ok;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f6440q;
    private String r;
    private String rh;
    private String s;
    private Map<String, String> t;
    private String z;

    public MediationAdEcpmInfo() {
        this.t = new HashMap();
    }

    public String getAbTestId() {
        return this.z;
    }

    public String getChannel() {
        return this.r;
    }

    public Map<String, String> getCustomData() {
        return this.t;
    }

    public String getCustomSdkName() {
        return this.f6438a;
    }

    public String getEcpm() {
        return this.n;
    }

    public String getErrorMsg() {
        return this.f6439h;
    }

    public String getLevelTag() {
        return this.s;
    }

    public int getReqBiddingType() {
        return this.kf;
    }

    public String getRequestId() {
        return this.p;
    }

    public String getRitType() {
        return this.f6440q;
    }

    public String getScenarioId() {
        return this.rh;
    }

    public String getSdkName() {
        return this.ok;
    }

    public String getSegmentId() {
        return this.k;
    }

    public String getSlotId() {
        return this.bl;
    }

    public String getSubChannel() {
        return this.j;
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Map<String, String> map) {
        HashMap map2 = new HashMap();
        this.t = map2;
        this.ok = str;
        this.f6438a = str2;
        this.bl = str3;
        this.s = str4;
        this.n = str5;
        this.kf = i2;
        this.f6439h = str6;
        this.p = str7;
        this.f6440q = str8;
        this.k = str9;
        this.r = str10;
        this.j = str11;
        this.z = str12;
        this.rh = str13;
        if (map != null) {
            this.t = map;
        } else {
            map2.clear();
        }
    }
}
