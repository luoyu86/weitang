package c.a.a.a.a.n;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class g {
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
