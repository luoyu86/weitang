package com.bytedance.sdk.openadsdk.mediation;

/* JADX INFO: loaded from: classes.dex */
public interface IMediationNativeAdTokenCallback {
    void onAdTokenLoaded(String str, IMediationNativeTokenInfo iMediationNativeTokenInfo);

    void onAdTokenLoadedFail(int i2, String str);
}
