package com.bumptech.glide.request.animation;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.request.animation.ViewAnimation;

/* JADX INFO: loaded from: classes.dex */
public class ViewAnimationFactory<R> implements GlideAnimationFactory<R> {
    private final ViewAnimation.AnimationFactory animationFactory;
    private GlideAnimation<R> glideAnimation;

    public static class ConcreteAnimationFactory implements ViewAnimation.AnimationFactory {
        private final Animation animation;

        public ConcreteAnimationFactory(Animation animation) {
            this.animation = animation;
        }

        @Override // com.bumptech.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            return this.animation;
        }
    }

    public static class ResourceAnimationFactory implements ViewAnimation.AnimationFactory {
        private final int animationId;
        private final Context context;

        public ResourceAnimationFactory(Context context, int i2) {
            this.context = context.getApplicationContext();
            this.animationId = i2;
        }

        @Override // com.bumptech.glide.request.animation.ViewAnimation.AnimationFactory
        public Animation build() {
            return AnimationUtils.loadAnimation(this.context, this.animationId);
        }
    }

    public ViewAnimationFactory(Animation animation) {
        this(new ConcreteAnimationFactory(animation));
    }

    @Override // com.bumptech.glide.request.animation.GlideAnimationFactory
    public GlideAnimation<R> build(boolean z, boolean z2) {
        if (z || !z2) {
            return NoAnimation.get();
        }
        if (this.glideAnimation == null) {
            this.glideAnimation = new ViewAnimation(this.animationFactory);
        }
        return this.glideAnimation;
    }

    public ViewAnimationFactory(Context context, int i2) {
        this(new ResourceAnimationFactory(context, i2));
    }

    public ViewAnimationFactory(ViewAnimation.AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }
}
