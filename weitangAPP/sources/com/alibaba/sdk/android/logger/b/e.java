package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.ILoggerWithControl;
import com.alibaba.sdk.android.logger.LogLevel;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e implements ILogger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ILogger f4657a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ILogger f4658b = f4657a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<ILogger> f4659c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f4660d;

    public e(b bVar) {
        this.f4660d = bVar;
    }

    private boolean a(ILogger iLogger, LogLevel logLevel) {
        if (iLogger == null || !(iLogger instanceof ILoggerWithControl)) {
            return this.f4660d.b(logLevel);
        }
        try {
            if (((ILoggerWithControl) iLogger).isEnabled()) {
                return ((ILoggerWithControl) iLogger).isPrint(logLevel);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void a(ILogger iLogger) {
        if (iLogger == null) {
            iLogger = f4657a;
        }
        this.f4658b = iLogger;
    }

    public boolean a(LogLevel logLevel) {
        if (a(this.f4658b, logLevel)) {
            return true;
        }
        try {
            Iterator<ILogger> it = this.f4659c.iterator();
            while (it.hasNext()) {
                if (a(it.next(), logLevel)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b(ILogger iLogger) {
        if (iLogger != null) {
            this.f4659c.add(iLogger);
        }
    }

    public void c(ILogger iLogger) {
        if (iLogger != null) {
            this.f4659c.remove(iLogger);
        }
    }

    @Override // com.alibaba.sdk.android.logger.ILogger
    public void print(LogLevel logLevel, String str, String str2) {
        if (a(this.f4658b, logLevel)) {
            try {
                this.f4658b.print(logLevel, str, str2);
            } catch (Throwable unused) {
            }
        }
        try {
            for (ILogger iLogger : this.f4659c) {
                if (a(iLogger, logLevel)) {
                    try {
                        iLogger.print(logLevel, str, str2);
                    } catch (Throwable unused2) {
                    }
                }
            }
        } catch (Throwable unused3) {
        }
    }
}
