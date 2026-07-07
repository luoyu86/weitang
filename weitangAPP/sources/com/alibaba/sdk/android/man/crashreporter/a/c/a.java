package com.alibaba.sdk.android.man.crashreporter.a.c;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.alipay.sdk.m.u.i;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final int s = -1;
    private static final int t = 0;
    private static final int u = 1;
    private static int v = -1;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m42a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("getCurProcessName error.", e2);
            return null;
        }
    }

    public static String b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "null";
        }
        String strSubstring = "{";
        try {
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                if (str2 != null) {
                    strSubstring = strSubstring + "\"" + ((Object) str) + "\":\"" + str2 + "\",";
                }
            }
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            return strSubstring + i.f5699d;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("simpleMapToJsonStr error.", e2);
            return strSubstring;
        }
    }

    public static String c(Context context) {
        try {
            return (com.alibaba.sdk.android.man.crashreporter.e.a.d(context) && com.alibaba.sdk.android.man.crashreporter.e.a.m50e(context)) ? com.alibaba.sdk.android.man.crashreporter.e.a.c(context) : "127.0.0.1";
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("getWifiIpAddress error.", e2);
            return "127.0.0.1";
        }
    }

    public static String getExternalStorageState() {
        try {
            return Environment.getExternalStorageState();
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("hasSDCard error.", e2);
            return "unknown";
        }
    }

    public static double a(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String line = bufferedReader.readLine();
            String[] strArrSplit = line.split("\\s+");
            for (String str : strArrSplit) {
                com.alibaba.sdk.android.man.crashreporter.b.a.c(line, str + "\t");
            }
            long jIntValue = Integer.valueOf(strArrSplit[1]).intValue();
            bufferedReader.close();
            return jIntValue / 1024;
        } catch (IOException e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("getTotalMemory error.", e2);
            return -1.0d;
        }
    }

    public static double b(Context context) {
        try {
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
            return (r0.availMem / 1024) / 1024;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("getAvailMemory error.", e2);
            return -1.0d;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static String m44b(Context context) {
        try {
            return ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().get(0).processName;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("getRunningActivityName error.", e2);
            return "";
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m43a(Context context) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    if (runningAppProcessInfo.importance == 400) {
                        com.alibaba.sdk.android.man.crashreporter.b.a.b("app is background :", runningAppProcessInfo.processName);
                        return true;
                    }
                    com.alibaba.sdk.android.man.crashreporter.b.a.b("app is foreground:", runningAppProcessInfo.processName);
                    return false;
                }
            }
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("isBackgroundRunning  error.", e2);
        }
        return false;
    }

    public static boolean b() {
        int i2 = v;
        if (i2 == 1) {
            return true;
        }
        if (i2 == 0) {
            return false;
        }
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i3 = 0; i3 < 5; i3++) {
            try {
                if (new File(strArr[i3] + "su").exists()) {
                    v = 1;
                    return true;
                }
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("isRootSystem error.", e2);
            }
        }
        v = 0;
        return false;
    }

    public static long[] a(boolean z) {
        File externalStorageDirectory;
        long[] jArr = {-1, -1, -1};
        try {
            if (z) {
                externalStorageDirectory = Environment.getDataDirectory();
            } else {
                externalStorageDirectory = Environment.getExternalStorageDirectory();
            }
            if (externalStorageDirectory != null) {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                int blockSize = statFs.getBlockSize();
                int blockCount = statFs.getBlockCount();
                int freeBlocks = statFs.getFreeBlocks();
                int availableBlocks = statFs.getAvailableBlocks();
                jArr[0] = blockCount * blockSize;
                jArr[1] = freeBlocks * blockSize;
                jArr[2] = blockSize * availableBlocks;
            }
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("getStorageSize error.", e2);
        }
        return jArr;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m45b(Context context) {
        try {
            return (context.getApplicationInfo().flags & 262144) != 0;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("isInstallOnSDCard error.", e2);
            return false;
        }
    }
}
