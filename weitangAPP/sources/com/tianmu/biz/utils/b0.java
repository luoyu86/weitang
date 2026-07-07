package com.tianmu.biz.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class b0 {
    public static boolean a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }
}
