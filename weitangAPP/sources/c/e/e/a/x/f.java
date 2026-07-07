package c.e.e.a.x;

import android.os.Build;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f2486a = false;

    public static int a() {
        int i2 = e() ? 3 : isViVoQ() ? 1 : 0;
        i.d(f.class.getSimpleName(), "getDefaultModel");
        return i2;
    }

    public static void addOpenFailedCount() {
    }

    public static void addRecordFailedCount() {
        int iB = b() + 1;
        if (iB >= 2) {
            int openDoorModel = getOpenDoorModel();
            if (openDoorModel == 0) {
                h(1);
            } else if (openDoorModel == 1) {
                h(3);
            } else if (openDoorModel == 2) {
                h(0);
            } else if (openDoorModel == 3) {
                h(2);
            }
            iB = 0;
        }
        g(iB);
    }

    public static int b() {
        return 0;
    }

    public static boolean c() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(":");
        sb.append(Build.BRAND);
        sb.append(":");
        sb.append(Build.MODEL);
        return sb.toString().contains("OnePlus") && Build.VERSION.SDK_INT >= 29;
    }

    public static boolean d() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(":");
        sb.append(Build.BRAND);
        sb.append(":");
        sb.append(Build.MODEL);
        return sb.toString().contains("OPPO:OPPO:P") && Build.VERSION.SDK_INT >= 28;
    }

    public static boolean e() {
        return Build.MODEL.contains("Redmi") && Build.VERSION.SDK_INT >= 29;
    }

    public static boolean f() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(":");
        sb.append(Build.BRAND);
        sb.append(":");
        sb.append(Build.MODEL);
        return sb.toString().toLowerCase().contains("deltainno:SMARTISAN".toLowerCase()) && Build.VERSION.SDK_INT >= 28;
    }

    public static void g(int i2) {
    }

    public static int getOpenDoorModel() {
        return isRedMiK30() ? a() : a();
    }

    public static void h(int i2) {
    }

    public static boolean isCompatibleDevice() {
        return isConnectModel();
    }

    public static boolean isConnectModel() {
        return getOpenDoorModel() == 2;
    }

    public static boolean isDirectConnect() {
        return f2486a;
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

    public static boolean isRedmiK40() {
        return isDirectConnect();
    }

    public static boolean isScan() {
        return c.q.a.b.a.isScan();
    }

    public static boolean isViVoQ() {
        return Build.BRAND.equals(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO) && Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isXiaoMimi() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(":");
        sb.append(Build.BRAND);
        sb.append(":");
        sb.append(Build.MODEL);
        return (sb.toString().toLowerCase().contains("Xiaomi:Xiaomi:M".toLowerCase()) && Build.VERSION.SDK_INT >= 28) || d() || isViVoQ() || isRedmiK20Pro() || f() || c();
    }

    public static void removeFailedCountRecord() {
        g(0);
    }

    public static void setDirectConnect(boolean z) {
        f2486a = z;
    }

    public static void setScan(boolean z) {
        c.q.a.b.a.setupEnableScan(z);
    }
}
