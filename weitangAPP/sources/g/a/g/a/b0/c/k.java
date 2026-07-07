package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class k extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f13977i = m.f13990g;
    public static final g.a.g.a.f[] j = {new m(g.a.g.a.d.f14091b)};
    public n k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13979b;

        public a(int i2, int[] iArr) {
            this.f13978a = i2;
            this.f13979b = iArr;
        }

        public final g.a.g.a.i a(int[] iArr, int[] iArr2) {
            return k.this.f(new m(iArr), new m(iArr2), k.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13978a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            int[] iArrCreate = g.a.g.c.e.create();
            int[] iArrCreate2 = g.a.g.c.e.create();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13978a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 5; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f13979b;
                    iArrCreate[i6] = i7 ^ (iArr[i3 + i6] & i5);
                    iArrCreate2[i6] = iArrCreate2[i6] ^ (iArr[(i3 + 5) + i6] & i5);
                }
                i3 += 10;
            }
            return a(iArrCreate, iArrCreate2);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            int[] iArrCreate = g.a.g.c.e.create();
            int[] iArrCreate2 = g.a.g.c.e.create();
            int i3 = i2 * 5 * 2;
            for (int i4 = 0; i4 < 5; i4++) {
                int[] iArr = this.f13979b;
                iArrCreate[i4] = iArr[i3 + i4];
                iArrCreate2[i4] = iArr[i3 + 5 + i4];
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    public k() {
        super(f13977i);
        this.k = new n(this, null, null);
        this.f14097b = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70")));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("B4E134D3FB59EB8BAB57274904664D5AF50388BA")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("0100000000000000000000351EE786A818F3A1A16B"));
        this.f14100e = BigInteger.valueOf(1L);
        this.f14101f = 2;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new k();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 5 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.e.copy(((m) iVar.getRawXCoord()).f13991h, 0, iArr, i4);
            int i6 = i4 + 5;
            g.a.g.c.e.copy(((m) iVar.getRawYCoord()).f13991h, 0, iArr, i6);
            i4 = i6 + 5;
        }
        return new a(i3, iArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new n(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new n(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new m(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return f13977i.bitLength();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public BigInteger getQ() {
        return f13977i;
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.e.create();
        l.random(secureRandom, iArrCreate);
        return new m(iArrCreate);
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.e.create();
        l.randomMult(secureRandom, iArrCreate);
        return new m(iArrCreate);
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 2;
    }
}
