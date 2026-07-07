package a.a.p;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f182a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static CookieManager f183b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f184c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static C0001a f185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static SharedPreferences f186e;

    /* JADX INFO: renamed from: a.a.p.a$a, reason: collision with other inner class name */
    public static class C0001a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f191e;

        public C0001a(String str) {
            this.f187a = str;
            String string = a.f186e.getString("networksdk_cookie_monitor", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (!TextUtils.isEmpty(this.f187a) && this.f187a.equals(jSONObject.getString("cookieName"))) {
                    this.f191e = jSONObject.getLong("time");
                    if (System.currentTimeMillis() - this.f191e < 86400000) {
                        this.f188b = jSONObject.getString("cookieText");
                        this.f189c = jSONObject.getString("setCookie");
                        this.f190d = jSONObject.getString(DispatchConstants.DOMAIN);
                    } else {
                        this.f191e = 0L;
                        a.f186e.edit().remove("networksdk_cookie_monitor").apply();
                    }
                }
            } catch (JSONException e2) {
                ALog.e("anet.CookieManager", "cookie json parse error.", null, e2, new Object[0]);
            }
        }

        public void a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cookieName", this.f187a);
                jSONObject.put("cookieText", this.f188b);
                jSONObject.put("setCookie", this.f189c);
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f191e = jCurrentTimeMillis;
                jSONObject.put("time", jCurrentTimeMillis);
                jSONObject.put(DispatchConstants.DOMAIN, this.f190d);
                a.f186e.edit().putString("networksdk_cookie_monitor", jSONObject.toString()).apply();
            } catch (Exception e2) {
                ALog.e("anet.CookieManager", "cookie json save error.", null, e2, new Object[0]);
            }
        }
    }

    public static void c(String str) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new c(str));
    }

    public static void d(String str, String str2) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new d(str, str2));
    }

    public static boolean g() {
        if (!f182a && a.a.r.a.getContext() != null) {
            setup(a.a.r.a.getContext());
        }
        return f182a;
    }

    public static synchronized String getCookie(String str) {
        String cookie = null;
        if (!a.a.o.b.isCookieEnable()) {
            return null;
        }
        if (!g() || !f184c) {
            return null;
        }
        try {
            cookie = f183b.getCookie(str);
        } catch (Throwable th) {
            ALog.e("anet.CookieManager", "get cookie failed. url=" + str, null, th, new Object[0]);
        }
        d(str, cookie);
        return cookie;
    }

    public static void h() {
        ThreadPoolExecutorFactory.submitCookieMonitor(new b());
    }

    public static String i() {
        SharedPreferences sharedPreferences = f186e;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("networksdk_target_cookie_name", null);
    }

    public static synchronized void setCookie(String str, String str2) {
        if (a.a.o.b.isCookieEnable()) {
            if (g() && f184c) {
                try {
                    f183b.setCookie(str, str2);
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.getInstance().sync();
                    } else {
                        f183b.flush();
                    }
                } catch (Throwable th) {
                    ALog.e("anet.CookieManager", "set cookie failed.", null, th, AgooConstants.OPEN_URL, str, "cookies", str2);
                }
            }
        }
    }

    public static void setTargetMonitorCookieName(String str) {
        SharedPreferences sharedPreferences;
        if (str == null || (sharedPreferences = f186e) == null) {
            return;
        }
        sharedPreferences.edit().putString("networksdk_target_cookie_name", str).apply();
    }

    public static synchronized void setup(Context context) {
        if (a.a.o.b.isCookieEnable()) {
            if (f182a) {
                return;
            }
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i2 = Build.VERSION.SDK_INT;
                if (i2 < 21) {
                    CookieSyncManager.createInstance(context);
                }
                CookieManager cookieManager = CookieManager.getInstance();
                f183b = cookieManager;
                cookieManager.setAcceptCookie(true);
                if (i2 < 21) {
                    f183b.removeExpiredCookie();
                }
                f186e = PreferenceManager.getDefaultSharedPreferences(context);
                h();
                ALog.e("anet.CookieManager", "CookieManager setup.", null, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            } catch (Throwable th) {
                f184c = false;
                ALog.e("anet.CookieManager", "Cookie Manager setup failed!!!", null, th, new Object[0]);
            }
            f182a = true;
        }
    }

    public static void setCookie(String str, Map<String, List<String>> map) {
        if (!a.a.o.b.isCookieEnable() || str == null || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null && (key.equalsIgnoreCase(HttpConstant.SET_COOKIE) || key.equalsIgnoreCase(HttpConstant.SET_COOKIE2))) {
                    for (String str2 : entry.getValue()) {
                        setCookie(str, str2);
                        c(str2);
                    }
                }
            }
        } catch (Exception e2) {
            ALog.e("anet.CookieManager", "set cookie failed", null, e2, AgooConstants.OPEN_URL, str, "\nheaders", map);
        }
    }
}
