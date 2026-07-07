package com.bumptech.glide.util;

import com.bumptech.glide.ListPreloader;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {
    private final int[] size;

    public FixedPreloadSizeProvider(int i2, int i3) {
        this.size = new int[]{i2, i3};
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T t, int i2, int i3) {
        int[] iArr = this.size;
        return Arrays.copyOf(iArr, iArr.length);
    }
}
