package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.view.View;
import cn.admobiletop.adsuyi.adapter.toutiao.a.C0272b;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0303h implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f3998a;

    public C0303h(r rVar) {
        this.f3998a = rVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        if (this.f3998a.f4040g != null) {
            this.f3998a.f4040g.post(new RunnableC0298c(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        int iHashCode;
        if (view == null || this.f3998a.getAdListener() == 0 || this.f3998a.f4039f == (iHashCode = view.hashCode())) {
            return;
        }
        if (this.f3998a.f4039f != 0 && !ADSuyiAdUtil.isReleased(this.f3998a.f4037d) && this.f3998a.getAdListener() != 0 && this.f3998a.f4038e != null && this.f3998a.f4038e.getAdapterAdInfo() != null) {
            TTNativeExpressAd adapterAdInfo = this.f3998a.f4038e.getAdapterAdInfo();
            r rVar = this.f3998a;
            rVar.f4038e = new C0272b(rVar.f4037d.getActivity(), this.f3998a.getPlatformPosId());
            this.f3998a.f4038e.setAdapterAdInfo(adapterAdInfo);
            this.f3998a.f4038e.setAdListener(this.f3998a.getAdListener());
            if (this.f3998a.f4040g != null) {
                this.f3998a.f4040g.post(new RunnableC0299d(this));
            }
        }
        this.f3998a.f4039f = iHashCode;
        if (this.f3998a.f4040g != null) {
            this.f3998a.f4040g.post(new RunnableC0300e(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        if (this.f3998a.f4040g != null) {
            this.f3998a.f4040g.post(new RunnableC0301f(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        if (this.f3998a.f4040g != null) {
            this.f3998a.f4040g.post(new RunnableC0302g(this, view));
        }
    }
}
