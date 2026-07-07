package com.bytedance.sdk.openadsdk.q.ok.ok.ok;

import c.d.a.a.a.a.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* JADX INFO: loaded from: classes.dex */
public class ok implements TTFeedAd.CustomizeVideo {
    private final Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge == null ? a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public String getVideoUrl() {
        return (String) this.ok.call(162101, a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoAutoStart() {
        this.ok.call(162107, a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoBreak(long j) {
        a aVarOk = a.ok(1);
        aVarOk.ok(0, j);
        this.ok.call(162106, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoContinue(long j) {
        a aVarOk = a.ok(1);
        aVarOk.ok(0, j);
        this.ok.call(162104, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoError(long j, int i2, int i3) {
        a aVarOk = a.ok(3);
        aVarOk.ok(0, j);
        aVarOk.ok(1, i2);
        aVarOk.ok(2, i3);
        this.ok.call(162109, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoFinish() {
        this.ok.call(162105, a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoPause(long j) {
        a aVarOk = a.ok(1);
        aVarOk.ok(0, j);
        this.ok.call(162103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStart() {
        this.ok.call(162102, a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
    public void reportVideoStartError(int i2, int i3) {
        a aVarOk = a.ok(2);
        aVarOk.ok(0, i2);
        aVarOk.ok(1, i3);
        this.ok.call(162108, aVarOk.a(), Void.class);
    }
}
