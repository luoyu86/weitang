package c.e.a.d;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.nanchen.compresshelper.CompressHelper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n {
    public static float a() {
        ((WindowManager) c.e.a.a.b.getInstance().getContext().getSystemService("window")).getDefaultDisplay().getMetrics(new DisplayMetrics());
        return r1.densityDpi;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i2 == 0 && i3 > 0) {
            return Math.round(i4 / i3);
        }
        if (i2 > 0 && i3 == 0) {
            return Math.round(i5 / i2);
        }
        if (i2 == 0 && i3 == 0) {
            return 1;
        }
        if (i4 <= i3 && i5 <= i2) {
            return 1;
        }
        int iRound = i5 > i4 ? Math.round(i4 / i3) : Math.round(i5 / i2);
        while ((i5 * i4) / (iRound * iRound) > i2 * i3 * 2) {
            iRound++;
        }
        return iRound;
    }

    public static String degreeBitmap(String str) {
        int exifOrientation = getExifOrientation(str);
        if (exifOrientation != 90 && exifOrientation != 180 && exifOrientation != 270) {
            return str;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(exifOrientation);
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        String strSaveBitmapToSdCard = saveBitmapToSdCard(Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true), l.getAppCacheDir().getPath() + System.currentTimeMillis() + l.getFileSuffix(str));
        bitmapDecodeFile.isRecycled();
        q.d(n.class.getSimpleName(), "savePath :" + strSaveBitmapToSdCard);
        return strSaveBitmapToSdCard;
    }

    public static String getBitmapWithScale(String str, int i2, int i3) {
        File file = new File(str);
        String name = file.getName();
        if (c.e.a.a.a.getInstance().isH5Model()) {
            name = System.currentTimeMillis() + file.getName();
        }
        try {
            File fileCompressToFile = new CompressHelper.Builder(c.e.a.a.b.getInstance().getContext()).setBitmapConfig(Bitmap.Config.ARGB_4444).setFileName(name).build().compressToFile(file);
            return fileCompressToFile != null ? getBitmapWithScaleToSrcPath(fileCompressToFile.getAbsolutePath(), str, i2, i3) : str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    public static String getBitmapWithScaleToSrcPath(String str, String str2, int i2, int i3) {
        Bitmap bitmapDecodeFile = null;
        if (str == null || !new File(str).exists()) {
            q.d(n.class.getSimpleName(), "getBitmapWithScale file path is null");
            return null;
        }
        getFolderNameByPath(str);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inPreferQualityOverSpeed = true;
        options.inDensity = (int) a();
        options.inTargetDensity = (int) a();
        BitmapFactory.decodeFile(str, options);
        int iCalculateInSampleSize = calculateInSampleSize(options, i2, i3);
        if (iCalculateInSampleSize > 1) {
            q.d(n.class.getSimpleName(), "getBitmapWithScale< 0 load scaled picture: , filePath： " + str);
            options.inJustDecodeBounds = false;
            options.inScaled = true;
            options.inSampleSize = iCalculateInSampleSize;
            bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
            saveBitmapToSdCard(bitmapDecodeFile, str2);
            str = str2;
        } else {
            q.d(n.class.getSimpleName(), "getBitmapWithScale else bitmap is null filePath: " + str);
        }
        if (bitmapDecodeFile != null && !bitmapDecodeFile.isRecycled()) {
            q.d(n.class.getSimpleName(), "getBitmapWithScale" + str + ": " + bitmapDecodeFile.getWidth() + ", " + bitmapDecodeFile.getHeight() + ", " + bitmapDecodeFile.getByteCount());
        }
        return str;
    }

    public static int getExifOrientation(String str) {
        ExifInterface exifInterface;
        try {
            exifInterface = new ExifInterface(str);
        } catch (IOException e2) {
            q.d(n.class.getSimpleName(), "cannot read exif" + e2);
            exifInterface = null;
        }
        if (exifInterface != null) {
            int attributeInt = exifInterface.getAttributeInt("Orientation", -1);
            q.d(n.class.getSimpleName(), "cannot read orientation:" + attributeInt);
            if (attributeInt != -1) {
                if (attributeInt == 3) {
                    return BaseTransientBottomBar.ANIMATION_FADE_DURATION;
                }
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 8) {
                    return 270;
                }
            }
        }
        return 0;
    }

    public static String getFolderNameByPath(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf("/") + 1, str.length());
    }

    public static List<c.k.b.a> getImageInfo(List<ResourceVo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (ResourceVo resourceVo : list) {
                if (resourceVo != null) {
                    c.k.b.a aVar = new c.k.b.a();
                    aVar.setThumbnailUrl(resourceVo.getUrl());
                    aVar.setBigImageUrl(resourceVo.getUrl());
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    public static String saveBitmapToSdCard(Bitmap bitmap, String str) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
        return str;
    }

    public static boolean saveImageToGallery(Context context, String str, String str2, Bitmap bitmap) {
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + str);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file, str2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            boolean zCompress = bitmap.compress(Bitmap.CompressFormat.JPEG, 60, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(file2)));
            return zCompress;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
