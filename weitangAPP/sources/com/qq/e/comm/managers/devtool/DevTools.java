package com.qq.e.comm.managers.devtool;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class DevTools {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9673a;

    public String getDemoGameUrl() {
        String str = this.f9673a;
        this.f9673a = null;
        return str;
    }

    public void testDemoGame(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context.getPackageName().equals("com.qq.e.union.demo.union")) {
            this.f9673a = str;
        }
    }
}
