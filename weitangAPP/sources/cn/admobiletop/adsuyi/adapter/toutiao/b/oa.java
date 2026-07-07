package cn.admobiletop.adsuyi.adapter.toutiao.b;

import com.bytedance.sdk.openadsdk.TTRewardVideoAd;

/* JADX INFO: loaded from: classes.dex */
public class oa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TTRewardVideoAd f4027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sa f4028b;

    public oa(sa saVar, TTRewardVideoAd tTRewardVideoAd) {
        this.f4028b = saVar;
        this.f4027a = tTRewardVideoAd;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4028b.f4044f.a(this.f4027a);
    }
}
