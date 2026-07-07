package c.e.a.c.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.zxing.LuminanceSource;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes.dex */
public final class g extends LuminanceSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f1171a;

    public g(String str) throws FileNotFoundException {
        this(a(str));
    }

    public static Bitmap a(String str) throws FileNotFoundException {
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile != null) {
            return bitmapDecodeFile;
        }
        throw new FileNotFoundException("Couldn't open " + str);
    }

    @Override // com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        return this.f1171a;
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
        System.arraycopy(this.f1171a, i2 * width, bArr, 0, width);
        return bArr;
    }

    public g(Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width * height;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        this.f1171a = new byte[i2];
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = i3 * width;
            for (int i5 = 0; i5 < width; i5++) {
                int i6 = i4 + i5;
                int i7 = iArr[i6];
                int i8 = (i7 >> 16) & 255;
                int i9 = (i7 >> 8) & 255;
                int i10 = i7 & 255;
                if (i8 == i9 && i9 == i10) {
                    this.f1171a[i6] = (byte) i8;
                } else {
                    this.f1171a[i6] = (byte) ((((i8 + i9) + i9) + i10) >> 2);
                }
            }
        }
    }
}
