package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class DrawableResource<T extends Drawable> implements Resource<T> {
    public final T drawable;

    public DrawableResource(T t) {
        Objects.requireNonNull(t, "Drawable must not be null!");
        this.drawable = t;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public final T get() {
        return (T) this.drawable.getConstantState().newDrawable();
    }
}
