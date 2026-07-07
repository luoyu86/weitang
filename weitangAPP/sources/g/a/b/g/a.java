package g.a.b.g;

import g.a.a.y3.l;
import g.a.j.k;
import java.io.IOException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: g.a.b.g.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0251a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public byte[] f13604a = new byte[4];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13605b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f13606c;

        public abstract void a();

        public abstract void b(long j);

        public abstract void c(byte[] bArr, int i2);

        public void finish() {
            long j = this.f13606c << 3;
            byte b2 = -128;
            while (true) {
                update(b2);
                if (this.f13605b == 0) {
                    b(j);
                    a();
                    return;
                }
                b2 = 0;
            }
        }

        public void reset() {
            this.f13606c = 0L;
            this.f13605b = 0;
            int i2 = 0;
            while (true) {
                byte[] bArr = this.f13604a;
                if (i2 >= bArr.length) {
                    return;
                }
                bArr[i2] = 0;
                i2++;
            }
        }

        public void update(byte b2) {
            byte[] bArr = this.f13604a;
            int i2 = this.f13605b;
            int i3 = i2 + 1;
            this.f13605b = i3;
            bArr[i2] = b2;
            if (i3 == bArr.length) {
                c(bArr, 0);
                this.f13605b = 0;
            }
            this.f13606c++;
        }

        public void update(byte[] bArr, int i2, int i3) {
            while (this.f13605b != 0 && i3 > 0) {
                update(bArr[i2]);
                i2++;
                i3--;
            }
            while (i3 > this.f13604a.length) {
                c(bArr, i2);
                byte[] bArr2 = this.f13604a;
                i2 += bArr2.length;
                i3 -= bArr2.length;
                this.f13606c += (long) bArr2.length;
            }
            while (i3 > 0) {
                update(bArr[i2]);
                i2++;
                i3--;
            }
        }
    }

    public static class b extends AbstractC0251a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13608e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f13609f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f13610g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f13611h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int[] f13612i = new int[80];
        public int j;

        public b() {
            reset();
        }

        @Override // g.a.b.g.a.AbstractC0251a
        public void a() {
            for (int i2 = 16; i2 < 80; i2++) {
                int[] iArr = this.f13612i;
                int i3 = ((iArr[i2 - 3] ^ iArr[i2 - 8]) ^ iArr[i2 - 14]) ^ iArr[i2 - 16];
                iArr[i2] = (i3 >>> 31) | (i3 << 1);
            }
            int iF = this.f13607d;
            int iF2 = this.f13608e;
            int i4 = this.f13609f;
            int i5 = this.f13610g;
            int i6 = this.f13611h;
            int i7 = 0;
            int i8 = 0;
            while (i7 < 4) {
                int i9 = i8 + 1;
                int iD = i6 + ((iF << 5) | (iF >>> 27)) + d(iF2, i4, i5) + this.f13612i[i8] + 1518500249;
                int i10 = (iF2 >>> 2) | (iF2 << 30);
                int i11 = i9 + 1;
                int iD2 = i5 + ((iD << 5) | (iD >>> 27)) + d(iF, i10, i4) + this.f13612i[i9] + 1518500249;
                int i12 = (iF >>> 2) | (iF << 30);
                int i13 = i11 + 1;
                int iD3 = i4 + ((iD2 << 5) | (iD2 >>> 27)) + d(iD, i12, i10) + this.f13612i[i11] + 1518500249;
                i6 = (iD >>> 2) | (iD << 30);
                int i14 = i13 + 1;
                iF2 = i10 + ((iD3 << 5) | (iD3 >>> 27)) + d(iD2, i6, i12) + this.f13612i[i13] + 1518500249;
                i5 = (iD2 >>> 2) | (iD2 << 30);
                iF = i12 + ((iF2 << 5) | (iF2 >>> 27)) + d(iD3, i5, i6) + this.f13612i[i14] + 1518500249;
                i4 = (iD3 >>> 2) | (iD3 << 30);
                i7++;
                i8 = i14 + 1;
            }
            int i15 = 0;
            while (i15 < 4) {
                int i16 = i8 + 1;
                int iF3 = i6 + ((iF << 5) | (iF >>> 27)) + f(iF2, i4, i5) + this.f13612i[i8] + 1859775393;
                int i17 = (iF2 >>> 2) | (iF2 << 30);
                int i18 = i16 + 1;
                int iF4 = i5 + ((iF3 << 5) | (iF3 >>> 27)) + f(iF, i17, i4) + this.f13612i[i16] + 1859775393;
                int i19 = (iF >>> 2) | (iF << 30);
                int i20 = i18 + 1;
                int iF5 = i4 + ((iF4 << 5) | (iF4 >>> 27)) + f(iF3, i19, i17) + this.f13612i[i18] + 1859775393;
                i6 = (iF3 >>> 2) | (iF3 << 30);
                int i21 = i20 + 1;
                iF2 = i17 + ((iF5 << 5) | (iF5 >>> 27)) + f(iF4, i6, i19) + this.f13612i[i20] + 1859775393;
                i5 = (iF4 >>> 2) | (iF4 << 30);
                iF = i19 + ((iF2 << 5) | (iF2 >>> 27)) + f(iF5, i5, i6) + this.f13612i[i21] + 1859775393;
                i4 = (iF5 >>> 2) | (iF5 << 30);
                i15++;
                i8 = i21 + 1;
            }
            int i22 = 0;
            while (i22 < 4) {
                int iE = i6 + (((((iF << 5) | (iF >>> 27)) + e(iF2, i4, i5)) + this.f13612i[i8]) - 1894007588);
                int iE2 = i5 + (((((iE << 5) | (iE >>> 27)) + e(iF, r2, i4)) + this.f13612i[r12]) - 1894007588);
                int iE3 = i4 + (((((iE2 << 5) | (iE2 >>> 27)) + e(iE, r1, r2)) + this.f13612i[r13]) - 1894007588);
                i6 = (iE >>> 2) | (iE << 30);
                iF2 = ((iF2 >>> 2) | (iF2 << 30)) + (((((iE3 << 5) | (iE3 >>> 27)) + e(iE2, i6, r1)) + this.f13612i[r12]) - 1894007588);
                i5 = (iE2 >>> 2) | (iE2 << 30);
                iF = ((iF >>> 2) | (iF << 30)) + (((((iF2 << 5) | (iF2 >>> 27)) + e(iE3, i5, i6)) + this.f13612i[r13]) - 1894007588);
                i4 = (iE3 >>> 2) | (iE3 << 30);
                i22++;
                i8 = i8 + 1 + 1 + 1 + 1 + 1;
            }
            int i23 = 0;
            while (i23 <= 3) {
                int iF6 = i6 + (((((iF << 5) | (iF >>> 27)) + f(iF2, i4, i5)) + this.f13612i[i8]) - 899497514);
                int iF7 = i5 + (((((iF6 << 5) | (iF6 >>> 27)) + f(iF, r2, i4)) + this.f13612i[r11]) - 899497514);
                int iF8 = i4 + (((((iF7 << 5) | (iF7 >>> 27)) + f(iF6, r1, r2)) + this.f13612i[r12]) - 899497514);
                i6 = (iF6 >>> 2) | (iF6 << 30);
                iF2 = ((iF2 >>> 2) | (iF2 << 30)) + (((((iF8 << 5) | (iF8 >>> 27)) + f(iF7, i6, r1)) + this.f13612i[r11]) - 899497514);
                i5 = (iF7 >>> 2) | (iF7 << 30);
                iF = ((iF >>> 2) | (iF << 30)) + (((((iF2 << 5) | (iF2 >>> 27)) + f(iF8, i5, i6)) + this.f13612i[r12]) - 899497514);
                i4 = (iF8 >>> 2) | (iF8 << 30);
                i23++;
                i8 = i8 + 1 + 1 + 1 + 1 + 1;
            }
            this.f13607d += iF;
            this.f13608e += iF2;
            this.f13609f += i4;
            this.f13610g += i5;
            this.f13611h += i6;
            this.j = 0;
            for (int i24 = 0; i24 < 16; i24++) {
                this.f13612i[i24] = 0;
            }
        }

        @Override // g.a.b.g.a.AbstractC0251a
        public void b(long j) {
            if (this.j > 14) {
                a();
            }
            int[] iArr = this.f13612i;
            iArr[14] = (int) (j >>> 32);
            iArr[15] = (int) (j & (-1));
        }

        @Override // g.a.b.g.a.AbstractC0251a
        public void c(byte[] bArr, int i2) {
            int i3 = bArr[i2] << 24;
            int i4 = i2 + 1;
            int i5 = i3 | ((bArr[i4] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = (bArr[i6 + 1] & 255) | i5 | ((bArr[i6] & 255) << 8);
            int[] iArr = this.f13612i;
            int i8 = this.j;
            iArr[i8] = i7;
            int i9 = i8 + 1;
            this.j = i9;
            if (i9 == 16) {
                a();
            }
        }

        public final int d(int i2, int i3, int i4) {
            return ((~i2) & i4) | (i3 & i2);
        }

        public int doFinal(byte[] bArr, int i2) {
            finish();
            k.intToBigEndian(this.f13607d, bArr, i2);
            k.intToBigEndian(this.f13608e, bArr, i2 + 4);
            k.intToBigEndian(this.f13609f, bArr, i2 + 8);
            k.intToBigEndian(this.f13610g, bArr, i2 + 12);
            k.intToBigEndian(this.f13611h, bArr, i2 + 16);
            reset();
            return 20;
        }

        public final int e(int i2, int i3, int i4) {
            return (i2 & i4) | (i2 & i3) | (i3 & i4);
        }

        public final int f(int i2, int i3, int i4) {
            return (i2 ^ i3) ^ i4;
        }

        public String getAlgorithmName() {
            return MessageDigestAlgorithms.SHA_1;
        }

        public int getDigestSize() {
            return 20;
        }

        @Override // g.a.b.g.a.AbstractC0251a
        public void reset() {
            super.reset();
            this.f13607d = 1732584193;
            this.f13608e = -271733879;
            this.f13609f = -1732584194;
            this.f13610g = 271733878;
            this.f13611h = -1009589776;
            this.j = 0;
            int i2 = 0;
            while (true) {
                int[] iArr = this.f13612i;
                if (i2 == iArr.length) {
                    return;
                }
                iArr[i2] = 0;
                i2++;
            }
        }
    }

    public static byte[] a(l lVar) {
        b bVar = new b();
        byte[] bArr = new byte[bVar.getDigestSize()];
        try {
            byte[] encoded = lVar.getEncoded("DER");
            bVar.update(encoded, 0, encoded.length);
            bVar.doFinal(bArr, 0);
            return bArr;
        } catch (IOException unused) {
            return new byte[0];
        }
    }
}
