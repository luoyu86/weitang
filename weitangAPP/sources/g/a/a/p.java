package g.a.a;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class p extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[][] f13279c;

    public p(InputStream inputStream) {
        this(inputStream, e3.a(inputStream));
    }

    public p(InputStream inputStream, int i2) {
        this(inputStream, i2, false);
    }

    public p(InputStream inputStream, int i2, boolean z) {
        this(inputStream, i2, z, new byte[11][]);
    }

    public p(InputStream inputStream, int i2, boolean z, byte[][] bArr) {
        super(inputStream);
        this.f13277a = i2;
        this.f13278b = z;
        this.f13279c = bArr;
    }

    public p(InputStream inputStream, boolean z) {
        this(inputStream, e3.a(inputStream), z);
    }

    public p(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }

    public p(byte[] bArr, boolean z) {
        this(new ByteArrayInputStream(bArr), bArr.length, z);
    }

    public static a0 d(int i2, x2 x2Var, byte[][] bArr) throws IOException {
        switch (i2) {
            case 1:
                return e.g(f(x2Var, bArr));
            case 2:
                return q.g(x2Var.e());
            case 3:
                return c.g(x2Var.e());
            case 4:
                return w.g(x2Var.e());
            case 5:
                return r.g(x2Var.e());
            case 6:
                return v.g(f(x2Var, bArr), true);
            case 7:
                return u.g(x2Var.e());
            case 8:
            case 9:
            case 11:
            case 14:
            case 15:
            case 16:
            case 17:
            case 29:
            default:
                throw new IOException("unknown tag " + i2 + " encountered");
            case 10:
                return i.g(f(x2Var, bArr), true);
            case 12:
                return p0.g(x2Var.e());
            case 13:
                return c0.g(x2Var.e(), false);
            case 18:
                return s.g(x2Var.e());
            case 19:
                return b0.g(x2Var.e());
            case 20:
                return j0.g(x2Var.e());
            case 21:
                return u0.g(x2Var.e());
            case 22:
                return o.g(x2Var.e());
            case 23:
                return o0.g(x2Var.e());
            case 24:
                return m.j(x2Var.e());
            case 25:
                return n.g(x2Var.e());
            case 26:
                return v0.g(x2Var.e());
            case 27:
                return l.g(x2Var.e());
            case 28:
                return q0.g(x2Var.e());
            case 30:
                return b.h(e(x2Var));
        }
    }

    public static char[] e(x2 x2Var) throws IOException {
        int i2;
        int iC = x2Var.c();
        if ((iC & 1) != 0) {
            throw new IOException("malformed BMPString encoding encountered");
        }
        int i3 = iC / 2;
        char[] cArr = new char[i3];
        byte[] bArr = new byte[8];
        int i4 = 0;
        int i5 = 0;
        while (iC >= 8) {
            if (g.a.j.s.b.readFully(x2Var, bArr, 0, 8) != 8) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            cArr[i5] = (char) ((bArr[0] << 8) | (bArr[1] & 255));
            cArr[i5 + 1] = (char) ((bArr[2] << 8) | (bArr[3] & 255));
            cArr[i5 + 2] = (char) ((bArr[4] << 8) | (bArr[5] & 255));
            cArr[i5 + 3] = (char) ((bArr[6] << 8) | (bArr[7] & 255));
            i5 += 4;
            iC -= 8;
        }
        if (iC > 0) {
            if (g.a.j.s.b.readFully(x2Var, bArr, 0, iC) != iC) {
                throw new EOFException("EOF encountered in middle of BMPString");
            }
            while (true) {
                int i6 = i4 + 1;
                int i7 = i6 + 1;
                i2 = i5 + 1;
                cArr[i5] = (char) ((bArr[i4] << 8) | (bArr[i6] & 255));
                if (i7 >= iC) {
                    break;
                }
                i4 = i7;
                i5 = i2;
            }
            i5 = i2;
        }
        if (x2Var.c() == 0 && i3 == i5) {
            return cArr;
        }
        throw new IllegalStateException();
    }

    public static byte[] f(x2 x2Var, byte[][] bArr) throws IOException {
        int iC = x2Var.c();
        if (iC >= bArr.length) {
            return x2Var.e();
        }
        byte[] bArr2 = bArr[iC];
        if (bArr2 == null) {
            bArr2 = new byte[iC];
            bArr[iC] = bArr2;
        }
        x2Var.d(bArr2);
        return bArr2;
    }

    public static int i(InputStream inputStream, int i2, boolean z) throws IOException {
        int i3 = inputStream.read();
        if ((i3 >>> 7) == 0) {
            return i3;
        }
        if (128 == i3) {
            return -1;
        }
        if (i3 < 0) {
            throw new EOFException("EOF found when length expected");
        }
        if (255 == i3) {
            throw new IOException("invalid long form definite-length 0xFF");
        }
        int i4 = i3 & 127;
        int i5 = 0;
        int i6 = 0;
        do {
            int i7 = inputStream.read();
            if (i7 < 0) {
                throw new EOFException("EOF found reading length");
            }
            if ((i5 >>> 23) != 0) {
                throw new IOException("long form definite-length more than 31 bits");
            }
            i5 = (i5 << 8) + i7;
            i6++;
        } while (i6 < i4);
        if (i5 < i2 || z) {
            return i5;
        }
        throw new IOException("corrupted stream - out of bounds length found: " + i5 + " >= " + i2);
    }

    public static int j(InputStream inputStream, int i2) throws IOException {
        int i3 = i2 & 31;
        if (i3 != 31) {
            return i3;
        }
        int i4 = 0;
        int i5 = inputStream.read();
        if (i5 < 31) {
            if (i5 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
            throw new IOException("corrupted stream - high tag number < 31 found");
        }
        if ((i5 & 127) == 0) {
            throw new IOException("corrupted stream - invalid high tag number found");
        }
        while ((i5 & 128) != 0) {
            if ((i4 >>> 24) != 0) {
                throw new IOException("Tag number more than 31 bits");
            }
            i4 = (i4 | (i5 & 127)) << 7;
            i5 = inputStream.read();
            if (i5 < 0) {
                throw new EOFException("EOF found inside tag value.");
            }
        }
        return i4 | (i5 & 127);
    }

    public c a(h hVar) throws IOException {
        int size = hVar.size();
        c[] cVarArr = new c[size];
        for (int i2 = 0; i2 != size; i2++) {
            g gVar = hVar.get(i2);
            if (!(gVar instanceof c)) {
                throw new j("unknown object encountered in constructed BIT STRING: " + gVar.getClass());
            }
            cVarArr[i2] = (c) gVar;
        }
        return new y0(cVarArr);
    }

    public w b(h hVar) throws IOException {
        int size = hVar.size();
        w[] wVarArr = new w[size];
        for (int i2 = 0; i2 != size; i2++) {
            g gVar = hVar.get(i2);
            if (!(gVar instanceof w)) {
                throw new j("unknown object encountered in constructed OCTET STRING: " + gVar.getClass());
            }
            wVarArr[i2] = (w) gVar;
        }
        return new b1(wVarArr);
    }

    public a0 c(int i2, int i3, int i4) throws IOException {
        x2 x2Var = new x2(this, i4, this.f13277a);
        if ((i2 & 224) == 0) {
            return d(i3, x2Var, this.f13279c);
        }
        int i5 = i2 & 192;
        if (i5 != 0) {
            return k(i5, i3, (i2 & 32) != 0, x2Var);
        }
        if (i3 == 3) {
            return a(m(x2Var));
        }
        if (i3 == 4) {
            return b(m(x2Var));
        }
        if (i3 == 8) {
            return o2.a(m(x2Var)).j();
        }
        if (i3 == 16) {
            return x2Var.c() < 1 ? o2.f13273a : this.f13278b ? new b3(x2Var.e()) : o2.a(m(x2Var));
        }
        if (i3 == 17) {
            return o2.b(m(x2Var));
        }
        throw new IOException("unknown tag " + i3 + " encountered");
    }

    public int g() {
        return this.f13277a;
    }

    public int h() throws IOException {
        return i(this, this.f13277a, false);
    }

    public a0 k(int i2, int i3, boolean z, x2 x2Var) throws IOException {
        return !z ? l0.j(i2, i3, x2Var.e()) : l0.h(i2, i3, m(x2Var));
    }

    public h l() throws IOException {
        a0 object = readObject();
        if (object == null) {
            return new h(0);
        }
        h hVar = new h();
        do {
            hVar.add(object);
            object = readObject();
        } while (object != null);
        return hVar;
    }

    public h m(x2 x2Var) throws IOException {
        int iC = x2Var.c();
        return iC < 1 ? new h(0) : new p(x2Var, iC, this.f13278b, this.f13279c).l();
    }

    public a0 readObject() throws IOException {
        int i2 = read();
        if (i2 <= 0) {
            if (i2 != 0) {
                return null;
            }
            throw new IOException("unexpected end-of-contents marker");
        }
        int iJ = j(this, i2);
        int iH = h();
        if (iH >= 0) {
            try {
                return c(i2, iJ, iH);
            } catch (IllegalArgumentException e2) {
                throw new j("corrupted stream detected", e2);
            }
        }
        if ((i2 & 32) == 0) {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
        h0 h0Var = new h0(new z2(this, this.f13277a), this.f13277a, this.f13279c);
        int i3 = i2 & 192;
        if (i3 != 0) {
            return h0Var.c(i3, iJ);
        }
        if (iJ == 3) {
            return z0.a(h0Var);
        }
        if (iJ == 4) {
            return c1.a(h0Var);
        }
        if (iJ == 8) {
            return p1.a(h0Var);
        }
        if (iJ == 16) {
            return e1.a(h0Var);
        }
        if (iJ == 17) {
            return g1.a(h0Var);
        }
        throw new IOException("unknown BER object encountered");
    }
}
