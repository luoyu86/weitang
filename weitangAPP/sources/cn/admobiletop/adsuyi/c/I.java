package cn.admobiletop.adsuyi.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import cn.admobiletop.adsuyi.c.A;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class I {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final A.d f4177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap f4178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InputStream f4179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4180d;

        public a(Bitmap bitmap, A.d dVar) {
            this((Bitmap) S.g(bitmap, "bitmap == null"), null, dVar, 0);
        }

        public Bitmap a() {
            return this.f4178b;
        }

        public int b() {
            return this.f4180d;
        }

        public A.d c() {
            return this.f4177a;
        }

        public InputStream d() {
            return this.f4179c;
        }

        public a(InputStream inputStream, A.d dVar) {
            this(null, (InputStream) S.g(inputStream, "stream == null"), dVar, 0);
        }

        public a(Bitmap bitmap, InputStream inputStream, A.d dVar, int i2) {
            if ((inputStream != null) ^ (bitmap != null)) {
                this.f4178b = bitmap;
                this.f4179c = inputStream;
                this.f4177a = (A.d) S.g(dVar, "loadedFrom == null");
                this.f4180d = i2;
                return;
            }
            throw new AssertionError();
        }
    }

    public static void b(int i2, int i3, int i4, int i5, BitmapFactory.Options options, G g2) {
        int iMax;
        double dFloor;
        if (i5 > i3 || i4 > i2) {
            if (i3 == 0) {
                dFloor = Math.floor(i4 / i2);
            } else if (i2 == 0) {
                dFloor = Math.floor(i5 / i3);
            } else {
                int iFloor = (int) Math.floor(i5 / i3);
                int iFloor2 = (int) Math.floor(i4 / i2);
                iMax = g2.l ? Math.max(iFloor, iFloor2) : Math.min(iFloor, iFloor2);
            }
            iMax = (int) dFloor;
        } else {
            iMax = 1;
        }
        options.inSampleSize = iMax;
        options.inJustDecodeBounds = false;
    }

    public static void c(int i2, int i3, BitmapFactory.Options options, G g2) {
        b(i2, i3, options.outWidth, options.outHeight, options, g2);
    }

    public static boolean d(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public static BitmapFactory.Options f(G g2) {
        boolean zC = g2.c();
        boolean z = g2.r != null;
        BitmapFactory.Options options = null;
        if (zC || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = zC;
            if (z) {
                options.inPreferredConfig = g2.r;
            }
        }
        return options;
    }

    public int a() {
        return 0;
    }

    public abstract a a(G g2, int i2);

    public abstract boolean a(G g2);

    public boolean e(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    public boolean g() {
        return false;
    }
}
