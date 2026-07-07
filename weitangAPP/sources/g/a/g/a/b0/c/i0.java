package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class i0 extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f13965i = k0.f13981g;
    public static final g.a.g.a.f[] j = {new k0(g.a.g.a.d.f14091b)};
    public l0 k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13967b;

        public a(int i2, int[] iArr) {
            this.f13966a = i2;
            this.f13967b = iArr;
        }

        public final g.a.g.a.i a(int[] iArr, int[] iArr2) {
            return i0.this.f(new k0(iArr), new k0(iArr2), i0.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13966a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            int[] iArrCreate = g.a.g.c.h.create();
            int[] iArrCreate2 = g.a.g.c.h.create();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13966a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 8; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f13967b;
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
                int[] iArr = this.f13967b;
                iArrCreate[i4] = iArr[i3 + i4];
                iArrCreate2[i4] = iArr[i3 + 8 + i4];
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    public i0() {
        super(f13965i);
        this.k = new l0(this, null, null);
        this.f14097b = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551"));
        this.f14100e = BigInteger.valueOf(1L);
        this.f14101f = 2;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new i0();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 8 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.h.copy(((k0) iVar.getRawXCoord()).f13982h, 0, iArr, i4);
            int i6 = i4 + 8;
            g.a.g.c.h.copy(((k0) iVar.getRawYCoord()).f13982h, 0, iArr, i6);
            i4 = i6 + 8;
        }
        return new a(i3, iArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new l0(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new l0(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new k0(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return f13965i.bitLength();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public BigInteger getQ() {
        return f13965i;
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.h.create();
        j0.random(secureRandom, iArrCreate);
        return new k0(iArrCreate);
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.h.create();
        j0.randomMult(secureRandom, iArrCreate);
        return new k0(iArrCreate);
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 2;
    }
}
