package com.alipay.sdk.m.d;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5304a = "OpenId";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f5305b = false;

    public static void a(boolean z) {
        Log.d(f5304a, "setDebug:" + z);
        f5305b = z;
    }

    public static void b(String str, Object... objArr) {
        if (f5305b) {
            Log.d(f5304a, a(str, objArr));
        }
    }

    public static void c(String str, Object... objArr) {
        if (f5305b) {
            Log.e(f5304a, a(str, objArr));
        }
    }

    public static void d(String str, Object... objArr) {
        if (f5305b) {
            Log.i(f5304a, a(str, objArr));
        }
    }

    public static void e(String str, Object... objArr) {
        if (f5305b) {
            Log.w(f5304a, a(str, objArr));
        }
    }

    public static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = "-";
        }
        int i2 = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i3 = i2 + 1;
                if (i3 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i2], objArr[i3]));
                if (i3 < length - 1) {
                    sb.append(",");
                }
                i2 = i3 + 1;
            }
            if (i2 == objArr.length - 1) {
                sb.append(objArr[i2]);
            }
        }
        return sb.toString();
    }

    public static String a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }
}
