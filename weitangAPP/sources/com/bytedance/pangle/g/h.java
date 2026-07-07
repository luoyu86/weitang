package com.bytedance.pangle.g;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class h implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f6089a;

    public h(ByteBuffer byteBuffer) {
        this.f6089a = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.g.k
    public final long a() {
        return this.f6089a.capacity();
    }

    @Override // com.bytedance.pangle.g.k
    public final void a(j jVar, long j, int i2) {
        ByteBuffer byteBufferSlice;
        synchronized (this.f6089a) {
            this.f6089a.position(0);
            int i3 = (int) j;
            this.f6089a.limit(i2 + i3);
            this.f6089a.position(i3);
            byteBufferSlice = this.f6089a.slice();
        }
        jVar.a(byteBufferSlice);
    }
}
