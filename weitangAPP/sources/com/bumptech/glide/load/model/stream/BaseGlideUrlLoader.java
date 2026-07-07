package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseGlideUrlLoader<T> implements StreamModelLoader<T> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    private final ModelCache<T, GlideUrl> modelCache;

    public BaseGlideUrlLoader(Context context) {
        this(context, (ModelCache) null);
    }

    public Headers getHeaders(T t, int i2, int i3) {
        return Headers.DEFAULT;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public DataFetcher<InputStream> getResourceFetcher(T t, int i2, int i3) {
        ModelCache<T, GlideUrl> modelCache = this.modelCache;
        GlideUrl glideUrl = modelCache != null ? modelCache.get(t, i2, i3) : null;
        if (glideUrl == null) {
            String url = getUrl(t, i2, i3);
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(url, getHeaders(t, i2, i3));
            ModelCache<T, GlideUrl> modelCache2 = this.modelCache;
            if (modelCache2 != null) {
                modelCache2.put(t, i2, i3, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        return this.concreteLoader.getResourceFetcher(glideUrl, i2, i3);
    }

    public abstract String getUrl(T t, int i2, int i3);

    public BaseGlideUrlLoader(Context context, ModelCache<T, GlideUrl> modelCache) {
        this((ModelLoader<GlideUrl, InputStream>) Glide.buildModelLoader(GlideUrl.class, InputStream.class, context), modelCache);
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, (ModelCache) null);
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, ModelCache<T, GlideUrl> modelCache) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache;
    }
}
