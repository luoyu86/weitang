package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.data.ADSuyiFullScreenVodAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiFullScreenVodAdListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0293x extends C0273c<ADSuyiFullScreenVodAdListener, TTFullScreenVideoAd> implements ADSuyiFullScreenVodAdInfo, TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    public boolean k;
    public Handler l;

    public C0293x(String str) {
        super(str);
        this.l = new Handler(Looper.getMainLooper());
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(TTFullScreenVideoAd tTFullScreenVideoAd) {
        super.setAdapterAdInfo(tTFullScreenVideoAd);
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().setShowDownLoadBar(true);
            if (4 == getAdapterAdInfo().getInteractionType()) {
                getAdapterAdInfo().setDownloadListener(new cn.admobiletop.adsuyi.adapter.toutiao.b.B());
            }
            getAdapterAdInfo().setFullScreenVideoAdInteractionListener(this);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new RunnableC0291v(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new RunnableC0289t(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new RunnableC0290u(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new RunnableC0292w(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo(null);
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.l = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiFullScreenVodAdInfo
    public void showFullScreenVod(Activity activity) {
        if (activity == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        this.k = true;
        getAdapterAdInfo().showFullScreenVideoAd(activity);
    }
}
