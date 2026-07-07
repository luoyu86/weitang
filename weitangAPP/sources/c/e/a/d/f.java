package c.e.a.d;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.Thread;

/* JADX INFO: loaded from: classes.dex */
public class f implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f1204b;

    public static String getAppErrFile() {
        return l.getAppCacheDir() + File.separator + "AppError.log";
    }

    public static void recordAppErrCount() {
    }

    public final String a() {
        return w.getInstance().getString(NewLoginBo.SMS_LOGIN_NAME, "");
    }

    public final UserInfoVo b() {
        String string = w.getInstance().getString("userDetailsInfoKey", null);
        if (x.isNotNull(string)) {
            return (UserInfoVo) JSON.parseObject(string, UserInfoVo.class);
        }
        return null;
    }

    public final void c(Throwable th) {
        try {
            String appErrFile = getAppErrFile();
            File file = new File(appErrFile);
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            StringBuilder sb = new StringBuilder(8);
            b();
            sb.append("AppVersion=");
            sb.append(c.e.a.a.b.getInstance().getAppVersionName());
            sb.append("<br/>Phone=");
            sb.append(a());
            String str = Build.BRAND + ":" + Build.MODEL;
            sb.append("<br/>PhoneType=");
            sb.append(str);
            String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
            sb.append("<br/>SystemVersion=");
            sb.append(strValueOf);
            sb.append("<br/>Time=");
            sb.append(z.getCurrentTimeInString(z.f1243d));
            sb.append("<br/>");
            sb.append(Log.getStackTraceString(th));
            String string = sb.toString();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(appErrFile, true));
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void init(Context context) {
        this.f1203a = context;
        this.f1204b = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        c(th);
        this.f1204b.uncaughtException(thread, th);
    }
}
