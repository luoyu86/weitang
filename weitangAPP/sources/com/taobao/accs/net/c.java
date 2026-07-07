package com.taobao.accs.net;

import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f10360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f10361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f10362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f10363d;

    public c(b bVar, String str, long j, boolean z) {
        this.f10363d = bVar;
        this.f10360a = str;
        this.f10361b = j;
        this.f10362c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageA = this.f10363d.f10355e.a(this.f10360a);
        if (messageA != null) {
            this.f10363d.f10355e.a(messageA, AccsErrorCode.REQ_TIME_OUT.copy().msg("发送超过" + this.f10361b + "未收到回执").detail(AccsErrorCode.getAllDetails(null)).build());
            this.f10363d.a(this.f10360a, this.f10362c, "receive data time out");
            ALog.e(this.f10363d.d(), this.f10360a + "-> receive data time out!", new Object[0]);
        }
    }
}
