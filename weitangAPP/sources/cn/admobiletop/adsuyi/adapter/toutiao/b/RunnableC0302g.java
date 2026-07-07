package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.view.View;
import android.widget.RelativeLayout;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0302g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0303h f3996b;

    public RunnableC0302g(C0303h c0303h, View view) {
        this.f3996b = c0303h;
        this.f3995a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (ADSuyiAdUtil.isReleased(this.f3996b.f3998a.f4037d)) {
            return;
        }
        try {
            if (!ADSuyiAdUtil.isReleased(this.f3996b.f3998a.f4037d) && this.f3996b.f3998a.f4037d.getContainer() != null && this.f3995a != null) {
                this.f3996b.f3998a.f4037d.getContainer().removeAllViews();
                this.f3996b.f3998a.f4037d.getContainer().addView(this.f3995a, new RelativeLayout.LayoutParams(-1, -2));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.f3996b.f3998a.getAdListener() == 0 || this.f3996b.f3998a.f4038e == null) {
            return;
        }
        ((ADSuyiBannerAdListener) this.f3996b.f3998a.getAdListener()).onAdReceive(this.f3996b.f3998a.f4038e);
    }
}
