package com.taobao.accs.net;

/* JADX INFO: loaded from: classes2.dex */
public class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f10417a;

    public y(w wVar) {
        this.f10417a = wVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10417a.q();
        if (this.f10417a.H != null) {
            this.f10417a.H.setCloseReason("shut down");
        }
        synchronized (this.f10417a.t) {
            try {
                this.f10417a.t.notifyAll();
            } catch (Exception unused) {
            }
        }
    }
}
