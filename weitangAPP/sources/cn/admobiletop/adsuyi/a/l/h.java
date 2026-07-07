package cn.admobiletop.adsuyi.a.l;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterSetting;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdmobileAdapterIniter;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiTianmuAdapterIniter;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.inner.ADSuyiInnerNoticeManager;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.exception.ADSuyiException;
import cn.admobiletop.adsuyi.exception.ADSuyiInitException;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static h f3383b;
    public boolean A;
    public ADSuyiAdmobileAdapterIniter k;
    public ADSuyiTianmuAdapterIniter l;
    public cn.admobiletop.adsuyi.a.a.c m;
    public ADSuyiInitConfig n;
    public cn.admobiletop.adsuyi.a.g.b o;
    public cn.admobiletop.adsuyi.a.g.g p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3391q;
    public cn.admobiletop.adsuyi.a.g.a r;
    public boolean s;
    public cn.admobiletop.adsuyi.a.c.a t;
    public boolean u;
    public String v;
    public List<String> w;
    public long y;
    public int z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f3382a = {"3.6.8.10281", "3.6.8.10282", "3.6.8.10283", "3.6.9.11211", "3.7.0.12211", "3.7.1.02061", "3.7.2.02221", "3.7.3.03281", "3.7.4.04271", "3.7.5.05231", "3.7.6.06251", "3.7.7.07141", "3.7.8.08181", "3.7.8.08183", "3.7.9.09111", "3.7.9.09112", "3.8.0.11281", "3.8.1.12061", "3.8.1.12062"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f3384c = "HTTP_REQUEST";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f3385d = "KEY_IS_HTTP_REQUEST";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f3386e = "SP_FILE_NAME_PERSONALIZED";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f3387f = "KEY_PERSONALIZED_ENABLED";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, ADSuyiAdapterIniter> f3388g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Handler f3389h = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<cn.admobiletop.adsuyi.a.i.a> f3390i = new ArrayList();
    public int x = 2;
    public final String j = cn.admobiletop.adsuyi.a.m.q.a(32);

    public static h l() {
        if (f3383b == null) {
            synchronized (h.class) {
                if (f3383b == null) {
                    f3383b = new h();
                }
            }
        }
        return f3383b;
    }

    public final synchronized void A(Map<String, ADSuyiPlatform> map) {
        if (map != null) {
            if (map.size() > 0) {
                try {
                    for (Map.Entry<String, ADSuyiPlatform> entry : map.entrySet()) {
                        if (entry != null) {
                            String key = entry.getKey();
                            ADSuyiPlatform value = entry.getValue();
                            if (key != null && value != null) {
                                ADSuyiAdapterIniter aDSuyiAdapterIniter = this.f3388g.get(key);
                                if (aDSuyiAdapterIniter == null) {
                                    aDSuyiAdapterIniter = (ADSuyiAdapterIniter) cn.admobiletop.adsuyi.a.m.b.c(key);
                                    if (aDSuyiAdapterIniter == null) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(key);
                                        sb.append(" 平台的初始器获取失败，请检查是否导入相应平台的AdapterSdk，如果已导入并开启了混淆请检查混淆是否配置正确");
                                        ADSuyiLogUtil.d(sb.toString());
                                    } else {
                                        this.f3388g.put(key, aDSuyiAdapterIniter);
                                    }
                                }
                                if (!aDSuyiAdapterIniter.inited()) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(key);
                                    sb2.append(" AdapterSdk version is : ");
                                    sb2.append(aDSuyiAdapterIniter.getAdapterVersion());
                                    ADSuyiLogUtil.d(sb2.toString());
                                    z(key, value, aDSuyiAdapterIniter);
                                } else if (ADSuyiPlatform.PLAFORM_ADMOBILE.equals(key)) {
                                    z(key, value, aDSuyiAdapterIniter);
                                }
                            }
                        }
                    }
                } catch (Throwable th) {
                    if (th instanceof ADSuyiException) {
                        throw th;
                    }
                    th.printStackTrace();
                }
            }
        }
    }

    public final boolean C(String str, @NonNull List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        if (list.contains(ADSuyiSdk.getInstance().getSdkVersion())) {
            return true;
        }
        List<String> listL = L();
        if (listL != null && listL.size() > 0) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                String str2 = list.get(i2);
                for (int i3 = 0; i3 < listL.size(); i3++) {
                    if (TextUtils.equals(str2, listL.get(i3))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean D(boolean z, cn.admobiletop.adsuyi.a.g.a aVar) {
        List<cn.admobiletop.adsuyi.a.g.j> listB;
        long jB;
        long jA;
        boolean z2 = false;
        if (z && aVar != null && (listB = cn.admobiletop.adsuyi.a.m.d.b(aVar.p())) != null && listB.size() > 0) {
            try {
                long jA2 = cn.admobiletop.adsuyi.a.m.e.a();
                int i2 = 0;
                while (true) {
                    if (i2 >= listB.size()) {
                        jB = 0;
                        jA = 0;
                        break;
                    }
                    cn.admobiletop.adsuyi.a.g.j jVar = listB.get(i2);
                    jB = jVar.b();
                    jA = jVar.a();
                    if (jA2 >= jB && jA2 <= jA) {
                        break;
                    }
                    i2++;
                }
                if (jB > 0 && jA > jB) {
                    long jS = aVar.s();
                    if (jS > jB && jS < jA) {
                        z2 = true;
                    }
                    return !z2;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public ADSuyiAdmobileAdapterIniter I() {
        return this.k;
    }

    public ADSuyiTianmuAdapterIniter J() {
        return this.l;
    }

    public final void K() {
        cn.admobiletop.adsuyi.a.a.d.a(new e(this, this.j, this.f3389h));
    }

    public final List<String> L() {
        if (this.w == null) {
            ArrayList arrayList = new ArrayList();
            this.w = arrayList;
            String[] strArr = f3382a;
            if (strArr != null && strArr.length > 0) {
                arrayList.addAll(Arrays.asList(strArr));
            }
        }
        return this.w;
    }

    public final void M() {
        ADSuyiAdmobileAdapterIniter aDSuyiAdmobileAdapterIniter = (ADSuyiAdmobileAdapterIniter) cn.admobiletop.adsuyi.a.m.b.c(ADSuyiPlatform.PLAFORM_ADMOBILE);
        this.k = aDSuyiAdmobileAdapterIniter;
        if (aDSuyiAdmobileAdapterIniter != null) {
            aDSuyiAdmobileAdapterIniter.boot();
            this.f3388g.put(ADSuyiPlatform.PLAFORM_ADMOBILE, this.k);
        }
    }

    public final void N() {
        if (this.f3391q) {
            return;
        }
        this.f3391q = true;
        for (int i2 = 0; i2 < this.f3390i.size(); i2++) {
            try {
                this.f3390i.get(i2).a();
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    public final void O() {
        M();
        Q();
        if (this.k == null && this.l == null) {
            throw new ADSuyiInitException(new ADSuyiError(ADSuyiErrorConfig.ADMOBILETOP_ADAPTER_IS_NULL, ADSuyiErrorConfig.MSG_ADMOBILETOP_ADAPTER_IS_NULL));
        }
    }

    public final void P() {
        ADSuyiAdmobileAdapterIniter aDSuyiAdmobileAdapterIniter = this.k;
        if (aDSuyiAdmobileAdapterIniter != null) {
            aDSuyiAdmobileAdapterIniter.initQuickAppMonitor(this.r.u());
            this.k.initQuickAppKeywords(this.r.m());
            this.k.initMachineId(p.a().b());
        }
        ADSuyiTianmuAdapterIniter aDSuyiTianmuAdapterIniter = this.l;
        if (aDSuyiTianmuAdapterIniter != null) {
            aDSuyiTianmuAdapterIniter.initMachineId(p.a().b());
        }
    }

    public final void Q() {
        ADSuyiTianmuAdapterIniter aDSuyiTianmuAdapterIniter = (ADSuyiTianmuAdapterIniter) cn.admobiletop.adsuyi.a.m.b.c("tianmu");
        this.l = aDSuyiTianmuAdapterIniter;
        if (aDSuyiTianmuAdapterIniter != null) {
            this.f3388g.put("tianmu", aDSuyiTianmuAdapterIniter);
        }
    }

    public void a(cn.admobiletop.adsuyi.a.i.a aVar) {
        if (aVar != null) {
            this.f3390i.add(aVar);
        }
    }

    public ADSuyiAdapterIniter b(String str) {
        return this.f3388g.get(str);
    }

    public ADSuyiPlatform c(String str) {
        cn.admobiletop.adsuyi.a.g.a aVar = this.r;
        if (aVar == null || aVar.j() == null) {
            return null;
        }
        return this.r.j().get(str);
    }

    public ADSuyiPosId d(String str) {
        cn.admobiletop.adsuyi.a.g.a aVar = this.r;
        if (aVar == null || aVar.k() == null) {
            return null;
        }
        return this.r.k().get(str);
    }

    public final void e() {
        new Handler(Looper.getMainLooper()).postDelayed(new f(this), 500L);
    }

    public int f() {
        cn.admobiletop.adsuyi.a.g.a aVar = this.r;
        if (aVar == null) {
            return 0;
        }
        return aVar.b();
    }

    public int g() {
        cn.admobiletop.adsuyi.a.g.a aVar = this.r;
        return aVar == null ? this.x : aVar.c();
    }

    public ADSuyiInitConfig h() {
        return this.n;
    }

    public cn.admobiletop.adsuyi.a.g.a i() {
        return this.r;
    }

    public String j() {
        return this.v;
    }

    public ADSuyiPosId k() {
        cn.admobiletop.adsuyi.a.g.a aVar = this.r;
        if (aVar == null) {
            return null;
        }
        return aVar.e();
    }

    public final void m() {
        if (!(ADSuyiSdk.getInstance().getContext() instanceof Application)) {
            ADSuyiLogUtil.d("register activity lifecycle error");
        } else {
            this.t = new cn.admobiletop.adsuyi.a.c.a();
            ((Application) ADSuyiSdk.getInstance().getContext()).registerActivityLifecycleCallbacks(this.t);
        }
    }

    public void n() {
        s();
        ADSuyiLogUtil.d("ADSuyiSdk Version : " + ADSuyiSdk.getInstance().getSdkVersion());
        this.n = ADSuyiSdk.getInstance().getConfig();
        O();
        this.m = new cn.admobiletop.adsuyi.a.a.a();
        b.b().e();
        m();
        cn.admobiletop.adsuyi.a.m.c.a(ADSuyiSdk.getInstance().getContext());
        ADSuyiInitConfig aDSuyiInitConfig = this.n;
        if (aDSuyiInitConfig != null && aDSuyiInitConfig.isOpenFloatingAd()) {
            o.b().c();
        }
        w(cn.admobiletop.adsuyi.a.m.h.a(this.j), true);
        K();
        e();
    }

    public void o() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.y;
        if (j <= 0 || jCurrentTimeMillis - j <= 259200000) {
            return;
        }
        b();
        K();
    }

    public boolean p() {
        cn.admobiletop.adsuyi.a.g.a aVar = this.r;
        if (aVar != null) {
            return aVar.t();
        }
        return false;
    }

    public boolean q() {
        return this.f3391q;
    }

    public boolean r() {
        return this.u;
    }

    public void s() {
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        cn.admobiletop.adsuyi.a.g.a aVar = this.r;
        boolean zA = aVar != null ? cn.admobiletop.adsuyi.a.m.o.a(aVar.d()) : false;
        if (config.isSandbox()) {
            cn.admobiletop.adsuyi.a.m.a.a(config.isDebug(), zA);
        } else {
            cn.admobiletop.adsuyi.a.m.a.b(config.isDebug(), zA);
        }
    }

    public final void t() {
        cn.admobiletop.adsuyi.a.h.d.c().a(cn.admobiletop.adsuyi.a.a.b.m, null, new g(this, this.f3389h));
    }

    public final void v(cn.admobiletop.adsuyi.a.g.a aVar) {
        ADSuyiAdmobileAdapterIniter aDSuyiAdmobileAdapterIniter = this.k;
        if (aDSuyiAdmobileAdapterIniter != null) {
            aDSuyiAdmobileAdapterIniter.initForcedPrintLog(this.s);
            j.a().d(aVar.l(), aVar.a());
        }
    }

    public final void w(cn.admobiletop.adsuyi.a.g.a aVar, boolean z) {
        if (aVar == null) {
            ADSuyiLogUtil.d("initData---> initData is null, isLocalData : " + z);
            return;
        }
        this.y = System.currentTimeMillis();
        if (z) {
            cn.admobiletop.adsuyi.a.a.d.a(false);
        }
        if (D(z, aVar)) {
            ADSuyiLogUtil.d("initData---> skipLocalCache");
            return;
        }
        if (!z) {
            s.a().a("suyi_request_header_ctl", aVar.v());
        }
        ADSuyiLogUtil.d("initData---> initData is not null, isLocalData : " + z);
        ADSuyiLogUtil.d("privacy---> privacy is " + ADSuyiSdk.getInstance().getConfig().isAgreePrivacyStrategy());
        if (s.a().a("suyi_is_use_package_strategy")) {
            ADSuyiLogUtil.d("strategy---> getSuyiPackageName isUse");
            s.a().a("suyi_is_use_package_strategy", false);
        }
        this.r = aVar;
        if (this.o == null) {
            this.o = new cn.admobiletop.adsuyi.a.g.b(aVar.f(), aVar.g(), aVar.a(), aVar.h());
        }
        if (this.p == null) {
            this.p = new cn.admobiletop.adsuyi.a.g.g(aVar.f(), aVar.g(), aVar.a(), aVar.o());
        }
        P();
        ADSuyiPlatform aDSuyiPlatformC = c(ADSuyiPlatform.PLAFORM_ADMOBILE);
        if (aDSuyiPlatformC == null) {
            s.a().a("admobilePlatformEmpty", true);
        } else {
            s.a().a("admobilePlatformEmpty", false);
        }
        A(aVar.j());
        cn.admobiletop.adsuyi.a.f.c.b().a();
        if (!z) {
            int iD = aVar.d();
            this.s = 618 == iD;
            s.a().b(f3384c, f3385d, this.s);
            j.a().b(iD);
            if (this.k != null && aDSuyiPlatformC != null) {
                v(aVar);
            }
            ADSuyiInitConfig aDSuyiInitConfig = this.n;
            if (aDSuyiInitConfig != null) {
                if (aDSuyiInitConfig.isOpenFloatingAd()) {
                    o.b().f();
                } else {
                    ADSuyiInnerNoticeManager.getInstance().init();
                }
            }
        }
        N();
        ADSuyiSdk.getInstance().setInitListenerSuccess();
    }

    public final void z(String str, ADSuyiPlatform aDSuyiPlatform, ADSuyiAdapterIniter aDSuyiAdapterIniter) {
        List<String> supportADSuyiSdkVersions = aDSuyiAdapterIniter.getSupportADSuyiSdkVersions();
        if (supportADSuyiSdkVersions == null || supportADSuyiSdkVersions.isEmpty()) {
            throw new ADSuyiInitException(new ADSuyiError(ADSuyiErrorConfig.INIT_ADAPTER_SUPPORT_SUYI_SDK_IS_EMPTY, str + ADSuyiErrorConfig.MSG_INIT_ADAPTER_SUPPORT_SUYI_SDK_IS_EMPTY));
        }
        if (!C(str, supportADSuyiSdkVersions)) {
            throw new ADSuyiInitException(new ADSuyiError(ADSuyiErrorConfig.INIT_ADAPTER_SUPPORT_VERSION_HAS_NOT_CONTAINS, str + ADSuyiErrorConfig.MSG_INIT_ADAPTER_SUPPORT_VERSION_HAS_NOT_CONTAINS));
        }
        try {
            aDSuyiAdapterIniter.init(aDSuyiPlatform, this.o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public <T extends cn.admobiletop.adsuyi.a.i.a> void a(List<T> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f3390i.removeAll(list);
    }

    public void b() {
        this.z = 0;
    }

    public boolean c() {
        return this.s;
    }

    public cn.admobiletop.adsuyi.a.c.a d() {
        return this.t;
    }

    public boolean a(String str) {
        String str2 = this.j;
        return str2 != null && str2.equals(str);
    }

    public void a(int i2) {
        this.x = i2;
    }

    public void a() {
        if (f() <= 0) {
            return;
        }
        int i2 = this.z + 1;
        this.z = i2;
        if (i2 >= f()) {
            b();
            K();
        }
    }

    public void a(boolean z) {
        if (q() && this.f3388g.size() > 0) {
            Iterator<String> it = this.f3388g.keySet().iterator();
            while (it.hasNext()) {
                ADSuyiAdapterIniter aDSuyiAdapterIniter = this.f3388g.get(it.next());
                if ((aDSuyiAdapterIniter instanceof ADSuyiAdapterSetting) && aDSuyiAdapterIniter.inited()) {
                    ((ADSuyiAdapterSetting) aDSuyiAdapterIniter).setPersonalizedAdEnabled(z);
                }
            }
        }
    }
}
