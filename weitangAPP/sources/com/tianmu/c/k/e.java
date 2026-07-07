package com.tianmu.c.k;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static e f11785d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tianmu.e.a.a f11786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadPoolExecutor f11787b = d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThreadPoolExecutor f11788c = d();

    private e() {
        com.tianmu.e.a.a aVar = new com.tianmu.e.a.a();
        this.f11786a = aVar;
        aVar.a(b());
        aVar.a(5000L);
        aVar.b(5000L);
    }

    private ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(2, 10, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(16), new ThreadPoolExecutor.DiscardOldestPolicy());
    }

    public static e e() {
        if (f11785d == null) {
            synchronized (e.class) {
                if (f11785d == null) {
                    f11785d = new e();
                }
            }
        }
        return f11785d;
    }

    public void a(String str, Map<String, Object> map, com.tianmu.c.k.f.d dVar) {
        a(str, map, null, dVar);
    }

    public void b(String str, Map<String, Object> map, com.tianmu.c.k.f.d dVar) {
        b(str, map, null, dVar);
    }

    public Executor c() {
        return this.f11787b;
    }

    public void a(String str, Map<String, Object> map, Map<String, Object> map2, com.tianmu.c.k.f.d dVar) {
        b().execute(new b(str, map, map2, dVar));
    }

    public void b(String str, Map<String, Object> map, Map<String, Object> map2, com.tianmu.c.k.f.d dVar) {
        b().execute(new c(str, map, map2, dVar));
    }

    public com.tianmu.e.a.a a() {
        return this.f11786a;
    }

    public ThreadPoolExecutor b() {
        return this.f11788c;
    }
}
