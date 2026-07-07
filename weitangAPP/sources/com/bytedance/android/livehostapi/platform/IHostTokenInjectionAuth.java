package com.bytedance.android.livehostapi.platform;

import android.app.Activity;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface IHostTokenInjectionAuth {
    TokenInfo getTokenInfo();

    boolean isLogin();

    void onTokenInvalid(TokenInfo tokenInfo, TokenRefreshCallback tokenRefreshCallback, Activity activity, Map<String, String> map);
}
