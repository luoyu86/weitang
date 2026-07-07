package com.bumptech.glide;

import android.view.animation.Animation;

/* JADX INFO: loaded from: classes.dex */
public interface DrawableOptions {
    GenericRequestBuilder<?, ?, ?, ?> crossFade();

    GenericRequestBuilder<?, ?, ?, ?> crossFade(int i2);

    GenericRequestBuilder<?, ?, ?, ?> crossFade(int i2, int i3);

    @Deprecated
    GenericRequestBuilder<?, ?, ?, ?> crossFade(Animation animation, int i2);
}
