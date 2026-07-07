package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Executor f5989a = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.bytedance.pangle.d.e.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f5992a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "pangle-Fast-" + this.f5992a.getAndIncrement());
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f5990b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f5991c = null;

    public static void a(Runnable runnable) {
        f5989a.execute(runnable);
    }

    public static void b(Runnable runnable) {
        if (a().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    public static ExecutorService a(int i2) {
        return Executors.newFixedThreadPool(i2, new ThreadFactory() { // from class: com.bytedance.pangle.d.e.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final AtomicInteger f5993a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return new Thread(runnable, "pangle-Install-" + this.f5993a.getAndIncrement());
            }
        });
    }

    private static Handler a() {
        Handler handler;
        synchronized (f5990b) {
            if (f5991c == null) {
                f5991c = new Handler(Looper.getMainLooper());
            }
            handler = f5991c;
        }
        return handler;
    }
}
