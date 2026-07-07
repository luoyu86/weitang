package com.alibaba.sdk.android.logger;

import com.alibaba.sdk.android.logger.a.a;
import com.alibaba.sdk.android.logger.b.b;
import com.alibaba.sdk.android.logger.b.c;
import com.alibaba.sdk.android.logger.b.e;
import com.alibaba.sdk.android.logger.b.f;
import com.alibaba.sdk.android.logger.b.g;
import com.alibaba.sdk.android.logger.b.h;
import com.alibaba.sdk.android.logger.interceptor.InterceptorManager;

/* JADX INFO: loaded from: classes.dex */
public class BaseSdkLogApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f4646a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private InterceptorManager f4649d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f4648c = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f4650e = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e f4647b = new e(this.f4650e);

    public BaseSdkLogApi(String str, boolean z) {
        this.f4646a = new g(str);
        InterceptorManager interceptorManager = new InterceptorManager(new com.alibaba.sdk.android.logger.interceptor.a(new h(this.f4648c)), new com.alibaba.sdk.android.logger.interceptor.b(this.f4647b));
        this.f4649d = interceptorManager;
        interceptorManager.a(new c(this.f4647b));
        if (z) {
            this.f4650e.a(LogLevel.DEBUG);
            this.f4649d.a(new com.alibaba.sdk.android.logger.b.a());
        }
    }

    public void addILogger(ILogger iLogger) {
        this.f4647b.b(iLogger);
    }

    public <T> void addObjectFormat(Class<T> cls, IObjectLogFormat<T> iObjectLogFormat) {
        this.f4648c.a(cls, iObjectLogFormat);
    }

    public void enable(boolean z) {
        this.f4650e.a(z);
    }

    public LogBuilder getLogBuilder(Object obj) {
        return new LogBuilder(this.f4649d, obj, this.f4646a);
    }

    public ILog getLogger(Object obj) {
        return new f(this.f4646a.a(obj), this.f4649d);
    }

    public void removeILogger(ILogger iLogger) {
        this.f4647b.c(iLogger);
    }

    public void setILogger(ILogger iLogger) {
        this.f4647b.a(iLogger);
    }

    public void setLevel(LogLevel logLevel) {
        this.f4650e.a(logLevel);
    }
}
