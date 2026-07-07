package com.alipay.sdk.m.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5275a = "ro.build.version.emui";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f5276b = "hw_sc.build.platform.version";

    public static com.alipay.sdk.m.b.b a(Context context) {
        String str = Build.BRAND;
        com.alipay.sdk.m.d.a.b("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI) || str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HONOR) || str.equalsIgnoreCase("华为")) {
            return new b();
        }
        if (str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new i();
        }
        if (str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO)) {
            return new h();
        }
        if (str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO) || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new f();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new c();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new e();
        }
        if (str.equalsIgnoreCase("samsung")) {
            return new g();
        }
        if (a()) {
            return new b();
        }
        if (str.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU) || str.equalsIgnoreCase("mblu")) {
            return new d();
        }
        return null;
    }

    public static boolean a() {
        return (TextUtils.isEmpty(a(f5275a)) && TextUtils.isEmpty(a(f5276b))) ? false : true;
    }

    public static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
