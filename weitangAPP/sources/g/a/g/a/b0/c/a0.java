package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class a0 extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f13910i = c0.f13925g;
    public static final g.a.g.a.f[] j = {new c0(g.a.g.a.d.f14091b)};
    public d0 k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13912b;

        public a(int i2, int[] iArr) {
            this.f13911a = i2;
            this.f13912b = iArr;
        }

        public final g.a.g.a.i a(int[] iArr, int[] iArr2) {
            return a0.this.f(new c0(iArr), new c0(iArr2), a0.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13911a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            int[] iArrCreate = g.a.g.c.g.create();
            int[] iArrCreate2 = g.a.g.c.g.create();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13911a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 7; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f13912b;
                    iArrCreate[i6] = i7 ^ (iArr[i3 + i6] & i5);
                    iArrCreate2[i6] = iArrCreate2[i6] ^ (iArr[(i3 + 7) + i6] & i5);
                }
                i3 += 14;
            }
            return a(iArrCreate, iArrCreate2);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            int[] iArrCreate = g.a.g.c.g.create();
            int[] iArrCreate2 = g.a.g.c.g.create();
            int i3 = i2 * 7 * 2;
            for (int i4 = 0; i4 < 7; i4++) {
                int[] iArr = this.f13912b;
                iArrCreate[i4] = iArr[i3 + i4];
                iArrCreate2[i4] = iArr[i3 + 7 + i4];
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    public a0() {
        super(f13910i);
        this.k = new d0(this, null, null);
        this.f14097b = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.f14100e = BigInteger.valueOf(1L);
        this.f14101f = 2;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new a0();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 7 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.g.copy(((c0) iVar.getRawXCoord()).f13926h, 0, iArr, i4);
            int i6 = i4 + 7;
            g.a.g.c.g.copy(((c0) iVar.getRawYCoord()).f13926h, 0, iArr, i6);
            i4 = i6 + 7;
        }
        return new a(i3, iArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new d0(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new d0(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new c0(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return f13910i.bitLength();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public BigInteger getQ() {
        return f13910i;
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.g.create();
        b0.random(secureRandom, iArrCreate);
        return new c0(iArrCreate);
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.g.create();
        b0.randomMult(secureRandom, iArrCreate);
        return new c0(iArrCreate);
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 2;
    }
}
