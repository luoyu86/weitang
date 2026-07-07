package com.tianmu.biz.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class d0 {
    public static String a() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_ANDROID_ID");
        return !TextUtils.isEmpty(strC) ? com.tianmu.c.d.a.a(strC, "0127fe163klj41b9") : "";
    }

    public static String b() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_OS_BOOT_MARK");
        return !TextUtils.isEmpty(strC) ? strC : "";
    }

    public static String c() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_IMEI");
        return !TextUtils.isEmpty(strC) ? com.tianmu.c.d.a.a(strC, "0127fe163klj41b9") : "";
    }

    public static String d() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_IMSI");
        return !TextUtils.isEmpty(strC) ? com.tianmu.c.d.a.a(strC, "0127fe163klj41b9") : "";
    }

    public static String e() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_IPV6");
        return !TextUtils.isEmpty(strC) ? com.tianmu.c.d.a.a(strC, "0127fe163klj41b9") : "";
    }

    public static String f() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_LAT");
        return !TextUtils.isEmpty(strC) ? strC : "";
    }

    public static String g() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_LNG");
        return !TextUtils.isEmpty(strC) ? strC : "";
    }

    public static String h() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_MAC");
        return !TextUtils.isEmpty(strC) ? com.tianmu.c.d.a.a(strC, "0127fe163klj41b9") : "";
    }

    public static String i() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_OS_UPDATE_MARK");
        return !TextUtils.isEmpty(strC) ? strC : "";
    }

    public static String j() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_WIFI_MAC");
        return !TextUtils.isEmpty(strC) ? strC : "";
    }

    public static String k() {
        String strC = i0.a().c("TIANMU_pis_sp", "TIANMU_WIFI_NAME");
        return !TextUtils.isEmpty(strC) ? strC : "";
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_OS_BOOT_MARK", str);
    }

    public static void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_LAT", str);
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_LNG", str);
    }

    public static void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_OS_UPDATE_MARK", str);
    }

    public static void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_WIFI_MAC", str);
    }

    public static void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_WIFI_NAME", str);
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = com.tianmu.c.d.a.b(str, "0127fe163klj41b9");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_ANDROID_ID", strB);
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = com.tianmu.c.d.a.b(str, "0127fe163klj41b9");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_IMEI", strB);
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = com.tianmu.c.d.a.b(str, "0127fe163klj41b9");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_IMSI", strB);
    }

    public static void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = com.tianmu.c.d.a.b(str, "0127fe163klj41b9");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_IPV6", strB);
    }

    public static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = com.tianmu.c.d.a.b(str, "0127fe163klj41b9");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        i0.a().a("TIANMU_pis_sp", "TIANMU_MAC", strB);
    }
}
