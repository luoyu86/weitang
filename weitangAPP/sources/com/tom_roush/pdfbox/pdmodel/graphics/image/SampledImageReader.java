package com.tom_roush.pdfbox.pdmodel.graphics.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.filter.DecodeOptions;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class SampledImageReader {
    private SampledImageReader() {
    }

    private static Rect clipRegion(PDImage pDImage, Rect rect) {
        if (rect == null) {
            return new Rect(0, 0, pDImage.getWidth(), pDImage.getHeight());
        }
        int iMax = Math.max(0, rect.left);
        int iMax2 = Math.max(0, rect.top);
        return new Rect(iMax, iMax2, Math.min(rect.width(), pDImage.getWidth() - iMax), Math.min(rect.height(), pDImage.getHeight() - iMax2));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap createBitmapFromRawStream(java.io.InputStream r7, int r8, int r9, int r10) throws java.io.IOException {
        /*
            byte[] r7 = com.tom_roush.pdfbox.io.IOUtils.toByteArray(r7)
            int r0 = r7.length
            int r0 = r0 / r9
            int r0 = r0 / r8
            r1 = 1
            if (r9 != r1) goto L30
            int r9 = r8 * r0
            int r2 = r9 * 4
            byte[] r2 = new byte[r2]
            int r9 = r9 - r1
        L11:
            if (r9 < 0) goto L2e
            int r3 = r9 * 4
            int r4 = r3 + 3
            r5 = r7[r9]
            r2[r4] = r5
            r4 = r7[r9]
            r2[r3] = r4
            int r4 = r3 + 1
            r5 = r7[r9]
            r2[r4] = r5
            int r3 = r3 + 2
            r4 = r7[r9]
            r2[r3] = r4
            int r9 = r9 + (-1)
            goto L11
        L2e:
            r7 = r2
            goto L5c
        L30:
            r2 = 3
            if (r9 != r2) goto L5c
            int r9 = r8 * r0
            int r2 = r9 * 4
            byte[] r2 = new byte[r2]
            int r9 = r9 - r1
        L3a:
            if (r9 < 0) goto L2e
            int r3 = r9 * 4
            int r4 = r9 * 3
            int r5 = r3 + 3
            r6 = -1
            r2[r5] = r6
            r5 = r7[r4]
            r2[r3] = r5
            int r5 = r3 + 1
            int r6 = r4 + 1
            r6 = r7[r6]
            r2[r5] = r6
            int r3 = r3 + 2
            int r4 = r4 + 2
            r4 = r7[r4]
            r2[r3] = r4
            int r9 = r9 + (-1)
            goto L3a
        L5c:
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r8, r0, r9)
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.wrap(r7)
            r9.copyPixelsFromBuffer(r7)
            if (r10 <= r1) goto L71
            int r8 = r8 / r10
            int r0 = r0 / r10
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createScaledBitmap(r9, r8, r0, r1)
        L71:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.graphics.image.SampledImageReader.createBitmapFromRawStream(java.io.InputStream, int, int, int):android.graphics.Bitmap");
    }

    private static Bitmap from1Bit(PDImage pDImage, Rect rect, int i2, int i3, int i4) throws Throwable {
        InputStream inputStreamCreateInputStream;
        int width;
        int iHeight;
        int i5;
        int i6;
        PDColorSpace colorSpace = pDImage.getColorSpace();
        float[] decodeArray = getDecodeArray(pDImage);
        int i7 = i3;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, i4, Bitmap.Config.ALPHA_8);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmapCreateBitmap.getRowBytes() * i4);
        bitmapCreateBitmap.copyPixelsToBuffer(byteBufferAllocate);
        int i8 = i2;
        DecodeOptions decodeOptions = new DecodeOptions(i8);
        decodeOptions.setSourceRegion(rect);
        try {
            inputStreamCreateInputStream = pDImage.createInputStream(decodeOptions);
        } catch (Throwable th) {
            th = th;
            inputStreamCreateInputStream = null;
        }
        try {
            int i9 = 0;
            if (decodeOptions.isFilterSubsampled()) {
                iHeight = i4;
                width = i7;
                i5 = 0;
                i8 = 1;
                i6 = 0;
            } else {
                width = pDImage.getWidth();
                int i10 = rect.left;
                int i11 = rect.top;
                int iWidth = rect.width();
                iHeight = rect.height();
                i5 = i10;
                i7 = iWidth;
                i6 = i11;
            }
            byte[] bArrArray = byteBufferAllocate.array();
            boolean z = i8 == 1;
            int i12 = (width + 7) / 8;
            byte b2 = decodeArray[0] < decodeArray[1] ? (byte) 0 : (byte) -1;
            int i13 = i7 + i5;
            byte[] bArr = new byte[i12];
            int i14 = 0;
            while (true) {
                if (i9 >= i6 + iHeight) {
                    break;
                }
                byte[] bArr2 = bArrArray;
                int iPopulateBuffer = (int) IOUtils.populateBuffer(inputStreamCreateInputStream, bArr);
                if (i9 >= i6 && i9 % i8 == 0) {
                    int i15 = i5 / 8;
                    int i16 = i5;
                    while (i15 < i12 && i15 < iPopulateBuffer) {
                        int i17 = i16 & 7;
                        int i18 = (bArr[i15] ^ b2) << (i17 + 24);
                        int i19 = iHeight;
                        byte b3 = b2;
                        for (int iMin = Math.min(8 - i17, i13 - i16); iMin > 0; iMin--) {
                            if (z || i16 % i8 == 0) {
                                if (i18 < 0) {
                                    bArr2[i14] = -1;
                                }
                                i14++;
                            }
                            i18 <<= 1;
                            i16++;
                        }
                        i15++;
                        iHeight = i19;
                        b2 = b3;
                    }
                }
                int i20 = iHeight;
                byte b4 = b2;
                if (iPopulateBuffer != i12) {
                    Log.w("PdfBox-Android", "premature EOF, image will be incomplete");
                    break;
                }
                i9++;
                bArrArray = bArr2;
                iHeight = i20;
                b2 = b4;
            }
            byteBufferAllocate.rewind();
            bitmapCreateBitmap.copyPixelsFromBuffer(byteBufferAllocate);
            Bitmap rGBImage = colorSpace.toRGBImage(bitmapCreateBitmap);
            if (inputStreamCreateInputStream != null) {
                inputStreamCreateInputStream.close();
            }
            return rGBImage;
        } catch (Throwable th2) {
            th = th2;
            if (inputStreamCreateInputStream != null) {
                inputStreamCreateInputStream.close();
            }
            throw th;
        }
    }

    private static Bitmap from8bit(PDImage pDImage, Rect rect, int i2, int i3, int i4) throws IOException {
        int width;
        int i5;
        int iWidth;
        int iHeight;
        DecodeOptions decodeOptions = new DecodeOptions(i2);
        decodeOptions.setSourceRegion(rect);
        InputStream inputStreamCreateInputStream = pDImage.createInputStream(decodeOptions);
        try {
            int i6 = 0;
            if (decodeOptions.isFilterSubsampled()) {
                width = i3;
                iWidth = width;
                iHeight = i4;
                i2 = 1;
                i5 = 0;
            } else {
                width = pDImage.getWidth();
                i6 = rect.left;
                i5 = rect.top;
                iWidth = rect.width();
                iHeight = rect.height();
            }
            int numberOfComponents = pDImage.getColorSpace().getNumberOfComponents();
            if (i6 == 0 && i5 == 0 && iWidth == i3 && iHeight == i4) {
                return createBitmapFromRawStream(inputStreamCreateInputStream, width, numberOfComponents, i2);
            }
            Bitmap bitmapCreateBitmapFromRawStream = createBitmapFromRawStream(inputStreamCreateInputStream, width, numberOfComponents, i2);
            if (i2 > 1) {
                i6 /= i2;
                i5 /= i2;
            }
            return Bitmap.createBitmap(bitmapCreateBitmapFromRawStream, i6, i5, i3, i4);
        } finally {
            IOUtils.closeQuietly(inputStreamCreateInputStream);
        }
    }

    private static float[] getDecodeArray(PDImage pDImage) throws IOException {
        float[] floatArray;
        COSArray decode = pDImage.getDecode();
        if (decode == null) {
            floatArray = null;
        } else if (decode.size() != pDImage.getColorSpace().getNumberOfComponents() * 2) {
            if (pDImage.isStencil() && decode.size() >= 2 && (decode.get(0) instanceof COSNumber) && (decode.get(1) instanceof COSNumber)) {
                float fFloatValue = ((COSNumber) decode.get(0)).floatValue();
                float fFloatValue2 = ((COSNumber) decode.get(1)).floatValue();
                if (fFloatValue >= 0.0f && fFloatValue <= 1.0f && fFloatValue2 >= 0.0f && fFloatValue2 <= 1.0f) {
                    Log.w("PdfBox-Android", "decode array " + decode + " not compatible with color space, using the first two entries");
                    return new float[]{fFloatValue, fFloatValue2};
                }
            }
            Log.e("PdfBox-Android", "decode array " + decode + " not compatible with color space, using default");
            floatArray = null;
        } else {
            floatArray = decode.toFloatArray();
        }
        return floatArray == null ? pDImage.getColorSpace().getDefaultDecode(pDImage.getBitsPerComponent()) : floatArray;
    }

    public static Bitmap getRGBImage(PDImage pDImage, COSArray cOSArray) throws IOException {
        return getRGBImage(pDImage, null, 1, cOSArray);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        android.util.Log.w("PdfBox-Android", "premature EOF, image will be incomplete");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap getStencilImage(com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage r17, android.graphics.Paint r18) throws java.lang.Throwable {
        /*
            int r0 = r17.getWidth()
            int r1 = r17.getHeight()
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r0, r1, r2)
            android.graphics.Canvas r3 = new android.graphics.Canvas
            r3.<init>(r2)
            float r6 = (float) r0
            float r7 = (float) r1
            r4 = 0
            r5 = 0
            r8 = r18
            r3.drawRect(r4, r5, r6, r7, r8)
            r3 = 0
            com.tom_roush.harmony.javax.imageio.stream.MemoryCacheImageInputStream r4 = new com.tom_roush.harmony.javax.imageio.stream.MemoryCacheImageInputStream     // Catch: java.lang.Throwable -> L91
            java.io.InputStream r5 = r17.createInputStream()     // Catch: java.lang.Throwable -> L91
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L91
            float[] r3 = getDecodeArray(r17)     // Catch: java.lang.Throwable -> L8e
            r5 = 0
            r6 = r3[r5]     // Catch: java.lang.Throwable -> L8e
            r7 = 1
            r3 = r3[r7]     // Catch: java.lang.Throwable -> L8e
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 >= 0) goto L36
            r3 = 1
            goto L37
        L36:
            r3 = 0
        L37:
            int r6 = r0 / 8
            int r8 = r0 % 8
            if (r8 <= 0) goto L3f
            int r6 = r6 + 1
        L3f:
            byte[] r8 = new byte[r6]     // Catch: java.lang.Throwable -> L8e
            r9 = 0
        L42:
            if (r9 >= r1) goto L8a
            int r10 = r4.read(r8)     // Catch: java.lang.Throwable -> L8e
            r11 = 0
            r12 = 0
        L4a:
            if (r11 >= r6) goto L78
            if (r11 >= r10) goto L78
            r13 = r8[r11]     // Catch: java.lang.Throwable -> L8e
            r14 = 128(0x80, float:1.8E-43)
            r15 = 7
        L53:
            r7 = 8
            if (r5 >= r7) goto L70
            r7 = r13 & r14
            int r7 = r7 >> r15
            r16 = 1
            int r14 = r14 >> 1
            int r15 = r15 + (-1)
            if (r7 != r3) goto L67
            r7 = 0
            r2.setPixel(r12, r9, r7)     // Catch: java.lang.Throwable -> L8e
            goto L68
        L67:
            r7 = 0
        L68:
            int r12 = r12 + 1
            if (r12 != r0) goto L6d
            goto L73
        L6d:
            int r5 = r5 + 1
            goto L53
        L70:
            r7 = 0
            r16 = 1
        L73:
            int r11 = r11 + 1
            r5 = 0
            r7 = 1
            goto L4a
        L78:
            r7 = 0
            r16 = 1
            if (r10 == r6) goto L85
            java.lang.String r0 = "PdfBox-Android"
            java.lang.String r1 = "premature EOF, image will be incomplete"
            android.util.Log.w(r0, r1)     // Catch: java.lang.Throwable -> L8e
            goto L8a
        L85:
            int r9 = r9 + 1
            r5 = 0
            r7 = 1
            goto L42
        L8a:
            r4.close()
            return r2
        L8e:
            r0 = move-exception
            r3 = r4
            goto L92
        L91:
            r0 = move-exception
        L92:
            if (r3 == 0) goto L97
            r3.close()
        L97:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.graphics.image.SampledImageReader.getStencilImage(com.tom_roush.pdfbox.pdmodel.graphics.image.PDImage, android.graphics.Paint):android.graphics.Bitmap");
    }

    public static Bitmap getRGBImage(PDImage pDImage, Rect rect, int i2, COSArray cOSArray) throws IOException {
        if (pDImage.isEmpty()) {
            throw new IOException("Image stream is empty");
        }
        Rect rectClipRegion = clipRegion(pDImage, rect);
        int numberOfComponents = pDImage.getColorSpace().getNumberOfComponents();
        int iCeil = (int) Math.ceil(rectClipRegion.width() / i2);
        int iCeil2 = (int) Math.ceil(rectClipRegion.height() / i2);
        int bitsPerComponent = pDImage.getBitsPerComponent();
        if (iCeil <= 0 || iCeil2 <= 0 || pDImage.getWidth() <= 0 || pDImage.getHeight() <= 0) {
            throw new IOException("image width and height must be positive");
        }
        try {
            if (bitsPerComponent == 1 && cOSArray == null && numberOfComponents == 1) {
                return from1Bit(pDImage, rectClipRegion, i2, iCeil, iCeil2);
            }
            float[] defaultDecode = pDImage.getColorSpace().getDefaultDecode(8);
            float[] decodeArray = getDecodeArray(pDImage);
            if (pDImage.getSuffix() != null && pDImage.getSuffix().equals("jpg") && i2 == 1) {
                return BitmapFactory.decodeStream(pDImage.createInputStream());
            }
            if (bitsPerComponent == 8 && cOSArray == null && Arrays.equals(decodeArray, defaultDecode)) {
                return from8bit(pDImage, rectClipRegion, i2, iCeil, iCeil2);
            }
            Log.e("PdfBox-Android", "Trying to create other-bit image not supported");
            return from8bit(pDImage, rectClipRegion, i2, iCeil, iCeil2);
        } catch (NegativeArraySizeException e2) {
            throw new IOException(e2);
        }
    }
}
