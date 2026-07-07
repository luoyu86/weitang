package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

/* JADX INFO: loaded from: classes.dex */
public interface BitmapDecoder<T> {
    Bitmap decode(T t, BitmapPool bitmapPool, int i2, int i3, DecodeFormat decodeFormat) throws Exception;

    String getId();
}
