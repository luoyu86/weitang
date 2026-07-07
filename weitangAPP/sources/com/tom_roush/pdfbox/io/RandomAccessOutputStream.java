package com.tom_roush.pdfbox.io;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class RandomAccessOutputStream extends OutputStream {
    private final RandomAccessWrite writer;

    public RandomAccessOutputStream(RandomAccessWrite randomAccessWrite) {
        this.writer = randomAccessWrite;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.writer.write(bArr, i2, i3);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.writer.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        this.writer.write(i2);
    }
}
