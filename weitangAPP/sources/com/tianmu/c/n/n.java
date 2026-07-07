package com.tianmu.c.n;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.biz.bean.MockBean;
import com.tianmu.biz.utils.b0;
import com.tianmu.biz.utils.h0;
import com.tianmu.biz.utils.i0;
import com.tianmu.biz.utils.u;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.config.TianmuInitConfig;
import com.tianmu.d.c.b;
import com.tianmu.utils.TianmuLogUtil;
import com.tianmu.utils.TianmuPackageUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    private static n u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tianmu.c.i.k f11893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11896d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11898f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.tianmu.c.i.b f11899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f11900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f11901i;
    private boolean o;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f11902q;
    private MockBean t;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TianmuError f11897e = new TianmuError(TianmuErrorConfig.SDK_UNINITIALIZED, TianmuErrorConfig.MSG_SDK_UNINITIALIZED);
    private Handler j = new Handler(Looper.getMainLooper());
    private final List<com.tianmu.c.l.b> k = new ArrayList();
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean r = false;
    private boolean s = false;

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.this.l) {
                return;
            }
            n.this.L();
            n.this.l = true;
        }
    }

    public class c extends com.tianmu.c.k.f.a {
        public c(Handler handler) {
            super(handler);
        }

        @Override // com.tianmu.c.k.f.a
        public void a() {
        }

        @Override // com.tianmu.c.k.f.a
        public void a(int i2, String str) {
            if (i2 == -1003 && k.h().d() && k.h().a() > 0) {
                k.h().f();
                n.this.L();
            }
        }
    }

    public class d extends com.tianmu.c.k.f.b {
        public d(Handler handler) {
            super(handler);
        }

        @Override // com.tianmu.c.k.f.b
        public void a() {
        }

        @Override // com.tianmu.c.k.f.b
        public void a(int i2, String str) {
        }

        @Override // com.tianmu.c.k.f.b
        public void a(com.tianmu.c.i.b bVar) {
            n.this.f11899g = bVar;
        }
    }

    public class e implements b.c {
        public e(n nVar) {
        }

        @Override // com.tianmu.d.c.b.c
        public void a(int i2) {
            if (i2 > 0) {
                com.tianmu.d.c.a.b().a();
            }
        }
    }

    private n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        com.tianmu.c.b.d.a(new a(this.j), this.p);
    }

    private void B() {
        if (TianmuSDK.getInstance().isCheckCacheApk()) {
            com.tianmu.d.d.a.a(new e(this));
        }
    }

    private void C() {
        new Handler(Looper.getMainLooper()).postDelayed(new b(), 600L);
    }

    public static n D() {
        if (u == null) {
            synchronized (n.class) {
                if (u == null) {
                    u = new n();
                }
            }
        }
        return u;
    }

    private void E() {
        com.tianmu.c.i.b bVarB = com.tianmu.biz.utils.a.b();
        if (bVarB != null) {
            this.f11899g = bVarB;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        if (this.m) {
            return;
        }
        M();
        this.m = true;
    }

    private void G() {
        this.f11895c = false;
        if (this.f11894b) {
            return;
        }
        this.f11894b = true;
        try {
            if (TianmuSDK.getInstance().getTianmuInitListener() != null) {
                TianmuSDK.getInstance().getTianmuInitListener().onInitFinished();
            }
            List<com.tianmu.c.l.b> list = this.k;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                this.k.get(i2).onInitFinished();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void H() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (this.f11893a == null) {
            return;
        }
        q.a().a(this.f11893a);
    }

    private void J() {
        if (Build.VERSION.SDK_INT < 28 || this.n) {
            return;
        }
        this.n = true;
        String processName = Application.getProcessName();
        String packageName = TianmuPackageUtil.getPackageName(TianmuSDK.getInstance().getContext());
        if (TextUtils.isEmpty(processName) || processName.equals(packageName)) {
            return;
        }
        try {
            WebView.setDataDirectorySuffix(processName);
        } catch (Exception unused) {
        }
    }

    private void K() {
        if (i0.a().a("tm_is_use_package_strategy")) {
            TianmuLogUtil.d("strategy---> getTianmuPackageName isUse");
            i0.a().a("tm_is_use_package_strategy", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        com.tianmu.c.b.e.a(new c(this.j));
    }

    private void M() {
        com.tianmu.c.b.b.a(new d(this.j));
    }

    private void z() {
        this.m = false;
    }

    public int f() {
        com.tianmu.c.i.k kVar = this.f11893a;
        if (kVar == null) {
            return 0;
        }
        return kVar.d();
    }

    public int g() {
        com.tianmu.c.i.k kVar = this.f11893a;
        if (kVar != null) {
            return kVar.f();
        }
        return 2;
    }

    public TianmuError h() {
        return this.f11897e;
    }

    public MockBean i() {
        return this.t;
    }

    public String j() {
        com.tianmu.c.i.k kVar = this.f11893a;
        if (kVar == null) {
            return null;
        }
        return kVar.g();
    }

    public String k() {
        com.tianmu.c.i.k kVar = this.f11893a;
        return kVar == null ? "" : kVar.k();
    }

    public void l() {
        y();
        J();
        TianmuLogUtil.d("TianmuSDK Version : " + TianmuSDK.getInstance().getSdkVersion());
        C();
        com.tianmu.c.i.k kVarC = u.c();
        this.p = kVarC != null;
        a(kVarC, true);
        E();
        A();
        com.tianmu.biz.utils.m.a(TianmuSDK.getInstance().getContext());
        H();
        if (Build.VERSION.SDK_INT < 30) {
            B();
            return;
        }
        boolean zA = b0.a(TianmuSDK.getInstance().getContext(), "android.permission.QUERY_ALL_PACKAGES");
        this.o = zA;
        if (zA) {
            B();
        }
    }

    public void m() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.f11900h;
        if (j <= 0 || jCurrentTimeMillis - j <= 259200000) {
            return;
        }
        b();
        z();
        A();
    }

    public boolean n() {
        return this.f11893a != null;
    }

    public boolean o() {
        return this.r;
    }

    public boolean p() {
        return this.f11902q;
    }

    public boolean q() {
        return this.s;
    }

    public boolean r() {
        return this.f11895c;
    }

    public boolean s() {
        return this.f11894b;
    }

    public boolean t() {
        return this.f11896d;
    }

    public boolean u() {
        com.tianmu.c.i.k kVar = this.f11893a;
        return kVar != null && kVar.c() == 1;
    }

    public boolean v() {
        com.tianmu.c.i.i iVarD = d();
        if (iVarD != null) {
            return iVarD.g();
        }
        return true;
    }

    public boolean w() {
        return this.o;
    }

    public void x() {
        com.tianmu.c.i.k kVar = this.f11893a;
        if (kVar == null || this.r) {
            return;
        }
        this.r = true;
        String strE = kVar.e();
        this.f11898f = "11.11".equals(strE);
        com.tianmu.c.i.i iVarA = this.f11893a.a();
        if (iVarA != null) {
            com.tianmu.c.n.e.a().a(iVarA);
            i0.a().a("tm_request_header_ctl", iVarA.i());
        }
        if (iVarA != null) {
            com.tianmu.c.n.e.a().c(strE);
            com.tianmu.c.n.e.a().a(this.f11893a.a().b(), this.f11893a.a().a());
        }
    }

    public void y() {
        TianmuInitConfig config = TianmuSDK.getInstance().getConfig();
        if (config == null || !config.isSandbox()) {
            com.tianmu.biz.utils.g.b(config.isDebug(), config.isFlag());
        } else {
            com.tianmu.biz.utils.g.a(config.isDebug(), config.isFlag());
        }
    }

    public com.tianmu.c.i.i d() {
        com.tianmu.c.i.k kVar = this.f11893a;
        if (kVar == null) {
            return null;
        }
        return kVar.a();
    }

    @Nullable
    public List<String> e() {
        com.tianmu.c.i.b bVar = this.f11899g;
        if (bVar == null) {
            return null;
        }
        return Build.VERSION.SDK_INT >= 30 ? bVar.b() : bVar.a();
    }

    public void b() {
        this.f11901i = 0;
    }

    public boolean c() {
        return this.f11898f;
    }

    public String b(String str, String str2) {
        com.tianmu.c.i.b bVar = this.f11899g;
        return bVar != null ? bVar.b(str, str2) : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tianmu.c.i.k kVar, boolean z) {
        if (kVar != null) {
            if (!a(kVar)) {
                a(new TianmuError(TianmuErrorConfig.AD_FAILED_SHA1_CHECK_ILLEGAL_FAILED, TianmuErrorConfig.ERROR_MEGA_SHA1_CHECK_ILLEGAL));
                return;
            }
            this.f11900h = System.currentTimeMillis();
            y();
            TianmuLogUtil.d("initData---> initData is not null, isLocalData : " + z);
            TianmuLogUtil.d("privacy----> privacy is " + TianmuSDK.getInstance().getConfig().isAgreePrivacyStrategy());
            K();
            this.f11893a = kVar;
            if (kVar.l()) {
                g.I().C();
            }
            G();
            return;
        }
        TianmuLogUtil.d("initData---> initData is null, isLocalData : " + z);
    }

    public class a extends com.tianmu.c.k.f.e {
        public a(Handler handler) {
            super(handler);
        }

        @Override // com.tianmu.c.k.f.e
        public void a(com.tianmu.c.i.k kVar) {
            TianmuLogUtil.d("init data request success...");
            n.this.s = true;
            k.h().e();
            n.this.a(kVar, false);
            n.this.F();
            if (n.this.v()) {
                n.this.x();
            }
            n.this.I();
        }

        @Override // com.tianmu.c.k.f.e
        public void a() {
            TianmuLogUtil.d("init data request success... use local data");
            n.this.s = true;
            k.h().e();
            n.this.F();
            if (n.this.v()) {
                n.this.x();
            }
            n.this.I();
        }

        @Override // com.tianmu.c.k.f.e
        public void a(boolean z, int i2, String str) {
            TianmuLogUtil.d("init data request failed--> code : " + i2 + ", error : " + str);
            if (i2 != -1003 || !k.h().d() || k.h().b() <= 0) {
                n.this.f11896d = z;
                n.this.a(new TianmuError(i2, str));
            } else {
                k.h().g();
                n.this.A();
            }
        }
    }

    private boolean a(com.tianmu.c.i.k kVar) {
        String strA = h0.a(TianmuSDK.getInstance().getContext());
        String strI = kVar.i();
        String strJ = kVar.j();
        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strI)) {
            if (strA.equals(strI.toUpperCase())) {
                return true;
            }
            if (strA.equals(strJ.toUpperCase())) {
                TianmuLogUtil.d("当前为测试SHA1，上线记得使用正式签名");
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (f() <= 0) {
            return;
        }
        int i2 = this.f11901i + 1;
        this.f11901i = i2;
        if (i2 >= f()) {
            b();
            A();
        }
    }

    public void a(TianmuError tianmuError) {
        this.f11895c = true;
        if (tianmuError == null) {
            this.f11897e = new TianmuError(-1000, TianmuErrorConfig.MSG_INIT_ERROR);
        } else {
            this.f11897e = tianmuError;
        }
        try {
            TianmuLogUtil.e(this.f11897e.toString());
            if (TianmuSDK.getInstance().getTianmuInitListener() != null) {
                TianmuSDK.getInstance().getTianmuInitListener().onInitFailed(this.f11897e);
            }
            List<com.tianmu.c.l.b> list = this.k;
            if (list == null || list.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                this.k.get(i2).onInitFailed();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public com.tianmu.c.i.e a(String str) {
        com.tianmu.c.i.k kVar = this.f11893a;
        if (kVar == null || kVar.h() == null) {
            return null;
        }
        return this.f11893a.h().get(str);
    }

    public void a(com.tianmu.c.l.b bVar) {
        if (bVar != null) {
            this.k.add(bVar);
        }
    }

    public <T extends com.tianmu.c.l.b> void a(List<T> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.k.removeAll(list);
    }

    public String a(String str, String str2) {
        com.tianmu.c.i.b bVar = this.f11899g;
        return bVar != null ? bVar.a(str, str2) : "";
    }

    public void a(boolean z) {
        this.f11902q = z;
    }
}
