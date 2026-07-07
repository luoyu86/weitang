package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class y0 extends e.b {
    public static final g.a.g.a.f[] j = {new v0(g.a.g.a.d.f14091b)};
    public z0 k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f14069b;

        public a(int i2, long[] jArr) {
            this.f14068a = i2;
            this.f14069b = jArr;
        }

        public final g.a.g.a.i a(long[] jArr, long[] jArr2) {
            return y0.this.f(new v0(jArr), new v0(jArr2), y0.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f14068a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            long[] jArrCreate64 = g.a.g.c.d.create64();
            long[] jArrCreate642 = g.a.g.c.d.create64();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f14068a; i4++) {
                long j = ((i4 ^ i2) - 1) >> 31;
                for (int i5 = 0; i5 < 2; i5++) {
                    long j2 = jArrCreate64[i5];
                    long[] jArr = this.f14069b;
                    jArrCreate64[i5] = j2 ^ (jArr[i3 + i5] & j);
                    jArrCreate642[i5] = jArrCreate642[i5] ^ (jArr[(i3 + 2) + i5] & j);
                }
                i3 += 4;
            }
            return a(jArrCreate64, jArrCreate642);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            long[] jArrCreate64 = g.a.g.c.d.create64();
            long[] jArrCreate642 = g.a.g.c.d.create64();
            int i3 = i2 * 2 * 2;
            for (int i4 = 0; i4 < 2; i4++) {
                long[] jArr = this.f14069b;
                jArrCreate64[i4] = jArr[i3 + i4];
                jArrCreate642[i4] = jArr[i3 + 2 + i4];
            }
            return a(jArrCreate64, jArrCreate642);
        }
    }

    public y0() {
        super(113, 9, 0, 0);
        this.k = new z0(this, null, null);
        this.f14097b = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("00689918DBEC7E5A0DD6DFC0AA55C7")));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("0095E9A9EC9B297BD4BF36E059184F")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("010000000000000108789B2496AF93"));
        this.f14100e = BigInteger.valueOf(2L);
        this.f14101f = 6;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new y0();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        long[] jArr = new long[i3 * 2 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.d.copy64(((v0) iVar.getRawXCoord()).f14050g, 0, jArr, i4);
            int i6 = i4 + 2;
            g.a.g.c.d.copy64(((v0) iVar.getRawYCoord()).f14050g, 0, jArr, i6);
            i4 = i6 + 2;
        }
        return new a(i3, jArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new z0(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new z0(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new v0(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return 113;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public int getK1() {
        return 9;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 113;
    }

    @Override // g.a.g.a.e.b
    public boolean isKoblitz() {
        return false;
    }

    public boolean isTrinomial() {
        return true;
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 6;
    }
}
