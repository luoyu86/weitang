package g.a.a;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class i extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13114a = new a(i.class, 10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i[] f13115b = new i[12];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13116c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13117d;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return i.g(x1Var.getOctets(), false);
        }
    }

    public i(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.f13116c = BigInteger.valueOf(i2).toByteArray();
        this.f13117d = 0;
    }

    public i(BigInteger bigInteger) {
        if (bigInteger.signum() < 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.f13116c = bigInteger.toByteArray();
        this.f13117d = 0;
    }

    public i(byte[] bArr) {
        this(bArr, true);
    }

    public i(byte[] bArr, boolean z) {
        if (q.i(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        }
        if ((bArr[0] & 128) != 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.f13116c = z ? g.a.j.a.clone(bArr) : bArr;
        this.f13117d = q.k(bArr);
    }

    public static i g(byte[] bArr, boolean z) {
        if (bArr.length > 1) {
            return new i(bArr, z);
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int i2 = bArr[0] & 255;
        i[] iVarArr = f13115b;
        if (i2 >= iVarArr.length) {
            return new i(bArr, z);
        }
        i iVar = iVarArr[i2];
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(bArr, z);
        iVarArr[i2] = iVar2;
        return iVar2;
    }

    public static i getInstance(l0 l0Var, boolean z) {
        return (i) f13114a.e(l0Var, z);
    }

    public static i getInstance(Object obj) {
        if (obj == null || (obj instanceof i)) {
            return (i) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (i) f13114a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (a0Var instanceof i) {
            return g.a.j.a.areEqual(this.f13116c, ((i) a0Var).f13116c);
        }
        return false;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 10, this.f13116c);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return y.e(z, this.f13116c.length);
    }

    public BigInteger getValue() {
        return new BigInteger(this.f13116c);
    }

    public boolean hasValue(int i2) {
        byte[] bArr = this.f13116c;
        int length = bArr.length;
        int i3 = this.f13117d;
        return length - i3 <= 4 && q.h(bArr, i3, -1) == i2;
    }

    public boolean hasValue(BigInteger bigInteger) {
        return bigInteger != null && q.h(this.f13116c, this.f13117d, -1) == bigInteger.intValue() && getValue().equals(bigInteger);
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return g.a.j.a.hashCode(this.f13116c);
    }

    public int intValueExact() {
        byte[] bArr = this.f13116c;
        int length = bArr.length;
        int i2 = this.f13117d;
        if (length - i2 <= 4) {
            return q.h(bArr, i2, -1);
        }
        throw new ArithmeticException("ASN.1 Enumerated out of int range");
    }
}
