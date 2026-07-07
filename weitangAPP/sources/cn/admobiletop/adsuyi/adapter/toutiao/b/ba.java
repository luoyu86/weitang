package cn.admobiletop.adsuyi.adapter.toutiao.b;

import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: loaded from: classes.dex */
public class ba implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ea f3980a;

    public ba(ea eaVar) {
        this.f3980a = eaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3980a.m.a((TTClientBidding) this.f3980a.n.get(0));
    }
}
