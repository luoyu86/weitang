package com.alibaba.sdk.android.logger.interceptor;

import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ILogger f4674a;

    public b(ILogger iLogger) {
        this.f4674a = iLogger;
    }

    @Override // com.alibaba.sdk.android.logger.interceptor.c
    public void a(InterceptorManager interceptorManager, int i2, LogLevel logLevel, String str, String str2) {
        this.f4674a.print(logLevel, str, str2);
    }
}
