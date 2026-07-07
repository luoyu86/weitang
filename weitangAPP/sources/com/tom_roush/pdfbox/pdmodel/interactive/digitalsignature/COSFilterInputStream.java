package com.tom_roush.pdfbox.pdmodel.interactive.digitalsignature;

import com.tom_roush.pdfbox.io.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class COSFilterInputStream extends FilterInputStream {
    private long position;
    private int range;
    private int[][] ranges;

    public COSFilterInputStream(InputStream inputStream, int[] iArr) {
        super(inputStream);
        this.position = 0L;
        calculateRanges(iArr);
    }

    private void calculateRanges(int[] iArr) {
        this.ranges = new int[iArr.length / 2][];
        for (int i2 = 0; i2 < iArr.length / 2; i2++) {
            int i3 = i2 * 2;
            this.ranges[i2] = new int[]{iArr[i3], iArr[i3] + iArr[i3 + 1]};
        }
        this.range = -1;
    }

    private long getRemaining() {
        return ((long) this.ranges[this.range][1]) - this.position;
    }

    private boolean nextRange() throws IOException {
        int i2 = this.range;
        if (i2 + 1 >= this.ranges.length) {
            return false;
        }
        this.range = i2 + 1;
        while (true) {
            long j = this.position;
            int[][] iArr = this.ranges;
            int i3 = this.range;
            if (j >= iArr[i3][0]) {
                return true;
            }
            this.position += super.skip(((long) iArr[i3][0]) - j);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if ((this.range == -1 || getRemaining() <= 0) && !nextRange()) {
            return -1;
        }
        int i2 = super.read();
        this.position++;
        return i2;
    }

    public byte[] toByteArray() throws IOException {
        return IOUtils.toByteArray(this);
    }

    public COSFilterInputStream(byte[] bArr, int[] iArr) {
        this(new ByteArrayInputStream(bArr), iArr);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if ((this.range == -1 || getRemaining() <= 0) && !nextRange()) {
            return -1;
        }
        int i4 = super.read(bArr, i2, (int) Math.min(i3, getRemaining()));
        this.position += (long) i4;
        return i4;
    }
}
