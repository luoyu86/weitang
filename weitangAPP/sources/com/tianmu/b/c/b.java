package com.tianmu.b.c;

import android.content.Context;
import android.content.res.Configuration;
import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.sun.mail.imap.IMAPStore;
import com.taobao.accs.common.Constants;
import com.tianmu.TianmuSDK;
import com.tianmu.apilib.utils.f;
import com.tianmu.apilib.utils.j;
import com.tianmu.biz.utils.c;
import com.tianmu.biz.utils.c0;
import com.tianmu.biz.utils.f0;
import com.tianmu.biz.utils.u0;
import com.tianmu.biz.utils.v0;
import com.tianmu.biz.utils.x;
import com.tianmu.c.i.i;
import com.tianmu.c.n.g;
import com.tianmu.c.n.n;
import com.tianmu.utils.TianmuDisplayUtil;
import com.tianmu.utils.TianmuPackageUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final b f10818d = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f10819a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f10821c;

    private b() {
    }

    private String f() {
        i iVarD = n.D().d();
        return iVarD != null ? iVarD.c() : "";
    }

    public static synchronized b g() {
        return f10818d;
    }

    private String h() {
        String strN = g.I().n();
        return strN == null ? "" : strN;
    }

    private long i() {
        long j = this.f10819a;
        if (j != -1) {
            return j;
        }
        try {
            this.f10819a = Long.parseLong(f0.a("ro.build.date.utc", "0")) * 1000;
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f10819a = 0L;
        }
        return this.f10819a;
    }

    private String j() {
        if (this.f10820b == null) {
            this.f10820b = v0.a();
        }
        return this.f10820b;
    }

    private String k() {
        i iVarD = n.D().d();
        return iVarD != null ? iVarD.d() : "";
    }

    private String l() {
        String strQ = g.I().q();
        return strQ == null ? "" : strQ;
    }

    private String m() {
        if (this.f10821c == null) {
            this.f10821c = c.e(TianmuSDK.getInstance().getContext());
        }
        return this.f10821c;
    }

    public Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("width", TianmuDisplayUtil.getScreenWidth() + "");
        map.put("height", TianmuDisplayUtil.getScreenHeight() + "");
        a(map);
        map.put("oaid", h());
        map.put("vaid", l());
        map.put("elapseTime", String.valueOf(SystemClock.elapsedRealtime()));
        map.put("vivostorever", g().m());
        String strB = c0.l().b();
        if (!TextUtils.isEmpty(strB)) {
            map.put("sysBootMark", strB);
        }
        String strI = c0.l().i();
        if (!TextUtils.isEmpty(strI)) {
            map.put("sysUpdateMark", strI);
        }
        Context context = TianmuSDK.getInstance().getContext();
        if (context != null) {
            map.put("storeVersion", c.a(context));
            map.put("hmsVer", c.b(context));
            map.put("osUiVer", c.a());
            map.put("harmonyOsVer", c.c());
        }
        map.put("ip_v6", c0.l().e());
        return map;
    }

    public Map<String, String> b() {
        return a();
    }

    public String c() {
        return com.tianmu.c.n.i.b().a();
    }

    public int d() {
        try {
            Configuration configuration = TianmuSDK.getInstance().getContext().getResources().getConfiguration();
            if (configuration != null) {
                return 2 == configuration.orientation ? 1 : 0;
            }
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public String e() {
        return j.b().a();
    }

    private void a(Map<String, String> map) {
        Context context = TianmuSDK.getInstance().getContext();
        map.put(DispatchConstants.MACHINE, c());
        map.put("version", TianmuPackageUtil.getAppVersion(context));
        map.put("id", "");
        map.put("os", "1");
        map.put("osversion", g.I().o());
        map.put("appversion", TianmuPackageUtil.getAppVersion(context));
        map.put("androidid", c0.l().a());
        map.put(Constants.KEY_IMEI, c0.l().c());
        map.put("mac", c0.l().h());
        map.put(Constants.KEY_IMSI, c0.l().d());
        String strH = g.I().h(context);
        if (TextUtils.isEmpty(strH)) {
            map.put("network", strH);
        } else {
            map.put("network", strH.toLowerCase());
        }
        map.put("sd", TianmuDisplayUtil.getDensityDpi() + "");
        map.put(Constants.KEY_MODEL, g.I().m());
        map.put(IMAPStore.ID_VENDOR, g.I().r());
        map.put(DispatchConstants.LATITUDE, c0.l().f());
        map.put(DispatchConstants.LONGTITUDE, c0.l().g());
        map.put(AbsServerManager.PACKAGE_QUERY_BINDER, TianmuPackageUtil.getPackageName(context));
        map.put(Constants.KEY_SDK_VERSION, TianmuSDK.getInstance().getSdkVersion());
        map.put("orientation", d() + "");
        String strK = c0.l().k();
        if (!TextUtils.isEmpty(strK)) {
            map.put("wifiname", strK);
        }
        String strJ = c0.l().j();
        if (!TextUtils.isEmpty(strJ)) {
            map.put("wifimac", strJ);
        }
        String strJ2 = j();
        if (!TextUtils.isEmpty(strJ2) && !"unknown".equals(strJ2)) {
            map.put("romversion", strJ2);
        }
        long jI = i();
        if (jI > 0) {
            map.put("comptime", jI + "");
        }
    }

    public String a(String str, String str2) {
        Context context = TianmuSDK.getInstance().getContext();
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashMap map = new HashMap();
        map.put("os", "1");
        map.put("osversion", g.I().o());
        map.put("appversion", TianmuPackageUtil.getAppVersion(context));
        map.put("androidid", c0.l().a());
        map.put(Constants.KEY_IMEI, c0.l().c());
        map.put("mac", c0.l().h());
        map.put(Constants.KEY_IMSI, c0.l().d());
        String strH = g.I().h(context);
        if (TextUtils.isEmpty(strH)) {
            map.put("network", strH);
        } else {
            map.put("network", strH.toLowerCase());
        }
        map.put("sd", TianmuDisplayUtil.getDensityDpi() + "");
        map.put("screenwidth", Integer.valueOf(TianmuDisplayUtil.getScreenWidth()));
        map.put("screenheight", Integer.valueOf(TianmuDisplayUtil.getScreenHeight()));
        map.put(Constants.KEY_MODEL, g.I().m());
        map.put(IMAPStore.ID_VENDOR, g.I().r());
        map.put(DispatchConstants.MACHINE, c());
        map.put("appid", f());
        map.put("ts", Long.valueOf(jCurrentTimeMillis));
        map.put("sign", x.a(jCurrentTimeMillis + k()));
        map.put(DispatchConstants.LATITUDE, c0.l().f());
        map.put(DispatchConstants.LONGTITUDE, c0.l().g());
        map.put(AbsServerManager.PACKAGE_QUERY_BINDER, TianmuPackageUtil.getPackageName(context));
        map.put("adtype", str2);
        map.put(Constants.KEY_SDK_VERSION, TianmuSDK.getInstance().getSdkVersion());
        map.put("orientation", d() + "");
        map.put("oaid", h());
        map.put("vaid", l());
        map.put("elapseTime", Long.valueOf(SystemClock.elapsedRealtime()));
        map.put("vivostorever", g().m());
        map.put("storeVersion", c.a(context));
        map.put("hmsVer", c.b(context));
        map.put("osUiVer", c.a());
        map.put("harmonyOsVer", c.c());
        map.put("ip_v6", c0.l().e());
        String strB = c0.l().b();
        if (!TextUtils.isEmpty(strB)) {
            map.put("sysBootMark", strB);
        }
        String strI = c0.l().i();
        if (!TextUtils.isEmpty(strI)) {
            map.put("sysUpdateMark", strI);
        }
        String strK = c0.l().k();
        if (!TextUtils.isEmpty(strK)) {
            map.put("wifiname", strK);
        }
        String strJ = c0.l().j();
        if (!TextUtils.isEmpty(strJ)) {
            map.put("wifimac", strJ);
        }
        String strJ2 = j();
        if (!TextUtils.isEmpty(strJ2) && !"unknown".equals(strJ2)) {
            map.put("romversion", strJ2);
        }
        long jI = i();
        if (jI > 0) {
            map.put("comptime", Long.valueOf(jI));
        }
        String strA = u0.a(32);
        return str + "?apiVersion=1.0&apiSecret=" + f.a(strA) + "&apiInfo=" + com.tianmu.c.d.a.b(new JSONObject(map).toString(), strA);
    }
}
