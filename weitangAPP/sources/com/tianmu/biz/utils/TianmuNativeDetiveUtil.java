package com.tianmu.biz.utils;

import android.text.TextUtils;
import com.tianmu.TianmuSDK;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuNativeDetiveUtil {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f10849c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10851b;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static TianmuNativeDetiveUtil f10852a = new TianmuNativeDetiveUtil();
    }

    static {
        try {
            System.loadLibrary("native-tianmu-lib");
        } catch (Throwable unused) {
            f10849c = false;
        }
    }

    public static TianmuNativeDetiveUtil c() {
        return b.f10852a;
    }

    private boolean d() {
        return TianmuSDK.getInstance().getConfig().isCanUsePhoneState();
    }

    public String a() {
        if (!f10849c) {
            return "";
        }
        try {
            if (!d()) {
                return "";
            }
            if (TextUtils.isEmpty(this.f10850a)) {
                String strStringFromJNI2 = stringFromJNI2();
                this.f10850a = strStringFromJNI2;
                if (!TextUtils.isEmpty(strStringFromJNI2) && this.f10850a.length() > 36) {
                    this.f10850a = this.f10850a.substring(0, 36);
                }
            }
            return this.f10850a;
        } catch (Throwable unused) {
            return "";
        }
    }

    public String b() {
        if (!f10849c) {
            return "";
        }
        try {
            if (!d()) {
                return "";
            }
            if (TextUtils.isEmpty(this.f10851b)) {
                this.f10851b = stringFromJNI1();
            }
            return this.f10851b;
        } catch (Throwable unused) {
            return "";
        }
    }

    public native String stringFromJNI1();

    public native String stringFromJNI2();

    private TianmuNativeDetiveUtil() {
    }
}
