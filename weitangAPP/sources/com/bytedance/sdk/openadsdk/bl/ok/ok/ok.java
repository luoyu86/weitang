package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJAdError;

/* JADX INFO: loaded from: classes.dex */
public class ok extends CSJAdError {
    private final Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public int getCode() {
        return this.ok.values().intValue(263001);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJAdError
    public String getMsg() {
        return (String) this.ok.values().objectValue(263002, String.class);
    }
}
