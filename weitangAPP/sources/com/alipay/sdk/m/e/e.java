package com.alipay.sdk.m.e;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<i> f5313a;

    static {
        ArrayList arrayList = new ArrayList();
        f5313a = arrayList;
        arrayList.add(new l());
        f5313a.add(new d());
        f5313a.add(new c());
        f5313a.add(new h());
        f5313a.add(new k());
        f5313a.add(new b());
        f5313a.add(new a());
        f5313a.add(new g());
    }

    public static final <T> T a(Object obj, Type type) {
        T t;
        for (i iVar : f5313a) {
            if (iVar.a(com.alipay.sdk.m.f.a.a(type)) && (t = (T) iVar.a(obj, type)) != null) {
                return t;
            }
        }
        return null;
    }

    public static final Object a(String str, Type type) {
        Object bVar;
        if (str == null || str.length() == 0) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("[") && strTrim.endsWith("]")) {
            bVar = new org.json.alipay.a(strTrim);
        } else {
            if (!strTrim.startsWith("{") || !strTrim.endsWith(com.alipay.sdk.m.u.i.f5699d)) {
                return a((Object) strTrim, type);
            }
            bVar = new org.json.alipay.b(strTrim);
        }
        return a(bVar, type);
    }
}
