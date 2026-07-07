package com.tianmu.biz.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import com.tianmu.utils.TianmuLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f10862b = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f10863a;

    private e() {
    }

    public static e b() {
        return f10862b;
    }

    @SuppressLint({"PrivateApi"})
    public Application a() {
        try {
            if (this.f10863a == null) {
                this.f10863a = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
            }
            return this.f10863a;
        } catch (Exception e2) {
            e2.printStackTrace();
            TianmuLogUtil.d("splash get application context failed");
            return null;
        }
    }
}
