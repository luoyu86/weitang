package com.bytedance.sdk.openadsdk.api.plugin.bl;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class bl {
    private static final char[] ok = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String ok(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        return ok(bArr, 0, bArr.length);
    }

    public static String ok(byte[] bArr, int i2, int i3) {
        Objects.requireNonNull(bArr, "bytes is null");
        if (i2 >= 0 && i2 + i3 <= bArr.length) {
            int i4 = i3 * 2;
            char[] cArr = new char[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = bArr[i6 + i2] & 255;
                int i8 = i5 + 1;
                char[] cArr2 = ok;
                cArr[i5] = cArr2[i7 >> 4];
                i5 = i8 + 1;
                cArr[i8] = cArr2[i7 & 15];
            }
            return new String(cArr, 0, i4);
        }
        throw new IndexOutOfBoundsException();
    }
}
