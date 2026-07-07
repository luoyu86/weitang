package cn.admobiletop.adsuyi.adapter.toutiao.b;

import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX INFO: loaded from: classes.dex */
public class N implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TTFullScreenVideoAd f3951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S f3952b;

    public N(S s, TTFullScreenVideoAd tTFullScreenVideoAd) {
        this.f3952b = s;
        this.f3951a = tTFullScreenVideoAd;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3952b.f3959g.a(this.f3951a);
    }
}
