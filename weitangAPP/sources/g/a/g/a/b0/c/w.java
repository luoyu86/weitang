package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class w extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f14052i = y.f14065g;
    public static final g.a.g.a.f[] j = {new y(g.a.g.a.d.f14091b)};
    public z k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14053a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f14054b;

        public a(int i2, int[] iArr) {
            this.f14053a = i2;
            this.f14054b = iArr;
        }

        public final g.a.g.a.i a(int[] iArr, int[] iArr2) {
            return w.this.f(new y(iArr), new y(iArr2), w.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f14053a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            int[] iArrCreate = g.a.g.c.g.create();
            int[] iArrCreate2 = g.a.g.c.g.create();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f14053a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 7; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f14054b;
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
            int i3 = 0;
            for (int i4 = 0; i4 < this.f14053a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 7; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f14054b;
                    iArrCreate[i6] = i7 ^ (iArr[i3 + i6] & i5);
                    iArrCreate2[i6] = iArrCreate2[i6] ^ (iArr[(i3 + 7) + i6] & i5);
                }
                i3 += 14;
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    public w() {
        super(f14052i);
        this.k = new z(this, null, null);
        this.f14097b = fromBigInteger(g.a.g.a.d.f14090a);
        this.f14098c = fromBigInteger(BigInteger.valueOf(5L));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7"));
        this.f14100e = BigInteger.valueOf(1L);
        this.f14101f = 2;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new w();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 7 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.g.copy(((y) iVar.getRawXCoord()).f14067i, 0, iArr, i4);
            int i6 = i4 + 7;
            g.a.g.c.g.copy(((y) iVar.getRawYCoord()).f14067i, 0, iArr, i6);
            i4 = i6 + 7;
        }
        return new a(i3, iArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new z(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new z(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new y(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return f14052i.bitLength();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public BigInteger getQ() {
        return f14052i;
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.g.create();
        x.random(secureRandom, iArrCreate);
        return new y(iArrCreate);
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.g.create();
        x.randomMult(secureRandom, iArrCreate);
        return new y(iArrCreate);
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 2;
    }
}
