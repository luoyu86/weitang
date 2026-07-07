package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f9922a;
        private Drawable bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f9923h;
        private int kf;
        private String n;
        private String ok;
        private String s;

        public ok(String str, String str2, Drawable drawable, String str3, String str4, int i2, boolean z) {
            a(str2);
            ok(drawable);
            ok(str);
            bl(str3);
            s(str4);
            ok(i2);
            ok(z);
        }

        public boolean a() {
            return this.f9923h;
        }

        public String bl() {
            return this.ok;
        }

        public String h() {
            return this.n;
        }

        public int kf() {
            return this.kf;
        }

        public String n() {
            return this.s;
        }

        public Drawable ok() {
            return this.bl;
        }

        public String s() {
            return this.f9922a;
        }

        public String toString() {
            return "{\n  pkg name: " + bl() + "\n  app icon: " + ok() + "\n  app name: " + s() + "\n  app path: " + n() + "\n  app v name: " + h() + "\n  app v code: " + kf() + "\n  is system: " + a() + i.f5699d;
        }

        public void a(String str) {
            this.f9922a = str;
        }

        public void bl(String str) {
            this.s = str;
        }

        public void ok(Drawable drawable) {
            this.bl = drawable;
        }

        public void s(String str) {
            this.n = str;
        }

        public void ok(boolean z) {
            this.f9923h = z;
        }

        public void ok(String str) {
            this.ok = str;
        }

        public void ok(int i2) {
            this.kf = i2;
        }
    }

    public static ok a(String str) {
        try {
            PackageManager packageManager = com.ss.android.socialbase.downloader.downloader.bl.l().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return ok(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static boolean bl(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static int ok(String str) {
        if (bl(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = com.ss.android.socialbase.downloader.downloader.bl.l().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private static ok ok(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawableLoadIcon = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String string = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawableLoadIcon = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new ok(str, string, drawableLoadIcon, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
