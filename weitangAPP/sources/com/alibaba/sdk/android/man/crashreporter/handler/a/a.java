package com.alibaba.sdk.android.man.crashreporter.handler.a;

import com.alibaba.sdk.android.man.crashreporter.MotuCrashReporter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Integer f4740a = 20;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Thread.UncaughtExceptionHandler f113a = Thread.getDefaultUncaughtExceptionHandler();
    private com.alibaba.sdk.android.man.crashreporter.handler.a crashReportManager;
    private final AtomicBoolean crashing;

    public a(AtomicBoolean atomicBoolean, com.alibaba.sdk.android.man.crashreporter.handler.a aVar) {
        this.crashReportManager = null;
        this.crashing = atomicBoolean;
        this.crashReportManager = aVar;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            printWriter.close();
            try {
                stringWriter.close();
            } catch (IOException e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("close StringWriter failed.", e2);
            }
        }
    }

    public void b() {
        Thread.setDefaultUncaughtExceptionHandler(this.f113a);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.crashing.compareAndSet(false, true)) {
            com.alibaba.sdk.android.man.crashreporter.b.a.e("uncaughtException start.");
            try {
                MotuCrashReporter.getInstance().setCrashReporterState(0);
                String strB = b(th);
                String strA = a(th);
                if (strB == null || strA == null) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("uncaughtException exception or backtrace is null!");
                } else {
                    com.alibaba.sdk.android.man.crashreporter.handler.a aVar = this.crashReportManager;
                    if (aVar != null) {
                        aVar.a(th, thread, strB, strA);
                    } else {
                        com.alibaba.sdk.android.man.crashreporter.b.a.e("java: crash manager is null!");
                    }
                }
            } catch (Throwable th2) {
                try {
                    com.alibaba.sdk.android.man.crashreporter.b.a.d("uncaughtException error.", th2);
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("uncaughtException end.");
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f113a;
                    if (uncaughtExceptionHandler == null) {
                    }
                } finally {
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("uncaughtException end.");
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f113a;
                    if (uncaughtExceptionHandler2 != null) {
                        uncaughtExceptionHandler2.uncaughtException(thread, th);
                    }
                }
            }
        }
    }

    private String b(Throwable th) {
        Throwable thM55a = m55a(th);
        return thM55a != null ? thM55a.getClass().getSimpleName() : "";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private Throwable m55a(Throwable th) {
        int i2 = 1;
        while (th.getCause() != null && th != th.getCause() && i2 <= this.f4740a.intValue()) {
            i2++;
            th = th.getCause();
        }
        return th;
    }
}
