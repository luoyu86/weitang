package com.tom_roush.pdfbox.filter;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public final class ASCII85OutputStream extends FilterOutputStream {
    private static final char NEWLINE = '\n';
    private static final char OFFSET = '!';
    private static final char Z = 'z';
    private int count;
    private boolean flushed;
    private byte[] indata;
    private int lineBreak;
    private int maxline;
    private byte[] outdata;
    private char terminator;

    public ASCII85OutputStream(OutputStream outputStream) {
        super(outputStream);
        this.lineBreak = 72;
        this.maxline = 72;
        this.count = 0;
        this.indata = new byte[4];
        this.outdata = new byte[5];
        this.flushed = true;
        this.terminator = '~';
    }

    private void transformASCII85() {
        byte[] bArr = this.indata;
        long j = ((long) ((bArr[3] & 255) | (((bArr[0] << 8) | (bArr[1] & 255)) << 16) | ((bArr[2] & 255) << 8))) & UIDFolder.MAXUID;
        if (j == 0) {
            byte[] bArr2 = this.outdata;
            bArr2[0] = 122;
            bArr2[1] = 0;
            return;
        }
        byte[] bArr3 = this.outdata;
        bArr3[0] = (byte) (r8 + 33);
        long j2 = j - (((((j / 52200625) * 85) * 85) * 85) * 85);
        bArr3[1] = (byte) (r8 + 33);
        long j3 = j2 - ((((j2 / 614125) * 85) * 85) * 85);
        bArr3[2] = (byte) (r8 + 33);
        long j4 = j3 - (((j3 / 7225) * 85) * 85);
        bArr3[3] = (byte) ((j4 / 85) + 33);
        bArr3[4] = (byte) ((j4 % 85) + 33);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            super.close();
        } finally {
            this.outdata = null;
            this.indata = null;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        if (this.flushed) {
            return;
        }
        int i2 = this.count;
        if (i2 > 0) {
            while (i2 < 4) {
                this.indata[i2] = 0;
                i2++;
            }
            transformASCII85();
            if (this.outdata[0] == 122) {
                for (int i3 = 0; i3 < 5; i3++) {
                    this.outdata[i3] = 33;
                }
            }
            for (int i4 = 0; i4 < this.count + 1; i4++) {
                ((FilterOutputStream) this).out.write(this.outdata[i4]);
                int i5 = this.lineBreak - 1;
                this.lineBreak = i5;
                if (i5 == 0) {
                    ((FilterOutputStream) this).out.write(10);
                    this.lineBreak = this.maxline;
                }
            }
        }
        int i6 = this.lineBreak - 1;
        this.lineBreak = i6;
        if (i6 == 0) {
            ((FilterOutputStream) this).out.write(10);
        }
        ((FilterOutputStream) this).out.write(this.terminator);
        ((FilterOutputStream) this).out.write(62);
        ((FilterOutputStream) this).out.write(10);
        this.count = 0;
        this.lineBreak = this.maxline;
        this.flushed = true;
        super.flush();
    }

    public int getLineLength() {
        return this.maxline;
    }

    public char getTerminator() {
        return this.terminator;
    }

    public void setLineLength(int i2) {
        if (this.lineBreak > i2) {
            this.lineBreak = i2;
        }
        this.maxline = i2;
    }

    public void setTerminator(char c2) {
        if (c2 < 'v' || c2 > '~' || c2 == 'z') {
            throw new IllegalArgumentException("Terminator must be 118-126 excluding z");
        }
        this.terminator = c2;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i2) throws IOException {
        this.flushed = false;
        byte[] bArr = this.indata;
        int i3 = this.count;
        int i4 = i3 + 1;
        this.count = i4;
        bArr[i3] = (byte) i2;
        if (i4 < 4) {
            return;
        }
        transformASCII85();
        for (int i5 = 0; i5 < 5; i5++) {
            byte[] bArr2 = this.outdata;
            if (bArr2[i5] == 0) {
                break;
            }
            ((FilterOutputStream) this).out.write(bArr2[i5]);
            int i6 = this.lineBreak - 1;
            this.lineBreak = i6;
            if (i6 == 0) {
                ((FilterOutputStream) this).out.write(10);
                this.lineBreak = this.maxline;
            }
        }
        this.count = 0;
    }
}
