package com.alibaba.sdk.android.logger.interceptor;

import com.alibaba.sdk.android.logger.LogLevel;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class InterceptorManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList<ILogInterceptor> f4667a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<c> f4668b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f4669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f4670d;

    public InterceptorManager(a aVar, b bVar) {
        this.f4669c = aVar;
        this.f4670d = bVar;
    }

    public InterceptorManager a() {
        InterceptorManager interceptorManager = new InterceptorManager(this.f4669c, this.f4670d);
        interceptorManager.f4667a.addAll(this.f4667a);
        interceptorManager.f4668b.addAll(this.f4668b);
        return interceptorManager;
    }

    public void a(LogLevel logLevel, String str, Object[] objArr) {
        toNextLogInterceptor(-1, logLevel, str, objArr);
    }

    public void a(ILogInterceptor iLogInterceptor) {
        this.f4667a.add(iLogInterceptor);
    }

    public void a(c cVar) {
        this.f4668b.add(cVar);
    }

    public void toNextLogInterceptor(int i2, LogLevel logLevel, String str, Object[] objArr) {
        int i3 = i2 + 1;
        if (i3 >= this.f4667a.size()) {
            this.f4669c.handle(this, i3, logLevel, str, objArr);
        } else {
            this.f4667a.get(i3).handle(this, i3, logLevel, str, objArr);
        }
    }

    public void toNextLoggerInterceptor(int i2, LogLevel logLevel, String str, String str2) {
        int i3 = i2 + 1;
        if (i3 >= this.f4668b.size()) {
            this.f4670d.a(this, i3, logLevel, str, str2);
        } else {
            this.f4668b.get(i3).a(this, i3, logLevel, str, str2);
        }
    }
}
