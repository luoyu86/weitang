package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class GifBitmapWrapperStreamResourceDecoder implements ResourceDecoder<InputStream, GifBitmapWrapper> {
    private final ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> gifBitmapDecoder;

    public GifBitmapWrapperStreamResourceDecoder(ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> resourceDecoder) {
        this.gifBitmapDecoder = resourceDecoder;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public String getId() {
        return this.gifBitmapDecoder.getId();
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<GifBitmapWrapper> decode(InputStream inputStream, int i2, int i3) throws IOException {
        return this.gifBitmapDecoder.decode(new ImageVideoWrapper(inputStream, null), i2, i3);
    }
}
