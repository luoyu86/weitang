package cn.admobiletop.adsuyi.a.l;

import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdmobileAdapterIniter;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiTianmuAdapterIniter;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdType;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static j f3393a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONArray f3395c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f3397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3399g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f3394b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3396d = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f3400h = new i(this);

    public static j a() {
        if (f3393a == null) {
            synchronized (j.class) {
                if (f3393a == null) {
                    f3393a = new j();
                }
            }
        }
        return f3393a;
    }

    public void b(int i2) {
        this.f3399g = i2;
    }

    public void d(JSONArray jSONArray, double d2) {
        this.f3395c = jSONArray;
        this.f3398f = (long) (d2 * 1000.0d);
        e(false);
    }

    public final void e(boolean z) {
        if (!z) {
            this.f3396d++;
            h();
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f3397e > this.f3398f) {
            this.f3397e = jCurrentTimeMillis;
            this.f3396d++;
            h();
        }
    }

    public final boolean g(String str, boolean z) {
        if (cn.admobiletop.adsuyi.a.m.o.b(this.f3399g)) {
            String str2 = "other";
            if (ADSuyiAdType.TYPE_SPLASH.equals(str)) {
                str2 = "startup";
            } else if ("banner".equals(str)) {
                str2 = "banner";
            } else if (!"other".equals(str)) {
                str2 = "flow";
            }
            ADSuyiAdmobileAdapterIniter aDSuyiAdmobileAdapterIniterI = h.l().I();
            ADSuyiPlatform aDSuyiPlatformC = h.l().c(ADSuyiPlatform.PLAFORM_ADMOBILE);
            if (aDSuyiAdmobileAdapterIniterI != null && aDSuyiPlatformC != null) {
                if (z) {
                    ADSuyiLogUtil.ti("res_nsend", "proc 0x00010");
                } else {
                    ADSuyiLogUtil.ti("res_nsend", "proc 0x0001");
                }
                boolean zApiLoad = aDSuyiAdmobileAdapterIniterI.apiLoad(str2);
                if (!z && zApiLoad) {
                    e(true);
                }
                return zApiLoad;
            }
            if (!cn.admobiletop.adsuyi.a.m.b.a() || z) {
                return false;
            }
            ADSuyiTianmuAdapterIniter aDSuyiTianmuAdapterIniterJ = h.l().J();
            ADSuyiPlatform aDSuyiPlatformC2 = h.l().c("tianmu");
            if (aDSuyiTianmuAdapterIniterJ != null && aDSuyiPlatformC2 != null) {
                return aDSuyiTianmuAdapterIniterJ.apiLoad(str2);
            }
        }
        return false;
    }

    public final void h() {
        int i2;
        i();
        JSONArray jSONArray = this.f3395c;
        if (jSONArray == null || (i2 = this.f3396d) < 0 || i2 >= jSONArray.length() || this.f3394b == null || this.f3400h == null) {
            return;
        }
        try {
            this.f3394b.postDelayed(this.f3400h, (long) (this.f3395c.optDouble(this.f3396d) * 1000.0d));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void i() {
        Runnable runnable;
        Handler handler = this.f3394b;
        if (handler == null || (runnable = this.f3400h) == null) {
            return;
        }
        try {
            handler.removeCallbacks(runnable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public boolean a(String str) {
        return g(str, false);
    }
}
