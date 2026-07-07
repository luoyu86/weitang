package g.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class x2 extends c3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f13417c = new byte[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13419e;

    public x2(InputStream inputStream, int i2, int i3) {
        super(inputStream, i3);
        if (i2 <= 0) {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative lengths not allowed");
            }
            b(true);
        }
        this.f13418d = i2;
        this.f13419e = i2;
    }

    public int c() {
        return this.f13419e;
    }

    public void d(byte[] bArr) throws IOException {
        int i2 = this.f13419e;
        if (i2 != bArr.length) {
            throw new IllegalArgumentException("buffer length not right for data");
        }
        if (i2 == 0) {
            return;
        }
        int iA = a();
        int i3 = this.f13419e;
        if (i3 >= iA) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.f13419e + " >= " + iA);
        }
        int fully = i3 - g.a.j.s.b.readFully(this.f13056a, bArr, 0, bArr.length);
        this.f13419e = fully;
        if (fully == 0) {
            b(true);
            return;
        }
        throw new EOFException("DEF length " + this.f13418d + " object truncated by " + this.f13419e);
    }

    public byte[] e() throws IOException {
        if (this.f13419e == 0) {
            return f13417c;
        }
        int iA = a();
        int i2 = this.f13419e;
        if (i2 >= iA) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.f13419e + " >= " + iA);
        }
        byte[] bArr = new byte[i2];
        int fully = i2 - g.a.j.s.b.readFully(this.f13056a, bArr, 0, i2);
        this.f13419e = fully;
        if (fully == 0) {
            b(true);
            return bArr;
        }
        throw new EOFException("DEF length " + this.f13418d + " object truncated by " + this.f13419e);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f13419e == 0) {
            return -1;
        }
        int i2 = this.f13056a.read();
        if (i2 >= 0) {
            int i3 = this.f13419e - 1;
            this.f13419e = i3;
            if (i3 == 0) {
                b(true);
            }
            return i2;
        }
        throw new EOFException("DEF length " + this.f13418d + " object truncated by " + this.f13419e);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f13419e;
        if (i4 == 0) {
            return -1;
        }
        int i5 = this.f13056a.read(bArr, i2, Math.min(i3, i4));
        if (i5 >= 0) {
            int i6 = this.f13419e - i5;
            this.f13419e = i6;
            if (i6 == 0) {
                b(true);
            }
            return i5;
        }
        throw new EOFException("DEF length " + this.f13418d + " object truncated by " + this.f13419e);
    }
}
