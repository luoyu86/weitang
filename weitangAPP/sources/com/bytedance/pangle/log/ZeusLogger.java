package com.bytedance.pangle.log;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.apm.ApmUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class ZeusLogger {
    public static final String TAG = "Zeus_pangle";
    public static final String TAG_ACTIVITY = "Zeus/activity_pangle";
    public static final String TAG_DOWNLOAD = "Zeus/download_pangle";
    public static final String TAG_INIT = "Zeus/init_pangle";
    public static final String TAG_INSTALL = "Zeus/install_pangle";
    public static final String TAG_LOAD = "Zeus/load_pangle";
    public static final String TAG_PAM = "Zeus/pam_pangle";
    public static final String TAG_PPM = "Zeus/ppm_pangle";
    public static final String TAG_PROVIDER = "Zeus/provider_pangle";
    public static final String TAG_RECEIVER = "Zeus/receiver_pangle";
    public static final String TAG_REPORTER = "Zeus/reporter_pangle";
    public static final String TAG_RESOURCES = "Zeus/resources_pangle";
    public static final String TAG_SERVER = "Zeus/server_pangle";
    public static final String TAG_SERVICE = "Zeus/service_pangle";
    public static final String TAG_SO = "Zeus/so_pangle";
    private static boolean sDebug = true;
    private static boolean sEnableTrace = false;

    public static void d(String str) {
        d(null, str);
    }

    public static void errReport(String str, String str2) {
        RuntimeException runtimeException = new RuntimeException();
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, 1, stackTrace.length - 1));
        errReport(str, str2, runtimeException, false);
    }

    private static String getTraceInfo() {
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            StackTraceElement stackTraceElement = null;
            int i2 = 1;
            while (true) {
                if (i2 >= stackTrace.length) {
                    break;
                }
                if (!TextUtils.equals(stackTrace[i2].getClassName(), ZeusLogger.class.getName())) {
                    stackTraceElement = stackTrace[i2];
                    break;
                }
                i2++;
            }
            if (stackTraceElement == null) {
                return "\t\t[No Trace Info]";
            }
            return "\t\t[" + stackTraceElement.toString() + "]";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "\t\t[No Trace Info]";
        }
    }

    public static void i(String str) {
        i(null, str);
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static boolean isEnableTrace() {
        return sEnableTrace;
    }

    private static String prefixTraceInfo(String str) {
        if (!sEnableTrace) {
            return str;
        }
        return str + getTraceInfo();
    }

    public static void setDebug(boolean z) {
        sDebug = z;
    }

    public static void setEnableTrace(boolean z) {
        sEnableTrace = z;
    }

    public static void v(String str) {
        v(null, str);
    }

    public static void w(String str) {
        w(null, str);
    }

    public static void d(String str, String str2) {
        i(str, str2);
    }

    public static void i(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.i(str, strPrefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().i(str, strPrefixTraceInfo);
        }
    }

    public static void v(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.v(str, strPrefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().v(str, strPrefixTraceInfo);
        }
    }

    public static void w(String str, String str2) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.w(str, strPrefixTraceInfo);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, strPrefixTraceInfo);
        }
    }

    public static void errReport(String str, String str2, @NonNull Throwable th) {
        errReport(str, str2, th, true);
    }

    private static void errReport(String str, String str2, @NonNull Throwable th, boolean z) {
        if (sDebug) {
            Log.e(str, str2, z ? th : null);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().e(str, str2, z ? th : null);
        }
        ApmUtils.getApmInstance().reportError(str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        String strPrefixTraceInfo = prefixTraceInfo(str2);
        if (sDebug) {
            Log.w(str, strPrefixTraceInfo, th);
        } else if (GlobalParam.getInstance().getLogger() != null) {
            GlobalParam.getInstance().getLogger().w(str, strPrefixTraceInfo, th);
        }
    }
}
