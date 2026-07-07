package com.taobao.accs.net;

import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.data.Message;

/* JADX INFO: loaded from: classes2.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f10389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f10390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f10391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j f10392d;

    public n(j jVar, String str, long j, boolean z) {
        this.f10392d = jVar;
        this.f10389a = str;
        this.f10390b = j;
        this.f10391c = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message messageA = this.f10392d.f10355e.a(this.f10389a);
        if (messageA != null) {
            this.f10392d.f10355e.a(messageA, AccsErrorCode.REQ_TIME_OUT.copy().msg("发送超过" + this.f10390b + "未收到回执").detail(AccsErrorCode.getAllDetails(null)).build());
            this.f10392d.a(this.f10389a, this.f10391c, "receive data time out");
            this.f10392d.t.e(this.f10389a + "-> receive data time out!");
        }
    }
}
