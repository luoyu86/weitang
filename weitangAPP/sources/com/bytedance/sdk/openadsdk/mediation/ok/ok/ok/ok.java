package com.bytedance.sdk.openadsdk.mediation.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo;

/* JADX INFO: loaded from: classes.dex */
public class ok implements IMediationDrawTokenInfo {
    private final Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationDrawTokenInfo
    public void loadDrawAdByAdm(String str, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(2);
        aVarOk.ok(0, str);
        aVarOk.ok(1, new com.bytedance.sdk.openadsdk.h.ok.ok.ok.ok(drawFeedAdListener));
        this.ok.call(270031, aVarOk.a(), Void.class);
    }
}
