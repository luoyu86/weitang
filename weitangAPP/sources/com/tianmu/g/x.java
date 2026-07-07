package com.tianmu.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.tianmu.g.r;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class x {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r.e f12184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bitmap f12185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final InputStream f12186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f12187d;

        public a(Bitmap bitmap, r.e eVar) {
            this((Bitmap) f0.a(bitmap, "bitmap == null"), null, eVar, 0);
        }

        public Bitmap a() {
            return this.f12185b;
        }

        public int b() {
            return this.f12187d;
        }

        public r.e c() {
            return this.f12184a;
        }

        public InputStream d() {
            return this.f12186c;
        }

        public a(InputStream inputStream, r.e eVar) {
            this(null, (InputStream) f0.a(inputStream, "stream == null"), eVar, 0);
        }

        public a(Bitmap bitmap, InputStream inputStream, r.e eVar, int i2) {
            if ((inputStream != null) ^ (bitmap != null)) {
                this.f12185b = bitmap;
                this.f12186c = inputStream;
                this.f12184a = (r.e) f0.a(eVar, "loadedFrom == null");
                this.f12187d = i2;
                return;
            }
            throw new AssertionError();
        }
    }

    public static boolean a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    public static BitmapFactory.Options b(v vVar) {
        boolean zC = vVar.c();
        boolean z = vVar.f12165q != null;
        BitmapFactory.Options options = null;
        if (zC || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = zC;
            if (z) {
                options.inPreferredConfig = vVar.f12165q;
            }
        }
        return options;
    }

    public int a() {
        return 0;
    }

    public abstract a a(v vVar, int i2);

    public abstract boolean a(v vVar);

    public boolean a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    public boolean b() {
        return false;
    }

    public static void a(int i2, int i3, BitmapFactory.Options options, v vVar) {
        a(i2, i3, options.outWidth, options.outHeight, options, vVar);
    }

    public static void a(int i2, int i3, int i4, int i5, BitmapFactory.Options options, v vVar) {
        int iMin;
        double dFloor;
        if (i5 > i3 || i4 > i2) {
            if (i3 == 0) {
                dFloor = Math.floor(i4 / i2);
            } else if (i2 == 0) {
                dFloor = Math.floor(i5 / i3);
            } else {
                int iFloor = (int) Math.floor(i5 / i3);
                int iFloor2 = (int) Math.floor(i4 / i2);
                if (vVar.k) {
                    iMin = Math.max(iFloor, iFloor2);
                } else {
                    iMin = Math.min(iFloor, iFloor2);
                }
            }
            iMin = (int) dFloor;
        } else {
            iMin = 1;
        }
        options.inSampleSize = iMin;
        options.inJustDecodeBounds = false;
    }
}
