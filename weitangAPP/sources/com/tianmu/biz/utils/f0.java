package com.tianmu.biz.utils;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {
    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }
}
