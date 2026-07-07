package com.alipay.sdk.m.h;

/* JADX INFO: loaded from: classes.dex */
public final class c extends b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5353f;

    public c(String str) {
        this.f5353f = str;
    }

    @Override // com.alipay.sdk.m.h.b
    public void a() throws Exception {
        this.f5350a = (byte) 1;
        byte[] bytes = this.f5353f.getBytes("UTF-8");
        this.f5352c = bytes;
        this.f5351b = (byte) bytes.length;
    }
}
