package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class y implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f5129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f5130b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f5131c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f5129a = gVar;
        this.f5130b = cls;
        this.f5131c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.f5131c.a(method, objArr);
    }
}
