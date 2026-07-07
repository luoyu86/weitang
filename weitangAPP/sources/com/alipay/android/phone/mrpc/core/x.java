package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f5127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f5128b = new z(this);

    public x(g gVar) {
        this.f5127a = gVar;
    }

    public final g a() {
        return this.f5127a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.f5127a, cls, this.f5128b));
    }
}
