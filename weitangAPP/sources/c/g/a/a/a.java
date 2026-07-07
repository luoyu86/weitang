package c.g.a.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import anet.channel.util.HttpConstant;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f2513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f2514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f2515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f2519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2520h;

    public a(Bitmap bitmap, boolean z) {
        this.f2514b = bitmap;
        this.f2513a = null;
        this.f2515c = null;
        this.f2516d = false;
        this.f2517e = bitmap.getWidth();
        this.f2518f = bitmap.getHeight();
        this.f2520h = z;
    }

    public static a asset(String str) {
        Objects.requireNonNull(str, "Asset name must not be null");
        return uri("file:///android_asset/" + str);
    }

    public static a bitmap(Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        return new a(bitmap, false);
    }

    public static a cachedBitmap(Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        return new a(bitmap, true);
    }

    public static a resource(int i2) {
        return new a(i2);
    }

    public static a uri(String str) {
        Objects.requireNonNull(str, "Uri must not be null");
        if (!str.contains(HttpConstant.SCHEME_SPLIT)) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = "file:///" + str;
        }
        return new a(Uri.parse(str));
    }

    public final Bitmap a() {
        return this.f2514b;
    }

    public final Integer b() {
        return this.f2515c;
    }

    public final int c() {
        return this.f2518f;
    }

    public final Rect d() {
        return this.f2519g;
    }

    public a dimensions(int i2, int i3) {
        if (this.f2514b == null) {
            this.f2517e = i2;
            this.f2518f = i3;
        }
        i();
        return this;
    }

    public final int e() {
        return this.f2517e;
    }

    public final boolean f() {
        return this.f2516d;
    }

    public final Uri g() {
        return this.f2513a;
    }

    public final boolean h() {
        return this.f2520h;
    }

    public final void i() {
        Rect rect = this.f2519g;
        if (rect != null) {
            this.f2516d = true;
            this.f2517e = rect.width();
            this.f2518f = this.f2519g.height();
        }
    }

    public a region(Rect rect) {
        this.f2519g = rect;
        i();
        return this;
    }

    public a tiling(boolean z) {
        this.f2516d = z;
        return this;
    }

    public a tilingDisabled() {
        return tiling(false);
    }

    public a tilingEnabled() {
        return tiling(true);
    }

    public static a uri(Uri uri) {
        Objects.requireNonNull(uri, "Uri must not be null");
        return new a(uri);
    }

    public a(Uri uri) {
        String string = uri.toString();
        if (string.startsWith("file:///") && !new File(string.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(string, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.f2514b = null;
        this.f2513a = uri;
        this.f2515c = null;
        this.f2516d = true;
    }

    public a(int i2) {
        this.f2514b = null;
        this.f2513a = null;
        this.f2515c = Integer.valueOf(i2);
        this.f2516d = true;
    }
}
