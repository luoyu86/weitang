package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* JADX INFO: loaded from: classes.dex */
public class FitCenter extends BitmapTransformation {
    public FitCenter(Context context) {
        super(context);
    }

    @Override // com.bumptech.glide.load.Transformation
    public String getId() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i2, int i3) {
        return TransformationUtils.fitCenter(bitmap, bitmapPool, i2, i3);
    }

    public FitCenter(BitmapPool bitmapPool) {
        super(bitmapPool);
    }
}
