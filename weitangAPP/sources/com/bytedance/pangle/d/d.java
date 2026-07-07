package com.bytedance.pangle.d;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<String> f5988b = new CopyOnWriteArrayList();

    public static String a() {
        if (!TextUtils.isEmpty(f5987a)) {
            return f5987a;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName)) {
                    f5987a = processName;
                }
                return f5987a;
            }
        } catch (Throwable unused) {
        }
        try {
            Object objInvokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
            if (!TextUtils.isEmpty((String) objInvokeStaticMethod)) {
                f5987a = (String) objInvokeStaticMethod;
            }
            return f5987a;
        } catch (Exception e2) {
            e2.printStackTrace();
            String strB = b();
            f5987a = strB;
            return strB;
        }
    }

    private static String b() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int i2 = bufferedReader.read();
                    if (i2 <= 0) {
                        break;
                    }
                    sb.append((char) i2);
                }
                if (ZeusLogger.isDebug()) {
                    ZeusLogger.d("Process", "get processName = " + sb.toString());
                }
                String string = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return string;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static boolean a(Context context) {
        String strA = a();
        return (strA == null || !strA.contains(":")) && strA != null && strA.equals(context.getPackageName());
    }

    public static String a(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(":")) ? "main" : str.split(":")[1];
    }
}
