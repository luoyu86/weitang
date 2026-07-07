package com.tianmu.http.constant;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private HostnameVerifier f12207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SSLSocketFactory f12208h;

    public a(String str, String str2, String str3, long j, long j2, boolean z) {
        this.f12201a = str;
        this.f12202b = str2;
        this.f12203c = str3;
        this.f12204d = j;
        this.f12205e = j2;
        this.f12206f = z;
    }

    public String a() {
        return this.f12202b;
    }

    public String b() {
        return this.f12203c;
    }

    public long c() {
        return this.f12204d;
    }

    public String d() {
        return this.f12201a;
    }

    public HostnameVerifier e() {
        return this.f12207g;
    }

    public long f() {
        return this.f12205e;
    }

    public SSLSocketFactory g() {
        return this.f12208h;
    }

    public boolean h() {
        return this.f12206f;
    }

    public void a(long j) {
        this.f12204d = j;
    }

    public void b(long j) {
        this.f12205e = j;
    }

    public void a(HostnameVerifier hostnameVerifier) {
        this.f12207g = hostnameVerifier;
    }

    public void a(SSLSocketFactory sSLSocketFactory) {
        this.f12208h = sSLSocketFactory;
    }
}
