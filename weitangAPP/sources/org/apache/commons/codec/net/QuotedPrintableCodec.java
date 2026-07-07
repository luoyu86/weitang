package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

/* JADX INFO: loaded from: classes2.dex */
public class QuotedPrintableCodec implements BinaryEncoder, BinaryDecoder, StringEncoder, StringDecoder {
    private static final byte CR = 13;
    private static final byte ESCAPE_CHAR = 61;
    private static final byte LF = 10;
    private static final BitSet PRINTABLE_CHARS = new BitSet(256);
    private static final int SAFE_LENGTH = 73;
    private static final byte SPACE = 32;
    private static final byte TAB = 9;
    private final Charset charset;
    private final boolean strict;

    static {
        for (int i2 = 33; i2 <= 60; i2++) {
            PRINTABLE_CHARS.set(i2);
        }
        for (int i3 = 62; i3 <= 126; i3++) {
            PRINTABLE_CHARS.set(i3);
        }
        BitSet bitSet = PRINTABLE_CHARS;
        bitSet.set(9);
        bitSet.set(32);
    }

    public QuotedPrintableCodec() {
        this(StandardCharsets.UTF_8, false);
    }

    public static final byte[] decodeQuotedPrintable(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if (b2 == 61) {
                i2++;
                try {
                    if (bArr[i2] != 13) {
                        int iDigit16 = Utils.digit16(bArr[i2]);
                        i2++;
                        byteArrayOutputStream.write((char) ((iDigit16 << 4) + Utils.digit16(bArr[i2])));
                    }
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new DecoderException("Invalid quoted-printable encoding", e2);
                }
            } else if (b2 != 13 && b2 != 10) {
                byteArrayOutputStream.write(b2);
            }
            i2++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static int encodeByte(int i2, boolean z, ByteArrayOutputStream byteArrayOutputStream) {
        if (z) {
            return encodeQuotedPrintable(i2, byteArrayOutputStream);
        }
        byteArrayOutputStream.write(i2);
        return 1;
    }

    private static final int encodeQuotedPrintable(int i2, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char cHexDigit = Utils.hexDigit(i2 >> 4);
        char cHexDigit2 = Utils.hexDigit(i2);
        byteArrayOutputStream.write(cHexDigit);
        byteArrayOutputStream.write(cHexDigit2);
        return 3;
    }

    private static int getUnsignedOctet(int i2, byte[] bArr) {
        byte b2 = bArr[i2];
        return b2 < 0 ? b2 + 256 : b2;
    }

    private static boolean isWhitespace(int i2) {
        return i2 == 32 || i2 == 9;
    }

    @Override // org.apache.commons.codec.BinaryDecoder
    public byte[] decode(byte[] bArr) throws DecoderException {
        return decodeQuotedPrintable(bArr);
    }

    @Override // org.apache.commons.codec.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        return encodeQuotedPrintable(PRINTABLE_CHARS, bArr, this.strict);
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getDefaultCharset() {
        return this.charset.name();
    }

    public QuotedPrintableCodec(boolean z) {
        this(StandardCharsets.UTF_8, z);
    }

    public String decode(String str, Charset charset) throws DecoderException {
        if (str == null) {
            return null;
        }
        return new String(decode(StringUtils.getBytesUsAscii(str)), charset);
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) throws EncoderException {
        return encode(str, getCharset());
    }

    public QuotedPrintableCodec(Charset charset) {
        this(charset, false);
    }

    public String decode(String str, String str2) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return new String(decode(StringUtils.getBytesUsAscii(str)), str2);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable encoded");
    }

    public QuotedPrintableCodec(Charset charset, boolean z) {
        this.charset = charset;
        this.strict = z;
    }

    @Override // org.apache.commons.codec.StringDecoder
    public String decode(String str) throws DecoderException {
        return decode(str, getCharset());
    }

    @Override // org.apache.commons.codec.Decoder
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be quoted-printable decoded");
    }

    public static final byte[] encodeQuotedPrintable(BitSet bitSet, byte[] bArr) {
        return encodeQuotedPrintable(bitSet, bArr, false);
    }

    public QuotedPrintableCodec(String str) throws IllegalArgumentException {
        this(Charset.forName(str), false);
    }

    public static final byte[] encodeQuotedPrintable(BitSet bitSet, byte[] bArr, boolean z) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = PRINTABLE_CHARS;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (z) {
            int iEncodeByte = 1;
            for (int i2 = 0; i2 < bArr.length - 3; i2++) {
                int unsignedOctet = getUnsignedOctet(i2, bArr);
                if (iEncodeByte < 73) {
                    iEncodeByte += encodeByte(unsignedOctet, !bitSet.get(unsignedOctet), byteArrayOutputStream);
                } else {
                    encodeByte(unsignedOctet, !bitSet.get(unsignedOctet) || isWhitespace(unsignedOctet), byteArrayOutputStream);
                    byteArrayOutputStream.write(61);
                    byteArrayOutputStream.write(13);
                    byteArrayOutputStream.write(10);
                    iEncodeByte = 1;
                }
            }
            int unsignedOctet2 = getUnsignedOctet(bArr.length - 3, bArr);
            if (iEncodeByte + encodeByte(unsignedOctet2, !bitSet.get(unsignedOctet2) || (isWhitespace(unsignedOctet2) && iEncodeByte > 68), byteArrayOutputStream) > 71) {
                byteArrayOutputStream.write(61);
                byteArrayOutputStream.write(13);
                byteArrayOutputStream.write(10);
            }
            int length = bArr.length - 2;
            while (length < bArr.length) {
                int unsignedOctet3 = getUnsignedOctet(length, bArr);
                encodeByte(unsignedOctet3, !bitSet.get(unsignedOctet3) || (length > bArr.length + (-2) && isWhitespace(unsignedOctet3)), byteArrayOutputStream);
                length++;
            }
        } else {
            int length2 = bArr.length;
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = bArr[i3];
                if (i4 < 0) {
                    i4 += 256;
                }
                if (bitSet.get(i4)) {
                    byteArrayOutputStream.write(i4);
                } else {
                    encodeQuotedPrintable(i4, byteArrayOutputStream);
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String encode(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        return StringUtils.newStringUsAscii(encode(str.getBytes(charset)));
    }

    public String encode(String str, String str2) throws UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        return StringUtils.newStringUsAscii(encode(str.getBytes(str2)));
    }
}
