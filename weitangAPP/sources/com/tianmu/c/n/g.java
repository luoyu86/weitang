package com.tianmu.c.n;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.TianmuNativeDetiveUtil;
import com.tianmu.biz.utils.a0;
import com.tianmu.biz.utils.d0;
import com.tianmu.biz.utils.w;
import com.tianmu.biz.utils.w0;
import com.tianmu.config.TianmuCustomController;
import com.tianmu.config.TianmuInitConfig;
import com.tianmu.config.TianmuLocationProvider;
import com.tianmu.utils.TianmuLogUtil;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static g H;
    private TianmuInitConfig E;
    private TianmuCustomController F;
    private Location G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f11856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f11863i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f11864q;
    private w0.a r;
    private long s;
    private long t;
    private long u;
    private long v;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;

    public class a implements com.tianmu.i.a.b {
        public a() {
        }

        @Override // com.tianmu.i.a.b
        public void a(Exception exc) {
        }

        @Override // com.tianmu.i.a.b
        public void a(String str) {
            TianmuLogUtil.d("getTMID : " + str);
            com.tianmu.biz.utils.p.a(TianmuSDK.getInstance().getContext(), str);
            g.this.f11858d = str;
        }
    }

    private String E() {
        if (TianmuSDK.getInstance().getContext() != null) {
            return com.tianmu.biz.utils.p.a(TianmuSDK.getInstance().getContext());
        }
        return null;
    }

    private TianmuInitConfig F() {
        if (this.E == null) {
            this.E = TianmuSDK.getInstance().getConfig();
        }
        return this.E;
    }

    private TianmuCustomController G() {
        try {
            if (this.F == null && F() != null) {
                this.F = F().getCustomController();
            }
        } catch (Exception unused) {
        }
        return this.F;
    }

    private String H() {
        if (F() == null || G() == null) {
            return "";
        }
        String devOaid = G().getDevOaid();
        if (TextUtils.isEmpty(devOaid)) {
            return "";
        }
        TianmuLogUtil.d("getCustomOAID : " + devOaid);
        return devOaid;
    }

    public static g I() {
        if (H == null) {
            synchronized (g.class) {
                if (H == null) {
                    H = new g();
                }
            }
        }
        return H;
    }

    private void J() {
        String strA = TianmuNativeDetiveUtil.c().a();
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        d0.b(strA);
        this.p = strA;
    }

    private void K() {
        if (this.B) {
            return;
        }
        this.B = true;
        if (F() == null) {
            return;
        }
        if (F().isCanUseWifiState()) {
            List<String> listA = a0.a();
            if (!listA.isEmpty()) {
                String str = listA.get(0);
                this.n = str;
                d0.e(str);
            }
        }
        if (TextUtils.isEmpty(this.n)) {
            String strE = d0.e();
            if (TextUtils.isEmpty(strE)) {
                return;
            }
            this.n = strE;
        }
    }

    private void L() {
        if (this.D) {
            return;
        }
        this.D = true;
        this.v = System.currentTimeMillis();
        w0.a aVarA = w0.a(TianmuSDK.getInstance().getConfig().isCanUseWifiState());
        this.r = aVarA;
        if (aVarA != null) {
            if (!TextUtils.isEmpty(aVarA.f10905a)) {
                d0.k(this.r.f10905a);
            }
            if (TextUtils.isEmpty(this.r.f10906b)) {
                return;
            }
            d0.j(this.r.f10906b);
        }
    }

    private void i(Context context) {
        if (this.x) {
            return;
        }
        this.x = true;
        if (F() == null) {
            return;
        }
        if (F().isCanUsePhoneState()) {
            String strA = com.tianmu.biz.utils.s.a(context);
            this.f11855a = strA;
            d0.a(strA);
            if (!TextUtils.isEmpty(this.f11855a)) {
                return;
            }
        }
        if (G() != null) {
            String androidId = G().getAndroidId();
            if (!TextUtils.isEmpty(androidId)) {
                this.f11855a = androidId;
                return;
            }
        }
        if (TextUtils.isEmpty(this.f11855a)) {
            String strA2 = d0.a();
            if (TextUtils.isEmpty(strA2)) {
                return;
            }
            this.f11855a = strA2;
        }
    }

    private void j(Context context) {
        if (this.z) {
            return;
        }
        this.z = true;
        if (F() == null) {
            return;
        }
        if (F().isCanUsePhoneState()) {
            String strB = com.tianmu.biz.utils.s.b(context);
            this.f11856b = strB;
            d0.c(strB);
            if (!TextUtils.isEmpty(this.f11856b)) {
                return;
            }
        }
        if (G() != null) {
            String devImei = G().getDevImei();
            if (!TextUtils.isEmpty(devImei)) {
                this.f11856b = devImei;
            }
        }
        if (TextUtils.isEmpty(this.f11856b)) {
            String strC = d0.c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            this.f11856b = strC;
        }
    }

    private void k(Context context) {
        if (this.A) {
            return;
        }
        this.A = true;
        if (F() == null) {
            return;
        }
        if (F().isCanUsePhoneState()) {
            String strC = com.tianmu.biz.utils.s.c(context);
            this.f11857c = strC;
            d0.d(strC);
        }
        if (TextUtils.isEmpty(this.f11857c)) {
            String strD = d0.d();
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            this.f11857c = strD;
        }
    }

    public void A() {
        this.y = false;
    }

    public void B() {
        this.D = false;
    }

    public void C() {
        if (F() == null || this.w || !TextUtils.isEmpty(H())) {
            return;
        }
        this.w = true;
        try {
            String strE = E();
            if (!TextUtils.isEmpty(strE)) {
                TianmuLogUtil.d("get catch tm id success");
                this.f11858d = strE;
            }
            com.tianmu.i.a.a.a(TianmuSDK.getInstance().getContext(), new a());
        } catch (Throwable unused) {
        }
    }

    public void D() {
        String strB = TianmuNativeDetiveUtil.c().b();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        d0.i(strB);
        this.f11864q = strB;
    }

    public String b(Context context) {
        if (!TextUtils.isEmpty(this.f11855a)) {
            return this.f11855a;
        }
        i(context);
        return d();
    }

    public String c(Context context) {
        if (!TextUtils.isEmpty(this.f11856b)) {
            return this.f11856b;
        }
        j(context);
        return g();
    }

    public String d() {
        String str = this.f11855a;
        if (str != null) {
            return str;
        }
        if (G() == null) {
            return "";
        }
        String androidId = G().getAndroidId();
        if (TextUtils.isEmpty(androidId)) {
            return "";
        }
        this.f11855a = androidId;
        return androidId;
    }

    public String e(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(this.k)) {
            if (jCurrentTimeMillis - this.u <= TTAdConstant.AD_MAX_EVENT_TIME) {
                return this.k;
            }
            z();
        }
        b(context, jCurrentTimeMillis);
        return j();
    }

    public String f(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(this.l)) {
            if (jCurrentTimeMillis - this.u <= TTAdConstant.AD_MAX_EVENT_TIME) {
                return this.l;
            }
            z();
        }
        c(context, jCurrentTimeMillis);
        return k();
    }

    public String g(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(this.f11860f)) {
            if (jCurrentTimeMillis - this.t <= TTAdConstant.AD_MAX_EVENT_TIME) {
                return this.f11860f;
            }
            A();
        }
        d(context, jCurrentTimeMillis);
        return l();
    }

    public String h(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f11861g == null || jCurrentTimeMillis - this.s > TTAdConstant.AD_MAX_EVENT_TIME) {
            this.s = jCurrentTimeMillis;
            String strA = a0.a(context);
            if ("unknown".equals(strA)) {
                strA = "";
            }
            this.f11861g = strA;
        }
        return this.f11861g;
    }

    public String l() {
        String str = this.f11860f;
        if (str != null) {
            return str;
        }
        if (G() == null) {
            return "";
        }
        String macAddress = G().getMacAddress();
        if (TextUtils.isEmpty(macAddress)) {
            return "";
        }
        this.f11860f = macAddress;
        return macAddress;
    }

    public String m() {
        if (this.j == null) {
            this.j = Build.MODEL;
        }
        return this.j.toUpperCase();
    }

    public String n() {
        String str = this.f11858d;
        if (str != null) {
            return str;
        }
        String strH = H();
        if (TextUtils.isEmpty(strH)) {
            return "";
        }
        this.f11858d = strH;
        return strH;
    }

    public String o() {
        if (this.f11862h == null) {
            this.f11862h = Build.VERSION.RELEASE;
        }
        return this.f11862h;
    }

    public String p() {
        String str = this.f11864q;
        return str != null ? str : "";
    }

    public String q() {
        if (!TextUtils.isEmpty(this.f11859e)) {
            return this.f11859e;
        }
        if (F() == null || G() == null) {
            return "";
        }
        String devVaid = G().getDevVaid();
        if (TextUtils.isEmpty(devVaid)) {
            return "";
        }
        this.f11859e = devVaid;
        return devVaid;
    }

    public String r() {
        if (this.f11863i == null) {
            this.f11863i = Build.BRAND;
        }
        return this.f11863i.toUpperCase();
    }

    public String s() {
        w0.a aVar = this.r;
        return (aVar == null || TextUtils.isEmpty(aVar.f10906b)) ? "" : this.r.f10906b;
    }

    public String t() {
        w0.a aVar = this.r;
        return (aVar == null || TextUtils.isEmpty(aVar.f10905a)) ? "" : this.r.f10905a;
    }

    public void u() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.r != null && jCurrentTimeMillis - this.v > TTAdConstant.AD_MAX_EVENT_TIME) {
            B();
        }
        L();
    }

    public void v() {
        this.x = false;
    }

    public void w() {
        this.z = false;
    }

    public void x() {
        this.A = false;
    }

    public void y() {
        this.B = false;
    }

    public void z() {
        this.C = false;
    }

    public String a(Context context) {
        if (context != null && this.m == null) {
            this.m = "PHONE";
            try {
                if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                    this.m = "PAD";
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.m;
    }

    private void c(Context context, long j) {
        TianmuLocationProvider tianmuLocation;
        TianmuInitConfig config = TianmuSDK.getInstance().getConfig();
        if (config == null) {
            return;
        }
        if (!config.isCanUseLocation()) {
            if (G() == null || (tianmuLocation = G().getTianmuLocation()) == null) {
                return;
            }
            this.l = String.valueOf(tianmuLocation.getLongitude());
            return;
        }
        if (context != null) {
            Location locationA = a(context, j);
            String str = "";
            if (locationA != null) {
                str = locationA.getLongitude() + "";
            }
            this.l = str;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d0.g(this.l);
        }
    }

    public String b() {
        if (!TextUtils.isEmpty(this.n)) {
            return this.n;
        }
        K();
        return i();
    }

    private void d(Context context, long j) {
        if (this.y) {
            return;
        }
        this.t = j;
        this.y = true;
        if (F() == null) {
            return;
        }
        if (F().isCanUseWifiState()) {
            String strD = com.tianmu.biz.utils.s.d(context);
            this.f11860f = strD;
            d0.h(strD);
            if (!TextUtils.isEmpty(this.f11860f)) {
                return;
            }
        }
        if (G() != null) {
            String macAddress = G().getMacAddress();
            if (!TextUtils.isEmpty(macAddress)) {
                this.f11860f = macAddress;
            }
        }
        if (TextUtils.isEmpty(this.f11860f)) {
            String strH = d0.h();
            if (TextUtils.isEmpty(strH)) {
                return;
            }
            this.f11860f = strH;
        }
    }

    public String h() {
        String str = this.f11857c;
        return str != null ? str : "";
    }

    private Location a(Context context, long j) {
        if (this.C) {
            return this.G;
        }
        this.C = true;
        this.u = j;
        Location locationA = w.a(context);
        if (locationA != null) {
            this.G = locationA;
        }
        return this.G;
    }

    public String e() {
        String str = this.p;
        return str != null ? str : "";
    }

    public String f() {
        if (this.o == null) {
            this.o = String.valueOf(com.tianmu.biz.utils.r.a());
        }
        return this.o;
    }

    public String g() {
        String str = this.f11856b;
        if (str != null) {
            return str;
        }
        if (G() == null) {
            return "";
        }
        String devImei = G().getDevImei();
        if (TextUtils.isEmpty(devImei)) {
            return "";
        }
        this.f11856b = devImei;
        return devImei;
    }

    private void b(Context context, long j) {
        TianmuLocationProvider tianmuLocation;
        TianmuInitConfig config = TianmuSDK.getInstance().getConfig();
        if (config == null) {
            return;
        }
        if (!config.isCanUseLocation()) {
            if (G() == null || (tianmuLocation = G().getTianmuLocation()) == null) {
                return;
            }
            this.k = String.valueOf(tianmuLocation.getLatitude());
            return;
        }
        if (context != null) {
            Location locationA = a(context, j);
            String str = "";
            if (locationA != null) {
                str = locationA.getLatitude() + "";
            }
            this.k = str;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d0.f(this.k);
        }
    }

    public String k() {
        TianmuLocationProvider tianmuLocation;
        if (!TextUtils.isEmpty(this.l)) {
            return this.l;
        }
        if (TianmuSDK.getInstance().getConfig() == null || G() == null || (tianmuLocation = G().getTianmuLocation()) == null) {
            return "";
        }
        String strValueOf = String.valueOf(tianmuLocation.getLongitude());
        this.l = strValueOf;
        return strValueOf;
    }

    public String a() {
        if (!TextUtils.isEmpty(this.p)) {
            return this.p;
        }
        J();
        return e();
    }

    public String c() {
        if (!TextUtils.isEmpty(this.f11864q)) {
            return this.f11864q;
        }
        D();
        return p();
    }

    public String i() {
        String str = this.n;
        return str != null ? str : "";
    }

    public String j() {
        TianmuLocationProvider tianmuLocation;
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        if (TianmuSDK.getInstance().getConfig() == null || G() == null || (tianmuLocation = G().getTianmuLocation()) == null) {
            return "";
        }
        String strValueOf = String.valueOf(tianmuLocation.getLatitude());
        this.k = strValueOf;
        return strValueOf;
    }

    public String d(Context context) {
        if (!TextUtils.isEmpty(this.f11857c)) {
            return this.f11857c;
        }
        k(context);
        return h();
    }
}
