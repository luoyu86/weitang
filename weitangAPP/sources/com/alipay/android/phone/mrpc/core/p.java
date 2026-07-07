package com.alipay.android.phone.mrpc.core;

/* JADX INFO: loaded from: classes.dex */
public final class p extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f5108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HttpUrlHeader f5111h;

    public p(HttpUrlHeader httpUrlHeader, int i2, String str, byte[] bArr) {
        this.f5111h = httpUrlHeader;
        this.f5106c = i2;
        this.f5107d = str;
        this.f5125a = bArr;
    }

    public final HttpUrlHeader a() {
        return this.f5111h;
    }

    public final void a(long j) {
        this.f5108e = j;
    }

    public final void a(String str) {
        this.f5110g = str;
    }

    public final void b(long j) {
        this.f5109f = j;
    }
}
