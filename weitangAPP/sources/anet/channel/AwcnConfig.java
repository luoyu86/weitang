package anet.channel;

import android.text.TextUtils;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import anet.channel.util.ALog;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AwcnConfig {
    public static final String HTTP3_ENABLE = "HTTP3_ENABLE";
    public static final String NEXT_LAUNCH_FORBID = "NEXT_LAUNCH_FORBID";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f293a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f294b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f295c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f296d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f297e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f298f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile long f299g = 43200000;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f300h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f301i = true;
    private static boolean j = true;
    private static boolean k = false;
    private static volatile boolean l = false;
    private static volatile boolean m = true;
    private static volatile boolean n = false;
    private static volatile int o = 10000;
    private static volatile boolean p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static volatile boolean f302q = true;
    private static volatile int r = -1;
    private static volatile boolean s = true;
    private static volatile boolean t = true;
    private static volatile boolean u = false;
    private static volatile boolean v = true;
    private static volatile CopyOnWriteArrayList<String> w = null;
    private static volatile boolean x = true;
    private static volatile boolean y = true;

    public static int getAccsReconnectionDelayPeriod() {
        return o;
    }

    public static long getIpv6BlackListTtl() {
        return f299g;
    }

    public static int getXquicCongControl() {
        return r;
    }

    public static boolean isAccsSessionCreateForbiddenInBg() {
        return f293a;
    }

    public static boolean isAllowHttpDnsNotify(String str) {
        if (w == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return w.contains(str);
    }

    public static boolean isAppLifeCycleListenerEnable() {
        return j;
    }

    public static boolean isAsyncLoadStrategyEnable() {
        return k;
    }

    public static boolean isCarrierInfoEnable() {
        return y;
    }

    public static boolean isCookieHeaderRedundantFix() {
        return t;
    }

    public static boolean isHorseRaceEnable() {
        return f295c;
    }

    public static boolean isHttp3Enable() {
        return p;
    }

    public static boolean isHttp3OrangeEnable() {
        return f302q;
    }

    public static boolean isHttpsSniEnable() {
        return f294b;
    }

    public static boolean isIdleSessionCloseEnable() {
        return f298f;
    }

    public static boolean isIpStackDetectByUdpConnect() {
        return s;
    }

    public static boolean isIpv6BlackListEnable() {
        return f301i;
    }

    public static boolean isIpv6Enable() {
        return f300h;
    }

    public static boolean isNetworkDetectEnable() {
        return n;
    }

    public static boolean isPing6Enable() {
        return m;
    }

    public static boolean isQuicEnable() {
        return f297e;
    }

    public static boolean isSendConnectInfoByBroadcast() {
        return u;
    }

    public static boolean isSendConnectInfoByService() {
        return v;
    }

    public static boolean isTbNextLaunch() {
        return l;
    }

    public static boolean isTnetHeaderCacheEnable() {
        return f296d;
    }

    public static boolean isWifiInfoEnable() {
        return x;
    }

    public static void registerPresetSessions(String str) {
        if (GlobalAppRuntimeInfo.isTargetProcess() && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.getString("host");
                    if (!anet.channel.strategy.utils.c.c(string)) {
                        return;
                    }
                    StrategyTemplate.getInstance().registerConnProtocol(string, ConnProtocol.valueOf(jSONObject.getString("protocol"), jSONObject.getString("rtt"), jSONObject.getString("publicKey")));
                    if (jSONObject.getBoolean("isKeepAlive")) {
                        SessionCenter.getInstance().registerSessionInfo(SessionInfo.create(string, true, false, null, null, null));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void setAccsReconnectionDelayPeriod(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 10000) {
            i2 = 10000;
        }
        o = i2;
    }

    public static void setAccsSessionCreateForbiddenInBg(boolean z) {
        f293a = z;
    }

    public static void setAppLifeCycleListenerEnable(boolean z) {
        j = z;
    }

    public static void setAsyncLoadStrategyEnable(boolean z) {
        k = z;
    }

    public static void setCarrierInfoEnable(boolean z) {
        y = z;
    }

    public static void setCookieHeaderRedundantFix(boolean z) {
        t = z;
    }

    public static void setHorseRaceEnable(boolean z) {
        f295c = z;
    }

    public static void setHttp3Enable(boolean z) {
        p = z;
        ALog.e("awcn.AwcnConfig", "[setHttp3Enable]", null, "enable", Boolean.valueOf(z));
    }

    public static void setHttp3OrangeEnable(boolean z) {
        f302q = z;
    }

    public static void setHttpDnsNotifyWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string = jSONArray.getString(i2);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            w = copyOnWriteArrayList;
        } catch (Exception e2) {
            ALog.e("awcn.AwcnConfig", "[setHttpDnsNotifyWhiteList] error", null, e2, new Object[0]);
        }
    }

    public static void setHttpsSniEnable(boolean z) {
        f294b = z;
    }

    public static void setIdleSessionCloseEnable(boolean z) {
        f298f = z;
    }

    public static void setIpStackDetectByUdpConnect(boolean z) {
        s = z;
    }

    public static void setIpv6BlackListEnable(boolean z) {
        f301i = z;
    }

    public static void setIpv6BlackListTtl(long j2) {
        f299g = j2;
    }

    public static void setIpv6Enable(boolean z) {
        f300h = z;
    }

    public static void setNetworkDetectEnable(boolean z) {
        n = z;
    }

    public static void setPing6Enable(boolean z) {
        m = z;
    }

    public static void setQuicEnable(boolean z) {
        f297e = z;
    }

    public static void setSendConnectInfoByBroadcast(boolean z) {
        u = z;
    }

    public static void setSendConnectInfoByService(boolean z) {
        v = z;
    }

    public static void setTbNextLaunch(boolean z) {
        l = z;
    }

    public static void setTnetHeaderCacheEnable(boolean z) {
        f296d = z;
    }

    public static void setWifiInfoEnable(boolean z) {
        x = z;
    }

    public static void setXquicCongControl(int i2) {
        if (i2 < 0) {
            return;
        }
        r = i2;
    }
}
