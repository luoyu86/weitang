package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;

/* JADX INFO: loaded from: classes.dex */
public class z extends com.bytedance.sdk.openadsdk.bl.ok.ok.j {
    private Bridge ok;

    public z(Bridge bridge) {
        super(bridge);
        this.ok = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.bl.ok.ok.j, com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        if (fullScreenVideoAdInteractionListener instanceof IMediationInterstitialFullAdListener) {
            aVarOk.ok(0, new com.bytedance.sdk.openadsdk.mediation.ok.ok.a.a((IMediationInterstitialFullAdListener) fullScreenVideoAdInteractionListener));
            aVarOk.ok(1, 1);
        } else {
            aVarOk.ok(0, new com.bytedance.sdk.openadsdk.k.ok.ok.ok.ok(fullScreenVideoAdInteractionListener));
            aVarOk.ok(1, 0);
        }
        Bridge bridge = this.ok;
        if (bridge != null) {
            bridge.call(130101, aVarOk.a(), Void.class);
        }
    }
}
