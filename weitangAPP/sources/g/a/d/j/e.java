package g.a.d.j;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13757e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13758f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13759g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13760h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f13761i;
    public int j;

    public e() {
        this.f13761i = new int[80];
        reset();
    }

    public e(e eVar) {
        super(eVar);
        this.f13761i = new int[80];
        f(eVar);
    }

    public e(byte[] bArr) {
        super(bArr);
        this.f13761i = new int[80];
        this.f13756d = g.a.j.k.bigEndianToInt(bArr, 16);
        this.f13757e = g.a.j.k.bigEndianToInt(bArr, 20);
        this.f13758f = g.a.j.k.bigEndianToInt(bArr, 24);
        this.f13759g = g.a.j.k.bigEndianToInt(bArr, 28);
        this.f13760h = g.a.j.k.bigEndianToInt(bArr, 32);
        this.j = g.a.j.k.bigEndianToInt(bArr, 36);
        for (int i2 = 0; i2 != this.j; i2++) {
            this.f13761i[i2] = g.a.j.k.bigEndianToInt(bArr, (i2 * 4) + 40);
        }
    }

    @Override // g.a.d.j.a
    public void c() {
        for (int i2 = 16; i2 < 80; i2++) {
            int[] iArr = this.f13761i;
            int i3 = ((iArr[i2 - 3] ^ iArr[i2 - 8]) ^ iArr[i2 - 14]) ^ iArr[i2 - 16];
            iArr[i2] = (i3 >>> 31) | (i3 << 1);
        }
        int i4 = this.f13756d;
        int i5 = this.f13757e;
        int i6 = this.f13758f;
        int i7 = this.f13759g;
        int i8 = this.f13760h;
        int i9 = 0;
        int i10 = 0;
        while (i9 < 4) {
            int i11 = i10 + 1;
            int iG = i8 + ((i4 << 5) | (i4 >>> 27)) + g(i5, i6, i7) + this.f13761i[i10] + 1518500249;
            int i12 = (i5 >>> 2) | (i5 << 30);
            int i13 = i11 + 1;
            int iG2 = i7 + ((iG << 5) | (iG >>> 27)) + g(i4, i12, i6) + this.f13761i[i11] + 1518500249;
            int i14 = (i4 >>> 2) | (i4 << 30);
            int i15 = i13 + 1;
            int iG3 = i6 + ((iG2 << 5) | (iG2 >>> 27)) + g(iG, i14, i12) + this.f13761i[i13] + 1518500249;
            i8 = (iG >>> 2) | (iG << 30);
            int i16 = i15 + 1;
            i5 = i12 + ((iG3 << 5) | (iG3 >>> 27)) + g(iG2, i8, i14) + this.f13761i[i15] + 1518500249;
            i7 = (iG2 >>> 2) | (iG2 << 30);
            i4 = i14 + ((i5 << 5) | (i5 >>> 27)) + g(iG3, i7, i8) + this.f13761i[i16] + 1518500249;
            i6 = (iG3 >>> 2) | (iG3 << 30);
            i9++;
            i10 = i16 + 1;
        }
        int i17 = 0;
        while (i17 < 4) {
            int i18 = i10 + 1;
            int i19 = i8 + ((i4 << 5) | (i4 >>> 27)) + i(i5, i6, i7) + this.f13761i[i10] + 1859775393;
            int i20 = (i5 >>> 2) | (i5 << 30);
            int i21 = i18 + 1;
            int i22 = i7 + ((i19 << 5) | (i19 >>> 27)) + i(i4, i20, i6) + this.f13761i[i18] + 1859775393;
            int i23 = (i4 >>> 2) | (i4 << 30);
            int i24 = i21 + 1;
            int i25 = i6 + ((i22 << 5) | (i22 >>> 27)) + i(i19, i23, i20) + this.f13761i[i21] + 1859775393;
            i8 = (i19 >>> 2) | (i19 << 30);
            int i26 = i24 + 1;
            i5 = i20 + ((i25 << 5) | (i25 >>> 27)) + i(i22, i8, i23) + this.f13761i[i24] + 1859775393;
            i7 = (i22 >>> 2) | (i22 << 30);
            i4 = i23 + ((i5 << 5) | (i5 >>> 27)) + i(i25, i7, i8) + this.f13761i[i26] + 1859775393;
            i6 = (i25 >>> 2) | (i25 << 30);
            i17++;
            i10 = i26 + 1;
        }
        int i27 = 0;
        while (i27 < 4) {
            int iH = i8 + (((((i4 << 5) | (i4 >>> 27)) + h(i5, i6, i7)) + this.f13761i[i10]) - 1894007588);
            int iH2 = i7 + (((((iH << 5) | (iH >>> 27)) + h(i4, r2, i6)) + this.f13761i[r12]) - 1894007588);
            int iH3 = i6 + (((((iH2 << 5) | (iH2 >>> 27)) + h(iH, r1, r2)) + this.f13761i[r13]) - 1894007588);
            i8 = (iH >>> 2) | (iH << 30);
            i5 = ((i5 >>> 2) | (i5 << 30)) + (((((iH3 << 5) | (iH3 >>> 27)) + h(iH2, i8, r1)) + this.f13761i[r12]) - 1894007588);
            i7 = (iH2 >>> 2) | (iH2 << 30);
            i4 = ((i4 >>> 2) | (i4 << 30)) + (((((i5 << 5) | (i5 >>> 27)) + h(iH3, i7, i8)) + this.f13761i[r13]) - 1894007588);
            i6 = (iH3 >>> 2) | (iH3 << 30);
            i27++;
            i10 = i10 + 1 + 1 + 1 + 1 + 1;
        }
        int i28 = 0;
        while (i28 <= 3) {
            int i29 = i8 + (((((i4 << 5) | (i4 >>> 27)) + i(i5, i6, i7)) + this.f13761i[i10]) - 899497514);
            int i30 = i7 + (((((i29 << 5) | (i29 >>> 27)) + i(i4, r2, i6)) + this.f13761i[r11]) - 899497514);
            int i31 = i6 + (((((i30 << 5) | (i30 >>> 27)) + i(i29, r1, r2)) + this.f13761i[r12]) - 899497514);
            i8 = (i29 >>> 2) | (i29 << 30);
            i5 = ((i5 >>> 2) | (i5 << 30)) + (((((i31 << 5) | (i31 >>> 27)) + i(i30, i8, r1)) + this.f13761i[r11]) - 899497514);
            i7 = (i30 >>> 2) | (i30 << 30);
            i4 = ((i4 >>> 2) | (i4 << 30)) + (((((i5 << 5) | (i5 >>> 27)) + i(i31, i7, i8)) + this.f13761i[r12]) - 899497514);
            i6 = (i31 >>> 2) | (i31 << 30);
            i28++;
            i10 = i10 + 1 + 1 + 1 + 1 + 1;
        }
        this.f13756d += i4;
        this.f13757e += i5;
        this.f13758f += i6;
        this.f13759g += i7;
        this.f13760h += i8;
        this.j = 0;
        for (int i32 = 0; i32 < 16; i32++) {
            this.f13761i[i32] = 0;
        }
    }

    @Override // g.a.d.j.a, g.a.j.h
    public g.a.j.h copy() {
        return new e(this);
    }

    @Override // g.a.d.j.a
    public void d(long j) {
        if (this.j > 14) {
            c();
        }
        int[] iArr = this.f13761i;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    @Override // g.a.d.j.a, g.a.d.e
    public int doFinal(byte[] bArr, int i2) {
        finish();
        g.a.j.k.intToBigEndian(this.f13756d, bArr, i2);
        g.a.j.k.intToBigEndian(this.f13757e, bArr, i2 + 4);
        g.a.j.k.intToBigEndian(this.f13758f, bArr, i2 + 8);
        g.a.j.k.intToBigEndian(this.f13759g, bArr, i2 + 12);
        g.a.j.k.intToBigEndian(this.f13760h, bArr, i2 + 16);
        reset();
        return 20;
    }

    @Override // g.a.d.j.a
    public void e(byte[] bArr, int i2) {
        int i3 = bArr[i2] << 24;
        int i4 = i2 + 1;
        int i5 = i3 | ((bArr[i4] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = (bArr[i6 + 1] & 255) | i5 | ((bArr[i6] & 255) << 8);
        int[] iArr = this.f13761i;
        int i8 = this.j;
        iArr[i8] = i7;
        int i9 = i8 + 1;
        this.j = i9;
        if (i9 == 16) {
            c();
        }
    }

    public final void f(e eVar) {
        this.f13756d = eVar.f13756d;
        this.f13757e = eVar.f13757e;
        this.f13758f = eVar.f13758f;
        this.f13759g = eVar.f13759g;
        this.f13760h = eVar.f13760h;
        int[] iArr = eVar.f13761i;
        System.arraycopy(iArr, 0, this.f13761i, 0, iArr.length);
        this.j = eVar.j;
    }

    public final int g(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    @Override // g.a.d.j.a, g.a.d.e
    public String getAlgorithmName() {
        return MessageDigestAlgorithms.SHA_1;
    }

    @Override // g.a.d.j.a, g.a.d.e
    public int getDigestSize() {
        return 20;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[(this.j * 4) + 40];
        super.b(bArr);
        g.a.j.k.intToBigEndian(this.f13756d, bArr, 16);
        g.a.j.k.intToBigEndian(this.f13757e, bArr, 20);
        g.a.j.k.intToBigEndian(this.f13758f, bArr, 24);
        g.a.j.k.intToBigEndian(this.f13759g, bArr, 28);
        g.a.j.k.intToBigEndian(this.f13760h, bArr, 32);
        g.a.j.k.intToBigEndian(this.j, bArr, 36);
        for (int i2 = 0; i2 != this.j; i2++) {
            g.a.j.k.intToBigEndian(this.f13761i[i2], bArr, (i2 * 4) + 40);
        }
        return bArr;
    }

    public final int h(int i2, int i3, int i4) {
        return (i2 & i4) | (i2 & i3) | (i3 & i4);
    }

    public final int i(int i2, int i3, int i4) {
        return (i2 ^ i3) ^ i4;
    }

    @Override // g.a.d.j.a, g.a.d.e
    public void reset() {
        super.reset();
        this.f13756d = 1732584193;
        this.f13757e = -271733879;
        this.f13758f = -1732584194;
        this.f13759g = 271733878;
        this.f13760h = -1009589776;
        this.j = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f13761i;
            if (i2 == iArr.length) {
                return;
            }
            iArr[i2] = 0;
            i2++;
        }
    }

    @Override // g.a.d.j.a, g.a.j.h
    public void reset(g.a.j.h hVar) {
        e eVar = (e) hVar;
        super.a(eVar);
        f(eVar);
    }
}
