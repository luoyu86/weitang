package com.alibaba.sdk.android.man.crashreporter.handler.nativeCrashHandler;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.MotuCrashReporter;
import com.alibaba.sdk.android.man.crashreporter.c;
import com.alibaba.sdk.android.man.crashreporter.handler.a;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class NativeCrashHandler implements NativeExceptionHandler {
    private static boolean LOAD_SUCCESS = false;
    private static NativeCrashHandler nativeCrashHandler;
    private final String MOTU_PATH = "motu";
    private final String TOMBSTONE_PATH = "tombstone";
    private a crashReportManager = null;
    private AtomicBoolean crashing;
    private final String motuPath;

    static {
        try {
            System.loadLibrary("Motu");
            LOAD_SUCCESS = true;
        } catch (Error e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("load motu library error.", e2);
        }
    }

    private NativeCrashHandler(Context context) {
        String str = String.format("%s/%s", context.getDir("tombstone", 0).getAbsolutePath(), "motu");
        this.motuPath = str;
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static synchronized NativeCrashHandler getInstance() {
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler init(Context context) {
        if (nativeCrashHandler == null) {
            nativeCrashHandler = new NativeCrashHandler(context);
        }
        return nativeCrashHandler;
    }

    public static native String regist(String str, boolean z, int i2, long j, String str2);

    public static native String resetSigHandler();

    public static native String unregist();

    public NativeExceptionHandler getNativeExceptionHandler() {
        return nativeCrashHandler;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.handler.nativeCrashHandler.NativeExceptionHandler
    public void onNativeException(int i2, int i3, long j, long j2, String str, String str2, String str3, String str4, int i4, String str5, int i5, int i6, int i7, String str6, String str7) {
        try {
            if (str4 == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("native crash stack or path is null!");
                return;
            }
            a aVar = this.crashReportManager;
            if (aVar != null) {
                aVar.a(str5, str4, str3);
            } else {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("native: crash manager is null!");
            }
            try {
                unregist();
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("unregist native crash err", e2);
            } catch (UnsatisfiedLinkError e3) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("unregist native crash err,UnsatisfiedLinkError:", e3);
            }
        } catch (Exception e4) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("onNativeException err", e4);
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.handler.nativeCrashHandler.NativeExceptionHandler
    public void onNativeExceptionStart(String str, String str2, String str3) {
        com.alibaba.sdk.android.man.crashreporter.b.a.e("onNativeExceptionStart call back.");
        try {
            if (str == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("native crash stack or path is null!");
                return;
            }
            MotuCrashReporter.getInstance().setCrashReporterState(1);
            com.alibaba.sdk.android.man.crashreporter.b.a.e("stuck handler is closed");
            a aVar = this.crashReportManager;
            if (aVar != null) {
                aVar.a(str2, str, str3);
            } else {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("native: crash manager is null!");
            }
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("onNativeException err", e2);
        }
    }

    public boolean regist(AtomicBoolean atomicBoolean, a aVar, boolean z, c cVar) {
        if (LOAD_SUCCESS) {
            this.crashing = atomicBoolean;
            this.crashReportManager = aVar;
            String str = cVar.appVersion;
            if (str == null) {
                str = "";
            }
            try {
                return regist(this.motuPath, false, 1, cVar.startupTime, str) != null;
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("regist native crash err", e2);
            } catch (UnsatisfiedLinkError e3) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("regist native crash err,UnsatisfiedLinkError:", e3);
                return false;
            }
        }
        return false;
    }

    public boolean removeNativeCrashHandler() {
        if (resetSigHandler() != null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.e("Native crash handler is removed success");
            return true;
        }
        com.alibaba.sdk.android.man.crashreporter.b.a.e("Native crash handler is removed failed");
        return false;
    }
}
