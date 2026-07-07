package com.intelligoo.sdk.utils;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;

/* JADX INFO: loaded from: classes2.dex */
public class BleLog {
    public static boolean DEBUG = false;
    public static final String LINE_BREAK = "\r\n";
    public static final String PATH = "/vise/log";
    private static String PATH_LOG_INFO;
    public static final String ROOT;
    public static String TAG;
    public static boolean allowD;
    public static boolean allowE;
    public static boolean allowI;
    public static boolean allowV;
    public static boolean allowW;
    public static boolean allowWtf;
    public static boolean isAndroid;
    private static final ThreadLocal<ReusableFormatter> thread_local_formatter = new ThreadLocal<ReusableFormatter>() { // from class: com.intelligoo.sdk.utils.BleLog.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public ReusableFormatter initialValue() {
            return new ReusableFormatter();
        }
    };

    public static class ReusableFormatter {
        private StringBuilder builder = new StringBuilder();
        private Formatter formatter = new Formatter(this.builder);

        public String format(String str, Object... objArr) {
            this.formatter.format(str, objArr);
            String string = this.builder.toString();
            this.builder.setLength(0);
            return string;
        }
    }

    static {
        boolean z = true;
        isAndroid = true;
        String path = Environment.getExternalStorageDirectory().getPath();
        ROOT = path;
        TAG = "Bluetooth";
        DEBUG = true;
        allowD = true;
        allowE = true;
        allowI = true;
        allowV = true;
        allowW = true;
        allowWtf = true;
        String property = System.getProperty("os.name");
        System.out.println("current os System is " + property);
        if (property.toLowerCase().contains("win") || property.toLowerCase().contains("mac")) {
            z = false;
        } else {
            PATH_LOG_INFO = path + PATH;
        }
        isAndroid = z;
    }

    public static void createDipPath(String str) {
        String strSubstring = str.substring(0, str.lastIndexOf("/"));
        File file = new File(str);
        File file2 = new File(strSubstring);
        if (file.exists()) {
            return;
        }
        file2.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static void d(String str) {
        if (allowD) {
            logd(generateTag(getCallerStackTraceElement()), str);
        }
    }

    public static void d(String str, String str2) {
        if (allowD) {
            TAG = str;
            logd(generateTag(getCallerStackTraceElement()), str2);
        }
    }

    public static void d(String str, String str2, boolean z) throws Throwable {
        if (allowD) {
            TAG = str;
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            logd(strGenerateTag, str2);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, str2);
            }
        }
    }

    public static void d(String str, boolean z) throws Throwable {
        if (allowD) {
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            logd(strGenerateTag, str);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, str);
            }
        }
    }

    public static void e(String str) {
        if (allowE) {
            loge(generateTag(getCallerStackTraceElement()), str, null);
        }
    }

    public static void e(String str, String str2) {
        if (allowE) {
            TAG = str;
            loge(generateTag(getCallerStackTraceElement()), str2, null);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (allowE) {
            TAG = str;
            Log.e(generateTag(getCallerStackTraceElement()), str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th, boolean z) throws Throwable {
        if (allowE) {
            TAG = str;
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            loge(strGenerateTag, str2, th);
            String throwable = getThrowable(th, str2);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, throwable);
            }
        }
    }

    public static void e(String str, String str2, boolean z) throws Throwable {
        if (allowE) {
            TAG = str;
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            loge(strGenerateTag, str2, null);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, str2);
            }
        }
    }

    public static void e(String str, Throwable th) {
        if (allowE) {
            Log.e(generateTag(getCallerStackTraceElement()), str, th);
        }
    }

    public static void e(String str, Throwable th, boolean z) throws Throwable {
        if (allowE) {
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            Log.e(strGenerateTag, str, th);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, getThrowable(th, str));
            }
        }
    }

    public static void e(String str, boolean z) throws Throwable {
        if (allowE) {
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            loge(strGenerateTag, str, null);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, str);
            }
        }
    }

    public static void e(Throwable th) {
        if (allowE) {
            loge(generateTag(getCallerStackTraceElement()), getThrowable(th, null), null);
        }
    }

    public static void e(Throwable th, boolean z) throws Throwable {
        if (allowE) {
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            String throwable = getThrowable(th, null);
            loge(strGenerateTag, throwable, null);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, throwable);
            }
        }
    }

    public static String format(String str, Object... objArr) {
        return thread_local_formatter.get().format(str, objArr);
    }

    private static String generateTag(StackTraceElement stackTraceElement) {
        String str = String.format("(%s:%d).%s", stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()), stackTraceElement.getMethodName());
        String str2 = TAG;
        if (str2 == null || "".equalsIgnoreCase(str2)) {
            return str;
        }
        return TAG + ":" + str;
    }

    private static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }

    private static String getThrowable(Throwable th, String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (th != null) {
            sb.append(LINE_BREAK);
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            sb.append(stringWriter.toString());
        }
        return sb.toString();
    }

    public static void i(String str) {
        if (allowI) {
            logi(generateTag(getCallerStackTraceElement()), str);
        }
    }

    public static void i(String str, String str2) {
        if (allowI) {
            TAG = str;
            logi(generateTag(getCallerStackTraceElement()), str2);
        }
    }

    public static void i(String str, String str2, boolean z) throws Throwable {
        if (allowI) {
            TAG = str;
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            logi(strGenerateTag, str2);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, str2);
            }
        }
    }

    public static void i(String str, boolean z) throws Throwable {
        if (allowI) {
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            logi(strGenerateTag, str);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, str);
            }
        }
    }

    public static boolean isSDAva() {
        return (isAndroid && Environment.getExternalStorageState().equals("mounted")) || Environment.getExternalStorageDirectory().exists();
    }

    private static void logd(String str, String str2) {
        if (isAndroid) {
            Log.d(str, str2);
            return;
        }
        System.out.println(str + "-" + str2);
    }

    private static void loge(String str, String str2, Throwable th) {
        if (isAndroid) {
            Log.e(str, str2, th);
            return;
        }
        System.err.println(str + "-" + str2);
    }

    private static void logi(String str, String str2) {
        if (isAndroid) {
            Log.i(str, str2);
            return;
        }
        System.out.println(str + "-" + str2);
    }

    private static void logv(String str, String str2) {
        if (isAndroid) {
            Log.v(str, str2);
            return;
        }
        System.out.println(str + "-" + str2);
    }

    private static void logw(String str, String str2) {
        if (isAndroid) {
            Log.w(str, "" + str2);
            return;
        }
        System.out.println(str + "-" + str2);
    }

    private static void logwtf(String str, String str2) {
        if (isAndroid) {
            Log.wtf(str, str2);
            return;
        }
        System.out.println(str + "-" + str2);
    }

    private static void logwtf(String str, String str2, Throwable th) {
        if (isAndroid) {
            Log.wtf(str, str2, th);
            return;
        }
        System.out.println(str + "-" + str2);
    }

    private static void logwtf(String str, Throwable th) {
        if (isAndroid) {
            Log.wtf(str, th);
            return;
        }
        if (th != null) {
            System.out.println(str + "-" + th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void point(java.lang.String r7, java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.intelligoo.sdk.utils.BleLog.point(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public static void v(String str) {
        if (allowV) {
            logv(generateTag(getCallerStackTraceElement()), str);
        }
    }

    public static void v(String str, String str2) {
        if (allowV) {
            TAG = str;
            logv(generateTag(getCallerStackTraceElement()), str2);
        }
    }

    public static void v(String str, String str2, boolean z) throws Throwable {
        if (allowV) {
            TAG = str;
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            logv(strGenerateTag, str2);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, str2);
            }
        }
    }

    public static void v(String str, boolean z) throws Throwable {
        if (allowV) {
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            logv(strGenerateTag, str);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, str);
            }
        }
    }

    public static void w(String str) {
        if (allowW) {
            logw(generateTag(getCallerStackTraceElement()), str);
        }
    }

    public static void w(String str, String str2) {
        if (allowW) {
            TAG = str;
            logw(generateTag(getCallerStackTraceElement()), str2);
        }
    }

    public static void w(String str, String str2, boolean z) throws Throwable {
        if (allowW) {
            TAG = str;
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            logw(strGenerateTag, str2);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, str2);
            }
        }
    }

    public static void w(String str, boolean z) throws Throwable {
        if (allowW) {
            String strGenerateTag = generateTag(getCallerStackTraceElement());
            logw(strGenerateTag, str);
            if (z && isAndroid) {
                point(PATH_LOG_INFO, strGenerateTag, str);
            }
        }
    }

    public static void wtf(String str) {
        if (allowWtf) {
            logwtf(generateTag(getCallerStackTraceElement()), str);
        }
    }

    public static void wtf(String str, Throwable th) {
        if (allowWtf) {
            logwtf(generateTag(getCallerStackTraceElement()), str, th);
        }
    }

    public static void wtf(Throwable th) {
        if (allowWtf) {
            logwtf(generateTag(getCallerStackTraceElement()), th);
        }
    }
}
