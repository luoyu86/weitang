package cn.admobiletop.adsuyi.util;

import android.util.Log;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.l.h;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiLogUtil {
    public static void d(String str) {
        d("ADSuyiLog", str);
    }

    public static void directD(String str) {
        Log.d("ADSuyiLog", str);
    }

    public static void e(String str) {
        e("ADSuyiLog", str);
    }

    public static void i(String str) {
        i("ADSuyiLog", str);
    }

    public static boolean needShowLog() {
        return h.l().c() || ADSuyiSdk.getInstance().isDebug();
    }

    public static boolean tNeedShowLog() {
        return h.l().c();
    }

    public static void ti(String str, String str2) {
        if (tNeedShowLog()) {
            i(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (needShowLog()) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (needShowLog()) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (needShowLog()) {
            Log.i(str, str2);
        }
    }
}
