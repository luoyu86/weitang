package com.tianmu.j.b.c;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static k f12324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static j f12325c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12326a;

    private k() {
        new LinkedHashMap();
        this.f12326a = b().f12306a;
    }

    public static void a(j jVar) {
        if (f12325c == null) {
            synchronized (j.class) {
                if (f12325c == null) {
                    if (jVar == null) {
                        jVar = j.a().a();
                    }
                    f12325c = jVar;
                }
            }
        }
    }

    public static j b() {
        a((j) null);
        return f12325c;
    }

    public static k c() {
        if (f12324b == null) {
            synchronized (k.class) {
                if (f12324b == null) {
                    f12324b = new k();
                }
            }
        }
        return f12324b;
    }

    public boolean a() {
        return this.f12326a;
    }

    public void a(boolean z) {
        this.f12326a = z;
    }
}
