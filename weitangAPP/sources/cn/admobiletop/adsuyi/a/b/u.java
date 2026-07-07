package cn.admobiletop.adsuyi.a.b;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.c.a;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.api.ADSuyiNetworkRequestInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiReleaseListener;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import cn.admobiletop.adsuyi.util.ADSuyiPackageUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class u<T extends ADSuyiAdListener> implements ADSuyiAd<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f3220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Activity f3221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f3222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f3223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3224e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w f3226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a.InterfaceC0050a f3228i;
    public FragmentManager.FragmentLifecycleCallbacks j;
    public String k;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3225f = 30000;
    public List<ADSuyiReleaseListener> l = new ArrayList();

    public u(@NonNull Activity activity) {
        this.f3221b = activity;
        cn.admobiletop.adsuyi.a.c.a aVarD = cn.admobiletop.adsuyi.a.l.h.l().d();
        if (aVarD != null) {
            s sVar = new s(this);
            this.f3228i = sVar;
            aVarD.a(sVar);
        }
        b();
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public void addReleaseListener(ADSuyiReleaseListener aDSuyiReleaseListener) {
        List<ADSuyiReleaseListener> list = this.l;
        if (list == null || aDSuyiReleaseListener == null) {
            return;
        }
        list.add(aDSuyiReleaseListener);
    }

    public final void b() {
        this.k = cn.admobiletop.adsuyi.a.m.q.a(32);
        this.f3226g = cn.admobiletop.adsuyi.a.j.g.a(this);
    }

    public final void d() {
        List<ADSuyiReleaseListener> list = this.l;
        if (list != null && list.size() > 0) {
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                try {
                    this.l.get(i2).onRelease(this);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.l.clear();
        }
        this.l = null;
    }

    public final void e() {
        this.f3221b = null;
        cn.admobiletop.adsuyi.a.c.a aVarD = cn.admobiletop.adsuyi.a.l.h.l().d();
        if (aVarD != null) {
            aVarD.b(this.f3228i);
        }
        this.f3228i = null;
    }

    public final void f() {
        w wVar = this.f3226g;
        if (wVar != null) {
            wVar.release();
            this.f3226g = null;
        }
    }

    public final void g() {
        Fragment fragment = this.f3220a;
        if (fragment != null && this.j != null && fragment.getFragmentManager() != null) {
            try {
                this.f3220a.getFragmentManager().unregisterFragmentLifecycleCallbacks(this.j);
                this.j = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f3220a = null;
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public Activity getActivity() {
        return this.f3221b;
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public String getKey() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public T getListener() {
        return this.f3223d;
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public String getOnlySupportPlatform() {
        return this.f3227h;
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public final long getTimeout() {
        return this.f3225f;
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public boolean isReleased() {
        Activity activity;
        return this.f3222c != null ? this.f3224e : this.f3224e || (activity = this.f3221b) == null || activity.isFinishing();
    }

    public void loadAd(String str) {
        loadAd(str, 1);
    }

    public void loadDefaultAd(String str, int i2, ADSuyiNetworkRequestInfo aDSuyiNetworkRequestInfo) {
        if (!ADSuyiPackageUtil.isMainThread()) {
            if (ADSuyiAdUtil.canCallBack(this)) {
                getListener().onAdFailed(new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_MUST_LOAD_AD_IN_MAIN_THREAD, "必须在主线程获取广告"));
                return;
            }
            return;
        }
        if (cn.admobiletop.adsuyi.a.l.h.l().h() == null) {
            if (ADSuyiAdUtil.canCallBack(this)) {
                getListener().onAdFailed(new ADSuyiError(ADSuyiErrorConfig.INIT_METHOD_NOT_CALL, ADSuyiErrorConfig.MSG_INIT_METHOD_NOT_CALL));
            }
        } else if (isReleased()) {
            if (getListener() != null) {
                getListener().onAdFailed(new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_SUYI_AD_IS_RELEASED, ADSuyiErrorConfig.MSG_AD_FAILED_SUYI_AD_IS_RELEASED));
            }
        } else {
            w wVar = this.f3226g;
            if (wVar == null || !(wVar instanceof cn.admobiletop.adsuyi.a.j.j)) {
                return;
            }
            cn.admobiletop.adsuyi.a.l.q.c().e();
            ((cn.admobiletop.adsuyi.a.j.j) this.f3226g).a(str, i2, aDSuyiNetworkRequestInfo);
        }
    }

    public void release() {
        if (this.f3224e) {
            return;
        }
        ADSuyiLogUtil.d(getAdType() + " release...");
        this.f3224e = true;
        this.f3223d = null;
        d();
        f();
        e();
        g();
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public void removeReleaseListener(ADSuyiReleaseListener aDSuyiReleaseListener) {
        List<ADSuyiReleaseListener> list = this.l;
        if (list == null || aDSuyiReleaseListener == null) {
            return;
        }
        list.remove(aDSuyiReleaseListener);
    }

    public void setListener(T t) {
        this.f3223d = t;
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public void setOnlySupportPlatform(String str) {
        if (ADSuyiSdk.getInstance().isDebug()) {
            this.f3227h = str;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.ADSuyiAd
    public final void setTimeout(long j) {
        this.f3225f = Math.max(3000L, j);
    }

    public void loadAd(String str, int i2) {
        if (!ADSuyiPackageUtil.isMainThread()) {
            if (ADSuyiAdUtil.canCallBack(this)) {
                getListener().onAdFailed(new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_MUST_LOAD_AD_IN_MAIN_THREAD, "必须在主线程获取广告"));
            }
        } else if (cn.admobiletop.adsuyi.a.l.h.l().h() == null) {
            if (ADSuyiAdUtil.canCallBack(this)) {
                getListener().onAdFailed(new ADSuyiError(ADSuyiErrorConfig.INIT_METHOD_NOT_CALL, ADSuyiErrorConfig.MSG_INIT_METHOD_NOT_CALL));
            }
        } else if (isReleased()) {
            if (getListener() != null) {
                getListener().onAdFailed(new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_SUYI_AD_IS_RELEASED, ADSuyiErrorConfig.MSG_AD_FAILED_SUYI_AD_IS_RELEASED));
            }
        } else if (this.f3226g != null) {
            cn.admobiletop.adsuyi.a.l.q.c().e();
            this.f3226g.a(str, i2);
        }
    }

    public u(@NonNull Fragment fragment) {
        this.f3220a = fragment;
        this.f3221b = fragment.getActivity();
        if (fragment.getFragmentManager() != null) {
            try {
                this.j = new t(this, fragment);
                fragment.getFragmentManager().registerFragmentLifecycleCallbacks(this.j, true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        b();
    }

    public u(@NonNull Context context) {
        this.f3222c = context;
        b();
    }
}
