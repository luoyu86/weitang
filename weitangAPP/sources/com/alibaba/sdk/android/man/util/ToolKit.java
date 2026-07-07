package com.alibaba.sdk.android.man.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tom_roush.fontbox.ttf.OpenTypeScript;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class ToolKit {
    private static final String TAG = "MAN_ToolKit";
    private static final String validIp = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
    private static Pattern patternIp = Pattern.compile(validIp);
    private static final String validHostnameRegex = "^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])$";
    private static Pattern patternHost = Pattern.compile(validHostnameRegex);

    public static Object checkNotNull(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalArgumentException(String.valueOf(obj2));
    }

    public static long convertStr2Long(String str) {
        try {
            return Long.valueOf(str).longValue();
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    public static long getCurrentThreadId() {
        return Thread.currentThread().getId();
    }

    public static String getMetaDataAppKey(Context context) {
        String string;
        Bundle bundle;
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                string = "";
            } else {
                Object obj = bundle.get(MANConfig.MAN_APPKEY_META_DATA_KEY);
                string = ((obj instanceof String) || obj == null) ? (String) obj : obj.toString();
                try {
                    MANLog.Logi(TAG, "appKey : " + string);
                } catch (PackageManager.NameNotFoundException e2) {
                    str = string;
                    e = e2;
                    e.printStackTrace();
                    return str;
                }
            }
            return string == null ? "" : string;
        } catch (PackageManager.NameNotFoundException e3) {
            e = e3;
        }
    }

    public static String getMetaDataAppSecret(Context context) {
        String string;
        Bundle bundle;
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                string = "";
            } else {
                Object obj = bundle.get(MANConfig.MAN_APPSECRET_META_DATA_KEY);
                string = ((obj instanceof String) || obj == null) ? (String) obj : obj.toString();
                try {
                    MANLog.Logi(TAG, "appSecret : " + string);
                } catch (PackageManager.NameNotFoundException e2) {
                    str = string;
                    e = e2;
                    e.printStackTrace();
                    return str;
                }
            }
            return string == null ? "" : string;
        } catch (PackageManager.NameNotFoundException e3) {
            e = e3;
        }
    }

    public static String getMetaDataAppVersion(Context context) {
        String str;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 128).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            str = OpenTypeScript.UNKNOWN;
        }
        return isNullOrEmpty(str) ? "-" : str;
    }

    public static String getMetaDataChannel(Context context) {
        String string;
        Bundle bundle;
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                string = "";
            } else {
                Object obj = bundle.get(MANConfig.MAN_CHANNEL_META_DATA_KEY);
                string = ((obj instanceof String) || obj == null) ? (String) obj : obj.toString();
                try {
                    MANLog.Logi(TAG, "channel : " + string);
                } catch (PackageManager.NameNotFoundException e2) {
                    str = string;
                    e = e2;
                    e.printStackTrace();
                    return str;
                }
            }
            return string == null ? "" : string;
        } catch (PackageManager.NameNotFoundException e3) {
            e = e3;
        }
    }

    public static boolean isHost(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return patternHost.matcher(str).matches();
    }

    public static boolean isIp(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return patternIp.matcher(str).matches();
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }
}
