package com.tianmu.danikula.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ByteArrayCache implements Cache {
    private volatile boolean completed;
    private volatile byte[] data;

    public ByteArrayCache() {
        this(new byte[0]);
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public void append(byte[] bArr, int i2) {
        Preconditions.checkNotNull(this.data);
        Preconditions.checkArgument(i2 >= 0 && i2 <= bArr.length);
        byte[] bArrCopyOf = Arrays.copyOf(this.data, this.data.length + i2);
        System.arraycopy(bArr, 0, bArrCopyOf, this.data.length, i2);
        this.data = bArrCopyOf;
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public long available() {
        return this.data.length;
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public void close() {
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public void complete() {
        this.completed = true;
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public boolean isCompleted() {
        return this.completed;
    }

    @Override // com.tianmu.danikula.videocache.Cache
    public int read(byte[] bArr, long j, int i2) {
        if (j >= this.data.length) {
            return -1;
        }
        if (j <= 2147483647L) {
            return new ByteArrayInputStream(this.data).read(bArr, (int) j, i2);
        }
        throw new IllegalArgumentException("Too long offset for memory cache " + j);
    }

    public ByteArrayCache(byte[] bArr) {
        this.data = (byte[]) Preconditions.checkNotNull(bArr);
    }
}
