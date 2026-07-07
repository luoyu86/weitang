package c.g.a.a.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitmapRegionDecoder f2526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f2527b = new Object();

    @Override // c.g.a.a.c.d
    public Bitmap decodeRegion(Rect rect, int i2) {
        Bitmap bitmapDecodeRegion;
        synchronized (this.f2527b) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i2;
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            bitmapDecodeRegion = this.f2526a.decodeRegion(rect, options);
            if (bitmapDecodeRegion == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
        }
        return bitmapDecodeRegion;
    }

    @Override // c.g.a.a.c.d
    public Point init(Context context, Uri uri) throws Exception {
        int identifier;
        String string = uri.toString();
        if (string.startsWith("android.resource://")) {
            String authority = uri.getAuthority();
            Resources resources = context.getPackageName().equals(authority) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && pathSegments.get(0).equals(CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE)) {
                identifier = resources.getIdentifier(pathSegments.get(1), CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, authority);
            } else if (size == 1 && TextUtils.isDigitsOnly(pathSegments.get(0))) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    identifier = 0;
                }
            } else {
                identifier = 0;
            }
            this.f2526a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(identifier), false);
        } else if (string.startsWith("file:///android_asset/")) {
            this.f2526a = BitmapRegionDecoder.newInstance(context.getAssets().open(string.substring(22), 1), false);
        } else if (string.startsWith("file://")) {
            this.f2526a = BitmapRegionDecoder.newInstance(string.substring(7), false);
        } else {
            InputStream inputStreamOpenInputStream = null;
            try {
                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                this.f2526a = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th;
            }
        }
        return new Point(this.f2526a.getWidth(), this.f2526a.getHeight());
    }

    @Override // c.g.a.a.c.d
    public boolean isReady() {
        BitmapRegionDecoder bitmapRegionDecoder = this.f2526a;
        return (bitmapRegionDecoder == null || bitmapRegionDecoder.isRecycled()) ? false : true;
    }

    @Override // c.g.a.a.c.d
    public void recycle() {
        this.f2526a.recycle();
    }
}
