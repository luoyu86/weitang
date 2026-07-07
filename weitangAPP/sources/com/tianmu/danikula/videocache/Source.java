package com.tianmu.danikula.videocache;

/* JADX INFO: loaded from: classes2.dex */
public interface Source {
    void close();

    long length();

    void open(long j);

    int read(byte[] bArr);
}
