package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class Utils {
    public static final String SP_AGOO_BIND_FILE_NAME = "EMAS_AGOO_BIND";
    private static final String TAG = "Utils";
    private static int debugMode = 0;
    private static final byte[] mLock = new byte[0];
    private static int targetSdkVersion = -1;

    public static void clearAgooBindCache(Context context) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("EMAS_AGOO_BIND", 0).edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Exception e2) {
            ALog.e(TAG, "clearAgooBindCache", e2, new Object[0]);
        }
    }

    public static void clearAllSharePreferences(Context context) {
        try {
            synchronized (mLock) {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                editorEdit.clear();
                editorEdit.apply();
            }
        } catch (Throwable th) {
            ALog.e(TAG, "clearAllSharePreferences", th, new Object[0]);
        }
    }

    public static Bundle getMetaInfo(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            return null;
        } catch (Throwable th) {
            ALog.e(TAG, "getMetaInfo", th, new Object[0]);
            return null;
        }
    }

    public static int getMode() {
        return debugMode;
    }

    public static String getSpValue(Context context, String str, String str2) {
        String string = null;
        try {
            synchronized (mLock) {
                string = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(str, null);
            }
            ALog.i(TAG, "getSpValue", com.alipay.sdk.m.p0.b.f5579d, string);
            if (TextUtils.isEmpty(string)) {
                ALog.e(TAG, "getSpValue use default!", new Object[0]);
                return str2;
            }
        } catch (Throwable th) {
            ALog.e(TAG, "getSpValue fail", th, new Object[0]);
        }
        return string;
    }

    public static boolean isIPV6Address(String str) {
        int i2;
        boolean z;
        int i3;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        if (charArray.length < 2) {
            return false;
        }
        if (charArray[0] != ':') {
            i2 = 0;
            z = false;
            i3 = 0;
        } else {
            if (charArray[1] != ':') {
                return false;
            }
            i2 = 1;
            z = false;
            i3 = 1;
        }
        int i4 = 0;
        boolean z2 = true;
        while (i2 < charArray.length) {
            char c2 = charArray[i2];
            int iDigit = Character.digit(c2, 16);
            if (iDigit != -1) {
                i4 = (i4 << 4) + iDigit;
                if (i4 > 65535) {
                    return false;
                }
                z2 = false;
            } else {
                if (c2 != ':' || (i3 = i3 + 1) > 7) {
                    return false;
                }
                if (!z2) {
                    i4 = 0;
                    z2 = true;
                } else {
                    if (z) {
                        return false;
                    }
                    z = true;
                }
            }
            i2++;
        }
        return z || i3 >= 7;
    }

    public static boolean isTarget26(Context context) {
        if (context == null) {
            return false;
        }
        if (targetSdkVersion == -1) {
            targetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        }
        return targetSdkVersion >= 26 && Build.VERSION.SDK_INT >= 26;
    }

    public static void killService(Context context) {
        try {
            Class<?> clsLoadClass = com.taobao.accs.b.a.a().b().loadClass("com.taobao.accs.utl.UtilityImpl");
            clsLoadClass.getMethod("killService", Context.class).invoke(clsLoadClass, context);
        } catch (Throwable th) {
            ALog.e(TAG, "killService", th, new Object[0]);
        }
    }

    public static void setAgooAppKey(Context context, String str) {
        try {
            Class<?> clsLoadClass = com.taobao.accs.b.a.a().b().loadClass("org.android.agoo.common.Config");
            clsLoadClass.getMethod("setAgooAppKey", Context.class, String.class).invoke(clsLoadClass, context, str);
        } catch (Throwable th) {
            ALog.e(TAG, "setAgooAppKey", th, new Object[0]);
            th.printStackTrace();
        }
    }

    public static void setMode(int i2) {
        debugMode = i2;
    }

    public static void setSpValue(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            ALog.e(TAG, "setSpValue null", new Object[0]);
            return;
        }
        try {
            synchronized (mLock) {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                editorEdit.putString(str, str2);
                editorEdit.apply();
            }
            ALog.i(TAG, "setSpValue", "key", str, com.alipay.sdk.m.p0.b.f5579d, str2);
        } catch (Exception e2) {
            ALog.e(TAG, "setSpValue fail", e2, new Object[0]);
        }
    }
}
