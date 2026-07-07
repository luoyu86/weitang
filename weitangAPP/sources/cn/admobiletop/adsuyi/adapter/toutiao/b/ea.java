package cn.admobiletop.adsuyi.adapter.toutiao.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ea extends C0313s<ADSuyiNativeAdListener> implements TTAdNative.NativeExpressAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ADSuyiNativeAd f3988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<ADSuyiNativeAdInfo> f3989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<ADSuyiNativeAdInfo> f3990i;
    public int j;
    public int k;
    public Handler l;
    public cn.admobiletop.adsuyi.adapter.toutiao.d.c m;
    public List<TTNativeExpressAd> n;

    public ea(String str, int i2, int i3, ADSuyiNativeAd aDSuyiNativeAd, String str2, ADSuyiNativeAdListener aDSuyiNativeAdListener, cn.admobiletop.adsuyi.adapter.toutiao.d.c cVar) {
        super(str2, aDSuyiNativeAdListener);
        this.l = new Handler(Looper.getMainLooper());
        this.f3988g = aDSuyiNativeAd;
        this.f3987f = str;
        this.f3985d = i2;
        this.f3986e = i3;
        this.m = cVar;
    }

    public final void d(boolean z, cn.admobiletop.adsuyi.adapter.toutiao.a.T t) {
        Handler handler;
        List<ADSuyiNativeAdInfo> list;
        this.j++;
        if (z && t != null && !t.isReleased() && this.f3990i != null && (list = this.f3989h) != null) {
            list.remove(t);
            this.f3990i.add(t);
        }
        if (this.j < this.k || (handler = this.l) == null) {
            return;
        }
        handler.post(new da(this));
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i2, String str) {
        if (this.m != null) {
            Handler handler = this.l;
            if (handler != null) {
                handler.post(new X(this, i2, str));
                return;
            }
            return;
        }
        Handler handler2 = this.l;
        if (handler2 != null) {
            handler2.post(new Y(this, i2, str));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        if (list != null && !list.isEmpty()) {
            this.n = list;
            if (this.m == null) {
                a();
                return;
            }
            Handler handler = this.l;
            if (handler != null) {
                handler.post(new ba(this));
                return;
            }
            return;
        }
        if (this.m != null) {
            Handler handler2 = this.l;
            if (handler2 != null) {
                handler2.post(new Z(this));
                return;
            }
            return;
        }
        Handler handler3 = this.l;
        if (handler3 != null) {
            handler3.post(new aa(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f3988g = null;
        ADSuyiAdUtil.releaseList(this.f3990i);
        this.f3990i = null;
        ADSuyiAdUtil.releaseList(this.f3989h);
        this.f3989h = null;
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.l = null;
        }
    }

    public void a() {
        cn.admobiletop.adsuyi.adapter.toutiao.d.c cVar = this.m;
        if (cVar != null) {
            cVar.release();
            this.m = null;
        }
        if (getAdListener() == 0 || ADSuyiAdUtil.isReleased(this.f3988g)) {
            return;
        }
        this.f3989h = new ArrayList();
        this.f3990i = new ArrayList();
        this.k = this.n.size();
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            TTNativeExpressAd tTNativeExpressAd = this.n.get(i2);
            if (tTNativeExpressAd != null) {
                ca caVar = new ca(this, this.f3987f, this.f3985d, this.f3986e, this.f3988g.getActivity(), getPlatformPosId());
                this.f3989h.add(caVar);
                caVar.setAdListener(getAdListener());
                caVar.setAdapterAdInfo(tTNativeExpressAd);
            }
        }
    }
}
