package com.alibaba.mtl.log.d;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class t {
    public static void send(Map<String, String> map) {
        Object objA;
        try {
            Object objA2 = o.a("com.ut.mini.UTAnalytics", "getInstance");
            if (objA2 == null || (objA = o.a(objA2, "getDefaultTracker")) == null) {
                return;
            }
            o.a(objA, "send", new Object[]{map}, Map.class);
        } catch (Exception unused) {
        }
    }
}
