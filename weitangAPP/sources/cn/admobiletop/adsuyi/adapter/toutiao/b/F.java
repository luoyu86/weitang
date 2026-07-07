package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.ADSuyiDrawVodAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;
import cn.admobiletop.adsuyi.adapter.toutiao.a.C0288s;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class F extends C0313s<ADSuyiDrawVodAdListener> implements TTAdNative.NativeExpressAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ADSuyiDrawVodAd f3934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<ADSuyiDrawVodAdInfo> f3935g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f3936h;

    public F(int i2, int i3, ADSuyiDrawVodAd aDSuyiDrawVodAd, String str, ADSuyiDrawVodAdListener aDSuyiDrawVodAdListener) {
        super(str, aDSuyiDrawVodAdListener);
        this.f3936h = new Handler(Looper.getMainLooper());
        this.f3934f = aDSuyiDrawVodAd;
        this.f3932d = i2;
        this.f3933e = i3;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i2, String str) {
        Handler handler = this.f3936h;
        if (handler != null) {
            handler.post(new C(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        if (list == null || list.isEmpty()) {
            Handler handler = this.f3936h;
            if (handler != null) {
                handler.post(new D(this));
                return;
            }
            return;
        }
        if (getAdListener() == 0 || ADSuyiAdUtil.isReleased(this.f3934f)) {
            return;
        }
        this.f3935g = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            TTNativeExpressAd tTNativeExpressAd = list.get(i2);
            if (this.f3935g != null && tTNativeExpressAd != null) {
                C0288s c0288s = new C0288s(this.f3932d, this.f3933e, this.f3934f.getActivity(), getPlatformPosId());
                c0288s.setAdapterAdInfo(tTNativeExpressAd);
                c0288s.setAdListener(getAdListener());
                this.f3935g.add(c0288s);
            }
        }
        Handler handler2 = this.f3936h;
        if (handler2 != null) {
            handler2.post(new E(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f3934f = null;
        ADSuyiAdUtil.releaseList(this.f3935g);
        this.f3935g = null;
        Handler handler = this.f3936h;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3936h = null;
        }
    }
}
