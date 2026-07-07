package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.LogLevel;
import com.alibaba.sdk.android.logger.interceptor.ILogInterceptor;
import com.alibaba.sdk.android.logger.interceptor.InterceptorManager;

/* JADX INFO: loaded from: classes.dex */
public class c implements ILogInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f4655a;

    public c(e eVar) {
        this.f4655a = eVar;
    }

    @Override // com.alibaba.sdk.android.logger.interceptor.ILogInterceptor
    public void handle(InterceptorManager interceptorManager, int i2, LogLevel logLevel, String str, Object[] objArr) {
        if (this.f4655a.a(logLevel)) {
            interceptorManager.toNextLogInterceptor(i2, logLevel, str, objArr);
        }
    }
}
