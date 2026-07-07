package com.ss.android.download.api.model;

/* JADX INFO: loaded from: classes2.dex */
public class ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9735a;
    public String bl;
    public String n;
    public String ok;
    public String s;

    /* JADX INFO: renamed from: com.ss.android.download.api.model.ok$ok, reason: collision with other inner class name */
    public static class C0129ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9736a;
        private String bl;
        private String n;
        private String ok;
        private String s;

        public C0129ok a(String str) {
            this.f9736a = str;
            return this;
        }

        public C0129ok bl(String str) {
            this.s = str;
            return this;
        }

        public C0129ok ok(String str) {
            this.ok = str;
            return this;
        }

        public C0129ok s(String str) {
            this.n = str;
            return this;
        }

        public ok ok() {
            return new ok(this);
        }
    }

    public ok(C0129ok c0129ok) {
        this.f9735a = "";
        this.ok = c0129ok.ok;
        this.f9735a = c0129ok.f9736a;
        this.bl = c0129ok.bl;
        this.s = c0129ok.s;
        this.n = c0129ok.n;
    }
}
