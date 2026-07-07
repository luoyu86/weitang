package com.tom_roush.pdfbox.pdfparser;

import com.tom_roush.pdfbox.io.RandomAccessRead;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class RandomAccessSource implements SequentialSource {
    private final RandomAccessRead reader;

    public RandomAccessSource(RandomAccessRead randomAccessRead) {
        this.reader = randomAccessRead;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public long getPosition() throws IOException {
        return this.reader.getPosition();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public boolean isEOF() throws IOException {
        return this.reader.isEOF();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public int peek() throws IOException {
        return this.reader.peek();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public int read() throws IOException {
        return this.reader.read();
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public byte[] readFully(int i2) throws IOException {
        return this.reader.readFully(i2);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public void unread(int i2) throws IOException {
        this.reader.rewind(1);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public int read(byte[] bArr) throws IOException {
        return this.reader.read(bArr);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public void unread(byte[] bArr) throws IOException {
        this.reader.rewind(bArr.length);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        return this.reader.read(bArr, i2, i3);
    }

    @Override // com.tom_roush.pdfbox.pdfparser.SequentialSource
    public void unread(byte[] bArr, int i2, int i3) throws IOException {
        this.reader.rewind(i3);
    }
}
