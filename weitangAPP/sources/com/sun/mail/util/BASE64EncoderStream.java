package com.sun.mail.util;

import com.tom_roush.pdfbox.pdfparser.BaseParser;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: loaded from: classes2.dex */
public class BASE64EncoderStream extends FilterOutputStream {
    private static byte[] newline = {BaseParser.ASCII_CR, 10};
    private static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private byte[] buffer;
    private int bufsize;
    private int bytesPerLine;
    private int count;
    private int lineLimit;
    private boolean noCRLF;
    private byte[] outbuf;

    public BASE64EncoderStream(OutputStream outputStream, int i2) {
        super(outputStream);
        this.bufsize = 0;
        this.count = 0;
        this.noCRLF = false;
        this.buffer = new byte[3];
        if (i2 == Integer.MAX_VALUE || i2 < 4) {
            this.noCRLF = true;
            i2 = 76;
        }
        int i3 = (i2 / 4) * 4;
        this.bytesPerLine = i3;
        this.lineLimit = (i3 / 4) * 3;
        if (this.noCRLF) {
            this.outbuf = new byte[i3];
            return;
        }
        byte[] bArr = new byte[i3 + 2];
        this.outbuf = bArr;
        bArr[i3] = BaseParser.ASCII_CR;
        bArr[i3 + 1] = 10;
    }

    private void encode() throws IOException {
        int iEncodedSize = encodedSize(this.bufsize);
        ((FilterOutputStream) this).out.write(encode(this.buffer, 0, this.bufsize, this.outbuf), 0, iEncodedSize);
        int i2 = this.count + iEncodedSize;
        this.count = i2;
        if (i2 >= this.bytesPerLine) {
            if (!this.noCRLF) {
                ((FilterOutputStream) this).out.write(newline);
            }
            this.count = 0;
        }
    }

    private static int encodedSize(int i2) {
        return ((i2 + 2) / 3) * 4;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        flush();
        if (this.count > 0 && !this.noCRLF) {
            ((FilterOutputStream) this).out.write(newline);
            ((FilterOutputStream) this).out.flush();
        }
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.bufsize > 0) {
            encode();
            this.bufsize = 0;
        }
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = i3 + i2;
        while (this.bufsize != 0 && i2 < i4) {
            write(bArr[i2]);
            i2++;
        }
        int i5 = ((this.bytesPerLine - this.count) / 4) * 3;
        int i6 = i2 + i5;
        if (i6 <= i4) {
            int iEncodedSize = encodedSize(i5);
            if (!this.noCRLF) {
                byte[] bArr2 = this.outbuf;
                int i7 = iEncodedSize + 1;
                bArr2[iEncodedSize] = BaseParser.ASCII_CR;
                iEncodedSize = i7 + 1;
                bArr2[i7] = 10;
            }
            ((FilterOutputStream) this).out.write(encode(bArr, i2, i5, this.outbuf), 0, iEncodedSize);
            this.count = 0;
            i2 = i6;
        }
        while (true) {
            int i8 = this.lineLimit;
            if (i2 + i8 > i4) {
                break;
            }
            ((FilterOutputStream) this).out.write(encode(bArr, i2, i8, this.outbuf));
            i2 += this.lineLimit;
        }
        if (i2 + 3 <= i4) {
            int i9 = ((i4 - i2) / 3) * 3;
            int iEncodedSize2 = encodedSize(i9);
            ((FilterOutputStream) this).out.write(encode(bArr, i2, i9, this.outbuf), 0, iEncodedSize2);
            i2 += i9;
            this.count += iEncodedSize2;
        }
        while (i2 < i4) {
            write(bArr[i2]);
            i2++;
        }
    }

    public static byte[] encode(byte[] bArr) {
        return bArr.length == 0 ? bArr : encode(bArr, 0, bArr.length, null);
    }

    private static byte[] encode(byte[] bArr, int i2, int i3, byte[] bArr2) {
        if (bArr2 == null) {
            bArr2 = new byte[encodedSize(i3)];
        }
        int i4 = 0;
        while (i3 >= 3) {
            int i5 = i2 + 1;
            int i6 = i5 + 1;
            int i7 = ((((bArr[i2] & 255) << 8) | (bArr[i5] & 255)) << 8) | (bArr[i6] & 255);
            char[] cArr = pem_array;
            bArr2[i4 + 3] = (byte) cArr[i7 & 63];
            int i8 = i7 >> 6;
            bArr2[i4 + 2] = (byte) cArr[i8 & 63];
            int i9 = i8 >> 6;
            bArr2[i4 + 1] = (byte) cArr[i9 & 63];
            bArr2[i4 + 0] = (byte) cArr[(i9 >> 6) & 63];
            i3 -= 3;
            i4 += 4;
            i2 = i6 + 1;
        }
        if (i3 == 1) {
            int i10 = (bArr[i2] & 255) << 4;
            bArr2[i4 + 3] = BaseNCodec.PAD_DEFAULT;
            bArr2[i4 + 2] = BaseNCodec.PAD_DEFAULT;
            char[] cArr2 = pem_array;
            bArr2[i4 + 1] = (byte) cArr2[i10 & 63];
            bArr2[i4 + 0] = (byte) cArr2[(i10 >> 6) & 63];
        } else if (i3 == 2) {
            int i11 = ((bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8)) << 2;
            bArr2[i4 + 3] = BaseNCodec.PAD_DEFAULT;
            char[] cArr3 = pem_array;
            bArr2[i4 + 2] = (byte) cArr3[i11 & 63];
            int i12 = i11 >> 6;
            bArr2[i4 + 1] = (byte) cArr3[i12 & 63];
            bArr2[i4 + 0] = (byte) cArr3[(i12 >> 6) & 63];
        }
        return bArr2;
    }

    public BASE64EncoderStream(OutputStream outputStream) {
        this(outputStream, 76);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int i2) throws IOException {
        byte[] bArr = this.buffer;
        int i3 = this.bufsize;
        int i4 = i3 + 1;
        this.bufsize = i4;
        bArr[i3] = (byte) i2;
        if (i4 == 3) {
            encode();
            this.bufsize = 0;
        }
    }
}
