package com.tianmu.ad.listener;

import com.tianmu.ad.bean.InterstitialAdInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface InterstitialAdListener extends AdInfoListener<InterstitialAdInfo> {
    void onVideoError(InterstitialAdInfo interstitialAdInfo);

    void onVideoFinish(InterstitialAdInfo interstitialAdInfo);

    void onVideoPause(InterstitialAdInfo interstitialAdInfo);

    void onVideoStart(InterstitialAdInfo interstitialAdInfo);
}
