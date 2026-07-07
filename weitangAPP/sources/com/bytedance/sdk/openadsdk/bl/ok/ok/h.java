package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;

/* JADX INFO: loaded from: classes.dex */
public class h implements PersonalizationPrompt {
    private final Bridge ok;

    public h(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getName() {
        return (String) this.ok.values().objectValue(242002, String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.PersonalizationPrompt
    public String getUrl() {
        return (String) this.ok.values().objectValue(242001, String.class);
    }
}
