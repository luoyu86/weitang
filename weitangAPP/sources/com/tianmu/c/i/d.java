package com.tianmu.c.i;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11704a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11705b;

    public int a() {
        return this.f11704a;
    }

    public boolean b() {
        return this.f11705b;
    }

    public void a(int i2) {
        this.f11704a = i2;
        if (this.f11705b || i2 != 2) {
            return;
        }
        this.f11705b = true;
    }
}
