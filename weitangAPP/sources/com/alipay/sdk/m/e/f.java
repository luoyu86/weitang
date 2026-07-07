package com.alipay.sdk.m.e;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<j> f5314a;

    static {
        ArrayList arrayList = new ArrayList();
        f5314a = arrayList;
        arrayList.add(new l());
        f5314a.add(new d());
        f5314a.add(new c());
        f5314a.add(new h());
        f5314a.add(new b());
        f5314a.add(new a());
        f5314a.add(new g());
    }

    public static String a(Object obj) {
        if (obj == null) {
            return null;
        }
        Object objB = b(obj);
        if (com.alipay.sdk.m.f.a.a(objB.getClass())) {
            return org.json.alipay.b.c(objB.toString());
        }
        if (Collection.class.isAssignableFrom(objB.getClass())) {
            return new org.json.alipay.a((Collection) objB).toString();
        }
        if (Map.class.isAssignableFrom(objB.getClass())) {
            return new org.json.alipay.b((Map) objB).toString();
        }
        throw new IllegalArgumentException("Unsupported Class : " + objB.getClass());
    }

    public static Object b(Object obj) {
        Object objA;
        if (obj == null) {
            return null;
        }
        for (j jVar : f5314a) {
            if (jVar.a(obj.getClass()) && (objA = jVar.a(obj)) != null) {
                return objA;
            }
        }
        throw new IllegalArgumentException("Unsupported Class : " + obj.getClass());
    }
}
