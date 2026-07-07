package com.bytedance.sdk.openadsdk.api.plugin;

/* JADX INFO: loaded from: classes.dex */
public class ok extends Exception {
    private final int ok;

    public ok(int i2, String str) {
        super(str);
        this.ok = i2;
    }

    public int ok() {
        return this.ok;
    }
}
