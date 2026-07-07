package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.view.View;
import android.widget.RelativeLayout;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiPackageUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0282l implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0288s f3908a;

    public C0282l(C0288s c0288s) {
        this.f3908a = c0288s;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        if (this.f3908a.p != null) {
            this.f3908a.p.post(new RunnableC0279i(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        if (this.f3908a.p != null) {
            this.f3908a.p.post(new RunnableC0280j(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        if (ADSuyiPackageUtil.isMainThread()) {
            if (this.f3908a.getAdListener() != 0) {
                ((ADSuyiDrawVodAdListener) this.f3908a.getAdListener()).onRenderFailed(this.f3908a, new ADSuyiError(i2, str));
            }
        } else if (this.f3908a.p != null) {
            this.f3908a.p.post(new RunnableC0281k(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        ADSuyiViewUtil.addAdViewToAdContainer(this.f3908a.o, view, new RelativeLayout.LayoutParams(-1, -1));
    }
}
