package org.apache.commons.codec.binary;

import androidx.appcompat.widget.ActivityChooserView;
import com.tom_roush.fontbox.ttf.GlyfDescript;
import com.tom_roush.pdfbox.pdfparser.BaseParser;
import java.math.BigInteger;
import java.util.Objects;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.commons.codec.net.URLCodec;

/* JADX INFO: loaded from: classes2.dex */
public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    private static final int MASK_2BITS = 3;
    private static final int MASK_4BITS = 15;
    private static final int MASK_6BITS = 63;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, BaseNCodec.PAD_DEFAULT, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, BaseParser.ASCII_CR, 14, 15, GlyfDescript.X_DUAL, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, URLCodec.ESCAPE_CHAR, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

    public Base64() {
        this(0);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUsAscii(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUsAscii(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        Objects.requireNonNull(bigInteger, "bigInteger");
        return encodeBase64(toIntegerBytes(bigInteger), false);
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b2) {
        if (b2 != 61) {
            if (b2 >= 0) {
                byte[] bArr = DECODE_TABLE;
                if (b2 >= bArr.length || bArr[b2] == -1) {
                }
            }
            return false;
        }
        return true;
    }

    public static byte[] toIntegerBytes(BigInteger bigInteger) {
        int iBitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i2 = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == iBitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i2 = 0;
        }
        int i3 = iBitLength / 8;
        int i4 = i3 - length;
        byte[] bArr = new byte[i3];
        System.arraycopy(byteArray, i2, bArr, i4, length);
        return bArr;
    }

    private void validateCharacter(int i2, BaseNCodec.Context context) {
        if (isStrictDecoding() && (i2 & context.ibitWorkArea) != 0) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Expected the discarded bits from the character to be zero.");
        }
    }

    private void validateTrailingCharacter() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character (before the paddings if any) is a valid base 64 alphabet but not a possible encoding. Decoding requires at least two trailing 6-bit characters to create bytes.");
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i2, int i3, BaseNCodec.Context context) {
        byte b2;
        if (context.eof) {
            return;
        }
        if (i3 < 0) {
            context.eof = true;
        }
        int i4 = 0;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            byte[] bArrEnsureBufferSize = ensureBufferSize(this.decodeSize, context);
            int i5 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 == this.pad) {
                context.eof = true;
                break;
            }
            if (b3 >= 0) {
                byte[] bArr2 = DECODE_TABLE;
                if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                    int i6 = (context.modulus + 1) % 4;
                    context.modulus = i6;
                    int i7 = (context.ibitWorkArea << 6) + b2;
                    context.ibitWorkArea = i7;
                    if (i6 == 0) {
                        int i8 = context.pos;
                        int i9 = i8 + 1;
                        context.pos = i9;
                        bArrEnsureBufferSize[i8] = (byte) ((i7 >> 16) & 255);
                        int i10 = i9 + 1;
                        context.pos = i10;
                        bArrEnsureBufferSize[i9] = (byte) ((i7 >> 8) & 255);
                        context.pos = i10 + 1;
                        bArrEnsureBufferSize[i10] = (byte) (i7 & 255);
                    }
                }
            }
            i4++;
            i2 = i5;
        }
        if (!context.eof || context.modulus == 0) {
            return;
        }
        byte[] bArrEnsureBufferSize2 = ensureBufferSize(this.decodeSize, context);
        int i11 = context.modulus;
        if (i11 == 1) {
            validateTrailingCharacter();
            return;
        }
        if (i11 == 2) {
            validateCharacter(15, context);
            int i12 = context.ibitWorkArea >> 4;
            context.ibitWorkArea = i12;
            int i13 = context.pos;
            context.pos = i13 + 1;
            bArrEnsureBufferSize2[i13] = (byte) (i12 & 255);
            return;
        }
        if (i11 != 3) {
            throw new IllegalStateException("Impossible modulus " + context.modulus);
        }
        validateCharacter(3, context);
        int i14 = context.ibitWorkArea >> 2;
        context.ibitWorkArea = i14;
        int i15 = context.pos;
        int i16 = i15 + 1;
        context.pos = i16;
        bArrEnsureBufferSize2[i15] = (byte) ((i14 >> 8) & 255);
        context.pos = i16 + 1;
        bArrEnsureBufferSize2[i16] = (byte) (i14 & 255);
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i2, int i3, BaseNCodec.Context context) {
        if (context.eof) {
            return;
        }
        if (i3 >= 0) {
            int i4 = 0;
            while (i4 < i3) {
                byte[] bArrEnsureBufferSize = ensureBufferSize(this.encodeSize, context);
                int i5 = (context.modulus + 1) % 3;
                context.modulus = i5;
                int i6 = i2 + 1;
                int i7 = bArr[i2];
                if (i7 < 0) {
                    i7 += 256;
                }
                int i8 = (context.ibitWorkArea << 8) + i7;
                context.ibitWorkArea = i8;
                if (i5 == 0) {
                    int i9 = context.pos;
                    int i10 = i9 + 1;
                    context.pos = i10;
                    byte[] bArr2 = this.encodeTable;
                    bArrEnsureBufferSize[i9] = bArr2[(i8 >> 18) & 63];
                    int i11 = i10 + 1;
                    context.pos = i11;
                    bArrEnsureBufferSize[i10] = bArr2[(i8 >> 12) & 63];
                    int i12 = i11 + 1;
                    context.pos = i12;
                    bArrEnsureBufferSize[i11] = bArr2[(i8 >> 6) & 63];
                    int i13 = i12 + 1;
                    context.pos = i13;
                    bArrEnsureBufferSize[i12] = bArr2[i8 & 63];
                    int i14 = context.currentLinePos + 4;
                    context.currentLinePos = i14;
                    int i15 = this.lineLength;
                    if (i15 > 0 && i15 <= i14) {
                        byte[] bArr3 = this.lineSeparator;
                        System.arraycopy(bArr3, 0, bArrEnsureBufferSize, i13, bArr3.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                    }
                }
                i4++;
                i2 = i6;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] bArrEnsureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i16 = context.pos;
        int i17 = context.modulus;
        if (i17 != 0) {
            if (i17 == 1) {
                int i18 = i16 + 1;
                context.pos = i18;
                byte[] bArr4 = this.encodeTable;
                int i19 = context.ibitWorkArea;
                bArrEnsureBufferSize2[i16] = bArr4[(i19 >> 2) & 63];
                int i20 = i18 + 1;
                context.pos = i20;
                bArrEnsureBufferSize2[i18] = bArr4[(i19 << 4) & 63];
                if (bArr4 == STANDARD_ENCODE_TABLE) {
                    int i21 = i20 + 1;
                    context.pos = i21;
                    byte b2 = this.pad;
                    bArrEnsureBufferSize2[i20] = b2;
                    context.pos = i21 + 1;
                    bArrEnsureBufferSize2[i21] = b2;
                }
            } else {
                if (i17 != 2) {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
                int i22 = i16 + 1;
                context.pos = i22;
                byte[] bArr5 = this.encodeTable;
                int i23 = context.ibitWorkArea;
                bArrEnsureBufferSize2[i16] = bArr5[(i23 >> 10) & 63];
                int i24 = i22 + 1;
                context.pos = i24;
                bArrEnsureBufferSize2[i22] = bArr5[(i23 >> 4) & 63];
                int i25 = i24 + 1;
                context.pos = i25;
                bArrEnsureBufferSize2[i24] = bArr5[(i23 << 2) & 63];
                if (bArr5 == STANDARD_ENCODE_TABLE) {
                    context.pos = i25 + 1;
                    bArrEnsureBufferSize2[i25] = this.pad;
                }
            }
        }
        int i26 = context.currentLinePos;
        int i27 = context.pos;
        int i28 = i26 + (i27 - i16);
        context.currentLinePos = i28;
        if (this.lineLength <= 0 || i28 <= 0) {
            return;
        }
        byte[] bArr6 = this.lineSeparator;
        System.arraycopy(bArr6, 0, bArrEnsureBufferSize2, i27, bArr6.length);
        context.pos += this.lineSeparator.length;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.decodeTable;
            if (b2 < bArr.length && bArr[b2] != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    public Base64(boolean z) {
        this(76, BaseNCodec.CHUNK_SEPARATOR, z);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!isBase64(bArr[i2]) && !BaseNCodec.isWhiteSpace(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public Base64(int i2) {
        this(i2, BaseNCodec.CHUNK_SEPARATOR);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public Base64(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, BaseNCodec.CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= i2) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i2);
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public Base64(int i2, byte[] bArr, boolean z) {
        this(i2, bArr, z, BaseNCodec.DECODING_POLICY_DEFAULT);
    }

    public Base64(int i2, byte[] bArr, boolean z, CodecPolicy codecPolicy) {
        super(3, 4, i2, bArr == null ? 0 : bArr.length, BaseNCodec.PAD_DEFAULT, codecPolicy);
        this.decodeTable = DECODE_TABLE;
        if (bArr != null) {
            if (containsAlphabetOrPad(bArr)) {
                throw new IllegalArgumentException("lineSeparator must not contain base64 characters: [" + StringUtils.newStringUtf8(bArr) + "]");
            }
            if (i2 > 0) {
                this.encodeSize = bArr.length + 4;
                byte[] bArr2 = new byte[bArr.length];
                this.lineSeparator = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                this.encodeSize = 4;
                this.lineSeparator = null;
            }
        } else {
            this.encodeSize = 4;
            this.lineSeparator = null;
        }
        this.decodeSize = this.encodeSize - 1;
        this.encodeTable = z ? URL_SAFE_ENCODE_TABLE : STANDARD_ENCODE_TABLE;
    }
}
