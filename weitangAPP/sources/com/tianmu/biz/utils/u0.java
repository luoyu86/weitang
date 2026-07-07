package com.tianmu.biz.utils;

import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class u0 {
    public static String a(int i2) {
        String strReplace = UUID.randomUUID().toString().replace("-", "");
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > strReplace.length()) {
            i2 = strReplace.length();
        }
        return strReplace.substring(0, i2);
    }
}
