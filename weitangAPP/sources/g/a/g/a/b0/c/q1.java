package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class q1 extends e.b {
    public static final g.a.g.a.f[] j = {new p1(g.a.g.a.d.f14091b)};
    public r1 k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f14025b;

        public a(int i2, long[] jArr) {
            this.f14024a = i2;
            this.f14025b = jArr;
        }

        public final g.a.g.a.i a(long[] jArr, long[] jArr2) {
            return q1.this.f(new p1(jArr), new p1(jArr2), q1.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f14024a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            long[] jArrCreate64 = g.a.g.c.h.create64();
            long[] jArrCreate642 = g.a.g.c.h.create64();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f14024a; i4++) {
                long j = ((i4 ^ i2) - 1) >> 31;
                for (int i5 = 0; i5 < 4; i5++) {
                    long j2 = jArrCreate64[i5];
                    long[] jArr = this.f14025b;
                    jArrCreate64[i5] = j2 ^ (jArr[i3 + i5] & j);
                    jArrCreate642[i5] = jArrCreate642[i5] ^ (jArr[(i3 + 4) + i5] & j);
                }
                i3 += 8;
            }
            return a(jArrCreate64, jArrCreate642);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            long[] jArrCreate64 = g.a.g.c.h.create64();
            long[] jArrCreate642 = g.a.g.c.h.create64();
            int i3 = i2 * 4 * 2;
            for (int i4 = 0; i4 < 4; i4++) {
                long[] jArr = this.f14025b;
                jArrCreate64[i4] = jArr[i3 + i4];
                jArrCreate642[i4] = jArr[i3 + 4 + i4];
            }
            return a(jArrCreate64, jArrCreate642);
        }
    }

    public q1() {
        super(193, 15, 0, 0);
        this.k = new r1(this, null, null);
        this.f14097b = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01")));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("01000000000000000000000000C7F34A778F443ACC920EBA49"));
        this.f14100e = BigInteger.valueOf(2L);
        this.f14101f = 6;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new q1();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        long[] jArr = new long[i3 * 4 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.h.copy64(((p1) iVar.getRawXCoord()).f14017g, 0, jArr, i4);
            int i6 = i4 + 4;
            g.a.g.c.h.copy64(((p1) iVar.getRawYCoord()).f14017g, 0, jArr, i6);
            i4 = i6 + 4;
        }
        return new a(i3, jArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new r1(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new r1(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new p1(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return 193;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public int getK1() {
        return 15;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 193;
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
