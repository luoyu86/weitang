package anet.channel;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.LruCache;
import anet.channel.Config;
import anet.channel.detect.n;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import java.net.ConnectException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* JADX INFO: loaded from: classes.dex */
public class SessionCenter {
    public static final String TAG = "awcn.SessionCenter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<Config, SessionCenter> f333a = new HashMap();
    private static boolean j = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f334b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f335c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Config f336d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f337e = new e();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LruCache<String, SessionRequest> f338f = new LruCache<>(32);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f339g = new c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AccsSessionManager f340h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f341i;

    private SessionCenter(Config config) {
        a aVar = new a(this, null);
        this.f341i = aVar;
        this.f334b = GlobalAppRuntimeInfo.getContext();
        this.f336d = config;
        this.f335c = config.getAppkey();
        aVar.a();
        this.f340h = new AccsSessionManager(this);
        if (config.getAppkey().equals("[default]")) {
            return;
        }
        AmdcRuntimeInfo.setSign(new d(this, config.getAppkey(), config.getSecurity()));
    }

    public static void checkAndStartAccsSession() {
        Iterator<SessionCenter> it = f333a.values().iterator();
        while (it.hasNext()) {
            it.next().f340h.checkAndStartSession();
        }
    }

    public static synchronized SessionCenter getInstance(String str) {
        Config configByTag;
        configByTag = Config.getConfigByTag(str);
        if (configByTag == null) {
            throw new RuntimeException("tag not exist!");
        }
        return getInstance(configByTag);
    }

    public static synchronized void init(Context context) {
        if (context == null) {
            ALog.e(TAG, "context is null!", null, new Object[0]);
            throw new NullPointerException("init failed. context is null");
        }
        GlobalAppRuntimeInfo.setContext(context.getApplicationContext());
        if (!j) {
            Map<Config, SessionCenter> map = f333a;
            Config config = Config.DEFAULT_CONFIG;
            map.put(config, new SessionCenter(config));
            AppLifecycle.initialize();
            NetworkStatusHelper.startListener(context);
            if (!AwcnConfig.isTbNextLaunch()) {
                StrategyCenter.getInstance().initialize(GlobalAppRuntimeInfo.getContext());
            }
            if (GlobalAppRuntimeInfo.isTargetProcess()) {
                n.a();
                anet.channel.e.a.a();
            }
            j = true;
        }
    }

