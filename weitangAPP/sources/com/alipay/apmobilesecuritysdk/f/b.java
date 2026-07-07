package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f5164a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f5165b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinkedList<Runnable> f5166c = new LinkedList<>();

    public static b a() {
        return f5164a;
    }

    public static /* synthetic */ Thread b(b bVar) {
        bVar.f5165b = null;
        return null;
    }

    public final synchronized void a(Runnable runnable) {
        this.f5166c.add(runnable);
        if (this.f5165b == null) {
            Thread thread = new Thread(new c(this));
            this.f5165b = thread;
            thread.start();
        }
    }
}
