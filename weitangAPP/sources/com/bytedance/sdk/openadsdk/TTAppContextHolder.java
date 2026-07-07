package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.bl;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class TTAppContextHolder {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context ok;

    public static class ok {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application ok;

        static {
            try {
                Object objA = a();
                ok = (Application) objA.getClass().getMethod("getApplication", new Class[0]).invoke(objA, new Object[0]);
                bl.s("MyApplication", "application get success");
            } catch (Throwable th) {
                bl.bl("MyApplication", "application get failed", th);
            }
        }

        private static Object a() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                bl.bl("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        public static Application ok() {
            return ok;
        }
    }

    public static Context getContext() {
        if (ok == null) {
            setContext(null);
        }
        return ok;
    }

    public static synchronized void setContext(Context context) {
        if (ok == null) {
            if (context != null) {
                ok = context.getApplicationContext();
            } else if (ok.ok() != null) {
                try {
                    ok = ok.ok();
                    if (ok != null) {
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
