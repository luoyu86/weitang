package com.alibaba.mtl.log.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.taobao.accs.utl.UtilityImpl;
import com.tom_roush.fontbox.ttf.OpenTypeScript;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f4566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static b f65a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String[] f66a = {OpenTypeScript.UNKNOWN, OpenTypeScript.UNKNOWN};

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f4567a;

        private a() {
        }

        public a a(Context context) {
            this.f4567a = context;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.f4567a;
            if (context == null) {
                return;
            }
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.f4567a.getPackageName()) != 0) {
                    l.f66a[0] = OpenTypeScript.UNKNOWN;
                    return;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f4567a.getSystemService("connectivity");
                if (connectivityManager == null) {
                    l.f66a[0] = OpenTypeScript.UNKNOWN;
                    return;
                }
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    return;
                }
                if (1 == activeNetworkInfo.getType()) {
                    l.f66a[0] = "Wi-Fi";
                } else if (activeNetworkInfo.getType() == 0) {
                    l.f66a[0] = "2G/3G";
                    l.f66a[1] = activeNetworkInfo.getSubtypeName();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            s.a().b(l.f4566a.a(context));
        }
    }

    static {
        f65a = new b();
        f4566a = new a();
    }

    private static String a(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return OpenTypeScript.UNKNOWN;
        }
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        context.registerReceiver(f65a, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public static void c(Context context) {
        b bVar;
        if (context == null || (bVar = f65a) == null) {
            return;
        }
        context.unregisterReceiver(bVar);
    }

    public static String[] getNetworkState(Context context) {
        return f66a;
    }

    public static boolean isConnected() {
        Context context = com.alibaba.mtl.log.a.getContext();
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static String u() {
        NetworkInfo activeNetworkInfo;
        Context context = com.alibaba.mtl.log.a.getContext();
        if (context == null) {
            return OpenTypeScript.UNKNOWN;
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return UtilityImpl.NET_TYPE_WIFI;
                }
                if (activeNetworkInfo.getType() == 0) {
                    return a(activeNetworkInfo.getSubtype());
                }
            }
        } catch (Throwable unused) {
        }
        return OpenTypeScript.UNKNOWN;
    }
}
