package com.bytedance.pangle.d;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class f5979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f5980b;

    public static final Object a() {
        if (f5980b == null) {
            try {
                synchronized (a.class) {
                    if (f5980b == null) {
                        if (f5979a == null) {
                            f5979a = Class.forName("android.app.ActivityThread");
                        }
                        f5980b = MethodUtils.invokeStaticMethod(f5979a, "currentActivityThread", new Object[0]);
                    }
                    if (f5980b == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.d.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    try {
                                        Object unused = a.f5980b = MethodUtils.invokeStaticMethod(a.f5979a, "currentActivityThread", new Object[0]);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    } catch (Exception e2) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e2);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    }
                                } catch (Throwable th) {
                                    synchronized (obj) {
                                        obj.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (f5980b == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException e2) {
                                    ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e2);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e3);
            }
        }
        return f5980b;
    }
}
