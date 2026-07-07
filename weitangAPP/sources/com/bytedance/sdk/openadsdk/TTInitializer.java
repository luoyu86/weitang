package com.bytedance.sdk.openadsdk;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdSdk;

/* JADX INFO: loaded from: classes.dex */
public interface TTInitializer {
    TTAdManager getAdManager();

    @Deprecated
    TTAdManager init(Context context, AdConfig adConfig);

    void init(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback);

    boolean isInitSuccess();
}
