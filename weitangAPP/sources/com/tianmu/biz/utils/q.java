package com.tianmu.biz.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    @TargetApi(16)
    public static long a(Context context) {
        if (Build.VERSION.SDK_INT < 16) {
            return 0L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }
}
