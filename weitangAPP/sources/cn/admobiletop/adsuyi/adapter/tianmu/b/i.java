package cn.admobiletop.adsuyi.adapter.tianmu.b;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import com.tianmu.ad.bean.NativeAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.NativeAdListener;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i extends b<ADSuyiInnerNoticeAdListener> implements NativeAdListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.tianmu.a.c f3801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f3802e;

    public i(String str, ADSuyiInnerNoticeAdListener aDSuyiInnerNoticeAdListener) {
        super(str, aDSuyiInnerNoticeAdListener);
        this.f3802e = new Handler(Looper.getMainLooper());
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onAdClose(NativeAdInfo nativeAdInfo) {
        Handler handler = this.f3802e;
        if (handler != null) {
            handler.post(new g(this));
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onAdExpose(NativeAdInfo nativeAdInfo) {
        Handler handler = this.f3802e;
        if (handler != null) {
            handler.post(new e(this));
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        Handler handler = this.f3802e;
        if (handler != null) {
            handler.post(new h(this, tianmuError));
        }
    }

    @Override // com.tianmu.ad.listener.AdInfoListListener
    public void onAdReceive(List<NativeAdInfo> list) {
        if (getAdListener() == 0 || list.isEmpty()) {
            return;
        }
        NativeAdInfo nativeAdInfo = list.get(0);
        cn.admobiletop.adsuyi.adapter.tianmu.a.c cVar = new cn.admobiletop.adsuyi.adapter.tianmu.a.c(getPlatformPosId());
        this.f3801d = cVar;
        cVar.setAdapterAdInfo(nativeAdInfo);
        this.f3801d.setAdListener(getAdListener());
        Handler handler = this.f3802e;
        if (handler != null) {
            handler.post(new d(this));
        }
    }

    @Override // com.tianmu.ad.listener.NativeAdListener
    public void onRenderFailed(NativeAdInfo nativeAdInfo, TianmuError tianmuError) {
        Handler handler = this.f3802e;
        if (handler != null) {
            handler.post(new c(this, tianmuError));
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        Handler handler = this.f3802e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3802e = null;
        }
        cn.admobiletop.adsuyi.adapter.tianmu.a.c cVar = this.f3801d;
        if (cVar != null) {
            cVar.release();
            this.f3801d = null;
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdClick(NativeAdInfo nativeAdInfo) {
        Handler handler = this.f3802e;
        if (handler != null) {
            handler.post(new f(this));
        }
    }
}
