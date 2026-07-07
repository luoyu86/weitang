package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v f3672c;

    public t(v vVar, int i2, String str) {
        this.f3672c = vVar;
        this.f3670a = i2;
        this.f3671b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3672c.m != null) {
            this.f3672c.m.a(new AdError(this.f3670a, this.f3671b), this.f3672c.k);
            return;
        }
        if (this.f3672c.f3678h == null) {
            super/*cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener*/.onAdFailed(this.f3670a, this.f3671b);
        } else if (this.f3672c.getAdListener() != 0) {
            ADSuyiLogUtil.d(this.f3671b);
            ((ADSuyiSplashAdListener) this.f3672c.getAdListener()).onAdClose(this.f3672c.f3678h);
        }
    }
}
