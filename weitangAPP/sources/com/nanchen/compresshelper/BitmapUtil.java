package com.nanchen.compresshelper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class BitmapUtil {
    private BitmapUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int iRound;
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 > i3 || i5 > i2) {
            iRound = Math.round(i4 / i3);
            int iRound2 = Math.round(i5 / i2);
            if (iRound >= iRound2) {
                iRound = iRound2;
            }
        } else {
            iRound = 1;
        }
        while ((i5 * i4) / (iRound * iRound) > i2 * i3 * 2) {
            iRound++;
        }
        return iRound;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public static File compressImage(Context context, Uri uri, float f2, float f3, Bitmap.CompressFormat compressFormat, Bitmap.Config config, int i2, String str, String str2, String str3) throws Throwable {
        String strGenerateFilePath = generateFilePath(context, str, uri, compressFormat.name().toLowerCase(), str2, str3);
        ?? r2 = 0;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(strGenerateFilePath);
                try {
                    r2 = compressFormat;
                    getScaledBitmap(context, uri, f2, f3, config).compress(compressFormat, i2, fileOutputStream2);
                    fileOutputStream2.close();
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    r2 = fileOutputStream;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                        r2 = fileOutputStream;
                    }
                } catch (Throwable th) {
                    th = th;
                    r2 = fileOutputStream2;
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
            }
            return new File(strGenerateFilePath);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String generateFilePath(Context context, String str, Uri uri, String str2, String str3, String str4) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = str3 + FileUtil.splitFileName(FileUtil.getFileName(context, uri))[0];
        }
        return file.getAbsolutePath() + File.separator + str4 + Consts.DOT + str2;
    }

    public static Bitmap getScaledBitmap(Context context, Uri uri, float f2, float f3, Bitmap.Config config) {
        String realPathFromURI = FileUtil.getRealPathFromURI(context, uri);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(realPathFromURI, options);
        Bitmap bitmapCreateBitmap = null;
        if (bitmapDecodeFile == null) {
            try {
                FileInputStream fileInputStream = new FileInputStream(realPathFromURI);
                BitmapFactory.decodeStream(fileInputStream, null, options);
                fileInputStream.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        int attributeInt = options.outHeight;
        int attributeInt2 = options.outWidth;
        if (attributeInt == -1 || attributeInt2 == -1) {
            try {
                ExifInterface exifInterface = new ExifInterface(realPathFromURI);
                attributeInt = exifInterface.getAttributeInt("ImageLength", 1);
                attributeInt2 = exifInterface.getAttributeInt("ImageWidth", 1);
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        if (attributeInt2 <= 0 || attributeInt <= 0) {
            Bitmap bitmapDecodeFile2 = BitmapFactory.decodeFile(realPathFromURI);
            if (bitmapDecodeFile2 == null) {
                return null;
            }
            attributeInt2 = bitmapDecodeFile2.getWidth();
            attributeInt = bitmapDecodeFile2.getHeight();
        }
        float f4 = attributeInt2;
        float f5 = attributeInt;
        float f6 = f4 / f5;
        float f7 = f2 / f3;
        if (f5 > f3 || f4 > f2) {
            if (f6 < f7) {
                attributeInt2 = (int) ((f3 / f5) * f4);
                attributeInt = (int) f3;
            } else {
                attributeInt = f6 > f7 ? (int) ((f2 / f4) * f5) : (int) f3;
                attributeInt2 = (int) f2;
            }
        }
        options.inSampleSize = calculateInSampleSize(options, attributeInt2, attributeInt);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(realPathFromURI, options);
            if (bitmapDecodeFile == null) {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(realPathFromURI);
                    BitmapFactory.decodeStream(fileInputStream2, null, options);
                    fileInputStream2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
        } catch (OutOfMemoryError e6) {
            e6.printStackTrace();
        }
        if (attributeInt <= 0 || attributeInt2 <= 0) {
            return null;
        }
        try {
            bitmapCreateBitmap = Bitmap.createBitmap(attributeInt2, attributeInt, config);
        } catch (OutOfMemoryError e7) {
            e7.printStackTrace();
        }
        float f8 = attributeInt2 / options.outWidth;
        float f9 = attributeInt / options.outHeight;
        Matrix matrix = new Matrix();
        matrix.setScale(f8, f9, 0.0f, 0.0f);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmapDecodeFile, 0.0f, 0.0f, new Paint(2));
        try {
            int attributeInt3 = new ExifInterface(realPathFromURI).getAttributeInt("Orientation", 0);
            Matrix matrix2 = new Matrix();
            if (attributeInt3 == 6) {
                matrix2.postRotate(90.0f);
            } else if (attributeInt3 == 3) {
                matrix2.postRotate(180.0f);
            } else if (attributeInt3 == 8) {
                matrix2.postRotate(270.0f);
            }
            return Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight(), matrix2, true);
        } catch (IOException e8) {
            e8.printStackTrace();
            return bitmapCreateBitmap;
        }
    }
}
