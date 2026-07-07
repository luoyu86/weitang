package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;

/* JADX INFO: loaded from: classes.dex */
public class F implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ J f3873c;

    public F(J j, int i2, int i3) {
        this.f3873c = j;
        this.f3871a = i2;
        this.f3872b = i3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3873c.k != null) {
            this.f3873c.k.onVideoError(this.f3873c, new ADSuyiError(this.f3871a, "extraCode : " + this.f3872b));
        }
    }
}
