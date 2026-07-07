package com.tianmu.danikula.videocache;

import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ByteArraySource implements Source {
    private ByteArrayInputStream arrayInputStream;
    private final byte[] data;

    public ByteArraySource(byte[] bArr) {
        this.data = bArr;
    }

    @Override // com.tianmu.danikula.videocache.Source
    public void close() {
    }

    @Override // com.tianmu.danikula.videocache.Source
    public long length() {
        return this.data.length;
    }

    @Override // com.tianmu.danikula.videocache.Source
    public void open(long j) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.data);
        this.arrayInputStream = byteArrayInputStream;
        byteArrayInputStream.skip(j);
    }

    @Override // com.tianmu.danikula.videocache.Source
    public int read(byte[] bArr) {
        return this.arrayInputStream.read(bArr, 0, bArr.length);
    }
}
