package cn.admobiletop.adsuyi.a.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.b.v;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.api.ADSuyiNetworkRequestInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.config.ADSuyiConfig;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import cn.admobiletop.adsuyi.util.ADSuyiPackageUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class n<T extends ADSuyiAd, E extends v> implements w<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f3198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<cn.admobiletop.adsuyi.a.i.c<E>> f3199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<E> f3200c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<cn.admobiletop.adsuyi.a.i.b<E>> f3201d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f3202e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public E f3203f;

    public n(T t) {
        this.f3198a = t;
    }

    public abstract E a(T t, Handler handler);

    public T a() {
        return this.f3198a;
    }

    public final ADSuyiPosId b(ADSuyiNetworkRequestInfo aDSuyiNetworkRequestInfo, String str) {
        cn.admobiletop.adsuyi.a.g.e eVar = new cn.admobiletop.adsuyi.a.g.e(aDSuyiNetworkRequestInfo.getmNetworkAdPosListID(), 0L, str, 0, 0, aDSuyiNetworkRequestInfo.getmAdType(), true, 0, 0, 0, 0.0d, ADSuyiConfig.RequestMode.SERIAL);
        eVar.b(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new cn.admobiletop.adsuyi.a.g.d(aDSuyiNetworkRequestInfo.getmNetworkAdPosListID(), aDSuyiNetworkRequestInfo.getmPlatform(), aDSuyiNetworkRequestInfo.getAdNetworkSlotId(), 0, aDSuyiNetworkRequestInfo.getmRenderType(), ADSuyiConfig.TemplateType.FLOW, 1, "", "", -1, 1, false, 0, 1, false, 0.0d, 100, ADSuyiAdType.TYPE_SPLASH));
        eVar.a(arrayList);
        return eVar;
    }

    public final void e(E e2, int i2, ADSuyiNetworkRequestInfo aDSuyiNetworkRequestInfo, String str) {
        if (ADSuyiAdUtil.isReleased(this.f3198a) || e2 == null) {
            return;
        }
        ADSuyiLogUtil.d("开始轮循广告...");
        e2.a(b(aDSuyiNetworkRequestInfo, str), i2, aDSuyiNetworkRequestInfo);
    }

    public final void f(E e2, ADSuyiPosId aDSuyiPosId, int i2) {
        if (ADSuyiAdUtil.isReleased(this.f3198a) || e2 == null || aDSuyiPosId == null) {
            return;
        }
        ADSuyiLogUtil.d("开始轮循广告...");
        e2.a(aDSuyiPosId, i2);
    }

    public final void g(E e2, String str, int i2) {
        if (ADSuyiAdUtil.isReleased(this.f3198a)) {
            return;
        }
        String adType = this.f3198a.getAdType();
        if (cn.admobiletop.adsuyi.a.l.h.l().r()) {
            i(adType, str, e2, new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_INIT_REQUEST_IS_FAILED_NEED_PREVENT, ADSuyiErrorConfig.MSG_AD_FAILED_INIT_REQUEST_IS_FAILED_NEED_PREVENT + cn.admobiletop.adsuyi.a.l.h.l().j()));
            return;
        }
        if (TextUtils.isEmpty(str)) {
            i(adType, str, e2, new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_POS_ID_IS_EMPTY, "PosId不能为空"));
            return;
        }
        cn.admobiletop.adsuyi.a.g.a aVarI = cn.admobiletop.adsuyi.a.l.h.l().i();
        if (aVarI == null) {
            i(adType, str, e2, new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_INIT_DATA_IS_EMPTY, "初始化数据为空，可能是没有本地缓存的初始化数据并且初始接口请求失败"));
            return;
        }
        if (k(aVarI.i())) {
            i(adType, str, e2, new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_PACKAGE_NAME_MISMATCH, "AppId和包名不匹配"));
            return;
        }
        ADSuyiPosId aDSuyiPosIdD = cn.admobiletop.adsuyi.a.l.h.l().d(str);
        if (aDSuyiPosIdD == null || aDSuyiPosIdD.getPlatformPosIdList() == null || aDSuyiPosIdD.getPlatformPosIdList().isEmpty()) {
            i(adType, str, e2, new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_AD_FAILED_PLATFORM_POS_IDS_EMPTY, ADSuyiErrorConfig.MSG_AD_FAILED_AD_FAILED_PLATFORM_POS_IDS_EMPTY));
            return;
        }
        String adType2 = aDSuyiPosIdD.getAdType();
        if (adType == null || !adType.equals(adType2)) {
            i(adType, str, e2, new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_POS_ID_MISMATCH, "该PosId对应的广告类型不匹配, 当前PosId应是 " + adType2 + " 广告的PosId"));
            return;
        }
        if (!cn.admobiletop.adsuyi.a.f.c.b().a(aDSuyiPosIdD)) {
            f(e2, aDSuyiPosIdD, i2);
            return;
        }
        ADSuyiLogUtil.d("开始控频校验...");
        m mVar = new m(this, e2, aDSuyiPosIdD, i2);
        List<cn.admobiletop.adsuyi.a.i.b<E>> list = this.f3201d;
        if (list != null) {
            list.add(mVar);
        }
        cn.admobiletop.adsuyi.a.f.c.b().a(aDSuyiPosIdD, mVar);
    }

    public final void h(E e2, String str, int i2, ADSuyiNetworkRequestInfo aDSuyiNetworkRequestInfo) {
        if (ADSuyiAdUtil.isReleased(this.f3198a)) {
            return;
        }
        String adType = this.f3198a.getAdType();
        if (TextUtils.isEmpty(str) || aDSuyiNetworkRequestInfo == null) {
            i(adType, str, null, new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_AD_FAILED_DEFAULT_AD_EMPTY, ADSuyiErrorConfig.MSG_AD_FAILED_AD_FAILED_DEFAULT_AD_EMPTY));
        } else {
            e(e2, i2, aDSuyiNetworkRequestInfo, str);
        }
    }

    public final void i(String str, String str2, E e2, ADSuyiError aDSuyiError) {
        if (aDSuyiError != null && ADSuyiSdk.getInstance().isDebug()) {
            ADSuyiLogUtil.d("posid : " + str2 + ", loader failed : " + aDSuyiError.toString());
        }
        if (e2 != null) {
            e2.release();
            List<E> list = this.f3200c;
            if (list != null) {
                list.remove(e2);
            }
        }
        if (ADSuyiAdUtil.canCallBack(this.f3198a)) {
            if (aDSuyiError != null) {
                aDSuyiError.setAdType(str);
                aDSuyiError.setPosId(str2);
            }
            this.f3198a.getListener().onAdFailed(aDSuyiError);
        }
    }

    public final void j(boolean z) {
        List<E> list;
        if (!l() || (list = this.f3200c) == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f3200c.size(); i2++) {
            try {
                this.f3200c.get(i2).a(z);
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    public final boolean k(String str) {
        if (str == null) {
            return true;
        }
        if (ADSuyiConfig.TEST_APP_ID.equals(ADSuyiSdk.getInstance().getAppId())) {
            return false;
        }
        return !str.equals(ADSuyiPackageUtil.getPackageName(ADSuyiSdk.getInstance().getContext()));
    }

    public boolean l() {
        return false;
    }

    public final void m() {
        ADSuyiAdUtil.releaseList(this.f3200c);
        this.f3200c = null;
    }

    public final void n() {
        Handler handler = this.f3202e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3202e = null;
        }
    }

    public final void o() {
        cn.admobiletop.adsuyi.a.l.h.l().a(this.f3199b);
        ADSuyiAdUtil.releaseList(this.f3199b);
        this.f3199b = null;
    }

    @Override // cn.admobiletop.adsuyi.a.b.w
    public void onPaused() {
        j(false);
    }

    @Override // cn.admobiletop.adsuyi.a.b.w
    public void onResumed() {
        j(true);
    }

    public final void p() {
        ADSuyiAdUtil.releaseList(this.f3201d);
        this.f3201d = null;
    }

    @Override // cn.admobiletop.adsuyi.a.b.w
    public void release() {
        try {
            this.f3198a = null;
            n();
            o();
            p();
            m();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.w
    public void a(String str, int i2) {
        boolean zQ = cn.admobiletop.adsuyi.a.l.h.l().q();
        ADSuyiLogUtil.d("准备加载广告，初始化是否已完成 : " + zQ);
        E e2 = (E) a(this.f3198a, this.f3202e);
        this.f3203f = e2;
        this.f3200c.add(e2);
        if (zQ) {
            g(this.f3203f, str, i2);
            return;
        }
        ADSuyiLogUtil.d("等待初始化完成...");
        l lVar = new l(this, this.f3203f, str, i2);
        if (this.f3199b == null) {
            this.f3199b = new ArrayList();
        }
        this.f3199b.add(lVar);
        cn.admobiletop.adsuyi.a.l.h.l().a(lVar);
    }

    public void a(String str, int i2, ADSuyiNetworkRequestInfo aDSuyiNetworkRequestInfo) {
        boolean zQ = cn.admobiletop.adsuyi.a.l.h.l().q();
        ADSuyiLogUtil.d("准备加载广告，初始化是否已完成 : " + zQ);
        boolean zA = cn.admobiletop.adsuyi.a.l.s.a().a("defaultSplashAd", "SP_SUYI_DEFAULT_SPLASH_AD_REQUEST");
        v vVarA = a(this.f3198a, this.f3202e);
        if (vVarA != null) {
            this.f3200c.add((E) vVarA);
        }
        if (zQ && zA) {
            ADSuyiLogUtil.d("直接开始加载广告");
            g(vVarA, str, i2);
        } else {
            cn.admobiletop.adsuyi.a.l.s.a().b("defaultSplashAd", "SP_SUYI_DEFAULT_SPLASH_AD_REQUEST", true);
            ADSuyiLogUtil.d("加载兜底广告...");
            h(vVarA, str, i2, aDSuyiNetworkRequestInfo);
        }
    }
}
