package com.tom_roush.fontbox.pfb;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class PfbParser {
    private static final int ASCII_MARKER = 1;
    private static final int BINARY_MARKER = 2;
    private static final int BUFFER_SIZE = 65535;
    private static final int PFB_HEADER_LENGTH = 18;
    private static final int[] PFB_RECORDS = {1, 2, 1};
    private static final int START_MARKER = 128;
    private int[] lengths;
    private byte[] pfbdata;

    public PfbParser(String str) throws Throwable {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str), 65535);
        } catch (Throwable th) {
            th = th;
        }
        try {
            parsePfb(readFully(bufferedInputStream));
            bufferedInputStream.close();
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
            }
            throw th;
        }
    }

    private void parsePfb(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        this.pfbdata = new byte[bArr.length - 18];
        this.lengths = new int[PFB_RECORDS.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = PFB_RECORDS;
            if (i2 >= iArr.length) {
                return;
            }
            if (byteArrayInputStream.read() != 128) {
                throw new IOException("Start marker missing");
            }
            if (byteArrayInputStream.read() != iArr[i2]) {
                throw new IOException("Incorrect record type");
            }
            int i4 = byteArrayInputStream.read() + (byteArrayInputStream.read() << 8) + (byteArrayInputStream.read() << 16) + (byteArrayInputStream.read() << 24);
            if (i4 < 0) {
                throw new IOException("PFB record size is negative: " + i4);
            }
            this.lengths[i2] = i4;
            byte[] bArr2 = this.pfbdata;
            if (i3 >= bArr2.length) {
                throw new EOFException("attempted to read past EOF");
            }
            if (i4 > bArr2.length - i3) {
                throw new IOException("PFB record size (" + i4 + ") doesn't fit in buffer, position: " + i3 + ", total length: " + this.pfbdata.length);
            }
            int i5 = byteArrayInputStream.read(bArr2, i3, i4);
            if (i5 < 0) {
                throw new EOFException();
            }
            i3 += i5;
            i2++;
        }
    }

    private byte[] readFully(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[65535];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i2);
        }
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.pfbdata);
    }

    public int[] getLengths() {
        return this.lengths;
    }

    public byte[] getPfbdata() {
        return this.pfbdata;
    }

    public byte[] getSegment1() {
        return Arrays.copyOfRange(this.pfbdata, 0, this.lengths[0]);
    }

    public byte[] getSegment2() {
        byte[] bArr = this.pfbdata;
        int[] iArr = this.lengths;
        return Arrays.copyOfRange(bArr, iArr[0], iArr[0] + iArr[1]);
    }

    public int size() {
        return this.pfbdata.length;
    }

    public PfbParser(InputStream inputStream) throws IOException {
        parsePfb(readFully(inputStream));
    }

    public PfbParser(byte[] bArr) throws IOException {
        parsePfb(bArr);
    }
}
