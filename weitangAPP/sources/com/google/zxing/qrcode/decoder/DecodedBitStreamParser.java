package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import com.google.zxing.oned.rss.expanded.decoders.DecodedChar;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: loaded from: classes2.dex */
public final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', DecodedChar.FNC1, '%', '*', '+', Soundex.SILENT_MARKER, '.', '/', ':'};
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    public static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode modeForBits;
        Mode mode;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i2 = 1;
        ArrayList arrayList = new ArrayList(1);
        CharacterSetECI characterSetECIByValue = null;
        boolean z = false;
        while (true) {
            if (bitSource.available() < 4) {
                modeForBits = Mode.TERMINATOR;
            } else {
                try {
                    modeForBits = Mode.forBits(bitSource.readBits(4));
                } catch (IllegalArgumentException unused) {
                    throw FormatException.getFormatInstance();
                }
            }
            Mode mode2 = modeForBits;
            Mode mode3 = Mode.TERMINATOR;
            if (mode2 == mode3) {
                mode = mode3;
            } else if (mode2 == Mode.FNC1_FIRST_POSITION || mode2 == Mode.FNC1_SECOND_POSITION) {
                mode = mode3;
                z = true;
            } else {
                if (mode2 == Mode.STRUCTURED_APPEND) {
                    bitSource.readBits(16);
                } else if (mode2 == Mode.ECI) {
                    characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(parseECIValue(bitSource));
                    if (characterSetECIByValue == null) {
                        throw FormatException.getFormatInstance();
                    }
                } else if (mode2 == Mode.HANZI) {
                    int bits = bitSource.readBits(4);
                    int bits2 = bitSource.readBits(mode2.getCharacterCountBits(version));
                    if (bits == i2) {
                        decodeHanziSegment(bitSource, sb, bits2);
                    }
                } else {
                    int bits3 = bitSource.readBits(mode2.getCharacterCountBits(version));
                    if (mode2 == Mode.NUMERIC) {
                        decodeNumericSegment(bitSource, sb, bits3);
                    } else if (mode2 == Mode.ALPHANUMERIC) {
                        decodeAlphanumericSegment(bitSource, sb, bits3, z);
                    } else if (mode2 == Mode.BYTE) {
                        mode = mode3;
                        decodeByteSegment(bitSource, sb, bits3, characterSetECIByValue, arrayList, map);
                    } else {
                        mode = mode3;
                        if (mode2 != Mode.KANJI) {
                            throw FormatException.getFormatInstance();
                        }
                        decodeKanjiSegment(bitSource, sb, bits3);
                    }
                }
                mode = mode3;
            }
            if (mode2 == mode) {
                String string = sb.toString();
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                return new DecoderResult(bArr, string, arrayList, errorCorrectionLevel != null ? errorCorrectionLevel.toString() : null);
            }
            i2 = 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void decodeAlphanumericSegment(com.google.zxing.common.BitSource r3, java.lang.StringBuilder r4, int r5, boolean r6) throws com.google.zxing.FormatException {
        /*
            int r0 = r4.length()
        L4:
            r1 = 1
            if (r5 <= r1) goto L22
            r1 = 11
            int r1 = r3.readBits(r1)
            int r2 = r1 / 45
            char r2 = toAlphaNumericChar(r2)
            r4.append(r2)
            int r1 = r1 % 45
            char r1 = toAlphaNumericChar(r1)
            r4.append(r1)
            int r5 = r5 + (-2)
            goto L4
        L22:
            if (r5 != r1) goto L30
            r5 = 6
            int r3 = r3.readBits(r5)
            char r3 = toAlphaNumericChar(r3)
            r4.append(r3)
        L30:
            if (r6 == 0) goto L5b
        L32:
            int r3 = r4.length()
            if (r0 >= r3) goto L5b
            char r3 = r4.charAt(r0)
            r5 = 37
            if (r3 != r5) goto L58
            int r3 = r4.length()
            int r3 = r3 - r1
            if (r0 >= r3) goto L53
            int r3 = r0 + 1
            char r6 = r4.charAt(r3)
            if (r6 != r5) goto L53
            r4.deleteCharAt(r3)
            goto L58
        L53:
            r3 = 29
            r4.setCharAt(r0, r3)
        L58:
            int r0 = r0 + 1
            goto L32
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.DecodedBitStreamParser.decodeAlphanumericSegment(com.google.zxing.common.BitSource, java.lang.StringBuilder, int, boolean):void");
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder sb, int i2, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if ((i2 << 3) > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = (byte) bitSource.readBits(8);
        }
        try {
            sb.append(new String(bArr, characterSetECI == null ? StringUtils.guessEncoding(bArr, map) : characterSetECI.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int bits = bitSource.readBits(13);
            int i4 = (bits % 96) | ((bits / 96) << 8);
            int i5 = i4 + (i4 < 959 ? 41377 : 42657);
            bArr[i3] = (byte) ((i5 >> 8) & 255);
            bArr[i3 + 1] = (byte) (i5 & 255);
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, StringUtils.GB2312));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int bits = bitSource.readBits(13);
            int i4 = (bits % 192) | ((bits / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder sb, int i2) throws FormatException {
        while (i2 >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int bits = bitSource.readBits(10);
            if (bits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits / 100));
            sb.append(toAlphaNumericChar((bits / 10) % 10));
            sb.append(toAlphaNumericChar(bits % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            int bits2 = bitSource.readBits(7);
            if (bits2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits2 / 10));
            sb.append(toAlphaNumericChar(bits2 % 10));
            return;
        }
        if (i2 == 1) {
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            int bits3 = bitSource.readBits(4);
            if (bits3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(toAlphaNumericChar(bits3));
        }
    }

    private static int parseECIValue(BitSource bitSource) {
        int bits = bitSource.readBits(8);
        if ((bits & 128) == 0) {
            return bits & 127;
        }
        if ((bits & 192) == 128) {
            return bitSource.readBits(8) | ((bits & 63) << 8);
        }
        if ((bits & 224) == 192) {
            return bitSource.readBits(16) | ((bits & 31) << 16);
        }
        throw new IllegalArgumentException("Bad ECI bits starting with byte " + bits);
    }

    private static char toAlphaNumericChar(int i2) throws FormatException {
        char[] cArr = ALPHANUMERIC_CHARS;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw FormatException.getFormatInstance();
    }
}
