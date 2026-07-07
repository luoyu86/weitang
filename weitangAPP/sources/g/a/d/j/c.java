package g.a.d.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements g.a.d.e, g.a.j.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long[] f13741a = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f13742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f13746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f13747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f13748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f13749i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long[] n;
    public int o;

    public c() {
        this.f13742b = new byte[8];
        this.n = new long[80];
        this.f13743c = 0;
        reset();
    }

    public c(c cVar) {
        this.f13742b = new byte[8];
        this.n = new long[80];
        h(cVar);
    }

    public final long a(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    public final long b(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    public final long c(long j) {
        return (j >>> 7) ^ (((j << 63) | (j >>> 1)) ^ ((j << 56) | (j >>> 8)));
    }

    @Override // g.a.j.h
    public abstract /* synthetic */ g.a.j.h copy();

    public final long d(long j) {
        return (j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)));
    }

    @Override // g.a.d.e
    public abstract /* synthetic */ int doFinal(byte[] bArr, int i2);

    public final long e(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    public final long f(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    public void finish() {
        g();
        long j = this.f13744d << 3;
        long j2 = this.f13745e;
        byte b2 = -128;
        while (true) {
            update(b2);
            if (this.f13743c == 0) {
                l(j, j2);
                k();
                return;
            }
            b2 = 0;
        }
    }

    public final void g() {
        long j = this.f13744d;
        if (j > 2305843009213693951L) {
            this.f13745e += j >>> 61;
            this.f13744d = j & 2305843009213693951L;
        }
    }

    @Override // g.a.d.e
    public abstract /* synthetic */ String getAlgorithmName();

    public int getByteLength() {
        return 128;
    }

    @Override // g.a.d.e
    public abstract /* synthetic */ int getDigestSize();

    public abstract /* synthetic */ byte[] getEncodedState();

    public void h(c cVar) {
        byte[] bArr = cVar.f13742b;
        System.arraycopy(bArr, 0, this.f13742b, 0, bArr.length);
        this.f13743c = cVar.f13743c;
        this.f13744d = cVar.f13744d;
        this.f13745e = cVar.f13745e;
        this.f13746f = cVar.f13746f;
        this.f13747g = cVar.f13747g;
        this.f13748h = cVar.f13748h;
        this.f13749i = cVar.f13749i;
        this.j = cVar.j;
        this.k = cVar.k;
        this.l = cVar.l;
        this.m = cVar.m;
        long[] jArr = cVar.n;
        System.arraycopy(jArr, 0, this.n, 0, jArr.length);
        this.o = cVar.o;
    }

    public int i() {
        return (this.o * 8) + 96;
    }

    public void j(byte[] bArr) {
        System.arraycopy(this.f13742b, 0, bArr, 0, this.f13743c);
        g.a.j.k.intToBigEndian(this.f13743c, bArr, 8);
        g.a.j.k.longToBigEndian(this.f13744d, bArr, 12);
        g.a.j.k.longToBigEndian(this.f13745e, bArr, 20);
        g.a.j.k.longToBigEndian(this.f13746f, bArr, 28);
        g.a.j.k.longToBigEndian(this.f13747g, bArr, 36);
        g.a.j.k.longToBigEndian(this.f13748h, bArr, 44);
        g.a.j.k.longToBigEndian(this.f13749i, bArr, 52);
        g.a.j.k.longToBigEndian(this.j, bArr, 60);
        g.a.j.k.longToBigEndian(this.k, bArr, 68);
        g.a.j.k.longToBigEndian(this.l, bArr, 76);
        g.a.j.k.longToBigEndian(this.m, bArr, 84);
        g.a.j.k.intToBigEndian(this.o, bArr, 92);
        for (int i2 = 0; i2 < this.o; i2++) {
            g.a.j.k.longToBigEndian(this.n[i2], bArr, (i2 * 8) + 96);
        }
    }

    public void k() {
        g();
        for (int i2 = 16; i2 <= 79; i2++) {
            long[] jArr = this.n;
            long jD = d(jArr[i2 - 2]);
            long[] jArr2 = this.n;
            jArr[i2] = jD + jArr2[i2 - 7] + c(jArr2[i2 - 15]) + this.n[i2 - 16];
        }
        long j = this.f13746f;
        long j2 = this.f13747g;
        long j3 = this.f13748h;
        long j4 = this.f13749i;
        long j5 = this.j;
        long j6 = this.k;
        long j7 = this.l;
        long j8 = j6;
        long j9 = j4;
        int i3 = 0;
        long jE = j2;
        long j10 = j3;
        long j11 = j5;
        int i4 = 0;
        long j12 = this.m;
        long j13 = j;
        long j14 = j7;
        while (i4 < 10) {
            long j15 = j11;
            long jF = f(j11) + a(j11, j8, j14);
            long[] jArr3 = f13741a;
            int i5 = i3 + 1;
            long j16 = j12 + jF + jArr3[i3] + this.n[i3];
            long j17 = j9 + j16;
            long jE2 = j16 + e(j13) + b(j13, jE, j10);
            int i6 = i5 + 1;
            long jF2 = j14 + f(j17) + a(j17, j15, j8) + jArr3[i5] + this.n[i5];
            long j18 = j10 + jF2;
            long jE3 = jF2 + e(jE2) + b(jE2, j13, jE);
            int i7 = i6 + 1;
            long jF3 = j8 + f(j18) + a(j18, j17, j15) + jArr3[i6] + this.n[i6];
            long j19 = jE + jF3;
            long jE4 = jF3 + e(jE3) + b(jE3, jE2, j13);
            int i8 = i7 + 1;
            long jF4 = j15 + f(j19) + a(j19, j18, j17) + jArr3[i7] + this.n[i7];
            long j20 = j13 + jF4;
            long jE5 = jF4 + e(jE4) + b(jE4, jE3, jE2);
            int i9 = i8 + 1;
            long jF5 = j17 + f(j20) + a(j20, j19, j18) + jArr3[i8] + this.n[i8];
            long j21 = jE2 + jF5;
            long jE6 = jF5 + e(jE5) + b(jE5, jE4, jE3);
            int i10 = i9 + 1;
            long jF6 = j18 + f(j21) + a(j21, j20, j19) + jArr3[i9] + this.n[i9];
            long j22 = jE3 + jF6;
            long jE7 = jF6 + e(jE6) + b(jE6, jE5, jE4);
            j14 = j22;
            int i11 = i10 + 1;
            long jF7 = j19 + f(j22) + a(j22, j21, j20) + jArr3[i10] + this.n[i10];
            long j23 = jE4 + jF7;
            j8 = j23;
            jE = jF7 + e(jE7) + b(jE7, jE6, jE5);
            long jF8 = j20 + f(j23) + a(j23, j14, j21) + jArr3[i11] + this.n[i11];
            long jE8 = jF8 + e(jE) + b(jE, jE7, jE6);
            i4++;
            j11 = jE5 + jF8;
            j10 = jE7;
            j12 = j21;
            j9 = jE6;
            i3 = i11 + 1;
            j13 = jE8;
        }
        this.f13746f += j13;
        this.f13747g += jE;
        this.f13748h += j10;
        this.f13749i += j9;
        this.j += j11;
        this.k += j8;
        this.l += j14;
        this.m += j12;
        this.o = 0;
        for (int i12 = 0; i12 < 16; i12++) {
            this.n[i12] = 0;
        }
    }

    public void l(long j, long j2) {
        if (this.o > 14) {
            k();
        }
        long[] jArr = this.n;
        jArr[14] = j2;
        jArr[15] = j;
    }

    public void m(byte[] bArr, int i2) {
        this.n[this.o] = g.a.j.k.bigEndianToLong(bArr, i2);
        int i3 = this.o + 1;
        this.o = i3;
        if (i3 == 16) {
            k();
        }
    }

    public void n(byte[] bArr) {
        int iBigEndianToInt = g.a.j.k.bigEndianToInt(bArr, 8);
        this.f13743c = iBigEndianToInt;
        System.arraycopy(bArr, 0, this.f13742b, 0, iBigEndianToInt);
        this.f13744d = g.a.j.k.bigEndianToLong(bArr, 12);
        this.f13745e = g.a.j.k.bigEndianToLong(bArr, 20);
        this.f13746f = g.a.j.k.bigEndianToLong(bArr, 28);
        this.f13747g = g.a.j.k.bigEndianToLong(bArr, 36);
        this.f13748h = g.a.j.k.bigEndianToLong(bArr, 44);
        this.f13749i = g.a.j.k.bigEndianToLong(bArr, 52);
        this.j = g.a.j.k.bigEndianToLong(bArr, 60);
        this.k = g.a.j.k.bigEndianToLong(bArr, 68);
        this.l = g.a.j.k.bigEndianToLong(bArr, 76);
        this.m = g.a.j.k.bigEndianToLong(bArr, 84);
        this.o = g.a.j.k.bigEndianToInt(bArr, 92);
        for (int i2 = 0; i2 < this.o; i2++) {
            this.n[i2] = g.a.j.k.bigEndianToLong(bArr, (i2 * 8) + 96);
        }
    }

    @Override // g.a.d.e
    public void reset() {
        this.f13744d = 0L;
        this.f13745e = 0L;
        int i2 = 0;
        this.f13743c = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f13742b;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = 0;
            i3++;
        }
        this.o = 0;
        while (true) {
            long[] jArr = this.n;
            if (i2 == jArr.length) {
                return;
            }
            jArr[i2] = 0;
            i2++;
        }
    }

    @Override // g.a.j.h
    public abstract /* synthetic */ void reset(g.a.j.h hVar);

    @Override // g.a.d.e
    public void update(byte b2) {
        byte[] bArr = this.f13742b;
        int i2 = this.f13743c;
        int i3 = i2 + 1;
        this.f13743c = i3;
        bArr[i2] = b2;
        if (i3 == bArr.length) {
            m(bArr, 0);
            this.f13743c = 0;
        }
        this.f13744d++;
    }

    @Override // g.a.d.e
    public void update(byte[] bArr, int i2, int i3) {
        while (this.f13743c != 0 && i3 > 0) {
            update(bArr[i2]);
            i2++;
            i3--;
        }
        while (i3 > this.f13742b.length) {
            m(bArr, i2);
            byte[] bArr2 = this.f13742b;
            i2 += bArr2.length;
            i3 -= bArr2.length;
            this.f13744d += (long) bArr2.length;
        }
        while (i3 > 0) {
            update(bArr[i2]);
            i2++;
            i3--;
        }
    }
}
