package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0272b extends ea<ADSuyiBannerAdListener> {
    public Handler l;

    public C0272b(Activity activity, String str) {
        super(activity, str);
        this.l = new Handler(Looper.getMainLooper());
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void onCloseClick(View view) {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new RunnableC0271a(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.ea, cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.l = null;
        }
    }
}
