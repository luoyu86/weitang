package g.a.e.a;

import g.a.d.m.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public class a extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cipher f13828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f13831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13833f;

    public a(InputStream inputStream, Cipher cipher) {
        super(inputStream);
        this.f13829b = new byte[512];
        this.f13830c = false;
        this.f13828a = cipher;
    }

    public final byte[] a() throws b {
        try {
            if (this.f13830c) {
                return null;
            }
            this.f13830c = true;
            return this.f13828a.doFinal();
        } catch (GeneralSecurityException e2) {
            throw new b("Error finalising cipher", e2);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.f13832e - this.f13833f;
    }

    public final int b() throws IOException {
        if (this.f13830c) {
            return -1;
        }
        this.f13833f = 0;
        this.f13832e = 0;
        while (true) {
            int i2 = this.f13832e;
            if (i2 != 0) {
                return i2;
            }
            int i3 = ((FilterInputStream) this).in.read(this.f13829b);
            if (i3 == -1) {
                byte[] bArrA = a();
                this.f13831d = bArrA;
                if (bArrA == null || bArrA.length == 0) {
                    return -1;
                }
                int length = bArrA.length;
                this.f13832e = length;
                return length;
            }
            byte[] bArrUpdate = this.f13828a.update(this.f13829b, 0, i3);
            this.f13831d = bArrUpdate;
            if (bArrUpdate != null) {
                this.f13832e = bArrUpdate.length;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
            this.f13833f = 0;
            this.f13832e = 0;
        } finally {
            if (!this.f13830c) {
                a();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f13833f >= this.f13832e && b() < 0) {
            return -1;
        }
        byte[] bArr = this.f13831d;
        int i2 = this.f13833f;
        this.f13833f = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f13833f >= this.f13832e && b() < 0) {
            return -1;
        }
        int iMin = Math.min(i3, available());
        System.arraycopy(this.f13831d, this.f13833f, bArr, i2, iMin);
        this.f13833f += iMin;
        return iMin;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(j, available());
        this.f13833f += iMin;
        return iMin;
    }
}
