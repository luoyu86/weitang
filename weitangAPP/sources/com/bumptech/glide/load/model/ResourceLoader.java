package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.data.DataFetcher;

/* JADX INFO: loaded from: classes.dex */
public class ResourceLoader<T> implements ModelLoader<Integer, T> {
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader<Uri, T> uriLoader;

    public ResourceLoader(Context context, ModelLoader<Uri, T> modelLoader) {
        this(context.getResources(), modelLoader);
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, T> modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public DataFetcher<T> getResourceFetcher(Integer num, int i2, int i3) {
        Uri uri;
        try {
            uri = Uri.parse("android.resource://" + this.resources.getResourcePackageName(num.intValue()) + '/' + this.resources.getResourceTypeName(num.intValue()) + '/' + this.resources.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Received invalid resource id: " + num, e2);
            }
            uri = null;
        }
        if (uri != null) {
            return this.uriLoader.getResourceFetcher(uri, i2, i3);
        }
        return null;
    }
}
