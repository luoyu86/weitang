package com.bumptech.glide.request.target;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;

/* JADX INFO: loaded from: classes.dex */
public final class PreloadTarget<Z> extends SimpleTarget<Z> {
    private PreloadTarget(int i2, int i3) {
        super(i2, i3);
    }

    public static <Z> PreloadTarget<Z> obtain(int i2, int i3) {
        return new PreloadTarget<>(i2, i3);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z z, GlideAnimation<? super Z> glideAnimation) {
        Glide.clear(this);
    }
}
