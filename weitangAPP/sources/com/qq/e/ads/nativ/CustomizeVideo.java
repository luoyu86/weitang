package com.qq.e.ads.nativ;

/* JADX INFO: loaded from: classes2.dex */
public interface CustomizeVideo {
    String getVideoUrl();

    void reportVideoCompleted();

    void reportVideoError(long j, int i2, int i3);

    void reportVideoPause(long j);

    void reportVideoPreload();

    void reportVideoResume(long j);

    void reportVideoStart();
}
