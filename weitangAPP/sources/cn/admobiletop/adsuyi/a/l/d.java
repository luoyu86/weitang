package cn.admobiletop.adsuyi.a.l;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3374d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3375e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3376f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3377g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static d f3378a = new d();
    }

    public static d b() {
        return a.f3378a;
    }

    public void a(long j) {
        long jA = cn.admobiletop.adsuyi.a.m.e.a();
        if (j - jA <= 60000 && jA - j <= 10000) {
            this.f3373c = false;
            return;
        }
        this.f3373c = true;
        this.f3371a = j;
        this.f3372b = SystemClock.elapsedRealtime();
    }

    public long c() {
        return this.f3373c ? this.f3371a + (SystemClock.elapsedRealtime() - this.f3372b) : cn.admobiletop.adsuyi.a.m.e.a();
    }

    public int d() {
        return this.f3377g;
    }

    public boolean e() {
        return this.f3373c;
    }

    public void f() {
        int i2 = this.f3376f - 1;
        this.f3376f = i2;
        if (i2 < 0) {
            this.f3376f = 0;
        }
    }

    public void g() {
        int i2 = this.f3377g - 1;
        this.f3377g = i2;
        if (i2 < 0) {
            this.f3377g = 0;
        }
    }

    public d() {
        this.f3371a = 0L;
        this.f3372b = 0L;
        this.f3373c = false;
        this.f3374d = 60000L;
        this.f3375e = 10000L;
        this.f3376f = 1;
        this.f3377g = 1;
    }

    public int a() {
        return this.f3376f;
    }
}
