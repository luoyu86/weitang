package com.tianmu.c.c;

import android.os.Handler;
import com.tianmu.ad.base.BaseAd;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.base.BaseAdListener;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.biz.utils.u0;
import com.tianmu.c.c.f;
import com.tianmu.c.n.n;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuAdUtil;
import com.tianmu.utils.TianmuClassUtil;
import com.tianmu.utils.TianmuLogUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<K extends f, T extends BaseAdInfo, R extends BaseAdListener<T>, E extends BaseAd<R>> implements i, BaseAdListener<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f11235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public E f11236b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f11241g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.tianmu.c.i.e f11242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11243i;
    public String j;
    private boolean m;
    private int n;
    private String o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TianmuError f11237c = new TianmuError();
    public Map<T, K> k = new HashMap();
    public Runnable l = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.a(-2010, "获取广告超时");
            TianmuLogUtil.e("广告位获取超时：" + e.this.f11241g);
            e.this.n();
        }
    }

    public e(E e2, Handler handler) {
        this.f11236b = e2;
        this.o = e2.getAdType();
        this.f11235a = handler;
        t();
    }

    private void q() {
        if (TianmuClassUtil.isImportTianmuAdapterDependencies() || com.tianmu.apilib.adapter.a.a.b().a() || this.m || 1 != this.n) {
            return;
        }
        a(com.tianmu.c.n.e.a().a(this.o));
    }

    private void r() {
        TianmuError tianmuError = this.f11237c;
        if (tianmuError != null) {
            tianmuError.release();
            this.f11237c = null;
        }
    }

    private void s() {
        Map<T, K> map = this.k;
        if (map != null) {
            map.clear();
            this.k = null;
        }
    }

    private void t() {
        if (this.f11235a == null || this.l == null || TianmuAdUtil.isReleased(this.f11236b)) {
            return;
        }
        this.f11235a.postDelayed(this.l, this.f11236b.getTimeout());
    }

    public abstract K a();

    public void a(com.tianmu.c.i.e eVar, int i2) {
        if (eVar == null) {
            onAdFailed(new TianmuError(-2016, TianmuErrorConfig.MSG_AD_FAILED_AD_FAILED_PLATFORM_POS_IDS_EMPTY));
            release();
            return;
        }
        if (this.f11239e || this.f11240f) {
            return;
        }
        this.f11242h = eVar;
        this.f11239e = true;
        String strG = eVar.g();
        this.f11241g = strG;
        TianmuError tianmuError = this.f11237c;
        if (tianmuError != null) {
            tianmuError.setPosId(strG);
        }
        this.n = eVar.c();
        if (i2 < 1) {
            this.f11243i = 1;
        } else if (i2 > 3) {
            this.f11243i = 3;
        } else {
            this.f11243i = i2;
        }
        a(u0.a(32));
        n.D().m();
        n.D().a();
        com.tianmu.c.b.f.a("request", this.f11241g, i2, e());
        j();
    }

    public com.tianmu.c.i.e b() {
        return this.f11242h;
    }

    public Map<T, K> c() {
        return this.k;
    }

    public E d() {
        return this.f11236b;
    }

    public String e() {
        return this.j;
    }

    public boolean f() {
        if (b() != null) {
            return b().k();
        }
        return false;
    }

    public boolean g() {
        return this.f11238d;
    }

    public boolean h() {
        Map<T, K> map = this.k;
        return map != null && map.size() > 0;
    }

    public void i() {
        try {
            if (!n.D().q() || n.D().v() || n.D().o()) {
                q();
            } else {
                n.D().x();
            }
        } catch (Exception unused) {
        }
    }

    public void j() {
        if (h() || g() || TianmuAdUtil.isReleased(this.f11236b)) {
            return;
        }
        try {
            if (TianmuAdUtil.isReleased(this.f11236b)) {
                return;
            }
            i();
            com.tianmu.c.b.g.a("request", this.f11243i, this.j);
            this.f11236b.requestAdInfo(this);
        } catch (Throwable th) {
            th.printStackTrace();
            a(new TianmuError(-2012, "获取广告时发生未知异常"));
        }
    }

    public boolean k() {
        return true;
    }

    public boolean l() {
        return true;
    }

    public void m() {
    }

    public void n() {
        o();
        if (g()) {
            return;
        }
        this.f11238d = true;
        if (TianmuAdUtil.canCallBack(this.f11236b)) {
            this.f11236b.getListener().onAdFailed(this.f11237c);
        }
        if (l()) {
            release();
        }
    }

    public void o() {
        Runnable runnable;
        Handler handler = this.f11235a;
        if (handler == null || (runnable = this.l) == null) {
            return;
        }
        handler.removeCallbacks(runnable);
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdClick(T t) {
        if (!h() || t == null) {
            return;
        }
        K k = this.k.get(t);
        if (k != null && !k.a()) {
            k.a(true);
            com.tianmu.c.b.g.a("click", 1, this.j);
            i();
        }
        if (TianmuAdUtil.canCallBack(this.f11236b)) {
            this.f11236b.getListener().onAdClick(t);
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdClose(T t) {
        K k;
        if (!h() || g() || t == null || (k = this.k.get(t)) == null || k.b()) {
            return;
        }
        k.b(true);
        m();
        i();
        if (TianmuAdUtil.canCallBack(this.f11236b)) {
            this.f11236b.getListener().onAdClose(t);
        }
        if (k()) {
            release();
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdExpose(T t) {
        K k;
        if (!h() || t == null || (k = this.k.get(t)) == null || k.c()) {
            return;
        }
        k.c(true);
        com.tianmu.c.b.g.a("display", 1, this.j);
        i();
        if (TianmuAdUtil.canCallBack(this.f11236b)) {
            com.tianmu.d.c.a.b().a(true);
            this.f11236b.getListener().onAdExpose(t);
        }
    }

    @Override // com.tianmu.ad.base.BaseAdListener
    public void onAdFailed(TianmuError tianmuError) {
        a(tianmuError);
    }

    public void p() {
        com.tianmu.c.b.g.a("winNotice", 1, e());
    }

    @Override // com.tianmu.ad.base.IBaseRelease
    public void release() {
        if (this.f11240f) {
            return;
        }
        this.f11240f = true;
        this.f11238d = true;
        try {
            this.f11236b = null;
            this.l = null;
            r();
            s();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(int i2, String str) {
        TianmuError tianmuError = this.f11237c;
        if (tianmuError != null) {
            tianmuError.setCode(i2);
            this.f11237c.setError(str);
        }
    }

    public void a(TianmuError tianmuError) {
        o();
        if (tianmuError != null) {
            TianmuLogUtil.d(tianmuError.toString());
        }
        if (TianmuAdUtil.canCallBack(this.f11236b)) {
            this.f11236b.getListener().onAdFailed(tianmuError);
        }
    }

    public boolean a(T t) {
        try {
            return this.k.get(t).c();
        } catch (Exception unused) {
            return false;
        }
    }

    public void a(int i2, int i3) {
        com.tianmu.c.b.g.a("winFail", this.f11243i, e(), i3, i2);
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void a(String str) {
        this.j = str;
    }
}
