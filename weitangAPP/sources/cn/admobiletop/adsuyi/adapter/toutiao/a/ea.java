package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.app.Activity;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: loaded from: classes.dex */
public class ea<T extends ADSuyiAdListener> extends C0273c<T, TTNativeExpressAd> {
    public Activity k;

    public ea(Activity activity, String str) {
        super(str);
        this.k = activity;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(TTNativeExpressAd tTNativeExpressAd) {
        super.setAdapterAdInfo(tTNativeExpressAd);
        a();
        b(this.k);
    }

    public final void b(Activity activity) {
        if (activity == null || getAdapterAdInfo() == null) {
            return;
        }
        getAdapterAdInfo().setDislikeCallback(activity, new da(this));
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        this.k = null;
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().destroy();
            setAdapterAdInfo(null);
        }
    }

    public final void a() {
        if (getAdapterAdInfo() == null || 4 != getAdapterAdInfo().getInteractionType()) {
            return;
        }
        getAdapterAdInfo().setDownloadListener(new cn.admobiletop.adsuyi.adapter.toutiao.b.B());
    }
}
