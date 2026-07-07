package com.tom_roush.pdfbox.pdmodel.graphics.image;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import com.tom_roush.harmony.javax.imageio.stream.MemoryCacheImageOutputStream;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.filter.Filter;
import com.tom_roush.pdfbox.filter.FilterFactory;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class LosslessFactory {
    public static boolean usePredictorEncoder = false;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdmodel.graphics.image.LosslessFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class PredictorEncoder {
        public final byte[] aValues;
        public final byte[] alphaImageData;
        public final byte[] bValues;
        private final int bytesPerComponent = 1;
        private final int bytesPerPixel;
        public final byte[] cValues;
        private final byte[] dataRawRowAverage;
        private final byte[] dataRawRowNone;
        private final byte[] dataRawRowPaeth;
        private final byte[] dataRawRowSub;
        private final byte[] dataRawRowUp;
        private final PDDocument document;
        public final boolean hasAlpha;
        private final int height;
        private final Bitmap image;
        public final Bitmap.Config imageType;
        public final byte[] tmpResultValues;
        private final int width;
        public final byte[] xValues;

        public PredictorEncoder(PDDocument pDDocument, Bitmap bitmap) {
            this.document = pDDocument;
            this.image = bitmap;
            int i2 = 1 * 3;
            this.bytesPerPixel = i2;
            int height = bitmap.getHeight();
            this.height = height;
            int width = bitmap.getWidth();
            this.width = width;
            this.imageType = bitmap.getConfig();
            boolean zHasAlpha = bitmap.hasAlpha();
            this.hasAlpha = zHasAlpha;
            this.alphaImageData = zHasAlpha ? new byte[height * width * 1] : null;
            int i3 = (width * i2) + 1;
            byte[] bArr = new byte[i3];
            this.dataRawRowNone = bArr;
            byte[] bArr2 = new byte[i3];
            this.dataRawRowSub = bArr2;
            byte[] bArr3 = new byte[i3];
            this.dataRawRowUp = bArr3;
            byte[] bArr4 = new byte[i3];
            this.dataRawRowAverage = bArr4;
            byte[] bArr5 = new byte[i3];
            this.dataRawRowPaeth = bArr5;
            bArr[0] = 0;
            bArr2[0] = 1;
            bArr3[0] = 2;
            bArr4[0] = 3;
            bArr5[0] = 4;
            this.aValues = new byte[i2];
            this.cValues = new byte[i2];
            this.bValues = new byte[i2];
            this.xValues = new byte[i2];
            this.tmpResultValues = new byte[i2];
        }

        private byte[] chooseDataRowToWrite() {
            byte[] bArr = this.dataRawRowNone;
            long jEstCompressSum = estCompressSum(bArr);
            long jEstCompressSum2 = estCompressSum(this.dataRawRowSub);
            long jEstCompressSum3 = estCompressSum(this.dataRawRowUp);
            long jEstCompressSum4 = estCompressSum(this.dataRawRowAverage);
            long jEstCompressSum5 = estCompressSum(this.dataRawRowPaeth);
            if (jEstCompressSum > jEstCompressSum2) {
                bArr = this.dataRawRowSub;
                jEstCompressSum = jEstCompressSum2;
            }
            if (jEstCompressSum > jEstCompressSum3) {
                bArr = this.dataRawRowUp;
            } else {
                jEstCompressSum3 = jEstCompressSum;
            }
            if (jEstCompressSum3 > jEstCompressSum4) {
                bArr = this.dataRawRowAverage;
            } else {
                jEstCompressSum4 = jEstCompressSum3;
            }
            return jEstCompressSum4 > jEstCompressSum5 ? this.dataRawRowPaeth : bArr;
        }

        private void copyIntToBytes(int[] iArr, int i2, byte[] bArr, byte[] bArr2, int i3) {
            int i4 = iArr[i2];
            byte bBlue = (byte) Color.blue(i4);
            byte bGreen = (byte) Color.green(i4);
            byte bRed = (byte) Color.red(i4);
            int i5 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[this.imageType.ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    return;
                }
                bArr[0] = bRed;
                bArr[1] = bGreen;
                bArr[2] = bBlue;
                return;
            }
            bArr[0] = bRed;
            bArr[1] = bGreen;
            bArr[2] = bBlue;
            if (bArr2 != null) {
                bArr2[i3] = (byte) Color.alpha(i4);
            }
        }

        private static long estCompressSum(byte[] bArr) {
            long jAbs = 0;
            for (byte b2 : bArr) {
                jAbs += (long) Math.abs((int) b2);
            }
            return jAbs;
        }

        private static byte pngFilterAverage(int i2, int i3, int i4) {
            return (byte) (i2 - ((i4 + i3) / 2));
        }

        private static byte pngFilterPaeth(int i2, int i3, int i4, int i5) {
            int i6 = (i3 + i4) - i5;
            int iAbs = Math.abs(i6 - i3);
            int iAbs2 = Math.abs(i6 - i4);
            int iAbs3 = Math.abs(i6 - i5);
            if (iAbs > iAbs2 || iAbs > iAbs3) {
                i3 = iAbs2 <= iAbs3 ? i4 : i5;
            }
            return (byte) (i2 - i3);
        }

        private static byte pngFilterSub(int i2, int i3) {
            return (byte) ((i2 & 255) - (i3 & 255));
        }

        private static byte pngFilterUp(int i2, int i3) {
            return pngFilterSub(i2, i3);
        }

        private PDImageXObject preparePredictorPDImage(ByteArrayOutputStream byteArrayOutputStream, int i2) throws IOException {
            int height = this.image.getHeight();
            int width = this.image.getWidth();
            PDImageXObject pDImageXObject = new PDImageXObject(this.document, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), COSName.FLATE_DECODE, width, height, i2, PDDeviceRGB.INSTANCE);
            COSDictionary cOSDictionary = new COSDictionary();
            cOSDictionary.setItem(COSName.BITS_PER_COMPONENT, (COSBase) COSInteger.get(i2));
            cOSDictionary.setItem(COSName.PREDICTOR, (COSBase) COSInteger.get(15L));
            cOSDictionary.setItem(COSName.COLUMNS, (COSBase) COSInteger.get(width));
            cOSDictionary.setItem(COSName.COLORS, (COSBase) COSInteger.get(3L));
            pDImageXObject.getCOSObject().setItem(COSName.DECODE_PARMS, (COSBase) cOSDictionary);
            if (this.hasAlpha) {
                pDImageXObject.getCOSObject().setItem(COSName.SMASK, LosslessFactory.prepareImageXObject(this.document, this.alphaImageData, this.image.getWidth(), this.image.getHeight(), this.bytesPerComponent * 8, PDDeviceGray.INSTANCE));
            }
            return pDImageXObject;
        }

        public PDImageXObject encode() throws IOException {
            int i2 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[this.imageType.ordinal()];
            if (i2 != 1 && i2 != 2) {
                return null;
            }
            int i3 = this.width;
            int i4 = i3 * 1;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((this.height * this.width) * this.bytesPerPixel) / 2);
            Deflater deflater = new Deflater(Filter.getCompressionLevel());
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            byte b2 = 0;
            int[] iArr = new int[i3 * 1];
            int[] iArr2 = new int[i3 * 1];
            int i5 = 0;
            int i6 = 0;
            while (i6 < this.height) {
                Bitmap bitmap = this.image;
                int i7 = this.width;
                bitmap.getPixels(iArr2, 0, i7, 0, i6, i7, 1);
                Arrays.fill(this.aValues, b2);
                Arrays.fill(this.cValues, b2);
                int i8 = i5;
                int i9 = 0;
                int i10 = 1;
                while (i9 < i4) {
                    int i11 = i9;
                    int i12 = i6;
                    copyIntToBytes(iArr2, i11, this.xValues, this.alphaImageData, i8);
                    copyIntToBytes(iArr, i11, this.bValues, null, 0);
                    int length = this.xValues.length;
                    for (int i13 = 0; i13 < length; i13++) {
                        int i14 = this.xValues[i13] & 255;
                        int i15 = this.aValues[i13] & 255;
                        int i16 = this.bValues[i13] & 255;
                        int i17 = this.cValues[i13] & 255;
                        this.dataRawRowNone[i10] = (byte) i14;
                        this.dataRawRowSub[i10] = pngFilterSub(i14, i15);
                        this.dataRawRowUp[i10] = pngFilterUp(i14, i16);
                        this.dataRawRowAverage[i10] = pngFilterAverage(i14, i15, i16);
                        this.dataRawRowPaeth[i10] = pngFilterPaeth(i14, i15, i16, i17);
                        i10++;
                    }
                    System.arraycopy(this.xValues, 0, this.aValues, 0, this.bytesPerPixel);
                    System.arraycopy(this.bValues, 0, this.cValues, 0, this.bytesPerPixel);
                    i9++;
                    i8 += this.bytesPerComponent;
                    i6 = i12;
                }
                byte[] bArrChooseDataRowToWrite = chooseDataRowToWrite();
                deflaterOutputStream.write(bArrChooseDataRowToWrite, 0, bArrChooseDataRowToWrite.length);
                i6++;
                i5 = i8;
                b2 = 0;
                int[] iArr3 = iArr;
                iArr = iArr2;
                iArr2 = iArr3;
            }
            deflaterOutputStream.close();
            deflater.end();
            return preparePredictorPDImage(byteArrayOutputStream, this.bytesPerComponent * 8);
        }
    }

    private LosslessFactory() {
    }

    private static PDImageXObject createFromGrayImage(Bitmap bitmap, PDDocument pDDocument) throws IOException {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int[] iArr = new int[width];
        int i2 = width * 8;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(((i2 / 8) + (i2 % 8 != 0 ? 1 : 0)) * height);
        MemoryCacheImageOutputStream memoryCacheImageOutputStream = new MemoryCacheImageOutputStream(byteArrayOutputStream);
        for (int i3 = 0; i3 < height; i3++) {
            bitmap.getPixels(iArr, 0, width, 0, i3, width, 1);
            for (int i4 = 0; i4 < width; i4++) {
                memoryCacheImageOutputStream.writeBits(iArr[i4] & 255, 8);
            }
            int bitOffset = memoryCacheImageOutputStream.getBitOffset();
            if (bitOffset != 0) {
                memoryCacheImageOutputStream.writeBits(0L, 8 - bitOffset);
            }
        }
        memoryCacheImageOutputStream.flush();
        memoryCacheImageOutputStream.close();
        return prepareImageXObject(pDDocument, byteArrayOutputStream.toByteArray(), bitmap.getWidth(), bitmap.getHeight(), 8, PDDeviceGray.INSTANCE);
    }

    public static PDImageXObject createFromImage(PDDocument pDDocument, Bitmap bitmap) throws IOException {
        PDImageXObject pDImageXObjectEncode;
        if (isGrayImage(bitmap)) {
            return createFromGrayImage(bitmap, pDDocument);
        }
        if (!usePredictorEncoder || (pDImageXObjectEncode = new PredictorEncoder(pDDocument, bitmap).encode()) == null) {
            return createFromRGBImage(bitmap, pDDocument);
        }
        if (pDImageXObjectEncode.getColorSpace() == PDDeviceRGB.INSTANCE && pDImageXObjectEncode.getBitsPerComponent() < 16 && bitmap.getWidth() * bitmap.getHeight() <= 2500) {
            PDImageXObject pDImageXObjectCreateFromRGBImage = createFromRGBImage(bitmap, pDDocument);
            if (pDImageXObjectCreateFromRGBImage.getCOSObject().getLength() < pDImageXObjectEncode.getCOSObject().getLength()) {
                Log.e("PdfBox-Android", "Return classic");
                pDImageXObjectEncode.getCOSObject().close();
                return pDImageXObjectCreateFromRGBImage;
            }
            Log.e("PdfBox-Android", "Return predictor");
            pDImageXObjectCreateFromRGBImage.getCOSObject().close();
        }
        return pDImageXObjectEncode;
    }

    private static PDImageXObject createFromRGBImage(Bitmap bitmap, PDDocument pDDocument) throws IOException {
        byte[] bArr;
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int[] iArr = new int[width];
        PDDeviceRGB pDDeviceRGB = PDDeviceRGB.INSTANCE;
        byte[] bArr2 = new byte[width * height * 3];
        if (bitmap.hasAlpha()) {
            int i2 = width * 8;
            bArr = new byte[((i2 / 8) + (i2 % 8 != 0 ? 1 : 0)) * height];
        } else {
            bArr = new byte[0];
        }
        byte[] bArr3 = bArr;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < height; i5++) {
            bitmap.getPixels(iArr, 0, width, 0, i5, width, 1);
            for (int i6 = 0; i6 < width; i6++) {
                int i7 = iArr[i6];
                int i8 = i3 + 1;
                bArr2[i3] = (byte) ((i7 >> 16) & 255);
                int i9 = i8 + 1;
                bArr2[i8] = (byte) ((i7 >> 8) & 255);
                i3 = i9 + 1;
                bArr2[i9] = (byte) (i7 & 255);
                if (bitmap.hasAlpha()) {
                    bArr3[i4] = (byte) ((i7 >> 24) & 255);
                    i4++;
                }
            }
        }
        PDImageXObject pDImageXObjectPrepareImageXObject = prepareImageXObject(pDDocument, bArr2, bitmap.getWidth(), bitmap.getHeight(), 8, pDDeviceRGB);
        if (bitmap.hasAlpha()) {
            pDImageXObjectPrepareImageXObject.getCOSObject().setItem(COSName.SMASK, prepareImageXObject(pDDocument, bArr3, bitmap.getWidth(), bitmap.getHeight(), 8, PDDeviceGray.INSTANCE));
        }
        return pDImageXObjectPrepareImageXObject;
    }

    private static boolean isGrayImage(Bitmap bitmap) {
        return bitmap.getConfig() == Bitmap.Config.ALPHA_8;
    }

    public static PDImageXObject prepareImageXObject(PDDocument pDDocument, byte[] bArr, int i2, int i3, int i4, PDColorSpace pDColorSpace) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length / 2);
        FilterFactory filterFactory = FilterFactory.INSTANCE;
        COSName cOSName = COSName.FLATE_DECODE;
        filterFactory.getFilter(cOSName).encode(new ByteArrayInputStream(bArr), byteArrayOutputStream, new COSDictionary(), 0);
        return new PDImageXObject(pDDocument, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), cOSName, i2, i3, i4, pDColorSpace);
    }
}
