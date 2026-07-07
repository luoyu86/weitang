package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class g extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f13949i = i.f13963g;
    public static final g.a.g.a.f[] j = {new i(g.a.g.a.d.f14091b)};
    public j k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13950a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13951b;

        public a(int i2, int[] iArr) {
            this.f13950a = i2;
            this.f13951b = iArr;
        }

        public final g.a.g.a.i a(int[] iArr, int[] iArr2) {
            return g.this.f(new i(iArr), new i(iArr2), g.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13950a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            int[] iArrCreate = g.a.g.c.e.create();
            int[] iArrCreate2 = g.a.g.c.e.create();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13950a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 5; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f13951b;
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
                int[] iArr = this.f13951b;
                iArrCreate[i4] = iArr[i3 + i4];
                iArrCreate2[i4] = iArr[i3 + 5 + i4];
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    public g() {
        super(f13949i);
        this.k = new j(this, null, null);
        this.f14097b = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("0100000000000000000001F4C8F927AED3CA752257"));
        this.f14100e = BigInteger.valueOf(1L);
        this.f14101f = 2;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new g();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 5 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.e.copy(((i) iVar.getRawXCoord()).f13964h, 0, iArr, i4);
            int i6 = i4 + 5;
            g.a.g.c.e.copy(((i) iVar.getRawYCoord()).f13964h, 0, iArr, i6);
            i4 = i6 + 5;
        }
        return new a(i3, iArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new j(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new j(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new i(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return f13949i.bitLength();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public BigInteger getQ() {
        return f13949i;
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.e.create();
        h.random(secureRandom, iArrCreate);
        return new i(iArrCreate);
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.e.create();
        h.randomMult(secureRandom, iArrCreate);
        return new i(iArrCreate);
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 2;
    }
}
