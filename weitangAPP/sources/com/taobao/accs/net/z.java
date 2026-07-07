package com.taobao.accs.net;

/* JADX INFO: loaded from: classes2.dex */
public class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f10418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f10419b;

    public z(w wVar, String str) {
        this.f10419b = wVar;
        this.f10418a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f10418a;
        if (str != null && str.equals(this.f10419b.N) && this.f10419b.s == 2) {
            this.f10419b.J = false;
            this.f10419b.L = true;
            this.f10419b.q();
            this.f10419b.H.setCloseReason("conn timeout");
        }
    }
}
