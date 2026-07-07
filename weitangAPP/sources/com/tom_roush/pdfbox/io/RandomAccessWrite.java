package com.tom_roush.pdfbox.io;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface RandomAccessWrite extends Closeable {
    void clear() throws IOException;

    void write(int i2) throws IOException;

    void write(byte[] bArr) throws IOException;

    void write(byte[] bArr, int i2, int i3) throws IOException;
}
