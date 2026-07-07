package com.ut.mini.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.log.a.a;
import com.alibaba.mtl.log.b;
import com.alibaba.mtl.log.c;
import com.alibaba.mtl.log.d.p;
import com.ut.device.UTDevice;
import com.ut.mini.base.UTMIVariables;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UTTeamWork {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UTTeamWork f12366a;

    public static synchronized UTTeamWork getInstance() {
        if (f12366a == null) {
            f12366a = new UTTeamWork();
        }
        return f12366a;
    }

    public void clearHost4Https(Context context) {
        if (context == null) {
            Log.w("UTTeamWork", "context is null");
        } else {
            a.f("");
            p.a(context, "utanalytics_https_host", null);
        }
    }

    public void closeAuto1010Track() {
        c.a().o();
    }

    public void disableNetworkStatusChecker() {
    }

    public void dispatchLocalHits() {
    }

    public void enableUpload(boolean z) {
        com.alibaba.mtl.log.a.f52s = z;
    }

    public String getUtsid() {
        try {
            String appkey = com.alibaba.mtl.log.a.a() != null ? com.alibaba.mtl.log.a.a().getAppkey() : null;
            String utdid = UTDevice.getUtdid(b.a().getContext());
            long jLongValue = Long.valueOf(com.alibaba.mtl.log.a.B).longValue();
            if (!TextUtils.isEmpty(appkey) && !TextUtils.isEmpty(utdid)) {
                return utdid + "_" + appkey + "_" + jLongValue;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public void initialized() {
    }

    public void saveCacheDataToLocal() {
        com.alibaba.mtl.log.c.c.a().E();
    }

    public void setHost4Https(Context context, String str) {
        if (context == null) {
            Log.w("UTTeamWork", "context is null");
        } else if (TextUtils.isEmpty(str)) {
            Log.w("UTTeamWork", "host or port is empty");
        } else {
            a.f(str);
            p.a(context, "utanalytics_https_host", str);
        }
    }

    public void setToAliyunOsPlatform() {
        UTMIVariables.getInstance().setToAliyunOSPlatform();
    }

    public void turnOffRealTimeDebug() {
        AppMonitor.turnOffRealTimeDebug();
    }

    public void turnOnRealTimeDebug(Map<String, String> map) {
        AppMonitor.turnOnRealTimeDebug(map);
    }
}
