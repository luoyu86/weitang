package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class FileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {
    private final VideoBitmapDecoder bitmapDecoder;
    private final BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;

    public FileDescriptorBitmapDecoder(Context context) {
        this(Glide.get(context).getBitmapPool(), DecodeFormat.DEFAULT);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public String getId() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }

    public FileDescriptorBitmapDecoder(Context context, DecodeFormat decodeFormat) {
        this(Glide.get(context).getBitmapPool(), decodeFormat);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> decode(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3) throws IOException {
        return BitmapResource.obtain(this.bitmapDecoder.decode(parcelFileDescriptor, this.bitmapPool, i2, i3, this.decodeFormat), this.bitmapPool);
    }

    public FileDescriptorBitmapDecoder(BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this(new VideoBitmapDecoder(), bitmapPool, decodeFormat);
    }

    public FileDescriptorBitmapDecoder(VideoBitmapDecoder videoBitmapDecoder, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.bitmapDecoder = videoBitmapDecoder;
        this.bitmapPool = bitmapPool;
        this.decodeFormat = decodeFormat;
    }
}
