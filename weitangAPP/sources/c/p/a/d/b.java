package c.p.a.d;

import android.os.Build;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static int a() {
        int i2 = c() ? 3 : isViVoQ() ? 1 : 0;
        d.d(b.class.getSimpleName(), "getDefaultModel");
        return i2;
    }

    public static void addOpenFailedCount() {
    }

    public static void addRecordFailedCount() {
        int iB = b() + 1;
        if (iB >= 2) {
            int openDoorModel = getOpenDoorModel();
            if (openDoorModel == 0) {
                e(1);
            } else if (openDoorModel == 1) {
                e(3);
            } else if (openDoorModel == 2) {
                e(0);
            } else if (openDoorModel == 3) {
                e(2);
            }
            iB = 0;
        }
        d(iB);
    }

    public static int b() {
        return 0;
    }

    public static boolean c() {
        return Build.MODEL.contains("Redmi") && Build.VERSION.SDK_INT >= 29;
    }

    public static void d(int i2) {
    }

    public static void e(int i2) {
    }

    public static int getOpenDoorModel() {
        return isRedMiK30() ? a() : a();
    }

    public static boolean isCompatibleDevice() {
        return isConnectModel();
    }

    public static boolean isConnectModel() {
        return getOpenDoorModel() == 2;
    }

    public static boolean isHuaWeiMate30() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(":");
        sb.append(Build.BRAND);
        sb.append(":");
        sb.append(Build.MODEL);
        return sb.toString().contains("HUAWEI:HUAWEI:LIO-AL00") && Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isReceiveModel() {
        return getOpenDoorModel() == 3;
    }

    public static boolean isRedMiK30() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(":");
        sb.append(Build.BRAND);
        sb.append(":");
        sb.append(Build.MODEL);
        return sb.toString().contains("Xiaomi:Redmi:Redmi K30 5G") && Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isRedmiK20Pro() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(":");
        sb.append(Build.BRAND);
        sb.append(":");
        sb.append(Build.MODEL);
        return sb.toString().replaceAll(" ", "").toLowerCase().contains("Xiaomi:Xiaomi:RedmiK20Pro".toLowerCase()) && Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isViVoQ() {
        return Build.BRAND.equals(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO) && Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isXiaoMimi() {
        return false;
    }

    public static void removeFailedCountRecord() {
        d(0);
    }
}
