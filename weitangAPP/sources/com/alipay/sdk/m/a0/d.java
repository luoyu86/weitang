package com.alipay.sdk.m.a0;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f5262a = new ConcurrentHashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f5264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f5265c;
    }

    public static String a(String str) {
        a aVar;
        String str2;
        Map<String, a> map = f5262a;
        if (map == null || (aVar = map.get(str)) == null) {
            return null;
        }
        if ((System.currentTimeMillis() - aVar.f5264b < aVar.f5265c) && (str2 = aVar.f5263a) != null) {
            return str2;
        }
        map.remove(str);
        return null;
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        Map<String, a> map = f5262a;
        a aVar = map.get(str);
        if (aVar == null) {
            aVar = new a();
        }
        aVar.f5263a = str2;
        aVar.f5265c = 86400000L;
        aVar.f5264b = System.currentTimeMillis();
        map.put(str, aVar);
    }
}
