package com.tom_roush.pdfbox.pdmodel.encryption;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class RC4Cipher {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12345c;
    private final int[] salt = new int[256];

    private static int fixByte(byte b2) {
        return b2 < 0 ? b2 + 256 : b2;
    }

    private static void swap(int[] iArr, int i2, int i3) {
        int i4 = iArr[i2];
        iArr[i2] = iArr[i3];
        iArr[i3] = i4;
    }

    public void setKey(byte[] bArr) {
        this.f12344b = 0;
        this.f12345c = 0;
        if (bArr.length < 1 || bArr.length > 32) {
            throw new IllegalArgumentException("number of bytes must be between 1 and 32");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.salt;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2] = i2;
            i2++;
        }
        int length = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.salt.length; i4++) {
            int iFixByte = fixByte(bArr[length]);
            int[] iArr2 = this.salt;
            i3 = ((iFixByte + iArr2[i4]) + i3) % 256;
            swap(iArr2, i4, i3);
            length = (length + 1) % bArr.length;
        }
    }

    public void write(byte b2, OutputStream outputStream) throws IOException {
        int i2 = (this.f12344b + 1) % 256;
        this.f12344b = i2;
        int[] iArr = this.salt;
        int i3 = (iArr[i2] + this.f12345c) % 256;
        this.f12345c = i3;
        swap(iArr, i2, i3);
        int[] iArr2 = this.salt;
        outputStream.write(b2 ^ ((byte) iArr2[(iArr2[this.f12344b] + iArr2[this.f12345c]) % 256]));
    }

    public void write(byte[] bArr, OutputStream outputStream) throws IOException {
        for (byte b2 : bArr) {
            write(b2, outputStream);
        }
    }

    public void write(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return;
            } else {
                write(bArr, 0, i2, outputStream);
            }
        }
    }

    public void write(byte[] bArr, int i2, int i3, OutputStream outputStream) throws IOException {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            write(bArr[i4], outputStream);
        }
    }
}
