package cn.admobiletop.adsuyi.adapter.toutiao.b;

import com.bytedance.sdk.openadsdk.CSJAdError;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0319y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CSJAdError f4053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f4054b;

    public RunnableC0319y(A a2, CSJAdError cSJAdError) {
        this.f4054b = a2;
        this.f4053a = cSJAdError;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4054b.f3924f.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(this.f4053a.getCode(), this.f4053a.getMsg()));
    }
}
