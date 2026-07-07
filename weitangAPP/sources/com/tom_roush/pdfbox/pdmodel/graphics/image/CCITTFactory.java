package com.tom_roush.pdfbox.pdmodel.graphics.image;

import android.graphics.Bitmap;
import com.tom_roush.harmony.javax.imageio.stream.MemoryCacheImageOutputStream;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.filter.Filter;
import com.tom_roush.pdfbox.filter.FilterFactory;
import com.tom_roush.pdfbox.io.RandomAccess;
import com.tom_roush.pdfbox.io.RandomAccessBuffer;
import com.tom_roush.pdfbox.io.RandomAccessFile;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class CCITTFactory {
    private CCITTFactory() {
    }

    public static PDImageXObject createFromByteArray(PDDocument pDDocument, byte[] bArr) throws IOException {
        return createFromByteArray(pDDocument, bArr, 0);
    }

    public static PDImageXObject createFromFile(PDDocument pDDocument, File file) throws IOException {
        return createFromFile(pDDocument, file, 0);
    }

    public static PDImageXObject createFromImage(PDDocument pDDocument, Bitmap bitmap) throws IOException {
        if (bitmap.getConfig() != Bitmap.Config.ALPHA_8) {
            throw new IllegalArgumentException("Only 1-bit b/w images supported");
        }
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int[] iArr = new int[width];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        MemoryCacheImageOutputStream memoryCacheImageOutputStream = new MemoryCacheImageOutputStream(byteArrayOutputStream);
        for (int i2 = 0; i2 < height; i2++) {
            bitmap.getPixels(iArr, 0, width, 0, i2, width, 1);
            for (int i3 = 0; i3 < width; i3++) {
                memoryCacheImageOutputStream.writeBits(~(iArr[i3] & 1), 1);
            }
            if (memoryCacheImageOutputStream.getBitOffset() != 0) {
                memoryCacheImageOutputStream.writeBits(0L, 8 - memoryCacheImageOutputStream.getBitOffset());
            }
        }
        memoryCacheImageOutputStream.flush();
        memoryCacheImageOutputStream.close();
        return prepareImageXObject(pDDocument, byteArrayOutputStream.toByteArray(), width, height, PDDeviceGray.INSTANCE);
    }

    @Deprecated
    public static PDImageXObject createFromRandomAccess(PDDocument pDDocument, RandomAccess randomAccess) throws IOException {
        return createFromRandomAccessImpl(pDDocument, randomAccess, 0);
    }

    private static PDImageXObject createFromRandomAccessImpl(PDDocument pDDocument, RandomAccess randomAccess, int i2) throws Throwable {
        COSDictionary cOSDictionary = new COSDictionary();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        extractFromTiff(randomAccess, byteArrayOutputStream, cOSDictionary, i2);
        if (byteArrayOutputStream.size() == 0) {
            return null;
        }
        PDImageXObject pDImageXObject = new PDImageXObject(pDDocument, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), COSName.CCITTFAX_DECODE, cOSDictionary.getInt(COSName.COLUMNS), cOSDictionary.getInt(COSName.ROWS), 1, PDDeviceGray.INSTANCE);
        pDImageXObject.getCOSObject().setItem(COSName.DECODE_PARMS, (COSBase) cOSDictionary);
        return pDImageXObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void extractFromTiff(com.tom_roush.pdfbox.io.RandomAccess r16, java.io.OutputStream r17, com.tom_roush.pdfbox.cos.COSDictionary r18, int r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 440
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.graphics.image.CCITTFactory.extractFromTiff(com.tom_roush.pdfbox.io.RandomAccess, java.io.OutputStream, com.tom_roush.pdfbox.cos.COSDictionary, int):void");
    }

    private static PDImageXObject prepareImageXObject(PDDocument pDDocument, byte[] bArr, int i2, int i3, PDColorSpace pDColorSpace) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FilterFactory filterFactory = FilterFactory.INSTANCE;
        COSName cOSName = COSName.CCITTFAX_DECODE;
        Filter filter = filterFactory.getFilter(cOSName);
        COSDictionary cOSDictionary = new COSDictionary();
        cOSDictionary.setInt(COSName.COLUMNS, i2);
        cOSDictionary.setInt(COSName.ROWS, i3);
        filter.encode(new ByteArrayInputStream(bArr), byteArrayOutputStream, cOSDictionary, 0);
        PDImageXObject pDImageXObject = new PDImageXObject(pDDocument, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), cOSName, i2, i3, 1, pDColorSpace);
        cOSDictionary.setInt(COSName.K, -1);
        pDImageXObject.getCOSObject().setItem(COSName.DECODE_PARMS, (COSBase) cOSDictionary);
        return pDImageXObject;
    }

    private static int readlong(char c2, RandomAccess randomAccess) throws IOException {
        int i2;
        int i3;
        if (c2 == 'I') {
            i2 = randomAccess.read() | (randomAccess.read() << 8) | (randomAccess.read() << 16);
            i3 = randomAccess.read() << 24;
        } else {
            i2 = (randomAccess.read() << 24) | (randomAccess.read() << 16) | (randomAccess.read() << 8);
            i3 = randomAccess.read();
        }
        return i2 | i3;
    }

    private static int readshort(char c2, RandomAccess randomAccess) throws IOException {
        int i2;
        int i3;
        if (c2 == 'I') {
            i2 = randomAccess.read();
            i3 = randomAccess.read() << 8;
        } else {
            i2 = randomAccess.read() << 8;
            i3 = randomAccess.read();
        }
        return i2 | i3;
    }

    public static PDImageXObject createFromByteArray(PDDocument pDDocument, byte[] bArr, int i2) throws IOException {
        RandomAccessBuffer randomAccessBuffer = new RandomAccessBuffer(bArr);
        try {
            return createFromRandomAccessImpl(pDDocument, randomAccessBuffer, i2);
        } finally {
            randomAccessBuffer.close();
        }
    }

    public static PDImageXObject createFromFile(PDDocument pDDocument, File file, int i2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, PDPageLabelRange.STYLE_ROMAN_LOWER);
        try {
            return createFromRandomAccessImpl(pDDocument, randomAccessFile, i2);
        } finally {
            randomAccessFile.close();
        }
    }

    @Deprecated
    public static PDImageXObject createFromRandomAccess(PDDocument pDDocument, RandomAccess randomAccess, int i2) throws IOException {
        return createFromRandomAccessImpl(pDDocument, randomAccess, i2);
    }
}
