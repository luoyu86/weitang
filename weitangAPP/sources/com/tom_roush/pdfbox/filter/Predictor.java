package com.tom_roush.pdfbox.filter;

import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class Predictor {

    public static final class PredictorOutputStream extends FilterOutputStream {
        private final int bitsPerComponent;
        private final int colors;
        private final int columns;
        private byte[] currentRow;
        private int currentRowData;
        private byte[] lastRow;
        private int predictor;
        private final boolean predictorPerRow;
        private boolean predictorRead;
        private final int rowLength;

        public PredictorOutputStream(OutputStream outputStream, int i2, int i3, int i4, int i5) {
            super(outputStream);
            this.currentRowData = 0;
            this.predictorRead = false;
            this.predictor = i2;
            this.colors = i3;
            this.bitsPerComponent = i4;
            this.columns = i5;
            int iCalculateRowLength = Predictor.calculateRowLength(i3, i4, i5);
            this.rowLength = iCalculateRowLength;
            this.predictorPerRow = i2 >= 10;
            this.currentRow = new byte[iCalculateRowLength];
            this.lastRow = new byte[iCalculateRowLength];
        }

        private void decodeAndWriteRow() throws IOException {
            Predictor.decodePredictorRow(this.predictor, this.colors, this.bitsPerComponent, this.columns, this.currentRow, this.lastRow);
            ((FilterOutputStream) this).out.write(this.currentRow);
            flipRows();
        }

        private void flipRows() {
            byte[] bArr = this.lastRow;
            this.lastRow = this.currentRow;
            this.currentRow = bArr;
            this.currentRowData = 0;
            this.predictorRead = false;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            int i2 = this.currentRowData;
            if (i2 > 0) {
                Arrays.fill(this.currentRow, i2, this.rowLength, (byte) 0);
                decodeAndWriteRow();
            }
            super.flush();
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = i3 + i2;
            while (i2 < i4) {
                if (this.predictorPerRow && this.currentRowData == 0 && !this.predictorRead) {
                    this.predictor = bArr[i2] + 10;
                    i2++;
                    this.predictorRead = true;
                } else {
                    int iMin = Math.min(this.rowLength - this.currentRowData, i4 - i2);
                    System.arraycopy(bArr, i2, this.currentRow, this.currentRowData, iMin);
                    int i5 = this.currentRowData + iMin;
                    this.currentRowData = i5;
                    i2 += iMin;
                    if (i5 == this.currentRow.length) {
                        decodeAndWriteRow();
                    }
                }
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(int i2) throws IOException {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    private Predictor() {
    }

    public static int calcSetBitSeq(int i2, int i3, int i4, int i5) {
        int i6 = (1 << i4) - 1;
        return (i2 & (~(i6 << i3))) | ((i5 & i6) << i3);
    }

    public static int calculateRowLength(int i2, int i3, int i4) {
        return ((i4 * (i2 * i3)) + 7) / 8;
    }

    public static void decodePredictorRow(int i2, int i3, int i4, int i5, byte[] bArr, byte[] bArr2) {
        if (i2 == 1) {
            return;
        }
        int i6 = ((i3 * i4) + 7) / 8;
        int length = bArr.length;
        int i7 = 0;
        if (i2 != 2) {
            switch (i2) {
                case 11:
                    for (int i8 = i6; i8 < length; i8++) {
                        bArr[i8] = (byte) (bArr[i8] + bArr[i8 - i6]);
                    }
                    return;
                case 12:
                    break;
                case 13:
                    for (int i9 = 0; i9 < length; i9++) {
                        int i10 = i9 - i6;
                        bArr[i9] = (byte) (((bArr[i9] & 255) + (((i10 >= 0 ? bArr[i10] & 255 : 0) + (bArr2[i9] & 255)) / 2)) & 255);
                    }
                    return;
                case 14:
                    for (int i11 = 0; i11 < length; i11++) {
                        int i12 = bArr[i11] & 255;
                        int i13 = i11 - i6;
                        int i14 = i13 >= 0 ? bArr[i13] & 255 : 0;
                        int i15 = bArr2[i11] & 255;
                        int i16 = i13 >= 0 ? bArr2[i13] & 255 : 0;
                        int i17 = (i14 + i15) - i16;
                        int iAbs = Math.abs(i17 - i14);
                        int iAbs2 = Math.abs(i17 - i15);
                        int iAbs3 = Math.abs(i17 - i16);
                        if (iAbs <= iAbs2 && iAbs <= iAbs3) {
                            bArr[i11] = (byte) ((i12 + i14) & 255);
                        } else if (iAbs2 <= iAbs3) {
                            bArr[i11] = (byte) ((i12 + i15) & 255);
                        } else {
                            bArr[i11] = (byte) ((i12 + i16) & 255);
                        }
                    }
                    return;
                default:
                    return;
            }
            while (i7 < length) {
                bArr[i7] = (byte) (((bArr[i7] & 255) + (bArr2[i7] & 255)) & 255);
                i7++;
            }
            return;
        }
        if (i4 == 8) {
            for (int i18 = i6; i18 < length; i18++) {
                bArr[i18] = (byte) ((bArr[i18] & 255) + (bArr[i18 - i6] & 255));
            }
            return;
        }
        if (i4 == 16) {
            for (int i19 = i6; i19 < length; i19 += 2) {
                int i20 = i19 + 1;
                int i21 = i19 - i6;
                int i22 = ((bArr[i19] & 255) << 8) + (bArr[i20] & 255) + ((bArr[i21] & 255) << 8) + (bArr[i21 + 1] & 255);
                bArr[i19] = (byte) ((i22 >> 8) & 255);
                bArr[i20] = (byte) (i22 & 255);
            }
            return;
        }
        if (i4 != 1 || i3 != 1) {
            int i23 = i5 * i3;
            for (int i24 = i3; i24 < i23; i24++) {
                int i25 = i24 * i4;
                int i26 = i25 / 8;
                int i27 = (8 - (i25 % 8)) - i4;
                int i28 = (i24 - i3) * i4;
                bArr[i26] = (byte) calcSetBitSeq(bArr[i26], i27, i4, getBitSeq(bArr[i26], i27, i4) + getBitSeq(bArr[i28 / 8], (8 - (i28 % 8)) - i4, i4));
            }
            return;
        }
        while (i7 < length) {
            int i29 = 7;
            while (i29 >= 0) {
                int i30 = (bArr[i7] >> i29) & 1;
                if (i7 != 0 || i29 != 7) {
                    if (((i30 + ((i29 == 7 ? bArr[i7 - 1] : bArr[i7] >> (i29 + 1)) & 1)) & 1) == 0) {
                        bArr[i7] = (byte) (bArr[i7] & (~(1 << i29)));
                    } else {
                        bArr[i7] = (byte) (bArr[i7] | (1 << i29));
                    }
                }
                i29--;
            }
            i7++;
        }
    }

    public static int getBitSeq(int i2, int i3, int i4) {
        return (i2 >>> i3) & ((1 << i4) - 1);
    }

    public static OutputStream wrapPredictor(OutputStream outputStream, COSDictionary cOSDictionary) {
        int i2 = cOSDictionary.getInt(COSName.PREDICTOR);
        return i2 > 1 ? new PredictorOutputStream(outputStream, i2, Math.min(cOSDictionary.getInt(COSName.COLORS, 1), 32), cOSDictionary.getInt(COSName.BITS_PER_COMPONENT, 8), cOSDictionary.getInt(COSName.COLUMNS, 1)) : outputStream;
    }
}
