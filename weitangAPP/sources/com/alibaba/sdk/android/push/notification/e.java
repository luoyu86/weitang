package com.alibaba.sdk.android.push.notification;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Random f5018a;

    public static boolean a(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (Build.VERSION.SDK_INT > 16) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                return runningAppProcessInfo.importance == 100;
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks.isEmpty()) {
                return true;
            }
            return runningTasks.get(0).topActivity.getPackageName().equals(context.getPackageName());
        } catch (Exception unused) {
            return false;
        }
    }
}
