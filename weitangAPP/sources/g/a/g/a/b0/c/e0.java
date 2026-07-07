package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class e0 extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f13937i = g0.f13953g;
    public static final g.a.g.a.f[] j = {new g0(g.a.g.a.d.f14091b)};
    public h0 k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13939b;

        public a(int i2, int[] iArr) {
            this.f13938a = i2;
            this.f13939b = iArr;
        }

        public final g.a.g.a.i a(int[] iArr, int[] iArr2) {
            return e0.this.f(new g0(iArr), new g0(iArr2), e0.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13938a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            int[] iArrCreate = g.a.g.c.h.create();
            int[] iArrCreate2 = g.a.g.c.h.create();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13938a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 8; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f13939b;
                    iArrCreate[i6] = i7 ^ (iArr[i3 + i6] & i5);
                    iArrCreate2[i6] = iArrCreate2[i6] ^ (iArr[(i3 + 8) + i6] & i5);
                }
                i3 += 16;
            }
            return a(iArrCreate, iArrCreate2);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            int[] iArrCreate = g.a.g.c.h.create();
            int[] iArrCreate2 = g.a.g.c.h.create();
            int i3 = i2 * 8 * 2;
            for (int i4 = 0; i4 < 8; i4++) {
                int[] iArr = this.f13939b;
                iArrCreate[i4] = iArr[i3 + i4];
                iArrCreate2[i4] = iArr[i3 + 8 + i4];
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    public e0() {
        super(f13937i);
        this.k = new h0(this, null, null);
        this.f14097b = fromBigInteger(g.a.g.a.d.f14090a);
        this.f14098c = fromBigInteger(BigInteger.valueOf(7L));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.f14100e = BigInteger.valueOf(1L);
        this.f14101f = 2;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new e0();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 8 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.h.copy(((g0) iVar.getRawXCoord()).f13954h, 0, iArr, i4);
            int i6 = i4 + 8;
            g.a.g.c.h.copy(((g0) iVar.getRawYCoord()).f13954h, 0, iArr, i6);
            i4 = i6 + 8;
        }
        return new a(i3, iArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new h0(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new h0(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new g0(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return f13937i.bitLength();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public BigInteger getQ() {
        return f13937i;
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.h.create();
        f0.random(secureRandom, iArrCreate);
        return new g0(iArrCreate);
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.h.create();
        f0.randomMult(secureRandom, iArrCreate);
        return new g0(iArrCreate);
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 2;
    }
}
