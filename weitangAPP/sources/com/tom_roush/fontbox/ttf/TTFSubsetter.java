package com.tom_roush.fontbox.ttf;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.mail.UIDFolder;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public final class TTFSubsetter {
    private static final byte[] PAD_BUF = {0, 0, 0};
    private final SortedSet<Integer> glyphIds;
    private boolean hasAddedCompoundReferences;
    private final List<String> keepTables;
    private String prefix;
    private final TrueTypeFont ttf;
    private final SortedMap<Integer, Integer> uniToGID;
    private final CmapLookup unicodeCmap;

    public TTFSubsetter(TrueTypeFont trueTypeFont) throws IOException {
        this(trueTypeFont, null);
    }

    private void addCompoundReferences() throws IOException {
        boolean z;
        int i2;
        if (this.hasAddedCompoundReferences) {
            return;
        }
        this.hasAddedCompoundReferences = true;
        GlyphTable glyph = this.ttf.getGlyph();
        long[] offsets = this.ttf.getIndexToLocation().getOffsets();
        do {
            InputStream originalData = this.ttf.getOriginalData();
            TreeSet treeSet = null;
            try {
                originalData.skip(glyph.getOffset());
                long j = 0;
                Iterator<Integer> it = this.glyphIds.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    Integer next = it.next();
                    long j2 = offsets[next.intValue()];
                    long j3 = offsets[next.intValue() + 1] - j2;
                    originalData.skip(j2 - j);
                    int i3 = (int) j3;
                    byte[] bArr = new byte[i3];
                    originalData.read(bArr);
                    if (i3 >= 2 && bArr[0] == -1 && bArr[1] == -1) {
                        int i4 = 10;
                        do {
                            i2 = ((bArr[i4] & 255) << 8) | (bArr[i4 + 1] & 255);
                            int i5 = i4 + 2;
                            int i6 = ((bArr[i5] & 255) << 8) | (bArr[i5 + 1] & 255);
                            if (!this.glyphIds.contains(Integer.valueOf(i6))) {
                                if (treeSet == null) {
                                    treeSet = new TreeSet();
                                }
                                treeSet.add(Integer.valueOf(i6));
                            }
                            int i7 = i5 + 2;
                            i4 = (i2 & 1) != 0 ? i7 + 4 : i7 + 2;
                            if ((i2 & 128) != 0) {
                                i4 += 8;
                            } else if ((i2 & 64) != 0) {
                                i4 += 4;
                            } else if ((i2 & 8) != 0) {
                                i4 += 2;
                            }
                        } while ((i2 & 32) != 0);
                    }
                    j = offsets[next.intValue() + 1];
                }
                if (treeSet != null) {
                    this.glyphIds.addAll(treeSet);
                }
                if (treeSet != null) {
                    z = true;
                }
            } finally {
                originalData.close();
            }
        } while (z);
    }

    private byte[] buildCmapTable() throws IOException {
        if (this.ttf.getCmap() == null || this.uniToGID.isEmpty()) {
            return null;
        }
        List<String> list = this.keepTables;
        if (list != null && !list.contains(CmapTable.TAG)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        writeUint16(dataOutputStream, 0);
        writeUint16(dataOutputStream, 1);
        writeUint16(dataOutputStream, 3);
        writeUint16(dataOutputStream, 1);
        writeUint32(dataOutputStream, 12L);
        Iterator<Map.Entry<Integer, Integer>> it = this.uniToGID.entrySet().iterator();
        Map.Entry<Integer, Integer> next = it.next();
        int newGlyphId = getNewGlyphId(next.getValue());
        int size = this.uniToGID.size() + 1;
        int[] iArr = new int[size];
        int[] iArr2 = new int[size];
        int[] iArr3 = new int[size];
        int i2 = newGlyphId;
        int i3 = 0;
        Map.Entry<Integer, Integer> entry = next;
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> next2 = it.next();
            int newGlyphId2 = getNewGlyphId(next2.getValue());
            if (next2.getKey().intValue() > 65535) {
                throw new UnsupportedOperationException("non-BMP Unicode character");
            }
            if (next2.getKey().intValue() != entry.getKey().intValue() + 1 || newGlyphId2 - i2 != next2.getKey().intValue() - next.getKey().intValue()) {
                if (i2 != 0) {
                    iArr[i3] = next.getKey().intValue();
                    iArr2[i3] = entry.getKey().intValue();
                    iArr3[i3] = i2 - next.getKey().intValue();
                } else {
                    if (!next.getKey().equals(entry.getKey())) {
                        iArr[i3] = next.getKey().intValue() + 1;
                        iArr2[i3] = entry.getKey().intValue();
                        iArr3[i3] = i2 - next.getKey().intValue();
                    }
                    next = next2;
                    i2 = newGlyphId2;
                }
                i3++;
                next = next2;
                i2 = newGlyphId2;
            }
            entry = next2;
        }
        iArr[i3] = next.getKey().intValue();
        iArr2[i3] = entry.getKey().intValue();
        iArr3[i3] = i2 - next.getKey().intValue();
        int i4 = i3 + 1;
        iArr[i4] = 65535;
        iArr2[i4] = 65535;
        iArr3[i4] = 1;
        int i5 = i4 + 1;
        int iPow = ((int) Math.pow(2.0d, log2(i5))) * 2;
        writeUint16(dataOutputStream, 4);
        writeUint16(dataOutputStream, (i5 * 4 * 2) + 16);
        writeUint16(dataOutputStream, 0);
        int i6 = i5 * 2;
        writeUint16(dataOutputStream, i6);
        writeUint16(dataOutputStream, iPow);
        writeUint16(dataOutputStream, log2(iPow / 2));
        writeUint16(dataOutputStream, i6 - iPow);
        for (int i7 = 0; i7 < i5; i7++) {
            writeUint16(dataOutputStream, iArr2[i7]);
        }
        writeUint16(dataOutputStream, 0);
        for (int i8 = 0; i8 < i5; i8++) {
            writeUint16(dataOutputStream, iArr[i8]);
        }
        for (int i9 = 0; i9 < i5; i9++) {
            writeUint16(dataOutputStream, iArr3[i9]);
        }
        for (int i10 = 0; i10 < i5; i10++) {
            writeUint16(dataOutputStream, 0);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00fe A[Catch: all -> 0x0121, TryCatch #0 {all -> 0x0121, blocks: (B:3:0x001d, B:4:0x0030, B:6:0x0036, B:8:0x0060, B:10:0x0065, B:13:0x006b, B:15:0x00aa, B:17:0x00af, B:19:0x00b3, B:26:0x00c3, B:28:0x00c7, B:30:0x00cd, B:31:0x00dd, B:36:0x00f3, B:37:0x00f4, B:39:0x00fe, B:41:0x010d, B:20:0x00b6, B:22:0x00ba, B:23:0x00bd, B:25:0x00c1, B:16:0x00ad, B:35:0x00ee, B:42:0x0117), top: B:48:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] buildGlyfTable(long[] r21) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.fontbox.ttf.TTFSubsetter.buildGlyfTable(long[]):byte[]");
    }

    private byte[] buildHeadTable() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        HeaderTable header = this.ttf.getHeader();
        writeFixed(dataOutputStream, header.getVersion());
        writeFixed(dataOutputStream, header.getFontRevision());
        writeUint32(dataOutputStream, 0L);
        writeUint32(dataOutputStream, header.getMagicNumber());
        writeUint16(dataOutputStream, header.getFlags());
        writeUint16(dataOutputStream, header.getUnitsPerEm());
        writeLongDateTime(dataOutputStream, header.getCreated());
        writeLongDateTime(dataOutputStream, header.getModified());
        writeSInt16(dataOutputStream, header.getXMin());
        writeSInt16(dataOutputStream, header.getYMin());
        writeSInt16(dataOutputStream, header.getXMax());
        writeSInt16(dataOutputStream, header.getYMax());
        writeUint16(dataOutputStream, header.getMacStyle());
        writeUint16(dataOutputStream, header.getLowestRecPPEM());
        writeSInt16(dataOutputStream, header.getFontDirectionHint());
        writeSInt16(dataOutputStream, (short) 1);
        writeSInt16(dataOutputStream, header.getGlyphDataFormat());
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildHheaTable() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        HorizontalHeaderTable horizontalHeader = this.ttf.getHorizontalHeader();
        writeFixed(dataOutputStream, horizontalHeader.getVersion());
        writeSInt16(dataOutputStream, horizontalHeader.getAscender());
        writeSInt16(dataOutputStream, horizontalHeader.getDescender());
        writeSInt16(dataOutputStream, horizontalHeader.getLineGap());
        writeUint16(dataOutputStream, horizontalHeader.getAdvanceWidthMax());
        writeSInt16(dataOutputStream, horizontalHeader.getMinLeftSideBearing());
        writeSInt16(dataOutputStream, horizontalHeader.getMinRightSideBearing());
        writeSInt16(dataOutputStream, horizontalHeader.getXMaxExtent());
        writeSInt16(dataOutputStream, horizontalHeader.getCaretSlopeRise());
        writeSInt16(dataOutputStream, horizontalHeader.getCaretSlopeRun());
        writeSInt16(dataOutputStream, horizontalHeader.getReserved1());
        writeSInt16(dataOutputStream, horizontalHeader.getReserved2());
        writeSInt16(dataOutputStream, horizontalHeader.getReserved3());
        writeSInt16(dataOutputStream, horizontalHeader.getReserved4());
        writeSInt16(dataOutputStream, horizontalHeader.getReserved5());
        writeSInt16(dataOutputStream, horizontalHeader.getMetricDataFormat());
        int size = this.glyphIds.subSet(0, Integer.valueOf(horizontalHeader.getNumberOfHMetrics())).size();
        if (this.glyphIds.last().intValue() >= horizontalHeader.getNumberOfHMetrics() && !this.glyphIds.contains(Integer.valueOf(horizontalHeader.getNumberOfHMetrics() - 1))) {
            size++;
        }
        writeUint16(dataOutputStream, size);
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildHmtxTable() throws IOException {
        long jCopyBytes;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HorizontalHeaderTable horizontalHeader = this.ttf.getHorizontalHeader();
        HorizontalMetricsTable horizontalMetrics = this.ttf.getHorizontalMetrics();
        InputStream originalData = this.ttf.getOriginalData();
        int numberOfHMetrics = horizontalHeader.getNumberOfHMetrics() - 1;
        boolean z = this.glyphIds.last().intValue() > numberOfHMetrics && !this.glyphIds.contains(Integer.valueOf(numberOfHMetrics));
        try {
            originalData.skip(horizontalMetrics.getOffset());
            long jCopyBytes2 = 0;
            boolean z2 = z;
            for (Integer num : this.glyphIds) {
                if (num.intValue() <= numberOfHMetrics) {
                    jCopyBytes = copyBytes(originalData, byteArrayOutputStream, ((long) num.intValue()) * 4, jCopyBytes2, 4);
                } else {
                    if (z2) {
                        jCopyBytes2 = copyBytes(originalData, byteArrayOutputStream, ((long) numberOfHMetrics) * 4, jCopyBytes2, 2);
                        z2 = false;
                    }
                    jCopyBytes = copyBytes(originalData, byteArrayOutputStream, (((long) horizontalHeader.getNumberOfHMetrics()) * 4) + (((long) (num.intValue() - horizontalHeader.getNumberOfHMetrics())) * 2), jCopyBytes2, 2);
                }
                jCopyBytes2 = jCopyBytes;
            }
            return byteArrayOutputStream.toByteArray();
        } finally {
            originalData.close();
        }
    }

    private byte[] buildLocaTable(long[] jArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (long j : jArr) {
            writeUint32(dataOutputStream, j);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildMaxpTable() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        MaximumProfileTable maximumProfile = this.ttf.getMaximumProfile();
        writeFixed(dataOutputStream, 1.0d);
        writeUint16(dataOutputStream, this.glyphIds.size());
        writeUint16(dataOutputStream, maximumProfile.getMaxPoints());
        writeUint16(dataOutputStream, maximumProfile.getMaxContours());
        writeUint16(dataOutputStream, maximumProfile.getMaxCompositePoints());
        writeUint16(dataOutputStream, maximumProfile.getMaxCompositeContours());
        writeUint16(dataOutputStream, maximumProfile.getMaxZones());
        writeUint16(dataOutputStream, maximumProfile.getMaxTwilightPoints());
        writeUint16(dataOutputStream, maximumProfile.getMaxStorage());
        writeUint16(dataOutputStream, maximumProfile.getMaxFunctionDefs());
        writeUint16(dataOutputStream, maximumProfile.getMaxInstructionDefs());
        writeUint16(dataOutputStream, maximumProfile.getMaxStackElements());
        writeUint16(dataOutputStream, maximumProfile.getMaxSizeOfInstructions());
        writeUint16(dataOutputStream, maximumProfile.getMaxComponentElements());
        writeUint16(dataOutputStream, maximumProfile.getMaxComponentDepth());
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildNameTable() throws IOException {
        List<String> list;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        NamingTable naming = this.ttf.getNaming();
        if (naming == null || !((list = this.keepTables) == null || list.contains("name"))) {
            return null;
        }
        List<NameRecord> nameRecords = naming.getNameRecords();
        Iterator<NameRecord> it = nameRecords.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (shouldCopyNameRecord(it.next())) {
                i2++;
            }
        }
        writeUint16(dataOutputStream, 0);
        writeUint16(dataOutputStream, i2);
        writeUint16(dataOutputStream, (i2 * 12) + 6);
        if (i2 == 0) {
            return null;
        }
        byte[][] bArr = new byte[i2][];
        int i3 = 0;
        for (NameRecord nameRecord : nameRecords) {
            if (shouldCopyNameRecord(nameRecord)) {
                int platformId = nameRecord.getPlatformId();
                int platformEncodingId = nameRecord.getPlatformEncodingId();
                String str = "ISO-8859-1";
                if (platformId == 3 && platformEncodingId == 1) {
                    str = CharEncoding.UTF_16BE;
                } else if (platformId == 2) {
                    if (platformEncodingId == 0) {
                        str = CharEncoding.US_ASCII;
                    } else if (platformEncodingId == 1) {
                        str = "UTF16-BE";
                    }
                }
                String string = nameRecord.getString();
                if (nameRecord.getNameId() == 6 && this.prefix != null) {
                    string = this.prefix + string;
                }
                bArr[i3] = string.getBytes(str);
                i3++;
            }
        }
        int i4 = 0;
        int length = 0;
        for (NameRecord nameRecord2 : nameRecords) {
            if (shouldCopyNameRecord(nameRecord2)) {
                writeUint16(dataOutputStream, nameRecord2.getPlatformId());
                writeUint16(dataOutputStream, nameRecord2.getPlatformEncodingId());
                writeUint16(dataOutputStream, nameRecord2.getLanguageId());
                writeUint16(dataOutputStream, nameRecord2.getNameId());
                writeUint16(dataOutputStream, bArr[i4].length);
                writeUint16(dataOutputStream, length);
                length += bArr[i4].length;
                i4++;
            }
        }
        for (int i5 = 0; i5 < i2; i5++) {
            dataOutputStream.write(bArr[i5]);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildOS2Table() throws IOException {
        OS2WindowsMetricsTable oS2Windows = this.ttf.getOS2Windows();
        if (oS2Windows == null || this.uniToGID.isEmpty()) {
            return null;
        }
        List<String> list = this.keepTables;
        if (list != null && !list.contains(OS2WindowsMetricsTable.TAG)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        writeUint16(dataOutputStream, oS2Windows.getVersion());
        writeSInt16(dataOutputStream, oS2Windows.getAverageCharWidth());
        writeUint16(dataOutputStream, oS2Windows.getWeightClass());
        writeUint16(dataOutputStream, oS2Windows.getWidthClass());
        writeSInt16(dataOutputStream, oS2Windows.getFsType());
        writeSInt16(dataOutputStream, oS2Windows.getSubscriptXSize());
        writeSInt16(dataOutputStream, oS2Windows.getSubscriptYSize());
        writeSInt16(dataOutputStream, oS2Windows.getSubscriptXOffset());
        writeSInt16(dataOutputStream, oS2Windows.getSubscriptYOffset());
        writeSInt16(dataOutputStream, oS2Windows.getSuperscriptXSize());
        writeSInt16(dataOutputStream, oS2Windows.getSuperscriptYSize());
        writeSInt16(dataOutputStream, oS2Windows.getSuperscriptXOffset());
        writeSInt16(dataOutputStream, oS2Windows.getSuperscriptYOffset());
        writeSInt16(dataOutputStream, oS2Windows.getStrikeoutSize());
        writeSInt16(dataOutputStream, oS2Windows.getStrikeoutPosition());
        writeSInt16(dataOutputStream, (short) oS2Windows.getFamilyClass());
        dataOutputStream.write(oS2Windows.getPanose());
        writeUint32(dataOutputStream, 0L);
        writeUint32(dataOutputStream, 0L);
        writeUint32(dataOutputStream, 0L);
        writeUint32(dataOutputStream, 0L);
        dataOutputStream.write(oS2Windows.getAchVendId().getBytes(CharEncoding.US_ASCII));
        writeUint16(dataOutputStream, oS2Windows.getFsSelection());
        writeUint16(dataOutputStream, this.uniToGID.firstKey().intValue());
        writeUint16(dataOutputStream, this.uniToGID.lastKey().intValue());
        writeUint16(dataOutputStream, oS2Windows.getTypoAscender());
        writeUint16(dataOutputStream, oS2Windows.getTypoDescender());
        writeUint16(dataOutputStream, oS2Windows.getTypoLineGap());
        writeUint16(dataOutputStream, oS2Windows.getWinAscent());
        writeUint16(dataOutputStream, oS2Windows.getWinDescent());
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] buildPostTable() throws IOException {
        PostScriptTable postScript = this.ttf.getPostScript();
        if (postScript == null) {
            return null;
        }
        List<String> list = this.keepTables;
        if (list != null && !list.contains(PostScriptTable.TAG)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        writeFixed(dataOutputStream, 2.0d);
        writeFixed(dataOutputStream, postScript.getItalicAngle());
        writeSInt16(dataOutputStream, postScript.getUnderlinePosition());
        writeSInt16(dataOutputStream, postScript.getUnderlineThickness());
        writeUint32(dataOutputStream, postScript.getIsFixedPitch());
        writeUint32(dataOutputStream, postScript.getMinMemType42());
        writeUint32(dataOutputStream, postScript.getMaxMemType42());
        writeUint32(dataOutputStream, postScript.getMinMemType1());
        writeUint32(dataOutputStream, postScript.getMaxMemType1());
        writeUint16(dataOutputStream, this.glyphIds.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Integer> it = this.glyphIds.iterator();
        while (it.hasNext()) {
            String name = postScript.getName(it.next().intValue());
            Integer num = WGL4Names.MAC_GLYPH_NAMES_INDICES.get(name);
            if (num != null) {
                writeUint16(dataOutputStream, num.intValue());
            } else {
                Integer numValueOf = (Integer) linkedHashMap.get(name);
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(linkedHashMap.size());
                    linkedHashMap.put(name, numValueOf);
                }
                writeUint16(dataOutputStream, numValueOf.intValue() + WGL4Names.NUMBER_OF_MAC_GLYPHS);
            }
        }
        Iterator it2 = linkedHashMap.keySet().iterator();
        while (it2.hasNext()) {
            byte[] bytes = ((String) it2.next()).getBytes(Charset.forName(CharEncoding.US_ASCII));
            writeUint8(dataOutputStream, bytes.length);
            dataOutputStream.write(bytes);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    private long copyBytes(InputStream inputStream, OutputStream outputStream, long j, long j2, int i2) throws IOException {
        long j3 = j - j2;
        if (j3 != inputStream.skip(j3)) {
            throw new EOFException("Unexpected EOF exception parsing glyphId of hmtx table.");
        }
        byte[] bArr = new byte[i2];
        if (i2 != inputStream.read(bArr, 0, i2)) {
            throw new EOFException("Unexpected EOF exception parsing glyphId of hmtx table.");
        }
        outputStream.write(bArr, 0, i2);
        return j + ((long) i2);
    }

    private int getNewGlyphId(Integer num) {
        return this.glyphIds.headSet(num).size();
    }

    private int log2(int i2) {
        return (int) Math.floor(Math.log(i2) / Math.log(2.0d));
    }

    private boolean shouldCopyNameRecord(NameRecord nameRecord) {
        return nameRecord.getPlatformId() == 3 && nameRecord.getPlatformEncodingId() == 1 && nameRecord.getLanguageId() == 1033 && nameRecord.getNameId() >= 0 && nameRecord.getNameId() < 7;
    }

    private long toUInt32(int i2, int i3) {
        return (((long) i3) & WebSocketProtocol.PAYLOAD_SHORT_MAX) | ((((long) i2) & WebSocketProtocol.PAYLOAD_SHORT_MAX) << 16);
    }

    private long toUInt32(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 24) | ((((long) bArr[1]) & 255) << 16) | ((((long) bArr[2]) & 255) << 8) | (255 & ((long) bArr[3]));
    }

    private long writeFileHeader(DataOutputStream dataOutputStream, int i2) throws IOException {
        dataOutputStream.writeInt(65536);
        dataOutputStream.writeShort(i2);
        int iHighestOneBit = Integer.highestOneBit(i2);
        int i3 = iHighestOneBit * 16;
        dataOutputStream.writeShort(i3);
        int iLog2 = log2(iHighestOneBit);
        dataOutputStream.writeShort(iLog2);
        int i4 = (i2 * 16) - i3;
        dataOutputStream.writeShort(i4);
        return toUInt32(i2, i3) + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH + toUInt32(iLog2, i4);
    }

    private void writeFixed(DataOutputStream dataOutputStream, double d2) throws IOException {
        double dFloor = Math.floor(d2);
        dataOutputStream.writeShort((int) dFloor);
        dataOutputStream.writeShort((int) ((d2 - dFloor) * 65536.0d));
    }

    private void writeLongDateTime(DataOutputStream dataOutputStream, Calendar calendar) throws IOException {
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar2.set(1904, 0, 1, 0, 0, 0);
        calendar2.set(14, 0);
        dataOutputStream.writeLong((calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / 1000);
    }

    private void writeSInt16(DataOutputStream dataOutputStream, short s) throws IOException {
        dataOutputStream.writeShort(s);
    }

    private void writeTableBody(OutputStream outputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        outputStream.write(bArr);
        int i2 = length % 4;
        if (i2 != 0) {
            outputStream.write(PAD_BUF, 0, 4 - i2);
        }
    }

    private long writeTableHeader(DataOutputStream dataOutputStream, String str, long j, byte[] bArr) throws IOException {
        int length = bArr.length;
        long j2 = 0;
        for (int i2 = 0; i2 < length; i2++) {
            j2 += (((long) bArr[i2]) & 255) << (24 - ((i2 % 4) * 8));
        }
        long j3 = j2 & UIDFolder.MAXUID;
        byte[] bytes = str.getBytes(CharEncoding.US_ASCII);
        dataOutputStream.write(bytes, 0, 4);
        dataOutputStream.writeInt((int) j3);
        dataOutputStream.writeInt((int) j);
        dataOutputStream.writeInt(bArr.length);
        return toUInt32(bytes) + j3 + j3 + j + ((long) bArr.length);
    }

    private void writeUint16(DataOutputStream dataOutputStream, int i2) throws IOException {
        dataOutputStream.writeShort(i2);
    }

    private void writeUint32(DataOutputStream dataOutputStream, long j) throws IOException {
        dataOutputStream.writeInt((int) j);
    }

    private void writeUint8(DataOutputStream dataOutputStream, int i2) throws IOException {
        dataOutputStream.writeByte(i2);
    }

    public void add(int i2) {
        int glyphId = this.unicodeCmap.getGlyphId(i2);
        if (glyphId != 0) {
            this.uniToGID.put(Integer.valueOf(i2), Integer.valueOf(glyphId));
            this.glyphIds.add(Integer.valueOf(glyphId));
        }
    }

    public void addAll(Set<Integer> set) {
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            add(it.next().intValue());
        }
    }

    public Map<Integer, Integer> getGIDMap() throws IOException {
        addCompoundReferences();
        HashMap map = new HashMap();
        Iterator<Integer> it = this.glyphIds.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            map.put(Integer.valueOf(i2), Integer.valueOf(it.next().intValue()));
            i2++;
        }
        return map;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void writeToStream(OutputStream outputStream) throws IOException {
        List<String> list;
        if (this.glyphIds.isEmpty() || this.uniToGID.isEmpty()) {
            Log.i("PdfBox-Android", "font subset is empty");
        }
        addCompoundReferences();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        try {
            long[] jArr = new long[this.glyphIds.size() + 1];
            byte[] bArrBuildHeadTable = buildHeadTable();
            byte[] bArrBuildHheaTable = buildHheaTable();
            byte[] bArrBuildMaxpTable = buildMaxpTable();
            byte[] bArrBuildNameTable = buildNameTable();
            byte[] bArrBuildOS2Table = buildOS2Table();
            byte[] bArrBuildGlyfTable = buildGlyfTable(jArr);
            byte[] bArrBuildLocaTable = buildLocaTable(jArr);
            byte[] bArrBuildCmapTable = buildCmapTable();
            byte[] bArrBuildHmtxTable = buildHmtxTable();
            byte[] bArrBuildPostTable = buildPostTable();
            TreeMap treeMap = new TreeMap();
            if (bArrBuildOS2Table != null) {
                treeMap.put(OS2WindowsMetricsTable.TAG, bArrBuildOS2Table);
            }
            if (bArrBuildCmapTable != null) {
                treeMap.put(CmapTable.TAG, bArrBuildCmapTable);
            }
            treeMap.put(GlyphTable.TAG, bArrBuildGlyfTable);
            treeMap.put(HeaderTable.TAG, bArrBuildHeadTable);
            treeMap.put(HorizontalHeaderTable.TAG, bArrBuildHheaTable);
            treeMap.put(HorizontalMetricsTable.TAG, bArrBuildHmtxTable);
            treeMap.put(IndexToLocationTable.TAG, bArrBuildLocaTable);
            treeMap.put(MaximumProfileTable.TAG, bArrBuildMaxpTable);
            if (bArrBuildNameTable != null) {
                treeMap.put("name", bArrBuildNameTable);
            }
            if (bArrBuildPostTable != null) {
                treeMap.put(PostScriptTable.TAG, bArrBuildPostTable);
            }
            for (Map.Entry<String, TTFTable> entry : this.ttf.getTableMap().entrySet()) {
                String key = entry.getKey();
                TTFTable value = entry.getValue();
                if (!treeMap.containsKey(key) && ((list = this.keepTables) == null || list.contains(key))) {
                    treeMap.put(key, this.ttf.getTableBytes(value));
                }
            }
            long jWriteFileHeader = writeFileHeader(dataOutputStream, treeMap.size());
            long size = (((long) treeMap.size()) * 16) + 12;
            long length = size;
            long jWriteTableHeader = jWriteFileHeader;
            for (Map.Entry entry2 : treeMap.entrySet()) {
                jWriteTableHeader += writeTableHeader(dataOutputStream, (String) entry2.getKey(), length, (byte[]) entry2.getValue());
                length += (long) (((((byte[]) entry2.getValue()).length + 3) / 4) * 4);
            }
            long j = 2981146554L - (UIDFolder.MAXUID & jWriteTableHeader);
            bArrBuildHeadTable[8] = (byte) (j >>> 24);
            bArrBuildHeadTable[9] = (byte) (j >>> 16);
            bArrBuildHeadTable[10] = (byte) (j >>> 8);
            bArrBuildHeadTable[11] = (byte) j;
            Iterator it = treeMap.values().iterator();
            while (it.hasNext()) {
                writeTableBody(dataOutputStream, (byte[]) it.next());
            }
        } finally {
            dataOutputStream.close();
        }
    }

    public TTFSubsetter(TrueTypeFont trueTypeFont, List<String> list) throws IOException {
        this.ttf = trueTypeFont;
        this.keepTables = list;
        this.uniToGID = new TreeMap();
        TreeSet treeSet = new TreeSet();
        this.glyphIds = treeSet;
        this.unicodeCmap = trueTypeFont.getUnicodeCmapLookup();
        treeSet.add(0);
    }
}
