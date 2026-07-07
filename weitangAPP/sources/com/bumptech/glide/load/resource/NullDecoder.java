package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes.dex */
public class NullDecoder<T, Z> implements ResourceDecoder<T, Z> {
    private static final NullDecoder<?, ?> NULL_DECODER = new NullDecoder<>();

    public static <T, Z> NullDecoder<T, Z> get() {
        return (NullDecoder<T, Z>) NULL_DECODER;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Z> decode(T t, int i2, int i3) {
        return null;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public String getId() {
        return "";
    }
}
