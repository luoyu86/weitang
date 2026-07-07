package g.a.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class z2 extends c3 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13562f;

    public z2(InputStream inputStream, int i2) throws IOException {
        super(inputStream, i2);
        this.f13561e = false;
        this.f13562f = true;
        this.f13559c = inputStream.read();
        int i3 = inputStream.read();
        this.f13560d = i3;
        if (i3 < 0) {
            throw new EOFException();
        }
        c();
    }

    public final boolean c() {
        if (!this.f13561e && this.f13562f && this.f13559c == 0 && this.f13560d == 0) {
            this.f13561e = true;
            b(true);
        }
        return this.f13561e;
    }

    public void d(boolean z) {
        this.f13562f = z;
        c();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (c()) {
            return -1;
        }
        int i2 = this.f13056a.read();
        if (i2 < 0) {
            throw new EOFException();
        }
        int i3 = this.f13559c;
        this.f13559c = this.f13560d;
        this.f13560d = i2;
        return i3;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.f13562f || i3 < 3) {
            return super.read(bArr, i2, i3);
        }
        if (this.f13561e) {
            return -1;
        }
        int i4 = this.f13056a.read(bArr, i2 + 2, i3 - 2);
        if (i4 < 0) {
            throw new EOFException();
        }
        bArr[i2] = (byte) this.f13559c;
        bArr[i2 + 1] = (byte) this.f13560d;
        this.f13559c = this.f13056a.read();
        int i5 = this.f13056a.read();
        this.f13560d = i5;
        if (i5 >= 0) {
            return i4 + 2;
        }
        throw new EOFException();
    }
}
