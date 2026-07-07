package com.ss.android.downloadlib.h;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes2.dex */
public class ok {

    /* JADX INFO: renamed from: com.ss.android.downloadlib.h.ok$ok, reason: collision with other inner class name */
    public static class C0136ok implements InvocationHandler {
        private Object ok;

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("startActivity".contains(method.getName())) {
                    ok.ok(objArr);
                }
            } catch (Throwable unused) {
            }
            return method.invoke(this.ok, objArr);
        }

        private C0136ok(Object obj) {
            this.ok = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bl() {
        try {
            Field declaredField = Build.VERSION.SDK_INT < 26 ? Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault") : Class.forName("android.app.ActivityManager").getDeclaredField("IActivityManagerSingleton");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = Class.forName("android.util.Singleton").getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            if (obj2 == null) {
                return;
            }
            declaredField2.set(obj, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Class.forName("android.app.IActivityManager")}, new C0136ok(obj2)));
        } catch (Throwable unused) {
        }
    }

    public static String ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.ok.bl.ok(new File(str));
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = com.ss.android.downloadlib.addownload.r.getContext().getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return applicationInfo.sourceDir;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int ok(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return 5;
        }
        return com.ss.android.ok.bl.ok(str, new File(str2));
    }

    public static void ok() {
        if (com.ss.android.downloadlib.addownload.r.q().optInt("hook", 0) != 1) {
            return;
        }
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.h.ok.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.kf.n.p();
                ok.bl();
            }
        }, 10000L);
    }

    public static void ok(Object[] objArr) {
        if (com.ss.android.downloadlib.addownload.r.q().optInt("hook", 0) == 1 && (objArr[1] instanceof String) && (objArr[2] instanceof Intent)) {
            Intent intent = (Intent) objArr[2];
            if ("android.intent.action.VIEW".equals(intent.getAction()) && com.ss.android.socialbase.downloader.constants.n.ok.equals(intent.getType())) {
                if (com.ss.android.socialbase.appdownloader.kf.n.s()) {
                    String strOptString = com.ss.android.downloadlib.addownload.r.q().optString("hook_vivo_arg", "com.android.settings");
                    if ("null".equals(strOptString)) {
                        return;
                    }
                    objArr[1] = strOptString;
                    return;
                }
                if (com.ss.android.socialbase.appdownloader.kf.n.n()) {
                    String strOptString2 = com.ss.android.downloadlib.addownload.r.q().optString("hook_kllk_arg1", "com." + com.ss.android.socialbase.downloader.constants.n.bl + ".market");
                    if (!"null".equals(strOptString2)) {
                        objArr[1] = strOptString2;
                    }
                    String strOptString3 = com.ss.android.downloadlib.addownload.r.q().optString("hook_kllk_arg2", "com.android.browser");
                    String strOptString4 = com.ss.android.downloadlib.addownload.r.q().optString("hook_kllk_arg3", "m.store." + com.ss.android.socialbase.downloader.constants.n.bl + "mobile.com");
                    StringBuilder sb = new StringBuilder();
                    sb.append(com.ss.android.socialbase.downloader.constants.n.bl);
                    sb.append("_extra_pkg_name");
                    intent.putExtra(sb.toString(), strOptString3);
                    intent.putExtra("refererHost", strOptString4);
                    if (com.ss.android.downloadlib.addownload.r.q().optInt("hook_kllk_arg4", 0) == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(com.ss.android.socialbase.downloader.constants.n.bl + "_extra_pkg_name", strOptString3);
                        intent2.putExtra("refererHost", strOptString4);
                        intent.putExtra("android.intent.extra.INTENT", intent2);
                        return;
                    }
                    return;
                }
                if (com.ss.android.socialbase.appdownloader.kf.n.ok()) {
                    String strOptString5 = com.ss.android.downloadlib.addownload.r.q().optString("hook_huawei_arg1", "com.huawei.appmarket");
                    if (!"null".equals(strOptString5)) {
                        objArr[1] = strOptString5;
                    }
                    intent.putExtra("caller_package", com.ss.android.downloadlib.addownload.r.q().optString("hook_huawei_arg2", "com.huawei.appmarket"));
                }
            }
        }
    }
}
