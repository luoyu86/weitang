package com.tianmu.e.c;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f12002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12004d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f12005a = new ThreadPoolExecutor(f12004d, 20, 20, TimeUnit.SECONDS, new LinkedBlockingQueue(16), new ThreadPoolExecutor.DiscardOldestPolicy());

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f12003c = iAvailableProcessors;
        f12004d = Math.max(2, Math.min(iAvailableProcessors - 1, 5));
    }

    private a() {
    }

    public static a b() {
        if (f12002b == null) {
            synchronized (a.class) {
                if (f12002b == null) {
                    f12002b = new a();
                }
            }
        }
        return f12002b;
    }

    public ThreadPoolExecutor a() {
        return this.f12005a;
    }
}
