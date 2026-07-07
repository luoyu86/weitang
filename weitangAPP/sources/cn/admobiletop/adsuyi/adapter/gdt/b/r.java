package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f3663c;

    public r(s sVar, int i2, String str) {
        this.f3663c = sVar;
        this.f3661a = i2;
        this.f3662b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3663c.k != null) {
            this.f3663c.k.a(new AdError(this.f3661a, this.f3662b), this.f3663c.j);
            return;
        }
        if (this.f3663c.f3665e == null) {
            super/*cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener*/.onAdFailed(this.f3661a, this.f3662b);
        } else if (this.f3663c.getAdListener() != 0) {
            ADSuyiLogUtil.d(this.f3662b);
            ((ADSuyiSplashAdListener) this.f3663c.getAdListener()).onAdClose(this.f3663c.f3665e);
        }
    }
}
