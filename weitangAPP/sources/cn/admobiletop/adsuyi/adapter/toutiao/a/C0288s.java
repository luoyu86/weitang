package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodVideoListener;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0288s extends ea<ADSuyiDrawVodAdListener> implements ADSuyiDrawVodAdInfo, TTNativeExpressAd.ExpressVideoAdListener {
    public int l;
    public int m;
    public ADSuyiDrawVodVideoListener n;
    public RelativeLayout o;
    public Handler p;

    public C0288s(int i2, int i3, Activity activity, String str) {
        super(activity, str);
        this.p = new Handler(Looper.getMainLooper());
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
            getAdapterAdInfo().setExpressInteractionListener(new C0282l(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo
    public View getMediaView(@NonNull ViewGroup viewGroup) {
        ADSuyiViewUtil.releaseClickTouchListener(viewGroup, new View[0]);
        if (this.o == null && viewGroup != null) {
            RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
            this.o = relativeLayout;
            relativeLayout.setLayoutParams(new ViewGroup.LayoutParams(this.l, this.m));
        }
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onClickRetry() {
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void onCloseClick(View view) {
        Handler handler = this.p;
        if (handler != null) {
            handler.post(new r(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdComplete() {
        Handler handler = this.p;
        if (handler != null) {
            handler.post(new RunnableC0287q(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdContinuePlay() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdPaused() {
        Handler handler = this.p;
        if (handler != null) {
            handler.post(new RunnableC0286p(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoAdStartPlay() {
        Handler handler = this.p;
        if (handler != null) {
            handler.post(new RunnableC0285o(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoError(int i2, int i3) {
        Handler handler = this.p;
        if (handler != null) {
            handler.post(new RunnableC0284n(this, i2, i3));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
    public void onVideoLoad() {
        Handler handler = this.p;
        if (handler != null) {
            handler.post(new RunnableC0283m(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.ea, cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        this.n = null;
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.p = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo
    public void render(@NonNull ViewGroup viewGroup) {
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().render();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo
    public void setVideoListener(ADSuyiDrawVodVideoListener aDSuyiDrawVodVideoListener) {
        if (getAdapterAdInfo() != null) {
            this.n = aDSuyiDrawVodVideoListener;
            getAdapterAdInfo().setVideoAdListener(this);
        }
    }
}
