package com.tianmu.biz.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.taobao.accs.common.Constants;
import com.tianmu.TianmuSDK;
import com.tianmu.utils.TianmuPackageUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.Thread;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static m f10879d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DateFormat f10881b = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f10882c = Thread.getDefaultUncaughtExceptionHandler();

    private m(Context context) {
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f10880a = context;
    }

    public static m a(Context context) {
        m mVar = f10879d;
        if (mVar == null) {
            synchronized (m.class) {
                mVar = f10879d;
                if (mVar == null) {
                    mVar = new m(context.getApplicationContext());
                    f10879d = mVar;
                }
            }
        }
        return mVar;
    }

    private void b(Throwable th) {
        if (th == null || this.f10880a == null || !a()) {
            return;
        }
        try {
            String strA = a(Log.getStackTraceString(th));
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            b(strA);
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (thread != null && "FinalizerWatchdogDaemon".equals(thread.getName()) && (th instanceof TimeoutException)) {
            return;
        }
        a(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f10882c;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    private void a(Throwable th) {
        if (th == null) {
            return;
        }
        b(th);
    }

    private void b(String str) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str2 = "crash-" + this.f10881b.format(new Date()) + "-" + jCurrentTimeMillis + ".txt";
            String str3 = TianmuSDK.getInstance().getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/crashinfo/";
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(str3 + str2);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    private String a(String str) throws JSONException {
        Context context = TianmuSDK.getInstance().getContext();
        if (context == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.KEY_SDK_VERSION, "2.2.0.1");
        jSONObject.put("appVersion", TianmuPackageUtil.getAppVersion(context));
        jSONObject.put("osVersion", com.tianmu.c.n.g.I().o());
        jSONObject.put("time", o.a());
        jSONObject.put("detail", str);
        return jSONObject.toString();
    }

    public boolean a() {
        return com.tianmu.c.n.n.D().c();
    }
}
