package com.tom_roush.fontbox.ttf;

import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class KerningSubtable {
    private static final int COVERAGE_CROSS_STREAM = 4;
    private static final int COVERAGE_CROSS_STREAM_SHIFT = 2;
    private static final int COVERAGE_FORMAT = 65280;
    private static final int COVERAGE_FORMAT_SHIFT = 8;
    private static final int COVERAGE_HORIZONTAL = 1;
    private static final int COVERAGE_HORIZONTAL_SHIFT = 0;
    private static final int COVERAGE_MINIMUMS = 2;
    private static final int COVERAGE_MINIMUMS_SHIFT = 1;
    private boolean crossStream;
    private boolean horizontal;
    private boolean minimums;
    private PairData pairs;

    public interface PairData {
        int getKerning(int i2, int i3);

        void read(TTFDataStream tTFDataStream) throws IOException;
    }

    public static class PairData0Format0 implements Comparator<int[]>, PairData {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private int[][] pairs;
        private int searchRange;

        private PairData0Format0() {
        }

        @Override // com.tom_roush.fontbox.ttf.KerningSubtable.PairData
        public int getKerning(int i2, int i3) {
            int iBinarySearch = Arrays.binarySearch(this.pairs, new int[]{i2, i3, 0}, this);
            if (iBinarySearch >= 0) {
                return this.pairs[iBinarySearch][2];
            }
            return 0;
        }

        @Override // com.tom_roush.fontbox.ttf.KerningSubtable.PairData
        public void read(TTFDataStream tTFDataStream) throws IOException {
            int unsignedShort = tTFDataStream.readUnsignedShort();
            this.searchRange = tTFDataStream.readUnsignedShort() / 6;
            tTFDataStream.readUnsignedShort();
            tTFDataStream.readUnsignedShort();
            this.pairs = (int[][]) Array.newInstance((Class<?>) int.class, unsignedShort, 3);
            for (int i2 = 0; i2 < unsignedShort; i2++) {
                int unsignedShort2 = tTFDataStream.readUnsignedShort();
                int unsignedShort3 = tTFDataStream.readUnsignedShort();
                short signedShort = tTFDataStream.readSignedShort();
                int[][] iArr = this.pairs;
                iArr[i2][0] = unsignedShort2;
                iArr[i2][1] = unsignedShort3;
                iArr[i2][2] = signedShort;
            }
        }

        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int i2 = iArr[0];
            int i3 = iArr2[0];
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
            int i4 = iArr[1];
            int i5 = iArr2[1];
            if (i4 < i5) {
                return -1;
            }
            return i4 > i5 ? 1 : 0;
        }
    }

    private static int getBits(int i2, int i3, int i4) {
        return (i2 & i3) >> i4;
    }

    private static boolean isBitsSet(int i2, int i3, int i4) {
        return getBits(i2, i3, i4) != 0;
    }

    private void readSubtable0(TTFDataStream tTFDataStream) throws IOException {
        int unsignedShort = tTFDataStream.readUnsignedShort();
        if (unsignedShort != 0) {
            Log.i("PdfBox-Android", "Unsupported kerning sub-table version: " + unsignedShort);
            return;
        }
        int unsignedShort2 = tTFDataStream.readUnsignedShort();
        if (unsignedShort2 < 6) {
            throw new IOException("Kerning sub-table too short, got " + unsignedShort2 + " bytes, expect 6 or more.");
        }
        int unsignedShort3 = tTFDataStream.readUnsignedShort();
        if (isBitsSet(unsignedShort3, 1, 0)) {
            this.horizontal = true;
        }
        if (isBitsSet(unsignedShort3, 2, 1)) {
            this.minimums = true;
        }
        if (isBitsSet(unsignedShort3, 4, 2)) {
            this.crossStream = true;
        }
        int bits = getBits(unsignedShort3, 65280, 8);
        if (bits == 0) {
            readSubtable0Format0(tTFDataStream);
            return;
        }
        if (bits == 2) {
            readSubtable0Format2(tTFDataStream);
            return;
        }
        Log.d("PdfBox-Android", "Skipped kerning subtable due to an unsupported kerning subtable version: " + bits);
    }

    private void readSubtable0Format0(TTFDataStream tTFDataStream) throws IOException {
        PairData0Format0 pairData0Format0 = new PairData0Format0();
        this.pairs = pairData0Format0;
        pairData0Format0.read(tTFDataStream);
    }

    private void readSubtable0Format2(TTFDataStream tTFDataStream) {
        Log.i("PdfBox-Android", "Kerning subtable format 2 not yet supported.");
    }

    private void readSubtable1(TTFDataStream tTFDataStream) {
        Log.i("PdfBox-Android", "Kerning subtable format 1 not yet supported.");
    }

    public int[] getKerning(int[] iArr) {
        if (this.pairs == null) {
            Log.w("PdfBox-Android", "No kerning subtable data available due to an unsupported kerning subtable version");
            return null;
        }
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i2 = 0;
        while (i2 < length) {
            int i3 = iArr[i2];
            int i4 = -1;
            int i5 = i2 + 1;
            int i6 = i5;
            while (true) {
                if (i6 >= length) {
                    break;
                }
                int i7 = iArr[i6];
                if (i7 >= 0) {
                    i4 = i7;
                    break;
                }
                i6++;
            }
            iArr2[i2] = getKerning(i3, i4);
            i2 = i5;
        }
        return iArr2;
    }

    public boolean isHorizontalKerning() {
        return isHorizontalKerning(false);
    }

    public void read(TTFDataStream tTFDataStream, int i2) throws IOException {
        if (i2 == 0) {
            readSubtable0(tTFDataStream);
        } else {
            if (i2 != 1) {
                throw new IllegalStateException();
            }
            readSubtable1(tTFDataStream);
        }
    }

    public boolean isHorizontalKerning(boolean z) {
        if (this.horizontal && !this.minimums) {
            return z ? this.crossStream : !this.crossStream;
        }
        return false;
    }

    public int getKerning(int i2, int i3) {
        PairData pairData = this.pairs;
        if (pairData == null) {
            Log.w("PdfBox-Android", "No kerning subtable data available due to an unsupported kerning subtable version");
            return 0;
        }
        return pairData.getKerning(i2, i3);
    }
}
