package com.tianmu.biz.utils;

import android.text.TextUtils;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10901a;

    public static String a() {
        try {
            if (!TextUtils.isEmpty(f10901a)) {
                return f10901a;
            }
            String displayName = TimeZone.getDefault().getDisplayName(false, 0);
            f10901a = displayName;
            return displayName;
        } catch (AssertionError | Exception unused) {
            return "";
        }
    }
}
