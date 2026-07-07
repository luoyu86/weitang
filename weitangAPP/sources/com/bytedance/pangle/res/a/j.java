package com.bytedance.pangle.res.a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class j extends FilterInputStream {
    public j(InputStream inputStream) {
        super(inputStream);
    }

    public void a(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        try {
            return super.available();
        } catch (IOException e2) {
            throw e2;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
        } catch (IOException e2) {
            throw e2;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i2) {
        ((FilterInputStream) this).in.mark(i2);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return ((FilterInputStream) this).in.markSupported();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        try {
            int i2 = ((FilterInputStream) this).in.read();
            a(i2 != -1 ? 1 : -1);
            return i2;
        } catch (IOException e2) {
            throw e2;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        try {
            ((FilterInputStream) this).in.reset();
        } catch (IOException e2) {
            throw e2;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        try {
            return ((FilterInputStream) this).in.skip(j);
        } catch (IOException e2) {
            throw e2;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        try {
            int i2 = ((FilterInputStream) this).in.read(bArr);
            a(i2);
            return i2;
        } catch (IOException e2) {
            throw e2;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        try {
            int i4 = ((FilterInputStream) this).in.read(bArr, i2, i3);
            a(i4);
            return i4;
        } catch (IOException e2) {
            throw e2;
        }
    }
}
