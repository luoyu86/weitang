package org.apache.commons.codec.binary;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* JADX INFO: loaded from: classes2.dex */
public class Hex implements BinaryEncoder, BinaryDecoder {
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    private final Charset charset;
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public Hex() {
        this.charset = DEFAULT_CHARSET;
    }

    public static byte[] decodeHex(char[] cArr) throws DecoderException {
        byte[] bArr = new byte[cArr.length >> 1];
        decodeHex(cArr, bArr, 0);
        return bArr;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, true);
    }

    public static String encodeHexString(byte[] bArr) {
        return new String(encodeHex(bArr));
    }

    private static byte[] toByteArray(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (byteBuffer.hasArray()) {
            byte[] bArrArray = byteBuffer.array();
            if (iRemaining == bArrArray.length) {
                byteBuffer.position(iRemaining);
                return bArrArray;
            }
        }
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr);
        return bArr;
    }

    public static int toDigit(char c2, int i2) throws DecoderException {
        int iDigit = Character.digit(c2, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new DecoderException("Illegal hexadecimal character " + c2 + " at index " + i2);
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        return decodeHex(new String(bArr, getCharset()).toCharArray());
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return encodeHexString(bArr).getBytes(getCharset());
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getCharsetName() {
        return this.charset.name();
    }

    public String toString() {
        return super.toString() + "[charsetName=" + this.charset + "]";
    }

    public static char[] encodeHex(byte[] bArr, boolean z) {
        return encodeHex(bArr, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public static String encodeHexString(byte[] bArr, boolean z) {
        return new String(encodeHex(bArr, z));
    }

    public byte[] decode(ByteBuffer byteBuffer) throws DecoderException {
        return decodeHex(new String(toByteArray(byteBuffer), getCharset()).toCharArray());
    }

    public byte[] encode(ByteBuffer byteBuffer) {
        return encodeHexString(byteBuffer).getBytes(getCharset());
    }

    public Hex(Charset charset) {
        this.charset = charset;
    }

    public static int decodeHex(char[] cArr, byte[] bArr, int i2) throws DecoderException {
        int length = cArr.length;
        if ((length & 1) == 0) {
            int i3 = length >> 1;
            if (bArr.length - i2 < i3) {
                throw new DecoderException("Output array is not large enough to accommodate decoded data.");
            }
            int i4 = 0;
            while (i4 < length) {
                int digit = toDigit(cArr[i4], i4) << 4;
                int i5 = i4 + 1;
                int digit2 = digit | toDigit(cArr[i5], i5);
                i4 = i5 + 1;
                bArr[i2] = (byte) (digit2 & 255);
                i2++;
            }
            return i3;
        }
        throw new DecoderException("Odd number of characters.");
    }

    public static char[] encodeHex(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        encodeHex(bArr, 0, bArr.length, cArr, cArr2, 0);
        return cArr2;
    }

    public static String encodeHexString(ByteBuffer byteBuffer) {
        return new String(encodeHex(byteBuffer));
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof String) {
            return decode(((String) obj).toCharArray());
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof ByteBuffer) {
            return decode((ByteBuffer) obj);
        }
        try {
            return decodeHex((char[]) obj);
        } catch (ClassCastException e2) {
            throw new DecoderException(e2.getMessage(), e2);
        }
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        byte[] byteArray;
        if (obj instanceof String) {
            byteArray = ((String) obj).getBytes(getCharset());
        } else if (obj instanceof ByteBuffer) {
            byteArray = toByteArray((ByteBuffer) obj);
        } else {
            try {
                byteArray = (byte[]) obj;
            } catch (ClassCastException e2) {
                throw new EncoderException(e2.getMessage(), e2);
            }
        }
        return encodeHex(byteArray);
    }

    public static String encodeHexString(ByteBuffer byteBuffer, boolean z) {
        return new String(encodeHex(byteBuffer, z));
    }

    public Hex(String str) {
        this(Charset.forName(str));
    }

    public static char[] encodeHex(byte[] bArr, int i2, int i3, boolean z) {
        char[] cArr = new char[i3 << 1];
        encodeHex(bArr, i2, i3, z ? DIGITS_LOWER : DIGITS_UPPER, cArr, 0);
        return cArr;
    }

    public static void encodeHex(byte[] bArr, int i2, int i3, boolean z, char[] cArr, int i4) {
        encodeHex(bArr, i2, i3, z ? DIGITS_LOWER : DIGITS_UPPER, cArr, i4);
    }

    private static void encodeHex(byte[] bArr, int i2, int i3, char[] cArr, char[] cArr2, int i4) {
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            int i6 = i4 + 1;
            cArr2[i4] = cArr[(bArr[i5] & 240) >>> 4];
            i4 = i6 + 1;
            cArr2[i6] = cArr[bArr[i5] & 15];
        }
    }

    public static byte[] decodeHex(String str) throws DecoderException {
        return decodeHex(str.toCharArray());
    }

    public static char[] encodeHex(ByteBuffer byteBuffer) {
        return encodeHex(byteBuffer, true);
    }

    public static char[] encodeHex(ByteBuffer byteBuffer, boolean z) {
        return encodeHex(byteBuffer, z ? DIGITS_LOWER : DIGITS_UPPER);
    }

    public static char[] encodeHex(ByteBuffer byteBuffer, char[] cArr) {
        return encodeHex(toByteArray(byteBuffer), cArr);
    }
}
