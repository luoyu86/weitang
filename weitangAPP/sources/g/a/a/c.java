package g.a.a;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends a0 implements i0, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13048a = new a(c.class, 3);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f13049b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13050c;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 c(d0 d0Var) {
            return d0Var.i();
        }

        @Override // g.a.a.r0
        public a0 d(x1 x1Var) {
            return c.g(x1Var.getOctets());
        }
    }

    public c(byte b2, int i2) {
        if (i2 > 7 || i2 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.f13050c = new byte[]{(byte) i2, b2};
    }

    public c(byte[] bArr, int i2) {
        Objects.requireNonNull(bArr, "'data' cannot be null");
        if (bArr.length == 0 && i2 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i2 > 7 || i2 < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.f13050c = g.a.j.a.prepend(bArr, (byte) i2);
    }

    public c(byte[] bArr, boolean z) {
        if (z) {
            Objects.requireNonNull(bArr, "'contents' cannot be null");
            if (bArr.length < 1) {
                throw new IllegalArgumentException("'contents' cannot be empty");
            }
            int i2 = bArr[0] & 255;
            if (i2 > 0) {
                if (bArr.length < 2) {
                    throw new IllegalArgumentException("zero length data with non-zero pad bits");
                }
                if (i2 > 7) {
                    throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                }
            }
        }
        this.f13050c = bArr;
    }

    public static c g(byte[] bArr) {
        int length = bArr.length;
        if (length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int i2 = bArr[0] & 255;
        if (i2 > 0) {
            if (i2 > 7 || length < 2) {
                throw new IllegalArgumentException("invalid pad bits detected");
            }
            byte b2 = bArr[length - 1];
            if (b2 != ((byte) ((255 << i2) & b2))) {
                return new l2(bArr, false);
            }
        }
        return new n1(bArr, false);
    }

    public static c getInstance(l0 l0Var, boolean z) {
        return (c) f13048a.e(l0Var, z);
    }

    public static c getInstance(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof c) {
                return (c) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (c) f13048a.b((byte[]) obj);
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct BIT STRING from byte[]: " + e2.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static byte[] h(int i2) {
        if (i2 == 0) {
            return new byte[0];
        }
        int i3 = 4;
        for (int i4 = 3; i4 >= 1 && ((255 << (i4 * 8)) & i2) == 0; i4--) {
            i3--;
        }
        byte[] bArr = new byte[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = (byte) ((i2 >> (i5 * 8)) & 255);
        }
        return bArr;
    }

    public static int i(int i2) {
        int i3;
        int i4 = 3;
        while (true) {
            if (i4 < 0) {
                i3 = 0;
                break;
            }
            if (i4 != 0) {
                int i5 = i2 >> (i4 * 8);
                if (i5 != 0) {
                    i3 = i5 & 255;
                    break;
                }
                i4--;
            } else {
                if (i2 != 0) {
                    i3 = i2 & 255;
                    break;
                }
                i4--;
            }
        }
        if (i3 == 0) {
            return 0;
        }
        int i6 = 1;
        while (true) {
            i3 <<= 1;
            if ((i3 & 255) == 0) {
                return 8 - i6;
            }
            i6++;
        }
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (!(a0Var instanceof c)) {
            return false;
        }
        byte[] bArr = this.f13050c;
        byte[] bArr2 = ((c) a0Var).f13050c;
        int length = bArr.length;
        if (bArr2.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i2 = length - 1;
        for (int i3 = 0; i3 < i2; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        int i4 = 255 << (bArr[0] & 255);
        return ((byte) (bArr[i2] & i4)) == ((byte) (bArr2[i2] & i4));
    }

    @Override // g.a.a.a0
    public a0 e() {
        return new n1(this.f13050c, false);
    }

    @Override // g.a.a.a0
    public a0 f() {
        return new l2(this.f13050c, false);
    }

    @Override // g.a.a.d
    public InputStream getBitStream() throws IOException {
        byte[] bArr = this.f13050c;
        return new ByteArrayInputStream(bArr, 1, bArr.length - 1);
    }

    public byte[] getBytes() {
        byte[] bArr = this.f13050c;
        if (bArr.length == 1) {
            return w.f13392b;
        }
        int i2 = bArr[0] & 255;
        byte[] bArrCopyOfRange = g.a.j.a.copyOfRange(bArr, 1, bArr.length);
        int length = bArrCopyOfRange.length - 1;
        bArrCopyOfRange[length] = (byte) (((byte) (255 << i2)) & bArrCopyOfRange[length]);
        return bArrCopyOfRange;
    }

    @Override // g.a.a.d, g.a.a.y2
    public a0 getLoadedObject() {
        return toASN1Primitive();
    }

    @Override // g.a.a.d
    public InputStream getOctetStream() throws IOException {
        int i2 = this.f13050c[0] & 255;
        if (i2 == 0) {
            return getBitStream();
        }
        throw new IOException("expected octet-aligned bitstring, but found padBits: " + i2);
    }

    public byte[] getOctets() {
        byte[] bArr = this.f13050c;
        if (bArr[0] == 0) {
            return g.a.j.a.copyOfRange(bArr, 1, bArr.length);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    @Override // g.a.a.d
    public int getPadBits() {
        return this.f13050c[0] & 255;
    }

    @Override // g.a.a.i0
    public String getString() {
        try {
            byte[] encoded = getEncoded();
            StringBuffer stringBuffer = new StringBuffer((encoded.length * 2) + 1);
            stringBuffer.append('#');
            for (int i2 = 0; i2 != encoded.length; i2++) {
                byte b2 = encoded[i2];
                char[] cArr = f13049b;
                stringBuffer.append(cArr[(b2 >>> 4) & 15]);
                stringBuffer.append(cArr[b2 & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e2) {
            throw new z("Internal error encoding BitString: " + e2.getMessage(), e2);
        }
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        byte[] bArr = this.f13050c;
        if (bArr.length < 2) {
            return 1;
        }
        int i2 = bArr[0] & 255;
        int length = bArr.length - 1;
        return (g.a.j.a.hashCode(bArr, 0, length) * InputDeviceCompat.SOURCE_KEYBOARD) ^ ((byte) (bArr[length] & (255 << i2)));
    }

    public int intValue() {
        int iMin = Math.min(5, this.f13050c.length - 1);
        int i2 = 0;
        for (int i3 = 1; i3 < iMin; i3++) {
            i2 |= (255 & this.f13050c[i3]) << ((i3 - 1) * 8);
        }
        if (1 > iMin || iMin >= 5) {
            return i2;
        }
        byte[] bArr = this.f13050c;
        return i2 | ((((byte) (bArr[iMin] & (255 << (bArr[0] & 255)))) & 255) << ((iMin - 1) * 8));
    }

    public d parser() {
        return this;
    }

    public String toString() {
        return getString();
    }
}
