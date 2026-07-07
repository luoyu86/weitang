package c.e.e.a.x;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.annotation.StringRes;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f2487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PackageInfo f2488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f2489c;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f2490a = new g();
    }

    public static g getInstance() {
        return b.f2490a;
    }

    public static String getProcessName(Context context, int i2) {
        String str = "";
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                try {
                    if (runningAppProcessInfo.pid == i2) {
                        str = runningAppProcessInfo.processName;
                    }
                } catch (Exception unused) {
                }
            }
        } catch (Throwable unused2) {
        }
        return str;
    }

    public String getAppName() {
        Context context = this.f2487a;
        return context != null ? context.getApplicationInfo().name : "微棠";
    }

    public int getAppVersion(Context context) {
        if (context == null) {
            try {
                context = this.f2487a;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return 1;
            }
        }
        if (context != null) {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        return 1;
    }

    public String getAppVersionName() {
        PackageInfo packageInfo = this.f2488b;
        return packageInfo != null ? packageInfo.versionName : "";
    }

    public Context getContext() {
        return this.f2487a;
    }

    public List<String> getInstallAppPackName(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (installedPackages != null && !installedPackages.isEmpty()) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                arrayList.add(installedPackages.get(i2).packageName);
            }
        }
        return arrayList;
    }

    public Resources getResources() {
        return this.f2487a.getResources();
    }

    public String getString(@StringRes int i2) {
        return getResources().getString(i2);
    }

    public Integer getTestDoorType() {
        return this.f2489c;
    }

    public boolean isInstallApp(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (installedPackages != null && !installedPackages.isEmpty()) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                arrayList.add(installedPackages.get(i2).packageName);
            }
        }
        return arrayList.contains(str);
    }

    public boolean isInstallByRead(String str) {
        return new File("/data/data/" + str).exists();
    }

    public void setAppContext(Context context) {
        this.f2487a = context;
        if (context != null) {
            try {
                this.f2488b = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setTestDoorType(Integer num) {
        this.f2489c = num;
    }

    public g() {
    }

    public String getAppVersionName(Context context) {
        if (context == null) {
            try {
                context = this.f2487a;
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    }

    public int getAppVersion() {
        PackageInfo packageInfo = this.f2488b;
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 1;
    }
}
