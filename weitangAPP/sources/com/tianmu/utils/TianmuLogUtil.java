package com.tianmu.utils;

import android.util.Log;
import com.tianmu.TianmuSDK;
import com.tianmu.c.n.n;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuLogUtil {
    public static void d(String str) {
        d("TianmuLog", str);
    }

    public static void directD(String str) {
        Log.d("TianmuLog", str);
    }

    public static void e(String str) {
        e("TianmuLog", str);
    }

    public static void i(String str) {
        i("TianmuLog", str);
    }

    public static void iD(String str) {
        if (needShowImportantLog()) {
            d("TianmuLog", str);
        }
    }

    public static boolean needShowImportantLog() {
        if (n.D().i() == null || n.D().i().getLog() == null) {
            return false;
        }
        return n.D().i().getLog().isShowImportantLog();
    }

    public static boolean needShowLog() {
        return n.D().c() || TianmuSDK.getInstance().isDebug();
    }

    public static boolean needTShowLog() {
        return n.D().c();
    }

    public static void ti(String str, String str2) {
        if (needTShowLog()) {
            Log.i(str, str2);
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
