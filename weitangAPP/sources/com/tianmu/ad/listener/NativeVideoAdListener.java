package com.tianmu.ad.listener;

import com.tianmu.ad.model.ITianmuNativeVideoAd;

/* JADX INFO: loaded from: classes2.dex */
public interface NativeVideoAdListener {
    void onVideoError(ITianmuNativeVideoAd iTianmuNativeVideoAd);

    void onVideoFinish(ITianmuNativeVideoAd iTianmuNativeVideoAd);

    void onVideoPause(ITianmuNativeVideoAd iTianmuNativeVideoAd);

    void onVideoStart(ITianmuNativeVideoAd iTianmuNativeVideoAd);
}
