package com.alibaba.sdk.android.man.crashreporter.handler.c;

import com.alibaba.sdk.android.man.crashreporter.e.h;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(String str, int i2, int i3) {
        String str2 = i2 == 0 ? "CRASH_HANDLE" : i2 == 1 ? "NATIVE_CRASH_HANDLE" : i2 == 2 ? "ANR_HANDLE" : "";
        Class<?> cls = null;
        try {
            try {
                cls = Class.forName("com.taobao.statistis.TBS$Ext");
            } catch (ClassNotFoundException unused) {
            }
            if (cls == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("com.taobao.stdatistis.TBS.Ext is null");
            } else {
                h.a((Class) cls, "commitEvent", new Object[]{"", Integer.valueOf(i3), str, str2}, new Class[0]);
                com.alibaba.sdk.android.man.crashreporter.b.a.e("commitEvent call succ");
            }
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("watchDog error.", e2);
        }
    }
}
