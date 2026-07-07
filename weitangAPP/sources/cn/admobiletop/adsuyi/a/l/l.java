package cn.admobiletop.adsuyi.a.l;

import cn.admobiletop.adsuyi.a.f.c;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class l implements c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f3411a;

    public l(o oVar) {
        this.f3411a = oVar;
    }

    @Override // cn.admobiletop.adsuyi.a.f.c.a
    public void onFinish() {
        ADSuyiLogUtil.d("InnerNoticeAd start, [" + this.f3411a.l + ", " + this.f3411a.m + "]");
        this.f3411a.l();
    }
}
