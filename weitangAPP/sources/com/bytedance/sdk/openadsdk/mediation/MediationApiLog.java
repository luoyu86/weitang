package com.bytedance.sdk.openadsdk.mediation;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class MediationApiLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f6390a = "MEDIATION_LOG";
    private static boolean ok;

    public static void e(String str, String str2) {
        if (ok) {
            Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (ok) {
            Log.i(str, str2);
        }
    }

    public static void setDebug(Boolean bool) {
        ok = bool.booleanValue();
    }

    public static void e(String str) {
        if (ok) {
            Log.e(f6390a, str);
        }
    }

    public static void i(String str) {
        if (ok) {
            Log.i(f6390a, str);
        }
    }
}
