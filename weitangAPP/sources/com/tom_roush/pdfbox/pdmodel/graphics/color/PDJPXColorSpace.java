package com.tom_roush.pdfbox.pdmodel.graphics.color;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.os.Build;
import com.tom_roush.pdfbox.cos.COSBase;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class PDJPXColorSpace extends PDColorSpace {
    private final ColorSpace colorSpace;

    public PDJPXColorSpace(ColorSpace colorSpace) {
        this.colorSpace = colorSpace;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace, com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSBase getCOSObject() {
        throw new UnsupportedOperationException("JPX color spaces don't have COS objects");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public float[] getDefaultDecode(int i2) {
        if (Build.VERSION.SDK_INT <= 26) {
            return new float[0];
        }
        int numberOfComponents = getNumberOfComponents();
        float[] fArr = new float[numberOfComponents * 2];
        for (int i3 = 0; i3 < numberOfComponents; i3++) {
            int i4 = i3 * 2;
            fArr[i4] = this.colorSpace.getMinValue(i3);
            fArr[i4 + 1] = this.colorSpace.getMaxValue(i3);
        }
        return fArr;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public PDColor getInitialColor() {
        throw new UnsupportedOperationException("JPX color spaces don't support drawing");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public String getName() {
        return "JPX";
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public int getNumberOfComponents() {
        if (Build.VERSION.SDK_INT > 26) {
            return this.colorSpace.getComponentCount();
        }
        return 0;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public float[] toRGB(float[] fArr) {
        throw new UnsupportedOperationException("JPX color spaces don't support drawing");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace
    public Bitmap toRGBImage(Bitmap bitmap) throws IOException {
        if (Build.VERSION.SDK_INT <= 26) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565, false, this.colorSpace);
        new Canvas(bitmapCreateBitmap).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapCreateBitmap;
    }
}
