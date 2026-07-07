package g.a.a;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f13101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[][] f13103c;

    public h0(InputStream inputStream) {
        this(inputStream, e3.a(inputStream));
    }

    public h0(InputStream inputStream, int i2) {
        this(inputStream, i2, new byte[11][]);
    }

    public h0(InputStream inputStream, int i2, byte[][] bArr) {
        this.f13101a = inputStream;
        this.f13102b = i2;
        this.f13103c = bArr;
    }

    public h0(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public g a(int i2) throws IOException {
        k(false);
        int iJ = p.j(this.f13101a, i2);
        int i3 = p.i(this.f13101a, this.f13102b, iJ == 3 || iJ == 4 || iJ == 16 || iJ == 17 || iJ == 8);
        if (i3 < 0) {
            if ((i2 & 32) == 0) {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
            h0 h0Var = new h0(new z2(this.f13101a, this.f13102b), this.f13102b, this.f13103c);
            int i4 = i2 & 192;
            return i4 != 0 ? 64 == i4 ? new x0(iJ, h0Var) : new i1(i4, iJ, h0Var) : h0Var.e(iJ);
        }
        x2 x2Var = new x2(this.f13101a, i3, this.f13102b);
        if ((i2 & 224) == 0) {
            return g(iJ, x2Var);
        }
        h0 h0Var2 = new h0(x2Var, x2Var.a(), this.f13103c);
        int i5 = i2 & 192;
        if (i5 == 0) {
            return h0Var2.d(iJ);
        }
        boolean z = (i2 & 32) != 0;
        return 64 == i5 ? (k2) h0Var2.b(i5, iJ, z) : new v2(i5, iJ, z, h0Var2);
    }

    public a0 b(int i2, int i3, boolean z) throws IOException {
        return !z ? l0.j(i2, i3, ((x2) this.f13101a).e()) : l0.h(i2, i3, j());
    }

    public a0 c(int i2, int i3) throws IOException {
        return l0.i(i2, i3, j());
    }

    public g d(int i2) throws IOException {
        if (i2 == 3) {
            return new z0(this);
        }
        if (i2 == 4) {
            return new c1(this);
        }
        if (i2 == 8) {
            return new p1(this);
        }
        if (i2 == 16) {
            return new r2(this);
        }
        if (i2 == 17) {
            return new t2(this);
        }
        throw new j("unknown DL object encountered: 0x" + Integer.toHexString(i2));
    }

    public g e(int i2) throws IOException {
        if (i2 == 3) {
            return new z0(this);
        }
        if (i2 == 4) {
            return new c1(this);
        }
        if (i2 == 8) {
            return new p1(this);
        }
        if (i2 == 16) {
            return new e1(this);
        }
        if (i2 == 17) {
            return new g1(this);
        }
        throw new j("unknown BER object encountered: 0x" + Integer.toHexString(i2));
    }

    public g f(int i2) throws IOException {
        return g(i2, (x2) this.f13101a);
    }

    public g g(int i2, x2 x2Var) throws IOException {
        if (i2 == 3) {
            return new m2(x2Var);
        }
        if (i2 == 4) {
            return new y1(x2Var);
        }
        if (i2 == 8) {
            throw new j("externals must use constructed encoding (see X.690 8.18)");
        }
        if (i2 == 16) {
            throw new j("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
        }
        if (i2 == 17) {
            throw new j("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
        }
        try {
            return p.d(i2, x2Var, this.f13103c);
        } catch (IllegalArgumentException e2) {
            throw new j("corrupted stream detected", e2);
        }
    }

    public g h(int i2) throws IOException {
        if (i2 < 0 || i2 > 30) {
            throw new IllegalArgumentException("invalid universal tag number: " + i2);
        }
        int i3 = this.f13101a.read();
        if (i3 < 0) {
            return null;
        }
        if ((i3 & (-33)) == i2) {
            return a(i3);
        }
        throw new IOException("unexpected identifier encountered: " + i3);
    }

    public m0 i() throws IOException {
        int i2 = this.f13101a.read();
        if (i2 < 0) {
            return null;
        }
        if ((i2 & 192) != 0) {
            return (m0) a(i2);
        }
        throw new j("no tagged object found");
    }

    public h j() throws IOException {
        int i2 = this.f13101a.read();
        if (i2 < 0) {
            return new h(0);
        }
        h hVar = new h();
        do {
            g gVarA = a(i2);
            hVar.add(gVarA instanceof y2 ? ((y2) gVarA).getLoadedObject() : gVarA.toASN1Primitive());
            i2 = this.f13101a.read();
        } while (i2 >= 0);
        return hVar;
    }

    public final void k(boolean z) {
        InputStream inputStream = this.f13101a;
        if (inputStream instanceof z2) {
            ((z2) inputStream).d(z);
        }
    }

    public g readObject() throws IOException {
        int i2 = this.f13101a.read();
        if (i2 < 0) {
            return null;
        }
        return a(i2);
    }
}
