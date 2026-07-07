package com.ss.android.socialbase.downloader.constants;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f9994a = "";
    public static volatile String bl = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f9995h = 31457280;
    public static long kf = 5242880;
    public static long n = 50;
    public static volatile String ok = "";
    public static long p = 10485760;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final JSONObject f9996q = new JSONObject();
    public static long s = 512000;

    public static void ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ok = str;
    }
}
