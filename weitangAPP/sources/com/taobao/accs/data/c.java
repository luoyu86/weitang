package com.taobao.accs.data;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f10287a;

    public c(a aVar) {
        this.f10287a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.f10287a) {
            if (this.f10287a.f10283f == 0) {
                ALog.e("AssembleMessage", com.alipay.sdk.m.m.a.h0, Constants.KEY_DATA_ID, this.f10287a.f10279b);
                this.f10287a.f10283f = 1;
                this.f10287a.f10285h.clear();
                AppMonitor.getInstance().commitStat(new AssembleMonitor(this.f10287a.f10279b, String.valueOf(this.f10287a.f10283f)));
            }
        }
    }
}
