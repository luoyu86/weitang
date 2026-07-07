package com.alibaba.mtl.log.d;

import android.os.Process;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class i {
    private static boolean K = false;
    private static boolean L = false;
    private static String aj = "UTAnalytics:";

    public static void a(String str, Object... objArr) {
        if (L) {
            String str2 = aj + str;
            StringBuilder sb = new StringBuilder();
            sb.append("pid:");
            sb.append(Process.myPid());
            sb.append(" ");
            if (objArr != null) {
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    if (objArr[i2] != null) {
                        String string = objArr[i2].toString();
                        if (string.endsWith(":") || string.endsWith(": ")) {
                            sb.append(string);
                        } else {
                            sb.append(string);
                            sb.append(",");
                        }
                    }
                }
            }
            Log.d(str2, sb.toString());
        }
    }

    public static void d(boolean z) {
        L = z;
    }

    public static boolean k() {
        return K;
    }

    public static boolean l() {
        return L;
    }

    public static void a(String str, Object obj, Throwable th) {
        if (l() || k()) {
            Log.w(str + aj, obj + "", th);
        }
    }

    public static void a(String str, Object obj) {
        if (l() || k()) {
            Log.w(str + aj, obj + "");
        }
    }

    public static void a(String str, String... strArr) {
        if (L) {
            String str2 = aj + str;
            StringBuilder sb = new StringBuilder();
            sb.append("pid:");
            sb.append(Process.myPid());
            sb.append(" ");
            if (strArr != null) {
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    if (strArr[i2] != null) {
                        String str3 = strArr[i2];
                        if (!str3.endsWith(":") && !str3.endsWith(": ")) {
                            sb.append(str3);
                            sb.append(",");
                        } else {
                            sb.append(str3);
                        }
                    }
                }
            }
            Log.i(str2, sb.toString());
        }
    }
}
