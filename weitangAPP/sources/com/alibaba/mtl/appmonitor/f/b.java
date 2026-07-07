package com.alibaba.mtl.appmonitor.f;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static boolean c(String str) {
        return !d(str);
    }

    public static boolean d(String str) {
        int length;
        if (str != null && (length = str.length()) != 0) {
            for (int i2 = 0; i2 < length; i2++) {
                if (!Character.isWhitespace(str.charAt(i2))) {
                    return false;
                }
            }
        }
        return true;
    }
}
