package com.bytedance.sdk.openadsdk.mediation.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;

/* JADX INFO: loaded from: classes.dex */
public class r extends com.bytedance.sdk.openadsdk.bl.ok.ok.k {
    private Bridge ok;

    public r(Bridge bridge) {
        super(bridge);
        this.ok = bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.bl.ok.ok.k, com.bytedance.sdk.openadsdk.TTNativeAd
    public void setExpressRenderListener(TTNativeAd.ExpressRenderListener expressRenderListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        if (expressRenderListener instanceof MediationExpressRenderListener) {
            aVarOk.ok(0, new com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.kf((MediationExpressRenderListener) expressRenderListener));
            aVarOk.ok(1, 1);
        } else {
            aVarOk.ok(0, new com.bytedance.sdk.openadsdk.r.ok.ok.ok.a(expressRenderListener));
            aVarOk.ok(1, 0);
        }
        Bridge bridge = this.ok;
        if (bridge != null) {
            bridge.call(140111, aVarOk.a(), Void.class);
        }
    }
}
