package f;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final transient byte[][] f13028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int[] f13029f;

    public r(c cVar, int i2) {
        super(null);
        v.checkOffsetAndCount(cVar.f12980c, 0L, i2);
        p pVar = cVar.f12979b;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = pVar.f13021c;
            int i7 = pVar.f13020b;
            if (i6 == i7) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += i6 - i7;
            i5++;
            pVar = pVar.f13024f;
        }
        this.f13028e = new byte[i5][];
        this.f13029f = new int[i5 * 2];
        p pVar2 = cVar.f12979b;
        int i8 = 0;
        while (i3 < i2) {
            byte[][] bArr = this.f13028e;
            bArr[i8] = pVar2.f13019a;
            int i9 = pVar2.f13021c;
            int i10 = pVar2.f13020b;
            i3 += i9 - i10;
            if (i3 > i2) {
                i3 = i2;
            }
            int[] iArr = this.f13029f;
            iArr[i8] = i3;
            iArr[bArr.length + i8] = i10;
            pVar2.f13022d = true;
            i8++;
            pVar2 = pVar2.f13024f;
        }
    }

    private Object writeReplace() {
        return h();
    }

    @Override // f.f
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // f.f
    public String base64() {
        return h().base64();
    }

    @Override // f.f
    public String base64Url() {
        return h().base64Url();
    }

    @Override // f.f
    public byte[] e() {
        return toByteArray();
    }

    @Override // f.f
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (fVar.size() == size() && rangeEquals(0, fVar, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // f.f
    public void f(c cVar) {
        int length = this.f13028e.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f13029f;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            p pVar = new p(this.f13028e[i2], i4, (i4 + i5) - i3, true, false);
            p pVar2 = cVar.f12979b;
            if (pVar2 == null) {
                pVar.f13025g = pVar;
                pVar.f13024f = pVar;
                cVar.f12979b = pVar;
            } else {
                pVar2.f13025g.push(pVar);
            }
            i2++;
            i3 = i5;
        }
        cVar.f12980c += (long) i3;
    }

    public final int g(int i2) {
        int iBinarySearch = Arrays.binarySearch(this.f13029f, 0, this.f13028e.length, i2 + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // f.f
    public byte getByte(int i2) {
        v.checkOffsetAndCount(this.f13029f[this.f13028e.length - 1], i2, 1L);
        int iG = g(i2);
        int i3 = iG == 0 ? 0 : this.f13029f[iG - 1];
        int[] iArr = this.f13029f;
        byte[][] bArr = this.f13028e;
        return bArr[iG][(i2 - i3) + iArr[bArr.length + iG]];
    }

    public final f h() {
        return new f(toByteArray());
    }

    @Override // f.f
    public int hashCode() {
        int i2 = this.f12992c;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f13028e.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.f13028e[i3];
            int[] iArr = this.f13029f;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i4) + i6;
            while (i6 < i8) {
                i5 = (i5 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i4 = i7;
        }
        this.f12992c = i5;
        return i5;
    }

    @Override // f.f
    public String hex() {
        return h().hex();
    }

    @Override // f.f
    public f hmacSha1(f fVar) {
        return h().hmacSha1(fVar);
    }

    @Override // f.f
    public f hmacSha256(f fVar) {
        return h().hmacSha256(fVar);
    }

    @Override // f.f
    public int indexOf(byte[] bArr, int i2) {
        return h().indexOf(bArr, i2);
    }

    @Override // f.f
    public int lastIndexOf(byte[] bArr, int i2) {
        return h().lastIndexOf(bArr, i2);
    }

    @Override // f.f
    public f md5() {
        return h().md5();
    }

    @Override // f.f
    public boolean rangeEquals(int i2, f fVar, int i3, int i4) {
        if (i2 < 0 || i2 > size() - i4) {
            return false;
        }
        int iG = g(i2);
        while (i4 > 0) {
            int i5 = iG == 0 ? 0 : this.f13029f[iG - 1];
            int iMin = Math.min(i4, ((this.f13029f[iG] - i5) + i5) - i2);
            int[] iArr = this.f13029f;
            byte[][] bArr = this.f13028e;
            if (!fVar.rangeEquals(i3, bArr[iG], (i2 - i5) + iArr[bArr.length + iG], iMin)) {
                return false;
            }
            i2 += iMin;
            i3 += iMin;
            i4 -= iMin;
            iG++;
        }
        return true;
    }

    @Override // f.f
    public f sha1() {
        return h().sha1();
    }

    @Override // f.f
    public f sha256() {
        return h().sha256();
    }

    @Override // f.f
    public int size() {
        return this.f13029f[this.f13028e.length - 1];
    }

    @Override // f.f
    public String string(Charset charset) {
        return h().string(charset);
    }

    @Override // f.f
    public f substring(int i2) {
        return h().substring(i2);
    }

    @Override // f.f
    public f toAsciiLowercase() {
        return h().toAsciiLowercase();
    }

    @Override // f.f
    public f toAsciiUppercase() {
        return h().toAsciiUppercase();
    }

    @Override // f.f
    public byte[] toByteArray() {
        int[] iArr = this.f13029f;
        byte[][] bArr = this.f13028e;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f13029f;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f13028e[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // f.f
    public String toString() {
        return h().toString();
    }

    @Override // f.f
    public String utf8() {
        return h().utf8();
    }

    @Override // f.f
    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.f13028e.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f13029f;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            outputStream.write(this.f13028e[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
    }

    @Override // f.f
    public f substring(int i2, int i3) {
        return h().substring(i2, i3);
    }

    @Override // f.f
    public boolean rangeEquals(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int iG = g(i2);
        while (i4 > 0) {
            int i5 = iG == 0 ? 0 : this.f13029f[iG - 1];
            int iMin = Math.min(i4, ((this.f13029f[iG] - i5) + i5) - i2);
            int[] iArr = this.f13029f;
            byte[][] bArr2 = this.f13028e;
            if (!v.arrayRangeEquals(bArr2[iG], (i2 - i5) + iArr[bArr2.length + iG], bArr, i3, iMin)) {
                return false;
            }
            i2 += iMin;
            i3 += iMin;
            i4 -= iMin;
            iG++;
        }
        return true;
    }
}
