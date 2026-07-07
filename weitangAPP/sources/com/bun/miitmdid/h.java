package com.bun.miitmdid;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class<?> f5856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public Object f5857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Class<?>[] f5859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object[] f5860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Class<?> f5861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5862g = false;

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        this.f5856a = cls;
        this.f5857b = obj;
        this.f5858c = str;
        this.f5859d = clsArr;
        this.f5860e = objArr;
    }

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr, Class<?> cls2) {
        this.f5856a = cls;
        this.f5857b = obj;
        this.f5858c = str;
        this.f5859d = clsArr;
        this.f5860e = objArr;
        this.f5861f = cls2;
    }

    public native Object a();

    @Nullable
    public Class<?> b() {
        return this.f5861f;
    }

    public native boolean c();
}
