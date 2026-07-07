package com.ss.android.socialbase.appdownloader.kf.ok;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import com.taobao.accs.common.Constants;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    private static PackageInfo a(@NonNull Context context, @NonNull File file, int i2) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            ok("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i2);
        } catch (Throwable th) {
            ok("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
    
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
    
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.PackageInfo ok(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.kf.ok.n.ok(java.io.File):android.content.pm.PackageInfo");
    }

    private static String ok(int i2) {
        return (i2 >>> 24) == 1 ? "android:" : "";
    }

    public static PackageInfo ok(@NonNull Context context, @NonNull File file, int i2) {
        int i3;
        if (com.ss.android.socialbase.downloader.q.ok.ok(268435456) && (i3 = Build.VERSION.SDK_INT) >= 21 && i3 < 26) {
            try {
                return ok(file);
            } catch (Throwable th) {
                ok("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                return a(context, file, i2);
            }
        }
        return a(context, file, i2);
    }

    private static void ok(@NonNull String str, @NonNull String str2) {
        com.ss.android.socialbase.downloader.s.a aVarH = com.ss.android.socialbase.downloader.downloader.bl.h();
        if (aVarH == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.SHARED_MESSAGE_ID_FILE, str2);
        } catch (JSONException unused) {
        }
        aVarH.ok(str, jSONObject, null, null);
    }

    private static String ok(ok okVar, int i2) {
        int iA = okVar.a(i2);
        int iBl = okVar.bl(i2);
        if (iA == 3) {
            return okVar.s(i2);
        }
        return iA == 2 ? String.format("?%s%08X", ok(iBl), Integer.valueOf(iBl)) : (iA < 16 || iA > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(iBl), Integer.valueOf(iA)) : String.valueOf(iBl);
    }

    public static String ok(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e2) {
            ok("getPackageInfo::fail_load_label", e2.getMessage());
            return null;
        }
    }
}
