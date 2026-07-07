package com.google.zxing.aztec.decoder;

import androidx.core.view.PointerIconCompat;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.android.arouter.utils.Consts;
import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.FormatException;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.intelligoo.sdk.utils.BleLog;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import com.tom_roush.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;
import org.android.agoo.message.MessageService;

/* JADX INFO: loaded from: classes2.dex */
public final class Decoder {
    private int codewordSize;
    private AztecDetectorResult ddata;
    private int invertedBitCount;
    private int numCodewords;
    private static final int[] NB_BITS_COMPACT = {0, 104, 240, TTAdConstant.INTERACTION_TYPE_CODE, 608};
    private static final int[] NB_BITS = {0, 128, 288, 480, 704, 960, 1248, 1568, 1920, 2304, 2720, 3168, 3648, 4160, 4704, 5280, 5888, 6528, 7200, 7904, 8640, 9408, 10208, 11040, 11904, 12800, 13728, 14688, 15680, 16704, 17760, 18848, 19968};
    private static final int[] NB_DATABLOCK_COMPACT = {0, 17, 40, 51, 76};
    private static final int[] NB_DATABLOCK = {0, 21, 48, 60, 88, 120, 156, 196, 240, 230, 272, 316, 364, 416, 470, 528, 588, 652, 720, 790, 864, 940, PointerIconCompat.TYPE_GRAB, 920, 992, 1066, 1144, 1224, 1306, 1392, 1480, 1570, 1664};
    private static final String[] UPPER_TABLE = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", OperatorName.STROKING_COLOR_GRAY, StandardStructureTypes.H, "I", OperatorName.SET_LINE_CAPSTYLE, OperatorName.STROKING_COLOR_CMYK, "L", OperatorName.SET_LINE_MITERLIMIT, "N", PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, "P", OperatorName.RESTORE, "R", "S", PDNumberFormatDictionary.FRACTIONAL_DISPLAY_TRUNCATE, PDBorderStyleDictionary.STYLE_UNDERLINE, "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] LOWER_TABLE = {"CTRL_PS", " ", PDPageLabelRange.STYLE_LETTERS_LOWER, OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE, OperatorName.CURVE_TO, OperatorName.SET_LINE_DASHPATTERN, "e", OperatorName.FILL_NON_ZERO, OperatorName.NON_STROKING_GRAY, OperatorName.CLOSE_PATH, OperatorName.SET_FLATNESS, OperatorName.SET_LINE_JOINSTYLE, OperatorName.NON_STROKING_CMYK, OperatorName.LINE_TO, OperatorName.MOVE_TO, OperatorName.ENDPATH, "o", "p", OperatorName.SAVE, PDPageLabelRange.STYLE_ROMAN_LOWER, OperatorName.CLOSE_AND_STROKE, DispatchConstants.TIMESTAMP, "u", "v", OperatorName.SET_LINE_WIDTH, "x", OperatorName.CURVE_TO_REPLICATE_FINAL_POINT, "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] MIXED_TABLE = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] PUNCT_TABLE = {"", "\r", BleLog.LINE_BREAK, ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", OperatorName.SHOW_TEXT_LINE, "(", ")", "*", "+", ",", "-", Consts.DOT, "/", ":", i.f5697b, "<", "=", ">", "?", "[", "]", "{", i.f5699d, "CTRL_UL"};
    private static final String[] DIGIT_TABLE = {"CTRL_PS", " ", "0", "1", "2", "3", MessageService.MSG_ACCS_READY_REPORT, "5", "6", "7", MessageService.MSG_ACCS_NOTIFY_CLICK, MessageService.MSG_ACCS_NOTIFY_DISMISS, ",", Consts.DOT, "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: com.google.zxing.aztec.decoder.Decoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table;

        static {
            int[] iArr = new int[Table.values().length];
            $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table = iArr;
            try {
                iArr[Table.BINARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.UPPER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.LOWER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.MIXED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.PUNCT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[Table.DIGIT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f0, code lost:
    
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean[] correctBits(boolean[] r14) throws com.google.zxing.FormatException {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.Decoder.correctBits(boolean[]):boolean[]");
    }

    private boolean[] extractBits(BitMatrix bitMatrix) throws FormatException {
        boolean[] zArr;
        int i2;
        if (this.ddata.isCompact()) {
            int nbLayers = this.ddata.getNbLayers();
            int[] iArr = NB_BITS_COMPACT;
            if (nbLayers > iArr.length) {
                throw FormatException.getFormatInstance();
            }
            zArr = new boolean[iArr[this.ddata.getNbLayers()]];
            this.numCodewords = NB_DATABLOCK_COMPACT[this.ddata.getNbLayers()];
        } else {
            int nbLayers2 = this.ddata.getNbLayers();
            int[] iArr2 = NB_BITS;
            if (nbLayers2 > iArr2.length) {
                throw FormatException.getFormatInstance();
            }
            zArr = new boolean[iArr2[this.ddata.getNbLayers()]];
            this.numCodewords = NB_DATABLOCK[this.ddata.getNbLayers()];
        }
        int nbLayers3 = this.ddata.getNbLayers();
        int height = bitMatrix.getHeight();
        int i3 = 0;
        int i4 = 0;
        while (nbLayers3 != 0) {
            int i5 = 0;
            int i6 = 0;
            while (true) {
                i2 = height * 2;
                if (i5 >= i2 - 4) {
                    break;
                }
                int i7 = (i5 / 2) + i4;
                zArr[i3 + i5] = bitMatrix.get(i4 + i6, i7);
                zArr[((i2 + i3) - 4) + i5] = bitMatrix.get(i7, ((i4 + height) - 1) - i6);
                i6 = (i6 + 1) % 2;
                i5++;
            }
            int i8 = 0;
            for (int i9 = i2 + 1; i9 > 5; i9--) {
                int i10 = i2 - i9;
                int i11 = ((i9 / 2) + i4) - 1;
                zArr[(((height * 4) + i3) - 8) + i10 + 1] = bitMatrix.get(((i4 + height) - 1) - i8, i11);
                zArr[(((height * 6) + i3) - 12) + i10 + 1] = bitMatrix.get(i11, i4 + i8);
                i8 = (i8 + 1) % 2;
            }
            i4 += 2;
            i3 += (height * 8) - 16;
            nbLayers3--;
            height -= 4;
        }
        return zArr;
    }

    private static String getCharacter(Table table, int i2) {
        int i3 = AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table[table.ordinal()];
        return i3 != 2 ? i3 != 3 ? i3 != 4 ? i3 != 5 ? i3 != 6 ? "" : DIGIT_TABLE[i2] : PUNCT_TABLE[i2] : MIXED_TABLE[i2] : LOWER_TABLE[i2] : UPPER_TABLE[i2];
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getEncodedData(boolean[] r14) throws com.google.zxing.FormatException {
        /*
            r13 = this;
            int r0 = r13.codewordSize
            com.google.zxing.aztec.AztecDetectorResult r1 = r13.ddata
            int r1 = r1.getNbDatablocks()
            int r0 = r0 * r1
            int r1 = r13.invertedBitCount
            int r0 = r0 - r1
            int r1 = r14.length
            if (r0 > r1) goto L82
            com.google.zxing.aztec.decoder.Decoder$Table r1 = com.google.zxing.aztec.decoder.Decoder.Table.UPPER
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 20
            r2.<init>(r3)
            r3 = 0
            r4 = r1
            r5 = 0
            r6 = 0
            r7 = 0
        L1e:
            r8 = 0
        L1f:
            if (r5 != 0) goto L7d
            r9 = 1
            if (r6 == 0) goto L26
            r8 = 1
            goto L27
        L26:
            r4 = r1
        L27:
            int[] r10 = com.google.zxing.aztec.decoder.Decoder.AnonymousClass1.$SwitchMap$com$google$zxing$aztec$decoder$Decoder$Table
            int r11 = r1.ordinal()
            r10 = r10[r11]
            if (r10 == r9) goto L66
            com.google.zxing.aztec.decoder.Decoder$Table r10 = com.google.zxing.aztec.decoder.Decoder.Table.DIGIT
            r11 = 5
            if (r1 != r10) goto L38
            r10 = 4
            goto L39
        L38:
            r10 = 5
        L39:
            int r12 = r0 - r7
            if (r12 >= r10) goto L3e
            goto L6c
        L3e:
            int r12 = readCode(r14, r7, r10)
            int r7 = r7 + r10
            java.lang.String r10 = getCharacter(r1, r12)
            java.lang.String r12 = "CTRL_"
            boolean r12 = r10.startsWith(r12)
            if (r12 == 0) goto L62
            char r1 = r10.charAt(r11)
            com.google.zxing.aztec.decoder.Decoder$Table r1 = getTable(r1)
            r11 = 6
            char r10 = r10.charAt(r11)
            r11 = 83
            if (r10 != r11) goto L78
            r6 = 1
            goto L78
        L62:
            r2.append(r10)
            goto L78
        L66:
            int r10 = r0 - r7
            r11 = 8
            if (r10 >= r11) goto L6e
        L6c:
            r5 = 1
            goto L78
        L6e:
            int r9 = readCode(r14, r7, r11)
            int r7 = r7 + 8
            char r9 = (char) r9
            r2.append(r9)
        L78:
            if (r8 == 0) goto L1f
            r1 = r4
            r6 = 0
            goto L1e
        L7d:
            java.lang.String r14 = r2.toString()
            return r14
        L82:
            com.google.zxing.FormatException r14 = com.google.zxing.FormatException.getFormatInstance()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.aztec.decoder.Decoder.getEncodedData(boolean[]):java.lang.String");
    }

    private static Table getTable(char c2) {
        return c2 != 'B' ? c2 != 'D' ? c2 != 'P' ? c2 != 'L' ? c2 != 'M' ? Table.UPPER : Table.MIXED : Table.LOWER : Table.PUNCT : Table.DIGIT : Table.BINARY;
    }

    private static int readCode(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4++;
            }
        }
        return i4;
    }

    private static BitMatrix removeDashedLines(BitMatrix bitMatrix) {
        int width = ((((bitMatrix.getWidth() - 1) / 2) / 16) * 2) + 1;
        BitMatrix bitMatrix2 = new BitMatrix(bitMatrix.getWidth() - width, bitMatrix.getHeight() - width);
        int i2 = 0;
        for (int i3 = 0; i3 < bitMatrix.getWidth(); i3++) {
            if (((bitMatrix.getWidth() / 2) - i3) % 16 != 0) {
                int i4 = 0;
                for (int i5 = 0; i5 < bitMatrix.getHeight(); i5++) {
                    if (((bitMatrix.getWidth() / 2) - i5) % 16 != 0) {
                        if (bitMatrix.get(i3, i5)) {
                            bitMatrix2.set(i2, i4);
                        }
                        i4++;
                    }
                }
                i2++;
            }
        }
        return bitMatrix2;
    }

    public DecoderResult decode(AztecDetectorResult aztecDetectorResult) throws FormatException {
        this.ddata = aztecDetectorResult;
        BitMatrix bits = aztecDetectorResult.getBits();
        if (!this.ddata.isCompact()) {
            bits = removeDashedLines(this.ddata.getBits());
        }
        return new DecoderResult(null, getEncodedData(correctBits(extractBits(bits))), null, null);
    }
}
