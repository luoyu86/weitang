package anet.channel.e;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.IStrategyFilter;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f438b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static SharedPreferences f442f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AtomicBoolean f439c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f440d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f441e = 21600000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static IStrategyFilter f443g = new anet.channel.e.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static AtomicInteger f444h = new AtomicInteger(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static IStrategyListener f445i = new c();
    private static NetworkStatusHelper.INetworkStatusChangeListener j = new d();

    /* JADX INFO: renamed from: anet.channel.e.a$a, reason: collision with other inner class name */
    public static class C0007a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f447b;

        private C0007a() {
        }

        public /* synthetic */ C0007a(anet.channel.e.b bVar) {
            this();
        }
    }

    public static boolean b() {
        b bVar = f437a;
        if (bVar != null) {
            return bVar.b(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()));
        }
        return false;
    }

    public static void a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (!AwcnConfig.isHttp3Enable()) {
            ALog.i("awcn.Http3ConnDetector", "startDetect", null, "http3 global config close.");
            return;
        }
        if (f440d.get()) {
            ALog.e("awcn.Http3ConnDetector", "tnet exception.", null, new Object[0]);
            return;
        }
        if (NetworkStatusHelper.isConnected()) {
            if (TextUtils.isEmpty(f438b)) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "host is null");
                return;
            }
            List<IConnStrategy> connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(f438b, f443g);
            if (connStrategyListByHost.isEmpty()) {
                ALog.e("awcn.Http3ConnDetector", "startDetect", null, "http3 strategy is null.");
                return;
            }
            if (f439c.compareAndSet(false, true)) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).InitializeSecurityStuff();
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3.", null, "cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                } catch (Throwable th) {
                    ALog.e("awcn.Http3ConnDetector", "tnet init http3 error.", null, th, new Object[0]);
                    f440d.set(true);
                    return;
                }
            }
            if (f437a == null) {
                f437a = new b();
            }
            if (f437a.a(NetworkStatusHelper.getUniqueId(networkStatus))) {
                ThreadPoolExecutorFactory.submitDetectTask(new e(connStrategyListByHost, networkStatus));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IConnStrategy b(IConnStrategy iConnStrategy) {
        return new g(iConnStrategy);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, C0007a> f448a = new ConcurrentHashMap();

        public b() {
            a();
        }

        private void a() {
            anet.channel.e.b bVar = null;
            String string = a.f442f.getString("networksdk_http3_history_records", null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.get(i2);
                    C0007a c0007a = new C0007a(bVar);
                    String string2 = jSONObject.getString("networkUniqueId");
                    c0007a.f446a = jSONObject.getLong("time");
                    c0007a.f447b = jSONObject.getBoolean("enable");
                    if (a(c0007a.f446a)) {
                        synchronized (this.f448a) {
                            this.f448a.put(string2, c0007a);
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }

        public boolean b(String str) {
            synchronized (this.f448a) {
                C0007a c0007a = this.f448a.get(str);
                if (c0007a == null) {
                    return false;
                }
                return c0007a.f447b;
            }
        }

        public boolean a(String str) {
            synchronized (this.f448a) {
                C0007a c0007a = this.f448a.get(str);
                boolean z = true;
                if (c0007a == null) {
                    return true;
                }
                if (a(c0007a.f446a)) {
                    z = false;
                }
                return z;
            }
        }

        private boolean a(long j) {
            return System.currentTimeMillis() - j < a.f441e;
        }

        public void a(String str, boolean z) {
            C0007a c0007a = new C0007a(null);
            c0007a.f447b = z;
            c0007a.f446a = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            synchronized (this.f448a) {
                this.f448a.put(str, c0007a);
                for (Map.Entry<String, C0007a> entry : this.f448a.entrySet()) {
                    String key = entry.getKey();
                    C0007a value = entry.getValue();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkUniqueId", key);
                        jSONObject.put("time", value.f446a);
                        jSONObject.put("enable", value.f447b);
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            a.f442f.edit().putString("networksdk_http3_history_records", jSONArray.toString()).apply();
        }
    }

    public static void a() {
        try {
            ALog.e("awcn.Http3ConnDetector", "registerListener", null, "http3Enable", Boolean.valueOf(AwcnConfig.isHttp3Enable()));
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(GlobalAppRuntimeInfo.getContext());
            f442f = defaultSharedPreferences;
            f438b = defaultSharedPreferences.getString("http3_detector_host", "");
            a(NetworkStatusHelper.getStatus());
            NetworkStatusHelper.addStatusChangeListener(j);
            StrategyCenter.getInstance().registerListener(f445i);
        } catch (Exception e2) {
            ALog.e("awcn.Http3ConnDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    public static void a(long j2) {
        if (j2 < 0) {
            return;
        }
        f441e = j2;
    }

    public static void a(boolean z) {
        b bVar = f437a;
        if (bVar != null) {
            bVar.a(NetworkStatusHelper.getUniqueId(NetworkStatusHelper.getStatus()), z);
        }
    }
}
