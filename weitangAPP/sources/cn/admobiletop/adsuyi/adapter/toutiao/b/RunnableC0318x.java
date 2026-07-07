package cn.admobiletop.adsuyi.adapter.toutiao.b;

import com.bytedance.sdk.openadsdk.CSJAdError;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0318x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CSJAdError f4051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f4052b;

    public RunnableC0318x(A a2, CSJAdError cSJAdError) {
        this.f4052b = a2;
        this.f4051a = cSJAdError;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4052b.onAdFailed(this.f4051a.getCode(), this.f4051a.getMsg());
    }
}
