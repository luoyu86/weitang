package com.tianmu.biz.utils;

import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
public class o {
    static {
        new SimpleDateFormat("yyyy-MM-dd");
    }

    public static long a() {
        return System.currentTimeMillis();
    }

    public static long b() {
        return System.currentTimeMillis() / 1000;
    }
}
