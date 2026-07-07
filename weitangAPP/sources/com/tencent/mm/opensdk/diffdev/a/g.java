package com.tencent.mm.opensdk.diffdev.a;

import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
public enum g {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(TTAdConstant.INTERACTION_TYPE_CODE),
    UUID_ERROR(500);

    private int code;

    g(int i2) {
        this.code = i2;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
