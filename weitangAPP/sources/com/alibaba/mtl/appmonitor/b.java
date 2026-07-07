package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.s;

/* JADX INFO: loaded from: classes.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f4489a = 300000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f45a = null;
    private static boolean j = false;

    private b() {
    }

    public static void destroy() {
        s.a().f(5);
        j = false;
        f45a = null;
    }

    public static void init() {
        if (j) {
            return;
        }
        i.a("CleanTask", "init TimeoutEventManager");
        f45a = new b();
        s.a().a(5, f45a, f4489a);
        j = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        i.a("CleanTask", "clean TimeoutEvent");
        e.a().g();
        s.a().a(5, f45a, f4489a);
    }
}
