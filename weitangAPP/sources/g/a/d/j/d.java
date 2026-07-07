package g.a.d.j;

import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f13754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13755i;

    public d() {
        this.f13754h = new int[16];
        reset();
    }

    public d(d dVar) {
        super(dVar);
        this.f13754h = new int[16];
        j(dVar);
    }

    public d(byte[] bArr) {
        super(bArr);
        this.f13754h = new int[16];
        this.f13750d = g.a.j.k.bigEndianToInt(bArr, 16);
        this.f13751e = g.a.j.k.bigEndianToInt(bArr, 20);
        this.f13752f = g.a.j.k.bigEndianToInt(bArr, 24);
        this.f13753g = g.a.j.k.bigEndianToInt(bArr, 28);
        this.f13755i = g.a.j.k.bigEndianToInt(bArr, 32);
        for (int i2 = 0; i2 != this.f13755i; i2++) {
            this.f13754h[i2] = g.a.j.k.bigEndianToInt(bArr, (i2 * 4) + 36);
        }
    }

    @Override // g.a.d.j.a
    public void c() {
        int i2 = this.f13750d;
        int i3 = this.f13751e;
        int i4 = this.f13752f;
        int i5 = this.f13753g;
        int iK = k(((i2 + f(i3, i4, i5)) + this.f13754h[0]) - 680876936, 7) + i3;
        int iK2 = k(((i5 + f(iK, i3, i4)) + this.f13754h[1]) - 389564586, 12) + iK;
        int iK3 = k(i4 + f(iK2, iK, i3) + this.f13754h[2] + 606105819, 17) + iK2;
        int iK4 = k(((i3 + f(iK3, iK2, iK)) + this.f13754h[3]) - 1044525330, 22) + iK3;
        int iK5 = k(((iK + f(iK4, iK3, iK2)) + this.f13754h[4]) - 176418897, 7) + iK4;
        int iK6 = k(iK2 + f(iK5, iK4, iK3) + this.f13754h[5] + 1200080426, 12) + iK5;
        int iK7 = k(((iK3 + f(iK6, iK5, iK4)) + this.f13754h[6]) - 1473231341, 17) + iK6;
        int iK8 = k(((iK4 + f(iK7, iK6, iK5)) + this.f13754h[7]) - 45705983, 22) + iK7;
        int iK9 = k(iK5 + f(iK8, iK7, iK6) + this.f13754h[8] + 1770035416, 7) + iK8;
        int iK10 = k(((iK6 + f(iK9, iK8, iK7)) + this.f13754h[9]) - 1958414417, 12) + iK9;
        int iK11 = k(((iK7 + f(iK10, iK9, iK8)) + this.f13754h[10]) - 42063, 17) + iK10;
        int iK12 = k(((iK8 + f(iK11, iK10, iK9)) + this.f13754h[11]) - 1990404162, 22) + iK11;
        int iK13 = k(iK9 + f(iK12, iK11, iK10) + this.f13754h[12] + 1804603682, 7) + iK12;
        int iK14 = k(((iK10 + f(iK13, iK12, iK11)) + this.f13754h[13]) - 40341101, 12) + iK13;
        int iK15 = k(((iK11 + f(iK14, iK13, iK12)) + this.f13754h[14]) - 1502002290, 17) + iK14;
        int iK16 = k(iK12 + f(iK15, iK14, iK13) + this.f13754h[15] + 1236535329, 22) + iK15;
        int iK17 = k(((iK13 + g(iK16, iK15, iK14)) + this.f13754h[1]) - 165796510, 5) + iK16;
        int iK18 = k(((iK14 + g(iK17, iK16, iK15)) + this.f13754h[6]) - 1069501632, 9) + iK17;
        int iK19 = k(iK15 + g(iK18, iK17, iK16) + this.f13754h[11] + 643717713, 14) + iK18;
        int iK20 = k(((iK16 + g(iK19, iK18, iK17)) + this.f13754h[0]) - 373897302, 20) + iK19;
        int iK21 = k(((iK17 + g(iK20, iK19, iK18)) + this.f13754h[5]) - 701558691, 5) + iK20;
        int iK22 = k(iK18 + g(iK21, iK20, iK19) + this.f13754h[10] + 38016083, 9) + iK21;
        int iK23 = k(((iK19 + g(iK22, iK21, iK20)) + this.f13754h[15]) - 660478335, 14) + iK22;
        int iK24 = k(((iK20 + g(iK23, iK22, iK21)) + this.f13754h[4]) - 405537848, 20) + iK23;
        int iK25 = k(iK21 + g(iK24, iK23, iK22) + this.f13754h[9] + 568446438, 5) + iK24;
        int iK26 = k(((iK22 + g(iK25, iK24, iK23)) + this.f13754h[14]) - 1019803690, 9) + iK25;
        int iK27 = k(((iK23 + g(iK26, iK25, iK24)) + this.f13754h[3]) - 187363961, 14) + iK26;
        int iK28 = k(iK24 + g(iK27, iK26, iK25) + this.f13754h[8] + 1163531501, 20) + iK27;
        int iK29 = k(((iK25 + g(iK28, iK27, iK26)) + this.f13754h[13]) - 1444681467, 5) + iK28;
        int iK30 = k(((iK26 + g(iK29, iK28, iK27)) + this.f13754h[2]) - 51403784, 9) + iK29;
        int iK31 = k(iK27 + g(iK30, iK29, iK28) + this.f13754h[7] + 1735328473, 14) + iK30;
        int iK32 = k(((iK28 + g(iK31, iK30, iK29)) + this.f13754h[12]) - 1926607734, 20) + iK31;
        int iK33 = k(((iK29 + h(iK32, iK31, iK30)) + this.f13754h[5]) - 378558, 4) + iK32;
        int iK34 = k(((iK30 + h(iK33, iK32, iK31)) + this.f13754h[8]) - 2022574463, 11) + iK33;
        int iK35 = k(iK31 + h(iK34, iK33, iK32) + this.f13754h[11] + 1839030562, 16) + iK34;
        int iK36 = k(((iK32 + h(iK35, iK34, iK33)) + this.f13754h[14]) - 35309556, 23) + iK35;
        int iK37 = k(((iK33 + h(iK36, iK35, iK34)) + this.f13754h[1]) - 1530992060, 4) + iK36;
        int iK38 = k(iK34 + h(iK37, iK36, iK35) + this.f13754h[4] + 1272893353, 11) + iK37;
        int iK39 = k(((iK35 + h(iK38, iK37, iK36)) + this.f13754h[7]) - 155497632, 16) + iK38;
        int iK40 = k(((iK36 + h(iK39, iK38, iK37)) + this.f13754h[10]) - 1094730640, 23) + iK39;
        int iK41 = k(iK37 + h(iK40, iK39, iK38) + this.f13754h[13] + 681279174, 4) + iK40;
        int iK42 = k(((iK38 + h(iK41, iK40, iK39)) + this.f13754h[0]) - 358537222, 11) + iK41;
        int iK43 = k(((iK39 + h(iK42, iK41, iK40)) + this.f13754h[3]) - 722521979, 16) + iK42;
        int iK44 = k(iK40 + h(iK43, iK42, iK41) + this.f13754h[6] + 76029189, 23) + iK43;
        int iK45 = k(((iK41 + h(iK44, iK43, iK42)) + this.f13754h[9]) - 640364487, 4) + iK44;
        int iK46 = k(((iK42 + h(iK45, iK44, iK43)) + this.f13754h[12]) - 421815835, 11) + iK45;
        int iK47 = k(iK43 + h(iK46, iK45, iK44) + this.f13754h[15] + 530742520, 16) + iK46;
        int iK48 = k(((iK44 + h(iK47, iK46, iK45)) + this.f13754h[2]) - 995338651, 23) + iK47;
        int iK49 = k(((iK45 + i(iK48, iK47, iK46)) + this.f13754h[0]) - 198630844, 6) + iK48;
        int iK50 = k(iK46 + i(iK49, iK48, iK47) + this.f13754h[7] + 1126891415, 10) + iK49;
        int iK51 = k(((iK47 + i(iK50, iK49, iK48)) + this.f13754h[14]) - 1416354905, 15) + iK50;
        int iK52 = k(((iK48 + i(iK51, iK50, iK49)) + this.f13754h[5]) - 57434055, 21) + iK51;
        int iK53 = k(iK49 + i(iK52, iK51, iK50) + this.f13754h[12] + 1700485571, 6) + iK52;
        int iK54 = k(((iK50 + i(iK53, iK52, iK51)) + this.f13754h[3]) - 1894986606, 10) + iK53;
        int iK55 = k(((iK51 + i(iK54, iK53, iK52)) + this.f13754h[10]) - 1051523, 15) + iK54;
        int iK56 = k(((iK52 + i(iK55, iK54, iK53)) + this.f13754h[1]) - 2054922799, 21) + iK55;
        int iK57 = k(iK53 + i(iK56, iK55, iK54) + this.f13754h[8] + 1873313359, 6) + iK56;
        int iK58 = k(((iK54 + i(iK57, iK56, iK55)) + this.f13754h[15]) - 30611744, 10) + iK57;
        int iK59 = k(((iK55 + i(iK58, iK57, iK56)) + this.f13754h[6]) - 1560198380, 15) + iK58;
        int iK60 = k(iK56 + i(iK59, iK58, iK57) + this.f13754h[13] + 1309151649, 21) + iK59;
        int iK61 = k(((iK57 + i(iK60, iK59, iK58)) + this.f13754h[4]) - 145523070, 6) + iK60;
        int iK62 = k(((iK58 + i(iK61, iK60, iK59)) + this.f13754h[11]) - 1120210379, 10) + iK61;
        int iK63 = k(iK59 + i(iK62, iK61, iK60) + this.f13754h[2] + 718787259, 15) + iK62;
        int iK64 = k(((iK60 + i(iK63, iK62, iK61)) + this.f13754h[9]) - 343485551, 21) + iK63;
        this.f13750d += iK61;
        this.f13751e += iK64;
        this.f13752f += iK63;
        this.f13753g += iK62;
        this.f13755i = 0;
        int i6 = 0;
        while (true) {
            int[] iArr = this.f13754h;
            if (i6 == iArr.length) {
                return;
            }
            iArr[i6] = 0;
            i6++;
        }
    }

    @Override // g.a.d.j.a, g.a.j.h
    public g.a.j.h copy() {
        return new d(this);
    }

    @Override // g.a.d.j.a
    public void d(long j) {
        if (this.f13755i > 14) {
            c();
        }
        int[] iArr = this.f13754h;
        iArr[14] = (int) ((-1) & j);
        iArr[15] = (int) (j >>> 32);
    }

    @Override // g.a.d.j.a, g.a.d.e
    public int doFinal(byte[] bArr, int i2) {
        finish();
        l(this.f13750d, bArr, i2);
        l(this.f13751e, bArr, i2 + 4);
        l(this.f13752f, bArr, i2 + 8);
        l(this.f13753g, bArr, i2 + 12);
        reset();
        return 16;
    }

    @Override // g.a.d.j.a
    public void e(byte[] bArr, int i2) {
        int[] iArr = this.f13754h;
        int i3 = this.f13755i;
        int i4 = i3 + 1;
        this.f13755i = i4;
        iArr[i3] = ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        if (i4 == 16) {
            c();
        }
    }

    public final int f(int i2, int i3, int i4) {
        return ((~i2) & i4) | (i3 & i2);
    }

    public final int g(int i2, int i3, int i4) {
        return (i2 & i4) | (i3 & (~i4));
    }

    @Override // g.a.d.j.a, g.a.d.e
    public String getAlgorithmName() {
        return MessageDigestAlgorithms.MD5;
    }

    @Override // g.a.d.j.a, g.a.d.e
    public int getDigestSize() {
        return 16;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[(this.f13755i * 4) + 36];
        super.b(bArr);
        g.a.j.k.intToBigEndian(this.f13750d, bArr, 16);
        g.a.j.k.intToBigEndian(this.f13751e, bArr, 20);
        g.a.j.k.intToBigEndian(this.f13752f, bArr, 24);
        g.a.j.k.intToBigEndian(this.f13753g, bArr, 28);
        g.a.j.k.intToBigEndian(this.f13755i, bArr, 32);
        for (int i2 = 0; i2 != this.f13755i; i2++) {
            g.a.j.k.intToBigEndian(this.f13754h[i2], bArr, (i2 * 4) + 36);
        }
        return bArr;
    }

    public final int h(int i2, int i3, int i4) {
        return (i2 ^ i3) ^ i4;
    }

    public final int i(int i2, int i3, int i4) {
        return (i2 | (~i4)) ^ i3;
    }

    public final void j(d dVar) {
        super.a(dVar);
        this.f13750d = dVar.f13750d;
        this.f13751e = dVar.f13751e;
        this.f13752f = dVar.f13752f;
        this.f13753g = dVar.f13753g;
        int[] iArr = dVar.f13754h;
        System.arraycopy(iArr, 0, this.f13754h, 0, iArr.length);
        this.f13755i = dVar.f13755i;
    }

    public final int k(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    public final void l(int i2, byte[] bArr, int i3) {
        bArr[i3] = (byte) i2;
        bArr[i3 + 1] = (byte) (i2 >>> 8);
        bArr[i3 + 2] = (byte) (i2 >>> 16);
        bArr[i3 + 3] = (byte) (i2 >>> 24);
    }

    @Override // g.a.d.j.a, g.a.d.e
    public void reset() {
        super.reset();
        this.f13750d = 1732584193;
        this.f13751e = -271733879;
        this.f13752f = -1732584194;
        this.f13753g = 271733878;
        this.f13755i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f13754h;
            if (i2 == iArr.length) {
                return;
            }
            iArr[i2] = 0;
            i2++;
        }
    }

    @Override // g.a.d.j.a, g.a.j.h
    public void reset(g.a.j.h hVar) {
        j((d) hVar);
    }
}
