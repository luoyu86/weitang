package com.tom_roush.pdfbox.pdfparser;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDocument;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSObjectKey;
import com.tom_roush.pdfbox.cos.COSStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class PDFXrefStreamParser extends BaseParser {
    private ObjectNumbers objectNumbers;
    private final int[] w;
    private final XrefTrailerResolver xrefTrailerResolver;

    public static class ObjectNumbers implements Iterator<Long> {
        private long currentEnd;
        private long currentNumber;
        private int currentRange;
        private final long[] end;
        private long maxValue;
        private final long[] start;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.currentNumber < this.maxValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private ObjectNumbers(COSArray cOSArray) throws IOException {
            this.currentRange = 0;
            this.currentEnd = 0L;
            this.currentNumber = 0L;
            this.maxValue = 0L;
            long[] jArr = new long[cOSArray.size() / 2];
            this.start = jArr;
            this.end = new long[jArr.length];
            Iterator<COSBase> it = cOSArray.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                COSBase next = it.next();
                if (!(next instanceof COSInteger)) {
                    throw new IOException("Xref stream must have integer in /Index array");
                }
                long jLongValue = ((COSInteger) next).longValue();
                if (!it.hasNext()) {
                    break;
                }
                COSBase next2 = it.next();
                if (!(next2 instanceof COSInteger)) {
                    throw new IOException("Xref stream must have integer in /Index array");
                }
                long jLongValue2 = ((COSInteger) next2).longValue();
                this.start[i2] = jLongValue;
                this.end[i2] = jLongValue + jLongValue2;
                i2++;
            }
            this.currentNumber = this.start[0];
            long[] jArr2 = this.end;
            this.currentEnd = jArr2[0];
            this.maxValue = jArr2[i2 - 1];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Long next() {
            long j = this.currentNumber;
            if (j >= this.maxValue) {
                throw new NoSuchElementException();
            }
            if (j < this.currentEnd) {
                this.currentNumber = 1 + j;
                return Long.valueOf(j);
            }
            long[] jArr = this.start;
            int i2 = this.currentRange + 1;
            this.currentRange = i2;
            long j2 = jArr[i2];
            this.currentNumber = j2;
            this.currentEnd = this.end[i2];
            this.currentNumber = 1 + j2;
            return Long.valueOf(j2);
        }
    }

    public PDFXrefStreamParser(COSStream cOSStream, COSDocument cOSDocument, XrefTrailerResolver xrefTrailerResolver) throws IOException {
        super(new InputStreamSource(cOSStream.createInputStream()));
        this.w = new int[3];
        this.objectNumbers = null;
        this.document = cOSDocument;
        this.xrefTrailerResolver = xrefTrailerResolver;
        try {
            initParserValues(cOSStream);
        } catch (IOException unused) {
            close();
        }
    }

    private void close() throws IOException {
        SequentialSource sequentialSource = this.seqSource;
        if (sequentialSource != null) {
            sequentialSource.close();
        }
        this.document = null;
    }

    private void initParserValues(COSStream cOSStream) throws IOException {
        COSArray cOSArray = cOSStream.getCOSArray(COSName.W);
        if (cOSArray == null) {
            throw new IOException("/W array is missing in Xref stream");
        }
        if (cOSArray.size() != 3) {
            throw new IOException("Wrong number of values for /W array in XRef: " + Arrays.toString(this.w));
        }
        for (int i2 = 0; i2 < 3; i2++) {
            this.w[i2] = cOSArray.getInt(i2, 0);
        }
        int[] iArr = this.w;
        if (iArr[0] < 0 || iArr[1] < 0 || iArr[2] < 0) {
            throw new IOException("Incorrect /W array in XRef: " + Arrays.toString(this.w));
        }
        COSArray cOSArray2 = cOSStream.getCOSArray(COSName.INDEX);
        if (cOSArray2 == null) {
            cOSArray2 = new COSArray();
            cOSArray2.add((COSBase) COSInteger.ZERO);
            cOSArray2.add((COSBase) COSInteger.get(cOSStream.getInt(COSName.SIZE, 0)));
        }
        if (cOSArray2.size() % 2 != 1) {
            this.objectNumbers = new ObjectNumbers(cOSArray2);
            return;
        }
        throw new IOException("Wrong number of values for /Index array in XRef: " + Arrays.toString(this.w));
    }

    private long parseValue(byte[] bArr, int i2, int i3) {
        long j = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            j += (((long) bArr[i4 + i2]) & 255) << (((i3 - i4) - 1) * 8);
        }
        return j;
    }

    public void parse() throws IOException {
        int value;
        int[] iArr = this.w;
        byte[] bArr = new byte[iArr[0] + iArr[1] + iArr[2]];
        while (!this.seqSource.isEOF() && this.objectNumbers.hasNext()) {
            this.seqSource.read(bArr);
            long jLongValue = this.objectNumbers.next().longValue();
            int[] iArr2 = this.w;
            int value2 = iArr2[0] == 0 ? 1 : (int) parseValue(bArr, 0, iArr2[0]);
            if (value2 != 0) {
                int[] iArr3 = this.w;
                long value3 = parseValue(bArr, iArr3[0], iArr3[1]);
                if (value2 == 1) {
                    int[] iArr4 = this.w;
                    value = (int) parseValue(bArr, iArr4[0] + iArr4[1], iArr4[2]);
                } else {
                    value = 0;
                }
                COSObjectKey cOSObjectKey = new COSObjectKey(jLongValue, value);
                if (value2 == 1) {
                    this.xrefTrailerResolver.setXRef(cOSObjectKey, value3);
                } else {
                    this.xrefTrailerResolver.setXRef(cOSObjectKey, -value3);
                }
            }
        }
        close();
    }
}
