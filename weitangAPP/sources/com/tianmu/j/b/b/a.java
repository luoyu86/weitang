package com.tianmu.j.b.b;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f12277b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f12278a = b();

    private a() {
    }

    private ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, 10, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(16), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public static a c() {
        if (f12277b == null) {
            synchronized (a.class) {
                if (f12277b == null) {
                    f12277b = new a();
                }
            }
        }
        return f12277b;
    }

    public Executor a() {
        return this.f12278a;
    }
}
