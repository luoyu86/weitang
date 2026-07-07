package cn.admobiletop.adsuyi.a.b;

import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3182a;

    public g(k kVar) {
        this.f3182a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3182a.m()) {
            return;
        }
        ADSuyiLogUtil.ti("ADSuyiParallel", "瀑布流首位并发请求超时了....");
        if (this.f3182a.G == null || this.f3182a.G.b()) {
            return;
        }
        ADSuyiLogUtil.ti("ADSuyiParallel", "瀑布流首位并发请求超时 ，设置标记位，并通知HB请求");
        this.f3182a.G.a(true);
        this.f3182a.G.b(false);
        this.f3182a.H.a();
    }
}
