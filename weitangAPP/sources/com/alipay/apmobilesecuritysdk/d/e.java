package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, String> f5142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f5143b = {"AD1", "AD2", "AD3", "AD8", "AD9", "AD10", "AD11", "AD12", "AD14", "AD15", "AD16", "AD18", "AD20", "AD21", "AD23", "AD24", "AD26", "AD27", "AD28", "AD29", "AD30", "AD31", "AD34", "AA1", "AA2", "AA3", "AA4", "AC4", "AC10", "AE1", "AE2", "AE3", "AE4", "AE5", "AE6", "AE7", "AE8", "AE9", "AE10", "AE11", "AE12", "AE13", "AE14", "AE15"};

    public static String a(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str = (String) arrayList.get(i2);
            String str2 = map.get(str);
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            if (i2 != 0) {
                str3 = "&";
            }
            sb.append(str3);
            sb.append(str);
            sb.append("=");
            sb.append(str2);
            stringBuffer.append(sb.toString());
        }
        return stringBuffer.toString();
    }

    public static synchronized Map<String, String> a(Context context, Map<String, String> map) {
        if (f5142a == null) {
            c(context, map);
        }
        f5142a.putAll(d.a());
        return f5142a;
    }

    public static synchronized void a() {
        f5142a = null;
    }

    public static synchronized String b(Context context, Map<String, String> map) {
        TreeMap treeMap;
        a(context, map);
        treeMap = new TreeMap();
        for (String str : f5143b) {
            if (f5142a.containsKey(str)) {
                treeMap.put(str, f5142a.get(str));
            }
        }
        return com.alipay.sdk.m.y.b.a(a(treeMap));
    }

    public static synchronized void c(Context context, Map<String, String> map) {
        TreeMap treeMap = new TreeMap();
        f5142a = treeMap;
        treeMap.putAll(b.a(context, map));
        f5142a.putAll(d.a(context));
        f5142a.putAll(c.a(context));
        f5142a.putAll(a.a(context, map));
    }
}
