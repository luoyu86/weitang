package com.tianmu.c.i;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11762b;

    public String a() {
        return this.f11761a;
    }

    public String b() {
        return this.f11762b;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private p f11763a = new p();

        public a a(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11763a.f11761a = "";
            } else {
                this.f11763a.f11761a = str;
            }
            return this;
        }

        public a b(String str) {
            if (TextUtils.isEmpty(str)) {
                this.f11763a.f11762b = "";
            } else {
                this.f11763a.f11762b = str;
            }
            return this;
        }

        public p a() {
            return this.f11763a;
        }
    }
}
