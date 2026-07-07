package c.e.a.a;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import androidx.annotation.StringRes;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.u.n;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PackageInfo f945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f948e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f949f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f950g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f951h;

    /* JADX INFO: renamed from: c.e.a.a.b$b, reason: collision with other inner class name */
    public static final class C0016b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f952a = new b();
    }

    public static long getAppVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            Log.e("VersionInfo Exception", e2.getMessage());
            return 0L;
        }
    }

    public static b getInstance() {
        return C0016b.f952a;
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

    public final AppConfigExtVo a() {
        String string = w.getInstance().getString("app_config_info", null);
        if (!x.isNotNull(string)) {
            return null;
        }
        try {
            return (AppConfigExtVo) JSON.parseObject(string, AppConfigExtVo.class);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getAppName() {
        Context context = this.f944a;
        return context != null ? context.getApplicationInfo().name : "微棠";
    }

    public int getAppVersion(Context context) {
        if (getAppVersionName() != null) {
            return getVersionCode(getAppVersionName());
        }
        return 1;
    }

    public String getAppVersionName() {
        String str = this.f949f;
        return str != null ? str : "";
    }

    public Context getContext() {
        return this.f944a;
    }

    public String getDeviceId() {
        return this.f951h;
    }

    public List<String> getInstallAppPackName(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(installedPackages)) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                arrayList.add(installedPackages.get(i2).packageName);
            }
        }
        return arrayList;
    }

    public String getProjectKey() {
        return this.f950g;
    }

    public Resources getResources() {
        return this.f944a.getResources();
    }

    public String getString(@StringRes int i2) {
        return getResources().getString(i2);
    }

    public String getToken() {
        return this.f946c;
    }

    public String getUserKey() {
        return this.f948e;
    }

    public String getUserName() {
        return this.f947d;
    }

    public int getVersionCode(String str) {
        if (!x.isNotNull(str)) {
            return 0;
        }
        if (str.lastIndexOf("-") > 0) {
            str = str.substring(0, str.lastIndexOf("-"));
        }
        String[] strArrSplit = str.split("\\.");
        if (strArrSplit.length <= 2) {
            return 0;
        }
        String str2 = strArrSplit[strArrSplit.length - 1];
        if (str2.length() == 1) {
            strArrSplit[strArrSplit.length - 1] = "0" + str2;
        }
        StringBuilder sb = new StringBuilder(strArrSplit.length);
        for (String str3 : strArrSplit) {
            sb.append(str3);
        }
        String string = sb.toString();
        if (x.isNumeric(string)) {
            return Integer.parseInt(string);
        }
        return 0;
    }

    public boolean isInstallAliPay(Context context) {
        return getInstallAppPackName(context).contains(n.f5712b);
    }

    public boolean isInstallApp(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (o.isNotEmpty(installedPackages)) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                arrayList.add(installedPackages.get(i2).packageName);
            }
        }
        return arrayList.contains(str);
    }

    public boolean isInstallByRead(String str) {
        return new File("/data/data/" + str).exists();
    }

    public boolean isInstallWX(Context context) {
        return getInstallAppPackName(context).contains("com.tencent.mm");
    }

    public boolean isUpdateAppVersion(String str, Context context) {
        if (x.isNotNull(str)) {
            return getVersionCode(getAppVersionName()) < getVersionCode(str);
        }
        return false;
    }

    public void setAppContext(Context context) {
        this.f944a = context;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                this.f945b = packageInfo;
                setAppVersionName(packageInfo.versionName);
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setAppVersionName(String str) {
        this.f949f = str;
    }

    public void setDeviceId(String str) {
        this.f951h = str;
    }

    public void setProjectKey(String str) {
        this.f950g = str;
        q.d(b.class.getSimpleName(), "setProjectKey projectKey = " + str);
    }

    public synchronized void setToken(String str) {
        this.f946c = str;
        if (str == null) {
            setUserName(null);
            setUserKey(null);
        }
    }

    public void setUserKey(String str) {
        this.f948e = str;
    }

    public void setUserName(String str) {
        this.f947d = str;
    }

    public void setupGradModel(View view) {
        AppConfigExtVo appConfigExtVoA = a();
        if (view == null || appConfigExtVoA == null || !appConfigExtVoA.isHasEnableGrayStyle()) {
            return;
        }
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        view.setLayerType(2, paint);
    }

    public b() {
        this.f946c = null;
        this.f947d = null;
        this.f948e = null;
        this.f949f = null;
        this.f950g = null;
        this.f951h = null;
    }

    public int getAppVersion() {
        PackageInfo packageInfo = this.f945b;
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 1;
    }
}
