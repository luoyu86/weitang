package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;

/* JADX INFO: loaded from: classes.dex */
public class L implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ T f3880c;

    public L(T t, int i2, int i3) {
        this.f3880c = t;
        this.f3878a = i2;
        this.f3879b = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3880c.o != null) {
            this.f3880c.o.onVideoError(this.f3880c, new ADSuyiError(this.f3878a, "extraCode : " + this.f3879b));
        }
    }
}
