package com.tianmu.b;

import com.tianmu.apilib.api.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f10804b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f10805a = new com.tianmu.apilib.api.a();

    private a() {
    }

    public static a a() {
        if (f10804b == null) {
            synchronized (a.class) {
                if (f10804b == null) {
                    f10804b = new a();
                }
            }
        }
        return f10804b;
    }

    public void a(String str, long j) {
        b bVar = this.f10805a;
        if (bVar != null) {
            bVar.a(str, j);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean a(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.tianmu.apilib.api.b r0 = r1.f10805a     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            boolean r2 = r0.a(r2, r3, r4)     // Catch: java.lang.Throwable -> L10
            if (r2 == 0) goto Ld
            r2 = 1
            goto Le
        Ld:
            r2 = 0
        Le:
            monitor-exit(r1)
            return r2
        L10:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianmu.b.a.a(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public boolean a(String str) {
        b bVar = this.f10805a;
        return bVar != null && bVar.a(str);
    }
}
