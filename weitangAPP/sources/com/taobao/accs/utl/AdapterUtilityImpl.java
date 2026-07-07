package com.taobao.accs.utl;

import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.ta.utdid2.device.UTDevice;
import com.taobao.accs.ChannelService;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.data.MsgDistributeService;
import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class AdapterUtilityImpl {
    public static String BACK_APP_KEY = "";
    private static final String TAG = "AdapterUtilityImpl";
    private static boolean channelProcessChecked = false;
    private static String channelProcessName = "";
    private static boolean isChannelProcess = true;
    private static boolean isTargetProcess = true;
    public static String mAgooAppSecret = null;
    private static boolean mChecked = false;
    private static boolean mIsMainProc = true;
    private static boolean targetProcessChecked = false;
    private static String targetProcessName = "";
    public static final String channelService = ChannelService.class.getName();
    public static final String msgService = MsgDistributeService.class.getName();

    public static boolean checkIsWritable(String str, int i2) {
        if (str == null) {
            return false;
        }
        StatFs statFs = new StatFs(str);
        int blockSize = statFs.getBlockSize();
        boolean z = statFs.getAvailableBlocks() > 10 && ((long) statFs.getAvailableBlocks()) * ((long) blockSize) > ((long) i2);
        if (!z) {
            ALog.w("FileCheckUtils", "target : " + i2 + " st.getAvailableBlocks()=" + statFs.getAvailableBlocks() + ",st.getAvailableBlocks() * blockSize=" + (((long) statFs.getAvailableBlocks()) * ((long) blockSize)), new Object[0]);
        }
        return z;
    }

    public static String getChannelProcess(Context context) {
        if (TextUtils.isEmpty(channelProcessName)) {
            channelProcessName = getServiceProcess(context, channelService);
        }
        return channelProcessName;
    }

    public static String getDeviceId(Context context) {
        return UTDevice.getUtdid(context);
    }

    public static String getProcessName(Context context) throws Throwable {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        String processNameByActivityThread = getProcessNameByActivityThread(context);
        if (!TextUtils.isEmpty(processNameByActivityThread)) {
            return processNameByActivityThread;
        }
        String processNameByPid = getProcessNameByPid();
        return !TextUtils.isEmpty(processNameByPid) ? processNameByPid : "";
    }

    private static String getProcessNameByActivityThread(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e2) {
            ALog.w(TAG, "getProcessNameByActivityThread error: ", e2, new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String getProcessNameByPid() throws java.lang.Throwable {
        /*
            int r0 = android.os.Process.myPid()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            r3.<init>()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            r3.append(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            java.lang.String r0 = "/cmdline"
            r3.append(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            boolean r0 = r2.exists()     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            if (r0 == 0) goto L3e
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L4b java.lang.Exception -> L50
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L67
            java.lang.String r1 = r2.trim()     // Catch: java.lang.Exception -> L3c java.lang.Throwable -> L67
            r6 = r1
            r1 = r0
            r0 = r6
            goto L3f
        L3c:
            r2 = move-exception
            goto L52
        L3e:
            r0 = r1
        L3f:
            if (r1 == 0) goto L49
            r1.close()     // Catch: java.io.IOException -> L45
            goto L49
        L45:
            r1 = move-exception
            r1.printStackTrace()
        L49:
            r1 = r0
            goto L66
        L4b:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L68
        L50:
            r2 = move-exception
            r0 = r1
        L52:
            java.lang.String r3 = "AdapterUtilityImpl"
            java.lang.String r4 = "getProcessNameByPid error: "
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L67
            com.taobao.accs.utl.ALog.w(r3, r4, r2, r5)     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto L66
            r0.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r0 = move-exception
            r0.printStackTrace()
        L66:
            return r1
        L67:
            r1 = move-exception
        L68:
            if (r0 == 0) goto L72
            r0.close()     // Catch: java.io.IOException -> L6e
            goto L72
        L6e:
            r0 = move-exception
            r0.printStackTrace()
        L72:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.AdapterUtilityImpl.getProcessNameByPid():java.lang.String");
    }

    public static String getServiceProcess(Context context, String str) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, str), 131584);
            if (serviceInfo == null) {
                return null;
            }
            String str2 = serviceInfo.processName;
            if (str2 == null) {
                return context.getPackageName();
            }
            if (!str2.startsWith(":")) {
                return serviceInfo.processName;
            }
            return context.getPackageName() + serviceInfo.processName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String getStackMsg(Throwable th) {
        StringBuilder sb = new StringBuilder();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public static String getTargetProcess(Context context) {
        if (TextUtils.isEmpty(targetProcessName)) {
            targetProcessName = getServiceProcess(context, msgService);
        }
        return targetProcessName;
    }

    public static long getUsableSpace() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return -1L;
            }
            return dataDirectory.getUsableSpace();
        } catch (Throwable th) {
            ALog.e(TAG, "getUsableSpace", th, new Object[0]);
            return -1L;
        }
    }

    public static boolean isChannelProcess(Context context) throws Throwable {
        if (channelProcessChecked) {
            return isChannelProcess;
        }
        String processName = getProcessName(context);
        if (TextUtils.isEmpty(channelProcessName)) {
            channelProcessName = getServiceProcess(context, channelService);
        }
        boolean zEqualsIgnoreCase = processName.equalsIgnoreCase(channelProcessName);
        isChannelProcess = zEqualsIgnoreCase;
        channelProcessChecked = true;
        return zEqualsIgnoreCase;
    }

    public static boolean isMainProcess(Context context) throws Throwable {
        if (mChecked) {
            return mIsMainProc;
        }
        boolean zEqualsIgnoreCase = context.getPackageName().equalsIgnoreCase(getProcessName(context));
        mIsMainProc = zEqualsIgnoreCase;
        mChecked = true;
        return zEqualsIgnoreCase;
    }

    public static boolean isNetworkConnected(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = AdapterGlobalClientInfo.getInstance(context).getConnectivityManager().getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String isNotificationEnabled(Context context) {
        boolean z = true;
        if (!Utils.isTarget26(context)) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i2 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                if (((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i2), packageName)).intValue() != 0) {
                    z = false;
                }
                return String.valueOf(z);
            } catch (Throwable th) {
                ALog.e(TAG, "isNotificationEnabled", th, new Object[0]);
                return "unknown";
            }
        }
        ApplicationInfo applicationInfo2 = context.getApplicationInfo();
        String packageName2 = context.getApplicationContext().getPackageName();
        int i3 = applicationInfo2.uid;
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Method declaredMethod = notificationManager.getClass().getDeclaredMethod("getService", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(notificationManager, new Object[0]);
            Method declaredMethod2 = objInvoke.getClass().getDeclaredMethod("areNotificationsEnabledForPackage", String.class, Integer.TYPE);
            declaredMethod2.setAccessible(true);
            return String.valueOf(declaredMethod2.invoke(objInvoke, packageName2, Integer.valueOf(i3)));
        } catch (Throwable th2) {
            ALog.e(TAG, "Android O isNotificationEnabled", th2, new Object[0]);
            return "unknown";
        }
    }

    public static boolean isTargetProcess(Context context) throws Throwable {
        if (targetProcessChecked) {
            return isTargetProcess;
        }
        String processName = getProcessName(context);
        if (TextUtils.isEmpty(targetProcessName)) {
            targetProcessName = getServiceProcess(context, msgService);
        }
        boolean zEqualsIgnoreCase = processName.equalsIgnoreCase(targetProcessName);
        isTargetProcess = zEqualsIgnoreCase;
        targetProcessChecked = true;
        return zEqualsIgnoreCase;
    }
}
