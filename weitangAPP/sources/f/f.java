package f;

import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.annotation.Nullable;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Serializable, Comparable<f> {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f12991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient int f12992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient String f12993d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f12990a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final f EMPTY = of(new byte[0]);

    public f(byte[] bArr) {
        this.f12991b = bArr;
    }

    public static int a(String str, int i2) {
        int length = str.length();
        int iCharCount = 0;
        int i3 = 0;
        while (iCharCount < length) {
            if (i3 == i2) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i3++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }

    public static int b(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    @Nullable
    public static f decodeBase64(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrDecode = b.decode(str);
        if (bArrDecode != null) {
            return new f(bArrDecode);
        }
        return null;
    }

    public static f decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = (byte) ((b(str.charAt(i3)) << 4) + b(str.charAt(i3 + 1)));
        }
        return of(bArr);
    }

    public static f encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        if (charset != null) {
            return new f(str.getBytes(charset));
        }
        throw new IllegalArgumentException("charset == null");
    }

    public static f encodeUtf8(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        f fVar = new f(str.getBytes(v.f13030a));
        fVar.f12993d = str;
        return fVar;
    }

    public static f of(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static f read(InputStream inputStream, int i2) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i2);
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i3, i2 - i3);
            if (i4 == -1) {
                throw new EOFException();
            }
            i3 += i4;
        }
        return new f(bArr);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        f fVar = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = f.class.getDeclaredField(OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE);
            declaredField.setAccessible(true);
            declaredField.set(this, fVar.f12991b);
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        } catch (NoSuchFieldException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f12991b.length);
        objectOutputStream.write(this.f12991b);
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.f12991b).asReadOnlyBuffer();
    }

    public String base64() {
        return b.encode(this.f12991b);
    }

    public String base64Url() {
        return b.encodeUrl(this.f12991b);
    }

    public final f c(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.f12991b));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public final f d(String str, f fVar) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(fVar.toByteArray(), str));
            return of(mac.doFinal(this.f12991b));
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new AssertionError(e3);
        }
    }

    public byte[] e() {
        return this.f12991b;
    }

    public final boolean endsWith(f fVar) {
        return rangeEquals(size() - fVar.size(), fVar, 0, fVar.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int size = fVar.size();
            byte[] bArr = this.f12991b;
            if (size == bArr.length && fVar.rangeEquals(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public void f(c cVar) {
        byte[] bArr = this.f12991b;
        cVar.write(bArr, 0, bArr.length);
    }

    public byte getByte(int i2) {
        return this.f12991b[i2];
    }

    public int hashCode() {
        int i2 = this.f12992c;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.f12991b);
        this.f12992c = iHashCode;
        return iHashCode;
    }

    public String hex() {
        byte[] bArr = this.f12991b;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f12990a;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public f hmacSha1(f fVar) {
        return d("HmacSHA1", fVar);
    }

    public f hmacSha256(f fVar) {
        return d("HmacSHA256", fVar);
    }

    public f hmacSha512(f fVar) {
        return d("HmacSHA512", fVar);
    }

    public final int indexOf(f fVar) {
        return indexOf(fVar.e(), 0);
    }

    public final int lastIndexOf(f fVar) {
        return lastIndexOf(fVar.e(), size());
    }

    public f md5() {
        return c(MessageDigestAlgorithms.MD5);
    }

    public boolean rangeEquals(int i2, f fVar, int i3, int i4) {
        return fVar.rangeEquals(i3, this.f12991b, i2, i4);
    }

    public f sha1() {
        return c(MessageDigestAlgorithms.SHA_1);
    }

    public f sha256() {
        return c(MessageDigestAlgorithms.SHA_256);
    }

    public f sha512() {
        return c(MessageDigestAlgorithms.SHA_512);
    }

    public int size() {
        return this.f12991b.length;
    }

    public final boolean startsWith(f fVar) {
        return rangeEquals(0, fVar, 0, fVar.size());
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.f12991b, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public f substring(int i2) {
        return substring(i2, this.f12991b.length);
    }

    public f toAsciiLowercase() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f12991b;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i3] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr2);
            }
            i2++;
        }
    }

    public f toAsciiUppercase() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f12991b;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 >= 97 && b2 <= 122) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 - 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 97 && b3 <= 122) {
                        bArr2[i3] = (byte) (b3 - 32);
                    }
                }
                return new f(bArr2);
            }
            i2++;
        }
    }

    public byte[] toByteArray() {
        return (byte[]) this.f12991b.clone();
    }

    public String toString() {
        if (this.f12991b.length == 0) {
            return "[size=0]";
        }
        String strUtf8 = utf8();
        int iA = a(strUtf8, 64);
        if (iA == -1) {
            if (this.f12991b.length <= 64) {
                return "[hex=" + hex() + "]";
            }
            return "[size=" + this.f12991b.length + " hex=" + substring(0, 64).hex() + "…]";
        }
        String strReplace = strUtf8.substring(0, iA).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iA >= strUtf8.length()) {
            return "[text=" + strReplace + "]";
        }
        return "[size=" + this.f12991b.length + " text=" + strReplace + "…]";
    }

    public String utf8() {
        String str = this.f12993d;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f12991b, v.f13030a);
        this.f12993d = str2;
        return str2;
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.f12991b);
    }

    @Override // java.lang.Comparable
    public int compareTo(f fVar) {
        int size = size();
        int size2 = fVar.size();
        int iMin = Math.min(size, size2);
        for (int i2 = 0; i2 < iMin; i2++) {
            int i3 = getByte(i2) & 255;
            int i4 = fVar.getByte(i2) & 255;
            if (i3 != i4) {
                return i3 < i4 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(f fVar, int i2) {
        return indexOf(fVar.e(), i2);
    }

    public final int lastIndexOf(f fVar, int i2) {
        return lastIndexOf(fVar.e(), i2);
    }

    public boolean rangeEquals(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.f12991b;
            if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && v.arrayRangeEquals(bArr2, i2, bArr, i3, i4)) {
                return true;
            }
        }
        return false;
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public f substring(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f12991b;
        if (i3 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.f12991b.length + ")");
        }
        int i4 = i3 - i2;
        if (i4 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i2 == 0 && i3 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i2, bArr2, 0, i4);
        return new f(bArr2);
    }

    public static f of(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            v.checkOffsetAndCount(bArr.length, i2, i3);
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return new f(bArr2);
        }
        throw new IllegalArgumentException("data == null");
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    public int indexOf(byte[] bArr, int i2) {
        int length = this.f12991b.length - bArr.length;
        for (int iMax = Math.max(i2, 0); iMax <= length; iMax++) {
            if (v.arrayRangeEquals(this.f12991b, iMax, bArr, 0, bArr.length)) {
                return iMax;
            }
        }
        return -1;
    }

    public int lastIndexOf(byte[] bArr, int i2) {
        for (int iMin = Math.min(i2, this.f12991b.length - bArr.length); iMin >= 0; iMin--) {
            if (v.arrayRangeEquals(this.f12991b, iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public static f of(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new f(bArr);
        }
        throw new IllegalArgumentException("data == null");
    }
}
