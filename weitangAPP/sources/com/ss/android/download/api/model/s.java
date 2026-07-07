package com.ss.android.download.api.model;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9737a;
    private String ok;

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9738a;
        private String ok;

        public ok a(String str) {
            this.f9738a = str;
            return this;
        }

        public ok ok(String str) {
            this.ok = str;
            return this;
        }

        public s ok() {
            return new s(this);
        }
    }

    public s(ok okVar) {
        this.ok = okVar.ok;
        this.f9737a = okVar.f9738a;
    }

    public String ok() {
        return this.ok;
    }
}
