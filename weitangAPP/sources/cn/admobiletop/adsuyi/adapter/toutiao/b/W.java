package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class W extends C0313s<ADSuyiNativeAdListener> implements TTAdNative.FeedAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiNativeAd f3965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ADSuyiNativeAdInfo> f3966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f3967f;

    public W(String str, ADSuyiNativeAd aDSuyiNativeAd, ADSuyiNativeAdListener aDSuyiNativeAdListener) {
        super(str, aDSuyiNativeAdListener);
        this.f3967f = new Handler(Looper.getMainLooper());
        this.f3965d = aDSuyiNativeAd;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onError(int i2, String str) {
        Handler handler = this.f3967f;
        if (handler != null) {
            handler.post(new T(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        if (list == null || list.isEmpty()) {
            Handler handler = this.f3967f;
            if (handler != null) {
                handler.post(new U(this));
                return;
            }
            return;
        }
        if (getAdListener() == 0 || ADSuyiAdUtil.isReleased(this.f3965d)) {
            return;
        }
        this.f3966e = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            TTFeedAd tTFeedAd = list.get(i2);
            if (tTFeedAd != null) {
                cn.admobiletop.adsuyi.adapter.toutiao.a.J j = new cn.admobiletop.adsuyi.adapter.toutiao.a.J(getPlatformPosId());
                this.f3966e.add(j);
                j.setAdListener(getAdListener());
                j.setAdapterAdInfo(tTFeedAd);
            }
        }
        Handler handler2 = this.f3967f;
        if (handler2 != null) {
            handler2.post(new V(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f3965d = null;
        ADSuyiAdUtil.releaseList(this.f3966e);
        this.f3966e = null;
        Handler handler = this.f3967f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3967f = null;
        }
    }
}
