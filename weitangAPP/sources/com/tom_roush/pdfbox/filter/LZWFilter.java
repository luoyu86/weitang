package com.tom_roush.pdfbox.filter;

import android.util.Log;
import com.tom_roush.harmony.javax.imageio.stream.MemoryCacheImageInputStream;
import com.tom_roush.harmony.javax.imageio.stream.MemoryCacheImageOutputStream;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LZWFilter extends Filter {
    public static final long CLEAR_TABLE = 256;
    public static final long EOD = 257;

    private int calculateChunk(int i2, int i3) {
        if (i2 >= 2048 - i3) {
            return 12;
        }
        if (i2 >= 1024 - i3) {
            return 11;
        }
        return i2 >= 512 - i3 ? 10 : 9;
    }

    private void checkIndexBounds(List<byte[]> list, long j, MemoryCacheImageInputStream memoryCacheImageInputStream) throws IOException {
        if (j < 0) {
            throw new IOException("negative array index: " + j + " near offset " + memoryCacheImageInputStream.getStreamPosition());
        }
        if (j < list.size()) {
            return;
        }
        throw new IOException("array index overflow: " + j + " >= " + list.size() + " near offset " + memoryCacheImageInputStream.getStreamPosition());
    }

    private List<byte[]> createCodeTable() {
        ArrayList arrayList = new ArrayList(4096);
        for (int i2 = 0; i2 < 256; i2++) {
            arrayList.add(new byte[]{(byte) (i2 & 255)});
        }
        arrayList.add(null);
        arrayList.add(null);
        return arrayList;
    }

    private void doLZWDecode(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        List<byte[]> arrayList = new ArrayList<>();
        MemoryCacheImageInputStream memoryCacheImageInputStream = new MemoryCacheImageInputStream(inputStream);
        loop0: while (true) {
            long j = -1;
            int iCalculateChunk = 9;
            while (true) {
                try {
                    long bits = memoryCacheImageInputStream.readBits(iCalculateChunk);
                    if (bits == 257) {
                        break loop0;
                    }
                    if (bits == 256) {
                        break;
                    }
                    if (bits < arrayList.size()) {
                        byte[] bArr = arrayList.get((int) bits);
                        byte b2 = bArr[0];
                        outputStream.write(bArr);
                        if (j != -1) {
                            checkIndexBounds(arrayList, j, memoryCacheImageInputStream);
                            byte[] bArr2 = arrayList.get((int) j);
                            byte[] bArrCopyOf = Arrays.copyOf(bArr2, bArr2.length + 1);
                            bArrCopyOf[bArr2.length] = b2;
                            arrayList.add(bArrCopyOf);
                        }
                    } else {
                        checkIndexBounds(arrayList, j, memoryCacheImageInputStream);
                        byte[] bArr3 = arrayList.get((int) j);
                        byte[] bArrCopyOf2 = Arrays.copyOf(bArr3, bArr3.length + 1);
                        bArrCopyOf2[bArr3.length] = bArr3[0];
                        outputStream.write(bArrCopyOf2);
                        arrayList.add(bArrCopyOf2);
                    }
                    iCalculateChunk = calculateChunk(arrayList.size(), i2);
                    j = bits;
                } catch (EOFException unused) {
                    Log.w("PdfBox-Android", "Premature EOF in LZW stream, EOD code missing");
                }
            }
            arrayList = createCodeTable();
        }
        outputStream.flush();
    }

    private int findPatternCode(List<byte[]> list, byte[] bArr) {
        int length = 0;
        int i2 = -1;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (size <= 257) {
                if (i2 != -1) {
                    return i2;
                }
                if (bArr.length > 1) {
                    return -1;
                }
            }
            byte[] bArr2 = list.get(size);
            if ((i2 != -1 || bArr2.length > length) && Arrays.equals(bArr2, bArr)) {
                length = bArr2.length;
                i2 = size;
            }
        }
        return i2;
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public DecodeResult decode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary, int i2) throws IOException {
        COSDictionary decodeParams = getDecodeParams(cOSDictionary, i2);
        int i3 = decodeParams.getInt(COSName.EARLY_CHANGE, 1);
        doLZWDecode(inputStream, Predictor.wrapPredictor(outputStream, decodeParams), (i3 == 0 || i3 == 1) ? i3 : 1);
        return new DecodeResult(cOSDictionary);
    }

    @Override // com.tom_roush.pdfbox.filter.Filter
    public void encode(InputStream inputStream, OutputStream outputStream, COSDictionary cOSDictionary) throws IOException {
        List<byte[]> listCreateCodeTable = createCodeTable();
        MemoryCacheImageOutputStream memoryCacheImageOutputStream = new MemoryCacheImageOutputStream(outputStream);
        memoryCacheImageOutputStream.writeBits(256L, 9);
        byte[] bArrCopyOf = null;
        int i2 = -1;
        while (true) {
            int i3 = inputStream.read();
            if (i3 == -1) {
                break;
            }
            byte b2 = (byte) i3;
            if (bArrCopyOf == null) {
                bArrCopyOf = new byte[]{b2};
            } else {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, bArrCopyOf.length + 1);
                bArrCopyOf[bArrCopyOf.length - 1] = b2;
                int iFindPatternCode = findPatternCode(listCreateCodeTable, bArrCopyOf);
                if (iFindPatternCode == -1) {
                    int iCalculateChunk = calculateChunk(listCreateCodeTable.size() - 1, 1);
                    memoryCacheImageOutputStream.writeBits(i2, iCalculateChunk);
                    listCreateCodeTable.add(bArrCopyOf);
                    if (listCreateCodeTable.size() == 4096) {
                        memoryCacheImageOutputStream.writeBits(256L, iCalculateChunk);
                        listCreateCodeTable = createCodeTable();
                    }
                    bArrCopyOf = new byte[]{b2};
                } else {
                    i2 = iFindPatternCode;
                }
            }
            i2 = b2 & 255;
        }
        if (i2 != -1) {
            memoryCacheImageOutputStream.writeBits(i2, calculateChunk(listCreateCodeTable.size() - 1, 1));
        }
        memoryCacheImageOutputStream.writeBits(257L, calculateChunk(listCreateCodeTable.size(), 1));
        memoryCacheImageOutputStream.writeBits(0L, 7);
        memoryCacheImageOutputStream.flush();
        memoryCacheImageOutputStream.close();
    }
}
