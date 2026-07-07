package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.MediaStoreThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class MediaStoreStreamLoader implements ModelLoader<Uri, InputStream> {
    private final Context context;
    private final ModelLoader<Uri, InputStream> uriLoader;

    public MediaStoreStreamLoader(Context context, ModelLoader<Uri, InputStream> modelLoader) {
        this.context = context;
        this.uriLoader = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public DataFetcher<InputStream> getResourceFetcher(Uri uri, int i2, int i3) {
        return new MediaStoreThumbFetcher(this.context, uri, this.uriLoader.getResourceFetcher(uri, i2, i3), i2, i3);
    }
}
