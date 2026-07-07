package com.bumptech.glide.request.animation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.bumptech.glide.request.animation.ViewAnimation;

/* JADX INFO: loaded from: classes.dex */
public class DrawableCrossFadeFactory<T extends Drawable> implements GlideAnimationFactory<T> {
    private static final int DEFAULT_DURATION_MS = 300;
    private final ViewAnimationFactory<T> animationFactory;
    private final int duration;
    private DrawableCrossFadeViewAnimation<T> firstResourceAnimation;
    private DrawableCrossFadeViewAnimation<T> secondResourceAnimation;

    public static class DefaultAnimationFactory implements ViewAnimation.AnimationFactory {
        private final int duration;

        public DefaultAnimationFactory(int i2) {
            this.duration = i2;
        }

        @Override // com.bumptech.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(this.duration);
            return alphaAnimation;
        }
    }

    public DrawableCrossFadeFactory() {
        this(300);
    }

    private GlideAnimation<T> getFirstResourceAnimation() {
        if (this.firstResourceAnimation == null) {
            this.firstResourceAnimation = new DrawableCrossFadeViewAnimation<>(this.animationFactory.build(false, true), this.duration);
        }
        return this.firstResourceAnimation;
    }

    private GlideAnimation<T> getSecondResourceAnimation() {
        if (this.secondResourceAnimation == null) {
            this.secondResourceAnimation = new DrawableCrossFadeViewAnimation<>(this.animationFactory.build(false, false), this.duration);
        }
        return this.secondResourceAnimation;
    }

    @Override // com.bumptech.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<T> build(boolean z, boolean z2) {
        return z ? NoAnimation.get() : z2 ? getFirstResourceAnimation() : getSecondResourceAnimation();
    }

    public DrawableCrossFadeFactory(int i2) {
        this(new ViewAnimationFactory(new DefaultAnimationFactory(i2)), i2);
    }

    public DrawableCrossFadeFactory(Context context, int i2, int i3) {
        this(new ViewAnimationFactory(context, i2), i3);
    }

    public DrawableCrossFadeFactory(Animation animation, int i2) {
        this(new ViewAnimationFactory(animation), i2);
    }

    public DrawableCrossFadeFactory(ViewAnimationFactory<T> viewAnimationFactory, int i2) {
        this.animationFactory = viewAnimationFactory;
        this.duration = i2;
    }
}
