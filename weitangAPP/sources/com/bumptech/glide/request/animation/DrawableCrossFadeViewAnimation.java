package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;

/* JADX INFO: loaded from: classes.dex */
public class DrawableCrossFadeViewAnimation<T extends Drawable> implements GlideAnimation<T> {
    private final GlideAnimation<T> defaultAnimation;
    private final int duration;

    public DrawableCrossFadeViewAnimation(GlideAnimation<T> glideAnimation, int i2) {
        this.defaultAnimation = glideAnimation;
        this.duration = i2;
    }

    @Override // com.bumptech.glide.request.animation.GlideAnimation
    public boolean animate(T t, GlideAnimation.ViewAdapter viewAdapter) {
        Drawable currentDrawable = viewAdapter.getCurrentDrawable();
        if (currentDrawable == null) {
            this.defaultAnimation.animate(t, viewAdapter);
            return false;
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{currentDrawable, t});
        transitionDrawable.setCrossFadeEnabled(true);
        transitionDrawable.startTransition(this.duration);
        viewAdapter.setDrawable(transitionDrawable);
        return true;
    }
}
