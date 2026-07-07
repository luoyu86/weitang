package cn.com.heaton.blelibrary.ble.utils;

import android.app.ActivityManager;
import android.content.Context;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class BleUtils {
    public static boolean isBackground(Context context) {
        Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.processName.equals(context.getPackageName())) {
                if (next.importance != 100) {
                    return true;
                }
            }
        }
        return false;
    }
}
