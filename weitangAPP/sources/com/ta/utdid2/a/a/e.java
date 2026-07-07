package com.ta.utdid2.a.a;

import com.ta.a.c.f;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static String get(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e2) {
            f.b("", e2, new Object[0]);
            return str2;
        }
    }
}
