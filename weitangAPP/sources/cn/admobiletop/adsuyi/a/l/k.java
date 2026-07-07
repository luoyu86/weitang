package cn.admobiletop.adsuyi.a.l;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.config.CustomDeviceInfoController;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.sun.mail.pop3.POP3Message;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static k f3401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f3405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f3409i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public Location o;
    public long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f3410q;
    public long r;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public ADSuyiInitConfig w;
    public CustomDeviceInfoController x;

    public static k d() {
        if (f3401a == null) {
            synchronized (k.class) {
                if (f3401a == null) {
                    f3401a = new k();
                }
            }
        }
        return f3401a;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f3406f)) {
            this.f3406f = b.b().a();
        }
        return this.f3406f;
    }

    public String b(Context context) {
        if (!TextUtils.isEmpty(this.f3402b)) {
            return this.f3402b;
        }
        j(context);
        return b();
    }

    public String c(Context context) {
        if (!TextUtils.isEmpty(this.f3403c)) {
            return this.f3403c;
        }
        k(context);
        return c();
    }

    public String e(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(this.f3407g)) {
            if (jCurrentTimeMillis - this.f3410q <= TTAdConstant.AD_MAX_EVENT_TIME) {
                return this.f3407g;
            }
            m();
        }
        c(context, jCurrentTimeMillis);
        return f();
    }

    public String f() {
        String str = this.f3407g;
        if (str != null) {
            return str;
        }
        if (o() == null) {
            return "";
        }
        String macAddress = o().getMacAddress();
        if (TextUtils.isEmpty(macAddress)) {
            return "";
        }
        this.f3407g = macAddress;
        return macAddress;
    }

    public String g() {
        if (this.k == null) {
            this.k = Build.MODEL;
        }
        return this.k.toUpperCase();
    }

    public String h(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f3408h == null || jCurrentTimeMillis - this.p > TTAdConstant.AD_MAX_EVENT_TIME) {
            this.p = jCurrentTimeMillis;
            String strA = cn.admobiletop.adsuyi.a.m.l.a(context);
            if (POP3Message.UNKNOWN.equals(strA)) {
                strA = "";
            }
            this.f3408h = strA;
        }
        return this.f3408h;
    }

    public String i() {
        if (this.f3409i == null) {
            this.f3409i = Build.VERSION.RELEASE;
        }
        return this.f3409i;
    }

    public String j() {
        if (!TextUtils.isEmpty(this.f3405e)) {
            return this.f3405e;
        }
        if (o() == null || TextUtils.isEmpty(o().getVaid())) {
            if (TextUtils.isEmpty(this.f3405e)) {
                this.f3405e = b.b().d();
            }
            return this.f3405e;
        }
        String vaid = o().getVaid();
        this.f3405e = vaid;
        return vaid;
    }

    public String k() {
        if (this.j == null) {
            this.j = Build.BRAND;
        }
        return this.j.toUpperCase();
    }

    public void l() {
        this.v = false;
    }

    public void m() {
        this.u = false;
    }

    public final ADSuyiInitConfig n() {
        if (this.w == null) {
            this.w = ADSuyiSdk.getInstance().getConfig();
        }
        return this.w;
    }

    public final CustomDeviceInfoController o() {
        try {
            if (this.x == null) {
                this.x = n().getCustomController();
            }
        } catch (Exception unused) {
        }
        return this.x;
    }

    public String a(Context context) {
        if (context != null && this.n == null) {
            this.n = "PHONE";
            try {
                if ((context.getResources().getConfiguration().screenLayout & 15) >= 3) {
                    this.n = "PAD";
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.n;
    }

    public String g(Context context) {
        if (this.m == null && this.o != null) {
            this.m = this.o.getLongitude() + "";
        }
        return this.m;
    }

    public final void k(Context context) {
        if (this.s) {
            return;
        }
        this.s = true;
        if (n() != null && n().isCanUsePhoneState()) {
            String strB = cn.admobiletop.adsuyi.a.m.f.b(context);
            this.f3403c = strB;
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            r.b(this.f3403c);
        }
    }

    public String b() {
        String str = this.f3402b;
        if (str != null) {
            return str;
        }
        if (o() == null) {
            return "";
        }
        String androidId = o().getAndroidId();
        if (TextUtils.isEmpty(androidId)) {
            return "";
        }
        this.f3402b = androidId;
        return androidId;
    }

    public String c() {
        String str = this.f3403c;
        if (str != null) {
            return str;
        }
        if (o() == null) {
            return "";
        }
        String imei = o().getImei();
        if (TextUtils.isEmpty(imei)) {
            return "";
        }
        this.f3403c = imei;
        return imei;
    }

    public String f(Context context) {
        if (this.l == null && this.o != null) {
            this.l = this.o.getLatitude() + "";
        }
        return this.l;
    }

    public Location d(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Location location = this.o;
        if (location != null) {
            if (jCurrentTimeMillis - this.r <= TTAdConstant.AD_MAX_EVENT_TIME) {
                return location;
            }
            l();
        }
        a(context, jCurrentTimeMillis);
        return e();
    }

    public String h() {
        if (!TextUtils.isEmpty(this.f3404d)) {
            return this.f3404d;
        }
        if (o() != null && !TextUtils.isEmpty(o().getOaid())) {
            String oaid = o().getOaid();
            this.f3404d = oaid;
            if (!TextUtils.isEmpty(oaid)) {
                ADSuyiLogUtil.d("getCustomOAID : " + this.f3404d);
                return this.f3404d;
            }
        }
        if (!TextUtils.isEmpty(this.f3404d)) {
            return "";
        }
        String strC = b.b().c();
        this.f3404d = strC;
        if (!TextUtils.isEmpty(strC)) {
            ADSuyiLogUtil.d("getADSuyiID : " + this.f3404d);
        }
        return this.f3404d;
    }

    public Location e() {
        Location location = this.o;
        if (location != null) {
            return location;
        }
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config == null) {
            return null;
        }
        if (config.getCustomController() != null) {
            this.o = config.getCustomController().getLocation();
        }
        return this.o;
    }

    public final void j(Context context) {
        if (this.t) {
            return;
        }
        this.t = true;
        if (n() != null && n().isCanUsePhoneState()) {
            String strA = cn.admobiletop.adsuyi.a.m.f.a(context);
            this.f3402b = strA;
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            r.a(this.f3402b);
        }
    }

    public void a(Context context, long j) {
        if (this.v) {
            return;
        }
        this.v = true;
        this.r = j;
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config == null) {
            return;
        }
        if (config.isCanUseLocation()) {
            this.o = cn.admobiletop.adsuyi.a.m.i.a(context);
        } else if (config.getCustomController() != null) {
            this.o = config.getCustomController().getLocation();
        }
    }

    public final void c(Context context, long j) {
        if (this.u) {
            return;
        }
        this.f3410q = j;
        this.u = true;
        if (n() != null && n().isCanUseWifiState()) {
            String strC = cn.admobiletop.adsuyi.a.m.f.c(context);
            this.f3407g = strC;
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            r.c(this.f3407g);
        }
    }
}
