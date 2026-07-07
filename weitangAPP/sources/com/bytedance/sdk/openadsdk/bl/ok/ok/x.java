package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTWidgetManager;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class x extends TTWidgetManager {
    private final Bridge ok;

    public x(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTWidgetManager
    public boolean updateWidgetWithType(int i2, JSONObject jSONObject) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(2);
        aVarOk.ok(0, i2);
        aVarOk.ok(1, jSONObject);
        return ((Boolean) this.ok.call(264001, aVarOk.a(), Boolean.TYPE)).booleanValue();
    }
}
