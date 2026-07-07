package g.a.g.a.b0.c;

import com.chinavisionary.microtang.life.vo.SubmitLifeOrderVo;
import g.a.g.a.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class y1 extends e.b {
    public static final g.a.g.a.f[] j = {new v1(g.a.g.a.d.f14091b)};
    public z1 k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f14072b;

        public a(int i2, long[] jArr) {
            this.f14071a = i2;
            this.f14072b = jArr;
        }

        public final g.a.g.a.i a(long[] jArr, long[] jArr2) {
            return y1.this.f(new v1(jArr), new v1(jArr2), y1.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f14071a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            long[] jArrCreate64 = g.a.g.c.h.create64();
            long[] jArrCreate642 = g.a.g.c.h.create64();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f14071a; i4++) {
                long j = ((i4 ^ i2) - 1) >> 31;
                for (int i5 = 0; i5 < 4; i5++) {
                    long j2 = jArrCreate64[i5];
                    long[] jArr = this.f14072b;
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
                long[] jArr = this.f14072b;
                jArrCreate64[i4] = jArr[i3 + i4];
                jArrCreate642[i4] = jArr[i3 + 4 + i4];
            }
            return a(jArrCreate64, jArrCreate642);
        }
    }

    public y1() {
        super(SubmitLifeOrderVo.ITEM_TYPE_INFO, 74, 0, 0);
        this.k = new z1(this, null, null);
        this.f14097b = fromBigInteger(BigInteger.valueOf(1L));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("0066647EDE6C332C7F8C0923BB58213B333B20E9CE4281FE115F7D8F90AD")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("01000000000000000000000000000013E974E72F8A6922031D2603CFE0D7"));
        this.f14100e = BigInteger.valueOf(2L);
        this.f14101f = 6;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new y1();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        long[] jArr = new long[i3 * 4 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.h.copy64(((v1) iVar.getRawXCoord()).f14051g, 0, jArr, i4);
            int i6 = i4 + 4;
            g.a.g.c.h.copy64(((v1) iVar.getRawYCoord()).f14051g, 0, jArr, i6);
            i4 = i6 + 4;
        }
        return new a(i3, jArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new z1(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new z1(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new v1(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return SubmitLifeOrderVo.ITEM_TYPE_INFO;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public int getK1() {
        return 74;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return SubmitLifeOrderVo.ITEM_TYPE_INFO;
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
