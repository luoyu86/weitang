package com.tianmu.c.n;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f11826b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, com.tianmu.c.i.c> f11827a = new HashMap();

    public static a a() {
        if (f11826b == null) {
            synchronized (a.class) {
                if (f11826b == null) {
                    f11826b = new a();
                }
            }
        }
        return f11826b;
    }

    public void b(String str) {
        Map<String, com.tianmu.c.i.c> map = this.f11827a;
        if (map != null) {
            map.remove(str);
        }
    }

    public void a(String str, com.tianmu.c.i.c cVar) {
        if (this.f11827a == null) {
            this.f11827a = new HashMap();
        }
        this.f11827a.put(str, cVar);
    }

    public com.tianmu.c.i.c a(String str) {
        Map<String, com.tianmu.c.i.c> map = this.f11827a;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f11827a.get(str);
    }
}
