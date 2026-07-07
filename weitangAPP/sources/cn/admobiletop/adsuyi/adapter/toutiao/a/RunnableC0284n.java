package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0284n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3911b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0288s f3912c;

    public RunnableC0284n(C0288s c0288s, int i2, int i3) {
        this.f3912c = c0288s;
        this.f3910a = i2;
        this.f3911b = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3912c.n != null) {
            this.f3912c.n.onVideoError(this.f3912c, new ADSuyiError(this.f3910a, "extraCode : " + this.f3911b));
        }
    }
}
