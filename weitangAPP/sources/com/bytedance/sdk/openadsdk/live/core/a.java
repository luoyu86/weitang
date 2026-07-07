package com.bytedance.sdk.openadsdk.live.core;

import android.app.Activity;
import com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth;
import com.bytedance.android.livehostapi.platform.TokenInfo;
import com.bytedance.android.livehostapi.platform.TokenRefreshCallback;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.bytedance.sdk.openadsdk.live.TTLiveToken;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements IHostTokenInjectionAuth {
    private ITTLiveTokenInjectionAuth ok;

    public a(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.ok = iTTLiveTokenInjectionAuth;
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public TokenInfo getTokenInfo() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.ok;
        if (iTTLiveTokenInjectionAuth == null) {
            return null;
        }
        TTLiveToken tokenInfo = iTTLiveTokenInjectionAuth.getTokenInfo();
        return tokenInfo == null ? new TokenInfo("", "", "", 0L) : new TokenInfo(tokenInfo.name, tokenInfo.openId, tokenInfo.accessToken, tokenInfo.expireAt);
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public boolean isLogin() {
        ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth = this.ok;
        return iTTLiveTokenInjectionAuth != null && iTTLiveTokenInjectionAuth.isLogin();
    }

    @Override // com.bytedance.android.livehostapi.platform.IHostTokenInjectionAuth
    public void onTokenInvalid(TokenInfo tokenInfo, final TokenRefreshCallback tokenRefreshCallback, Activity activity, Map<String, String> map) {
        if (this.ok == null) {
            return;
        }
        this.ok.onTokenInvalid(tokenInfo == null ? null : new TTLiveToken(TTLiveConstants.DOUYIN_AUTH_NAME, tokenInfo.getAccessToken(), tokenInfo.getOpenId(), tokenInfo.getExpireAt(), tokenInfo.getName()), new TTLiveAuthCallback() { // from class: com.bytedance.sdk.openadsdk.live.core.a.1
            @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
            public void onAuth(TTLiveToken tTLiveToken) {
                tokenRefreshCallback.onSuccess(new TokenInfo(tTLiveToken.name, tTLiveToken.openId, tTLiveToken.accessToken, tTLiveToken.expireAt));
            }

            @Override // com.bytedance.sdk.openadsdk.live.TTLiveAuthCallback
            public void onFailed(Throwable th) {
                tokenRefreshCallback.onFailed(th);
            }
        }, activity, map);
    }
}
