package com.tianmu.c.n;

import android.os.SystemClock;
import com.tianmu.biz.utils.i0;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f11877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f11878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11881e;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static k f11882a = new k();
    }

    public static k h() {
        return b.f11882a;
    }

    public void a(long j) {
        long jA = com.tianmu.biz.utils.o.a();
        if (j - jA <= 60000 && jA - j <= 10000) {
            this.f11879c = false;
            return;
        }
        this.f11879c = true;
        this.f11877a = j;
        this.f11878b = SystemClock.elapsedRealtime();
    }

    public int b() {
        return this.f11880d;
    }

    public long c() {
        return this.f11879c ? this.f11877a + (SystemClock.elapsedRealtime() - this.f11878b) : com.tianmu.biz.utils.o.a();
    }

    public boolean d() {
        return this.f11879c;
    }

    public void e() {
        long jC = c();
        if (i0.a().b("SP_VL_TI_F_TAG") == 0) {
            i0.a().a("SP_VL_TI_F_TAG", jC / 1000);
        }
        i0.a().a("SP_VL_TI_L_TAG", jC / 1000);
    }

    public void f() {
        int i2 = this.f11881e - 1;
        this.f11881e = i2;
        if (i2 < 0) {
            this.f11881e = 0;
        }
    }

    public void g() {
        int i2 = this.f11880d - 1;
        this.f11880d = i2;
        if (i2 < 0) {
            this.f11880d = 0;
        }
    }

    private k() {
        this.f11877a = 0L;
        this.f11878b = 0L;
        this.f11879c = false;
        this.f11880d = 1;
        this.f11881e = 1;
    }

    public int a() {
        return this.f11881e;
    }
}
