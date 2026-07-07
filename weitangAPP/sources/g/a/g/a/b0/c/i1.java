package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class i1 extends e.b {
    public static final g.a.g.a.f[] j = {new h1(g.a.g.a.d.f14091b)};
    public j1 k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f13970b;

        public a(int i2, long[] jArr) {
            this.f13969a = i2;
            this.f13970b = jArr;
        }

        public final g.a.g.a.i a(long[] jArr, long[] jArr2) {
            return i1.this.f(new h1(jArr), new h1(jArr2), i1.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13969a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            long[] jArrCreate64 = g.a.g.c.f.create64();
            long[] jArrCreate642 = g.a.g.c.f.create64();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13969a; i4++) {
                long j = ((i4 ^ i2) - 1) >> 31;
                for (int i5 = 0; i5 < 3; i5++) {
                    long j2 = jArrCreate64[i5];
                    long[] jArr = this.f13970b;
                    jArrCreate64[i5] = j2 ^ (jArr[i3 + i5] & j);
                    jArrCreate642[i5] = jArrCreate642[i5] ^ (jArr[(i3 + 3) + i5] & j);
                }
                i3 += 6;
            }
            return a(jArrCreate64, jArrCreate642);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            long[] jArrCreate64 = g.a.g.c.f.create64();
            long[] jArrCreate642 = g.a.g.c.f.create64();
            int i3 = i2 * 3 * 2;
            for (int i4 = 0; i4 < 3; i4++) {
                long[] jArr = this.f13970b;
                jArrCreate64[i4] = jArr[i3 + i4];
                jArrCreate642[i4] = jArr[i3 + 3 + i4];
            }
            return a(jArrCreate64, jArrCreate642);
        }
    }

    public i1() {
        super(163, 3, 6, 7);
        this.k = new j1(this, null, null);
        g.a.g.a.f fVarFromBigInteger = fromBigInteger(BigInteger.valueOf(1L));
        this.f14097b = fVarFromBigInteger;
        this.f14098c = fVarFromBigInteger;
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("04000000000000000000020108A2E0CC0D99F8A5EF"));
        this.f14100e = BigInteger.valueOf(2L);
        this.f14101f = 6;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new i1();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        long[] jArr = new long[i3 * 3 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.f.copy64(((h1) iVar.getRawXCoord()).f13962g, 0, jArr, i4);
            int i6 = i4 + 3;
            g.a.g.c.f.copy64(((h1) iVar.getRawYCoord()).f13962g, 0, jArr, i6);
            i4 = i6 + 3;
        }
        return new a(i3, jArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.h d() {
        return new g.a.g.a.y();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new j1(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new j1(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new h1(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return 163;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public int getK1() {
        return 3;
    }

    public int getK2() {
        return 6;
    }

    public int getK3() {
        return 7;
    }

    public int getM() {
        return 163;
    }

    @Override // g.a.g.a.e.b
    public boolean isKoblitz() {
        return true;
    }

    public boolean isTrinomial() {
        return false;
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 6;
    }
}
