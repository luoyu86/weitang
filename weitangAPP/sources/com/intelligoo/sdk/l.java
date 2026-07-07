package com.intelligoo.sdk;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f9276a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9277b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f9278c = false;

    private static String a(Exception exc, String str) {
        StackTraceElement[] stackTrace = exc.getStackTrace();
        if (stackTrace == null || stackTrace.length <= 1) {
            return "[EMPTY]";
        }
        return str + " " + stackTrace[1].getFileName() + ":" + stackTrace[1].getMethodName() + ":" + stackTrace[1].getLineNumber();
    }

    public static void a(String str) {
        if (f9276a) {
            Log.e(a(new Exception(), "[debug]"), str);
        }
    }

    public static void a(boolean z) {
        if (z || !f9278c) {
        } else {
            Log.e(a(new Exception(), "[assert] "), "assert happend");
            while (true) {
            }
        }
    }

    public static void b(String str) {
        if (f9277b) {
            Log.e(a(new Exception(), "[error]"), str);
        }
    }
}
