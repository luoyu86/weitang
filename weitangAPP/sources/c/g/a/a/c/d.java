package c.g.a.a.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public interface d {
    Bitmap decodeRegion(Rect rect, int i2);

    Point init(Context context, Uri uri) throws Exception;

    boolean isReady();

    void recycle();
}
