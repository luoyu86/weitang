package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.view.View;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0310o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f4025a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0311p f4026b;

    public RunnableC0310o(C0311p c0311p, View view) {
        this.f4026b = c0311p;
        this.f4025a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ADSuyiAdUtil.isReleased(this.f4026b.f4029a.f4031d)) {
            return;
        }
        try {
            if (!ADSuyiAdUtil.isReleased(this.f4026b.f4029a.f4031d) && this.f4026b.f4029a.f4031d.getContainer() != null && this.f4025a != null && this.f4026b.f4029a.f4034g != null) {
                this.f4026b.f4029a.f4034g.a(this.f4025a);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f4026b.f4029a.getAdListener() == 0 || this.f4026b.f4029a.f4032e == null) {
            return;
        }
        ((ADSuyiBannerAdListener) this.f4026b.f4029a.getAdListener()).onAdReceive(this.f4026b.f4029a.f4032e);
    }
}
