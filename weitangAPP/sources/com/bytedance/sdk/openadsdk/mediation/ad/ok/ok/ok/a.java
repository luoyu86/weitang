package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationDislikeCallback;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;

/* JADX INFO: loaded from: classes.dex */
public class a implements MediationAdDislike {
    private final Bridge ok;

    public a(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void setDislikeCallback(IMediationDislikeCallback iMediationDislikeCallback) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.a(iMediationDislikeCallback));
        this.ok.call(270033, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike
    public void showDislikeDialog() {
        this.ok.call(270032, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }
}
