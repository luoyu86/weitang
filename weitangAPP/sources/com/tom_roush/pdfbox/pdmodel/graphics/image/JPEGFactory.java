package com.tom_roush.pdfbox.pdmodel.graphics.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.filter.FilterFactory;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class JPEGFactory {

    public static class Dimensions {
        private int height;
        private int numComponents;
        private int width;

        private Dimensions() {
        }
    }

    private JPEGFactory() {
    }

    private static PDImageXObject createAlphaFromARGBImage(PDDocument pDDocument, Bitmap bitmap) throws IOException {
        if (!bitmap.hasAlpha()) {
            return null;
        }
        int height = bitmap.getHeight() * bitmap.getWidth();
        int[] iArr = new int[height];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < height; i2++) {
            byteArrayOutputStream.write(Color.alpha(iArr[i2]));
        }
        return prepareImageXObject(pDDocument, byteArrayOutputStream.toByteArray(), bitmap.getWidth(), bitmap.getHeight(), 8, PDDeviceGray.INSTANCE);
    }

    public static PDImageXObject createFromByteArray(PDDocument pDDocument, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Dimensions dimensionsRetrieveDimensions = retrieveDimensions(byteArrayInputStream);
        return new PDImageXObject(pDDocument, byteArrayInputStream, COSName.DCT_DECODE, dimensionsRetrieveDimensions.width, dimensionsRetrieveDimensions.height, 8, PDDeviceRGB.INSTANCE);
    }

    public static PDImageXObject createFromImage(PDDocument pDDocument, Bitmap bitmap) throws IOException {
        return createFromImage(pDDocument, bitmap, 0.75f);
    }

    public static PDImageXObject createFromStream(PDDocument pDDocument, InputStream inputStream) throws IOException {
        return createFromByteArray(pDDocument, IOUtils.toByteArray(inputStream));
    }

    private static PDImageXObject createJPEG(PDDocument pDDocument, Bitmap bitmap, float f2, int i2) throws IOException {
        PDImageXObject pDImageXObject = new PDImageXObject(pDDocument, new ByteArrayInputStream(encodeImageToJPEGStream(bitmap, f2, i2)), COSName.DCT_DECODE, bitmap.getWidth(), bitmap.getHeight(), 8, PDDeviceRGB.INSTANCE);
        if (bitmap.hasAlpha()) {
            pDImageXObject.getCOSObject().setItem(COSName.SMASK, createAlphaFromARGBImage(pDDocument, bitmap));
        }
        return pDImageXObject;
    }

    private static byte[] encodeImageToJPEGStream(Bitmap bitmap, float f2, int i2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, (int) (f2 * 100.0f), byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static Bitmap getAlphaImage(Bitmap bitmap) {
        if (bitmap.hasAlpha()) {
            return bitmap.extractAlpha();
        }
        return null;
    }

    private static Bitmap getColorImage(Bitmap bitmap) {
        if (!bitmap.hasAlpha()) {
            return bitmap;
        }
        if (!bitmap.getConfig().name().contains("RGB")) {
            throw new UnsupportedOperationException("only RGB color spaces are implemented");
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Paint paint = new Paint();
        paint.setAlpha(0);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    private static PDImageXObject prepareImageXObject(PDDocument pDDocument, byte[] bArr, int i2, int i3, int i4, PDColorSpace pDColorSpace) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FilterFactory filterFactory = FilterFactory.INSTANCE;
        COSName cOSName = COSName.FLATE_DECODE;
        filterFactory.getFilter(cOSName).encode(new ByteArrayInputStream(bArr), byteArrayOutputStream, new COSDictionary(), 0);
        return new PDImageXObject(pDDocument, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), cOSName, i2, i3, i4, pDColorSpace);
    }

    private static Dimensions retrieveDimensions(ByteArrayInputStream byteArrayInputStream) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(byteArrayInputStream, null, options);
        byteArrayInputStream.reset();
        Dimensions dimensions = new Dimensions();
        dimensions.width = options.outWidth;
        dimensions.height = options.outHeight;
        return dimensions;
    }

    public static PDImageXObject createFromImage(PDDocument pDDocument, Bitmap bitmap, float f2) throws IOException {
        return createFromImage(pDDocument, bitmap, f2, 72);
    }

    public static PDImageXObject createFromImage(PDDocument pDDocument, Bitmap bitmap, float f2, int i2) throws IOException {
        return createJPEG(pDDocument, bitmap, f2, i2);
    }
}
