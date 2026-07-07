package com.taobao.accs.utl;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import anet.channel.util.HMacUtil;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class UtilityImpl {
    public static final String NET_TYPE_MOBILE = "mobile";
    public static final String NET_TYPE_UNKNOWN = "unknown";
    public static final String NET_TYPE_WIFI = "wifi";
    public static final int TNET_FILE_NUM = 5;
    public static final int TNET_FILE_SIZE = 5242880;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f10471a = new byte[0];

    public static String a(Context context) {
        String string = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getString(Constants.KEY_PROXY_HOST, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        return strD;
    }

    public static byte[] a() {
        return null;
    }

    public static int b(Context context) {
        int i2 = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getInt(Constants.KEY_PROXY_PORT, -1);
        if (i2 > 0) {
            return i2;
        }
        if (a(context) == null) {
            return -1;
        }
        try {
            return e();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static String b() {
        return "null";
    }

    public static boolean c(Context context) {
        String str;
        int i2;
        synchronized (f10471a) {
            PackageInfo packageInfo = GlobalClientInfo.getInstance(context).getPackageInfo();
            int i3 = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(Constants.KEY_APP_VERSION_CODE, -1);
            String string = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(Constants.KEY_APP_VERSION_NAME, "");
            if (packageInfo != null) {
                i2 = packageInfo.versionCode;
                str = packageInfo.versionName;
            } else {
                str = null;
                i2 = 0;
            }
            if (i3 == i2 && string.equals(str)) {
                return false;
            }
            n(context);
            ALog.i("UtilityImpl", "appVersionChanged", "oldV", Integer.valueOf(i3), "nowV", Integer.valueOf(i2), "oldN", string, "nowN", str);
            return true;
        }
    }

    public static void clearSharePreferences(Context context) {
        try {
            synchronized (f10471a) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
                String string = sharedPreferences.getString("appkey", null);
                String string2 = sharedPreferences.getString("app_sercet", null);
                String string3 = sharedPreferences.getString(Constants.KEY_PROXY_HOST, null);
                int i2 = sharedPreferences.getInt(Constants.KEY_PROXY_PORT, -1);
                int i3 = sharedPreferences.getInt("version", -1);
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                editorEdit.clear();
                if (!TextUtils.isEmpty(string)) {
                    editorEdit.putString("appkey", string);
                }
                if (!TextUtils.isEmpty(string2)) {
                    editorEdit.putString("app_sercet", string2);
                }
                if (!TextUtils.isEmpty(string3)) {
                    editorEdit.putString(Constants.KEY_PROXY_HOST, string3);
                }
                if (i2 > 0) {
                    editorEdit.putInt(Constants.KEY_PROXY_PORT, i2);
                }
                if (i3 > 0) {
                    editorEdit.putInt("version", i3);
                }
                editorEdit.apply();
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "clearSharePreferences", th, new Object[0]);
        }
    }

    public static boolean d(Context context) {
        String agooCustomServiceName = AdapterGlobalClientInfo.getAgooCustomServiceName(context);
        if (TextUtils.isEmpty(agooCustomServiceName)) {
            return false;
        }
        ComponentName componentName = new ComponentName(context, agooCustomServiceName);
        PackageManager packageManager = context.getPackageManager();
        if (!componentName.getPackageName().equals("!")) {
            return packageManager.getServiceInfo(componentName, 128).enabled;
        }
        ALog.e("UtilityImpl", "getAgooServiceEnabled,exception,comptName.getPackageName()=" + componentName.getPackageName(), new Object[0]);
        return false;
    }

    public static void disableService(Context context) {
        try {
            b(context, AdapterUtilityImpl.channelService);
        } catch (Throwable unused) {
        }
    }

    public static String e(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo == null ? "unknown" : activeNetworkInfo.getType() == 1 ? NET_TYPE_WIFI : activeNetworkInfo.getType() == 0 ? NET_TYPE_MOBILE : "unknown";
        } catch (Throwable th) {
            th.printStackTrace();
            return "unknown";
        }
    }

    public static void enableService(Context context) {
        a(context, AdapterUtilityImpl.channelService);
    }

    public static String f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo == null ? "unknown" : activeNetworkInfo.getType() == 1 ? NET_TYPE_WIFI : activeNetworkInfo.getType() == 0 ? NET_TYPE_MOBILE : "unknown";
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getNetworkTypeExt", th, new Object[0]);
            return null;
        }
    }

    public static boolean g(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = GlobalClientInfo.getInstance(context).getConnectivityManager().getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String getDeviceId(Context context) {
        return AdapterUtilityImpl.getDeviceId(context);
    }

    public static String getUtdid(String str, Context context) {
        String string;
        try {
            synchronized (f10471a) {
                string = context.getSharedPreferences(str, 0).getString("utdid", getDeviceId(context));
            }
            return string;
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getUtdid", th, new Object[0]);
            return "";
        }
    }

    public static List<String> getUtdids(String str, Context context) {
        ArrayList arrayList;
        try {
            synchronized (f10471a) {
                String string = context.getSharedPreferences(str, 0).getString(Constants.SP_KEY_UTDID_LIST, null);
                arrayList = new ArrayList();
                if (string != null) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add(jSONArray.getString(i2));
                    }
                }
                arrayList.add(getDeviceId(context));
            }
            return arrayList;
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getUtdidList", th, new Object[0]);
            return null;
        }
    }

    public static long h(Context context) {
        SharedPreferences sharedPreferences;
        long j;
        long j2 = 0;
        try {
            sharedPreferences = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0);
            long j3 = sharedPreferences.getLong(Constants.SP_KEY_SERVICE_START, 0L);
            j = j3 > 0 ? sharedPreferences.getLong(Constants.SP_KEY_SERVICE_END, 0L) - j3 : 0L;
        } catch (Throwable th) {
            th = th;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putLong(Constants.SP_KEY_SERVICE_START, 0L);
            editorEdit.putLong(Constants.SP_KEY_SERVICE_END, 0L);
            editorEdit.apply();
            return j;
        } catch (Throwable th2) {
            th = th2;
            j2 = j;
            ALog.e("UtilityImpl", "getServiceAliveTime:", th, new Object[0]);
            return j2;
        }
    }

    public static void hitUtdid(String str, Context context, String str2) {
        try {
            synchronized (f10471a) {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str2);
                editorEdit.putString(Constants.SP_KEY_UTDID_LIST, jSONArray.toString());
                editorEdit.apply();
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "hitUtdid", th, new Object[0]);
        }
    }

    public static String i(Context context) {
        try {
            return GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String j(Context context) {
        try {
            return context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 4).getString(Constants.SP_KEY_COOKIE_SEC, null);
        } catch (Exception e2) {
            ALog.e("UtilityImpl", "reStoreCookie fail", e2, new Object[0]);
            return null;
        }
    }

    public static String k(Context context) {
        return AdapterUtilityImpl.isNotificationEnabled(context);
    }

    public static boolean l(Context context) {
        try {
            return context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(Constants.SP_KEY_ENABLE_CHANNEL_PROCESS, true);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static List<String> m(Context context) {
        try {
            String string = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(Constants.SP_KEY_CHANNEL_INIT, null);
            if (string != null) {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.getString(i2));
                }
                return arrayList;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static void n(Context context) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            editorEdit.putInt(Constants.KEY_APP_VERSION_CODE, GlobalClientInfo.getInstance(context).getPackageInfo().versionCode);
            editorEdit.putString(Constants.KEY_APP_VERSION_NAME, GlobalClientInfo.getInstance(context).getPackageInfo().versionName);
            editorEdit.apply();
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "saveAppVersion", th, new Object[0]);
        }
    }

    public static void saveChannelInitClass(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
            String string = sharedPreferences.getString(Constants.SP_KEY_CHANNEL_INIT, null);
            ArrayList arrayList = new ArrayList();
            if (string != null) {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.getString(i2));
                }
            }
            if (arrayList.contains(str)) {
                return;
            }
            arrayList.add(str);
            JSONArray jSONArray2 = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                jSONArray2.put(arrayList.get(i3));
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString(Constants.SP_KEY_CHANNEL_INIT, jSONArray2.toString());
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    public static void saveUtdid(String str, Context context) {
        try {
            synchronized (f10471a) {
                String deviceId = getDeviceId(context);
                SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                String string = sharedPreferences.getString(Constants.SP_KEY_UTDID_LIST, null);
                if (string == null || !string.contains(deviceId)) {
                    JSONArray jSONArray = string == null ? new JSONArray() : new JSONArray(string);
                    jSONArray.put(deviceId);
                    editorEdit.putString(Constants.SP_KEY_UTDID_LIST, jSONArray.toString());
                }
                editorEdit.putString("utdid", deviceId);
                editorEdit.apply();
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "saveUtdid", th, new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean utdidChanged(String str, Context context) {
        boolean z;
        try {
        } catch (Throwable th) {
            th = th;
            str = null;
        }
        try {
            synchronized (f10471a) {
                try {
                    String deviceId = getDeviceId(context);
                    z = !context.getSharedPreferences(str, 0).getString("utdid", deviceId).equals(deviceId);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    str = null;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                        ALog.e("UtilityImpl", "saveUtdid", th, new Object[0]);
                        z = str;
                        return z;
                    }
                }
            }
        } catch (Throwable th4) {
            while (true) {
                th = th4;
            }
        }
    }

    public static boolean b(Context context, String str) {
        ComponentName componentName = new ComponentName(context, str);
        PackageManager packageManager = context.getPackageManager();
        try {
            ALog.d("UtilityImpl", "disableComponent,comptName=" + componentName, new Object[0]);
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String g() {
        Class<?>[] clsArr = {String.class};
        Object[] objArr = {com.alipay.sdk.m.c.a.f5275a};
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
            ALog.d("UtilityImpl", "getEmuiVersion", "result", str);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception e2) {
            ALog.e("UtilityImpl", "getEmuiVersion", e2, new Object[0]);
            return "";
        }
    }

    public static void a(Context context, String str) {
        ComponentName componentName = new ComponentName(context, str);
        ALog.d("UtilityImpl", "enableComponent", "comptName", componentName);
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
            ALog.w("UtilityImpl", "enableComponent", th, new Object[0]);
        }
    }

    public static int e() {
        if (Build.VERSION.SDK_INT < 11) {
            return Proxy.getDefaultPort();
        }
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static String f() {
        String str = d() + ":" + e();
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("UtilityImpl", "getProxy:" + str, new Object[0]);
        }
        return str;
    }

    public static void e(Context context, String str) {
        try {
            synchronized (f10471a) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
                String string = sharedPreferences.getString("appkey", "");
                if (!TextUtils.isEmpty(str) && !string.equals(str) && !string.contains(str)) {
                    if (!TextUtils.isEmpty(string)) {
                        str = string + "|" + str;
                    }
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("appkey", str);
                    editorEdit.apply();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(j));
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "formatDay", th, new Object[0]);
            return "";
        }
    }

    public static boolean b(Context context, boolean z) {
        if (l(context)) {
            return false;
        }
        ALog.d("UtilityImpl", "channel process is disabled, kill it", new Object[0]);
        if (!z) {
            return true;
        }
        Process.killProcess(Process.myPid());
        return true;
    }

    public static String d() {
        if (Build.VERSION.SDK_INT < 11) {
            return Proxy.getDefaultHost();
        }
        return System.getProperty("http.proxyHost");
    }

    public static String a(String str, String str2, String str3) {
        String strHmacSha1Hex = null;
        if (TextUtils.isEmpty(str)) {
            ALog.e("UtilityImpl", "getAppSign appKey null", new Object[0]);
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                strHmacSha1Hex = HMacUtil.hmacSha1Hex(str2.getBytes(), (str + str3).getBytes());
            } else {
                ALog.e("UtilityImpl", "getAppSign secret null", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getAppSign", th, new Object[0]);
        }
        return strHmacSha1Hex;
    }

    public static boolean c(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            ALog.e("UtilityImpl", "package not exist", "pkg", str);
            return false;
        }
    }

    public static String d(Context context, String str) {
        try {
            File externalFilesDir = context.getExternalFilesDir("emastnetlogs");
            if (externalFilesDir == null || !externalFilesDir.exists() || !externalFilesDir.canWrite()) {
                externalFilesDir = context.getDir("emaslogs", 0);
            }
            ALog.d("UtilityImpl", "getTnetLogFilePath :" + externalFilesDir, new Object[0]);
            return externalFilesDir + "/" + str.toLowerCase();
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getTnetLogFilePath", th, new Object[0]);
            return null;
        }
    }

    public static long c() {
        return AdapterUtilityImpl.getUsableSpace();
    }

    public static int a(Context context, String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || context == null || bArr == null) {
        }
        return -1;
    }

    public static byte[] a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            return null;
        }
        ALog.i("UtilityImpl", "get sslticket input null", new Object[0]);
        return null;
    }

    public static void a(Context context, String str, long j) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0).edit();
            editorEdit.putLong(str, j);
            editorEdit.apply();
            ALog.d("UtilityImpl", "setServiceTime:" + j, new Object[0]);
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "setServiceTime:", th, new Object[0]);
        }
    }

    public static int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String a(Throwable th) {
        return AdapterUtilityImpl.getStackMsg(th);
    }

    public static String a(int i2) {
        try {
            return String.valueOf(i2);
        } catch (Exception e2) {
            ALog.e("UtilityImpl", "int2String", e2, new Object[0]);
            return null;
        }
    }

    public static Map<String, String> a(Map<String, List<String>> map) {
        HashMap map2 = new HashMap();
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String strA = a(entry.getValue());
                    if (!TextUtils.isEmpty(strA)) {
                        if (!key.startsWith(":")) {
                            key = key.toLowerCase(Locale.US);
                        }
                        map2.put(key, strA);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return map2;
    }

    public static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            sb.append(list.get(i2));
            if (i2 < size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static void a(Context context, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            editorEdit.putBoolean(Constants.SP_KEY_ENABLE_CHANNEL_PROCESS, z);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, List<String> list) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
            String string = sharedPreferences.getString(Constants.SP_KEY_CHANNEL_INIT, null);
            ArrayList arrayList = new ArrayList();
            if (string != null) {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    arrayList.add(jSONArray.getString(i2));
                }
            }
            if (arrayList.removeAll(list)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    jSONArray2.put(arrayList.get(i3));
                }
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putString(Constants.SP_KEY_CHANNEL_INIT, jSONArray2.toString());
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }
}
