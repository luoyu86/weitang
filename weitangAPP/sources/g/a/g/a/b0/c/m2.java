package g.a.g.a.b0.c;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import g.a.g.a.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class m2 extends e.b {
    public static final g.a.g.a.f[] j = {new l2(g.a.g.a.d.f14091b)};
    public n2 k;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f14000b;

        public a(int i2, long[] jArr) {
            this.f13999a = i2;
            this.f14000b = jArr;
        }

        public final g.a.g.a.i a(long[] jArr, long[] jArr2) {
            return m2.this.f(new l2(jArr), new l2(jArr2), m2.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13999a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            long[] jArrCreate64 = g.a.g.c.k.create64();
            long[] jArrCreate642 = g.a.g.c.k.create64();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13999a; i4++) {
                long j = ((i4 ^ i2) - 1) >> 31;
                for (int i5 = 0; i5 < 7; i5++) {
                    long j2 = jArrCreate64[i5];
                    long[] jArr = this.f14000b;
                    jArrCreate64[i5] = j2 ^ (jArr[i3 + i5] & j);
                    jArrCreate642[i5] = jArrCreate642[i5] ^ (jArr[(i3 + 7) + i5] & j);
                }
                i3 += 14;
            }
            return a(jArrCreate64, jArrCreate642);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            long[] jArrCreate64 = g.a.g.c.k.create64();
            long[] jArrCreate642 = g.a.g.c.k.create64();
            int i3 = i2 * 7 * 2;
            for (int i4 = 0; i4 < 7; i4++) {
                long[] jArr = this.f14000b;
                jArrCreate64[i4] = jArr[i3 + i4];
                jArrCreate642[i4] = jArr[i3 + 7 + i4];
            }
            return a(jArrCreate64, jArrCreate642);
        }
    }

    public m2() {
        super(TTAdConstant.IMAGE_LIST_CODE, 87, 0, 0);
        this.k = new n2(this, null, null);
        this.f14097b = fromBigInteger(BigInteger.valueOf(0L));
        this.f14098c = fromBigInteger(BigInteger.valueOf(1L));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
        this.f14100e = BigInteger.valueOf(4L);
        this.f14101f = 6;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new m2();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        long[] jArr = new long[i3 * 7 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.k.copy64(((l2) iVar.getRawXCoord()).f13989g, 0, jArr, i4);
            int i6 = i4 + 7;
            g.a.g.c.k.copy64(((l2) iVar.getRawYCoord()).f13989g, 0, jArr, i6);
            i4 = i6 + 7;
        }
        return new a(i3, jArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.h d() {
        return new g.a.g.a.y();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new n2(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new n2(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new l2(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return TTAdConstant.IMAGE_LIST_CODE;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public int getK1() {
        return 87;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return TTAdConstant.IMAGE_LIST_CODE;
    }

    @Override // g.a.g.a.e.b
    public boolean isKoblitz() {
        return true;
    }

    public boolean isTrinomial() {
        return true;
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 6;
    }
}
