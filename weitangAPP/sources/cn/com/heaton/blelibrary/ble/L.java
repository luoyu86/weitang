package cn.com.heaton.blelibrary.ble;

import android.text.TextUtils;
import android.util.Log;
import cn.com.heaton.blelibrary.ble.Ble;
import com.alibaba.android.arouter.utils.Consts;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class L {
    public static String TAG = "AndroidBLE";
    public static boolean isDebug;

    private static String buildMessage(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.CHINA, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i2].getClass().equals(L.class)) {
                String className = stackTrace[i2].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                str2 = strSubstring.substring(strSubstring.lastIndexOf(36) + 1) + Consts.DOT + stackTrace[i2].getMethodName();
                break;
            }
            i2++;
        }
        return String.format(Locale.CHINA, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    private static String buildMessge(String str, String str2) {
        return String.format(Locale.CHINA, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str, str2);
    }

    public static void d(Object obj, String str) {
        if (isDebug) {
            Log.d(TAG, buildMessge(getSubTag(obj), str));
        }
    }

    public static void e(Object obj, String str) {
        if (isDebug) {
            Log.e(TAG, buildMessge(getSubTag(obj), str));
        }
    }

    private static String getSubTag(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof Number ? String.valueOf(obj) : obj.getClass().getSimpleName();
    }

    public static void i(Object obj, String str) {
        if (isDebug) {
            Log.i(TAG, buildMessge(getSubTag(obj), str));
        }
    }

    public static void init(Ble.Options options) {
        isDebug = options.logBleExceptions;
        if (TextUtils.isEmpty(options.logTAG)) {
            return;
        }
        TAG = options.logTAG;
    }

    public static void w(Object obj, String str) {
        if (isDebug) {
            Log.w(TAG, buildMessge(getSubTag(obj), str));
        }
    }
}
