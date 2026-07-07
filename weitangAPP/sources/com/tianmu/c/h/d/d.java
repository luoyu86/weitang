package com.tianmu.c.h.d;

import android.content.Intent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f11649b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, com.tianmu.c.h.f.a> f11650a;

    private d() {
    }

    public static d c() {
        if (f11649b == null) {
            synchronized (c.class) {
                if (f11649b == null) {
                    f11649b = new d();
                }
            }
        }
        return f11649b;
    }

    public void a(String str, com.tianmu.c.h.f.a aVar) {
        if (this.f11650a == null) {
            this.f11650a = new HashMap();
        }
        this.f11650a.put(str, aVar);
    }

    public void b() {
        Map<String, com.tianmu.c.h.f.a> map = this.f11650a;
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                this.f11650a.get(it.next()).b();
            }
            this.f11650a.clear();
        }
    }

    public void d(String str) {
        com.tianmu.c.h.f.a aVar;
        Map<String, com.tianmu.c.h.f.a> map = this.f11650a;
        if (map == null || !map.containsKey(str) || (aVar = this.f11650a.get(str)) == null) {
            return;
        }
        aVar.e();
        aVar.c();
    }

    public void e(String str) {
        com.tianmu.c.h.f.a aVar;
        Map<String, com.tianmu.c.h.f.a> map = this.f11650a;
        if (map == null || !map.containsKey(str) || (aVar = this.f11650a.get(str)) == null) {
            return;
        }
        aVar.f();
        aVar.c();
    }

    public com.tianmu.c.h.f.a a(String str) {
        Map<String, com.tianmu.c.h.f.a> map = this.f11650a;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void a() {
        Map<String, com.tianmu.c.h.f.a> map = this.f11650a;
        if (map != null) {
            for (String str : map.keySet()) {
                com.tianmu.c.h.f.a aVar = this.f11650a.get(str);
                if (aVar != null && aVar.a() == 100) {
                    aVar.b();
                    this.f11650a.remove(str);
                }
            }
        }
    }

    public void b(String str) {
        Map<String, com.tianmu.c.h.f.a> map = this.f11650a;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.f11650a.get(str).b();
    }

    public void c(String str) {
        Map<String, com.tianmu.c.h.f.a> map = this.f11650a;
        if (map == null || !map.containsKey(str)) {
            return;
        }
        this.f11650a.get(str).b();
        this.f11650a.remove(str);
    }

    public void a(String str, int i2) {
        com.tianmu.c.h.f.a aVar;
        Intent intentA = c.c().a(str);
        if (intentA != null) {
            intentA.putExtra("downloadProgress", i2);
        }
        Map<String, com.tianmu.c.h.f.a> map = this.f11650a;
        if (map == null || !map.containsKey(str) || (aVar = this.f11650a.get(str)) == null || !aVar.a(i2)) {
            return;
        }
        aVar.e();
        aVar.g();
        aVar.c();
    }
}
