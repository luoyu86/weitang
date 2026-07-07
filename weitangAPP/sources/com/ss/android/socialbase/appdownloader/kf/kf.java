package com.ss.android.socialbase.appdownloader.kf;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class kf {
    private static Boolean ok;

    public static boolean a() {
        if (s() == 0) {
            return true;
        }
        return n();
    }

    public static boolean bl(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        return intentRegisterReceiver != null && intentRegisterReceiver.getIntExtra("plugged", -1) == 2;
    }

    private static boolean kf() {
        try {
            HashSet<String> hashSet = new HashSet();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/" + Process.myPid() + "/maps"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.endsWith(".so") || line.endsWith(".jar")) {
                    hashSet.add(line.substring(line.lastIndexOf(" ") + 1));
                }
            }
            bufferedReader.close();
            for (String str : hashSet) {
                if (str.contains(ok("636f6d2e73617572696b2e737562737472617465")) || str.contains(ok("58706f7365644272696467652e6a6172")) || str.contains(ok("6c696273616e64686f6f6b2e656478702e736f"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean n() {
        String[] strArr = {ok("2f7362696e2f7375"), ok("2f73797374656d2f62696e2f7375"), ok("2f73797374656d2f7862696e2f7375"), ok("2f646174612f6c6f63616c2f7862696e2f7375"), ok("2f646174612f6c6f63616c2f62696e2f7375"), ok("2f73797374656d2f73642f7862696e2f7375"), ok("2f73797374656d2f62696e2f6661696c736166652f7375"), ok("2f646174612f6c6f63616c2f7375")};
        for (int i2 = 0; i2 < 8; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean ok() {
        Boolean bool = ok;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    private static int s() {
        String str = null;
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, ok("726f2e736563757265"));
            if (objInvoke != null) {
                str = (String) objInvoke;
            }
        } catch (Exception unused) {
        }
        return (str != null && "0".equals(str)) ? 0 : 1;
    }

    @WorkerThread
    public static synchronized void ok(@NonNull Context context) {
        if (ok == null) {
            ok = Boolean.valueOf((a() || a(context) || bl(context) || !s(context) || bl() || n(context)) ? false : true);
        }
    }

    public static boolean a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    @WorkerThread
    public static boolean bl() {
        try {
            InetAddress.getByName(ok("3132372e302e302e31"));
            new Socket(ok("3132372e302e302e31"), Integer.parseInt(ok("3237303432")));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean s(Context context) {
        try {
            int simState = ((TelephonyManager) context.getSystemService(NewLoginBo.SMS_LOGIN_NAME)).getSimState();
            return (simState == 1 || simState == 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String ok(@NonNull String str) {
        return com.ss.android.socialbase.downloader.q.kf.ok(str);
    }

    @WorkerThread
    public static boolean n(Context context) {
        return kf() || kf(context);
    }

    private static boolean kf(Context context) {
        List listAsList = Arrays.asList(ok("64652e726f62762e616e64726f69642e78706f736564"), ok("636f6d2e746f706a6f686e77752e6d616769736b"), ok("696f2e76612e6578706f736564"), ok("636f6d2e77696e642e636f74746572"), ok("6f72672e6d656f776361742e656478706f7365642e6d616e61676572"), ok("6d652e7765697368752e657870"), ok("636f6d2e73617572696b2e737562737472617465"));
        PackageManager packageManager = context.getPackageManager();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            try {
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
            }
            if (packageManager.getPackageInfo((String) it.next(), 0) != null) {
                return true;
            }
        }
        return false;
    }
}
