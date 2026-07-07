package com.tom_roush.pdfbox.pdfparser;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class InputStreamSource implements SequentialSource {
    private final PushbackInputStream input;
    private int position = 0;

    public InputStreamSource(InputStream inputStream) {
        this.input = new PushbackInputStream(inputStream, 32767);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.input.close();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public long getPosition() throws IOException {
        return this.position;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public boolean isEOF() throws IOException {
        return peek() == -1;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public int peek() throws IOException {
        int i2 = this.input.read();
        if (i2 != -1) {
            this.input.unread(i2);
        }
        return i2;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public int read() throws IOException {
        int i2 = this.input.read();
        this.position++;
        return i2;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public byte[] readFully(int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        do {
            int i4 = read(bArr, i3, i2 - i3);
            if (i4 < 0) {
                throw new EOFException();
            }
            i3 += i4;
        } while (i3 < i2);
        return bArr;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public void unread(int i2) throws IOException {
        this.input.unread(i2);
        this.position--;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public int read(byte[] bArr) throws IOException {
        int i2 = this.input.read(bArr);
        if (i2 <= 0) {
            return -1;
        }
        this.position += i2;
        return i2;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public void unread(byte[] bArr) throws IOException {
        this.input.unread(bArr);
        this.position -= bArr.length;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.input.read(bArr, i2, i3);
        if (i4 <= 0) {
            return -1;
        }
        this.position += i4;
        return i4;
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public void unread(byte[] bArr, int i2, int i3) throws IOException {
        this.input.unread(bArr, i2, i3);
        this.position -= i3;
    }
}
