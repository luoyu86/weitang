package com.alibaba.mtl.appmonitor.f;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static int a(String str) {
        if (!b.c(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }
}
