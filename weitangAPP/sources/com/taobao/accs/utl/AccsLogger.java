package com.taobao.accs.utl;

import com.alibaba.sdk.android.logger.BaseSdkLogApi;
import com.alibaba.sdk.android.logger.ILog;
import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;

/* JADX INFO: loaded from: classes2.dex */
public class AccsLogger {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final BaseSdkLogApi f10470a = new BaseSdkLogApi("EMASNAccs", false);

        private a() {
        }
    }

    public static void addILogger(ILogger iLogger) {
        a.f10470a.addILogger(iLogger);
    }

    public static void enable(boolean z) {
        a.f10470a.enable(z);
    }

    public static ILog getLogger(Object obj) {
        return a.f10470a.getLogger(obj);
    }

    public static void removeILogger(ILogger iLogger) {
        a.f10470a.removeILogger(iLogger);
    }

    public static void setILogger(ILogger iLogger) {
        a.f10470a.setILogger(iLogger);
    }

    public static void setLevel(LogLevel logLevel) {
        a.f10470a.setLevel(logLevel);
    }
}
