package com.tianmu.g;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tianmu.g.r;

/* JADX INFO: loaded from: classes2.dex */
public interface b0 {
    void onBitmapFailed(Drawable drawable);

    void onBitmapLoaded(Bitmap bitmap, r.e eVar);

    void onPrepareLoad(Drawable drawable);
}
