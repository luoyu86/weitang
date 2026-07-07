package com.taobao.accs.b;

import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f10246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ClassLoader f10247b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10248c = false;

    public static synchronized a a() {
        if (f10246a == null) {
            f10246a = new a();
        }
        return f10246a;
    }

    public synchronized ClassLoader b() {
        if (this.f10247b == null) {
            ALog.d("ACCSClassLoader", "getClassLoader", new Object[0]);
            this.f10247b = a.class.getClassLoader();
        }
        return this.f10247b;
    }
}
