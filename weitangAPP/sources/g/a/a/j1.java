package g.a.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class j1 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h0 f13182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13184c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13185d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f13186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InputStream f13187f;

    public j1(h0 h0Var, boolean z) {
        this.f13182a = h0Var;
        this.f13183b = z;
    }

    public final d a() throws IOException {
        g object = this.f13182a.readObject();
        if (object == null) {
            if (!this.f13183b || this.f13185d == 0) {
                return null;
            }
            throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.f13185d);
        }
        if (object instanceof d) {
            if (this.f13185d == 0) {
                return (d) object;
            }
            throw new IOException("only the last nested bitstring can have padding");
        }
        throw new IOException("unknown object encountered: " + object.getClass());
    }

    public int b() {
        return this.f13185d;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f13187f == null) {
            if (!this.f13184c) {
                return -1;
            }
            d dVarA = a();
            this.f13186e = dVarA;
            if (dVarA == null) {
                return -1;
            }
            this.f13184c = false;
            this.f13187f = dVarA.getBitStream();
        }
        while (true) {
            int i2 = this.f13187f.read();
            if (i2 >= 0) {
                return i2;
            }
            this.f13185d = this.f13186e.getPadBits();
            d dVarA2 = a();
            this.f13186e = dVarA2;
            if (dVarA2 == null) {
                this.f13187f = null;
                return -1;
            }
            this.f13187f = dVarA2.getBitStream();
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        if (this.f13187f == null) {
            if (!this.f13184c) {
                return -1;
            }
            d dVarA = a();
            this.f13186e = dVarA;
            if (dVarA == null) {
                return -1;
            }
            this.f13184c = false;
            this.f13187f = dVarA.getBitStream();
        }
        while (true) {
            int i5 = this.f13187f.read(bArr, i2 + i4, i3 - i4);
            if (i5 >= 0) {
                i4 += i5;
                if (i4 == i3) {
                    return i4;
                }
            } else {
                this.f13185d = this.f13186e.getPadBits();
                d dVarA2 = a();
                this.f13186e = dVarA2;
                if (dVarA2 == null) {
                    this.f13187f = null;
                    if (i4 < 1) {
                        return -1;
                    }
                    return i4;
                }
                this.f13187f = dVarA2.getBitStream();
            }
        }
    }
}
