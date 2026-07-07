package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.Priority;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;

/* JADX INFO: loaded from: classes.dex */
public class GifFrameModelLoader implements ModelLoader<GifDecoder, GifDecoder> {

    public static class GifFrameDataFetcher implements DataFetcher<GifDecoder> {
        private final GifDecoder decoder;

        public GifFrameDataFetcher(GifDecoder gifDecoder) {
            this.decoder = gifDecoder;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public String getId() {
            return String.valueOf(this.decoder.getCurrentFrameIndex());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.load.data.DataFetcher
        public GifDecoder loadData(Priority priority) {
            return this.decoder;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public DataFetcher<GifDecoder> getResourceFetcher(GifDecoder gifDecoder, int i2, int i3) {
        return new GifFrameDataFetcher(gifDecoder);
    }
}
