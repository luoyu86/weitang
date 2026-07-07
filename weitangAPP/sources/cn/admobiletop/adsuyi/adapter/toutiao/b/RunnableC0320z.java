package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import com.bytedance.sdk.openadsdk.CSJAdError;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0320z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CSJAdError f4055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f4056b;

    public RunnableC0320z(A a2, CSJAdError cSJAdError) {
        this.f4056b = a2;
        this.f4055a = cSJAdError;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4056b.onAdFailed(this.f4055a.getCode(), this.f4055a.getMsg());
        if (this.f4056b.f3922d == null || this.f4056b.getAdListener() == 0) {
            return;
        }
        ((ADSuyiSplashAdListener) this.f4056b.getAdListener()).onAdClose(this.f4056b.f3922d);
    }
}
