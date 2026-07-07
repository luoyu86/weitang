package com.tianmu.c.n;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f11830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f11831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f11832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static c f11833f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f11834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f11835b;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f11830c = iAvailableProcessors;
        f11831d = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        f11832e = (iAvailableProcessors * 2) + 1;
    }

    private c() {
        if (this.f11834a == null) {
            this.f11834a = new ThreadPoolExecutor(5, 10, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(32), new ThreadPoolExecutor.DiscardOldestPolicy());
        }
        if (this.f11835b == null) {
            this.f11835b = new ThreadPoolExecutor(f11831d, f11832e, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(16), new ThreadPoolExecutor.DiscardOldestPolicy());
        }
    }

    public static c c() {
        if (f11833f == null) {
            synchronized (c.class) {
                if (f11833f == null) {
                    f11833f = new c();
                }
            }
        }
        return f11833f;
    }

    public ThreadPoolExecutor a() {
        return this.f11835b;
    }

    public ThreadPoolExecutor b() {
        return this.f11834a;
    }
}
