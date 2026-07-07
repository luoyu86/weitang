package com.tianmu.biz.utils;

import android.content.SharedPreferences;
import com.tianmu.TianmuSDK;

/* JADX INFO: loaded from: classes2.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i0 f10864a;

    private i0() {
    }

    public static i0 a() {
        if (f10864a == null) {
            synchronized (i0.class) {
                if (f10864a == null) {
                    f10864a = new i0();
                }
            }
        }
        return f10864a;
    }

    public long b(String str) {
        return b(null, str);
    }

    public String c(String str) {
        return c(null, str);
    }

    public void d(String str, String str2) {
        a((String) null, str, str2);
    }

    private SharedPreferences d(String str) {
        if (str == null) {
            return TianmuSDK.getInstance().getContext().getSharedPreferences("com.tianmu.sp", 0);
        }
        return TianmuSDK.getInstance().getContext().getSharedPreferences("com.tianmu.sp." + str, 0);
    }

    public long b(String str, String str2) {
        try {
            return d(str).getLong(str2, 0L);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0L;
        }
    }

    public String c(String str, String str2) {
        try {
            return d(str).getString(str2, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            d(str).edit().putString(str2, str3).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, long j) {
        a((String) null, str, j);
    }

    public void a(String str, String str2, long j) {
        try {
            d(str).edit().putLong(str2, j).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a(String str, String str2) {
        try {
            return d(str).getBoolean(str2, false);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean a(String str) {
        return a((String) null, str);
    }

    public void a(String str, String str2, boolean z) {
        try {
            d(str).edit().putBoolean(str2, z).apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a(String str, boolean z) {
        a((String) null, str, z);
    }
}
