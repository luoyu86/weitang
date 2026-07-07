package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.tianmu.ad.error.TianmuError;

/* JADX INFO: loaded from: classes.dex */
public class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TianmuError f3823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f3824b;

    public p(q qVar, TianmuError tianmuError) {
        this.f3824b = qVar;
        this.f3823a = tianmuError;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3824b.getAdListener() == 0 || this.f3823a == null) {
            return;
        }
        if (this.f3824b.f3826e == null) {
            this.f3824b.onAdFailed(this.f3823a.getCode(), this.f3823a.getError());
        } else {
            ADSuyiLogUtil.d(this.f3823a.toString());
            ((ADSuyiSplashAdListener) this.f3824b.getAdListener()).onAdClose(this.f3824b.f3826e);
        }
    }
}
