package com.bytedance.sdk.openadsdk.mediation;

/* JADX INFO: loaded from: classes.dex */
public interface IMediationDrawAdTokenCallback {
    void onAdTokenLoaded(String str, IMediationDrawTokenInfo iMediationDrawTokenInfo);

    void onAdTokenLoadedFail(int i2, String str);
}
