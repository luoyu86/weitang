package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeExpressAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeVideoListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiInterceptContainer;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: loaded from: classes.dex */
public abstract class T extends ea<ADSuyiNativeAdListener> implements ADSuyiNativeExpressAdInfo, TTNativeExpressAd.ExpressAdInteractionListener, TTNativeExpressAd.ExpressVideoAdListener {
    public int l;
    public int m;
    public String n;
    public ADSuyiNativeVideoListener o;
    public boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ADSuyiInterceptContainer f3887q;
    public Handler r;

    public T(String str, int i2, int i3, Activity activity, String str2) {
        super(activity, str2);
        this.r = new Handler(Looper.getMainLooper());
        this.n = str;
        this.l = i2;
        this.m = i3;
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.ea, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a */
    public void setAdapterAdInfo(TTNativeExpressAd tTNativeExpressAd) {
        super.setAdapterAdInfo(tTNativeExpressAd);
        e();
    }

    public final void e() {
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().setExpressInteractionListener(this);
            getAdapterAdInfo().render();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeExpressAdInfo
    public View getNativeExpressAdView(@NonNull ViewGroup viewGroup) {
        View expressAdView;
        ADSuyiViewUtil.releaseClickTouchListener(viewGroup, new View[0]);
        if (this.f3887q == null && getAdapterAdInfo() != null && (expressAdView = getAdapterAdInfo().getExpressAdView()) != null) {
            ADSuyiInterceptContainer aDSuyiInterceptContainer = new ADSuyiInterceptContainer(expressAdView.getContext());
            this.f3887q = aDSuyiInterceptContainer;
            int i2 = this.l;
            if (i2 <= 0) {
                i2 = -1;
            }
            int i3 = this.m;
            if (i3 <= 0) {
                i3 = -2;
            }
            aDSuyiInterceptContainer.setLayoutParams(new ViewGroup.LayoutParams(i2, i3));
            this.f3887q.setPosId(this.n);
            this.f3887q.addResponseClickView(expressAdView);
        }
        return this.f3887q;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public boolean isNativeExpress() {
        return true;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public boolean isVideo() {
        return getAdapterAdInfo() != null && 5 == getAdapterAdInfo().getImageMode();
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        Handler handler = this.r;
        if (handler != null) {
            handler.post(new Q(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        Handler handler = this.r;
        if (handler != null) {
            handler.post(new S(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onClickRetry() {
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void onCloseClick(View view) {
        Handler handler = this.r;
        if (handler != null) {
            handler.post(new P(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdComplete() {
        Handler handler = this.r;
        if (handler != null) {
            handler.post(new O(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdContinuePlay() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdPaused() {
        Handler handler = this.r;
        if (handler != null) {
            handler.post(new N(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdStartPlay() {
        Handler handler = this.r;
        if (handler != null) {
            handler.post(new M(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoError(int i2, int i3) {
        Handler handler = this.r;
        if (handler != null) {
            handler.post(new L(this, i2, i3));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoLoad() {
        Handler handler = this.r;
        if (handler != null) {
            handler.post(new K(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.ea, cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        this.o = null;
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.r = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeExpressAdInfo
    public void render(@NonNull ViewGroup viewGroup) {
        getNativeExpressAdView(viewGroup);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo
    public void setVideoListener(ADSuyiNativeVideoListener aDSuyiNativeVideoListener) {
        if (isVideo()) {
            this.o = aDSuyiNativeVideoListener;
            getAdapterAdInfo().setVideoAdListener(this);
        }
    }
}
