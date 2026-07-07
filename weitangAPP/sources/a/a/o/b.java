package a.a.o;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.utils.c;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f172a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f173b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile boolean f174c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile int f175d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f176e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f177f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f178g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile long f179h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static volatile boolean f180i = false;
    public static volatile ConcurrentHashMap<String, List<String>> j;
    public static volatile CopyOnWriteArrayList<String> k;
    public static final List<String> l = new ArrayList();
    public static volatile int m = 10000;
    public static volatile boolean n = true;
    public static volatile boolean o = false;
    public static volatile int p = 60000;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile CopyOnWriteArrayList<String> f181q = null;
    public static volatile ConcurrentHashMap<String, List<String>> r = null;
    public static volatile boolean s = true;
    public static volatile boolean t = false;
    public static volatile boolean u = false;
    public static volatile boolean v = true;
    public static volatile boolean w = true;
    public static volatile a x;

    public static void enableNetworkSdkOptimizeTest(boolean z) {
        if (!z) {
            setGetSessionAsyncEnable(false);
            ThreadPoolExecutorFactory.setNormalExecutorPoolSize(6);
        } else {
            setGetSessionAsyncEnable(true);
            ThreadPoolExecutorFactory.setNormalExecutorPoolSize(16);
            AwcnConfig.registerPresetSessions("[{\"host\":\"trade-acs.m.taobao.com\", \"protocol\":\"http2\", \"rtt\":\"0rtt\", \"publicKey\": \"acs\", \"isKeepAlive\":true}]");
        }
    }

    public static int getBgForbidRequestThreshold() {
        return p;
    }

    public static int getRequestStatisticSampleRate() {
        return m;
    }

    public static int getServiceBindWaitTime() {
        return f175d;
    }

    public static void init() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(a.a.r.a.getContext());
        f179h = defaultSharedPreferences.getLong("Cache.Flag", 0L);
        u = defaultSharedPreferences.getBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", false);
        v = defaultSharedPreferences.getBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", true);
    }

    public static boolean isAllowHttpIpRetry() {
        return f176e && f178g;
    }

    public static boolean isAllowSpdyWhenBindServiceFailed() {
        return v;
    }

    public static boolean isBgRequestForbidden() {
        return f180i;
    }

    public static boolean isBindServiceOptimize() {
        return t;
    }

    public static boolean isBizInWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = k;
        if (k == null) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isChannelLocalInstanceEnable() {
        return u;
    }

    public static boolean isCookieEnable() {
        return w;
    }

    public static boolean isGetSessionAsyncEnable() {
        return o;
    }

    public static boolean isHttpCacheEnable() {
        return f177f;
    }

    public static boolean isHttpSessionEnable() {
        return f176e;
    }

    public static boolean isRemoteNetworkServiceEnable() {
        return f174c;
    }

    public static boolean isRequestDelayRetryForNoNetwork() {
        return s;
    }

    public static boolean isRequestInMonitorList(RequestStatistic requestStatistic) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (requestStatistic == null || (copyOnWriteArrayList = f181q) == null || TextUtils.isEmpty(requestStatistic.host)) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (requestStatistic.host.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isResponseBufferEnable() {
        return n;
    }

    public static boolean isSSLEnabled() {
        return f172a;
    }

    public static boolean isSpdyEnabled() {
        return f173b;
    }

    public static boolean isUrlInDegradeList(HttpUrl httpUrl) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (httpUrl == null || (concurrentHashMap = r) == null || (list = concurrentHashMap.get(httpUrl.host())) == null) {
            return false;
        }
        if (list == l) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (httpUrl.path().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlInWhiteList(HttpUrl httpUrl) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (httpUrl == null || (concurrentHashMap = j) == null || (list = concurrentHashMap.get(httpUrl.host())) == null) {
            return false;
        }
        if (list == l) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (httpUrl.path().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void setAllowHttpIpRetry(boolean z) {
        f178g = z;
    }

    public static void setAllowSpdyWhenBindServiceFailed(boolean z) {
        v = z;
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(a.a.r.a.getContext()).edit();
        editorEdit.putBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", v);
        editorEdit.apply();
    }

    public static void setAmdcPresetHosts(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i2 = 0; i2 < length; i2++) {
                    String string = jSONArray.getString(i2);
                    if (c.c(string)) {
                        arrayList.add(string);
                    }
                }
                HttpDispatcher.getInstance().addHosts(arrayList);
            } catch (JSONException e2) {
                ALog.e("anet.NetworkConfigCenter", "parse hosts failed", null, e2, new Object[0]);
            }
        }
    }

    public static void setBgForbidRequestThreshold(int i2) {
        p = i2;
    }

    public static void setBgRequestForbidden(boolean z) {
        f180i = z;
    }

    public static void setBindServiceOptimize(boolean z) {
        t = z;
    }

    public static void setCacheFlag(long j2) {
        if (j2 != f179h) {
            ALog.i("anet.NetworkConfigCenter", "set cache flag", null, "old", Long.valueOf(f179h), "new", Long.valueOf(j2));
            f179h = j2;
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(a.a.r.a.getContext()).edit();
            editorEdit.putLong("Cache.Flag", f179h);
            editorEdit.apply();
            a.a.n.b.clearAllCache();
        }
    }

    public static void setChannelLocalInstanceEnable(boolean z) {
        u = z;
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(a.a.r.a.getContext()).edit();
        editorEdit.putBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", u);
        editorEdit.apply();
    }

    public static void setCookieEnable(boolean z) {
        w = z;
    }

    public static void setDegradeRequestList(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "setDegradeRequestList", null, "Degrade List", str);
        }
        if (TextUtils.isEmpty(str)) {
            r = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                try {
                    if ("*".equals(obj)) {
                        concurrentHashMap.put(next, l);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        r = concurrentHashMap;
    }

    public static void setGetSessionAsyncEnable(boolean z) {
        o = z;
    }

    public static void setHttpCacheEnable(boolean z) {
        f177f = z;
    }

    public static void setHttpSessionEnable(boolean z) {
        f176e = z;
    }

    @Deprecated
    public static void setHttpsValidationEnabled(boolean z) {
    }

    public static void setMonitorRequestList(String str) {
        if (TextUtils.isEmpty(str)) {
            f181q = null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("host");
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (c.c(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f181q = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse hosts failed", null, e2, new Object[0]);
        }
    }

    public static void setRemoteConfig(a aVar) {
        if (x != null) {
            x.unRegister();
        }
        if (aVar != null) {
            aVar.register();
        }
        x = aVar;
    }

    public static void setRemoteNetworkServiceEnable(boolean z) {
        f174c = z;
    }

    public static void setRequestDelayRetryForNoNetwork(boolean z) {
        s = z;
    }

    public static void setRequestStatisticSampleRate(int i2) {
        m = i2;
    }

    public static void setResponseBufferEnable(boolean z) {
        n = z;
    }

    public static void setSSLEnabled(boolean z) {
        ALog.i("anet.NetworkConfigCenter", "[setSSLEnabled]", null, "enable", Boolean.valueOf(z));
        f172a = z;
    }

    public static void setServiceBindWaitTime(int i2) {
        f175d = i2;
    }

    public static void setSpdyEnabled(boolean z) {
        ALog.i("anet.NetworkConfigCenter", "[setSpdyEnabled]", null, "enable", Boolean.valueOf(z));
        f173b = z;
    }

    public static void updateBizWhiteList(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateRequestWhiteList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            k = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i2 = 0; i2 < length; i2++) {
                String string = jSONArray.getString(i2);
                if (!string.isEmpty()) {
                    copyOnWriteArrayList.add(string);
                }
            }
            k = copyOnWriteArrayList;
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse bizId failed", null, e2, new Object[0]);
        }
    }

    public static void updateWhiteListMap(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateWhiteUrlList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            j = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                try {
                    if ("*".equals(obj)) {
                        concurrentHashMap.put(next, l);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i2 = 0; i2 < length; i2++) {
                            Object obj2 = jSONArray.get(i2);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e2) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e2, new Object[0]);
        }
        j = concurrentHashMap;
    }
}
