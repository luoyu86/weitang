package org.apache.commons.codec.binary;

import com.tom_roush.pdfbox.pdfparser.BaseParser;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.binary.BaseNCodec;

/* JADX INFO: loaded from: classes2.dex */
public class Base16 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 4;
    private static final int BYTES_PER_ENCODED_BLOCK = 2;
    private static final int BYTES_PER_UNENCODED_BLOCK = 1;
    private static final int MASK_4BITS = 15;
    private final byte[] decodeTable;
    private final byte[] encodeTable;
    private static final byte[] UPPER_CASE_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, BaseParser.ASCII_CR, 14, 15};
    private static final byte[] UPPER_CASE_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    private static final byte[] LOWER_CASE_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, BaseParser.ASCII_CR, 14, 15};
    private static final byte[] LOWER_CASE_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    public Base16() {
        this(false);
    }

    private int decodeOctet(byte b2) {
        int i2 = b2 & 255;
        byte[] bArr = this.decodeTable;
        byte b3 = i2 < bArr.length ? bArr[b2] : (byte) -1;
        if (b3 != -1) {
            return b3;
        }
        throw new IllegalArgumentException("Invalid octet in encoded value: " + ((int) b2));
    }

    private void validateTrailingCharacter() {
        if (isStrictDecoding()) {
            throw new IllegalArgumentException("Strict decoding: Last encoded character is a valid base 16 alphabetcharacter but not a possible encoding. Decoding requires at least two characters to create one byte.");
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i2, int i3, BaseNCodec.Context context) {
        if (context.eof || i3 < 0) {
            context.eof = true;
            if (context.ibitWorkArea != 0) {
                validateTrailingCharacter();
                return;
            }
            return;
        }
        int iMin = Math.min(bArr.length - i2, i3);
        int i4 = 0;
        int i5 = (context.ibitWorkArea != 0 ? 1 : 0) + iMin;
        if (i5 == 1 && i5 == iMin) {
            context.ibitWorkArea = decodeOctet(bArr[i2]) + 1;
            return;
        }
        int i6 = i5 % 2 == 0 ? i5 : i5 - 1;
        byte[] bArrEnsureBufferSize = ensureBufferSize(i6 / 2, context);
        if (iMin < i5) {
            int i7 = i2 + 1;
            int iDecodeOctet = decodeOctet(bArr[i2]) | ((context.ibitWorkArea - 1) << 4);
            int i8 = context.pos;
            context.pos = i8 + 1;
            bArrEnsureBufferSize[i8] = (byte) iDecodeOctet;
            context.ibitWorkArea = 0;
            i4 = 2;
            i2 = i7;
        }
        while (i4 < i6) {
            int i9 = i2 + 1;
            int i10 = i9 + 1;
            int iDecodeOctet2 = (decodeOctet(bArr[i2]) << 4) | decodeOctet(bArr[i9]);
            i4 += 2;
            int i11 = context.pos;
            context.pos = i11 + 1;
            bArrEnsureBufferSize[i11] = (byte) iDecodeOctet2;
            i2 = i10;
        }
        if (i4 < iMin) {
            context.ibitWorkArea = decodeOctet(bArr[i4]) + 1;
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i2, int i3, BaseNCodec.Context context) {
        if (context.eof) {
            return;
        }
        if (i3 < 0) {
            context.eof = true;
            return;
        }
        int i4 = i3 * 2;
        if (i4 < 0) {
            throw new IllegalArgumentException("Input length exceeds maximum size for encoded data: " + i3);
        }
        byte[] bArrEnsureBufferSize = ensureBufferSize(i4, context);
        int i5 = i3 + i2;
        while (i2 < i5) {
            byte b2 = bArr[i2];
            int i6 = context.pos;
            int i7 = i6 + 1;
            context.pos = i7;
            byte[] bArr2 = this.encodeTable;
            bArrEnsureBufferSize[i6] = bArr2[(b2 >> 4) & 15];
            context.pos = i7 + 1;
            bArrEnsureBufferSize[i7] = bArr2[b2 & 15];
            i2++;
        }
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b2) {
        int i2 = b2 & 255;
        byte[] bArr = this.decodeTable;
        return i2 < bArr.length && bArr[b2] != -1;
    }

    public Base16(boolean z) {
        this(z, BaseNCodec.DECODING_POLICY_DEFAULT);
    }

    public Base16(boolean z, CodecPolicy codecPolicy) {
        super(1, 2, 0, 0, BaseNCodec.PAD_DEFAULT, codecPolicy);
        if (z) {
            this.encodeTable = LOWER_CASE_ENCODE_TABLE;
            this.decodeTable = LOWER_CASE_DECODE_TABLE;
        } else {
            this.encodeTable = UPPER_CASE_ENCODE_TABLE;
            this.decodeTable = UPPER_CASE_DECODE_TABLE;
        }
    }
}
