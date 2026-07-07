package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0281k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0282l f3907c;

    public RunnableC0281k(C0282l c0282l, int i2, String str) {
        this.f3907c = c0282l;
        this.f3905a = i2;
        this.f3906b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3907c.f3908a.getAdListener() != 0) {
            ((ADSuyiDrawVodAdListener) this.f3907c.f3908a.getAdListener()).onRenderFailed(this.f3907c.f3908a, new ADSuyiError(this.f3905a, this.f3906b));
        }
    }
}
