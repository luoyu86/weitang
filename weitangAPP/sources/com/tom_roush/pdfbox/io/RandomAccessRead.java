package com.tom_roush.pdfbox.io;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public interface RandomAccessRead extends Closeable {
    int available() throws IOException;

    long getPosition() throws IOException;

    boolean isClosed();

    boolean isEOF() throws IOException;

    long length() throws IOException;

    int peek() throws IOException;

    int read() throws IOException;

    int read(byte[] bArr) throws IOException;

    int read(byte[] bArr, int i2, int i3) throws IOException;

    byte[] readFully(int i2) throws IOException;

    void rewind(int i2) throws IOException;

    void seek(long j) throws IOException;
}
