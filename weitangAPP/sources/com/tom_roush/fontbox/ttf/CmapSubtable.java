package com.tom_roush.fontbox.ttf;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.alipay.sdk.m.u.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CmapSubtable implements CmapLookup {
    private static final long LEAD_OFFSET = 55232;
    private static final long SURROGATE_OFFSET = -56613888;
    private int[] glyphIdToCharacterCode;
    private int platformEncodingId;
    private int platformId;
    private long subTableOffset;
    private final Map<Integer, List<Integer>> glyphIdToCharacterCodeMultiple = new HashMap();
    private Map<Integer, Integer> characterCodeToGlyphId = new HashMap();

    public static class SubHeader {
        private final int entryCount;
        private final int firstCode;
        private final short idDelta;
        private final int idRangeOffset;

        /* JADX INFO: Access modifiers changed from: private */
        public int getEntryCount() {
            return this.entryCount;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getFirstCode() {
            return this.firstCode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public short getIdDelta() {
            return this.idDelta;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getIdRangeOffset() {
            return this.idRangeOffset;
        }

        private SubHeader(int i2, int i3, short s, int i4) {
            this.firstCode = i2;
            this.entryCount = i3;
            this.idDelta = s;
            this.idRangeOffset = i4;
        }
    }

    private void buildGlyphIdToCharacterCodeLookup(int i2) {
        this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(i2 + 1);
        for (Map.Entry<Integer, Integer> entry : this.characterCodeToGlyphId.entrySet()) {
            if (this.glyphIdToCharacterCode[entry.getValue().intValue()] == -1) {
                this.glyphIdToCharacterCode[entry.getValue().intValue()] = entry.getKey().intValue();
            } else {
                List<Integer> arrayList = this.glyphIdToCharacterCodeMultiple.get(entry.getValue());
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.glyphIdToCharacterCodeMultiple.put(entry.getValue(), arrayList);
                    arrayList.add(Integer.valueOf(this.glyphIdToCharacterCode[entry.getValue().intValue()]));
                    this.glyphIdToCharacterCode[entry.getValue().intValue()] = Integer.MIN_VALUE;
                }
                arrayList.add(entry.getKey());
            }
        }
    }

    private int getCharCode(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int[] iArr = this.glyphIdToCharacterCode;
        if (i2 >= iArr.length) {
            return -1;
        }
        return iArr[i2];
    }

    private int[] newGlyphIdToCharacterCode(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    @Override // com.tom_roush.fontbox.ttf.CmapLookup
    public List<Integer> getCharCodes(int i2) {
        int charCode = getCharCode(i2);
        if (charCode == -1) {
            return null;
        }
        if (charCode != Integer.MIN_VALUE) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(Integer.valueOf(charCode));
            return arrayList;
        }
        List<Integer> list = this.glyphIdToCharacterCodeMultiple.get(Integer.valueOf(i2));
        if (list == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(list);
        Collections.sort(arrayList2);
        return arrayList2;
    }

    @Deprecated
    public Integer getCharacterCode(int i2) {
        List<Integer> list;
        int charCode = getCharCode(i2);
        if (charCode == -1) {
            return null;
        }
        return (charCode != Integer.MIN_VALUE || (list = this.glyphIdToCharacterCodeMultiple.get(Integer.valueOf(i2))) == null) ? Integer.valueOf(charCode) : list.get(0);
    }

    @Override // com.tom_roush.fontbox.ttf.CmapLookup
    public int getGlyphId(int i2) {
        Integer num = this.characterCodeToGlyphId.get(Integer.valueOf(i2));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getPlatformEncodingId() {
        return this.platformEncodingId;
    }

    public int getPlatformId() {
        return this.platformId;
    }

    public void initData(TTFDataStream tTFDataStream) throws IOException {
        this.platformId = tTFDataStream.readUnsignedShort();
        this.platformEncodingId = tTFDataStream.readUnsignedShort();
        this.subTableOffset = tTFDataStream.readUnsignedInt();
    }

    public void initSubtable(CmapTable cmapTable, int i2, TTFDataStream tTFDataStream) throws IOException {
        tTFDataStream.seek(cmapTable.getOffset() + this.subTableOffset);
        int unsignedShort = tTFDataStream.readUnsignedShort();
        if (unsignedShort < 8) {
            tTFDataStream.readUnsignedShort();
            tTFDataStream.readUnsignedShort();
        } else {
            tTFDataStream.readUnsignedShort();
            tTFDataStream.readUnsignedInt();
            tTFDataStream.readUnsignedInt();
        }
        if (unsignedShort == 0) {
            processSubtype0(tTFDataStream);
            return;
        }
        if (unsignedShort == 2) {
            processSubtype2(tTFDataStream, i2);
            return;
        }
        if (unsignedShort == 4) {
            processSubtype4(tTFDataStream, i2);
            return;
        }
        if (unsignedShort == 6) {
            processSubtype6(tTFDataStream, i2);
            return;
        }
        if (unsignedShort == 8) {
            processSubtype8(tTFDataStream, i2);
            return;
        }
        if (unsignedShort == 10) {
            processSubtype10(tTFDataStream, i2);
            return;
        }
        switch (unsignedShort) {
            case 12:
                processSubtype12(tTFDataStream, i2);
                return;
            case 13:
                processSubtype13(tTFDataStream, i2);
                return;
            case 14:
                processSubtype14(tTFDataStream, i2);
                return;
            default:
                throw new IOException("Unknown cmap format:" + unsignedShort);
        }
    }

    public void processSubtype0(TTFDataStream tTFDataStream) throws IOException {
        byte[] bArr = tTFDataStream.read(256);
        this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(256);
        this.characterCodeToGlyphId = new HashMap(bArr.length);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            this.glyphIdToCharacterCode[i3] = i2;
            this.characterCodeToGlyphId.put(Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    public void processSubtype10(TTFDataStream tTFDataStream, int i2) throws IOException {
        long unsignedInt = tTFDataStream.readUnsignedInt();
        long unsignedInt2 = tTFDataStream.readUnsignedInt();
        if (unsignedInt2 > 2147483647L) {
            throw new IOException("Invalid number of Characters");
        }
        if (unsignedInt >= 0 && unsignedInt <= 1114111) {
            long j = unsignedInt + unsignedInt2;
            if (j <= 1114111 && (j < 55296 || j > 57343)) {
                return;
            }
        }
        throw new IOException("Invalid character codes, " + String.format("startCode: 0x%X, numChars: %d", Long.valueOf(unsignedInt), Long.valueOf(unsignedInt2)));
    }

    public void processSubtype12(TTFDataStream tTFDataStream, int i2) throws IOException {
        long unsignedInt = tTFDataStream.readUnsignedInt();
        this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(i2);
        this.characterCodeToGlyphId = new HashMap(i2);
        if (i2 == 0) {
            Log.w("PdfBox-Android", "subtable has no glyphs");
            return;
        }
        long j = 0;
        long j2 = 0;
        int iMax = 0;
        while (j2 < unsignedInt) {
            long unsignedInt2 = tTFDataStream.readUnsignedInt();
            long unsignedInt3 = tTFDataStream.readUnsignedInt();
            long unsignedInt4 = tTFDataStream.readUnsignedInt();
            long j3 = unsignedInt;
            if (unsignedInt2 < j || unsignedInt2 > 1114111 || (unsignedInt2 >= 55296 && unsignedInt2 <= 57343)) {
                throw new IOException("Invalid character code " + String.format("0x%X", Long.valueOf(unsignedInt2)));
            }
            if ((unsignedInt3 > j && unsignedInt3 < unsignedInt2) || unsignedInt3 > 1114111 || (unsignedInt3 >= 55296 && unsignedInt3 <= 57343)) {
                throw new IOException("Invalid character code " + String.format("0x%X", Long.valueOf(unsignedInt3)));
            }
            long j4 = j;
            while (true) {
                if (j4 <= unsignedInt3 - unsignedInt2) {
                    long j5 = unsignedInt4 + j4;
                    long j6 = unsignedInt3;
                    if (j5 >= i2) {
                        Log.w("PdfBox-Android", "Format 12 cmap contains an invalid glyph index");
                        break;
                    }
                    long j7 = unsignedInt2 + j4;
                    if (j7 > 1114111) {
                        Log.w("PdfBox-Android", "Format 12 cmap contains character beyond UCS-4");
                    }
                    int i3 = (int) j5;
                    iMax = Math.max(iMax, i3);
                    this.characterCodeToGlyphId.put(Integer.valueOf((int) j7), Integer.valueOf(i3));
                    j4++;
                    unsignedInt3 = j6;
                }
            }
            j2++;
            unsignedInt = j3;
            j = 0;
        }
        buildGlyphIdToCharacterCodeLookup(iMax);
    }

    public void processSubtype13(TTFDataStream tTFDataStream, int i2) throws IOException {
        int i3 = i2;
        long unsignedInt = tTFDataStream.readUnsignedInt();
        this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(i3);
        this.characterCodeToGlyphId = new HashMap(i3);
        if (i3 == 0) {
            Log.w("PdfBox-Android", "subtable has no glyphs");
            return;
        }
        long j = 0;
        while (j < unsignedInt) {
            long unsignedInt2 = tTFDataStream.readUnsignedInt();
            long unsignedInt3 = tTFDataStream.readUnsignedInt();
            long unsignedInt4 = tTFDataStream.readUnsignedInt();
            if (unsignedInt4 > i3) {
                Log.w("PdfBox-Android", "Format 13 cmap contains an invalid glyph index");
                return;
            }
            if (unsignedInt2 < 0 || unsignedInt2 > 1114111 || (unsignedInt2 >= 55296 && unsignedInt2 <= 57343)) {
                throw new IOException("Invalid character code " + String.format("0x%X", Long.valueOf(unsignedInt2)));
            }
            if ((unsignedInt3 > 0 && unsignedInt3 < unsignedInt2) || unsignedInt3 > 1114111 || (unsignedInt3 >= 55296 && unsignedInt3 <= 57343)) {
                throw new IOException("Invalid character code " + String.format("0x%X", Long.valueOf(unsignedInt3)));
            }
            long j2 = 0;
            while (j2 <= unsignedInt3 - unsignedInt2) {
                long j3 = unsignedInt;
                long j4 = unsignedInt2 + j2;
                if (j4 > 2147483647L) {
                    throw new IOException("Character Code greater than Integer.MAX_VALUE");
                }
                if (j4 > 1114111) {
                    Log.w("PdfBox-Android", "Format 13 cmap contains character beyond UCS-4");
                }
                int i4 = (int) unsignedInt4;
                int i5 = (int) j4;
                this.glyphIdToCharacterCode[i4] = i5;
                this.characterCodeToGlyphId.put(Integer.valueOf(i5), Integer.valueOf(i4));
                j2++;
                unsignedInt = j3;
            }
            j++;
            i3 = i2;
        }
    }

    public void processSubtype14(TTFDataStream tTFDataStream, int i2) throws IOException {
        Log.w("PdfBox-Android", "Format 14 cmap table is not supported and will be ignored");
    }

    public void processSubtype2(TTFDataStream tTFDataStream, int i2) throws IOException {
        SubHeader[] subHeaderArr;
        int[] iArr = new int[256];
        int iMax = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            iArr[i3] = tTFDataStream.readUnsignedShort();
            iMax = Math.max(iMax, iArr[i3] / 8);
        }
        SubHeader[] subHeaderArr2 = new SubHeader[iMax + 1];
        for (int i4 = 0; i4 <= iMax; i4++) {
            subHeaderArr2[i4] = new SubHeader(tTFDataStream.readUnsignedShort(), tTFDataStream.readUnsignedShort(), tTFDataStream.readSignedShort(), (tTFDataStream.readUnsignedShort() - (((r2 - i4) - 1) * 8)) - 2);
        }
        long currentPosition = tTFDataStream.getCurrentPosition();
        this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(i2);
        this.characterCodeToGlyphId = new HashMap(i2);
        if (i2 == 0) {
            Log.w("PdfBox-Android", "subtable has no glyphs");
            return;
        }
        for (int i5 = 0; i5 <= iMax; i5++) {
            SubHeader subHeader = subHeaderArr2[i5];
            int firstCode = subHeader.getFirstCode();
            int idRangeOffset = subHeader.getIdRangeOffset();
            short idDelta = subHeader.getIdDelta();
            int entryCount = subHeader.getEntryCount();
            tTFDataStream.seek(((long) idRangeOffset) + currentPosition);
            int i6 = 0;
            while (i6 < entryCount) {
                int i7 = (i5 << 8) + firstCode + i6;
                int unsignedShort = tTFDataStream.readUnsignedShort();
                if (unsignedShort > 0 && (unsignedShort = (unsignedShort + idDelta) % 65536) < 0) {
                    unsignedShort += 65536;
                }
                if (unsignedShort >= i2) {
                    StringBuilder sb = new StringBuilder();
                    subHeaderArr = subHeaderArr2;
                    sb.append("glyphId ");
                    sb.append(unsignedShort);
                    sb.append(" for charcode ");
                    sb.append(i7);
                    sb.append(" ignored, numGlyphs is ");
                    sb.append(i2);
                    Log.w("PdfBox-Android", sb.toString());
                } else {
                    subHeaderArr = subHeaderArr2;
                    this.glyphIdToCharacterCode[unsignedShort] = i7;
                    this.characterCodeToGlyphId.put(Integer.valueOf(i7), Integer.valueOf(unsignedShort));
                }
                i6++;
                subHeaderArr2 = subHeaderArr;
            }
        }
    }

    public void processSubtype4(TTFDataStream tTFDataStream, int i2) throws IOException {
        long j;
        int iMax;
        int unsignedShort = tTFDataStream.readUnsignedShort() / 2;
        tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        int[] unsignedShortArray = tTFDataStream.readUnsignedShortArray(unsignedShort);
        tTFDataStream.readUnsignedShort();
        int[] unsignedShortArray2 = tTFDataStream.readUnsignedShortArray(unsignedShort);
        int[] unsignedShortArray3 = tTFDataStream.readUnsignedShortArray(unsignedShort);
        long currentPosition = tTFDataStream.getCurrentPosition();
        int[] unsignedShortArray4 = tTFDataStream.readUnsignedShortArray(unsignedShort);
        this.characterCodeToGlyphId = new HashMap(i2);
        int i3 = 0;
        int i4 = 0;
        while (i3 < unsignedShort) {
            int i5 = unsignedShortArray2[i3];
            int i6 = unsignedShortArray[i3];
            int i7 = unsignedShortArray3[i3];
            int i8 = unsignedShortArray4[i3];
            int i9 = unsignedShort;
            int[] iArr = unsignedShortArray;
            int[] iArr2 = unsignedShortArray2;
            int[] iArr3 = unsignedShortArray3;
            long j2 = ((long) (i3 * 2)) + currentPosition + ((long) i8);
            int i10 = 65535;
            if (i5 != 65535 && i6 != 65535) {
                int i11 = i5;
                while (i11 <= i6) {
                    if (i8 == 0) {
                        j = currentPosition;
                        int i12 = (i11 + i7) & i10;
                        iMax = Math.max(i12, i4);
                        this.characterCodeToGlyphId.put(Integer.valueOf(i11), Integer.valueOf(i12));
                    } else {
                        j = currentPosition;
                        tTFDataStream.seek(((long) ((i11 - i5) * 2)) + j2);
                        int unsignedShort2 = tTFDataStream.readUnsignedShort();
                        if (unsignedShort2 != 0) {
                            int i13 = (unsignedShort2 + i7) & 65535;
                            iMax = Math.max(i13, i4);
                            this.characterCodeToGlyphId.put(Integer.valueOf(i11), Integer.valueOf(i13));
                        } else {
                            i11++;
                            currentPosition = j;
                            i10 = 65535;
                        }
                    }
                    i4 = iMax;
                    i11++;
                    currentPosition = j;
                    i10 = 65535;
                }
            }
            i3++;
            unsignedShortArray2 = iArr2;
            unsignedShort = i9;
            unsignedShortArray = iArr;
            unsignedShortArray3 = iArr3;
            currentPosition = currentPosition;
        }
        if (this.characterCodeToGlyphId.isEmpty()) {
            Log.w("PdfBox-Android", "cmap format 4 subtable is empty");
        } else {
            buildGlyphIdToCharacterCodeLookup(i4);
        }
    }

    public void processSubtype6(TTFDataStream tTFDataStream, int i2) throws IOException {
        int unsignedShort = tTFDataStream.readUnsignedShort();
        int unsignedShort2 = tTFDataStream.readUnsignedShort();
        if (unsignedShort2 == 0) {
            return;
        }
        this.characterCodeToGlyphId = new HashMap(i2);
        int[] unsignedShortArray = tTFDataStream.readUnsignedShortArray(unsignedShort2);
        int iMax = 0;
        for (int i3 = 0; i3 < unsignedShort2; i3++) {
            iMax = Math.max(iMax, unsignedShortArray[i3]);
            this.characterCodeToGlyphId.put(Integer.valueOf(unsignedShort + i3), Integer.valueOf(unsignedShortArray[i3]));
        }
        buildGlyphIdToCharacterCodeLookup(iMax);
    }

    public void processSubtype8(TTFDataStream tTFDataStream, int i2) throws IOException {
        int[] unsignedByteArray = tTFDataStream.readUnsignedByteArray(8192);
        long unsignedInt = tTFDataStream.readUnsignedInt();
        if (unsignedInt > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
            throw new IOException("CMap ( Subtype8 ) is invalid");
        }
        this.glyphIdToCharacterCode = newGlyphIdToCharacterCode(i2);
        this.characterCodeToGlyphId = new HashMap(i2);
        if (i2 == 0) {
            Log.w("PdfBox-Android", "subtable has no glyphs");
            return;
        }
        long j = 0;
        long j2 = 0;
        while (j2 < unsignedInt) {
            long unsignedInt2 = tTFDataStream.readUnsignedInt();
            long unsignedInt3 = tTFDataStream.readUnsignedInt();
            long unsignedInt4 = tTFDataStream.readUnsignedInt();
            if (unsignedInt2 > unsignedInt3 || j > unsignedInt2) {
                throw new IOException("Range invalid");
            }
            long j3 = unsignedInt2;
            while (j3 <= unsignedInt3) {
                if (j3 > 2147483647L) {
                    throw new IOException("[Sub Format 8] Invalid character code " + j3);
                }
                long j4 = unsignedInt;
                int i3 = (int) j3;
                int i4 = i3 / 8;
                long j5 = unsignedInt3;
                if (i4 >= unsignedByteArray.length) {
                    throw new IOException("[Sub Format 8] Invalid character code " + j3);
                }
                if ((unsignedByteArray[i4] & (1 << (i3 % 8))) != 0) {
                    long j6 = (((j3 >> 10) + LEAD_OFFSET) << 10) + (j3 & 1023) + 56320 + SURROGATE_OFFSET;
                    if (j6 > 2147483647L) {
                        throw new IOException("[Sub Format 8] Invalid character code " + j6);
                    }
                    i3 = (int) j6;
                }
                long j7 = (j3 - unsignedInt2) + unsignedInt4;
                int[] iArr = unsignedByteArray;
                if (j7 > i2 || j7 > 2147483647L) {
                    throw new IOException("CMap contains an invalid glyph index");
                }
                int i5 = (int) j7;
                this.glyphIdToCharacterCode[i5] = i3;
                this.characterCodeToGlyphId.put(Integer.valueOf(i3), Integer.valueOf(i5));
                j3++;
                unsignedInt = j4;
                unsignedInt3 = j5;
                unsignedByteArray = iArr;
            }
            j2++;
            j = 0;
        }
    }

    public void setPlatformEncodingId(int i2) {
        this.platformEncodingId = i2;
    }

    public void setPlatformId(int i2) {
        this.platformId = i2;
    }

    public String toString() {
        return "{" + getPlatformId() + " " + getPlatformEncodingId() + i.f5699d;
    }
}
