package com.bytedance.sdk.openadsdk.mediation.bridge;

/* JADX INFO: loaded from: classes.dex */
public interface IMediationCustomizeVideo {
    String getVideoUrl();

    void reportVideoAutoStart();

    void reportVideoBreak(long j);

    void reportVideoContinue(long j);

    void reportVideoError(long j, int i2, int i3);

    void reportVideoFinish();

    void reportVideoPause(long j);

    void reportVideoStart();

    void reportVideoStartError(int i2, int i3);
}
