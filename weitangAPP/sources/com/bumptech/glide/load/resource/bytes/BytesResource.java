package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class BytesResource implements Resource<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] bArr) {
        Objects.requireNonNull(bArr, "Bytes must not be null");
        this.bytes = bArr;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bytes.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public byte[] get() {
        return this.bytes;
    }
}
