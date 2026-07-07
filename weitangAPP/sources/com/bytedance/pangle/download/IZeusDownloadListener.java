package com.bytedance.pangle.download;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public interface IZeusDownloadListener {
    void onFailed(Throwable th, int i2, String str);

    void onProgress(long j, long j2);

    void onStart();

    void onSuccess(String str, String str2, long j);
}
