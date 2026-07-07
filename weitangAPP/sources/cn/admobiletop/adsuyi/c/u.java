package cn.admobiletop.adsuyi.c;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class u extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f4266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f4270e;

    public u(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public long a(int i2) {
        long j = this.f4267b + ((long) i2);
        if (this.f4269d < j) {
            c(j);
        }
        return this.f4267b;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f4266a.available();
    }

    public final void b(long j, long j2) throws IOException {
        while (j < j2) {
            long jSkip = this.f4266a.skip(j2 - j);
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

    public final void c(long j) {
        try {
            long j2 = this.f4268c;
            long j3 = this.f4267b;
            if (j2 >= j3 || j3 > this.f4269d) {
                this.f4268c = j3;
                this.f4266a.mark((int) (j - j3));
            } else {
                this.f4266a.reset();
                this.f4266a.mark((int) (j - this.f4268c));
                b(this.f4268c, this.f4267b);
            }
            this.f4269d = j;
        } catch (IOException e2) {
            throw new IllegalStateException("Unable to mark: " + e2);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4266a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i2) {
        this.f4270e = a(i2);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f4266a.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i2 = this.f4266a.read();
        if (i2 != -1) {
            this.f4267b++;
        }
        return i2;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        a(this.f4270e);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.f4266a.skip(j);
        this.f4267b += jSkip;
        return jSkip;
    }

    public u(InputStream inputStream, int i2) {
        this.f4270e = -1L;
        this.f4266a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i2);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i2 = this.f4266a.read(bArr);
        if (i2 != -1) {
            this.f4267b += (long) i2;
        }
        return i2;
    }

    public void a(long j) throws IOException {
        if (this.f4267b <= this.f4269d && j >= this.f4268c) {
            this.f4266a.reset();
            b(this.f4268c, j);
            this.f4267b = j;
            return;
        }
        throw new IOException("Cannot reset");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f4266a.read(bArr, i2, i3);
        if (i4 != -1) {
            this.f4267b += (long) i4;
        }
        return i4;
    }
}
