package g.a.g.a.b0.c;

import g.a.g.a.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class a extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f13906i = c.f13923g;
    public static final g.a.g.a.f[] j = {new c(g.a.g.a.d.f14091b)};
    public d k;

    /* JADX INFO: renamed from: g.a.g.a.b0.c.a$a, reason: collision with other inner class name */
    public class C0260a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13908b;

        public C0260a(int i2, int[] iArr) {
            this.f13907a = i2;
            this.f13908b = iArr;
        }

        public final g.a.g.a.i a(int[] iArr, int[] iArr2) {
            return a.this.f(new c(iArr), new c(iArr2), a.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13907a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookup(int i2) {
            int[] iArrCreate = g.a.g.c.d.create();
            int[] iArrCreate2 = g.a.g.c.d.create();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13907a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 4; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f13908b;
                    iArrCreate[i6] = i7 ^ (iArr[i3 + i6] & i5);
                    iArrCreate2[i6] = iArrCreate2[i6] ^ (iArr[(i3 + 4) + i6] & i5);
                }
                i3 += 8;
            }
            return a(iArrCreate, iArrCreate2);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public g.a.g.a.i lookupVar(int i2) {
            int[] iArrCreate = g.a.g.c.d.create();
            int[] iArrCreate2 = g.a.g.c.d.create();
            int i3 = i2 * 4 * 2;
            for (int i4 = 0; i4 < 4; i4++) {
                int[] iArr = this.f13908b;
                iArrCreate[i4] = iArr[i3 + i4];
                iArrCreate2[i4] = iArr[i3 + 4 + i4];
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    public a() {
        super(f13906i);
        this.k = new d(this, null, null);
        this.f14097b = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("E87579C11079F43DD824993C2CEE5ED3")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFE0000000075A30D1B9038A115"));
        this.f14100e = BigInteger.valueOf(1L);
        this.f14101f = 2;
    }

    @Override // g.a.g.a.e
    public g.a.g.a.e c() {
        return new a();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.g createCacheSafeLookupTable(g.a.g.a.i[] iVarArr, int i2, int i3) {
        int[] iArr = new int[i3 * 4 * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            g.a.g.a.i iVar = iVarArr[i2 + i5];
            g.a.g.c.d.copy(((c) iVar.getRawXCoord()).f13924h, 0, iArr, i4);
            int i6 = i4 + 4;
            g.a.g.c.d.copy(((c) iVar.getRawYCoord()).f13924h, 0, iArr, i6);
            i4 = i6 + 4;
        }
        return new C0260a(i3, iArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return new d(this, fVar, fVar2);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        return new d(this, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.e
    public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
        return new c(bigInteger);
    }

    @Override // g.a.g.a.e
    public int getFieldSize() {
        return f13906i.bitLength();
    }

    @Override // g.a.g.a.e
    public g.a.g.a.i getInfinity() {
        return this.k;
    }

    public BigInteger getQ() {
        return f13906i;
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.d.create();
        b.random(secureRandom, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.e.c, g.a.g.a.e
    public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrCreate = g.a.g.c.d.create();
        b.randomMult(secureRandom, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.e
    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 2;
    }
}
