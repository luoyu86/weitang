package g.a.d.j;

/* JADX INFO: loaded from: classes2.dex */
public class b implements g.a.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long[] f13734a = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f13735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f13736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13740g;

    public b() {
        this(288);
    }

    public b(int i2) {
        this.f13735b = new long[25];
        this.f13736c = new byte[192];
        g(i2);
    }

    public b(b bVar) {
        long[] jArr = new long[25];
        this.f13735b = jArr;
        this.f13736c = new byte[192];
        long[] jArr2 = bVar.f13735b;
        System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
        byte[] bArr = bVar.f13736c;
        System.arraycopy(bArr, 0, this.f13736c, 0, bArr.length);
        this.f13737d = bVar.f13737d;
        this.f13738e = bVar.f13738e;
        this.f13739f = bVar.f13739f;
        this.f13740g = bVar.f13740g;
    }

    public final void a(byte[] bArr, int i2) {
        int i3 = this.f13737d >>> 6;
        for (int i4 = 0; i4 < i3; i4++) {
            long[] jArr = this.f13735b;
            jArr[i4] = jArr[i4] ^ g.a.j.k.littleEndianToLong(bArr, i2);
            i2 += 8;
        }
        c();
    }

    public final void b() {
        c();
        g.a.j.k.longToLittleEndian(this.f13735b, 0, this.f13737d >>> 6, this.f13736c, 0);
        this.f13738e = this.f13737d;
    }

    public final void c() {
        long[] jArr = this.f13735b;
        int i2 = 0;
        long j = jArr[0];
        char c2 = 1;
        long j2 = jArr[1];
        long j3 = jArr[2];
        char c3 = 3;
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = jArr[9];
        long j11 = jArr[10];
        long j12 = jArr[11];
        long j13 = jArr[12];
        long j14 = jArr[13];
        long j15 = jArr[14];
        long j16 = jArr[15];
        long j17 = jArr[16];
        long j18 = jArr[17];
        long j19 = jArr[18];
        long j20 = jArr[19];
        long j21 = jArr[20];
        long j22 = jArr[21];
        long j23 = jArr[22];
        long j24 = jArr[23];
        int i3 = 24;
        long j25 = jArr[24];
        while (i2 < i3) {
            long j26 = (((j ^ j6) ^ j11) ^ j16) ^ j21;
            long j27 = (((j2 ^ j7) ^ j12) ^ j17) ^ j22;
            long j28 = (((j3 ^ j8) ^ j13) ^ j18) ^ j23;
            long j29 = (((j4 ^ j9) ^ j14) ^ j19) ^ j24;
            long j30 = (((j5 ^ j10) ^ j15) ^ j20) ^ j25;
            long j31 = ((j27 << c2) | (j27 >>> (-1))) ^ j30;
            long j32 = ((j28 << c2) | (j28 >>> (-1))) ^ j26;
            long j33 = ((j29 << c2) | (j29 >>> (-1))) ^ j27;
            long j34 = ((j30 << c2) | (j30 >>> (-1))) ^ j28;
            long j35 = ((j26 << c2) | (j26 >>> (-1))) ^ j29;
            long j36 = j ^ j31;
            long j37 = j6 ^ j31;
            long j38 = j11 ^ j31;
            long j39 = j16 ^ j31;
            long j40 = j21 ^ j31;
            long j41 = j2 ^ j32;
            long j42 = j7 ^ j32;
            long j43 = j12 ^ j32;
            long j44 = j17 ^ j32;
            long j45 = j22 ^ j32;
            long j46 = j3 ^ j33;
            long j47 = j8 ^ j33;
            long j48 = j13 ^ j33;
            long j49 = j18 ^ j33;
            long j50 = j23 ^ j33;
            long j51 = j4 ^ j34;
            long j52 = j9 ^ j34;
            long j53 = j14 ^ j34;
            long j54 = j19 ^ j34;
            long j55 = j24 ^ j34;
            long j56 = j5 ^ j35;
            long j57 = j10 ^ j35;
            long j58 = j15 ^ j35;
            long j59 = j20 ^ j35;
            long j60 = j25 ^ j35;
            long j61 = (j41 << c2) | (j41 >>> 63);
            long j62 = (j42 << 44) | (j42 >>> 20);
            long j63 = (j57 << 20) | (j57 >>> 44);
            long j64 = (j50 << 61) | (j50 >>> c3);
            long j65 = (j58 << 39) | (j58 >>> 25);
            long j66 = (j40 << 18) | (j40 >>> 46);
            long j67 = (j46 << 62) | (j46 >>> 2);
            long j68 = (j48 << 43) | (j48 >>> 21);
            long j69 = (j53 << 25) | (j53 >>> 39);
            long j70 = (j59 << 8) | (j59 >>> 56);
            long j71 = (j55 << 56) | (j55 >>> 8);
            long j72 = (j39 << 41) | (j39 >>> 23);
            long j73 = (j56 << 27) | (j56 >>> 37);
            long j74 = (j60 << 14) | (j60 >>> 50);
            long j75 = (j45 << 2) | (j45 >>> 62);
            long j76 = (j52 << 55) | (j52 >>> 9);
            long j77 = (j44 << 45) | (j44 >>> 19);
            long j78 = (j37 << 36) | (j37 >>> 28);
            long j79 = (j51 << 28) | (j51 >>> 36);
            long j80 = (j54 << 21) | (j54 >>> 43);
            long j81 = (j49 << 15) | (j49 >>> 49);
            long j82 = (j43 << 10) | (j43 >>> 54);
            long j83 = (j47 << 6) | (j47 >>> 58);
            long j84 = (j38 << 3) | (j38 >>> 61);
            long j85 = ((~j62) & j68) ^ j36;
            long j86 = ((~j68) & j80) ^ j62;
            j3 = j68 ^ ((~j80) & j74);
            j4 = j80 ^ ((~j74) & j36);
            long j87 = j74 ^ ((~j36) & j62);
            long j88 = j79 ^ ((~j63) & j84);
            long j89 = ((~j84) & j77) ^ j63;
            long j90 = ((~j77) & j64) ^ j84;
            long j91 = j77 ^ ((~j64) & j79);
            long j92 = ((~j79) & j63) ^ j64;
            j11 = j61 ^ ((~j83) & j69);
            long j93 = ((~j69) & j70) ^ j83;
            long j94 = ((~j70) & j66) ^ j69;
            long j95 = j70 ^ ((~j66) & j61);
            long j96 = ((~j61) & j83) ^ j66;
            long j97 = j73 ^ ((~j78) & j82);
            long j98 = ((~j82) & j81) ^ j78;
            long j99 = j82 ^ ((~j81) & j71);
            long j100 = ((~j71) & j73) ^ j81;
            long j101 = ((~j73) & j78) ^ j71;
            long j102 = j67 ^ ((~j76) & j65);
            long j103 = ((~j65) & j72) ^ j76;
            j21 = j102;
            long j104 = j65 ^ ((~j72) & j75);
            long j105 = ((~j75) & j67) ^ j72;
            long j106 = ((~j67) & j76) ^ j75;
            long j107 = j85 ^ f13734a[i2];
            i2++;
            j7 = j89;
            j13 = j94;
            j12 = j93;
            j14 = j95;
            j22 = j103;
            c3 = 3;
            j24 = j105;
            j23 = j104;
            j10 = j92;
            jArr = jArr;
            j20 = j101;
            j15 = j96;
            j8 = j90;
            j9 = j91;
            j18 = j99;
            j16 = j97;
            j5 = j87;
            j6 = j88;
            i3 = 24;
            j19 = j100;
            j17 = j98;
            c2 = 1;
            j2 = j86;
            j25 = j106;
            j = j107;
        }
        long[] jArr2 = jArr;
        jArr2[0] = j;
        jArr2[1] = j2;
        jArr2[2] = j3;
        jArr2[3] = j4;
        jArr2[4] = j5;
        jArr2[5] = j6;
        jArr2[6] = j7;
        jArr2[7] = j8;
        jArr2[8] = j9;
        jArr2[9] = j10;
        jArr2[10] = j11;
        jArr2[11] = j12;
        jArr2[12] = j13;
        jArr2[13] = j14;
        jArr2[14] = j15;
        jArr2[15] = j16;
        jArr2[16] = j17;
        jArr2[17] = j18;
        jArr2[18] = j19;
        jArr2[19] = j20;
        jArr2[20] = j21;
        jArr2[21] = j22;
        jArr2[22] = j23;
        jArr2[23] = j24;
        jArr2[24] = j25;
    }

    public void d(byte b2) {
        int i2 = this.f13738e;
        if (i2 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.f13740g) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        byte[] bArr = this.f13736c;
        bArr[i2 >>> 3] = b2;
        int i3 = i2 + 8;
        this.f13738e = i3;
        if (i3 == this.f13737d) {
            a(bArr, 0);
            this.f13738e = 0;
        }
    }

    @Override // g.a.d.e
    public int doFinal(byte[] bArr, int i2) {
        j(bArr, i2, this.f13739f);
        reset();
        return getDigestSize();
    }

    public void e(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7 = this.f13738e;
        if (i7 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.f13740g) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        int i8 = i7 >>> 3;
        int i9 = this.f13737d >>> 3;
        int i10 = i9 - i8;
        if (i3 < i10) {
            System.arraycopy(bArr, i2, this.f13736c, i8, i3);
            i6 = this.f13738e + (i3 << 3);
        } else {
            if (i8 > 0) {
                System.arraycopy(bArr, i2, this.f13736c, i8, i10);
                i4 = i10 + 0;
                a(this.f13736c, 0);
            } else {
                i4 = 0;
            }
            while (true) {
                i5 = i3 - i4;
                if (i5 < i9) {
                    break;
                }
                a(bArr, i2 + i4);
                i4 += i9;
            }
            System.arraycopy(bArr, i2 + i4, this.f13736c, 0, i5);
            i6 = i5 << 3;
        }
        this.f13738e = i6;
    }

    public void f(int i2, int i3) {
        if (i3 < 1 || i3 > 7) {
            throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
        }
        int i4 = this.f13738e;
        if (i4 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.f13740g) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        this.f13736c[i4 >>> 3] = (byte) (i2 & ((1 << i3) - 1));
        this.f13738e = i4 + i3;
    }

    public final void g(int i2) {
        if (i2 != 128 && i2 != 224 && i2 != 256 && i2 != 288 && i2 != 384 && i2 != 512) {
            throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
        }
        h(1600 - (i2 << 1));
    }

    @Override // g.a.d.e
    public String getAlgorithmName() {
        return "Keccak-" + this.f13739f;
    }

    public int getByteLength() {
        return this.f13737d / 8;
    }

    @Override // g.a.d.e
    public int getDigestSize() {
        return this.f13739f / 8;
    }

    public final void h(int i2) {
        if (i2 <= 0 || i2 >= 1600 || i2 % 64 != 0) {
            throw new IllegalStateException("invalid rate value");
        }
        this.f13737d = i2;
        int i3 = 0;
        while (true) {
            long[] jArr = this.f13735b;
            if (i3 >= jArr.length) {
                g.a.j.a.fill(this.f13736c, (byte) 0);
                this.f13738e = 0;
                this.f13740g = false;
                this.f13739f = (1600 - i2) / 2;
                return;
            }
            jArr[i3] = 0;
            i3++;
        }
    }

    public final void i() {
        byte[] bArr = this.f13736c;
        int i2 = this.f13738e;
        int i3 = i2 >>> 3;
        bArr[i3] = (byte) (bArr[i3] | ((byte) (1 << (i2 & 7))));
        int i4 = i2 + 1;
        this.f13738e = i4;
        if (i4 == this.f13737d) {
            a(bArr, 0);
        } else {
            int i5 = i4 >>> 6;
            int i6 = i4 & 63;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                long[] jArr = this.f13735b;
                jArr[i8] = jArr[i8] ^ g.a.j.k.littleEndianToLong(this.f13736c, i7);
                i7 += 8;
            }
            if (i6 > 0) {
                long[] jArr2 = this.f13735b;
                jArr2[i5] = (((1 << i6) - 1) & g.a.j.k.littleEndianToLong(this.f13736c, i7)) ^ jArr2[i5];
            }
        }
        long[] jArr3 = this.f13735b;
        int i9 = (this.f13737d - 1) >>> 6;
        jArr3[i9] = jArr3[i9] ^ Long.MIN_VALUE;
        this.f13738e = 0;
        this.f13740g = true;
    }

    public void j(byte[] bArr, int i2, long j) {
        if (!this.f13740g) {
            i();
        }
        long j2 = 0;
        if (j % 8 != 0) {
            throw new IllegalStateException("outputLength not a multiple of 8");
        }
        while (j2 < j) {
            if (this.f13738e == 0) {
                b();
            }
            int iMin = (int) Math.min(this.f13738e, j - j2);
            System.arraycopy(this.f13736c, (this.f13737d - this.f13738e) / 8, bArr, ((int) (j2 / 8)) + i2, iMin / 8);
            this.f13738e -= iMin;
            j2 += (long) iMin;
        }
    }

    @Override // g.a.d.e
    public void reset() {
        g(this.f13739f);
    }

    @Override // g.a.d.e
    public void update(byte b2) {
        d(b2);
    }

    @Override // g.a.d.e
    public void update(byte[] bArr, int i2, int i3) {
        e(bArr, i2, i3);
    }
}
