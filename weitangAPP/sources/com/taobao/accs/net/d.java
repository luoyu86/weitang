package com.taobao.accs.net;

import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f10364a;

    public d(b bVar) {
        this.f10364a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f10364a.f10355e.c()) {
            ALog.e(this.f10364a.d(), "receive ping time out! ", new Object[0]);
            f.a(this.f10364a.f10354d).c();
            this.f10364a.a("", false, "receive ping timeout");
            this.f10364a.f10355e.a(AccsErrorCode.SPDY_PING_TIME_OUT.copy().detail(AccsErrorCode.getAllDetails(null)).build());
        }
    }
}
