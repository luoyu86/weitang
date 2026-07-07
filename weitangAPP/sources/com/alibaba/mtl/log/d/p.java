package com.alibaba.mtl.log.d;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class p {
    public static void a(Context context, String str, String str2) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editorEdit;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ut_setting", 4)) == null || (editorEdit = sharedPreferences.edit()) == null) {
            return;
        }
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static String getString(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getSharedPreferences("ut_setting", 4)) == null) {
            return null;
        }
        return sharedPreferences.getString(str, null);
    }
}
