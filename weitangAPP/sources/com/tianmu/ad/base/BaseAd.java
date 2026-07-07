package com.tianmu.ad.base;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.base.BaseAdListener;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.c.i.e;
import com.tianmu.c.l.d;
import com.tianmu.c.n.n;
import com.tianmu.config.TianmuConfig;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuAdUtil;
import com.tianmu.utils.TianmuLogUtil;
import com.tianmu.utils.TianmuPackageUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseAd<T extends BaseAdListener> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f10622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f10624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f10625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f10626f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.tianmu.c.c.e f10628h;
    private List<d> j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f10621a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f10627g = 10000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10629i = false;
    private Handler k = new Handler(Looper.getMainLooper());
    private Runnable l = new Runnable() { // from class: com.tianmu.ad.base.BaseAd.1
        @Override // java.lang.Runnable
        public void run() {
            BaseAd.this.d();
            BaseAd.this.getListener().onAdFailed(new TianmuError(TianmuErrorConfig.AD_WAIT_INIT_TIMEOUT_ERROR, TianmuErrorConfig.MSG_AD_WAIT_INIT_TIMEOUT_ERROR));
            TianmuLogUtil.e("等待初始化完成超时：" + BaseAd.this.f10623c);
        }
    };

    public BaseAd(Context context) {
        this.f10622b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        n.D().a(this.j);
        this.j = null;
    }

    private void e() {
        com.tianmu.c.c.e eVar = this.f10628h;
        if (eVar != null) {
            eVar.release();
            this.f10628h = null;
        }
        b();
    }

    private void f() {
        if (this.k == null || this.l == null || TianmuAdUtil.isReleased(this)) {
            return;
        }
        this.k.postDelayed(this.l, 5000L);
    }

    public abstract com.tianmu.c.c.e a();

    public e getAdPosId() {
        return this.f10626f;
    }

    public abstract String getAdType();

    public Context getContext() {
        return this.f10622b;
    }

    public int getCount() {
        return this.f10624d;
    }

    public T getListener() {
        return this.f10625e;
    }

    public String getPosId() {
        return this.f10623c;
    }

    public abstract int getRenderType();

    public final long getTimeout() {
        return this.f10627g;
    }

    public boolean isReleased() {
        return false;
    }

    public void loadAd(String str, int i2) {
        if (!TianmuPackageUtil.isMainThread()) {
            if (TianmuAdUtil.canCallBack(this)) {
                getListener().onAdFailed(new TianmuError(-2000, "必须在主线程获取广告"));
                return;
            }
            return;
        }
        if (TianmuAdUtil.isReleased(this)) {
            if (getListener() != null) {
                getListener().onAdFailed(new TianmuError(-2002, TianmuErrorConfig.MSG_AD_FAILED_SUYI_AD_IS_RELEASED));
                return;
            }
            return;
        }
        a(str);
        a(i2);
        if (n.D().s()) {
            c();
            return;
        }
        if (n.D().r()) {
            getListener().onAdFailed(n.D().h());
            return;
        }
        TianmuLogUtil.d("waiting tianmu init complete...");
        f();
        d dVar = new d() { // from class: com.tianmu.ad.base.BaseAd.2
            @Override // com.tianmu.c.l.d, com.tianmu.c.l.b
            public void onInitFailed() {
                BaseAd.this.b();
                BaseAd.this.getListener().onAdFailed(n.D().h());
            }

            @Override // com.tianmu.c.l.d, com.tianmu.c.l.b
            public void onInitFinished() {
                BaseAd.this.b();
                BaseAd.this.c();
            }
        };
        if (this.j == null) {
            this.j = new ArrayList();
        }
        this.j.add(dVar);
        n.D().a(dVar);
    }

    public void materialClick(BaseAdInfo baseAdInfo) {
        if (baseAdInfo == null || !baseAdInfo.b()) {
            return;
        }
        baseAdInfo.reportMultiExpose();
    }

    public void materialSkip(BaseAdInfo baseAdInfo) {
        if (baseAdInfo == null || !baseAdInfo.b()) {
            return;
        }
        baseAdInfo.reportMultiExpose();
    }

    public void onAdClick(View view, BaseAdInfo baseAdInfo, int i2) {
        com.tianmu.c.c.e eVar = this.f10628h;
        if (eVar != null) {
            if (!eVar.a(baseAdInfo)) {
                this.f10628h.onAdExpose(baseAdInfo);
            }
            materialClick(baseAdInfo);
            this.f10628h.onAdClick(baseAdInfo);
        }
        if (baseAdInfo == null || baseAdInfo.getAdData() == null || baseAdInfo.getAdData().z() == null) {
            return;
        }
        baseAdInfo.getAdData().z().a(view, baseAdInfo.getAdData(), i2);
    }

    public void onAdClose(BaseAdInfo baseAdInfo) {
        com.tianmu.c.c.e eVar = this.f10628h;
        if (eVar != null) {
            eVar.onAdClose(baseAdInfo);
        }
    }

    public void onAdExpose(BaseAdInfo baseAdInfo) {
        com.tianmu.c.c.e eVar = this.f10628h;
        if (eVar != null) {
            eVar.onAdExpose(baseAdInfo);
        }
        if (baseAdInfo != null) {
            if (baseAdInfo.b()) {
                baseAdInfo.reportMultiExpose();
            } else {
                if (baseAdInfo.getAdData() == null || baseAdInfo.getAdData().z() == null) {
                    return;
                }
                baseAdInfo.getAdData().z().a(baseAdInfo.getAdData());
            }
        }
    }

    public void onAdFailed(TianmuError tianmuError) {
        com.tianmu.c.c.e eVar = this.f10628h;
        if (eVar != null) {
            eVar.onAdFailed(tianmuError);
        }
    }

    public void onAdSlide(View view, BaseAdInfo baseAdInfo) {
        com.tianmu.c.c.e eVar = this.f10628h;
        if (eVar != null) {
            if (!eVar.a(baseAdInfo)) {
                this.f10628h.onAdExpose(baseAdInfo);
            }
            this.f10628h.onAdClick(baseAdInfo);
        }
        if (baseAdInfo == null || baseAdInfo.getAdData() == null || baseAdInfo.getAdData().z() == null) {
            return;
        }
        baseAdInfo.getAdData().z().a(view, baseAdInfo.getAdData());
    }

    public void release() {
        TianmuLogUtil.d("BaseAd release");
        d();
        e();
    }

    public abstract void requestAdInfo(com.tianmu.c.c.e eVar);

    public boolean sensorDisable() {
        return this.f10629i;
    }

    public void setAdPosId(e eVar) {
        this.f10626f = eVar;
    }

    public void setContext(Context context) {
        this.f10622b = context;
    }

    public void setListener(T t) {
        this.f10625e = t;
    }

    public final void setTimeout(long j) {
        this.f10627g = Math.max(3000L, j);
    }

    public abstract void startLoopLoadAd();

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        if (TianmuConfig.TEST_APP_ID.equals(TianmuSDK.getInstance().getAppId())) {
            return false;
        }
        return !str.equals(TianmuPackageUtil.getPackageName(TianmuSDK.getInstance().getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.f10628h == null) {
            this.f10628h = a();
        }
        if (n.D().t()) {
            onAdFailed(new TianmuError(TianmuErrorConfig.AD_FAILED_INIT_REQUEST_IS_FAILED_NEED_PREVENT, TianmuErrorConfig.MSG_AD_FAILED_INIT_REQUEST_IS_FAILED_NEED_PREVENT + n.D().h()));
            return;
        }
        if (TextUtils.isEmpty(this.f10623c)) {
            onAdFailed(new TianmuError(-2013, "PosId不能为空"));
            return;
        }
        if (!n.D().n()) {
            onAdFailed(new TianmuError(-2014, "初始化数据为空，可能是没有本地缓存的初始化数据并且初始接口请求失败"));
            return;
        }
        if (b(n.D().j())) {
            onAdFailed(new TianmuError(-2015, "AppId和包名不匹配"));
            return;
        }
        e eVarA = n.D().a(this.f10623c);
        if (eVarA == null) {
            onAdFailed(new TianmuError(-2016, TianmuErrorConfig.MSG_AD_FAILED_AD_FAILED_PLATFORM_POS_IDS_EMPTY));
            return;
        }
        setAdPosId(eVarA);
        String adType = getAdType();
        int renderType = getRenderType();
        String strB = eVarA.b();
        int iH = eVarA.h();
        if (adType == null || !adType.equals(strB)) {
            onAdFailed(new TianmuError(-2018, "该PosId对应的广告类型不匹配, 当前PosId应是 " + strB + " 广告的PosId"));
            return;
        }
        if (!"flow".equals(adType) || renderType == iH) {
            startLoopLoadAd();
            return;
        }
        HashMap map = new HashMap();
        map.put(2, "自渲染");
        map.put(1, "模版");
        onAdFailed(new TianmuError(-2019, "该PosId对应的广告渲染类型不匹配, 当前PosId应是" + ((String) map.get(Integer.valueOf(renderType))) + "广告的PosId"));
    }

    public void a(String str) {
        this.f10623c = str;
    }

    public void a(int i2) {
        if (i2 > 3) {
            i2 = 3;
        }
        this.f10624d = i2;
    }

    public void b() {
        Runnable runnable;
        Handler handler = this.k;
        if (handler == null || (runnable = this.l) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
        this.l = null;
    }
}
