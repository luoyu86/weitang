package com.alibaba.sdk.android.crashdefend;

/* JADX INFO: loaded from: classes.dex */
public interface CrashDefendCallback {
    void onSdkClosed(int i2);

    void onSdkStart(int i2, int i3, int i4);

    void onSdkStop(int i2, int i3, int i4, long j);
}
