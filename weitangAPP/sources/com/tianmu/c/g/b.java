package com.tianmu.c.g;

import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f11584a;

    public static synchronized void a(com.tianmu.c.g.c.a aVar) {
        try {
            f11584a--;
            if (f11584a <= 0) {
                if (aVar != null) {
                    TianmuLogUtil.iD(String.format("zero instances, closing helper %s", aVar));
                    aVar.close();
                }
                if (f11584a < 0) {
                    TianmuLogUtil.iD(String.format("too many calls to release helper, instance count = %s", Integer.valueOf(f11584a)));
                }
            }
        } catch (Exception unused) {
        }
    }

    public static synchronized void a() {
        f11584a++;
    }
}
