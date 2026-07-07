package com.bytedance.pangle.util;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static <T> boolean a(@Nullable T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean a(@Nullable T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t : tArr2) {
            if (!a(tArr, t)) {
                return false;
            }
        }
        return true;
    }

    private static <T> boolean a(@Nullable T[] tArr, T t) {
        int i2;
        if (tArr != null) {
            i2 = 0;
            while (i2 < tArr.length) {
                if (tArr[i2] == t || (tArr[i2] != null && tArr[i2].equals(t))) {
                    break;
                }
                i2++;
            }
            i2 = -1;
        } else {
            i2 = -1;
        }
        return i2 != -1;
    }
}
