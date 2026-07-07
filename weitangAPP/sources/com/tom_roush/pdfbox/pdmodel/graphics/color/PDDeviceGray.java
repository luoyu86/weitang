package com.tom_roush.pdfbox.pdmodel.graphics.color;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import com.tom_roush.pdfbox.cos.COSName;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class PDDeviceGray extends PDDeviceColorSpace {
    public static final PDDeviceGray INSTANCE = new PDDeviceGray();
    private final PDColor initialColor = new PDColor(new float[]{0.0f}, this);

    private PDDeviceGray() {
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public float[] getDefaultDecode(int i2) {
        return new float[]{0.0f, 1.0f};
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public PDColor getInitialColor() {
        return this.initialColor;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public String getName() {
        return COSName.DEVICEGRAY.getName();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public int getNumberOfComponents() {
        return 1;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public float[] toRGB(float[] fArr) {
        return new float[]{fArr[0], fArr[0], fArr[0]};
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public Bitmap toRGBImage(Bitmap bitmap) throws IOException {
        if (bitmap.getConfig() != Bitmap.Config.ALPHA_8) {
            Log.e("PdfBox-Android", "Raster in PDDevicGrey was not ALPHA_8");
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width];
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] iArr2 = new int[width];
        for (int i2 = 0; i2 < height; i2++) {
            bitmap.getPixels(iArr, 0, width, 0, i2, width, 1);
            for (int i3 = 0; i3 < width; i3++) {
                int iAlpha = Color.alpha(iArr[i3]);
                iArr2[i3] = Color.argb(255, iAlpha, iAlpha, iAlpha);
            }
            bitmapCreateBitmap.setPixels(iArr2, 0, width, 0, i2, width, 1);
        }
        return bitmapCreateBitmap;
    }
}
