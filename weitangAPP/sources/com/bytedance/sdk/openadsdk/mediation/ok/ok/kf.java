package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;

/* JADX INFO: loaded from: classes.dex */
public class kf implements IMediationDislikeCallback {
    private final Bridge ok;

    public kf(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onCancel() {
        this.ok.call(268014, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onSelected(int i2, String str) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(2);
        aVarOk.ok(0, i2);
        aVarOk.ok(1, str);
        this.ok.call(268013, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback
    public void onShow() {
        this.ok.call(268015, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }
}
