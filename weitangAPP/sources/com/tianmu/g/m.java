package com.tianmu.g;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f12093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f12095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f12097e;

    public m(InputStream inputStream) {
        this(inputStream, 4096);
    }

    private void b(long j) {
        try {
            long j2 = this.f12095c;
            long j3 = this.f12094b;
            if (j2 >= j3 || j3 > this.f12096d) {
                this.f12095c = j3;
                this.f12093a.mark((int) (j - j3));
            } else {
                this.f12093a.reset();
                this.f12093a.mark((int) (j - this.f12095c));
                a(this.f12095c, this.f12094b);
            }
            this.f12096d = j;
        } catch (IOException e2) {
            throw new IllegalStateException("Unable to mark: " + e2);
        }
    }

    public long a(int i2) {
        long j = this.f12094b + ((long) i2);
        if (this.f12096d < j) {
            b(j);
        }
        return this.f12094b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f12093a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12093a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f12097e = a(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f12093a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i2 = this.f12093a.read();
        if (i2 != -1) {
            this.f12094b++;
        }
        return i2;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        a(this.f12097e);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.f12093a.skip(j);
        this.f12094b += jSkip;
        return jSkip;
    }

    public m(InputStream inputStream, int i2) {
        this.f12097e = -1L;
        this.f12093a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i2);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i2 = this.f12093a.read(bArr);
        if (i2 != -1) {
            this.f12094b += (long) i2;
        }
        return i2;
    }

    public void a(long j) throws IOException {
        if (this.f12094b <= this.f12096d && j >= this.f12095c) {
            this.f12093a.reset();
            a(this.f12095c, j);
            this.f12094b = j;
            return;
        }
        throw new IOException("Cannot reset");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f12093a.read(bArr, i2, i3);
        if (i4 != -1) {
            this.f12094b += (long) i4;
        }
        return i4;
    }

    private void a(long j, long j2) throws IOException {
        while (j < j2) {
            long jSkip = this.f12093a.skip(j2 - j);
            if (jSkip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j += jSkip;
        }
    }
}
