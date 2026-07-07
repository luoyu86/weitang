package com.ss.android.socialbase.appdownloader.kf;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.h;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f9932a = "";
    public static String bl = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f9933h = null;
    private static String kf = null;
    private static String n = null;
    public static String ok = null;
    private static Boolean p = null;
    private static String s = "";

    public static boolean a() {
        return ok("MAGICUI");
    }

    public static boolean bl() {
        return ok("MIUI");
    }

    public static boolean h() {
        return ok("SAMSUNG");
    }

    public static boolean i() {
        if (p == null) {
            p = Boolean.valueOf(s.h().equals("harmony"));
        }
        return p.booleanValue();
    }

    @NonNull
    public static String j() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static String k() {
        if (bl == null) {
            ok("");
        }
        return bl;
    }

    public static boolean kf() {
        return ok("FLYME");
    }

    public static boolean n() {
        td();
        return ok(ok);
    }

    public static boolean ok() {
        return ok("EMUI") || ok("MAGICUI");
    }

    public static String p() {
        if (n == null) {
            ok("");
        }
        return n;
    }

    public static String q() {
        if (kf == null) {
            ok("");
        }
        return kf;
    }

    @NonNull
    public static String r() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean rh() {
        zz();
        return "V11".equals(f9933h);
    }

    public static boolean s() {
        return ok("VIVO");
    }

    public static boolean t() {
        zz();
        return "V12".equals(f9933h);
    }

    private static void td() {
        if (TextUtils.isEmpty(ok)) {
            com.ss.android.socialbase.downloader.downloader.bl.fl();
            ok = com.ss.android.socialbase.downloader.constants.n.f9994a;
            s = "ro.build.version." + com.ss.android.socialbase.downloader.constants.n.bl + "rom";
            f9932a = "com." + com.ss.android.socialbase.downloader.constants.n.bl + ".market";
        }
    }

    public static boolean x() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR)) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR)) {
                return false;
            }
        }
        return true;
    }

    public static boolean z() {
        zz();
        return "V10".equals(f9933h);
    }

    private static void zz() {
        if (f9933h == null) {
            try {
                f9933h = s("ro.miui.ui.version.name");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String str = f9933h;
            if (str == null) {
                str = "";
            }
            f9933h = str;
        }
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                com.ss.android.socialbase.downloader.q.kf.ok(bufferedReader);
                return line;
            } catch (Throwable unused) {
                com.ss.android.socialbase.downloader.q.kf.ok(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String bl(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
    }

    public static boolean ok(String str) {
        td();
        String str2 = n;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strS = s("ro.miui.ui.version.name");
        kf = strS;
        if (TextUtils.isEmpty(strS)) {
            String strS2 = s(com.alipay.sdk.m.c.a.f5275a);
            kf = strS2;
            if (TextUtils.isEmpty(strS2)) {
                String strS3 = s(s);
                kf = strS3;
                if (TextUtils.isEmpty(strS3)) {
                    String strS4 = s("ro.vivo.os.version");
                    kf = strS4;
                    if (TextUtils.isEmpty(strS4)) {
                        String strS5 = s("ro.smartisan.version");
                        kf = strS5;
                        if (TextUtils.isEmpty(strS5)) {
                            String strS6 = s("ro.gn.sv.version");
                            kf = strS6;
                            if (TextUtils.isEmpty(strS6)) {
                                String strS7 = s("ro.lenovo.lvp.version");
                                kf = strS7;
                                if (!TextUtils.isEmpty(strS7)) {
                                    n = "LENOVO";
                                    bl = "com.lenovo.leos.appstore";
                                } else if (r().toUpperCase().contains("SAMSUNG")) {
                                    n = "SAMSUNG";
                                    bl = "com.sec.android.app.samsungapps";
                                } else if (r().toUpperCase().contains("ZTE")) {
                                    n = "ZTE";
                                    bl = "zte.com.market";
                                } else if (r().toUpperCase().contains("NUBIA")) {
                                    n = "NUBIA";
                                    bl = "cn.nubia.neostore";
                                } else if (j().toUpperCase().contains("FLYME")) {
                                    n = "FLYME";
                                    bl = "com.meizu.mstore";
                                    kf = j();
                                } else if (r().toUpperCase().contains("ONEPLUS")) {
                                    n = "ONEPLUS";
                                    kf = s("ro.rom.version");
                                    if (h.ok(f9932a) > -1) {
                                        bl = f9932a;
                                    } else {
                                        bl = "com.heytap.market";
                                    }
                                } else {
                                    n = r().toUpperCase();
                                    bl = "";
                                    kf = "";
                                }
                            } else {
                                n = "QIONEE";
                                bl = "com.gionee.aora.market";
                            }
                        } else {
                            n = "SMARTISAN";
                            bl = "com.smartisanos.appstore";
                        }
                    } else {
                        n = "VIVO";
                        bl = "com.bbk.appstore";
                    }
                } else {
                    n = ok;
                    if (h.ok(f9932a) > -1) {
                        bl = f9932a;
                    } else {
                        bl = "com.heytap.market";
                    }
                }
            } else {
                n = x() ? "MAGICUI" : "EMUI";
                bl = "com.huawei.appmarket";
            }
        } else {
            n = "MIUI";
            bl = "com.xiaomi.market";
            f9933h = kf;
        }
        return n.equals(str);
    }

    public static String s(String str) {
        if (!com.ss.android.socialbase.downloader.h.ok.a().optBoolean("enable_reflect_system_properties", true)) {
            return a(str);
        }
        try {
            return bl(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return a(str);
        }
    }
}
