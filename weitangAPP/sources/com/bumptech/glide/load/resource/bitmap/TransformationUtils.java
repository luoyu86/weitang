package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: classes.dex */
public final class TransformationUtils {
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";

    private TransformationUtils() {
    }

    public static Bitmap centerCrop(Bitmap bitmap, Bitmap bitmap2, int i2, int i3) {
        float width;
        float height;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i2 && bitmap2.getHeight() == i3) {
            return bitmap2;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap2.getWidth() * i3 > bitmap2.getHeight() * i2) {
            width = i3 / bitmap2.getHeight();
            width2 = (i2 - (bitmap2.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i2 / bitmap2.getWidth();
            height = (i3 - (bitmap2.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i2, i3, getSafeConfig(bitmap2));
        }
        setAlpha(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap fitCenter(Bitmap bitmap, BitmapPool bitmapPool, int i2, int i3) {
        if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float fMin = Math.min(i2 / bitmap.getWidth(), i3 / bitmap.getHeight());
        int width = (int) (bitmap.getWidth() * fMin);
        int height = (int) (bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap.Config safeConfig = getSafeConfig(bitmap);
        Bitmap bitmapCreateBitmap = bitmapPool.get(width, height, safeConfig);
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(width, height, safeConfig);
        }
        setAlpha(bitmap, bitmapCreateBitmap);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "request: " + i2 + "x" + i3);
            Log.v(TAG, "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v(TAG, "toReuse: " + bitmapCreateBitmap.getWidth() + "x" + bitmapCreateBitmap.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(fMin);
            Log.v(TAG, sb.toString());
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        canvas.drawBitmap(bitmap, matrix, new Paint(6));
        return bitmapCreateBitmap;
    }

    public static int getExifOrientationDegrees(int i2) {
        switch (i2) {
            case 3:
            case 4:
                return BaseTransientBottomBar.ANIMATION_FADE_DURATION;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @TargetApi(5)
    @Deprecated
    public static int getOrientation(String str) {
        try {
            return getExifOrientationDegrees(new ExifInterface(str).getAttributeInt("Orientation", 0));
        } catch (Exception e2) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "Unable to get orientation for image with path=" + str, e2);
            }
            return 0;
        }
    }

    private static Bitmap.Config getSafeConfig(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static void initializeMatrixForRotation(int i2, Matrix matrix) {
        switch (i2) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    @Deprecated
    public static Bitmap orientImage(String str, Bitmap bitmap) {
        return rotateImage(bitmap, getOrientation(str));
    }

    public static Bitmap rotateImage(Bitmap bitmap, int i2) {
        if (i2 == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate(i2);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e2) {
            if (!Log.isLoggable(TAG, 6)) {
                return bitmap;
            }
            Log.e(TAG, "Exception when trying to orient image", e2);
            return bitmap;
        }
    }

    public static Bitmap rotateImageExif(Bitmap bitmap, BitmapPool bitmapPool, int i2) {
        Matrix matrix = new Matrix();
        initializeMatrixForRotation(i2, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        int iRound = Math.round(rectF.width());
        int iRound2 = Math.round(rectF.height());
        Bitmap.Config safeConfig = getSafeConfig(bitmap);
        Bitmap bitmapCreateBitmap = bitmapPool.get(iRound, iRound2, safeConfig);
        if (bitmapCreateBitmap == null) {
            bitmapCreateBitmap = Bitmap.createBitmap(iRound, iRound2, safeConfig);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, matrix, new Paint(6));
        return bitmapCreateBitmap;
    }

    @TargetApi(12)
    public static void setAlpha(Bitmap bitmap, Bitmap bitmap2) {
        if (Build.VERSION.SDK_INT < 12 || bitmap2 == null) {
            return;
        }
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
