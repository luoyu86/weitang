package com.tianmu.c.o;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {
    private boolean n;
    private boolean o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f11933q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;

    public void a(List<String> list) {
        if (this.f11933q) {
            return;
        }
        a(list, 0, false);
        this.f11933q = true;
    }

    public void b(List<String> list, int i2) {
        if (this.o) {
            return;
        }
        a(list, i2, true);
        this.o = true;
    }

    public void c(List<String> list) {
        if (this.n || list == null || list.size() <= 0) {
            return;
        }
        a(list, 0, false);
        this.n = true;
    }

    public void d(List<String> list) {
        if (this.p) {
            return;
        }
        a(list, false);
        this.p = true;
    }

    public void e(List<String> list) {
        a(list, false);
    }

    public void f(List<String> list) {
        if (this.u) {
            return;
        }
        a(list, 0, false);
        this.u = true;
    }

    public void g(List<String> list, int i2) {
        if (this.w) {
            return;
        }
        a(list, i2, false);
        this.w = true;
    }

    public void e(List<String> list, int i2) {
        if (this.t) {
            return;
        }
        a(list, i2, false);
        this.t = true;
    }

    public void a(List<String> list, int i2) {
        if (this.x) {
            return;
        }
        a(list, i2, false);
        this.x = true;
    }

    public void b(List<String> list) {
        a(list, false);
    }

    public void c(List<String> list, int i2) {
        if (this.s) {
            return;
        }
        a(list, i2, false);
        this.s = true;
    }

    public void d(List<String> list, int i2) {
        if (this.v) {
            return;
        }
        a(list, i2, false);
        this.v = true;
    }

    public void f(List<String> list, int i2) {
        if (this.r) {
            return;
        }
        a(list, i2, false);
        this.r = true;
    }
}
