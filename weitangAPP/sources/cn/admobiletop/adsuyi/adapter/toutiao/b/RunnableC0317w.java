package cn.admobiletop.adsuyi.adapter.toutiao.b;

import com.bytedance.sdk.openadsdk.CSJAdError;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.w, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0317w implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CSJAdError f4049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f4050b;

    public RunnableC0317w(A a2, CSJAdError cSJAdError) {
        this.f4050b = a2;
        this.f4049a = cSJAdError;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4050b.f3924f.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(this.f4049a.getCode(), this.f4049a.getMsg()));
    }
}
