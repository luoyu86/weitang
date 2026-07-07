package com.alipay.sdk.m.i0;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5375c = System.currentTimeMillis() + 86400000;

    public d(String str, int i2) {
        this.f5373a = str;
        this.f5374b = i2;
    }

    public String toString() {
        return "ValueData{value='" + this.f5373a + "', code=" + this.f5374b + ", expired=" + this.f5375c + '}';
    }
}
