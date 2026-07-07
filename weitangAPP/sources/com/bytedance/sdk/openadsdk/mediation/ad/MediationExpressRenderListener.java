package com.bytedance.sdk.openadsdk.mediation.ad;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;

/* JADX INFO: loaded from: classes.dex */
public interface MediationExpressRenderListener extends TTNativeAd.ExpressRenderListener {
    void onAdClick();

    void onAdShow();

    void onRenderFail(View view, String str, int i2);
}
