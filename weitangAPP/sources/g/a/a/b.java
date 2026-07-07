package g.a.a;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends a0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13036a = new a(b.class, 30);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f13037b;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return b.g(x1Var.getOctets());
        }
    }

    public b(String str) {
        Objects.requireNonNull(str, "'string' cannot be null");
        this.f13037b = str.toCharArray();
    }

    public b(byte[] bArr) {
        Objects.requireNonNull(bArr, "'string' cannot be null");
        int length = bArr.length;
        if ((length & 1) != 0) {
            throw new IllegalArgumentException("malformed BMPString encoding encountered");
        }
        int i2 = length / 2;
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 != i2; i3++) {
            int i4 = i3 * 2;
            cArr[i3] = (char) ((bArr[i4 + 1] & 255) | (bArr[i4] << 8));
        }
        this.f13037b = cArr;
    }

    public b(char[] cArr) {
        Objects.requireNonNull(cArr, "'string' cannot be null");
        this.f13037b = cArr;
    }

    public static b g(byte[] bArr) {
        return new m1(bArr);
    }

    public static b getInstance(l0 l0Var, boolean z) {
        return (b) f13036a.e(l0Var, z);
    }

    public static b getInstance(Object obj) {
        if (obj == null || (obj instanceof b)) {
            return (b) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof b) {
                return (b) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (b) f13036a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    public static b h(char[] cArr) {
        return new m1(cArr);
    }

    @Override // g.a.a.a0
    public final boolean a(a0 a0Var) {
        if (a0Var instanceof b) {
            return g.a.j.a.areEqual(this.f13037b, ((b) a0Var).f13037b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public final void b(y yVar, boolean z) throws IOException {
        int length = this.f13037b.length;
        yVar.q(z, 30);
        yVar.i(length * 2);
        byte[] bArr = new byte[8];
        int i2 = length & (-4);
        int i3 = 0;
        while (i3 < i2) {
            char[] cArr = this.f13037b;
            char c2 = cArr[i3];
            char c3 = cArr[i3 + 1];
            char c4 = cArr[i3 + 2];
            char c5 = cArr[i3 + 3];
            i3 += 4;
            bArr[0] = (byte) (c2 >> '\b');
            bArr[1] = (byte) c2;
            bArr[2] = (byte) (c3 >> '\b');
            bArr[3] = (byte) c3;
            bArr[4] = (byte) (c4 >> '\b');
            bArr[5] = (byte) c4;
            bArr[6] = (byte) (c5 >> '\b');
            bArr[7] = (byte) c5;
            yVar.h(bArr, 0, 8);
        }
        if (i3 < length) {
            int i4 = 0;
            do {
                char c6 = this.f13037b[i3];
                i3++;
                int i5 = i4 + 1;
                bArr[i4] = (byte) (c6 >> '\b');
                i4 = i5 + 1;
                bArr[i5] = (byte) c6;
            } while (i3 < length);
            yVar.h(bArr, 0, i4);
        }
    }

    @Override // g.a.a.a0
    public final boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public final int d(boolean z) {
        return y.e(z, this.f13037b.length * 2);
    }

    @Override // g.a.a.i0
    public final String getString() {
        return new String(this.f13037b);
    }

    @Override // g.a.a.a0, g.a.a.t
    public final int hashCode() {
        return g.a.j.a.hashCode(this.f13037b);
    }

    public String toString() {
        return getString();
    }
}
