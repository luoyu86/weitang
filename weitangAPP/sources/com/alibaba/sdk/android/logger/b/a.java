package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.LogLevel;
import com.alibaba.sdk.android.logger.interceptor.InterceptorManager;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.alibaba.sdk.android.logger.interceptor.c {
    private String a() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i2 = 1; i2 < stackTrace.length; i2++) {
            if (!stackTrace[i2].getClassName().startsWith("com.alibaba.sdk.android.logger")) {
                return "(" + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + ")";
            }
        }
        return "";
    }

    @Override // com.alibaba.sdk.android.logger.interceptor.c
    public void a(InterceptorManager interceptorManager, int i2, LogLevel logLevel, String str, String str2) {
        interceptorManager.toNextLoggerInterceptor(i2, logLevel, str, str2 + a());
    }
}
