package org.android.agoo.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class Config {
    public static final String AGOO_CLEAR_TIME = "agoo_clear_time";
    public static final String AGOO_ENABLE_DAEMONSERVER = "agoo_enable_daemonserver";
    public static final String AGOO_UNREPORT_TIMES = "agoo_UnReport_times";
    public static final String KEY_DEVICE_TOKEN = "deviceId";
    public static final String PREFERENCES = "EMAS_Agoo_AppStore";
    public static final String PROPERTY_AGOO_SERVICE_MODE = "agoo_service_mode";
    public static final String PROPERTY_APP_KEY = "agoo_app_key";
    public static final String PROPERTY_APP_SECRET = "agoo_app_secret";
    public static final String PROPERTY_APP_VERSION = "app_version";
    public static final String PROPERTY_DEVICE_TOKEN = "app_device_token";
    public static final String PROPERTY_PUSH_USER_TOKEN = "app_push_user_token";
    public static final String PROPERTY_TT_ID = "app_tt_id";
    public static final String TAG = "Config";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f14935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f14936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f14937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f14938d;

    public static void a(Context context, String str) {
        try {
        } catch (Throwable th) {
            ALog.e(TAG, "setAgooAppSecret", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "setAgooAppSecret appSecret null", new Object[0]);
            return;
        }
        f14937c = str;
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
        editorEdit.putString(PROPERTY_APP_SECRET, str);
        editorEdit.apply();
        ALog.d(TAG, "setAgooAppSecret", "appSecret", str);
    }

    public static String b(Context context) {
        String string = f14936b;
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            string = context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_APP_KEY, f14936b);
        } catch (Throwable th) {
            ALog.e(TAG, "getAgooAppKey", th, new Object[0]);
        }
        if (TextUtils.isEmpty(string)) {
            ALog.e(TAG, "getAgooAppKey null!!", new Object[0]);
        }
        ALog.d(TAG, "getAgooAppKey", "appkey", string);
        return string;
    }

    public static String c(Context context) {
        String string = f14937c;
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            string = context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_APP_SECRET, f14937c);
        } catch (Throwable th) {
            ALog.e(TAG, "getAgooAppSecret", th, new Object[0]);
        }
        if (TextUtils.isEmpty(string)) {
            ALog.e(TAG, "getAgooAppSecret null!!", new Object[0]);
        }
        ALog.d(TAG, "getAgooAppSecret", "appSecret", string);
        return string;
    }

    public static String d(Context context) {
        return TextUtils.isEmpty(f14935a) ? ACCSManager.getDefaultConfig(context) : f14935a;
    }

    public static boolean e(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getInt(AGOO_UNREPORT_TIMES, 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void f(Context context) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
            editorEdit.putInt(AGOO_UNREPORT_TIMES, 0);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static int g(Context context) {
        try {
            return context.getSharedPreferences(PREFERENCES, 4).getInt(AGOO_UNREPORT_TIMES, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String getDeviceToken(Context context) {
        String string = f14938d;
        try {
            string = context.getSharedPreferences(PREFERENCES, 4).getString("deviceId", f14938d);
        } catch (Throwable th) {
            ALog.e(TAG, "getDeviceToken", th, new Object[0]);
        }
        ALog.i(TAG, "getDeviceToken", "token", string);
        return string;
    }

    public static void setAgooAppKey(Context context, String str) {
        try {
        } catch (Throwable th) {
            ALog.e(TAG, "setAgooAppKey", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "setAgooAppKey appkey null", new Object[0]);
            return;
        }
        f14936b = str;
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
        editorEdit.putString(PROPERTY_APP_KEY, str);
        editorEdit.apply();
        ALog.d(TAG, "setAgooAppKey", "appkey", str);
    }

    public static void b(Context context, String str) {
        ALog.i(TAG, "setDeviceToken", "token", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f14938d = str;
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
            editorEdit.putString("deviceId", str);
            editorEdit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "setDeviceToken", th, new Object[0]);
        }
    }

    public static void a(Context context) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
            editorEdit.putInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
            editorEdit.remove(PROPERTY_DEVICE_TOKEN);
            editorEdit.remove(PROPERTY_APP_KEY);
            editorEdit.remove(PROPERTY_TT_ID);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i2) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES, 4);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putInt(AGOO_UNREPORT_TIMES, sharedPreferences.getInt(AGOO_UNREPORT_TIMES, 0) + i2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context, long j) {
        try {
            long j2 = context.getSharedPreferences(PREFERENCES, 4).getLong(AGOO_CLEAR_TIME, 0L);
            StringBuilder sb = new StringBuilder();
            sb.append("now=");
            sb.append(j);
            sb.append(",now - lastTime=");
            long j3 = j - j2;
            sb.append(j3);
            sb.append(",istrue=");
            sb.append(j3 > 86400000);
            ALog.d("isClearTime", sb.toString(), new Object[0]);
            return j != 0 && j3 > 86400000;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(Context context, long j) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(PREFERENCES, 4).edit();
            editorEdit.putLong(AGOO_CLEAR_TIME, j);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }
}
