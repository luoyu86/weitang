package com.tianmu.b.c;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f10812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f10813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f10814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f10815f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ThreadPoolExecutor f10816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f10817b;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f10812c = iAvailableProcessors;
        f10813d = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        f10814e = (iAvailableProcessors * 2) + 1;
    }

    private a() {
        if (this.f10816a == null) {
            this.f10816a = new ThreadPoolExecutor(5, 10, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(32), new ThreadPoolExecutor.DiscardOldestPolicy());
        }
        if (this.f10817b == null) {
            this.f10817b = new ThreadPoolExecutor(f10813d, f10814e, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(16), new ThreadPoolExecutor.DiscardOldestPolicy());
        }
    }

    public static a c() {
        if (f10815f == null) {
            synchronized (a.class) {
                if (f10815f == null) {
                    f10815f = new a();
                }
            }
        }
        return f10815f;
    }

    public ThreadPoolExecutor a() {
        return this.f10817b;
    }

    public ThreadPoolExecutor b() {
        return this.f10816a;
    }
}
