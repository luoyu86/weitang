package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdDislike;

/* JADX INFO: loaded from: classes.dex */
public class p implements TTAdDislike {
    private final Bridge ok;

    public p(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public boolean isShow() {
        return ((Boolean) this.ok.call(240105, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void resetDislikeStatus() {
        this.ok.call(240104, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeInteractionCallback(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.kf.ok.ok.ok.ok(dislikeInteractionCallback));
        this.ok.call(240102, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void setDislikeSource(String str) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, str);
        this.ok.call(240103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike
    public void showDislikeDialog() {
        this.ok.call(240101, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }
}
