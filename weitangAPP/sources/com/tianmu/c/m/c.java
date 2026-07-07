package com.tianmu.c.m;

import android.os.Handler;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.tianmu.ad.NativeAd;
import com.tianmu.ad.bean.NativeAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.NativeAdListener;
import com.tianmu.c.b.g;
import com.tianmu.c.i.m;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuAdUtil;
import com.tianmu.utils.TianmuLogUtil;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.tianmu.c.c.b<m, NativeAdInfo, NativeAdListener, NativeAd> implements NativeAdListener {
    public c(NativeAd nativeAd, Handler handler) {
        super(nativeAd, handler);
    }

    @Override // com.tianmu.c.c.e
    public void a(com.tianmu.c.i.e eVar, int i2) {
        this.f11239e = false;
        this.f11238d = false;
        this.f11240f = false;
        super.a(eVar, i2);
    }

    @Override // com.tianmu.c.c.e
    public boolean g() {
        return false;
    }

    @Override // com.tianmu.c.c.e
    public void j() {
        if (g() || TianmuAdUtil.isReleased(this.f11236b)) {
            return;
        }
        try {
            if (TianmuAdUtil.isReleased(this.f11236b)) {
                return;
            }
            i();
            g.a("request", this.f11243i, this.j);
            ((NativeAd) this.f11236b).requestAdInfo(this);
        } catch (Throwable th) {
            th.printStackTrace();
            a(new TianmuError(-2012, "获取广告时发生未知异常"));
        }
    }

    @Override // com.tianmu.c.c.e
    public boolean k() {
        return false;
    }

    @Override // com.tianmu.c.c.e
    public boolean l() {
        return false;
    }

    @Override // com.tianmu.c.c.e
    public void m() {
        g.a(ILivePush.ClickType.CLOSE, 1, e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.tianmu.ad.base.BaseAd] */
    @Override // com.tianmu.c.c.b, com.tianmu.ad.listener.AdInfoListListener
    public void onAdReceive(List<NativeAdInfo> list) {
        if (g()) {
            return;
        }
        if (list == null || list.isEmpty()) {
            a(new TianmuError(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
            return;
        }
        if (c() == null) {
            a(new TianmuError(TianmuErrorConfig.AD_FAILED_LOADER_IS_DESTROY, TianmuErrorConfig.MSG_AD_FAILED_LOADER_IS_DESTROY));
            return;
        }
        o();
        for (int i2 = 0; i2 < list.size(); i2++) {
            c().put(list.get(i2), a());
        }
        g.a(com.taobao.agoo.a.a.b.JSON_SUCCESS, list.size(), e());
        i();
        if (TianmuAdUtil.canCallBack(d())) {
            ((NativeAdListener) ((NativeAd) d()).getListener()).onAdReceive(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.tianmu.ad.base.BaseAd] */
    @Override // com.tianmu.ad.listener.NativeAdListener
    public void onRenderFailed(NativeAdInfo nativeAdInfo, TianmuError tianmuError) {
        m mVar;
        if (tianmuError != null) {
            TianmuLogUtil.d(tianmuError.toString());
        }
        if (nativeAdInfo == null || c() == null || (mVar = (m) c().get(nativeAdInfo)) == null || mVar.e()) {
            return;
        }
        mVar.e(true);
        if (TianmuAdUtil.canCallBack(d())) {
            ((NativeAdListener) ((NativeAd) d()).getListener()).onRenderFailed(nativeAdInfo, tianmuError);
        }
    }

    @Override // com.tianmu.c.c.e
    public m a() {
        return new m();
    }

    @Override // com.tianmu.c.c.e, com.tianmu.ad.base.BaseAdListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onAdExpose(NativeAdInfo nativeAdInfo) {
        super.onAdExpose(nativeAdInfo);
    }
}
