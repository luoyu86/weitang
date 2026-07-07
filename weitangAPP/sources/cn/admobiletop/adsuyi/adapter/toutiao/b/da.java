package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;

/* JADX INFO: loaded from: classes.dex */
public class da implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ea f3983a;

    public da(ea eaVar) {
        this.f3983a = eaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3983a.getAdListener() != 0 && this.f3983a.f3990i != null && this.f3983a.f3990i.size() > 0) {
            ((ADSuyiNativeAdListener) this.f3983a.getAdListener()).onAdReceive(this.f3983a.f3990i);
        }
        ADSuyiAdUtil.releaseList(this.f3983a.f3989h);
        this.f3983a.f3989h = null;
    }
}
