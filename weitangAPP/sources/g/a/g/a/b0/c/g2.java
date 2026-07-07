package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class g2 extends e.b {
    public static final g.a.g.a.f[] j = {new f2(g.a.g.a.d.f14091b)};
    public h2 k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f13957b;

        public a(int i2, long[] jArr) {
            this.f13956a = i2;
            this.f13957b = jArr;
        }

        public final g.a.g.a.i a(long[] jArr, long[] jArr2) {
            return g2.this.f(new f2(jArr), new f2(jArr2), g2.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13956a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            long[] jArrCreate64 = g.a.g.c.i.create64();
            long[] jArrCreate642 = g.a.g.c.i.create64();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13956a; i4++) {
                long j = ((i4 ^ i2) - 1) >> 31;
                for (int i5 = 0; i5 < 5; i5++) {
                    long j2 = jArrCreate64[i5];
                    long[] jArr = this.f13957b;
                    jArrCreate64[i5] = j2 ^ (jArr[i3 + i5] & j);
                    jArrCreate642[i5] = jArrCreate642[i5] ^ (jArr[(i3 + 5) + i5] & j);
                }
                i3 += 10;
            }
            return a(jArrCreate64, jArrCreate642);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            long[] jArrCreate64 = g.a.g.c.i.create64();
            long[] jArrCreate642 = g.a.g.c.i.create64();
            int i3 = i2 * 5 * 2;
            for (int i4 = 0; i4 < 5; i4++) {
                long[] jArr = this.f13957b;
                jArrCreate64[i4] = jArr[i3 + i4];
                jArrCreate642[i4] = jArr[i3 + 5 + i4];
            }
            return a(jArrCreate64, jArrCreate642);
        }
    }

    public g2() {
        super(283, 5, 7, 12);
        this.k = new h2(this, null, null);
        this.f14097b = fromBigInteger(BigInteger.valueOf(0L));
        this.f14098c = fromBigInteger(BigInteger.valueOf(1L));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE9AE2ED07577265DFF7F94451E061E163C61"));
        this.f14100e = BigInteger.valueOf(4L);
        this.f14101f = 6;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new g2();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        long[] jArr = new long[i3 * 5 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.i.copy64(((f2) iVar.getRawXCoord()).f13948g, 0, jArr, i4);
            int i6 = i4 + 5;
            g.a.g.c.i.copy64(((f2) iVar.getRawYCoord()).f13948g, 0, jArr, i6);
            i4 = i6 + 5;
        }
        return new a(i3, jArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.h d() {
        return new g.a.g.a.y();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new h2(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new h2(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new f2(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return 283;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public int getK1() {
        return 5;
    }

    public int getK2() {
        return 7;
    }

    public int getK3() {
        return 12;
    }

    public int getM() {
        return 283;
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
