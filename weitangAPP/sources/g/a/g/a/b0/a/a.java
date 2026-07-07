package g.a.g.a.b0.a;

import g.a.g.a.e;
import g.a.g.a.f;
import g.a.g.a.g;
import g.a.g.a.i;
import g.a.g.c.h;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes2.dex */
public class a extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f13889i = c.f13895g;
    public static final BigInteger j;
    public static final BigInteger k;
    public static final f[] l;
    public d m;

    /* JADX INFO: renamed from: g.a.g.a.b0.a.a$a, reason: collision with other inner class name */
    public class C0258a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13890a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13891b;

        public C0258a(int i2, int[] iArr) {
            this.f13890a = i2;
            this.f13891b = iArr;
        }

        public final i a(int[] iArr, int[] iArr2) {
            return a.this.f(new c(iArr), new c(iArr2), a.l);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13890a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public i lookup(int i2) {
            int[] iArrCreate = h.create();
            int[] iArrCreate2 = h.create();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13890a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 8; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f13891b;
                    iArrCreate[i6] = i7 ^ (iArr[i3 + i6] & i5);
                    iArrCreate2[i6] = iArrCreate2[i6] ^ (iArr[(i3 + 8) + i6] & i5);
                }
                i3 += 16;
            }
            return a(iArrCreate, iArrCreate2);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public i lookupVar(int i2) {
            int[] iArrCreate = h.create();
            int[] iArrCreate2 = h.create();
            int i3 = i2 * 8 * 2;
            for (int i4 = 0; i4 < 8; i4++) {
                int[] iArr = this.f13891b;
                iArrCreate[i4] = iArr[i3 + i4];
                iArrCreate2[i4] = iArr[i3 + 8 + i4];
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    static {
        BigInteger bigInteger = new BigInteger(1, g.a.j.r.c.decodeStrict("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144"));
        j = bigInteger;
        k = new BigInteger(1, g.a.j.r.c.decodeStrict("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864"));
        l = new f[]{new c(g.a.g.a.d.f14091b), new c(bigInteger)};
    }

    public a() {
        super(f13889i);
        this.m = new d(this, null, null);
        this.f14097b = fromBigInteger(j);
        this.f14098c = fromBigInteger(k);
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.f14100e = BigInteger.valueOf(8L);
        this.f14101f = 4;
    }

    @Override // g.a.g.a.e
    public e c() {
        return new a();
    }

    @Override // g.a.g.a.e
    public g createCacheSafeLookupTable(i[] iVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 8 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i iVar = iVarArr[i2 + i5];
            h.copy(((c) iVar.getRawXCoord()).f13897i, 0, iArr, i4);
            int i6 = i4 + 8;
            h.copy(((c) iVar.getRawYCoord()).f13897i, 0, iArr, i6);
            i4 = i6 + 8;
        }
        return new C0258a(i3, iArr);
    }

    @Override // g.a.g.a.e
    public i e(f fVar, f fVar2) {
        return new d(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public i f(f fVar, f fVar2, f[] fVarArr) {
        return new d(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public f fromBigInteger(BigInteger bigInteger) {
        return new c(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return f13889i.bitLength();
    }

    @Override // g.a.g.a.e
    public i getInfinity() {
        return this.m;
    }

    public BigInteger getQ() {
        return f13889i;
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public f randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = h.create();
        b.random(secureRandom, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public f randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = h.create();
        b.randomMult(secureRandom, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 4;
    }
}
