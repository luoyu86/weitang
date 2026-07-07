package cn.admobiletop.adsuyi.a.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.b.o;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.api.ADSuyiNetworkRequestInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import cn.admobiletop.adsuyi.ad.scene.ADSuyiSceneAd;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManagerFactory;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiPreLoaderCacheManager;
import cn.admobiletop.adsuyi.config.ADSuyiConfig;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiPreLoadParams;
import cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController;
import cn.admobiletop.adsuyi.tsplugin.adapter.AdEventPluginAdapter;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class k<K extends o, T extends ADSuyiAdInfo, R extends ADSuyiAdListener<T>, E extends ADSuyiAd<R>> implements v, ADSuyiAdListener<T> {
    public int A;

    @Nullable
    public cn.admobiletop.adsuyi.b.a.a G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f3186a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public E f3189d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3191f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<ADSuyiPlatformPosId> f3194i;
    public ArrayList<ADSuyiPlatformPosId> j;
    public ADSuyiAdapterLoader k;
    public ADSuyiPlatformPosId l;
    public int n;
    public boolean o;
    public String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f3195q;
    public int r;
    public int s;
    public int t;
    public String u;
    public boolean v;
    public ADSuyiError w;
    public int y;
    public int z;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f3187b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Handler f3188c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, K> f3192g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ADSuyiError f3193h = new ADSuyiError();
    public int m = -1;
    public boolean x = false;
    public Handler B = new Handler(Looper.getMainLooper());
    public Runnable C = new d(this);
    public Runnable D = new e(this);
    public Runnable E = new f(this);
    public Runnable F = new g(this);
    public cn.admobiletop.adsuyi.b.c.b H = new cn.admobiletop.adsuyi.b.c.b();
    public List<ADSuyiAdapterLoader> I = new ArrayList();
    public List<ADSuyiAdapterLoader> J = new ArrayList();

    public k(E e2, Handler handler) {
        this.f3189d = e2;
        this.f3186a = handler;
        String adType = e2.getAdType();
        this.u = adType;
        this.f3193h.setAdType(adType);
    }

    public final void A(String str, ADSuyiPlatform aDSuyiPlatform, ADSuyiAdapterIniter aDSuyiAdapterIniter) {
        try {
            aDSuyiAdapterIniter.init(aDSuyiPlatform, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean B(ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        return ADSuyiBidManagerFactory.getInstance().isC2SBidType(aDSuyiPlatformPosId);
    }

    public boolean C(Integer num) {
        Map<Integer, K> map = this.f3192g;
        if (map != null) {
            return map.containsKey(num);
        }
        return false;
    }

    public boolean D(List<T> list) {
        if (this.f3192g != null && list != null && list.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (this.f3192g.containsKey(Integer.valueOf(list.get(i2).hashCode()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public Map<Integer, K> E() {
        return this.f3192g;
    }

    public final void F(int i2) {
        if (i2 == 0 || this.f3188c == null || this.F == null || ADSuyiAdUtil.isReleased(this.f3189d)) {
            return;
        }
        this.f3188c.postDelayed(this.F, i2);
    }

    public final void H(ADSuyiError aDSuyiError) {
        ADSuyiError aDSuyiError2 = this.f3193h;
        if (aDSuyiError2 != null) {
            aDSuyiError2.appendDesc(aDSuyiError);
        }
    }

    public final void I(List<ADSuyiPlatformPosId> list) {
        ADSuyiPlatformPosId aDSuyiPlatformPosIdA;
        cn.admobiletop.adsuyi.b.a.a aVar = this.G;
        if (aVar == null || (aDSuyiPlatformPosIdA = aVar.a()) == null) {
            return;
        }
        ADSuyiPlatformPosId aDSuyiPlatformPosId = null;
        Iterator<ADSuyiPlatformPosId> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ADSuyiPlatformPosId next = it.next();
            if (next.getPlatformPosId().equals(aDSuyiPlatformPosIdA.getPlatformPosId())) {
                if (!this.G.c()) {
                    ADSuyiLogUtil.ti("ADSuyiParallel", "并发预加载请求失败、移除当前瀑布流队列");
                    aDSuyiPlatformPosId = next;
                }
            }
        }
        if (aDSuyiPlatformPosId != null) {
            list.remove(aDSuyiPlatformPosId);
            ADSuyiPreLoaderCacheManager.getInstance().removePreAdapterLoader(this, aDSuyiPlatformPosId.getPlatformPosId());
        }
    }

    public void J(boolean z) {
        this.f3191f = z;
    }

    public final boolean K(ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        String platformPosId = aDSuyiPlatformPosId.getPlatformPosId();
        cn.admobiletop.adsuyi.b.a.a aVar = this.G;
        return (aVar == null || aVar.a() == null || !this.G.a().getPlatformPosId().equals(platformPosId)) ? false : true;
    }

    public final boolean L(ADSuyiPosId aDSuyiPosId) {
        return aDSuyiPosId != null && aDSuyiPosId.getRequestMode().equals(ADSuyiConfig.RequestMode.PARALLEL);
    }

    public String N() {
        return this.u;
    }

    public final void O(ADSuyiPosId aDSuyiPosId) {
        E e2 = this.f3189d;
        new cn.admobiletop.adsuyi.a.k.a.e(e2 == null ? null : e2.getOnlySupportPlatform(), this.u, new h(this), this.A).a(aDSuyiPosId, this.f3194i, d0(), this.f3189d, this);
    }

    public final void P(ADSuyiError aDSuyiError) {
        n0();
        if (i0() || ADSuyiAdUtil.isReleased(this.f3189d)) {
            return;
        }
        if (aDSuyiError != null && ADSuyiLogUtil.needShowLog()) {
            ADSuyiLogUtil.d("当前三方广告位轮循失败，错误信息 : " + aDSuyiError.toString());
            y(aDSuyiError);
        }
        H(aDSuyiError);
        t0();
        List<ADSuyiPlatformPosId> list = this.f3194i;
        if (list == null || list.size() <= this.m) {
            t(ADSuyiErrorConfig.AD_FAILED_ALL_PLATFORM_NO_AD, ADSuyiErrorConfig.MSG_AD_FAILED_ALL_PLATFORM_NO_AD);
            u0();
            return;
        }
        ADSuyiPlatformPosId aDSuyiPlatformPosId = this.l;
        if (aDSuyiPlatformPosId == null) {
            P(ADSuyiError.createErrorDesc("unknown", null, ADSuyiErrorConfig.AD_FAILED_PLATFORM_POS_ID_EMPTY, "平台的广告位信息为空"));
            return;
        }
        String platform = aDSuyiPlatformPosId.getPlatform();
        String platformPosId = this.l.getPlatformPosId();
        ADSuyiAdapterIniter aDSuyiAdapterIniterB = cn.admobiletop.adsuyi.a.l.h.l().b(platform);
        ADSuyiPlatform aDSuyiPlatformC = cn.admobiletop.adsuyi.a.l.h.l().c(platform);
        if (aDSuyiAdapterIniterB == null || aDSuyiPlatformC == null) {
            P(ADSuyiError.createErrorDesc(platform, platformPosId, ADSuyiErrorConfig.ADAPTER_IS_NOT_INITED, platform + ADSuyiErrorConfig.MSG_ADAPTER_IS_NOT_INITED));
            return;
        }
        E e2 = this.f3189d;
        String onlySupportPlatform = e2 == null ? null : e2.getOnlySupportPlatform();
        if (!TextUtils.isEmpty(onlySupportPlatform) && !onlySupportPlatform.equals(platform)) {
            P(ADSuyiError.createErrorDesc(platform, platformPosId, -1, "当前广告设置了仅支持 " + onlySupportPlatform + " 平台，无法获取该平台之外的广告"));
            return;
        }
        if (1 == this.t && !ADSuyiPlatform.PLAFORM_ADMOBILE.equals(platform)) {
            P(ADSuyiError.createErrorDesc(platform, null, ADSuyiErrorConfig.AD_FAILED_NOT_SUPPORT_REWARD_AD, ADSuyiErrorConfig.MSG_AD_FAILED_NOT_SUPPORT_REWARD_AD));
            return;
        }
        if (p0()) {
            P(ADSuyiError.createErrorDesc(platform, platformPosId, ADSuyiErrorConfig.AD_FAILED_ATTAIN_FREQUENCY, ADSuyiErrorConfig.MSG_AD_FAILED_ATTAIN_FREQUENCY));
            return;
        }
        try {
            if (ADSuyiAdUtil.isReleased(this.f3189d)) {
                return;
            }
            v0();
            this.w = null;
            ADSuyiAdapterLoader aDSuyiAdapterLoaderP = p(platform, platformPosId, aDSuyiAdapterIniterB);
            this.k = aDSuyiAdapterLoaderP;
            if (aDSuyiAdapterLoaderP == null) {
                ADSuyiError aDSuyiError2 = this.w;
                if (aDSuyiError2 != null) {
                    P(aDSuyiError2);
                    return;
                } else {
                    P(ADSuyiError.createErrorDesc(platform, platformPosId, ADSuyiErrorConfig.AD_FAILED_ADAPTER_IS_NOT_SUPPORT_AD_TYPE, ADSuyiErrorConfig.MSG_AD_FAILED_ADAPTER_IS_NOT_SUPPORT_AD_TYPE));
                    return;
                }
            }
            if (!cn.admobiletop.adsuyi.a.m.m.a(this.l.getRequestRate())) {
                P(ADSuyiError.createErrorDesc(platform, platformPosId, ADSuyiErrorConfig.AD_FAILED_PLATFORM_NO_HIT, ADSuyiErrorConfig.MSG_AD_FAILED_PLATFORM_NO_HIT));
                return;
            }
            k0();
            String strQ0 = q0();
            if (TextUtils.isEmpty(strQ0) || !strQ0.equals(this.l.getPlatformPosId())) {
                cn.admobiletop.adsuyi.a.a.f.a("request", this.p, this.n, this.u, this.l, this.f3195q, d0());
            }
            ADSuyiAdapterParams aDSuyiAdapterParams = new ADSuyiAdapterParams(this.l, aDSuyiPlatformC, this.t == 1, this.n, this.p, this.r == 1);
            s(this.y);
            this.k.loadAd(this.f3189d, aDSuyiAdapterParams, this);
        } catch (Throwable th) {
            th.printStackTrace();
            P(ADSuyiError.createErrorDesc(S(), Y(), ADSuyiErrorConfig.AD_FAILED_GET_AD_EXCEPTION, "获取广告时发生未知异常"));
        }
    }

    public final boolean Q(ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        return cn.admobiletop.adsuyi.b.b.b.a().a(aDSuyiPlatformPosId);
    }

    public String S() {
        ADSuyiPlatformPosId aDSuyiPlatformPosId = this.l;
        return aDSuyiPlatformPosId == null ? "unknown" : aDSuyiPlatformPosId.getPlatform();
    }

    public final void T(ADSuyiPosId aDSuyiPosId) {
        if (!L(aDSuyiPosId)) {
            O(aDSuyiPosId);
            return;
        }
        ADSuyiPlatformPosId aDSuyiPlatformPosIdQ = q(aDSuyiPosId);
        if (aDSuyiPlatformPosIdQ == null) {
            O(aDSuyiPosId);
        } else {
            O(aDSuyiPosId);
            x(aDSuyiPosId, aDSuyiPlatformPosIdQ);
        }
    }

    public ADSuyiPlatformPosId V() {
        return this.l;
    }

    public final void W(ADSuyiPosId aDSuyiPosId) {
        new cn.admobiletop.adsuyi.a.k.a.g().a(aDSuyiPosId, this.f3194i, d0(), null, null);
        k();
    }

    public String Y() {
        ADSuyiPlatformPosId aDSuyiPlatformPosId = this.l;
        if (aDSuyiPlatformPosId == null) {
            return null;
        }
        return aDSuyiPlatformPosId.getPlatformPosId();
    }

    public final void a() {
        List<ADSuyiAdapterLoader> list = this.I;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (ADSuyiAdapterLoader aDSuyiAdapterLoader : this.I) {
            if (aDSuyiAdapterLoader != null) {
                aDSuyiAdapterLoader.release();
            }
        }
        this.I.clear();
    }

    public R a0() {
        return (R) this.f3189d.getListener();
    }

    public final void b() {
        Map<Integer, K> map = this.f3192g;
        if (map != null) {
            map.clear();
        }
    }

    public final void c() {
        List<ADSuyiAdapterLoader> list = this.J;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (ADSuyiAdapterLoader aDSuyiAdapterLoader : this.J) {
            if (aDSuyiAdapterLoader != null) {
                aDSuyiAdapterLoader.release();
            }
        }
        this.J.clear();
    }

    public final void d() {
        ArrayList<ADSuyiPlatformPosId> arrayList = this.j;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (ADSuyiPlatformPosId aDSuyiPlatformPosId : this.j) {
            if (B(aDSuyiPlatformPosId)) {
                ADSuyiPreLoaderCacheManager.getInstance().removePreAdapterLoader(this, aDSuyiPlatformPosId.getPlatformPosId());
            }
        }
    }

    public String d0() {
        E e2 = this.f3189d;
        return e2 instanceof ADSuyiSceneAd ? ((ADSuyiSceneAd) e2).getSceneId() : "";
    }

    public final void e() {
        Runnable runnable;
        Handler handler = this.B;
        if (handler == null || (runnable = this.C) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public final void f() {
        Runnable runnable;
        Handler handler = this.f3188c;
        if (handler == null || (runnable = this.F) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public E f0() {
        return this.f3189d;
    }

    public long g() {
        return this.f3195q;
    }

    public final void h() {
        ArrayList<ADSuyiPlatformPosId> arrayList = this.j;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (ADSuyiPlatformPosId aDSuyiPlatformPosId : this.j) {
            if (K(aDSuyiPlatformPosId)) {
                ADSuyiPreLoaderCacheManager.getInstance().removePreAdapterLoader(this, aDSuyiPlatformPosId.getPlatformPosId());
            }
        }
    }

    public String i() {
        return this.p;
    }

    public boolean i0() {
        return this.f3190e;
    }

    public final void j() {
        ADSuyiLogUtil.ti("ADSuyiParallel", "release 预加载请求头，removeAllObserver 监听");
        this.G = null;
        this.H.b();
    }

    public final void k() {
        cn.admobiletop.adsuyi.a.l.h.l().o();
        cn.admobiletop.adsuyi.a.l.h.l().a();
        cn.admobiletop.adsuyi.a.a.e.a("request", this.p, this.n, this.u, this.f3195q, d0());
        P(null);
    }

    public void k0() {
        if (this.f3191f || 1 != this.s) {
            return;
        }
        J(cn.admobiletop.adsuyi.a.l.j.a().a(this.u));
    }

    public final void l() {
        if (this.f3186a == null || this.D == null || ADSuyiAdUtil.isReleased(this.f3189d)) {
            return;
        }
        Handler handler = this.f3186a;
        Runnable runnable = this.D;
        int i2 = this.z;
        handler.postDelayed(runnable, i2 == 0 ? this.f3189d.getTimeout() : i2);
    }

    public boolean l0() {
        return false;
    }

    public boolean m() {
        return this.v;
    }

    public void m0() {
    }

    public abstract K n();

    public void n0() {
        Runnable runnable;
        Handler handler = this.f3187b;
        if (handler == null || (runnable = this.E) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    public K o(T t) {
        Map<Integer, K> map = this.f3192g;
        if (map != null) {
            return map.get(Integer.valueOf(t.hashCode()));
        }
        return null;
    }

    public void o0() {
        Runnable runnable;
        Handler handler = this.f3186a;
        if (handler == null || (runnable = this.D) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    public void onAdClick(T t) {
        Object obj;
        if (t != null) {
            K k = this.f3192g.get(Integer.valueOf(t.hashCode()));
            if (k != null && !k.a()) {
                k.a(true);
                cn.admobiletop.adsuyi.a.a.f.a("click", this.p, 1, this.u, this.l, (ADSuyiAdType.TYPE_INNER_NOTICE.equals(this.u) && (t instanceof ADSuyiBaseAdInfo) && (obj = ((ADSuyiBaseAdInfo) t).getExtInfo().get(ADSuyiConfig.KEY_SP_CLICK)) != null && (obj instanceof Integer)) ? ((Integer) obj).intValue() : 0, this.f3195q, d0());
                k0();
            }
            if (ADSuyiAdUtil.canCallBack(this.f3189d)) {
                a0().onAdClick(t);
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    public void onAdClose(T t) {
        K k;
        if (i0() || t == null || (k = this.f3192g.get(Integer.valueOf(t.hashCode()))) == null || k.b()) {
            return;
        }
        k.b(true);
        m0();
        k0();
        if (ADSuyiAdUtil.canCallBack(this.f3189d)) {
            a0().onAdClose(t);
        }
        if (l0()) {
            release();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    public void onAdExpose(T t) {
        K k;
        if (t == null || (k = this.f3192g.get(Integer.valueOf(t.hashCode()))) == null || k.c()) {
            return;
        }
        k.c(true);
        cn.admobiletop.adsuyi.a.a.f.a("display", this.p, 1, this.u, this.l, this.f3195q, d0());
        cn.admobiletop.adsuyi.a.f.c.b().a(this.p, this.l);
        k0();
        if (ADSuyiAdUtil.canCallBack(this.f3189d)) {
            a0().onAdExpose(t);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
    public void onAdFailed(ADSuyiError aDSuyiError) {
        cn.admobiletop.adsuyi.a.f.c.b().a(this.p, this.l);
        if (this.x) {
            z(aDSuyiError, null);
        } else {
            P(aDSuyiError);
        }
    }

    public final ADSuyiAdapterLoader p(String str, String str2, ADSuyiAdapterIniter aDSuyiAdapterIniter) {
        if (B(this.l)) {
            ADSuyiAdapterLoader theLatestPreAdapterLoader = ADSuyiPreLoaderCacheManager.getInstance().getTheLatestPreAdapterLoader(this, str2);
            if (theLatestPreAdapterLoader != null) {
                ADSuyiPreLoaderCacheManager.getInstance().removePreAdapterLoader(this, str2);
                return theLatestPreAdapterLoader;
            }
            this.w = ADSuyiError.createErrorDesc(str, str2, ADSuyiErrorConfig.AD_FAILED_ADAPTER_IS_C2S_BID_INIT_ERROR, ADSuyiErrorConfig.MSG_AD_FAILED_ADAPTER_IS_C2S_BID_INIT_ERROR);
            return null;
        }
        if (!K(this.l)) {
            return aDSuyiAdapterIniter.getSuyiAdapterLoader(this.u);
        }
        ADSuyiAdapterLoader theLatestPreAdapterLoader2 = ADSuyiPreLoaderCacheManager.getInstance().getTheLatestPreAdapterLoader(this, str2);
        if (theLatestPreAdapterLoader2 != null) {
            ADSuyiPreLoaderCacheManager.getInstance().removePreAdapterLoader(this, str2);
            return theLatestPreAdapterLoader2;
        }
        this.w = ADSuyiError.createErrorDesc(str, str2, ADSuyiErrorConfig.AD_FAILED_ADAPTER_PRE_LOAD_AD_ERROR, ADSuyiErrorConfig.MSG_AD_FAILED_ADAPTER_PRE_LOAD_AD_ERROR);
        return null;
    }

    public final boolean p0() {
        ADSuyiPlatformPosId aDSuyiPlatformPosId = this.l;
        if (aDSuyiPlatformPosId == null) {
            return true;
        }
        return (aDSuyiPlatformPosId.isBidType() || this.l.isLoopFrequencyType() || !this.l.isFrequencyFinished()) ? false : true;
    }

    public final ADSuyiPlatformPosId q(ADSuyiPosId aDSuyiPosId) {
        ArrayList arrayList = new ArrayList();
        if (aDSuyiPosId == null || aDSuyiPosId.getPlatformPosIdList() == null) {
            return null;
        }
        arrayList.addAll(aDSuyiPosId.getPlatformPosIdList());
        new cn.admobiletop.adsuyi.a.k.a.h().a(aDSuyiPosId, arrayList, null, null, null);
        if (arrayList.size() == 0) {
            return null;
        }
        ADSuyiPlatformPosId aDSuyiPlatformPosId = (ADSuyiPlatformPosId) arrayList.get(0);
        if (Q(aDSuyiPlatformPosId)) {
            return aDSuyiPlatformPosId;
        }
        return null;
    }

    public final String q0() {
        ADSuyiPlatformPosId aDSuyiPlatformPosIdA;
        cn.admobiletop.adsuyi.b.a.a aVar = this.G;
        return (aVar == null || (aDSuyiPlatformPosIdA = aVar.a()) == null) ? "" : aDSuyiPlatformPosIdA.getPlatformPosId();
    }

    public final void r0() {
        if (this.G != null) {
            ADSuyiLogUtil.ti("ADSuyiParallel", "预加载不为空，有并发请求的情况下");
            if (this.G.b()) {
                ADSuyiLogUtil.ti("ADSuyiParallel", "瀑布流第一位已经有返回状态了");
            } else {
                ADSuyiLogUtil.ti("ADSuyiParallel", "瀑布流第一位还没有返回值，则强制标记结束");
                this.G.a(true);
                f();
            }
            ADSuyiLogUtil.ti("ADSuyiParallel", "执行这里已经明确并发请求有结果了（无论是正常结束还是强制结束） 过滤结果，发起请求");
            I(this.f3194i);
        } else {
            ADSuyiLogUtil.ti("ADSuyiParallel", "没有并发请求预加载渠道，直接发起请求");
        }
        k();
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        if (this.v) {
            return;
        }
        this.v = true;
        this.f3190e = true;
        try {
            d();
            h();
            j();
            this.f3189d = null;
            this.f3194i = null;
            this.j = null;
            this.l = null;
            w0();
            b();
            v0();
            o0();
            n0();
            f();
            this.D = null;
            this.E = null;
            this.F = null;
            this.C = null;
            a();
            c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void s(int i2) {
        if (i2 == 0 || this.f3187b == null || this.E == null || ADSuyiAdUtil.isReleased(this.f3189d)) {
            return;
        }
        this.f3187b.postDelayed(this.E, i2);
    }

    public final void s0() {
        if (this.G == null) {
            ADSuyiLogUtil.ti("ADSuyiParallel", "没有并发请求预加载渠道，直接发起请求");
            k();
            return;
        }
        ADSuyiLogUtil.ti("ADSuyiParallel", "预加载不为空，有并发请求的情况下");
        if (this.G.b()) {
            ADSuyiLogUtil.ti("ADSuyiParallel", "并发请求已完成，过滤结果发起发起请求");
            I(this.f3194i);
            k();
        } else {
            ADSuyiLogUtil.ti("ADSuyiParallel", "并发请求未完成，开始注册监听并发回调结束发起请求");
            this.H.a(new j(this));
        }
    }

    public final void t(int i2, String str) {
        ADSuyiError aDSuyiError = this.f3193h;
        if (aDSuyiError != null) {
            aDSuyiError.setCode(i2);
            this.f3193h.setError(str);
        }
    }

    public final void t0() {
        this.m++;
        List<ADSuyiPlatformPosId> list = this.f3194i;
        if (list != null) {
            int size = list.size();
            int i2 = this.m;
            if (size > i2) {
                this.l = this.f3194i.get(i2);
                return;
            }
        }
        this.l = null;
    }

    public final void u0() {
        if (i0()) {
            return;
        }
        this.f3190e = true;
        o0();
        n0();
        f();
        if (ADSuyiAdUtil.canCallBack(this.f3189d)) {
            a0().onAdFailed(this.f3193h);
        }
        release();
    }

    public final void v0() {
        ADSuyiAdapterLoader aDSuyiAdapterLoader = this.k;
        if (aDSuyiAdapterLoader != null) {
            aDSuyiAdapterLoader.release();
            this.k = null;
        }
    }

    public final void w0() {
        ADSuyiError aDSuyiError = this.f3193h;
        if (aDSuyiError != null) {
            aDSuyiError.release();
            this.f3193h = null;
        }
    }

    public final void x(ADSuyiPosId aDSuyiPosId, ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        if (aDSuyiPlatformPosId == null || aDSuyiPosId == null) {
            return;
        }
        try {
            ParallelAdLoadController parallelAdLoadControllerA = cn.admobiletop.adsuyi.b.b.b.a().a(this, this.u, aDSuyiPlatformPosId);
            if (parallelAdLoadControllerA != null) {
                this.G = new cn.admobiletop.adsuyi.b.a.a(aDSuyiPlatformPosId);
                ADSuyiPreLoadParams aDSuyiPreLoadParams = new ADSuyiPreLoadParams();
                aDSuyiPreLoadParams.setSuyiAd(this.f3189d);
                aDSuyiPreLoadParams.setListener(this);
                aDSuyiPreLoadParams.setAdapterParams(new ADSuyiAdapterParams(aDSuyiPlatformPosId, cn.admobiletop.adsuyi.a.l.h.l().c(aDSuyiPlatformPosId.getPlatform()), (aDSuyiPosId instanceof cn.admobiletop.adsuyi.a.g.e ? ((cn.admobiletop.adsuyi.a.g.e) aDSuyiPosId).b() : 0) == 1, 1, aDSuyiPosId.getPosId(), aDSuyiPosId.getCompelRefresh() == 1));
                StringBuilder sb = new StringBuilder();
                sb.append("开始发起渠道并发请求（预加载）：");
                sb.append(aDSuyiPlatformPosId.getPlatformPosId());
                ADSuyiLogUtil.ti("ADSuyiParallel", sb.toString());
                cn.admobiletop.adsuyi.a.a.f.a("request", aDSuyiPosId.getPosId(), 1, this.u, aDSuyiPlatformPosId, this.f3195q, d0());
                F(this.y);
                parallelAdLoadControllerA.parallelLoad(aDSuyiPreLoadParams, this.u, new i(this));
            }
        } catch (Exception e2) {
            h();
            j();
            ADSuyiLogUtil.ti("ADSuyiParallel", "并发请求逻辑出现异常 msg : " + e2.getMessage());
        }
    }

    public final void y(ADSuyiError aDSuyiError) {
        if (aDSuyiError == null) {
            return;
        }
        AdEventPluginAdapter.getInstance().addErrorReportInfo(ADSuyiSdk.getInstance().getAppId(), this.p, this.u, "failure", aDSuyiError.toString());
    }

    public final void z(ADSuyiError aDSuyiError, ADSuyiNetworkRequestInfo aDSuyiNetworkRequestInfo) {
        if (i0() || ADSuyiAdUtil.isReleased(this.f3189d)) {
            return;
        }
        if (aDSuyiError != null && ADSuyiLogUtil.needShowLog()) {
            ADSuyiLogUtil.d("当前三方广告位轮循失败，错误信息 : " + aDSuyiError.toString());
            y(aDSuyiError);
        }
        H(aDSuyiError);
        t0();
        List<ADSuyiPlatformPosId> list = this.f3194i;
        if (list == null || list.size() <= this.m) {
            t(ADSuyiErrorConfig.AD_FAILED_ALL_PLATFORM_NO_AD, ADSuyiErrorConfig.MSG_AD_FAILED_ALL_PLATFORM_NO_AD);
            u0();
            return;
        }
        ADSuyiPlatformPosId aDSuyiPlatformPosId = this.l;
        if (aDSuyiPlatformPosId == null) {
            z(ADSuyiError.createErrorDesc("unknown", null, ADSuyiErrorConfig.AD_FAILED_PLATFORM_POS_ID_EMPTY, "平台的广告位信息为空"), null);
            return;
        }
        String platform = aDSuyiPlatformPosId.getPlatform();
        String platformPosId = this.l.getPlatformPosId();
        ADSuyiAdapterIniter aDSuyiAdapterIniter = (ADSuyiAdapterIniter) cn.admobiletop.adsuyi.a.m.b.c(platform);
        if (aDSuyiAdapterIniter == null) {
            ADSuyiLogUtil.d(platform + " 平台的初始器获取失败，请检查是否导入相应平台的AdapterSdk，如果已导入并开启了混淆请检查混淆是否配置正确");
            return;
        }
        if (aDSuyiNetworkRequestInfo == null) {
            ADSuyiLogUtil.d(platform + " 平台的初始器获取失败，请检查是否配置相应平台的打底广告");
            return;
        }
        cn.admobiletop.adsuyi.a.g.c cVar = new cn.admobiletop.adsuyi.a.g.c(platform, aDSuyiNetworkRequestInfo.getAppId(), aDSuyiNetworkRequestInfo.getAppKey(), "100001");
        A(platform, cVar, aDSuyiAdapterIniter);
        cn.admobiletop.adsuyi.a.l.h.l().a(aDSuyiNetworkRequestInfo.getmDownloadTip());
        try {
            if (!ADSuyiAdUtil.isReleased(this.f3189d)) {
                v0();
                ADSuyiAdapterLoader suyiAdapterLoader = aDSuyiAdapterIniter.getSuyiAdapterLoader(this.u);
                this.k = suyiAdapterLoader;
                if (suyiAdapterLoader == null) {
                    z(ADSuyiError.createErrorDesc(platform, platformPosId, ADSuyiErrorConfig.AD_FAILED_ADAPTER_IS_NOT_SUPPORT_AD_TYPE, ADSuyiErrorConfig.MSG_AD_FAILED_ADAPTER_IS_NOT_SUPPORT_AD_TYPE), null);
                } else {
                    this.x = true;
                    cn.admobiletop.adsuyi.a.a.e.a("request", this.p, this.n, this.u, this.f3195q, d0());
                    cn.admobiletop.adsuyi.a.a.f.a("request", this.p, this.n, this.u, this.l, this.f3195q, d0());
                    this.k.loadAd(this.f3189d, new ADSuyiAdapterParams(this.l, cVar, false, this.n, this.p, this.r == 1), this);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            z(ADSuyiError.createErrorDesc(S(), Y(), ADSuyiErrorConfig.AD_FAILED_GET_AD_EXCEPTION, "获取广告时发生未知异常"), null);
        }
    }

    public void b(ADSuyiAdapterLoader aDSuyiAdapterLoader) {
        List<ADSuyiAdapterLoader> list = this.J;
        if (list == null || list.contains(aDSuyiAdapterLoader)) {
            return;
        }
        this.J.add(aDSuyiAdapterLoader);
    }

    @Override // cn.admobiletop.adsuyi.a.b.v
    public void a(ADSuyiPosId aDSuyiPosId, int i2) {
        if (this.o || this.v) {
            return;
        }
        this.o = true;
        this.m = -1;
        this.p = aDSuyiPosId.getPosId();
        this.f3195q = aDSuyiPosId.getGroupId();
        this.r = aDSuyiPosId.getCompelRefresh();
        this.y = aDSuyiPosId.getSingleSourceTimeout();
        this.z = aDSuyiPosId.getTotalTimeout();
        this.A = aDSuyiPosId.getBiddingTimeout();
        l();
        ArrayList<ADSuyiPlatformPosId> arrayList = new ArrayList<>();
        this.j = arrayList;
        arrayList.addAll(aDSuyiPosId.getPlatformPosIdList());
        ArrayList arrayList2 = new ArrayList();
        this.f3194i = arrayList2;
        arrayList2.addAll(aDSuyiPosId.getPlatformPosIdList());
        if (aDSuyiPosId instanceof cn.admobiletop.adsuyi.a.g.e) {
            cn.admobiletop.adsuyi.a.g.e eVar = (cn.admobiletop.adsuyi.a.g.e) aDSuyiPosId;
            this.s = eVar.a();
            this.t = eVar.b();
        }
        ADSuyiError aDSuyiError = this.f3193h;
        if (aDSuyiError != null) {
            aDSuyiError.setPosId(this.p);
        }
        if (aDSuyiPosId.isHeadingBid() || i2 < 1) {
            this.n = 1;
        } else if (i2 > 3) {
            this.n = 3;
        } else {
            this.n = i2;
        }
        if (this.f3194i != null) {
            if (aDSuyiPosId.isHeadingBid()) {
                T(aDSuyiPosId);
            } else {
                W(aDSuyiPosId);
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.a.b.v
    public void a(ADSuyiPosId aDSuyiPosId, int i2, ADSuyiNetworkRequestInfo aDSuyiNetworkRequestInfo) {
        if (this.o || this.v) {
            return;
        }
        this.o = true;
        this.p = aDSuyiPosId.getPosId();
        this.f3195q = aDSuyiPosId.getGroupId();
        this.f3194i = aDSuyiPosId.getPlatformPosIdList();
        if (aDSuyiPosId instanceof cn.admobiletop.adsuyi.a.g.e) {
            cn.admobiletop.adsuyi.a.g.e eVar = (cn.admobiletop.adsuyi.a.g.e) aDSuyiPosId;
            this.s = eVar.a();
            this.t = eVar.b();
        }
        ADSuyiError aDSuyiError = this.f3193h;
        if (aDSuyiError != null) {
            aDSuyiError.setPosId(this.p);
        }
        if (i2 < 1) {
            this.n = 1;
        } else if (i2 > 3) {
            this.n = 3;
        } else {
            this.n = i2;
        }
        z(null, aDSuyiNetworkRequestInfo);
    }

    @Override // cn.admobiletop.adsuyi.a.b.v
    public void a(boolean z) {
        ADSuyiAdapterLoader aDSuyiAdapterLoader = this.k;
        if (aDSuyiAdapterLoader != null) {
            if (z) {
                aDSuyiAdapterLoader.onResumed();
            } else {
                aDSuyiAdapterLoader.onPaused();
            }
        }
    }

    public void a(ADSuyiAdapterLoader aDSuyiAdapterLoader) {
        List<ADSuyiAdapterLoader> list = this.I;
        if (list == null || list.contains(aDSuyiAdapterLoader)) {
            return;
        }
        this.I.add(aDSuyiAdapterLoader);
    }
}
