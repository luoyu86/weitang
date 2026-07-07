package cn.admobiletop.adsuyi.a.b;

import android.app.Activity;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.c.a;

/* JADX INFO: loaded from: classes.dex */
public class s implements a.InterfaceC0050a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f3217a;

    public s(u uVar) {
        this.f3217a = uVar;
    }

    @Override // cn.admobiletop.adsuyi.a.c.a.InterfaceC0050a
    public void onActivityDestroyed(Activity activity) {
        if (this.f3217a.f3221b == activity) {
            if (ADSuyiSdk.getInstance().getConfig() == null || ADSuyiSdk.getInstance().getConfig().isCanAutoReleaseAd()) {
                this.f3217a.release();
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.a.c.a.InterfaceC0050a
    public void onActivityPaused(Activity activity) {
        if (this.f3217a.f3226g == null || this.f3217a.f3221b != activity) {
            return;
        }
        this.f3217a.f3226g.onPaused();
    }

    @Override // cn.admobiletop.adsuyi.a.c.a.InterfaceC0050a
    public void onActivityResumed(Activity activity) {
        if (this.f3217a.f3226g == null || this.f3217a.f3221b != activity) {
            return;
        }
        this.f3217a.f3226g.onResumed();
    }
}
