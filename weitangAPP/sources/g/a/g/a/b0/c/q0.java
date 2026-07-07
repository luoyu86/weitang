package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class q0 extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f14020i = s0.f14034g;
    public static final g.a.g.a.f[] j = {new s0(g.a.g.a.d.f14091b)};
    public t0 k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f14022b;

        public a(int i2, int[] iArr) {
            this.f14021a = i2;
            this.f14022b = iArr;
        }

        public final g.a.g.a.i a(int[] iArr, int[] iArr2) {
            return q0.this.f(new s0(iArr), new s0(iArr2), q0.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f14021a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            int[] iArrCreate = g.a.g.c.n.create(17);
            int[] iArrCreate2 = g.a.g.c.n.create(17);
            int i3 = 0;
            for (int i4 = 0; i4 < this.f14021a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 17; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f14022b;
                    iArrCreate[i6] = i7 ^ (iArr[i3 + i6] & i5);
                    iArrCreate2[i6] = iArrCreate2[i6] ^ (iArr[(i3 + 17) + i6] & i5);
                }
                i3 += 34;
            }
            return a(iArrCreate, iArrCreate2);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            int[] iArrCreate = g.a.g.c.n.create(17);
            int[] iArrCreate2 = g.a.g.c.n.create(17);
            int i3 = i2 * 17 * 2;
            for (int i4 = 0; i4 < 17; i4++) {
                int i5 = iArrCreate[i4];
                int[] iArr = this.f14022b;
                iArrCreate[i4] = i5 ^ iArr[i3 + i4];
                iArrCreate2[i4] = iArrCreate2[i4] ^ iArr[(i3 + 17) + i4];
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    public q0() {
        super(f14020i);
        this.k = new t0(this, null, null);
        this.f14097b = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
        this.f14100e = BigInteger.valueOf(1L);
        this.f14101f = 2;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new q0();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 17 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.n.copy(17, ((s0) iVar.getRawXCoord()).f14035h, 0, iArr, i4);
            int i6 = i4 + 17;
            g.a.g.c.n.copy(17, ((s0) iVar.getRawYCoord()).f14035h, 0, iArr, i6);
            i4 = i6 + 17;
        }
        return new a(i3, iArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new t0(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new t0(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new s0(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return f14020i.bitLength();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public BigInteger getQ() {
        return f14020i;
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.n.create(17);
        r0.random(secureRandom, iArrCreate);
        return new s0(iArrCreate);
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.n.create(17);
        r0.randomMult(secureRandom, iArrCreate);
        return new s0(iArrCreate);
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 2;
    }
}
