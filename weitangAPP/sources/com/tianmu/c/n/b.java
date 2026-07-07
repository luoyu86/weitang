package com.tianmu.c.n;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, com.tianmu.c.i.d> f11828a;

    /* JADX INFO: renamed from: com.tianmu.c.n.b$b, reason: collision with other inner class name */
    public static final class C0213b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f11829a = new b();
    }

    public static b a() {
        return C0213b.f11829a;
    }

    public boolean b(String str) {
        com.tianmu.c.i.d dVar;
        return (TextUtils.isEmpty(str) || (dVar = this.f11828a.get(str)) == null || dVar.a() != 2) ? false : true;
    }

    public boolean c(String str) {
        com.tianmu.c.i.d dVar;
        if (TextUtils.isEmpty(str) || (dVar = this.f11828a.get(str)) == null) {
            return false;
        }
        return dVar.b();
    }

    private b() {
        this.f11828a = new HashMap();
    }

    public void a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.tianmu.c.i.d dVar = this.f11828a.get(str);
        if (dVar == null) {
            dVar = new com.tianmu.c.i.d();
            this.f11828a.put(str, dVar);
        }
        dVar.a(i2);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f11828a.remove(str);
    }
}
