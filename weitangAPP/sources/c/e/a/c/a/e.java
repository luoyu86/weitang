package c.e.a.c.a;

import android.graphics.Bitmap;
import com.google.zxing.LuminanceSource;

/* JADX INFO: loaded from: classes.dex */
public final class e extends LuminanceSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1144e;

    public e(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        if (i6 + i4 > i2 || i7 + i5 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f1140a = bArr;
        this.f1141b = i2;
        this.f1142c = i3;
        this.f1143d = i4;
        this.f1144e = i5;
    }

    public int getDataHeight() {
        return this.f1142c;
    }

    public int getDataWidth() {
        return this.f1141b;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i2 = this.f1141b;
        if (width == i2 && height == this.f1142c) {
            return this.f1140a;
        }
        int i3 = width * height;
        byte[] bArr = new byte[i3];
        int i4 = (this.f1144e * i2) + this.f1143d;
        if (width == i2) {
            System.arraycopy(this.f1140a, i4, bArr, 0, i3);
            return bArr;
        }
        byte[] bArr2 = this.f1140a;
        for (int i5 = 0; i5 < height; i5++) {
            System.arraycopy(bArr2, i4, bArr, i5 * width, width);
            i4 += this.f1141b;
        }
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getRow(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i2);
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.f1140a, ((i2 + this.f1144e) * this.f1141b) + this.f1143d, bArr, 0, width);
        return bArr;
    }

    @Override // com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public Bitmap renderCroppedGreyscaleBitmap() {
        int width = getWidth();
        int height = getHeight();
        int[] iArr = new int[width * height];
        byte[] bArr = this.f1140a;
        int i2 = (this.f1144e * this.f1141b) + this.f1143d;
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = i3 * width;
            for (int i5 = 0; i5 < width; i5++) {
                iArr[i4 + i5] = ((bArr[i2 + i5] & 255) * 65793) | (-16777216);
            }
            i2 += this.f1141b;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return bitmapCreateBitmap;
    }
}
