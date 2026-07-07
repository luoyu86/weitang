package com.bytedance.sdk.openadsdk.mediation.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo;

/* JADX INFO: loaded from: classes.dex */
public class bl implements IMediationNativeTokenInfo {
    private final Bridge ok;

    public bl(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationNativeTokenInfo
    public void loadNativeAdByAdm(String str, TTAdNative.FeedAdListener feedAdListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(2);
        aVarOk.ok(0, str);
        aVarOk.ok(1, new com.bytedance.sdk.openadsdk.h.ok.ok.ok.a(feedAdListener));
        this.ok.call(270028, aVarOk.a(), Void.class);
    }
}
