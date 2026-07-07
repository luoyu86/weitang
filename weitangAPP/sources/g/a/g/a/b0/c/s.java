package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class s extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f14030i = u.f14045g;
    public static final g.a.g.a.f[] j = {new u(g.a.g.a.d.f14091b)};
    public v k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f14032b;

        public a(int i2, int[] iArr) {
            this.f14031a = i2;
            this.f14032b = iArr;
        }

        public final g.a.g.a.i a(int[] iArr, int[] iArr2) {
            return s.this.f(new u(iArr), new u(iArr2), s.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f14031a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            int[] iArrCreate = g.a.g.c.f.create();
            int[] iArrCreate2 = g.a.g.c.f.create();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f14031a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 6; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f14032b;
                    iArrCreate[i6] = i7 ^ (iArr[i3 + i6] & i5);
                    iArrCreate2[i6] = iArrCreate2[i6] ^ (iArr[(i3 + 6) + i6] & i5);
                }
                i3 += 12;
            }
            return a(iArrCreate, iArrCreate2);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            int[] iArrCreate = g.a.g.c.f.create();
            int[] iArrCreate2 = g.a.g.c.f.create();
            int i3 = i2 * 6 * 2;
            for (int i4 = 0; i4 < 6; i4++) {
                int[] iArr = this.f14032b;
                iArrCreate[i4] = iArr[i3 + i4];
                iArrCreate2[i4] = iArr[i3 + 6 + i4];
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    public s() {
        super(f14030i);
        this.k = new v(this, null, null);
        this.f14097b = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        this.f14100e = BigInteger.valueOf(1L);
        this.f14101f = 2;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new s();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 6 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.f.copy(((u) iVar.getRawXCoord()).f14046h, 0, iArr, i4);
            int i6 = i4 + 6;
            g.a.g.c.f.copy(((u) iVar.getRawYCoord()).f14046h, 0, iArr, i6);
            i4 = i6 + 6;
        }
        return new a(i3, iArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new v(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new v(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new u(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return f14030i.bitLength();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public BigInteger getQ() {
        return f14030i;
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.f.create();
        t.random(secureRandom, iArrCreate);
        return new u(iArrCreate);
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.f.create();
        t.randomMult(secureRandom, iArrCreate);
        return new u(iArrCreate);
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 2;
    }
}
