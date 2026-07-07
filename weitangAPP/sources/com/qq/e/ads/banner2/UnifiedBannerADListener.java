package com.qq.e.ads.banner2;

import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes2.dex */
public interface UnifiedBannerADListener {
    void onADClicked();

    void onADClosed();

    void onADExposure();

    void onADLeftApplication();

    void onADReceive();

    void onNoAD(AdError adError);
}
