package com.bumptech.glide.util;

import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
    private int[] size;
    private SizeViewTarget viewTarget;

    public static final class SizeViewTarget extends ViewTarget<View, Object> {
        public SizeViewTarget(View view, SizeReadyCallback sizeReadyCallback) {
            super(view);
            getSize(sizeReadyCallback);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T t, int i2, int i3) {
        int[] iArr = this.size;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int i2, int i3) {
        this.size = new int[]{i2, i3};
        this.viewTarget = null;
    }

    public void setView(View view) {
        if (this.size == null && this.viewTarget == null) {
            this.viewTarget = new SizeViewTarget(view, this);
        }
    }

    public ViewPreloadSizeProvider(View view) {
        setView(view);
    }
}
