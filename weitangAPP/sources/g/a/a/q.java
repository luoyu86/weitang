package g.a.a;

import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class q extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13288a = new a(q.class, 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13290c;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return q.g(x1Var.getOctets());
        }
    }

    public q(long j) {
        this.f13289b = BigInteger.valueOf(j).toByteArray();
        this.f13290c = 0;
    }

    public q(BigInteger bigInteger) {
        this.f13289b = bigInteger.toByteArray();
        this.f13290c = 0;
    }

    public q(byte[] bArr) {
        this(bArr, true);
    }

    public q(byte[] bArr, boolean z) {
        if (i(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.f13289b = z ? g.a.j.a.clone(bArr) : bArr;
        this.f13290c = k(bArr);
    }

    public static q g(byte[] bArr) {
        return new q(bArr, false);
    }

    public static q getInstance(l0 l0Var, boolean z) {
        return (q) f13288a.e(l0Var, z);
    }

    public static q getInstance(Object obj) {
        if (obj == null || (obj instanceof q)) {
            return (q) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (q) f13288a.b((byte[]) obj);
        } catch (Exception e2) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e2.toString());
        }
    }

    public static int h(byte[] bArr, int i2, int i3) {
        int length = bArr.length;
        int iMax = Math.max(i2, length - 4);
        int i4 = i3 & bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return i4;
            }
            i4 = (i4 << 8) | (bArr[iMax] & 255);
        }
    }

    public static boolean i(byte[] bArr) {
        int length = bArr.length;
        if (length != 0) {
            return (length == 1 || bArr[0] != (bArr[1] >> 7) || g.a.j.l.isOverrideSet("org.bouncycastle.asn1.allow_unsafe_integer")) ? false : true;
        }
        return true;
    }

    public static long j(byte[] bArr, int i2, int i3) {
        int length = bArr.length;
        int iMax = Math.max(i2, length - 8);
        long j = i3 & bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return j;
            }
            j = (j << 8) | ((long) (bArr[iMax] & 255));
        }
    }

    public static int k(byte[] bArr) {
        int length = bArr.length - 1;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (bArr[i2] != (bArr[i3] >> 7)) {
                break;
            }
            i2 = i3;
        }
        return i2;
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (a0Var instanceof q) {
            return g.a.j.a.areEqual(this.f13289b, ((q) a0Var).f13289b);
        }
        return false;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.m(z, 2, this.f13289b);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return false;
    }

    @Override // g.a.a.a0
    public int d(boolean z) {
        return y.e(z, this.f13289b.length);
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.f13289b);
    }

    public BigInteger getValue() {
        return new BigInteger(this.f13289b);
    }

    public boolean hasValue(int i2) {
        byte[] bArr = this.f13289b;
        int length = bArr.length;
        int i3 = this.f13290c;
        return length - i3 <= 4 && h(bArr, i3, -1) == i2;
    }

    public boolean hasValue(long j) {
        byte[] bArr = this.f13289b;
        int length = bArr.length;
        int i2 = this.f13290c;
        return length - i2 <= 8 && j(bArr, i2, -1) == j;
    }

    public boolean hasValue(BigInteger bigInteger) {
        return bigInteger != null && h(this.f13289b, this.f13290c, -1) == bigInteger.intValue() && getValue().equals(bigInteger);
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return g.a.j.a.hashCode(this.f13289b);
    }

    public int intPositiveValueExact() {
        byte[] bArr = this.f13289b;
        int length = bArr.length;
        int i2 = this.f13290c;
        int i3 = length - i2;
        if (i3 > 4 || (i3 == 4 && (bArr[i2] & 128) != 0)) {
            throw new ArithmeticException("ASN.1 Integer out of positive int range");
        }
        return h(bArr, i2, 255);
    }

    public int intValueExact() {
        byte[] bArr = this.f13289b;
        int length = bArr.length;
        int i2 = this.f13290c;
        if (length - i2 <= 4) {
            return h(bArr, i2, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    public long longValueExact() {
        byte[] bArr = this.f13289b;
        int length = bArr.length;
        int i2 = this.f13290c;
        if (length - i2 <= 8) {
            return j(bArr, i2, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    public String toString() {
        return getValue().toString();
    }
}
