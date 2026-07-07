package com.ss.android.downloadlib.h;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.io.File;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object[] f9869a = new Object[0];
    private static Object[] bl = new Object[73];
    public static final char[] ok = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String s = null;

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static String bl(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static Intent h(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static File k(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        File file = new File((parentFile != null ? parentFile.getParent() : null) + File.separator + str);
        StringBuilder sb = new StringBuilder();
        sb.append("getExtDir: file.toString()-->");
        sb.append(file.toString());
        com.ss.android.socialbase.downloader.bl.ok.a("ToolUtils", sb.toString());
        return file;
    }

    public static boolean kf(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i2 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i2 <= packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean n(Context context, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.r.getContext();
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static Signature[] p(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Signature[] q(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Drawable s(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static int a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public static long ok(JSONObject jSONObject, String str) {
        return com.ss.android.download.api.bl.a.ok(jSONObject, str);
    }

    @WorkerThread
    public static boolean bl(String str) {
        File file;
        Context context = com.ss.android.downloadlib.addownload.r.getContext();
        if (TextUtils.isEmpty(str) || !n(context, str)) {
            return false;
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (com.ss.android.downloadlib.addownload.r.q().optInt("get_ext_dir_mode") == 0 && Build.VERSION.SDK_INT >= 29 && ((i2 == 29 && !Environment.isExternalStorageLegacy()) || i2 > 29)) {
            return true;
        }
        try {
            if (Build.VERSION.SDK_INT >= 29 && context.getApplicationInfo().targetSdkVersion >= 29 && com.ss.android.downloadlib.addownload.r.q().optInt("get_ext_dir_mode") == 1) {
                file = k(context, str);
            } else {
                file = new File(Environment.getExternalStorageDirectory().getPath(), "android/data/" + str);
            }
            if (!file.exists()) {
                return false;
            }
            long jOk = h.ok(file);
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                if (packageInfo.lastUpdateTime < jOk) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public static JSONObject ok(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.download.api.bl.a.ok(jSONObject, jSONObject2);
    }

    @NonNull
    public static JSONObject ok(JSONObject jSONObject) {
        return com.ss.android.download.api.bl.a.ok(jSONObject);
    }

    @NonNull
    public static JSONObject ok(JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.bl.a.ok(jSONObjectArr);
    }

    public static boolean a(com.ss.android.downloadad.api.ok.a aVar) {
        if (aVar == null) {
            return false;
        }
        return ok(aVar.n(), aVar.fd(), aVar.em()).ok();
    }

    public static boolean ok(Context context, Intent intent) {
        try {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities != null) {
                return !listQueryIntentActivities.isEmpty();
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean a(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.r.getContext();
        }
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }

    public static String ok(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j >= 1073741824) {
            return (j / 1073741824) + OperatorName.STROKING_COLOR_GRAY;
        }
        if (j >= 1048576) {
            return (j / 1048576) + OperatorName.SET_LINE_MITERLIMIT;
        }
        return decimalFormat.format(j / 1048576.0f) + OperatorName.SET_LINE_MITERLIMIT;
    }

    public static long a(long j) {
        try {
            return ok(Environment.getExternalStorageDirectory(), j);
        } catch (Exception e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static PackageInfo ok(com.ss.android.downloadad.api.ok.a aVar) {
        DownloadInfo downloadInfo;
        if (aVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadInfo(aVar.zz())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.bl.ok(com.ss.android.downloadlib.addownload.r.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable unused) {
            return null;
        }
    }

    @NonNull
    public static HashMap<String, String> a(JSONObject jSONObject) {
        HashMap<String, String> map = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.optString(next));
                }
                return map;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return map;
    }

    public static Drawable ok(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context != null && !TextUtils.isEmpty(str) && (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) != null) {
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            try {
                return applicationInfo.loadIcon(packageManager);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static void bl() {
        try {
            if (com.ss.android.downloadlib.addownload.r.n().ok(com.ss.android.downloadlib.addownload.r.getContext(), "android.permission.REORDER_TASKS")) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.r.getContext().getSystemService("activity");
                for (ActivityManager.RunningTaskInfo runningTaskInfo : activityManager.getRunningTasks(20)) {
                    if (com.ss.android.downloadlib.addownload.r.getContext().getPackageName().equals(runningTaskInfo.topActivity.getPackageName())) {
                        activityManager.moveTaskToFront(runningTaskInfo.id, 1);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static com.ss.android.downloadlib.addownload.a.bl ok(String str, int i2, String str2) {
        com.ss.android.downloadlib.addownload.a.bl blVar = new com.ss.android.downloadlib.addownload.a.bl();
        if (TextUtils.isEmpty(str)) {
            return blVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.r.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                blVar.a(packageInfo.versionCode);
                blVar.ok(com.ss.android.downloadlib.addownload.a.bl.f9770a);
                t tVarH = com.ss.android.downloadlib.addownload.r.h();
                if (tVarH != null && tVarH.ok() && !ok(packageInfo.versionCode, i2, packageInfo.versionName, str2)) {
                    blVar.ok(com.ss.android.downloadlib.addownload.a.bl.bl);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return blVar;
    }

    private static boolean ok(int i2, int i3, String str, String str2) {
        if (i3 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i3 > 0 && i2 >= i3) || ok(str, str2) >= 0;
    }

    public static boolean ok(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return ok(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).ok();
    }

    public static boolean ok(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i2 = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i2 == packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean ok(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < signatureArr.length; i2++) {
            if ((signatureArr[i2] == null && signatureArr2[i2] != null) || (signatureArr[i2] != null && !signatureArr[i2].equals(signatureArr2[i2]))) {
                return false;
            }
        }
        return true;
    }

    public static int ok(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String ok(String str, int i2) {
        return i2 == 0 ? "" : (TextUtils.isEmpty(str) || str.length() <= i2) ? str : str.substring(0, i2);
    }

    public static int ok(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (str.equals(str2)) {
                    return 0;
                }
                String[] strArrSplit = str.split("\\.");
                String[] strArrSplit2 = str2.split("\\.");
                int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
                int i2 = 0;
                int i3 = 0;
                while (i2 < iMin) {
                    i3 = Integer.parseInt(strArrSplit[i2]) - Integer.parseInt(strArrSplit2[i2]);
                    if (i3 != 0) {
                        break;
                    }
                    i2++;
                }
                if (i3 != 0) {
                    return i3 > 0 ? 1 : -1;
                }
                for (int i4 = i2; i4 < strArrSplit.length; i4++) {
                    if (Integer.parseInt(strArrSplit[i4]) > 0) {
                        return 1;
                    }
                }
                while (i2 < strArrSplit2.length) {
                    if (Integer.parseInt(strArrSplit2[i2]) > 0) {
                        return -1;
                    }
                    i2++;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return -2;
    }

    public static String ok(String... strArr) {
        return com.ss.android.download.api.bl.a.ok(strArr);
    }

    @NonNull
    public static <T> T ok(T... tArr) {
        if (tArr != null) {
            for (T t : tArr) {
                if (t != null) {
                    return t;
                }
            }
            throw new IllegalArgumentException("args is null");
        }
        throw new IllegalArgumentException("args is null");
    }

    public static boolean ok() {
        try {
            if (com.ss.android.downloadlib.addownload.r.getContext().getPackageManager().getPackageInfo(com.ss.android.downloadlib.addownload.r.getContext().getPackageName(), 0).applicationInfo.targetSdkVersion == 33) {
                return Build.VERSION.SDK_INT == 33;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static long ok(File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return com.ss.android.socialbase.downloader.q.kf.s(file.getAbsolutePath());
        } catch (Exception e2) {
            e2.printStackTrace();
            return j;
        }
    }

    public static long ok(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return -1L;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static void ok(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
