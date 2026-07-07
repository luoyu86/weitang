package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SimpleResource<T> implements Resource<T> {
    public final T data;

    public SimpleResource(T t) {
        Objects.requireNonNull(t, "Data must not be null");
        this.data = t;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final T get() {
        return this.data;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }
}
