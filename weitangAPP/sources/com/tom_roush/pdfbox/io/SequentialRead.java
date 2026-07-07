package com.tom_roush.pdfbox.io;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface SequentialRead extends Closeable {
    int read() throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i2, int i3) throws IOException;
}
