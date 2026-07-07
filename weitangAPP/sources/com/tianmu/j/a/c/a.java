package com.tianmu.j.a.c;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12260c;

    public a(boolean z) {
        this.f12258a = z;
    }

    public void a(boolean z) {
        this.f12258a = z;
    }

    public boolean b() {
        return this.f12260c;
    }

    public boolean c() {
        return this.f12258a;
    }

    public void d() {
        this.f12259b = 0;
        this.f12260c = false;
    }

    public void e() {
        this.f12260c = true;
    }

    public int a() {
        return this.f12259b;
    }

    public void a(int i2) {
        if (i2 > 0) {
            this.f12259b = i2;
        }
    }
}
