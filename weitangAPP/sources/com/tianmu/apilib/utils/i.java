package com.tianmu.apilib.utils;

import android.content.SharedPreferences;
import com.tianmu.TianmuSDK;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static i f10800a;

    private i() {
    }

    public static i a() {
        if (f10800a == null) {
            synchronized (i.class) {
                if (f10800a == null) {
                    f10800a = new i();
                }
            }
        }
        return f10800a;
    }

    private SharedPreferences b(String str) {
        if (str == null) {
            return TianmuSDK.getInstance().getContext().getSharedPreferences("cn.admobiletop.adsuyi", 0);
        }
        return TianmuSDK.getInstance().getContext().getSharedPreferences("cn.admobiletop.adsuyi." + str, 0);
    }

    public boolean a(String str, String str2) {
        try {
            return b(str).getBoolean(str2, false);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean a(String str) {
        return a(null, str);
    }
}
