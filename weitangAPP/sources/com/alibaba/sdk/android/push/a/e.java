package com.alibaba.sdk.android.push.a;

import com.alibaba.sdk.android.push.PushControlService;

/* JADX INFO: loaded from: classes.dex */
public class e implements PushControlService {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final e f4848a = new e();
    }

    private e() {
    }

    public static e a() {
        return a.f4848a;
    }

    @Override // com.alibaba.sdk.android.push.PushControlService
    public void disconnect() {
        com.alibaba.sdk.android.push.e.a.a().f();
    }

    @Override // com.alibaba.sdk.android.push.PushControlService
    public boolean isConnected() {
        return com.alibaba.sdk.android.push.e.a.a().c();
    }

    @Override // com.alibaba.sdk.android.push.PushControlService
    public void reconnect() {
        com.alibaba.sdk.android.push.e.a.a().d();
    }

    @Override // com.alibaba.sdk.android.push.PushControlService
    public void reset() {
        com.alibaba.sdk.android.push.e.a.a().e();
    }

    @Override // com.alibaba.sdk.android.push.PushControlService
    public void setConnectionChangeListener(PushControlService.ConnectionChangeListener connectionChangeListener) {
        com.alibaba.sdk.android.push.e.a.a().a(connectionChangeListener);
    }
}
