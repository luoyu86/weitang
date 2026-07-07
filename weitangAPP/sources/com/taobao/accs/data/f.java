package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor;

/* JADX INFO: loaded from: classes2.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f10299a;

    public f(d dVar) {
        this.f10299a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TrafficsMonitor trafficsMonitor = this.f10299a.f10290c;
        if (trafficsMonitor != null) {
            trafficsMonitor.a();
        }
    }
}
