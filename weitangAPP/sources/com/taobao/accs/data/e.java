package com.taobao.accs.data;

import com.taobao.accs.ut.monitor.TrafficsMonitor;

/* JADX INFO: loaded from: classes2.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TrafficsMonitor.a f10297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f10298b;

    public e(d dVar, TrafficsMonitor.a aVar) {
        this.f10298b = dVar;
        this.f10297a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        TrafficsMonitor trafficsMonitor = this.f10298b.f10290c;
        if (trafficsMonitor != null) {
            trafficsMonitor.a(this.f10297a);
        }
    }
}
