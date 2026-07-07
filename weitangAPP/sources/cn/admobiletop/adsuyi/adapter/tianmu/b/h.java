package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import com.tianmu.ad.error.TianmuError;

/* JADX INFO: loaded from: classes.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TianmuError f3799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f3800b;

    public h(i iVar, TianmuError tianmuError) {
        this.f3800b = iVar;
        this.f3799a = tianmuError;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3800b.getAdListener() == 0 || this.f3799a == null) {
            return;
        }
        ((ADSuyiInnerNoticeAdListener) this.f3800b.getAdListener()).onAdFailed(new ADSuyiError(this.f3799a.getCode(), this.f3799a.getError()));
    }
}