    public static synchronized void switchEnvironment(ENV env) {
        try {
            if (GlobalAppRuntimeInfo.getEnv() != env) {
                ALog.i(TAG, "switch env", null, "old", GlobalAppRuntimeInfo.getEnv(), "new", env);
                GlobalAppRuntimeInfo.setEnv(env);
                StrategyCenter.getInstance().switchEnv();
                SpdyAgent.getInstance(GlobalAppRuntimeInfo.getContext(), SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION).switchAccsServer(env == ENV.TEST ? 0 : 1);
            }
            Iterator<Map.Entry<Config, SessionCenter>> it = f333a.entrySet().iterator();
            while (it.hasNext()) {
                SessionCenter value = it.next().getValue();
                if (value.f336d.getEnv() != env) {
                    ALog.i(TAG, "remove instance", value.f335c, "ENVIRONMENT", value.f336d.getEnv());
                    value.f340h.forceCloseSession(false);
                    value.f341i.b();
                    it.remove();
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "switch env error.", null, th, new Object[0]);
        }
    }

    public void asyncGet(HttpUrl httpUrl, int i2, long j2, SessionGetCallback sessionGetCallback) {
        Objects.requireNonNull(sessionGetCallback, "cb is null");
        if (j2 <= 0) {
            throw new InvalidParameterException("timeout must > 0");
        }
        try {
            b(httpUrl, i2, j2, sessionGetCallback);
        } catch (Exception unused) {
            sessionGetCallback.onSessionGetFail();
        }
    }

    public void b(HttpUrl httpUrl, int i2, long j2, SessionGetCallback sessionGetCallback) throws Exception {
        SessionInfo sessionInfoB;
        if (!j) {
            ALog.e(TAG, "getInternal not inited!", this.f335c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        }
        if (httpUrl == null) {
            throw new InvalidParameterException("httpUrl is null");
        }
        if (sessionGetCallback == null) {
            throw new InvalidParameterException("sessionGetCallback is null");
        }
        String str = this.f335c;
        Object[] objArr = new Object[6];
        objArr[0] = "u";
        objArr[1] = httpUrl.urlString();
        objArr[2] = "sessionType";
        objArr[3] = i2 == anet.channel.entity.c.f462a ? "LongLink" : "ShortLink";
        objArr[4] = com.alipay.sdk.m.m.a.h0;
        objArr[5] = Long.valueOf(j2);
        ALog.d(TAG, "getInternal", str, objArr);
        SessionRequest sessionRequestA = a(httpUrl);
        Session sessionA = this.f337e.a(sessionRequestA, i2);
        if (sessionA != null) {
            ALog.d(TAG, "get internal hit cache session", this.f335c, "session", sessionA);
            sessionGetCallback.onSessionGetSuccess(sessionA);
            return;
        }
        if (this.f336d == Config.DEFAULT_CONFIG && i2 != anet.channel.entity.c.f463b) {
            sessionGetCallback.onSessionGetFail();
            return;
        }
        if (GlobalAppRuntimeInfo.isAppBackground() && i2 == anet.channel.entity.c.f462a && AwcnConfig.isAccsSessionCreateForbiddenInBg() && (sessionInfoB = this.f339g.b(httpUrl.host())) != null && sessionInfoB.isAccs) {
            ALog.w(TAG, "app background, forbid to create accs session", this.f335c, new Object[0]);
            throw new ConnectException("accs session connecting forbidden in background");
        }
        sessionRequestA.b(this.f334b, i2, anet.channel.util.i.a(this.f335c), sessionGetCallback, j2);
    }

    @Deprecated
    public void enterBackground() {
        AppLifecycle.onBackground();
    }

    @Deprecated
    public void enterForeground() {
        AppLifecycle.onForeground();
    }

    public void forceRecreateAccsSession() {
        this.f340h.forceCloseSession(true);
    }

    public Session get(String str, long j2) {
        return get(HttpUrl.parse(str), anet.channel.entity.c.f464c, j2);
    }

    public Session getThrowsException(String str, long j2) throws Exception {
        return a(HttpUrl.parse(str), anet.channel.entity.c.f464c, j2, null);
    }

    public void registerAccsSessionListener(ISessionListener iSessionListener) {
        this.f340h.registerListener(iSessionListener);
    }

    public void registerPublicKey(String str, int i2) {
        this.f339g.a(str, i2);
    }

    public void registerSessionInfo(SessionInfo sessionInfo) {
        this.f339g.a(sessionInfo);
        if (sessionInfo.isKeepAlive) {
            this.f340h.checkAndStartSession();
        }
    }

    @Deprecated
    public synchronized void switchEnv(ENV env) {
        switchEnvironment(env);
    }

    public void unregisterAccsSessionListener(ISessionListener iSessionListener) {
        this.f340h.unregisterListener(iSessionListener);
    }

    public void unregisterSessionInfo(String str) {
        SessionInfo sessionInfoA = this.f339g.a(str);
        if (sessionInfoA == null || !sessionInfoA.isKeepAlive) {
            return;
        }
        this.f340h.checkAndStartSession();
    }

    public class a implements NetworkStatusHelper.INetworkStatusChangeListener, IStrategyListener, AppLifecycle.AppLifecycleListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f342a;

        private a() {
            this.f342a = false;
        }

        public void a() {
            AppLifecycle.registerLifecycleListener(this);
            NetworkStatusHelper.addStatusChangeListener(this);
            StrategyCenter.getInstance().registerListener(this);
        }

        public void b() {
            StrategyCenter.getInstance().unregisterListener(this);
            AppLifecycle.unregisterLifecycleListener(this);
            NetworkStatusHelper.removeStatusChangeListener(this);
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void background() {
            ALog.i(SessionCenter.TAG, "[background]", SessionCenter.this.f335c, new Object[0]);
            if (!SessionCenter.j) {
                ALog.e(SessionCenter.TAG, "background not inited!", SessionCenter.this.f335c, new Object[0]);
                return;
            }
            try {
                StrategyCenter.getInstance().saveData();
                if (AwcnConfig.isAccsSessionCreateForbiddenInBg() && "OPPO".equalsIgnoreCase(Build.BRAND)) {
                    ALog.i(SessionCenter.TAG, "close session for OPPO", SessionCenter.this.f335c, new Object[0]);
                    SessionCenter.this.f340h.forceCloseSession(false);
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.util.AppLifecycle.AppLifecycleListener
        public void forground() {
            ALog.i(SessionCenter.TAG, "[forground]", SessionCenter.this.f335c, new Object[0]);
            if (SessionCenter.this.f334b == null || this.f342a) {
                return;
            }
            this.f342a = true;
            try {
                if (!SessionCenter.j) {
                    ALog.e(SessionCenter.TAG, "forground not inited!", SessionCenter.this.f335c, new Object[0]);
                    return;
                }
                try {
                    if (AppLifecycle.lastEnterBackgroundTime == 0 || System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime <= 60000) {
                        SessionCenter.this.f340h.checkAndStartSession();
                    } else {
                        SessionCenter.this.f340h.forceCloseSession(true);
                    }
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.f342a = false;
                    throw th;
                }
                this.f342a = false;
            } catch (Exception unused2) {
            }
        }

        @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
        public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
            ALog.e(SessionCenter.TAG, "onNetworkStatusChanged.", SessionCenter.this.f335c, "networkStatus", networkStatus);
            List<SessionRequest> listA = SessionCenter.this.f337e.a();
            if (!listA.isEmpty()) {
                for (SessionRequest sessionRequest : listA) {
                    ALog.d(SessionCenter.TAG, "network change, try recreate session", SessionCenter.this.f335c, new Object[0]);
                    sessionRequest.a((String) null);
                }
            }
            SessionCenter.this.f340h.checkAndStartSession();
        }

        @Override // anet.channel.strategy.IStrategyListener
        public void onStrategyUpdated(l.d dVar) {
            SessionCenter.this.a(dVar);
            SessionCenter.this.f340h.checkAndStartSession();
        }

        public /* synthetic */ a(SessionCenter sessionCenter, d dVar) {
            this();
        }
    }

    @Deprecated
    public Session get(String str, ConnType.TypeLevel typeLevel, long j2) {
        return get(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f462a : anet.channel.entity.c.f463b, j2);
    }

    @Deprecated
    public Session getThrowsException(String str, ConnType.TypeLevel typeLevel, long j2) throws Exception {
        return a(HttpUrl.parse(str), typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f462a : anet.channel.entity.c.f463b, j2, null);
    }

    private SessionRequest a(HttpUrl httpUrl) {
        String cNameByHost = StrategyCenter.getInstance().getCNameByHost(httpUrl.host());
        if (cNameByHost == null) {
            cNameByHost = httpUrl.host();
        }
        String strScheme = httpUrl.scheme();
        if (!httpUrl.isSchemeLocked()) {
            strScheme = StrategyCenter.getInstance().getSchemeByHost(cNameByHost, strScheme);
        }
        return a(StringUtils.concatString(strScheme, HttpConstant.SCHEME_SPLIT, cNameByHost));
    }

    @Deprecated
    public Session get(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j2) {
        return get(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f462a : anet.channel.entity.c.f463b, j2);
    }

    public Session getThrowsException(HttpUrl httpUrl, int i2, long j2) throws Exception {
        return a(httpUrl, i2, j2, null);
    }

    public static synchronized SessionCenter getInstance(Config config) {
        SessionCenter sessionCenter;
        Context appContext;
        if (config != null) {
            if (!j && (appContext = Utils.getAppContext()) != null) {
                init(appContext);
            }
            sessionCenter = f333a.get(config);
            if (sessionCenter == null) {
                sessionCenter = new SessionCenter(config);
                f333a.put(config, sessionCenter);
            }
        } else {
            throw new NullPointerException("config is null!");
        }
        return sessionCenter;
    }

    public Session get(HttpUrl httpUrl, int i2, long j2) {
        try {
            return a(httpUrl, i2, j2, null);
        } catch (NoAvailStrategyException e2) {
            ALog.i(TAG, "[Get]" + e2.getMessage(), this.f335c, null, AgooConstants.OPEN_URL, httpUrl.urlString());
            return null;
        } catch (ConnectException e3) {
            ALog.e(TAG, "[Get]connect exception", this.f335c, "errMsg", e3.getMessage(), AgooConstants.OPEN_URL, httpUrl.urlString());
            return null;
        } catch (InvalidParameterException e4) {
            ALog.e(TAG, "[Get]param url is invalid", this.f335c, e4, AgooConstants.OPEN_URL, httpUrl);
            return null;
        } catch (TimeoutException e5) {
            ALog.e(TAG, "[Get]timeout exception", this.f335c, e5, AgooConstants.OPEN_URL, httpUrl.urlString());
            return null;
        } catch (Exception e6) {
            ALog.e(TAG, "[Get]" + e6.getMessage(), this.f335c, null, AgooConstants.OPEN_URL, httpUrl.urlString());
            return null;
        }
    }

    @Deprecated
    public Session getThrowsException(HttpUrl httpUrl, ConnType.TypeLevel typeLevel, long j2) throws Exception {
        return a(httpUrl, typeLevel == ConnType.TypeLevel.SPDY ? anet.channel.entity.c.f462a : anet.channel.entity.c.f463b, j2, null);
    }

    public Session a(HttpUrl httpUrl, int i2, long j2, SessionGetCallback sessionGetCallback) throws Exception {
        SessionInfo sessionInfoB;
        if (!j) {
            ALog.e(TAG, "getInternal not inited!", this.f335c, new Object[0]);
            throw new IllegalStateException("getInternal not inited");
        }
        if (httpUrl != null) {
            String str = this.f335c;
            Object[] objArr = new Object[6];
            objArr[0] = "u";
            objArr[1] = httpUrl.urlString();
            objArr[2] = "sessionType";
            objArr[3] = i2 == anet.channel.entity.c.f462a ? "LongLink" : "ShortLink";
            objArr[4] = com.alipay.sdk.m.m.a.h0;
            objArr[5] = Long.valueOf(j2);
            ALog.d(TAG, "getInternal", str, objArr);
            SessionRequest sessionRequestA = a(httpUrl);
            Session sessionA = this.f337e.a(sessionRequestA, i2);
            if (sessionA != null) {
                ALog.d(TAG, "get internal hit cache session", this.f335c, "session", sessionA);
            } else {
                if (this.f336d == Config.DEFAULT_CONFIG && i2 != anet.channel.entity.c.f463b) {
                    if (sessionGetCallback == null) {
                        return null;
                    }
                    sessionGetCallback.onSessionGetFail();
                    return null;
                }
                if (GlobalAppRuntimeInfo.isAppBackground() && i2 == anet.channel.entity.c.f462a && AwcnConfig.isAccsSessionCreateForbiddenInBg() && (sessionInfoB = this.f339g.b(httpUrl.host())) != null && sessionInfoB.isAccs) {
                    ALog.w(TAG, "app background, forbid to create accs session", this.f335c, new Object[0]);
                    throw new ConnectException("accs session connecting forbidden in background");
                }
                sessionRequestA.a(this.f334b, i2, anet.channel.util.i.a(this.f335c), sessionGetCallback, j2);
                if (sessionGetCallback == null && j2 > 0 && (i2 == anet.channel.entity.c.f464c || sessionRequestA.b() == i2)) {
                    sessionRequestA.a(j2);
                    sessionA = this.f337e.a(sessionRequestA, i2);
                    if (sessionA == null) {
                        throw new ConnectException("session connecting failed or timeout");
                    }
                }
            }
            return sessionA;
        }
        throw new InvalidParameterException("httpUrl is null");
    }

    @Deprecated
    public static synchronized SessionCenter getInstance() {
        Context appContext;
        if (!j && (appContext = Utils.getAppContext()) != null) {
            init(appContext);
        }
        SessionCenter sessionCenter = null;
        for (Map.Entry<Config, SessionCenter> entry : f333a.entrySet()) {
            SessionCenter value = entry.getValue();
            if (entry.getKey() != Config.DEFAULT_CONFIG) {
                return value;
            }
            sessionCenter = value;
        }
        return sessionCenter;
    }

    @Deprecated
    public static synchronized void init(Context context, String str) {
        init(context, str, GlobalAppRuntimeInfo.getEnv());
    }

    public static synchronized void init(Context context, String str, ENV env) {
        if (context != null) {
            Config config = Config.getConfig(str, env);
            if (config == null) {
                config = new Config.Builder().setAppkey(str).setEnv(env).build();
            }
            init(context, config);
        } else {
            ALog.e(TAG, "context is null!", null, new Object[0]);
            throw new NullPointerException("init failed. context is null");
        }
    }

    private void b(l.b bVar) {
        boolean z;
        boolean z2;
        ALog.i(TAG, "find effectNow", this.f335c, "host", bVar.f669a);
        l.a[] aVarArr = bVar.f676h;
        String[] strArr = bVar.f674f;
        for (Session session : this.f337e.a(a(StringUtils.buildKey(bVar.f671c, bVar.f669a)))) {
            if (!session.getConnType().isHttpType()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= strArr.length) {
                        z = false;
                        break;
                    } else {
                        if (session.getIp().equals(strArr[i2])) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (z) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= aVarArr.length) {
                            z2 = false;
                            break;
                        } else {
                            if (session.getPort() == aVarArr[i3].f661a && session.getConnType().equals(ConnType.valueOf(ConnProtocol.valueOf(aVarArr[i3])))) {
                                z2 = true;
                                break;
                            }
                            i3++;
                        }
                    }
                    if (!z2) {
                        if (ALog.isPrintLog(2)) {
                            ALog.i(TAG, "aisle not match", session.p, "port", Integer.valueOf(session.getPort()), "connType", session.getConnType(), "aisle", Arrays.toString(aVarArr));
                        }
                        session.close(true);
                    }
                } else {
                    if (ALog.isPrintLog(2)) {
                        ALog.i(TAG, "ip not match", session.p, "session ip", session.getIp(), "ips", Arrays.toString(strArr));
                    }
                    session.close(true);
                }
            }
        }
    }

    public static synchronized void init(Context context, Config config) {
        if (context == null) {
            ALog.e(TAG, "context is null!", null, new Object[0]);
            throw new NullPointerException("init failed. context is null");
        }
        if (config != null) {
            init(context);
            if (!f333a.containsKey(config)) {
                f333a.put(config, new SessionCenter(config));
            }
        } else {
            ALog.e(TAG, "paramter config is null!", null, new Object[0]);
            throw new NullPointerException("init failed. config is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l.d dVar) {
        try {
            for (l.b bVar : dVar.f681b) {
                if (bVar.k) {
                    b(bVar);
                }
                if (bVar.f673e != null) {
                    a(bVar);
                }
            }
        } catch (Exception e2) {
            ALog.e(TAG, "checkStrategy failed", this.f335c, e2, new Object[0]);
        }
    }

    private void a(l.b bVar) {
        for (Session session : this.f337e.a(a(StringUtils.buildKey(bVar.f671c, bVar.f669a)))) {
            if (!StringUtils.isStringEqual(session.l, bVar.f673e)) {
                ALog.i(TAG, "unit change", session.p, "session unit", session.l, "unit", bVar.f673e);
                session.close(true);
            }
        }
    }

    public SessionRequest a(String str) {
        SessionRequest sessionRequest;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f338f) {
            sessionRequest = this.f338f.get(str);
            if (sessionRequest == null) {
                sessionRequest = new SessionRequest(str, this);
                this.f338f.put(str, sessionRequest);
            }
        }
        return sessionRequest;
    }
}
