package g.a.g.a;

import g.a.g.a.f;
import g.a.g.a.i;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.g.b.a f14096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.g.a.f f14097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.g.a.f f14098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f14099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f14100e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14101f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g.a.g.a.c0.a f14102g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h f14103h = null;

    public class a extends g.a.g.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f14105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ byte[] f14106c;

        public a(int i2, int i3, byte[] bArr) {
            this.f14104a = i2;
            this.f14105b = i3;
            this.f14106c = bArr;
        }

        public final i a(byte[] bArr, byte[] bArr2) {
            e eVar = e.this;
            return eVar.e(eVar.fromBigInteger(new BigInteger(1, bArr)), e.this.fromBigInteger(new BigInteger(1, bArr2)));
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public int getSize() {
            return this.f14104a;
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public i lookup(int i2) {
            int i3;
            int i4 = this.f14105b;
            byte[] bArr = new byte[i4];
            byte[] bArr2 = new byte[i4];
            int i5 = 0;
            for (int i6 = 0; i6 < this.f14104a; i6++) {
                int i7 = ((i6 ^ i2) - 1) >> 31;
                int i8 = 0;
                while (true) {
                    i3 = this.f14105b;
                    if (i8 < i3) {
                        byte b2 = bArr[i8];
                        byte[] bArr3 = this.f14106c;
                        bArr[i8] = (byte) (b2 ^ (bArr3[i5 + i8] & i7));
                        bArr2[i8] = (byte) ((bArr3[(i3 + i5) + i8] & i7) ^ bArr2[i8]);
                        i8++;
                    }
                }
                i5 += i3 * 2;
            }
            return a(bArr, bArr2);
        }

        @Override // g.a.g.a.a, g.a.g.a.g
        public i lookupVar(int i2) {
            int i3 = this.f14105b;
            byte[] bArr = new byte[i3];
            byte[] bArr2 = new byte[i3];
            int i4 = i2 * i3 * 2;
            int i5 = 0;
            while (true) {
                int i6 = this.f14105b;
                if (i5 >= i6) {
                    return a(bArr, bArr2);
                }
                byte[] bArr3 = this.f14106c;
                bArr[i5] = bArr3[i4 + i5];
                bArr2[i5] = bArr3[i6 + i4 + i5];
                i5++;
            }
        }
    }

    public static abstract class b extends e {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public BigInteger[] f14108i;

        public b(int i2, int i3, int i4, int i5) {
            super(h(i2, i3, i4, i5));
            this.f14108i = null;
        }

        public static g.a.g.b.a h(int i2, int i3, int i4, int i5) {
            if (i3 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            }
            if (i4 == 0) {
                if (i5 == 0) {
                    return g.a.g.b.b.getBinaryExtensionField(new int[]{0, i3, i2});
                }
                throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
            }
            if (i4 <= i3) {
                throw new IllegalArgumentException("k2 must be > k1");
            }
            if (i5 > i4) {
                return g.a.g.b.b.getBinaryExtensionField(new int[]{0, i3, i4, i5, i2});
            }
            throw new IllegalArgumentException("k3 must be > k2");
        }

        public static BigInteger inverse(int i2, int[] iArr, BigInteger bigInteger) {
            return new o(bigInteger).modInverse(i2, iArr).toBigInteger();
        }

        public static BigInteger j(SecureRandom secureRandom, int i2) {
            BigInteger bigIntegerCreateRandomBigInteger;
            do {
                bigIntegerCreateRandomBigInteger = g.a.j.b.createRandomBigInteger(i2, secureRandom);
            } while (bigIntegerCreateRandomBigInteger.signum() <= 0);
            return bigIntegerCreateRandomBigInteger;
        }

        @Override // g.a.g.a.e
        public i createPoint(BigInteger bigInteger, BigInteger bigInteger2) {
            g.a.g.a.f fVarFromBigInteger = fromBigInteger(bigInteger);
            g.a.g.a.f fVarFromBigInteger2 = fromBigInteger(bigInteger2);
            int coordinateSystem = getCoordinateSystem();
            if (coordinateSystem == 5 || coordinateSystem == 6) {
                if (!fVarFromBigInteger.isZero()) {
                    fVarFromBigInteger2 = fVarFromBigInteger2.divide(fVarFromBigInteger).add(fVarFromBigInteger);
                } else if (!fVarFromBigInteger2.square().equals(getB())) {
                    throw new IllegalArgumentException();
                }
            }
            return e(fVarFromBigInteger, fVarFromBigInteger2);
        }

        @Override // g.a.g.a.e
        public i g(int i2, BigInteger bigInteger) {
            g.a.g.a.f fVarAdd;
            g.a.g.a.f fVarFromBigInteger = fromBigInteger(bigInteger);
            if (fVarFromBigInteger.isZero()) {
                fVarAdd = getB().sqrt();
            } else {
                g.a.g.a.f fVarK = k(fVarFromBigInteger.square().invert().multiply(getB()).add(getA()).add(fVarFromBigInteger));
                if (fVarK != null) {
                    if (fVarK.testBitZero() != (i2 == 1)) {
                        fVarK = fVarK.addOne();
                    }
                    int coordinateSystem = getCoordinateSystem();
                    fVarAdd = (coordinateSystem == 5 || coordinateSystem == 6) ? fVarK.add(fVarFromBigInteger) : fVarK.multiply(fVarFromBigInteger);
                } else {
                    fVarAdd = null;
                }
            }
            if (fVarAdd != null) {
                return e(fVarFromBigInteger, fVarAdd);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        public synchronized BigInteger[] i() {
            if (this.f14108i == null) {
                this.f14108i = t.getSi(this);
            }
            return this.f14108i;
        }

        public boolean isKoblitz() {
            return this.f14099d != null && this.f14100e != null && this.f14098c.isOne() && (this.f14097b.isZero() || this.f14097b.isOne());
        }

        @Override // g.a.g.a.e
        public boolean isValidFieldElement(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= getFieldSize();
        }

        public g.a.g.a.f k(g.a.g.a.f fVar) {
            g.a.g.a.f fVarAdd;
            f.a aVar = (f.a) fVar;
            boolean zHasFastTrace = aVar.hasFastTrace();
            if (zHasFastTrace && aVar.trace() != 0) {
                return null;
            }
            int fieldSize = getFieldSize();
            if ((fieldSize & 1) != 0) {
                g.a.g.a.f fVarHalfTrace = aVar.halfTrace();
                if (zHasFastTrace || fVarHalfTrace.square().add(fVarHalfTrace).add(fVar).isZero()) {
                    return fVarHalfTrace;
                }
                return null;
            }
            if (fVar.isZero()) {
                return fVar;
            }
            g.a.g.a.f fVarFromBigInteger = fromBigInteger(g.a.g.a.d.f14090a);
            Random random = new Random();
            do {
                g.a.g.a.f fVarFromBigInteger2 = fromBigInteger(new BigInteger(fieldSize, random));
                g.a.g.a.f fVarAdd2 = fVar;
                fVarAdd = fVarFromBigInteger;
                for (int i2 = 1; i2 < fieldSize; i2++) {
                    g.a.g.a.f fVarSquare = fVarAdd2.square();
                    fVarAdd = fVarAdd.square().add(fVarSquare.multiply(fVarFromBigInteger2));
                    fVarAdd2 = fVarSquare.add(fVar);
                }
                if (!fVarAdd2.isZero()) {
                    return null;
                }
            } while (fVarAdd.square().add(fVarAdd).isZero());
            return fVarAdd;
        }

        @Override // g.a.g.a.e
        public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
            return fromBigInteger(g.a.j.b.createRandomBigInteger(getFieldSize(), secureRandom));
        }

        @Override // g.a.g.a.e
        public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
            int fieldSize = getFieldSize();
            return fromBigInteger(j(secureRandom, fieldSize)).multiply(fromBigInteger(j(secureRandom, fieldSize)));
        }
    }

    public static abstract class c extends e {
        public c(BigInteger bigInteger) {
            super(g.a.g.b.b.getPrimeField(bigInteger));
        }

        public static BigInteger h(SecureRandom secureRandom, BigInteger bigInteger) {
            BigInteger bigIntegerCreateRandomBigInteger;
            do {
                bigIntegerCreateRandomBigInteger = g.a.j.b.createRandomBigInteger(bigInteger.bitLength(), secureRandom);
            } while (bigIntegerCreateRandomBigInteger.compareTo(bigInteger) >= 0);
            return bigIntegerCreateRandomBigInteger;
        }

        public static BigInteger i(SecureRandom secureRandom, BigInteger bigInteger) {
            while (true) {
                BigInteger bigIntegerCreateRandomBigInteger = g.a.j.b.createRandomBigInteger(bigInteger.bitLength(), secureRandom);
                if (bigIntegerCreateRandomBigInteger.signum() > 0 && bigIntegerCreateRandomBigInteger.compareTo(bigInteger) < 0) {
                    return bigIntegerCreateRandomBigInteger;
                }
            }
        }

        @Override // g.a.g.a.e
        public i g(int i2, BigInteger bigInteger) {
            g.a.g.a.f fVarFromBigInteger = fromBigInteger(bigInteger);
            g.a.g.a.f fVarSqrt = fVarFromBigInteger.square().add(this.f14097b).multiply(fVarFromBigInteger).add(this.f14098c).sqrt();
            if (fVarSqrt == null) {
                throw new IllegalArgumentException("Invalid point compression");
            }
            if (fVarSqrt.testBitZero() != (i2 == 1)) {
                fVarSqrt = fVarSqrt.negate();
            }
            return e(fVarFromBigInteger, fVarSqrt);
        }

        @Override // g.a.g.a.e
        public boolean isValidFieldElement(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(getField().getCharacteristic()) < 0;
        }

        @Override // g.a.g.a.e
        public g.a.g.a.f randomFieldElement(SecureRandom secureRandom) {
            BigInteger characteristic = getField().getCharacteristic();
            return fromBigInteger(h(secureRandom, characteristic)).multiply(fromBigInteger(h(secureRandom, characteristic)));
        }

        @Override // g.a.g.a.e
        public g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom) {
            BigInteger characteristic = getField().getCharacteristic();
            return fromBigInteger(i(secureRandom, characteristic)).multiply(fromBigInteger(i(secureRandom, characteristic)));
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g.a.g.a.c0.a f14110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f14111c;

        public d(int i2, g.a.g.a.c0.a aVar, h hVar) {
            this.f14109a = i2;
            this.f14110b = aVar;
            this.f14111c = hVar;
        }

        public e create() {
            if (!e.this.supportsCoordinateSystem(this.f14109a)) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            e eVarC = e.this.c();
            if (eVarC == e.this) {
                throw new IllegalStateException("implementation returned current curve");
            }
            synchronized (eVarC) {
                eVarC.f14101f = this.f14109a;
                eVarC.f14102g = this.f14110b;
                eVarC.f14103h = this.f14111c;
            }
            return eVarC;
        }

        public d setCoordinateSystem(int i2) {
            this.f14109a = i2;
            return this;
        }

        public d setEndomorphism(g.a.g.a.c0.a aVar) {
            this.f14110b = aVar;
            return this;
        }

        public d setMultiplier(h hVar) {
            this.f14111c = hVar;
            return this;
        }
    }

    /* JADX INFO: renamed from: g.a.g.a.e$e, reason: collision with other inner class name */
    public static class C0261e extends b {
        public int j;
        public int k;
        public int l;
        public int m;
        public i.d n;

        /* JADX INFO: renamed from: g.a.g.a.e$e$a */
        public class a extends g.a.g.a.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f14113a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f14114b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long[] f14115c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int[] f14116d;

            public a(int i2, int i3, long[] jArr, int[] iArr) {
                this.f14113a = i2;
                this.f14114b = i3;
                this.f14115c = jArr;
                this.f14116d = iArr;
            }

            public final i a(long[] jArr, long[] jArr2) {
                return C0261e.this.e(new f.c(C0261e.this.j, this.f14116d, new o(jArr)), new f.c(C0261e.this.j, this.f14116d, new o(jArr2)));
            }

            @Override // g.a.g.a.a, g.a.g.a.g
            public int getSize() {
                return this.f14113a;
            }

            @Override // g.a.g.a.a, g.a.g.a.g
            public i lookup(int i2) {
                int i3;
                long[] jArrCreate64 = g.a.g.c.n.create64(this.f14114b);
                long[] jArrCreate642 = g.a.g.c.n.create64(this.f14114b);
                int i4 = 0;
                for (int i5 = 0; i5 < this.f14113a; i5++) {
                    long j = ((i5 ^ i2) - 1) >> 31;
                    int i6 = 0;
                    while (true) {
                        i3 = this.f14114b;
                        if (i6 < i3) {
                            long j2 = jArrCreate64[i6];
                            long[] jArr = this.f14115c;
                            jArrCreate64[i6] = j2 ^ (jArr[i4 + i6] & j);
                            jArrCreate642[i6] = jArrCreate642[i6] ^ (jArr[(i3 + i4) + i6] & j);
                            i6++;
                        }
                    }
                    i4 += i3 * 2;
                }
                return a(jArrCreate64, jArrCreate642);
            }

            @Override // g.a.g.a.a, g.a.g.a.g
            public i lookupVar(int i2) {
                long[] jArrCreate64 = g.a.g.c.n.create64(this.f14114b);
                long[] jArrCreate642 = g.a.g.c.n.create64(this.f14114b);
                int i3 = i2 * this.f14114b * 2;
                int i4 = 0;
                while (true) {
                    int i5 = this.f14114b;
                    if (i4 >= i5) {
                        return a(jArrCreate64, jArrCreate642);
                    }
                    long[] jArr = this.f14115c;
                    jArrCreate64[i4] = jArr[i3 + i4];
                    jArrCreate642[i4] = jArr[i5 + i3 + i4];
                    i4++;
                }
            }
        }

        public C0261e(int i2, int i3, int i4, int i5, g.a.g.a.f fVar, g.a.g.a.f fVar2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i2, i3, i4, i5);
            this.j = i2;
            this.k = i3;
            this.l = i4;
            this.m = i5;
            this.f14099d = bigInteger;
            this.f14100e = bigInteger2;
            this.n = new i.d(this, null, null);
            this.f14097b = fVar;
            this.f14098c = fVar2;
            this.f14101f = 6;
        }

        public C0261e(int i2, int i3, int i4, int i5, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i2, i3, i4, i5, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public C0261e(int i2, int i3, int i4, int i5, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i2, i3, i4, i5);
            this.j = i2;
            this.k = i3;
            this.l = i4;
            this.m = i5;
            this.f14099d = bigInteger3;
            this.f14100e = bigInteger4;
            this.n = new i.d(this, null, null);
            this.f14097b = fromBigInteger(bigInteger);
            this.f14098c = fromBigInteger(bigInteger2);
            this.f14101f = 6;
        }

        public C0261e(int i2, int i3, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i2, i3, 0, 0, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public C0261e(int i2, int i3, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i2, i3, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        @Override // g.a.g.a.e
        public e c() {
            return new C0261e(this.j, this.k, this.l, this.m, this.f14097b, this.f14098c, this.f14099d, this.f14100e);
        }

        @Override // g.a.g.a.e
        public g createCacheSafeLookupTable(i[] iVarArr, int i2, int i3) {
            int i4 = (this.j + 63) >>> 6;
            int[] iArr = isTrinomial() ? new int[]{this.k} : new int[]{this.k, this.l, this.m};
            long[] jArr = new long[i3 * i4 * 2];
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                i iVar = iVarArr[i2 + i6];
                ((f.c) iVar.getRawXCoord()).j.h(jArr, i5);
                int i7 = i5 + i4;
                ((f.c) iVar.getRawYCoord()).j.h(jArr, i7);
                i5 = i7 + i4;
            }
            return new a(i3, i4, jArr, iArr);
        }

        @Override // g.a.g.a.e
        public h d() {
            return isKoblitz() ? new y() : super.d();
        }

        @Override // g.a.g.a.e
        public i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
            return new i.d(this, fVar, fVar2);
        }

        @Override // g.a.g.a.e
        public i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
            return new i.d(this, fVar, fVar2, fVarArr);
        }

        @Override // g.a.g.a.e
        public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
            return new f.c(this.j, this.k, this.l, this.m, bigInteger);
        }

        @Override // g.a.g.a.e
        public int getFieldSize() {
            return this.j;
        }

        @Override // g.a.g.a.e
        public i getInfinity() {
            return this.n;
        }

        public int getK1() {
            return this.k;
        }

        public int getK2() {
            return this.l;
        }

        public int getK3() {
            return this.m;
        }

        public int getM() {
            return this.j;
        }

        public boolean isTrinomial() {
            return this.l == 0 && this.m == 0;
        }

        @Override // g.a.g.a.e
        public boolean supportsCoordinateSystem(int i2) {
            return i2 == 0 || i2 == 1 || i2 == 6;
        }
    }

    public static class f extends c {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public BigInteger f14118i;
        public BigInteger j;
        public i.e k;

        public f(BigInteger bigInteger, BigInteger bigInteger2, g.a.g.a.f fVar, g.a.g.a.f fVar2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.f14118i = bigInteger;
            this.j = bigInteger2;
            this.k = new i.e(this, null, null);
            this.f14097b = fVar;
            this.f14098c = fVar2;
            this.f14099d = bigInteger3;
            this.f14100e = bigInteger4;
            this.f14101f = 4;
        }

        public f(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this(bigInteger, bigInteger2, bigInteger3, null, null);
        }

        public f(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            super(bigInteger);
            this.f14118i = bigInteger;
            this.j = f.d.a(bigInteger);
            this.k = new i.e(this, null, null);
            this.f14097b = fromBigInteger(bigInteger2);
            this.f14098c = fromBigInteger(bigInteger3);
            this.f14099d = bigInteger4;
            this.f14100e = bigInteger5;
            this.f14101f = 4;
        }

        @Override // g.a.g.a.e
        public e c() {
            return new f(this.f14118i, this.j, this.f14097b, this.f14098c, this.f14099d, this.f14100e);
        }

        @Override // g.a.g.a.e
        public i e(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
            return new i.e(this, fVar, fVar2);
        }

        @Override // g.a.g.a.e
        public i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
            return new i.e(this, fVar, fVar2, fVarArr);
        }

        @Override // g.a.g.a.e
        public g.a.g.a.f fromBigInteger(BigInteger bigInteger) {
            return new f.d(this.f14118i, this.j, bigInteger);
        }

        @Override // g.a.g.a.e
        public int getFieldSize() {
            return this.f14118i.bitLength();
        }

        @Override // g.a.g.a.e
        public i getInfinity() {
            return this.k;
        }

        public BigInteger getQ() {
            return this.f14118i;
        }

        @Override // g.a.g.a.e
        public i importPoint(i iVar) {
            int coordinateSystem;
            return (this == iVar.getCurve() || getCoordinateSystem() != 2 || iVar.isInfinity() || !((coordinateSystem = iVar.getCurve().getCoordinateSystem()) == 2 || coordinateSystem == 3 || coordinateSystem == 4)) ? super.importPoint(iVar) : new i.e(this, fromBigInteger(iVar.f14127c.toBigInteger()), fromBigInteger(iVar.f14128d.toBigInteger()), new g.a.g.a.f[]{fromBigInteger(iVar.f14129e[0].toBigInteger())});
        }

        @Override // g.a.g.a.e
        public boolean supportsCoordinateSystem(int i2) {
            return i2 == 0 || i2 == 1 || i2 == 2 || i2 == 4;
        }
    }

    public e(g.a.g.b.a aVar) {
        this.f14096a = aVar;
    }

    public static int[] getAllCoordinateSystems() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    public void a(i iVar) {
        if (iVar == null || this != iVar.getCurve()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    public void b(i[] iVarArr, int i2, int i3) {
        if (iVarArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        }
        if (i2 < 0 || i3 < 0 || i2 > iVarArr.length - i3) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        }
        for (int i4 = 0; i4 < i3; i4++) {
            i iVar = iVarArr[i2 + i4];
            if (iVar != null && this != iVar.getCurve()) {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }
    }

    public abstract e c();

    public synchronized d configure() {
        return new d(this.f14101f, this.f14102g, this.f14103h);
    }

    public g createCacheSafeLookupTable(i[] iVarArr, int i2, int i3) {
        int fieldSize = (getFieldSize() + 7) >>> 3;
        byte[] bArr = new byte[i3 * fieldSize * 2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            i iVar = iVarArr[i2 + i5];
            byte[] byteArray = iVar.getRawXCoord().toBigInteger().toByteArray();
            byte[] byteArray2 = iVar.getRawYCoord().toBigInteger().toByteArray();
            int i6 = 1;
            int i7 = byteArray.length > fieldSize ? 1 : 0;
            int length = byteArray.length - i7;
            if (byteArray2.length <= fieldSize) {
                i6 = 0;
            }
            int length2 = byteArray2.length - i6;
            int i8 = i4 + fieldSize;
            System.arraycopy(byteArray, i7, bArr, i8 - length, length);
            i4 = i8 + fieldSize;
            System.arraycopy(byteArray2, i6, bArr, i4 - length2, length2);
        }
        return new a(i3, fieldSize, bArr);
    }

    public i createPoint(BigInteger bigInteger, BigInteger bigInteger2) {
        return e(fromBigInteger(bigInteger), fromBigInteger(bigInteger2));
    }

    public h d() {
        g.a.g.a.c0.a aVar = this.f14102g;
        return aVar instanceof g.a.g.a.c0.d ? new n(this, (g.a.g.a.c0.d) aVar) : new v();
    }

    public i decodePoint(byte[] bArr) {
        i infinity;
        int fieldSize = (getFieldSize() + 7) / 8;
        byte b2 = bArr[0];
        if (b2 != 0) {
            if (b2 == 2 || b2 == 3) {
                if (bArr.length != fieldSize + 1) {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
                infinity = g(b2 & 1, g.a.j.b.fromUnsignedByteArray(bArr, 1, fieldSize));
                if (!infinity.h(true, true)) {
                    throw new IllegalArgumentException("Invalid point");
                }
            } else if (b2 != 4) {
                if (b2 != 6 && b2 != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b2, 16));
                }
                if (bArr.length != (fieldSize * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
                BigInteger bigIntegerFromUnsignedByteArray = g.a.j.b.fromUnsignedByteArray(bArr, 1, fieldSize);
                BigInteger bigIntegerFromUnsignedByteArray2 = g.a.j.b.fromUnsignedByteArray(bArr, fieldSize + 1, fieldSize);
                if (bigIntegerFromUnsignedByteArray2.testBit(0) != (b2 == 7)) {
                    throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                }
                infinity = validatePoint(bigIntegerFromUnsignedByteArray, bigIntegerFromUnsignedByteArray2);
            } else {
                if (bArr.length != (fieldSize * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
                }
                infinity = validatePoint(g.a.j.b.fromUnsignedByteArray(bArr, 1, fieldSize), g.a.j.b.fromUnsignedByteArray(bArr, fieldSize + 1, fieldSize));
            }
        } else {
            if (bArr.length != 1) {
                throw new IllegalArgumentException("Incorrect length for infinity encoding");
            }
            infinity = getInfinity();
        }
        if (b2 == 0 || !infinity.isInfinity()) {
            return infinity;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    public abstract i e(g.a.g.a.f fVar, g.a.g.a.f fVar2);

    public boolean equals(e eVar) {
        return this == eVar || (eVar != null && getField().equals(eVar.getField()) && getA().toBigInteger().equals(eVar.getA().toBigInteger()) && getB().toBigInteger().equals(eVar.getB().toBigInteger()));
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof e) && equals((e) obj));
    }

    public abstract i f(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr);

    public abstract g.a.g.a.f fromBigInteger(BigInteger bigInteger);

    public abstract i g(int i2, BigInteger bigInteger);

    public g.a.g.a.f getA() {
        return this.f14097b;
    }

    public g.a.g.a.f getB() {
        return this.f14098c;
    }

    public BigInteger getCofactor() {
        return this.f14100e;
    }

    public int getCoordinateSystem() {
        return this.f14101f;
    }

    public g.a.g.a.c0.a getEndomorphism() {
        return this.f14102g;
    }

    public g.a.g.b.a getField() {
        return this.f14096a;
    }

    public abstract int getFieldSize();

    public abstract i getInfinity();

    public h getMultiplier() {
        if (this.f14103h == null) {
            this.f14103h = d();
        }
        return this.f14103h;
    }

    public BigInteger getOrder() {
        return this.f14099d;
    }

    public q getPreCompInfo(i iVar, String str) {
        Hashtable hashtable;
        q qVar;
        a(iVar);
        synchronized (iVar) {
            hashtable = iVar.f14130f;
        }
        if (hashtable == null) {
            return null;
        }
        synchronized (hashtable) {
            qVar = (q) hashtable.get(str);
        }
        return qVar;
    }

    public int hashCode() {
        return (getField().hashCode() ^ g.a.j.g.rotateLeft(getA().toBigInteger().hashCode(), 8)) ^ g.a.j.g.rotateLeft(getB().toBigInteger().hashCode(), 16);
    }

    public i importPoint(i iVar) {
        if (this == iVar.getCurve()) {
            return iVar;
        }
        if (iVar.isInfinity()) {
            return getInfinity();
        }
        i iVarNormalize = iVar.normalize();
        return createPoint(iVarNormalize.getXCoord().toBigInteger(), iVarNormalize.getYCoord().toBigInteger());
    }

    public abstract boolean isValidFieldElement(BigInteger bigInteger);

    public void normalizeAll(i[] iVarArr) {
        normalizeAll(iVarArr, 0, iVarArr.length, null);
    }

    public void normalizeAll(i[] iVarArr, int i2, int i3, g.a.g.a.f fVar) {
        b(iVarArr, i2, i3);
        int coordinateSystem = getCoordinateSystem();
        if (coordinateSystem == 0 || coordinateSystem == 5) {
            if (fVar != null) {
                throw new IllegalArgumentException("'iso' not valid for affine coordinates");
            }
            return;
        }
        g.a.g.a.f[] fVarArr = new g.a.g.a.f[i3];
        int[] iArr = new int[i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i2 + i5;
            i iVar = iVarArr[i6];
            if (iVar != null && (fVar != null || !iVar.isNormalized())) {
                fVarArr[i4] = iVar.getZCoord(0);
                iArr[i4] = i6;
                i4++;
            }
        }
        if (i4 == 0) {
            return;
        }
        g.a.g.a.c.montgomeryTrick(fVarArr, 0, i4, fVar);
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = iArr[i7];
            iVarArr[i8] = iVarArr[i8].j(fVarArr[i7]);
        }
    }

    public q precompute(i iVar, String str, p pVar) {
        Hashtable hashtable;
        q qVarPrecompute;
        a(iVar);
        synchronized (iVar) {
            hashtable = iVar.f14130f;
            if (hashtable == null) {
                hashtable = new Hashtable(4);
                iVar.f14130f = hashtable;
            }
        }
        synchronized (hashtable) {
            q qVar = (q) hashtable.get(str);
            qVarPrecompute = pVar.precompute(qVar);
            if (qVarPrecompute != qVar) {
                hashtable.put(str, qVarPrecompute);
            }
        }
        return qVarPrecompute;
    }

    public abstract g.a.g.a.f randomFieldElement(SecureRandom secureRandom);

    public abstract g.a.g.a.f randomFieldElementMult(SecureRandom secureRandom);

    public boolean supportsCoordinateSystem(int i2) {
        return i2 == 0;
    }

    public i validatePoint(BigInteger bigInteger, BigInteger bigInteger2) {
        i iVarCreatePoint = createPoint(bigInteger, bigInteger2);
        if (iVarCreatePoint.isValid()) {
            return iVarCreatePoint;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }
}
