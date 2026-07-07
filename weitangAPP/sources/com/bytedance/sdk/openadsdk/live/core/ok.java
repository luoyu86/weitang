package com.bytedance.sdk.openadsdk.live.core;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.android.live.base.api.ILiveHostActionParam;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ok implements ILiveHostActionParam {
    private Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge;
    }

    @Override // com.bytedance.android.live.base.api.ILiveHostActionParam
    public void logEvent(boolean z, String str, String str2, Map<String, String> map) {
        Bridge bridge = this.ok;
        if (bridge != null) {
            bridge.call(1, c.d.a.a.a.a.a.ok().ok(0, z).ok(1, str).ok(2, str2).ok(3, map).a(), null);
        }
    }
}
