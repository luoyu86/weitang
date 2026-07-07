package com.ss.android.socialbase.downloader.bl;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AbstractC0149ok f9989a = null;
    private static int ok = 4;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.bl.ok$ok, reason: collision with other inner class name */
    public static abstract class AbstractC0149ok {
        public void a(String str, String str2) {
        }

        public void bl(String str, String str2) {
        }

        public void n(String str, String str2) {
        }

        public void ok(String str, String str2) {
        }

        public void ok(String str, String str2, Throwable th) {
        }

        public void s(String str, String str2) {
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "DownloaderLogger";
        }
        return "Downloader-" + str;
    }

    public static void bl(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (ok <= 4) {
            Log.i(a(str), str2);
        }
        AbstractC0149ok abstractC0149ok = f9989a;
        if (abstractC0149ok != null) {
            abstractC0149ok.bl(a(str), str2);
        }
    }

    public static void n(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (ok <= 6) {
            Log.e(a(str), str2);
        }
        AbstractC0149ok abstractC0149ok = f9989a;
        if (abstractC0149ok != null) {
            abstractC0149ok.s(a(str), str2);
        }
    }

    public static void ok(int i2) {
        ok = i2;
    }

    public static void s(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (ok <= 5) {
            Log.w(a(str), str2);
        }
        AbstractC0149ok abstractC0149ok = f9989a;
        if (abstractC0149ok != null) {
            abstractC0149ok.n(a(str), str2);
        }
    }

    public static boolean ok() {
        return ok <= 3;
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (ok <= 3) {
            Log.d(a(str), str2);
        }
        AbstractC0149ok abstractC0149ok = f9989a;
        if (abstractC0149ok != null) {
            abstractC0149ok.a(a(str), str2);
        }
    }

    public static void ok(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (ok <= 2) {
            Log.v(str, str2);
        }
        AbstractC0149ok abstractC0149ok = f9989a;
        if (abstractC0149ok != null) {
            abstractC0149ok.ok(a(str), str2);
        }
    }

    public static void bl(String str) {
        s("DownloaderLogger", str);
    }

    public static void a(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (ok <= 6) {
            Log.e(a(str), str2, th);
        }
        AbstractC0149ok abstractC0149ok = f9989a;
        if (abstractC0149ok != null) {
            abstractC0149ok.ok(a(str), str2, th);
        }
    }

    public static void ok(String str) {
        a("DownloaderLogger", str);
    }

    public static void ok(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (ok <= 3) {
            Log.d(a(str), str2, th);
        }
        AbstractC0149ok abstractC0149ok = f9989a;
        if (abstractC0149ok != null) {
            abstractC0149ok.a(a(str), str2 + th);
        }
    }
}
