package com.nanchen.compresshelper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ImageUtil {
    private static int calculateInSampleSize(BitmapFactory.Options options, String str, int i2, int i3) {
        int attributeInt = options.outHeight;
        int attributeInt2 = options.outWidth;
        int i4 = 1;
        if (attributeInt == -1 || attributeInt2 == -1) {
            try {
                ExifInterface exifInterface = new ExifInterface(str);
                attributeInt = exifInterface.getAttributeInt("ImageLength", 1);
                attributeInt2 = exifInterface.getAttributeInt("ImageWidth", 1);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        if (attributeInt > i3 || attributeInt2 > i2) {
            int i5 = attributeInt / 2;
            int i6 = attributeInt2 / 2;
            while (i5 / i4 > i3 && i6 / i4 > i2) {
                i4 *= 2;
            }
        }
        return i4;
    }

    private static Bitmap createScaleBitmap(Bitmap bitmap, int i2, int i3, int i4) {
        if (i4 % 2 == 0) {
            return bitmap;
        }
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, false);
        if (bitmap != bitmapCreateScaledBitmap) {
            bitmap.recycle();
        }
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, str, i2, i3);
        options.inJustDecodeBounds = false;
        return createScaleBitmap(BitmapFactory.decodeFile(str, options), i2, i3, options.inSampleSize);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i2, int i3, int i4) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i2, options);
        options.inSampleSize = calculateInSampleSize(options, i3, i4);
        options.inJustDecodeBounds = false;
        return createScaleBitmap(BitmapFactory.decodeResource(resources, i2, options), i3, i4, options.inSampleSize);
    }

    public static void deleteTempFile(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        int i6 = 1;
        if (i4 > i3 || i5 > i2) {
            int i7 = i4 / 2;
            int i8 = i5 / 2;
            while (i7 / i6 > i3 && i8 / i6 > i2) {
                i6 *= 2;
            }
        }
        return i6;
    }
}
