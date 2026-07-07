package com.alibaba.mtl.log.b;

import android.text.TextUtils;
import com.alibaba.mtl.log.d.i;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static StringBuilder f4534a = new StringBuilder();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile long f4535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f4536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f4537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static long f4538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f4539i;
    private static long j;
    private static long k;
    private static long l;
    private static long m;
    private static long n;
    private static long o;
    private static long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static long f4540q;
    private static long r;
    private static long s;
    private static long t;
    private static int u;

    /* JADX INFO: renamed from: u, reason: collision with other field name */
    private static long f55u;
    private static int v;

    /* JADX INFO: renamed from: v, reason: collision with other field name */
    private static long f56v;
    private static int w;

    /* JADX INFO: renamed from: w, reason: collision with other field name */
    private static long f57w;
    private static long x;
    private static long y;

    public static synchronized void A() {
        t++;
    }

    public static synchronized void B() {
        f55u++;
    }

    public static synchronized void C() {
        w++;
        if (f4535e == 0 && f4537g == 0) {
            return;
        }
        if (com.alibaba.mtl.log.a.o || w >= 6) {
            c(true);
        }
    }

    public static synchronized void a(List<com.alibaba.mtl.log.model.a> list, int i2) {
        if (list == null) {
            return;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            com.alibaba.mtl.log.model.a aVar = list.get(i4);
            if (aVar != null) {
                if (!"6005".equalsIgnoreCase(aVar.X)) {
                    i3++;
                }
                f4534a.append(aVar.ab);
                if (i4 != list.size() - 1) {
                    f4534a.append(",");
                }
            }
        }
        i.a("CoreStatics", "[uploadInc]:", Long.valueOf(f4537g), "count:", Integer.valueOf(i2));
        long j2 = f4537g + ((long) i2);
        f4537g = j2;
        i.a("CoreStatics", "[uploadInc]:", Long.valueOf(j2));
        if (i3 != i2) {
            i.a("CoreStatics", "Mutil Process Upload Error");
        }
    }

    @Deprecated
    public static synchronized void c(boolean z) {
    }

    public static synchronized void d(int i2) {
        u += i2;
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return "6005".equalsIgnoreCase(str.trim());
    }

    public static synchronized void m(String str) {
        if (e(str)) {
            return;
        }
        if ("65501".equalsIgnoreCase(str)) {
            y++;
        } else if ("65133".equalsIgnoreCase(str)) {
            f57w++;
        } else if ("65502".equalsIgnoreCase(str)) {
            x++;
        } else if ("65503".equalsIgnoreCase(str)) {
            f56v++;
        }
        f4535e++;
    }

    public static synchronized void n(String str) {
        if (e(str)) {
            return;
        }
        f4536f++;
    }

    public static synchronized void s() {
        f4538h++;
    }

    public static synchronized void t() {
        f4539i++;
    }

    public static synchronized void u() {
        n++;
    }

    public static synchronized void v() {
        o++;
    }

    public static synchronized void w() {
        p++;
    }

    public static synchronized void x() {
        f4540q++;
    }

    public static synchronized void y() {
        r++;
    }

    public static synchronized void z() {
        s++;
    }
}
