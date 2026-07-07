package com.bytedance.sdk.openadsdk.api;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public EventListener ok;

    public void ok(int i2, Result result) {
        if (ok()) {
            return;
        }
        this.ok.onEvent(i2, result);
    }

    public void ok(int i2) {
        ok(i2, null);
    }

    public boolean ok() {
        return this.ok == null;
    }
}
