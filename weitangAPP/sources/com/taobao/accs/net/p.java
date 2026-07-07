package com.taobao.accs.net;

import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsState;
import com.taobao.accs.data.Message;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f10401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j f10402e;

    public p(j jVar, int i2, String str, int i3, boolean z) {
        this.f10402e = jVar;
        this.f10398a = i2;
        this.f10399b = str;
        this.f10400c = i3;
        this.f10401d = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Message.a next;
        Message messageB;
        AccsState.getInstance().b(this.f10402e.m, "re", "oe " + this.f10398a + " " + this.f10399b);
        int i2 = this.f10400c;
        if (i2 > 0) {
            Message.a aVar = new Message.a(i2, "");
            Iterator<Message.a> it = this.f10402e.f10355e.f().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (next.equals(aVar)) {
                        break;
                    }
                }
            }
            if (next != null && (messageB = this.f10402e.f10355e.b(next.b())) != null) {
                if (this.f10401d) {
                    if (!this.f10402e.a(messageB, 2000)) {
                        this.f10402e.f10355e.a(messageB, AccsErrorCode.convertNetworkSdkError(this.f10398a, this.f10399b).detail(AccsErrorCode.getAllDetails(null)).build());
                    }
                    if (messageB.e() != null) {
                        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "total_tnet", 0.0d);
                    }
                } else {
                    this.f10402e.f10355e.a(messageB, AccsErrorCode.convertNetworkSdkError(this.f10398a, this.f10399b).detail(AccsErrorCode.getAllDetails(null)).build());
                }
            }
        }
        int i3 = this.f10400c;
        if (i3 >= 0 || !this.f10401d) {
            return;
        }
        this.f10402e.b(i3);
    }
}
