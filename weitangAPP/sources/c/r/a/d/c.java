package c.r.a.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static boolean a(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    public static Bitmap getBitmapFromByte(byte[] bArr, int i2, int i3) {
        YuvImage yuvImage = new YuvImage(bArr, 17, i2, i3, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        if (!yuvImage.compressToJpeg(new Rect(0, 0, i2, i3), 100, byteArrayOutputStream)) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, b.getFileByPath(str), compressFormat, false);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        return save(bitmap, file, compressFormat, false);
    }

    public static boolean save(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z) {
        return save(bitmap, b.getFileByPath(str), compressFormat, z);
    }

    public static boolean save(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z) throws Throwable {
        boolean zCompress;
        BufferedOutputStream bufferedOutputStream;
        if (a(bitmap) || !b.createOrExistsFile(file)) {
            return false;
        }
        System.out.println(bitmap.getWidth() + ", " + bitmap.getHeight());
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            try {
                zCompress = bitmap.compress(compressFormat, 100, bufferedOutputStream);
                if (z) {
                    try {
                        if (!bitmap.isRecycled()) {
                            bitmap.recycle();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedOutputStream2 = bufferedOutputStream;
                        e.printStackTrace();
                        b.closeIO(bufferedOutputStream2);
                    }
                }
                b.closeIO(bufferedOutputStream);
            } catch (IOException e4) {
                e = e4;
                bufferedOutputStream2 = bufferedOutputStream;
                zCompress = false;
                e.printStackTrace();
                b.closeIO(bufferedOutputStream2);
                return zCompress;
            }
            return zCompress;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            b.closeIO(bufferedOutputStream2);
            throw th;
        }
    }
}
