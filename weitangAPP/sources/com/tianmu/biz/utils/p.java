package com.tianmu.biz.utils;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10893a = "TIANMU_ID_SAVE_KEY";

    public static void a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            j0.b(context, f10893a, str);
        } catch (Exception unused) {
        }
    }

    public static String a(Context context) {
        try {
            return j0.a(context, f10893a);
        } catch (Exception unused) {
            return null;
        }
    }
}
