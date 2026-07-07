package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiBannerAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.a.C0272b;
import cn.admobiletop.adsuyi.adapter.toutiao.f.b;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.List;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0312q extends C0313s<ADSuyiBannerAdListener> implements TTAdNative.NativeExpressAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiBannerAd f4031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0272b f4032e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4033f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b.a f4034g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f4035h;

    public C0312q(ADSuyiBannerAd aDSuyiBannerAd, String str, ADSuyiBannerAdListener aDSuyiBannerAdListener, b.a aVar, cn.admobiletop.adsuyi.adapter.toutiao.f.b bVar) {
        super(str, aDSuyiBannerAdListener);
        this.f4035h = new Handler(Looper.getMainLooper());
        this.f4031d = aDSuyiBannerAd;
        this.f4034g = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i2, String str) {
        Handler handler = this.f4035h;
        if (handler != null) {
            handler.post(new RunnableC0304i(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        if (list == null || list.isEmpty() || list.get(0) == null || list.get(0).getExpressAdView() == null) {
            Handler handler = this.f4035h;
            if (handler != null) {
                handler.post(new RunnableC0305j(this));
                return;
            }
            return;
        }
        if (getAdListener() == 0 || ADSuyiAdUtil.isReleased(this.f4031d) || this.f4031d.getContainer() == null) {
            return;
        }
        TTNativeExpressAd tTNativeExpressAd = list.get(0);
        C0272b c0272b = new C0272b(this.f4031d.getActivity(), getPlatformPosId());
        this.f4032e = c0272b;
        c0272b.setAdapterAdInfo(tTNativeExpressAd);
        this.f4032e.setAdListener(getAdListener());
        try {
            tTNativeExpressAd.setExpressInteractionListener(new C0311p(this));
            tTNativeExpressAd.render();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f4031d = null;
        C0272b c0272b = this.f4032e;
        if (c0272b != null) {
            c0272b.release();
            this.f4032e = null;
        }
        Handler handler = this.f4035h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f4035h = null;
        }
    }
}
