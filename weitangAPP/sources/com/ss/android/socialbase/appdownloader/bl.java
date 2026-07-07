package com.ss.android.socialbase.appdownloader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.bl.k;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static NotificationChannel f9919a;
    private static int ok;

    /* JADX INFO: Access modifiers changed from: private */
    public static int s(Context context, int i2, boolean z) {
        if (com.ss.android.socialbase.downloader.h.ok.ok(i2).a("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.a.ok().kf(i2);
        }
        ok((Activity) p.ok().a());
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("install_queue_enable", 0) == 1 ? p.ok().ok(context, i2, z) : a(context, i2, z);
    }

    public static String a(long j) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long j2 = jArr[i2];
            if (j >= j2) {
                return ok(j, j2, strArr[i2]);
            }
        }
        return null;
    }

    public static boolean bl(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return a(context, downloadInfo, ok(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    private static String ok(long j, long j2, String str, boolean z) {
        double d2 = j;
        if (j2 > 1) {
            d2 /= j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d2) + " " + str;
        }
        return new DecimalFormat("#").format(d2) + " " + str;
    }

    public static boolean bl(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    public static String ok(long j) {
        return ok(j, true);
    }

    public static List<String> bl() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static String ok(long j, boolean z) {
        long[] jArr = {1099511627776L, 1073741824, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i2 = 0; i2 < 5; i2++) {
            long j2 = jArr[i2];
            if (j >= j2) {
                return ok(j, j2, strArr[i2], z);
            }
        }
        return null;
    }

    public static int a(final Context context, final int i2, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
        if (downloadInfo != null && "application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                com.ss.android.socialbase.downloader.downloader.bl.a(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.bl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        s.k().r();
                        int iOk = bl.ok(context, i2, z, downloadInfo, file);
                        if (iOk == 1 && s.k().x() != null) {
                            s.k().x().ok(downloadInfo, null);
                        }
                        bl.a(downloadInfo, z, iOk);
                    }
                });
                return 1;
            }
        }
        a(downloadInfo, z, 2);
        return 2;
    }

    private static JSONObject s(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String ok(long j, long j2, String str) {
        double d2 = j;
        if (j2 > 1) {
            d2 /= j2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d2) + str;
        }
        return new DecimalFormat("#.##").format(d2) + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(DownloadInfo downloadInfo, boolean z, int i2) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i2);
            jSONObject.put("real_package_name", downloadInfo.getFilePackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.bl.vk().ok(downloadInfo.getId(), "install_view_result", jSONObject);
    }

    public static int ok(final Context context, final int i2, final boolean z) {
        k kVarH = s.k().h();
        if (kVarH == null) {
            return s(context, i2, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i2);
        ok = 1;
        kVarH.ok(downloadInfo, new com.ss.android.socialbase.appdownloader.bl.q() { // from class: com.ss.android.socialbase.appdownloader.bl.1
            @Override // com.ss.android.socialbase.appdownloader.bl.q
            public void ok() {
                int unused = bl.ok = bl.s(context, i2, z);
            }
        });
        return ok;
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return ok(context, downloadInfo, packageInfo, false);
    }

    public static int a(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo packageInfoOk = ok(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (packageInfoOk != null) {
                    int i2 = packageInfoOk.versionCode;
                    downloadInfo.setAppVersionCode(i2);
                    return i2;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int ok(android.content.Context r5, int r6, boolean r7, com.ss.android.socialbase.downloader.model.DownloadInfo r8, java.io.File r9) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.bl.ok(android.content.Context, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo, java.io.File):int");
    }

    public static String a() {
        return com.ss.android.socialbase.downloader.q.kf.n();
    }

    public static boolean a(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean("auto_install_with_notification", true)) {
                return false;
            }
        }
        return true;
    }

    @TargetApi(26)
    public static String a(@NonNull Context context) {
        try {
            if (f9919a == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                f9919a = notificationChannel;
                notificationChannel.setSound(null, null);
                f9919a.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(f9919a);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "111111";
    }

    public static int ok(Context context, Intent intent) {
        try {
            if (s.k().i() != null) {
                if (s.k().i().ok(intent)) {
                    return 1;
                }
            }
        } catch (Throwable unused) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    public static boolean ok(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.bl.s sVarA = s.k().a();
        if (sVarA != null) {
            sVarA.ok(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (sVarA.ok()) {
                return true;
            }
        }
        ep downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.ok(8, downloadInfo, packageInfo.packageName, "");
        com.ss.android.socialbase.appdownloader.bl.bl blVarOk = s.k().ok();
        return (blVarOk instanceof com.ss.android.socialbase.appdownloader.bl.ok) && ((com.ss.android.socialbase.appdownloader.bl.ok) blVarOk).bl();
    }

    public static boolean ok(Context context, int i2, File file) {
        if (com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.kf.n.z() || com.ss.android.socialbase.appdownloader.kf.n.rh()) && com.ss.android.socialbase.downloader.q.k.ok(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt(AgooConstants.MESSAGE_FLAG, 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static int ok() {
        return s.k().kf() ? 16384 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0021 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri ok(int r1, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r2, android.content.Context r3, java.lang.String r4, java.io.File r5) {
        /*
            if (r2 == 0) goto Lb
            java.lang.String r1 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.getUriForFile(r4, r1)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        Lb:
            com.ss.android.socialbase.appdownloader.s r2 = com.ss.android.socialbase.appdownloader.s.k()
            com.ss.android.socialbase.appdownloader.bl.kf r2 = r2.n()
            if (r2 == 0) goto L1e
            java.lang.String r0 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L1e
            android.net.Uri r1 = r2.ok(r1, r4, r0)     // Catch: java.lang.Throwable -> L1e
            goto L1f
        L1e:
            r1 = 0
        L1f:
            if (r1 != 0) goto L3b
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L37
            r0 = 24
            if (r2 < r0) goto L32
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L32
            android.net.Uri r1 = androidx.core.content.FileProvider.getUriForFile(r3, r4, r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L32:
            android.net.Uri r1 = android.net.Uri.fromFile(r5)     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r2 = move-exception
            r2.printStackTrace()
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.bl.ok(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6 */
    private static Intent ok(Context context, DownloadInfo downloadInfo, @NonNull File file, boolean z, int[] iArr) {
        Uri uriOk = ok(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, s.k().s(), file);
        if (uriOk == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.setDataAndType(uriOk, "application/vnd.android.package-archive");
        com.ss.android.socialbase.appdownloader.bl.s sVarA = s.k().a();
        boolean zOk = sVarA != null ? sVarA.ok(downloadInfo.getId(), z) : false;
        ep downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        ?? Ok = zOk;
        if (downloadNotificationEventListener != null) {
            Ok = downloadNotificationEventListener.ok(z);
        }
        iArr[0] = Ok;
        if (Ok != 0) {
            return null;
        }
        return intent;
    }

    public static boolean ok(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && ok(com.ss.android.socialbase.downloader.downloader.bl.l(), downloadInfo, str);
        }
        return true;
    }

    public static boolean ok(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (file.exists()) {
                Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
                PackageInfo packageInfoOk = ok(downloadInfo, file);
                if (packageInfoOk == null || !packageInfoOk.packageName.equals(str)) {
                    return false;
                }
                int i2 = packageInfoOk.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, ok());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i2 != packageInfo.versionCode) {
                    return false;
                }
            } else {
                if (!com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("install_callback_error")) {
                    return false;
                }
                String strOk = com.ss.android.socialbase.downloader.q.kf.ok(downloadInfo.getTempCacheData().get("extra_apk_package_name"), (String) null);
                int iOk = com.ss.android.socialbase.downloader.q.kf.ok(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                if (strOk == null || TextUtils.isEmpty(strOk) || !strOk.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, ok());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || iOk != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean ok(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i2 = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i2);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, ok());
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i3 = packageInfo2.versionCode;
        return z ? i2 < i3 : (downloadInfo == null || com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("install_with_same_version_code", 0) != 1) ? i2 <= i3 : i2 < i3;
    }

    public static boolean ok(Context context, DownloadInfo downloadInfo) {
        return ok(context, downloadInfo, true);
    }

    public static boolean ok(Context context, DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode <= 0 && z) {
            return bl(context, downloadInfo);
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, ok());
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        return com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("install_with_same_version_code", 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
    }

    public static PackageInfo ok(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        Log.e("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
        return ok(downloadInfo, file);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String ok(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r0 = "default.apk"
            java.lang.String r2 = ".."
            if (r6 == 0) goto L34
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L5a
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            boolean r4 = r4.contains(r2)
            if (r4 != 0) goto L32
            java.lang.String r4 = r3.getLastPathSegment()
            goto L5a
        L32:
            r4 = r0
            goto L5a
        L34:
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L4c
            java.lang.String r6 = r3.getLastPathSegment()
            boolean r6 = r6.contains(r2)
            if (r6 != 0) goto L4c
            java.lang.String r1 = r3.getLastPathSegment()
        L4c:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L59
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L32
            goto L5a
        L59:
            r4 = r1
        L5a:
            boolean r3 = bl(r5)
            if (r3 == 0) goto L77
            java.lang.String r3 = ".apk"
            boolean r5 = r4.endsWith(r3)
            if (r5 != 0) goto L77
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            r5.append(r3)
            java.lang.String r4 = r5.toString()
        L77:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.bl.ok(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static String ok(String str, com.ss.android.socialbase.downloader.h.ok okVar) {
        JSONObject jSONObjectS;
        String str2;
        if (okVar == null || (jSONObjectS = okVar.s("download_dir")) == null) {
            return "";
        }
        String strOptString = jSONObjectS.optString("dir_name");
        if (!TextUtils.isEmpty(strOptString) && strOptString.startsWith("/")) {
            strOptString = strOptString.substring(1);
        }
        if (TextUtils.isEmpty(strOptString)) {
            return strOptString;
        }
        if (!strOptString.contains("%s")) {
            str2 = strOptString + str;
        } else {
            try {
                str2 = String.format(strOptString, str);
            } catch (Throwable unused) {
            }
        }
        strOptString = str2;
        return strOptString.length() > 255 ? strOptString.substring(strOptString.length() - 255) : strOptString;
    }

    public static boolean ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static int ok(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 == -2) {
            return 2;
        }
        if (i2 == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i2) || i2 == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i2) ? 3 : 0;
    }

    public static boolean ok(Context context) {
        if (Build.VERSION.SDK_INT > 20 && context != null) {
            TypedArray typedArrayObtainStyledAttributes = null;
            try {
                int color = context.getResources().getColor(n.a());
                typedArrayObtainStyledAttributes = context.obtainStyledAttributes(n.n(), new int[]{n.bl(), n.s()});
                if (color == typedArrayObtainStyledAttributes.getColor(0, 0)) {
                    try {
                        typedArrayObtainStyledAttributes.recycle();
                    } catch (Throwable unused) {
                    }
                    return true;
                }
            } catch (Throwable unused2) {
                if (typedArrayObtainStyledAttributes != null) {
                }
                return false;
            }
            try {
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable unused3) {
            }
        }
        return false;
    }

    public static void ok(DownloadInfo downloadInfo, boolean z, boolean z2) {
        s.k().ok(new kf(com.ss.android.socialbase.downloader.downloader.bl.l(), downloadInfo.getUrl()).ok(downloadInfo.getTitle()).a(downloadInfo.getName()).bl(downloadInfo.getSavePath()).ok(downloadInfo.isShowNotification()).a(downloadInfo.isAutoInstallWithoutNotification()).bl(downloadInfo.isOnlyWifi() || z2).n(downloadInfo.getExtra()).kf(downloadInfo.getMimeType()).ok(downloadInfo.getExtraHeaders()).n(true).a(downloadInfo.getRetryCount()).bl(downloadInfo.getBackUpUrlRetryCount()).a(downloadInfo.getBackUpUrls()).s(downloadInfo.getMinProgressTimeMsInterval()).n(downloadInfo.getMaxProgressCount()).kf(z).s(downloadInfo.isNeedHttpsToHttpRetry()).h(downloadInfo.getPackageName()).p(downloadInfo.getMd5()).ok(downloadInfo.getExpectFileLength()).q(downloadInfo.isNeedDefaultHttpServiceBackUp()).k(downloadInfo.isNeedReuseFirstConnection()).j(downloadInfo.isNeedIndependentProcess()).ok(downloadInfo.getEnqueueType()).rh(downloadInfo.isForce()).z(downloadInfo.isHeadConnectionAvailable()).h(downloadInfo.isNeedRetryDelay()).q(downloadInfo.getRetryDelayTimeArray()).ok(s(downloadInfo.getDownloadSettingString())).r(downloadInfo.getIconUrl()).kf(downloadInfo.getExecutorGroup()).i(downloadInfo.isAutoInstall()));
    }

    public static void ok(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static PackageInfo ok(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.kf.ok.n.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), file, ok());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        if (packageInfo != null) {
            return packageInfo;
        }
        PackageInfo packageInfoOk = com.ss.android.socialbase.appdownloader.kf.ok.n.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), file, ok());
        downloadInfo.setPackageInfo(packageInfoOk);
        return packageInfoOk;
    }

    public static int ok(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
