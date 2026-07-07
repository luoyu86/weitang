package com.sun.mail.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class QPEncoderStream extends FilterOutputStream {
    private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private int bytesPerLine;
    private int count;
    private boolean gotCR;
    private boolean gotSpace;

    public QPEncoderStream(OutputStream outputStream, int i2) {
        super(outputStream);
        this.count = 0;
        this.gotSpace = false;
        this.gotCR = false;
        this.bytesPerLine = i2 - 1;
    }

    private void outputCRLF() throws IOException {
        ((FilterOutputStream) this).out.write(13);
        ((FilterOutputStream) this).out.write(10);
        this.count = 0;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.gotSpace) {
            output(32, true);
            this.gotSpace = false;
        }
        ((FilterOutputStream) this).out.flush();
    }

    public void output(int i2, boolean z) throws IOException {
        if (!z) {
            int i3 = this.count + 1;
            this.count = i3;
            if (i3 > this.bytesPerLine) {
                ((FilterOutputStream) this).out.write(61);
                ((FilterOutputStream) this).out.write(13);
                ((FilterOutputStream) this).out.write(10);
                this.count = 1;
            }
            ((FilterOutputStream) this).out.write(i2);
            return;
        }
        int i4 = this.count + 3;
        this.count = i4;
        if (i4 > this.bytesPerLine) {
            ((FilterOutputStream) this).out.write(61);
            ((FilterOutputStream) this).out.write(13);
            ((FilterOutputStream) this).out.write(10);
            this.count = 3;
        }
        ((FilterOutputStream) this).out.write(61);
        OutputStream outputStream = ((FilterOutputStream) this).out;
        char[] cArr = hex;
        outputStream.write(cArr[i2 >> 4]);
        ((FilterOutputStream) this).out.write(cArr[i2 & 15]);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        for (int i4 = 0; i4 < i3; i4++) {
            write(bArr[i2 + i4]);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        int i3 = i2 & 255;
        if (this.gotSpace) {
            if (i3 != 13 && i3 != 10) {
                output(32, false);
            } else {
                output(32, true);
            }
            this.gotSpace = false;
        }
        if (i3 == 13) {
            this.gotCR = true;
            outputCRLF();
            return;
        }
        if (i3 == 10) {
            if (!this.gotCR) {
                outputCRLF();
            }
        } else if (i3 == 32) {
            this.gotSpace = true;
        } else if (i3 >= 32 && i3 < 127 && i3 != 61) {
            output(i3, false);
        } else {
            output(i3, true);
        }
        this.gotCR = false;
    }

    public QPEncoderStream(OutputStream outputStream) {
        this(outputStream, 76);
    }
}
