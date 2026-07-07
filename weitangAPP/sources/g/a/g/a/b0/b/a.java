package g.a.g.a.b0.b;

import g.a.g.a.e;
import g.a.g.a.f;
import g.a.g.a.g;
import g.a.g.a.i;
import g.a.g.c.h;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class a extends e.c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final BigInteger f13898i = c.f13904g;
    public static final f[] j = {new c(g.a.g.a.d.f14091b)};
    public d k;

    /* JADX INFO: renamed from: g.a.g.a.b0.b.a$a, reason: collision with other inner class name */
    public class C0259a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f13899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f13900b;

        public C0259a(int i2, int[] iArr) {
            this.f13899a = i2;
            this.f13900b = iArr;
        }

        public final i a(int[] iArr, int[] iArr2) {
            return a.this.f(new c(iArr), new c(iArr2), a.j);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f13899a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public i lookup(int i2) {
            int[] iArrCreate = h.create();
            int[] iArrCreate2 = h.create();
            int i3 = 0;
            for (int i4 = 0; i4 < this.f13899a; i4++) {
                int i5 = ((i4 ^ i2) - 1) >> 31;
                for (int i6 = 0; i6 < 8; i6++) {
                    int i7 = iArrCreate[i6];
                    int[] iArr = this.f13900b;
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
                int[] iArr = this.f13900b;
                iArrCreate[i4] = iArr[i3 + i4];
                iArrCreate2[i4] = iArr[i3 + 8 + i4];
            }
            return a(iArrCreate, iArrCreate2);
        }
    }

    public a() {
        super(f13898i);
        this.k = new d(this, null, null);
        this.f14097b = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.f14098c = fromBigInteger(new BigInteger(1, g.a.j.r.c.decodeStrict("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.f14099d = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.f14100e = BigInteger.valueOf(1L);
        this.f14101f = 2;
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
            h.copy(((c) iVar.getRawXCoord()).f13905h, 0, iArr, i4);
            int i6 = i4 + 8;
            h.copy(((c) iVar.getRawYCoord()).f13905h, 0, iArr, i6);
            i4 = i6 + 8;
        }
        return new C0259a(i3, iArr);
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
        return f13898i.bitLength();
    }

    @Override // g.a.g.a.e
    public i getInfinity() {
        return this.k;
    }

    public BigInteger getQ() {
        return f13898i;
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
        return i2 == 2;
    }
}
