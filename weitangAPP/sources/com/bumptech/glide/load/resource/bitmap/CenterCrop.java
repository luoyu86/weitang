package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* JADX INFO: loaded from: classes.dex */
public class CenterCrop extends BitmapTransformation {
    public CenterCrop(Context context) {
        super(context);
    }

    @Override // com.bumptech.glide.load.Transformation
    public String getId() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        Bitmap bitmap2 = bitmapPool.get(i2, i3, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Bitmap bitmapCenterCrop = TransformationUtils.centerCrop(bitmap2, bitmap, i2, i3);
        if (bitmap2 != null && bitmap2 != bitmapCenterCrop && !bitmapPool.put(bitmap2)) {
            bitmap2.recycle();
        }
        return bitmapCenterCrop;
    }

    public CenterCrop(BitmapPool bitmapPool) {
        super(bitmapPool);
    }
}
