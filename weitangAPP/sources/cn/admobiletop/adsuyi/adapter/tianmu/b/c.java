package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import com.tianmu.ad.error.TianmuError;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TianmuError f3793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f3794b;

    public c(i iVar, TianmuError tianmuError) {
        this.f3794b = iVar;
        this.f3793a = tianmuError;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3794b.getAdListener() == 0 || this.f3793a == null) {
            return;
        }
        ((ADSuyiInnerNoticeAdListener) this.f3794b.getAdListener()).onAdFailed(new ADSuyiError(this.f3793a.getCode(), this.f3793a.getError()));
    }
}
