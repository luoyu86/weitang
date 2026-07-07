package g.a.i.d.a;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f14639a;

    public l(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("invalid length");
        }
        this.f14639a = new int[i2];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            this.f14639a[i3] = i3;
        }
    }

    public l(int i2, SecureRandom secureRandom) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("invalid length");
        }
        this.f14639a = new int[i2];
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = i3;
        }
        int i4 = i2;
        for (int i5 = 0; i5 < i2; i5++) {
            int iA = p.a(secureRandom, i4);
            i4--;
            this.f14639a[i5] = iArr[iA];
            iArr[iA] = iArr[i4];
        }
    }

    public l(byte[] bArr) {
        if (bArr.length <= 4) {
            throw new IllegalArgumentException("invalid encoding");
        }
        int iOS2IP = j.OS2IP(bArr, 0);
        int iCeilLog256 = i.ceilLog256(iOS2IP - 1);
        if (bArr.length != (iOS2IP * iCeilLog256) + 4) {
            throw new IllegalArgumentException("invalid encoding");
        }
        this.f14639a = new int[iOS2IP];
        for (int i2 = 0; i2 < iOS2IP; i2++) {
            this.f14639a[i2] = j.OS2IP(bArr, (i2 * iCeilLog256) + 4, iCeilLog256);
        }
        if (!a(this.f14639a)) {
            throw new IllegalArgumentException("invalid encoding");
        }
    }

    public l(int[] iArr) {
        if (!a(iArr)) {
            throw new IllegalArgumentException("array is not a permutation vector");
        }
        this.f14639a = h.clone(iArr);
    }

    public final boolean a(int[] iArr) {
        int length = iArr.length;
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            if (iArr[i2] < 0 || iArr[i2] >= length || zArr[iArr[i2]]) {
                return false;
            }
            zArr[iArr[i2]] = true;
        }
        return true;
    }

    public l computeInverse() {
        l lVar = new l(this.f14639a.length);
        for (int length = this.f14639a.length - 1; length >= 0; length--) {
            lVar.f14639a[this.f14639a[length]] = length;
        }
        return lVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            return h.equals(this.f14639a, ((l) obj).f14639a);
        }
        return false;
    }

    public byte[] getEncoded() {
        int length = this.f14639a.length;
        int iCeilLog256 = i.ceilLog256(length - 1);
        byte[] bArr = new byte[(length * iCeilLog256) + 4];
        j.I2OSP(length, bArr, 0);
        for (int i2 = 0; i2 < length; i2++) {
            j.I2OSP(this.f14639a[i2], bArr, (i2 * iCeilLog256) + 4, iCeilLog256);
        }
        return bArr;
    }

    public int[] getVector() {
        return h.clone(this.f14639a);
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f14639a);
    }

    public l rightMultiply(l lVar) {
        int length = lVar.f14639a.length;
        int[] iArr = this.f14639a;
        if (length != iArr.length) {
            throw new IllegalArgumentException("length mismatch");
        }
        l lVar2 = new l(iArr.length);
        for (int length2 = this.f14639a.length - 1; length2 >= 0; length2--) {
            lVar2.f14639a[length2] = this.f14639a[lVar.f14639a[length2]];
        }
        return lVar2;
    }

    public String toString() {
        String str = "[" + this.f14639a[0];
        for (int i2 = 1; i2 < this.f14639a.length; i2++) {
            str = str + ", " + this.f14639a[i2];
        }
        return str + "]";
    }
}
