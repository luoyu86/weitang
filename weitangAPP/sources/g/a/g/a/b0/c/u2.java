package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class u2 extends e.b {
    public static final g.a.g.a.f[] j = {new r2(g.a.g.a.d.f14091b)};
    public static final r2 k;
    public static final r2 l;
    public v2 m;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f14048b;

        public a(int i2, long[] jArr) {
            this.f14047a = i2;
            this.f14048b = jArr;
        }

        public final g.a.g.a.i a(long[] jArr, long[] jArr2) {
            return u2.this.f(new r2(jArr), new r2(jArr2), u2.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f14047a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            long[] jArrCreate64 = g.a.g.c.m.create64();
            long[] jArrCreate642 = g.a.g.c.m.create64();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f14047a; i4++) {
                long j = ((i4 ^ i2) - 1) >> 31;
                for (int i5 = 0; i5 < 9; i5++) {
                    long j2 = jArrCreate64[i5];
                    long[] jArr = this.f14048b;
                    jArrCreate64[i5] = j2 ^ (jArr[i3 + i5] & j);
                    jArrCreate642[i5] = jArrCreate642[i5] ^ (jArr[(i3 + 9) + i5] & j);
                }
                i3 += 18;
            }
            return a(jArrCreate64, jArrCreate642);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            long[] jArrCreate64 = g.a.g.c.m.create64();
            long[] jArrCreate642 = g.a.g.c.m.create64();
            int i3 = i2 * 9 * 2;
            for (int i4 = 0; i4 < 9; i4++) {
                long[] jArr = this.f14048b;
                jArrCreate64[i4] = jArr[i3 + i4];
                jArrCreate642[i4] = jArr[i3 + 9 + i4];
            }
            return a(jArrCreate64, jArrCreate642);
        }
    }

    static {
        r2 r2Var = new r2(new BigInteger(1, g.a.j.r.c.decodeStrict("02F40E7E2221F295DE297117B7F3D62F5C6A97FFCB8CEFF1CD6BA8CE4A9A18AD84FFABBD8EFA59332BE7AD6756A66E294AFD185A78FF12AA520E4DE739BACA0C7FFEFF7F2955727A")));
        k = r2Var;
        l = (r2) r2Var.sqrt();
    }

    public u2() {
        super(571, 2, 5, 10);
        this.m = new v2(this, null, null);
        this.f14097b = fromBigInteger(BigInteger.valueOf(1L));
        this.f14098c = k;
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE661CE18FF55987308059B186823851EC7DD9CA1161DE93D5174D66E8382E9BB2FE84E47"));
        this.f14100e = BigInteger.valueOf(2L);
        this.f14101f = 6;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new u2();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        long[] jArr = new long[i3 * 9 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.m.copy64(((r2) iVar.getRawXCoord()).f14029g, 0, jArr, i4);
            int i6 = i4 + 9;
            g.a.g.c.m.copy64(((r2) iVar.getRawYCoord()).f14029g, 0, jArr, i6);
            i4 = i6 + 9;
        }
        return new a(i3, jArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new v2(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new v2(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new r2(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return 571;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.m;
    }

    public int getK1() {
        return 2;
    }

    public int getK2() {
        return 5;
    }

    public int getK3() {
        return 10;
    }

    public int getM() {
        return 571;
    }

    @Override // g.a.g.a.e.b
    public boolean isKoblitz() {
        return false;
    }

    public boolean isTrinomial() {
        return false;
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 6;
    }
}
