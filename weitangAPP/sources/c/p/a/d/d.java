package c.p.a.d;

import android.util.Log;
import c.o.a.f;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f3058a = true;

    public static boolean a(String str) {
        Log.d("Logger", "message = " + str);
        return true;
    }

    public static void d(String str) {
        if (a(str)) {
            f.d(str);
        }
    }

    public static void e(String str) {
        if (a(str)) {
            f.e(str, new Object[0]);
        }
    }

    public static void i(String str) {
        if (a(str)) {
            f.i(str, new Object[0]);
        }
    }

    public static void v(String str) {
        if (a(str)) {
            f.v(str, new Object[0]);
        }
    }

    public static void d(String str, String str2) {
        if (a(str2)) {
            f.d(str + ":" + str2);
        }
    }

    public static void e(String str, String str2) {
        if (a(str2)) {
            f.e(str + ":" + str2, new Object[0]);
        }
    }

    public static void i(String str, String str2) {
        if (f3058a) {
            f.i(str + ":" + str2, new Object[0]);
        }
    }

    public static void v(String str, String str2) {
        if (a(str2)) {
            f.v(str + ":" + str2, new Object[0]);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (a(str2 + ":" + th)) {
            f.e(str + ":" + str2 + ":" + th, new Object[0]);
        }
    }
}
