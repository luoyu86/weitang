package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class VideoBitmapDecoder implements BitmapDecoder<ParcelFileDescriptor> {
    private static final MediaMetadataRetrieverFactory DEFAULT_FACTORY = new MediaMetadataRetrieverFactory();
    private static final int NO_FRAME = -1;
    private MediaMetadataRetrieverFactory factory;
    private int frame;

    public static class MediaMetadataRetrieverFactory {
        public MediaMetadataRetriever build() {
            return new MediaMetadataRetriever();
        }
    }

    public VideoBitmapDecoder() {
        this(DEFAULT_FACTORY, -1);
    }

    private static int checkValidFrame(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException("Requested frame must be non-negative");
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
    public String getId() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }

    public VideoBitmapDecoder(int i2) {
        this(DEFAULT_FACTORY, checkValidFrame(i2));
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapDecoder
    public Bitmap decode(ParcelFileDescriptor parcelFileDescriptor, BitmapPool bitmapPool, int i2, int i3, DecodeFormat decodeFormat) throws IOException {
        MediaMetadataRetriever mediaMetadataRetrieverBuild = this.factory.build();
        mediaMetadataRetrieverBuild.setDataSource(parcelFileDescriptor.getFileDescriptor());
        int i4 = this.frame;
        Bitmap frameAtTime = i4 >= 0 ? mediaMetadataRetrieverBuild.getFrameAtTime(i4) : mediaMetadataRetrieverBuild.getFrameAtTime();
        mediaMetadataRetrieverBuild.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    public VideoBitmapDecoder(MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory) {
        this(mediaMetadataRetrieverFactory, -1);
    }

    public VideoBitmapDecoder(MediaMetadataRetrieverFactory mediaMetadataRetrieverFactory, int i2) {
        this.factory = mediaMetadataRetrieverFactory;
        this.frame = i2;
    }
}
