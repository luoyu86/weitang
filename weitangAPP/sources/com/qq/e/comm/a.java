package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static boolean a(Context context) {
        boolean z;
        boolean z2;
        try {
            String[] strArr = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"};
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    String str = strArr[i2];
                    if (context.checkCallingOrSelfPermission(str) == -1) {
                        GDTLogger.e(String.format("Permission[%s]需要在AndroidManifest.xml中声明", str));
                    }
                } catch (Throwable th) {
                    GDTLogger.e("检查权限时发生异常", th);
                }
                z = false;
            }
            z = true;
            if (!z || !b(context, Class.forName(CustomPkgConstants.getADActivityName())) || !b(context, Class.forName(CustomPkgConstants.getPortraitADActivityName())) || !b(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                return false;
            }
            Class<?>[] clsArr = {Class.forName(CustomPkgConstants.getDownLoadServiceName())};
            for (int i3 = 0; i3 < 1; i3++) {
                try {
                    Class<?> cls = clsArr[i3];
                    Intent intent = new Intent();
                    intent.setClass(context, cls);
                    if (context.getPackageManager().resolveService(intent, 65536) == null) {
                        GDTLogger.e(String.format("Service[%s]需要在AndroidManifest.xml中声明", cls.getName()));
                    }
                } catch (Throwable th2) {
                    GDTLogger.e("检查Service时发生异常", th2);
                }
                z2 = false;
                break;
            }
            z2 = true;
            return z2;
        } catch (Throwable th3) {
            GDTLogger.e("检查AndroidManifest.xml时发生异常", th3);
            return false;
        }
    }

    public static boolean b(Context context, Class<?>... clsArr) {
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[i2]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e(String.format("Activity[%s]需要在AndroidManifest.xml中声明", clsArr[i2].getName()));
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("检查Activity时发生异常", th);
                return false;
            }
        }
        return true;
    }
}
