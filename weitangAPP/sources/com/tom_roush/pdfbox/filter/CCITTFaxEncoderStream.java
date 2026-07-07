package com.tom_roush.pdfbox.filter;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class CCITTFaxEncoderStream extends OutputStream {
    private static final Code[] BLACK_NONTERMINATING_CODES;
    private static final Code[] BLACK_TERMINATING_CODES;
    private int[] changesCurrentRow;
    private int[] changesReferenceRow;
    private final int columns;
    private final int fillOrder;
    private final byte[] inputBuffer;
    private final int inputBufferLength;
    private final int rows;
    private final OutputStream stream;
    private static final Code[] WHITE_TERMINATING_CODES = new Code[64];
    private static final Code[] WHITE_NONTERMINATING_CODES = new Code[40];
    private int currentBufferLength = 0;
    private int currentRow = 0;
    private int changesCurrentRowLength = 0;
    private int changesReferenceRowLength = 0;
    private byte outputBuffer = 0;
    private byte outputBufferBitLength = 0;

    public static class Code {
        public final int code;
        public final int length;

        private Code(int i2, int i3) {
            this.code = i2;
            this.length = i3;
        }
    }

    static {
        int i2 = 0;
        while (true) {
            if (i2 >= CCITTFaxDecoderStream.WHITE_CODES.length) {
                break;
            }
            int i3 = i2 + 4;
            int i4 = 0;
            while (true) {
                short[][] sArr = CCITTFaxDecoderStream.WHITE_CODES;
                if (i4 < sArr[i2].length) {
                    short s = CCITTFaxDecoderStream.WHITE_RUN_LENGTHS[i2][i4];
                    short s2 = sArr[i2][i4];
                    if (s < 64) {
                        WHITE_TERMINATING_CODES[s] = new Code(s2, i3);
                    } else {
                        WHITE_NONTERMINATING_CODES[(s / 64) - 1] = new Code(s2, i3);
                    }
                    i4++;
                }
            }
            i2++;
        }
        BLACK_TERMINATING_CODES = new Code[64];
        BLACK_NONTERMINATING_CODES = new Code[40];
        for (int i5 = 0; i5 < CCITTFaxDecoderStream.BLACK_CODES.length; i5++) {
            int i6 = i5 + 2;
            int i7 = 0;
            while (true) {
                short[][] sArr2 = CCITTFaxDecoderStream.BLACK_CODES;
                if (i7 < sArr2[i5].length) {
                    short s3 = CCITTFaxDecoderStream.BLACK_RUN_LENGTHS[i5][i7];
                    short s4 = sArr2[i5][i7];
                    if (s3 < 64) {
                        BLACK_TERMINATING_CODES[s3] = new Code(s4, i6);
                    } else {
                        BLACK_NONTERMINATING_CODES[(s3 / 64) - 1] = new Code(s4, i6);
                    }
                    i7++;
                }
            }
        }
    }

    public CCITTFaxEncoderStream(OutputStream outputStream, int i2, int i3, int i4) {
        this.stream = outputStream;
        this.columns = i2;
        this.rows = i3;
        this.fillOrder = i4;
        this.changesReferenceRow = new int[i2];
        this.changesCurrentRow = new int[i2];
        int i5 = (i2 + 7) / 8;
        this.inputBufferLength = i5;
        this.inputBuffer = new byte[i5];
    }

    private void clearOutputBuffer() {
        this.outputBuffer = (byte) 0;
        this.outputBufferBitLength = (byte) 0;
    }

    private void encode2D() throws IOException {
        int i2 = 0;
        boolean z = true;
        while (i2 < this.columns) {
            int[] nextChanges = getNextChanges(i2, z);
            int[] nextRefChanges = getNextRefChanges(i2, z);
            int i3 = nextChanges[0] - nextRefChanges[0];
            if (nextChanges[0] > nextRefChanges[1]) {
                write(1, 4);
                i2 = nextRefChanges[1];
            } else if (i3 > 3 || i3 < -3) {
                write(1, 3);
                writeRun(nextChanges[0] - i2, z);
                writeRun(nextChanges[1] - nextChanges[0], !z);
                i2 = nextChanges[1];
            } else {
                switch (i3) {
                    case -3:
                        write(2, 7);
                        break;
                    case -2:
                        write(2, 6);
                        break;
                    case -1:
                        write(2, 3);
                        break;
                    case 0:
                        write(1, 1);
                        break;
                    case 1:
                        write(3, 3);
                        break;
                    case 2:
                        write(3, 6);
                        break;
                    case 3:
                        write(3, 7);
                        break;
                }
                z = !z;
                i2 = nextRefChanges[0] + i3;
            }
        }
    }

    private void encodeRow() throws IOException {
        this.currentRow++;
        int[] iArr = this.changesReferenceRow;
        this.changesReferenceRow = this.changesCurrentRow;
        this.changesCurrentRow = iArr;
        this.changesReferenceRowLength = this.changesCurrentRowLength;
        this.changesCurrentRowLength = 0;
        boolean z = true;
        for (int i2 = 0; i2 < this.columns; i2++) {
            if ((((this.inputBuffer[i2 / 8] >> (7 - (i2 % 8))) & 1) == 1) == z) {
                int[] iArr2 = this.changesCurrentRow;
                int i3 = this.changesCurrentRowLength;
                iArr2[i3] = i2;
                this.changesCurrentRowLength = i3 + 1;
                z = !z;
            }
        }
        encodeRowType6();
        if (this.currentRow == this.rows) {
            writeEOL();
            writeEOL();
            fill();
        }
    }

    private void encodeRowType6() throws IOException {
        encode2D();
    }

    private void fill() throws IOException {
        if (this.outputBufferBitLength != 0) {
            this.stream.write(this.outputBuffer);
        }
        clearOutputBuffer();
    }

    private int[] getNextChanges(int i2, boolean z) {
        int i3;
        int[] iArr;
        int i4 = this.columns;
        int[] iArr2 = {i4, i4};
        int i5 = 0;
        while (true) {
            i3 = this.changesCurrentRowLength;
            if (i5 >= i3) {
                break;
            }
            iArr = this.changesCurrentRow;
            if (i2 < iArr[i5] || (i2 == 0 && z)) {
                break;
            }
            i5++;
        }
        iArr2[0] = iArr[i5];
        int i6 = i5 + 1;
        if (i6 < i3) {
            iArr2[1] = iArr[i6];
        }
        return iArr2;
    }

    private int[] getNextRefChanges(int i2, boolean z) {
        int i3;
        int[] iArr;
        int i4 = this.columns;
        int[] iArr2 = {i4, i4};
        int i5 = !z ? 1 : 0;
        while (true) {
            i3 = this.changesReferenceRowLength;
            if (i5 >= i3) {
                break;
            }
            iArr = this.changesReferenceRow;
            if (iArr[i5] > i2 || (i2 == 0 && i5 == 0)) {
                break;
            }
            i5 += 2;
        }
        iArr2[0] = iArr[i5];
        int i6 = i5 + 1;
        if (i6 < i3) {
            iArr2[1] = iArr[i6];
        }
        return iArr2;
    }

    private void writeEOL() throws IOException {
        write(1, 12);
    }

    private void writeRun(int i2, boolean z) throws IOException {
        int length = i2 / 64;
        Code[] codeArr = z ? WHITE_NONTERMINATING_CODES : BLACK_NONTERMINATING_CODES;
        while (length > 0) {
            if (length >= codeArr.length) {
                write(codeArr[codeArr.length - 1].code, codeArr[codeArr.length - 1].length);
                length -= codeArr.length;
            } else {
                int i3 = length - 1;
                write(codeArr[i3].code, codeArr[i3].length);
                length = 0;
            }
        }
        Code code = z ? WHITE_TERMINATING_CODES[i2 % 64] : BLACK_TERMINATING_CODES[i2 % 64];
        write(code.code, code.length);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stream.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.stream.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        byte[] bArr = this.inputBuffer;
        int i3 = this.currentBufferLength;
        bArr[i3] = (byte) i2;
        int i4 = i3 + 1;
        this.currentBufferLength = i4;
        if (i4 == this.inputBufferLength) {
            encodeRow();
            this.currentBufferLength = 0;
        }
    }

    private void write(int i2, int i3) throws IOException {
        for (int i4 = 0; i4 < i3; i4++) {
            boolean z = ((i2 >> ((i3 - i4) - 1)) & 1) == 1;
            if (this.fillOrder == 1) {
                this.outputBuffer = (byte) ((z ? 1 << (7 - (this.outputBufferBitLength % 8)) : 0) | this.outputBuffer);
            } else {
                this.outputBuffer = (byte) ((z ? 1 << (this.outputBufferBitLength % 8) : 0) | this.outputBuffer);
            }
            byte b2 = (byte) (this.outputBufferBitLength + 1);
            this.outputBufferBitLength = b2;
            if (b2 == 8) {
                this.stream.write(this.outputBuffer);
                clearOutputBuffer();
            }
        }
    }
}
