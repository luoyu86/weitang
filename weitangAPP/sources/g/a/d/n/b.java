package g.a.d.n;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class b implements g.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f13796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f13797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BigInteger f13798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f13799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f13802g;

    public b(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, null, 0);
    }

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i2) {
        this(bigInteger, bigInteger2, bigInteger3, a(i2), i2, null, null);
    }

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i2, int i3) {
        this(bigInteger, bigInteger2, bigInteger3, i2, i3, null, null);
    }

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i2, int i3, BigInteger bigInteger4, c cVar) {
        if (i3 != 0) {
            if (i3 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
            if (i3 < i2) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i2 > bigInteger.bitLength() && !g.a.j.l.isOverrideSet("org.bouncycastle.dh.allow_unsafe_p_value")) {
            throw new IllegalArgumentException("unsafe p value so small specific l required");
        }
        this.f13796a = bigInteger2;
        this.f13797b = bigInteger;
        this.f13798c = bigInteger3;
        this.f13800e = i2;
        this.f13801f = i3;
        this.f13799d = bigInteger4;
        this.f13802g = cVar;
    }

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, c cVar) {
        this(bigInteger, bigInteger2, bigInteger3, 160, 0, bigInteger4, cVar);
    }

    public static int a(int i2) {
        if (i2 != 0 && i2 < 160) {
            return i2;
        }
        return 160;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (getQ() != null) {
            if (!getQ().equals(bVar.getQ())) {
                return false;
            }
        } else if (bVar.getQ() != null) {
            return false;
        }
        return bVar.getP().equals(this.f13797b) && bVar.getG().equals(this.f13796a);
    }

    public BigInteger getG() {
        return this.f13796a;
    }

    public BigInteger getJ() {
        return this.f13799d;
    }

    public int getL() {
        return this.f13801f;
    }

    public int getM() {
        return this.f13800e;
    }

    public BigInteger getP() {
        return this.f13797b;
    }

    public BigInteger getQ() {
        return this.f13798c;
    }

    public c getValidationParameters() {
        return this.f13802g;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) ^ (getQ() != null ? getQ().hashCode() : 0);
    }
}
