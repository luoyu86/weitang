package cn.admobiletop.adsuyi.adapter.toutiao.a;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* JADX INFO: loaded from: classes.dex */
public class ca<T extends ADSuyiAdListener> extends C0273c<T, TTFeedAd> {
    public ca(String str) {
        super(str);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(TTFeedAd tTFeedAd) {
        super.setAdapterAdInfo(tTFeedAd);
        a();
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
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
