package com.tianmu.danikula.videocache;

/* JADX INFO: loaded from: classes2.dex */
public interface Cache {
    void append(byte[] bArr, int i2);

    long available();

    void close();

    void complete();

    boolean isCompleted();

    int read(byte[] bArr, long j, int i2);
}
