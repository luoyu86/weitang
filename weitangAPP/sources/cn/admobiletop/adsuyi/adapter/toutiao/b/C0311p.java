package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.view.View;
import cn.admobiletop.adsuyi.adapter.toutiao.a.C0272b;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0311p implements TTNativeExpressAd.ExpressAdInteractionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0312q f4029a;

    public C0311p(C0312q c0312q) {
        this.f4029a = c0312q;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdClicked(View view, int i2) {
        if (this.f4029a.f4035h != null) {
            this.f4029a.f4035h.post(new RunnableC0306k(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onAdShow(View view, int i2) {
        int iHashCode;
        if (view == null || this.f4029a.getAdListener() == 0 || this.f4029a.f4033f == (iHashCode = view.hashCode())) {
            return;
        }
        if (this.f4029a.f4033f != 0 && !ADSuyiAdUtil.isReleased(this.f4029a.f4031d) && this.f4029a.getAdListener() != 0 && this.f4029a.f4032e != null && this.f4029a.f4032e.getAdapterAdInfo() != null) {
            TTNativeExpressAd adapterAdInfo = this.f4029a.f4032e.getAdapterAdInfo();
            C0312q c0312q = this.f4029a;
            c0312q.f4032e = new C0272b(c0312q.f4031d.getActivity(), this.f4029a.getPlatformPosId());
            this.f4029a.f4032e.setAdapterAdInfo(adapterAdInfo);
            this.f4029a.f4032e.setAdListener(this.f4029a.getAdListener());
            if (this.f4029a.f4035h != null) {
                this.f4029a.f4035h.post(new RunnableC0307l(this));
            }
        }
        this.f4029a.f4033f = iHashCode;
        if (this.f4029a.f4035h != null) {
            this.f4029a.f4035h.post(new RunnableC0308m(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderFail(View view, String str, int i2) {
        if (this.f4029a.f4035h != null) {
            this.f4029a.f4035h.post(new RunnableC0309n(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
    public void onRenderSuccess(View view, float f2, float f3) {
        if (this.f4029a.f4035h != null) {
            this.f4029a.f4035h.post(new RunnableC0310o(this, view));
        }
    }
}
