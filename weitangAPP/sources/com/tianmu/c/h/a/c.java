package com.tianmu.c.h.a;

import android.text.TextUtils;
import com.tianmu.biz.utils.k;
import com.tianmu.biz.utils.s0;
import com.tianmu.utils.TianmuLogUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.tianmu.c.h.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f11610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f11611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f11614e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11617h;
    public String j;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, com.tianmu.c.h.b.c> f11616g = new HashMap();
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 1000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11618i = -2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.tianmu.c.h.b.b f11615f = new com.tianmu.c.h.b.b(this);

    public class a implements com.tianmu.c.g.e.b<com.tianmu.c.g.d.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11619a;

        public a(String str) {
            this.f11619a = str;
        }

        @Override // com.tianmu.c.g.e.b
        public void a(com.tianmu.c.g.d.a aVar) {
            c.this.f11615f.a(this.f11619a, aVar.l());
        }

        @Override // com.tianmu.c.g.e.b
        public void a() {
            c.this.f11615f.a(this.f11619a, 0L);
        }
    }

    public c(String str, String str2, String str3, String str4, String str5) {
        this.f11617h = str;
        this.f11610a = str2;
        this.f11612c = str3;
        this.f11611b = str4;
        this.f11614e = str5;
    }

    private com.tianmu.c.h.b.c p() {
        Map<String, com.tianmu.c.h.b.c> map;
        String str = this.j;
        if (str == null || (map = this.f11616g) == null) {
            return null;
        }
        return map.get(str);
    }

    public void b(long j) {
        this.k = j;
    }

    public String c() {
        return this.f11612c;
    }

    public String d() {
        return this.j;
    }

    public long e() {
        return this.l;
    }

    public String f() {
        return this.f11617h;
    }

    public String g() {
        return this.f11610a;
    }

    public String h() {
        return this.f11613d;
    }

    public long i() {
        return this.k;
    }

    public int j() {
        return this.f11618i;
    }

    public void k() {
        a(4);
    }

    public void l() {
        a(0);
        List<String> listB = com.tianmu.c.h.d.a.c().b();
        if (TextUtils.isEmpty(this.j) || listB.contains(this.j)) {
            return;
        }
        listB.add(this.j);
        com.tianmu.c.h.b.c cVarP = p();
        if (cVarP != null) {
            cVarP.f();
        }
    }

    public void m() {
        this.f11618i = -1;
        k.a(a(this.f11611b, ".tianmu.action.download.failed"), this.j, this.f11612c);
        Map<String, com.tianmu.c.h.b.c> map = this.f11616g;
        if (map == null || map.size() <= 0) {
            return;
        }
        try {
            Iterator<Map.Entry<String, com.tianmu.c.h.b.c>> it = this.f11616g.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().a();
            }
            this.f11616g.clear();
            this.f11615f = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void n() {
        com.tianmu.c.h.b.c cVarP = p();
        if (cVarP != null) {
            cVarP.e();
        }
        a(2);
    }

    public void o() {
        com.tianmu.c.h.b.c cVarP = p();
        if (cVarP != null) {
            cVarP.c();
        }
    }

    private void e(String str) {
        this.j = str;
        Map<String, com.tianmu.c.h.b.c> map = this.f11616g;
        if (map == null || str == null || map.get(str) != null) {
            return;
        }
        this.f11616g.put(str, new com.tianmu.c.h.b.c(str));
    }

    private void f(String str) {
        com.tianmu.c.h.b.b bVar = this.f11615f;
        if (bVar != null) {
            bVar.a(str);
        } else {
            a(-1);
        }
    }

    public void a(long j) {
        this.l = j;
    }

    public void b(String str) {
        if (this.f11615f != null) {
            com.tianmu.c.g.f.a.a().a(new a(str), this.f11612c);
        } else {
            a(-1);
        }
    }

    public void c(String str) {
        this.f11613d = str;
        a(1);
        com.tianmu.c.h.b.c cVarP = p();
        if (cVarP != null) {
            cVarP.d();
        }
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(h()) ? com.tianmu.biz.utils.d.a(h(), str) : com.tianmu.biz.utils.d.a(c(), str)) {
            com.tianmu.c.h.b.c cVarP = p();
            if (cVarP != null) {
                cVarP.b();
            }
            a(3);
        }
    }

    public void a(long j, long j2) {
        if (System.currentTimeMillis() - this.m > this.n) {
            k.a(a(this.f11611b, ".tianmu.action.download.progress.update"), j, j2, this.j, this.f11612c);
            this.m = System.currentTimeMillis();
        }
        if (j >= j2) {
            k.a(a(this.f11611b, ".tianmu.action.download.progress.update"), j, j2, this.j, this.f11612c);
        }
    }

    public void b(String str, boolean z, String str2) {
        f(str);
    }

    public static void b(String str, String str2, String str3) {
        k.a(a(str, ".tianmu.action.download.failed"), str2, str3);
    }

    public void b() {
        com.tianmu.c.h.d.a.c().a(d(), this.f11612c);
    }

    public boolean a(String str) {
        com.tianmu.c.h.b.b bVar = this.f11615f;
        return bVar != null && (bVar.a(str, c()) || this.f11615f.a(str, h()));
    }

    public void a(String str, boolean z, String str2) {
        e(str2);
        if (2 != j() && 3 != j() && !TextUtils.isEmpty(this.f11612c) && com.tianmu.biz.utils.d.c(this.f11612c) != null) {
            a(2);
        }
        int iJ = j();
        if (1 == iJ) {
            if (z) {
                File fileA = com.tianmu.biz.utils.d.a(this.f11617h);
                if (fileA != null && fileA.exists()) {
                    o();
                    com.tianmu.biz.utils.d.a(f(), true);
                } else {
                    s0.a("文件不存在或已被删除");
                    m();
                }
            }
            k.a(a(this.f11611b, ".tianmu.action.download.success"), this.j, this.f11612c);
            return;
        }
        if (2 == iJ && !TextUtils.isEmpty(c())) {
            if (z) {
                d(this.f11614e);
            }
            k.a(a(this.f11611b, ".tianmu.action.download.installed"), this.j, this.f11612c, this.f11613d);
            return;
        }
        if (3 == iJ) {
            if (z) {
                d(this.f11614e);
            }
            k.a(a(this.f11611b, ".tianmu.action.download.installed"), this.j, this.f11612c, this.f11613d);
            return;
        }
        if (-1 == iJ) {
            m();
            return;
        }
        if (-2 == iJ) {
            if (z) {
                b(str);
                return;
            } else {
                k.a(a(this.f11611b, ".tianmu.action.download.idel"), this.j, this.f11612c);
                return;
            }
        }
        if (iJ == 0) {
            if (z) {
                TianmuLogUtil.i("下载中...");
            }
        } else if (4 == iJ) {
            if (z) {
                b(str);
            } else {
                k.a(a(this.f11611b, ".tianmu.action.download.idel"), this.j, this.f11612c);
            }
        }
    }

    public void a() {
        a(1);
    }

    private void a(int i2) {
        this.f11618i = i2;
        if (i2 == -1) {
            k.a(a(this.f11611b, ".tianmu.action.download.failed"), this.j, this.f11612c);
            return;
        }
        if (i2 == 0) {
            k.a(a(this.f11611b, ".tianmu.action.download.loading"), this.j, this.f11612c);
            return;
        }
        if (i2 == 1) {
            File fileA = com.tianmu.biz.utils.d.a(f());
            if (fileA != null) {
                if (!fileA.exists()) {
                    a(-1);
                    return;
                } else {
                    k.a(a(this.f11611b, ".tianmu.action.download.success"), this.j, this.f11612c, this.f11613d);
                    return;
                }
            }
            return;
        }
        if (i2 == 2) {
            k.a(a(this.f11611b, ".tianmu.action.download.installed"), this.j, this.f11612c, this.f11613d);
            d(this.f11614e);
        } else if (i2 == 3) {
            k.a(a(this.f11611b, ".tianmu.action.download.opened"), this.j, this.f11612c, this.f11613d);
        } else {
            if (i2 != 4) {
                return;
            }
            k.a(a(this.f11611b, ".tianmu.action.download.pause"), this.j, this.f11612c);
        }
    }

    public static void a(String str, String str2, String str3) {
        k.a(a(str, ".tianmu.action.download.stop"), str2, str3);
    }

    private static String a(String str, String str2) {
        return str + str2;
    }
}
