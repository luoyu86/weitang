package com.alipay.sdk.m.u;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f5659a = 3000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f5660b = -1;

    public static synchronized boolean a() {
        boolean z;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - f5660b >= 3000) {
            f5660b = jElapsedRealtime;
            z = false;
        } else {
            z = true;
        }
        return z;
    }
}
