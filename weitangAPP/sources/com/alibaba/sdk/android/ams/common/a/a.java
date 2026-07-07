package com.alibaba.sdk.android.ams.common.a;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Context f4586a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Application f4587b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f4588c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile String f4589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile String f4590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile String f4591f;

    public static Context a() {
        return f4586a;
    }

    public static String a(String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = f4586a.getPackageManager().getApplicationInfo(f4586a.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey(str)) {
                return null;
            }
            return String.valueOf(applicationInfo.metaData.get(str));
        } catch (PackageManager.NameNotFoundException unused) {
            AmsLogger.getImportantLogger().e("Meta data name " + str + " not found!");
            return null;
        }
    }

    public static boolean b() {
        return f4588c;
    }

    public static String c() {
        return f4589d == null ? "mpush-api.aliyun.com" : f4589d;
    }

    public static String d() {
        return f4590e == null ? "msgacs.cn-zhangjiakou.aliyuncs.com" : f4590e;
    }

    public static String e() {
        return f4591f == null ? "jmacs.cn-zhangjiakou.aliyuncs.com" : f4591f;
    }

    public static boolean f() {
        return c().equals("mpush-api.aliyun.com");
    }

    public static String g() {
        return "https://" + c() + "/config";
    }

    public static SharedPreferences h() {
        return PreferenceManager.getDefaultSharedPreferences(f4586a);
    }

    public static String i() {
        return f4586a.getPackageName();
    }
}
