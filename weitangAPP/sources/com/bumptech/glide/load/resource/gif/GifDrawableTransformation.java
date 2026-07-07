package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

/* JADX INFO: loaded from: classes.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final BitmapPool bitmapPool;
    private final Transformation<Bitmap> wrapped;

    public GifDrawableTransformation(Transformation<Bitmap> transformation, BitmapPool bitmapPool) {
        this.wrapped = transformation;
        this.bitmapPool = bitmapPool;
    }

    @Override // com.bumptech.glide.load.Transformation
    public String getId() {
        return this.wrapped.getId();
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<GifDrawable> transform(Resource<GifDrawable> resource, int i2, int i3) {
        GifDrawable gifDrawable = resource.get();
        Bitmap firstFrame = resource.get().getFirstFrame();
        Bitmap bitmap = this.wrapped.transform(new BitmapResource(firstFrame, this.bitmapPool), i2, i3).get();
        return !bitmap.equals(firstFrame) ? new GifDrawableResource(new GifDrawable(gifDrawable, bitmap, this.wrapped)) : resource;
    }
}
