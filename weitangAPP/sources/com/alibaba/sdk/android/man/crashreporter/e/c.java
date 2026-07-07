package com.alibaba.sdk.android.man.crashreporter.e;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static byte[] d(int i2) {
        byte[] bArr = {(byte) ((i >> 8) % 256), (byte) (i % 256), (byte) (i % 256), (byte) (i2 % 256)};
        int i3 = i2 >> 8;
        int i4 = i3 >> 8;
        return bArr;
    }

    public static byte[] e(int i2) {
        return new byte[]{(byte) ((i2 >> 8) % 256), (byte) (i2 % 256)};
    }
}
