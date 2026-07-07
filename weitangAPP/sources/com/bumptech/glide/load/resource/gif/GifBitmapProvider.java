package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* JADX INFO: loaded from: classes.dex */
public class GifBitmapProvider implements GifDecoder.BitmapProvider {
    private final BitmapPool bitmapPool;

    public GifBitmapProvider(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public Bitmap obtain(int i2, int i3, Bitmap.Config config) {
        return this.bitmapPool.getDirty(i2, i3, config);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider
    public void release(Bitmap bitmap) {
        if (this.bitmapPool.put(bitmap)) {
            return;
        }
        bitmap.recycle();
    }
}
