package com.alipay.sdk.interior;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.m.k.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.e;

/* JADX INFO: loaded from: classes.dex */
public class Log {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f5247a;

    public interface ISdkLogCallback {
        void onLogLine(String str);
    }

    public static boolean forcedLogReport(Context context) {
        try {
            b.d().a(context);
            long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (jElapsedRealtime - f5247a < 600) {
                return false;
            }
            f5247a = jElapsedRealtime;
            a.a(context);
            return true;
        } catch (Exception e2) {
            e.a(e2);
            return false;
        }
    }

    public static void setupLogCallback(ISdkLogCallback iSdkLogCallback) {
        e.a(iSdkLogCallback);
    }
}
