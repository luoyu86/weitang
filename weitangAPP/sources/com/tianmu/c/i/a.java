package com.tianmu.c.i;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11687i;
    private int j = 0;
    private String k;

    public String j() {
        return this.f11684f;
    }

    public boolean k() {
        return this.f11687i;
    }

    public boolean l() {
        return TextUtils.isEmpty(d()) && TextUtils.isEmpty(f()) && TextUtils.isEmpty(a()) && TextUtils.isEmpty(h()) && TextUtils.isEmpty(i()) && TextUtils.isEmpty(j());
    }

    public String b() {
        return this.f11681c;
    }

    public String c() {
        return this.f11682d;
    }

    public String d() {
        return this.f11679a;
    }

    public String e() {
        return this.k;
    }

    public String f() {
        return this.f11680b;
    }

    public int g() {
        return this.j;
    }

    public String h() {
        return this.f11686h;
    }

    public String i() {
        return this.f11685g;
    }

    /* JADX INFO: renamed from: com.tianmu.c.i.a$a, reason: collision with other inner class name */
    public static class C0209a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private a f11688a = new a();

        public C0209a a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11688a.f11683e = "";
            } else {
                this.f11688a.f11683e = str;
            }
            return this;
        }

        public C0209a b(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11688a.f11681c = "";
            } else {
                this.f11688a.f11681c = str;
            }
            return this;
        }

        public C0209a c(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11688a.f11682d = "";
            } else {
                this.f11688a.f11682d = str;
            }
            return this;
        }

        public C0209a d(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11688a.f11679a = "";
            } else {
                this.f11688a.f11679a = str;
            }
            return this;
        }

        public C0209a e(String str) {
            this.f11688a.k = str;
            return this;
        }

        public C0209a f(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11688a.f11680b = "";
            } else {
                this.f11688a.f11680b = str;
            }
            return this;
        }

        public C0209a g(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11688a.f11686h = "";
            } else {
                this.f11688a.f11686h = str;
            }
            return this;
        }

        public C0209a h(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11688a.f11685g = "";
            } else {
                this.f11688a.f11685g = str;
            }
            return this;
        }

        public C0209a i(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11688a.f11684f = "";
            } else {
                this.f11688a.f11684f = str;
            }
            return this;
        }

        public C0209a a(int i2) {
            this.f11688a.j = i2;
            return this;
        }

        public a a() {
            return this.f11688a;
        }
    }

    public String a() {
        return this.f11683e;
    }

    public void a(boolean z) {
        this.f11687i = z;
    }
}
