package com.tianmu.biz.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c0 {
    private static c0 l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f10856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10857e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f10858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f10859g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f10860h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f10861i;
    private String j;
    private String k;

    private c0() {
    }

    public static c0 l() {
        if (l == null) {
            synchronized (c0.class) {
                if (l == null) {
                    l = new c0();
                }
            }
        }
        return l;
    }

    public String a() {
        String strD = com.tianmu.c.n.g.I().d();
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        if (!TextUtils.isEmpty(this.f10853a)) {
            return this.f10853a;
        }
        String strA = d0.a();
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        this.f10853a = strA;
        return strA;
    }

    public String b() {
        String strE = com.tianmu.c.n.g.I().e();
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        if (!TextUtils.isEmpty(this.f10860h)) {
            return this.f10860h;
        }
        String strB = d0.b();
        if (TextUtils.isEmpty(strB)) {
            return "";
        }
        this.f10860h = strB;
        return strB;
    }

    public String c() {
        String strG = com.tianmu.c.n.g.I().g();
        if (!TextUtils.isEmpty(strG)) {
            return strG;
        }
        if (!TextUtils.isEmpty(this.f10854b)) {
            return this.f10854b;
        }
        String strC = d0.c();
        if (TextUtils.isEmpty(strC)) {
            return "";
        }
        this.f10854b = strC;
        return strC;
    }

    public String d() {
        String strH = com.tianmu.c.n.g.I().h();
        if (!TextUtils.isEmpty(strH)) {
            return strH;
        }
        if (!TextUtils.isEmpty(this.f10856d)) {
            return this.f10856d;
        }
        String strD = d0.d();
        if (TextUtils.isEmpty(strD)) {
            return "";
        }
        this.f10856d = strD;
        return strD;
    }

    public String e() {
        String strI = com.tianmu.c.n.g.I().i();
        if (!TextUtils.isEmpty(strI)) {
            return strI;
        }
        if (!TextUtils.isEmpty(this.f10857e)) {
            return this.f10857e;
        }
        String strE = d0.e();
        if (TextUtils.isEmpty(strE)) {
            return "";
        }
        this.f10857e = strE;
        return strE;
    }

    public String f() {
        String strJ = com.tianmu.c.n.g.I().j();
        if (!TextUtils.isEmpty(strJ)) {
            return strJ;
        }
        if (!TextUtils.isEmpty(this.f10858f)) {
            return this.f10858f;
        }
        String strF = d0.f();
        if (TextUtils.isEmpty(strF)) {
            return "";
        }
        this.f10858f = strF;
        return strF;
    }

    public String g() {
        String strK = com.tianmu.c.n.g.I().k();
        if (!TextUtils.isEmpty(strK)) {
            return strK;
        }
        if (!TextUtils.isEmpty(this.f10859g)) {
            return this.f10859g;
        }
        String strG = d0.g();
        if (TextUtils.isEmpty(strG)) {
            return "";
        }
        this.f10859g = strG;
        return strG;
    }

    public String h() {
        String strL = com.tianmu.c.n.g.I().l();
        if (!TextUtils.isEmpty(strL)) {
            return strL;
        }
        if (!TextUtils.isEmpty(this.f10855c)) {
            return this.f10855c;
        }
        String strH = d0.h();
        if (TextUtils.isEmpty(strH)) {
            return "";
        }
        this.f10855c = strH;
        return strH;
    }

    public String i() {
        String strP = com.tianmu.c.n.g.I().p();
        if (!TextUtils.isEmpty(strP)) {
            return strP;
        }
        if (!TextUtils.isEmpty(this.f10861i)) {
            return this.f10861i;
        }
        String strI = d0.i();
        if (TextUtils.isEmpty(strI)) {
            return "";
        }
        this.f10861i = strI;
        return strI;
    }

    public String j() {
        String strS = com.tianmu.c.n.g.I().s();
        if (!TextUtils.isEmpty(strS)) {
            return strS;
        }
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        String strJ = d0.j();
        if (TextUtils.isEmpty(strJ)) {
            return "";
        }
        this.k = strJ;
        return strJ;
    }

    public String k() {
        String strT = com.tianmu.c.n.g.I().t();
        if (!TextUtils.isEmpty(strT)) {
            return strT;
        }
        if (!TextUtils.isEmpty(this.j)) {
            return this.j;
        }
        String strK = d0.k();
        if (TextUtils.isEmpty(strK)) {
            return "";
        }
        this.j = strK;
        return strK;
    }
}
