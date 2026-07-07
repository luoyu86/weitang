package cn.admobiletop.adsuyi.a.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f3178c;

    public i(String str, String str2, double d2) {
        this.f3176a = str;
        this.f3177b = str2;
        this.f3178c = d2;
    }

    public String a() {
        return MediationConstant.KEY_ECPM;
    }

    public String b() {
        return "event";
    }

    public double c() {
        return this.f3178c;
    }

    public String d() {
        return this.f3176a;
    }

    public String e() {
        return this.f3177b;
    }

    public String f() {
        return "platformAdPosUniqueId";
    }

    public String toString() {
        return "ReportBidEvent{event='" + this.f3176a + "', platformAdPosUniqueId='" + this.f3177b + "', ecpm=" + this.f3178c + '}';
    }
}
