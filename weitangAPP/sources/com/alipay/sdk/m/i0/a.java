package com.alipay.sdk.m.i0;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5368d;

    public a(String str) {
        this.f5367c = str;
    }

    public void a(int i2) {
        this.f5368d = i2;
    }

    public void a(long j) {
        this.f5365a = j;
    }

    public void a(String str) {
        this.f5366b = str;
    }

    public boolean a() {
        return this.f5365a > System.currentTimeMillis();
    }

    public void b() {
        this.f5365a = 0L;
    }
}
