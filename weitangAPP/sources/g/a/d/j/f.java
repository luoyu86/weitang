package g.a.d.j;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class f extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f13762d = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13763e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13767i;
    public int j;
    public int k;
    public int l;
    public int[] m;
    public int n;

    public f() {
        this.m = new int[64];
        reset();
    }

    public f(f fVar) {
        super(fVar);
        this.m = new int[64];
        l(fVar);
    }

    public f(byte[] bArr) {
        super(bArr);
        this.m = new int[64];
        this.f13763e = g.a.j.k.bigEndianToInt(bArr, 16);
        this.f13764f = g.a.j.k.bigEndianToInt(bArr, 20);
        this.f13765g = g.a.j.k.bigEndianToInt(bArr, 24);
        this.f13766h = g.a.j.k.bigEndianToInt(bArr, 28);
        this.f13767i = g.a.j.k.bigEndianToInt(bArr, 32);
        this.j = g.a.j.k.bigEndianToInt(bArr, 36);
        this.k = g.a.j.k.bigEndianToInt(bArr, 40);
        this.l = g.a.j.k.bigEndianToInt(bArr, 44);
        this.n = g.a.j.k.bigEndianToInt(bArr, 48);
        for (int i2 = 0; i2 != this.n; i2++) {
            this.m[i2] = g.a.j.k.bigEndianToInt(bArr, (i2 * 4) + 52);
        }
    }

    @Override // g.a.d.j.a
    public void c() {
        for (int i2 = 16; i2 <= 63; i2++) {
            int[] iArr = this.m;
            int iK = k(iArr[i2 - 2]);
            int[] iArr2 = this.m;
            iArr[i2] = iK + iArr2[i2 - 7] + j(iArr2[i2 - 15]) + this.m[i2 - 16];
        }
        int iH = this.f13763e;
        int iH2 = this.f13764f;
        int iH3 = this.f13765g;
        int iH4 = this.f13766h;
        int i3 = this.f13767i;
        int i4 = this.j;
        int i5 = this.k;
        int i6 = this.l;
        int i7 = 0;
        for (int i8 = 0; i8 < 8; i8++) {
            int i9 = i(i3) + f(i3, i4, i5);
            int[] iArr3 = f13762d;
            int i10 = i6 + i9 + iArr3[i7] + this.m[i7];
            int i11 = iH4 + i10;
            int iH5 = i10 + h(iH) + g(iH, iH2, iH3);
            int i12 = i7 + 1;
            int i13 = i5 + i(i11) + f(i11, i3, i4) + iArr3[i12] + this.m[i12];
            int i14 = iH3 + i13;
            int iH6 = i13 + h(iH5) + g(iH5, iH, iH2);
            int i15 = i12 + 1;
            int i16 = i4 + i(i14) + f(i14, i11, i3) + iArr3[i15] + this.m[i15];
            int i17 = iH2 + i16;
            int iH7 = i16 + h(iH6) + g(iH6, iH5, iH);
            int i18 = i15 + 1;
            int i19 = i3 + i(i17) + f(i17, i14, i11) + iArr3[i18] + this.m[i18];
            int i20 = iH + i19;
            int iH8 = i19 + h(iH7) + g(iH7, iH6, iH5);
            int i21 = i18 + 1;
            int i22 = i11 + i(i20) + f(i20, i17, i14) + iArr3[i21] + this.m[i21];
            i6 = iH5 + i22;
            iH4 = i22 + h(iH8) + g(iH8, iH7, iH6);
            int i23 = i21 + 1;
            int i24 = i14 + i(i6) + f(i6, i20, i17) + iArr3[i23] + this.m[i23];
            i5 = iH6 + i24;
            iH3 = i24 + h(iH4) + g(iH4, iH8, iH7);
            int i25 = i23 + 1;
            int i26 = i17 + i(i5) + f(i5, i6, i20) + iArr3[i25] + this.m[i25];
            i4 = iH7 + i26;
            iH2 = i26 + h(iH3) + g(iH3, iH4, iH8);
            int i27 = i25 + 1;
            int i28 = i20 + i(i4) + f(i4, i5, i6) + iArr3[i27] + this.m[i27];
            i3 = iH8 + i28;
            iH = i28 + h(iH2) + g(iH2, iH3, iH4);
            i7 = i27 + 1;
        }
        this.f13763e += iH;
        this.f13764f += iH2;
        this.f13765g += iH3;
        this.f13766h += iH4;
        this.f13767i += i3;
        this.j += i4;
        this.k += i5;
        this.l += i6;
        this.n = 0;
        for (int i29 = 0; i29 < 16; i29++) {
            this.m[i29] = 0;
        }
    }

    @Override // g.a.d.j.a, g.a.j.h
    public g.a.j.h copy() {
        return new f(this);
    }

    @Override // g.a.d.j.a
    public void d(long j) {
        if (this.n > 14) {
            c();
        }
        int[] iArr = this.m;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & (-1));
    }

    @Override // g.a.d.j.a, g.a.d.e
    public int doFinal(byte[] bArr, int i2) {
        finish();
        g.a.j.k.intToBigEndian(this.f13763e, bArr, i2);
        g.a.j.k.intToBigEndian(this.f13764f, bArr, i2 + 4);
        g.a.j.k.intToBigEndian(this.f13765g, bArr, i2 + 8);
        g.a.j.k.intToBigEndian(this.f13766h, bArr, i2 + 12);
        g.a.j.k.intToBigEndian(this.f13767i, bArr, i2 + 16);
        g.a.j.k.intToBigEndian(this.j, bArr, i2 + 20);
        g.a.j.k.intToBigEndian(this.k, bArr, i2 + 24);
        reset();
        return 28;
    }

    @Override // g.a.d.j.a
    public void e(byte[] bArr, int i2) {
        int i3 = bArr[i2] << 24;
        int i4 = i2 + 1;
        int i5 = i3 | ((bArr[i4] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = (bArr[i6 + 1] & 255) | i5 | ((bArr[i6] & 255) << 8);
        int[] iArr = this.m;
        int i8 = this.n;
        iArr[i8] = i7;
        int i9 = i8 + 1;
        this.n = i9;
        if (i9 == 16) {
            c();
        }
    }

    public final int f(int i2, int i3, int i4) {
        return ((~i2) & i4) ^ (i3 & i2);
    }

    public final int g(int i2, int i3, int i4) {
        return ((i2 & i4) ^ (i2 & i3)) ^ (i3 & i4);
    }

    @Override // g.a.d.j.a, g.a.d.e
    public String getAlgorithmName() {
        return MessageDigestAlgorithms.SHA_224;
    }

    @Override // g.a.d.j.a, g.a.d.e
    public int getDigestSize() {
        return 28;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[(this.n * 4) + 52];
        super.b(bArr);
        g.a.j.k.intToBigEndian(this.f13763e, bArr, 16);
        g.a.j.k.intToBigEndian(this.f13764f, bArr, 20);
        g.a.j.k.intToBigEndian(this.f13765g, bArr, 24);
        g.a.j.k.intToBigEndian(this.f13766h, bArr, 28);
        g.a.j.k.intToBigEndian(this.f13767i, bArr, 32);
        g.a.j.k.intToBigEndian(this.j, bArr, 36);
        g.a.j.k.intToBigEndian(this.k, bArr, 40);
        g.a.j.k.intToBigEndian(this.l, bArr, 44);
        g.a.j.k.intToBigEndian(this.n, bArr, 48);
        for (int i2 = 0; i2 != this.n; i2++) {
            g.a.j.k.intToBigEndian(this.m[i2], bArr, (i2 * 4) + 52);
        }
        return bArr;
    }

    public final int h(int i2) {
        return ((i2 << 10) | (i2 >>> 22)) ^ (((i2 >>> 2) | (i2 << 30)) ^ ((i2 >>> 13) | (i2 << 19)));
    }

    public final int i(int i2) {
        return ((i2 << 7) | (i2 >>> 25)) ^ (((i2 >>> 6) | (i2 << 26)) ^ ((i2 >>> 11) | (i2 << 21)));
    }

    public final int j(int i2) {
        return (i2 >>> 3) ^ (((i2 >>> 7) | (i2 << 25)) ^ ((i2 >>> 18) | (i2 << 14)));
    }

    public final int k(int i2) {
        return (i2 >>> 10) ^ (((i2 >>> 17) | (i2 << 15)) ^ ((i2 >>> 19) | (i2 << 13)));
    }

    public final void l(f fVar) {
        super.a(fVar);
        this.f13763e = fVar.f13763e;
        this.f13764f = fVar.f13764f;
        this.f13765g = fVar.f13765g;
        this.f13766h = fVar.f13766h;
        this.f13767i = fVar.f13767i;
        this.j = fVar.j;
        this.k = fVar.k;
        this.l = fVar.l;
        int[] iArr = fVar.m;
        System.arraycopy(iArr, 0, this.m, 0, iArr.length);
        this.n = fVar.n;
    }

    @Override // g.a.d.j.a, g.a.d.e
    public void reset() {
        super.reset();
        this.f13763e = -1056596264;
        this.f13764f = 914150663;
        this.f13765g = 812702999;
        this.f13766h = -150054599;
        this.f13767i = -4191439;
        this.j = 1750603025;
        this.k = 1694076839;
        this.l = -1090891868;
        this.n = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.m;
            if (i2 == iArr.length) {
                return;
            }
            iArr[i2] = 0;
            i2++;
        }
    }

    @Override // g.a.d.j.a, g.a.j.h
    public void reset(g.a.j.h hVar) {
        l((f) hVar);
    }
}
