package com.bytedance.pangle.util.b.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f6264a = new byte[2];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f6265b = new byte[4];

    public final int a(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f6265b);
        return b(this.f6265b);
    }

    public final int b(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f6264a);
        return a(this.f6264a);
    }

    private static int b(byte[] bArr) {
        return ((((bArr[3] & 255) << 8) | (bArr[2] & 255)) << 16) | (bArr[0] & 255) | ((bArr[1] & 255) << 8);
    }

    public final void a(ByteArrayOutputStream byteArrayOutputStream, int i2) {
        a(this.f6264a, i2);
        byteArrayOutputStream.write(this.f6264a);
    }

    private static void b(byte[] bArr, int i2) {
        bArr[3] = (byte) (i2 >>> 24);
        bArr[2] = (byte) (i2 >>> 16);
        bArr[1] = (byte) (i2 >>> 8);
        bArr[0] = (byte) (i2 & 255);
    }

    public final void a(OutputStream outputStream, int i2) throws IOException {
        b(this.f6265b, i2);
        outputStream.write(this.f6265b);
    }

    private static int a(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    public static void a(byte[] bArr, int i2) {
        bArr[1] = (byte) (i2 >>> 8);
        bArr[0] = (byte) (i2 & 255);
    }
}
