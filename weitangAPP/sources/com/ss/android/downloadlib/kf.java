package com.ss.android.downloadlib;

/* JADX INFO: loaded from: classes2.dex */
public class kf {
    private static volatile kf ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ss.android.download.api.config.kf f9877a = null;

    private kf() {
    }

    public static kf ok() {
        if (ok == null) {
            synchronized (kf.class) {
                if (ok == null) {
                    ok = new kf();
                }
            }
        }
        return ok;
    }

    public com.ss.android.download.api.config.kf a() {
        return this.f9877a;
    }
}
