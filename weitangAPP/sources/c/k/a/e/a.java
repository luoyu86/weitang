package c.k.a.e;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int getBitmapDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return BaseTransientBottomBar.ANIMATION_FADE_DURATION;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Uri getRotatedUri(Activity activity, String str) {
        int bitmapDegree = getBitmapDegree(str);
        if (bitmapDegree == 0) {
            return Uri.fromFile(new File(str));
        }
        return Uri.parse(MediaStore.Images.Media.insertImage(activity.getContentResolver(), rotateBitmapByDegree(BitmapFactory.decodeFile(str), bitmapDegree), (String) null, (String) null));
    }

    public static Bitmap rotateBitmapByDegree(Bitmap bitmap, int i2) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap rotateBitmapByDegree(String str, int i2) {
        return rotateBitmapByDegree(BitmapFactory.decodeFile(str), i2);
    }
}
