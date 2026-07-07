package com.ss.android.downloadlib.addownload.a;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9773a;
    private String bl;
    private int ok;

    public h(int i2) {
        this(i2, 0, null);
    }

    public String a() {
        return this.bl;
    }

    public int getType() {
        return this.ok;
    }

    public int ok() {
        return this.f9773a;
    }

    public h(int i2, int i3) {
        this(i2, i3, null);
    }

    public h(int i2, String str) {
        this(i2, 0, str);
    }

    public h(int i2, int i3, String str) {
        this.ok = i2;
        this.f9773a = i3;
        this.bl = str;
    }
}
