package com.alibaba.sdk.android.man.crashreporter.a.a.a.a;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.alibaba.sdk.android.man.crashreporter.a.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.alibaba.sdk.android.man.crashreporter.global.a f4687a;

    public d(com.alibaba.sdk.android.man.crashreporter.global.a aVar) {
        this.f4687a = aVar;
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.a.a.c
    public void a(Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> map) {
        com.alibaba.sdk.android.man.crashreporter.global.a aVar = com.alibaba.sdk.android.man.crashreporter.global.a.SYS_LOG;
        if (aVar.equals(this.f4687a)) {
            map.put(aVar, com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a.a("", false));
            return;
        }
        com.alibaba.sdk.android.man.crashreporter.global.a aVar2 = com.alibaba.sdk.android.man.crashreporter.global.a.EVENTS_LOG;
        if (aVar2.equals(this.f4687a)) {
            map.put(aVar2, com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a.a("events", true));
            return;
        }
        com.alibaba.sdk.android.man.crashreporter.global.a aVar3 = com.alibaba.sdk.android.man.crashreporter.global.a.RADIO_LOG;
        if (aVar3.equals(this.f4687a)) {
            map.put(aVar3, com.alibaba.sdk.android.man.crashreporter.a.a.a.b.a.a("radios", true));
        }
    }
}
