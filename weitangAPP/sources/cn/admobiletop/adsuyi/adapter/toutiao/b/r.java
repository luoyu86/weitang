package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.a.C0272b;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r extends C0313s<ADSuyiBannerAdListener> implements TTAdNative.NativeExpressAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiBannerAd f4037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0272b f4038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Handler f4040g;

    public r(ADSuyiBannerAd aDSuyiBannerAd, String str, ADSuyiBannerAdListener aDSuyiBannerAdListener) {
        super(str, aDSuyiBannerAdListener);
        this.f4040g = new Handler(Looper.getMainLooper());
        this.f4037d = aDSuyiBannerAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i2, String str) {
        Handler handler = this.f4040g;
        if (handler != null) {
            handler.post(new RunnableC0296a(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        if (list == null || list.isEmpty() || list.get(0) == null || list.get(0).getExpressAdView() == null) {
            Handler handler = this.f4040g;
            if (handler != null) {
                handler.post(new RunnableC0297b(this));
                return;
            }
            return;
        }
        if (getAdListener() == 0 || ADSuyiAdUtil.isReleased(this.f4037d) || this.f4037d.getContainer() == null) {
            return;
        }
        TTNativeExpressAd tTNativeExpressAd = list.get(0);
        C0272b c0272b = new C0272b(this.f4037d.getActivity(), getPlatformPosId());
        this.f4038e = c0272b;
        c0272b.setAdapterAdInfo(tTNativeExpressAd);
        this.f4038e.setAdListener(getAdListener());
        if (this.f4037d.getAutoRefreshInterval() > 0) {
            tTNativeExpressAd.setSlideIntervalTime(((int) this.f4037d.getAutoRefreshInterval()) * 1000);
        }
        try {
            tTNativeExpressAd.setExpressInteractionListener(new C0303h(this));
            tTNativeExpressAd.render();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f4037d = null;
        C0272b c0272b = this.f4038e;
        if (c0272b != null) {
            c0272b.release();
            this.f4038e = null;
        }
        Handler handler = this.f4040g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f4040g = null;
        }
    }
}
