package com.tianmu.biz.utils;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class j0 {
    private static SharedPreferences a(@NonNull Context context) {
        return context.getSharedPreferences(context.getPackageName(), 0);
    }

    public static void b(Context context, String str, String str2) {
        a(context).edit().putString(str, str2).apply();
    }

    public static String a(Context context, String str) {
        return a(context, str, "");
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(str, str2);
    }
}
