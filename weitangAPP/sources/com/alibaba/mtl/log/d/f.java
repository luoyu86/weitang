package com.alibaba.mtl.log.d;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static byte[] getBytes(int i2) {
        byte[] bArr = {(byte) ((i >> 8) % 256), (byte) (i % 256), (byte) (i % 256), (byte) (i2 % 256)};
        int i3 = i2 >> 8;
        int i4 = i3 >> 8;
        return bArr;
    }
}
