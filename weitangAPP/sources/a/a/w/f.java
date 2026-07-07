package a.a.w;

import a.a.n.a;
import android.text.TextUtils;
import anet.channel.Config;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.NoAvailStrategyException;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.entity.ENV;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import anetwork.channel.aidl.DefaultFinishEvent;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class f implements a.a.w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a.a.n.a f247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a.C0000a f248c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f250e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile AtomicBoolean f253h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteArrayOutputStream f249d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Cancelable f251f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f252g = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f254i = 0;
    public int j = 0;
    public boolean k = false;
    public boolean l = false;
    public a m = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, List<String>> f256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<ByteArray> f257c = new ArrayList();

        public a(int i2, Map<String, List<String>> map) {
            this.f255a = i2;
            this.f256b = map;
        }

        public int a(a.a.s.a aVar, int i2) {
            aVar.onResponseCode(this.f255a, this.f256b);
            Iterator<ByteArray> it = this.f257c.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                aVar.onDataReceiveSize(i3, i2, it.next());
                i3++;
            }
            return i3;
        }

        public void b() {
            Iterator<ByteArray> it = this.f257c.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
        }
    }

    public f(k kVar, a.a.n.a aVar, a.C0000a c0000a) {
        this.f247b = null;
        this.f248c = null;
        this.f250e = "other";
        this.f253h = null;
        this.f246a = kVar;
        this.f253h = kVar.f278d;
        this.f247b = aVar;
        this.f248c = c0000a;
        this.f250e = kVar.f275a.h().get(HttpConstant.F_REFER);
    }

    public final Session a(Session session, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z) {
        a.a.q.g gVar = this.f246a.f275a;
        RequestStatistic requestStatistic = gVar.f219f;
        if (session == null && gVar.e() && !z && !NetworkStatusHelper.isProxy()) {
            session = sessionCenter.get(httpUrl, anet.channel.entity.c.f463b, 0L);
        }
        if (session == null) {
            ALog.i("anet.NetworkTask", "create HttpSession with local DNS", this.f246a.f277c, new Object[0]);
            session = new anet.channel.session.d(GlobalAppRuntimeInfo.getContext(), new anet.channel.entity.a(StringUtils.concatString(httpUrl.scheme(), HttpConstant.SCHEME_SPLIT, httpUrl.host()), this.f246a.f277c, null));
        }
        if (requestStatistic.spdyRequestSend) {
            requestStatistic.degraded = 1;
        }
        ALog.i("anet.NetworkTask", "tryGetHttpSession", this.f246a.f277c, "Session", session);
        return session;
    }

    public final SessionCenter c() {
        String strA = this.f246a.f275a.a("APPKEY");
        if (TextUtils.isEmpty(strA)) {
            return SessionCenter.getInstance();
        }
        ENV env = ENV.ONLINE;
        String strA2 = this.f246a.f275a.a("ENVIRONMENT");
        if ("pre".equalsIgnoreCase(strA2)) {
            env = ENV.PREPARE;
        } else if ("test".equalsIgnoreCase(strA2)) {
            env = ENV.TEST;
        }
        if (env != a.a.r.a.CURRENT_ENV) {
            a.a.r.a.CURRENT_ENV = env;
            SessionCenter.switchEnvironment(env);
        }
        Config config = Config.getConfig(strA, env);
        if (config == null) {
            config = new Config.Builder().setAppkey(strA).setEnv(env).setAuthCode(this.f246a.f275a.a("AuthCode")).build();
        }
        return SessionCenter.getInstance(config);
    }

    @Override // anet.channel.request.Cancelable
    public void cancel() {
        this.f252g = true;
        if (this.f251f != null) {
            this.f251f.cancel();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final anet.channel.request.Request d(anet.channel.request.Request r7) {
        /*
            r6 = this;
            a.a.w.k r0 = r6.f246a
            a.a.q.g r0 = r0.f275a
            boolean r0 = r0.i()
            if (r0 == 0) goto L3c
            a.a.w.k r0 = r6.f246a
            a.a.q.g r0 = r0.f275a
            java.lang.String r0 = r0.g()
            java.lang.String r0 = a.a.p.a.getCookie(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L3c
            anet.channel.request.Request$Builder r1 = r7.newBuilder()
            java.util.Map r2 = r7.getHeaders()
            java.lang.String r3 = "Cookie"
            java.lang.Object r2 = r2.get(r3)
            java.lang.String r2 = (java.lang.String) r2
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L38
            java.lang.String r4 = "; "
            java.lang.String r0 = anet.channel.util.StringUtils.concatString(r2, r4, r0)
        L38:
            r1.addHeader(r3, r0)
            goto L3d
        L3c:
            r1 = 0
        L3d:
            a.a.n.a$a r0 = r6.f248c
            if (r0 == 0) goto L66
            if (r1 != 0) goto L48
            anet.channel.request.Request$Builder r0 = r7.newBuilder()
            r1 = r0
        L48:
            a.a.n.a$a r0 = r6.f248c
            java.lang.String r0 = r0.etag
            if (r0 == 0) goto L53
            java.lang.String r2 = "If-None-Match"
            r1.addHeader(r2, r0)
        L53:
            a.a.n.a$a r0 = r6.f248c
            long r2 = r0.lastModified
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L66
            java.lang.String r0 = a.a.n.d.a(r2)
            java.lang.String r2 = "If-Modified-Since"
            r1.addHeader(r2, r0)
        L66:
            a.a.w.k r0 = r6.f246a
            a.a.q.g r0 = r0.f275a
            int r0 = r0.f218e
            if (r0 != 0) goto L84
            java.lang.String r0 = r6.f250e
            java.lang.String r2 = "weex"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L84
            if (r1 != 0) goto L7f
            anet.channel.request.Request$Builder r0 = r7.newBuilder()
            r1 = r0
        L7f:
            r0 = 3000(0xbb8, float:4.204E-42)
            r1.setReadTimeout(r0)
        L84:
            if (r1 != 0) goto L87
            goto L8b
        L87:
            anet.channel.request.Request r7 = r1.build()
        L8b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.w.f.d(anet.channel.request.Request):anet.channel.request.Request");
    }

    public final HttpUrl e(HttpUrl httpUrl) {
        HttpUrl httpUrl2;
        String str = this.f246a.f275a.h().get(HttpConstant.X_HOST_CNAME);
        return (TextUtils.isEmpty(str) || (httpUrl2 = HttpUrl.parse(httpUrl.urlString().replaceFirst(httpUrl.host(), str))) == null) ? httpUrl : httpUrl2;
    }

    public final void f(Session session, Request request) {
        if (session == null || this.f252g) {
            return;
        }
        Request requestD = d(request);
        RequestStatistic requestStatistic = this.f246a.f275a.f219f;
        requestStatistic.reqStart = System.currentTimeMillis();
        this.f251f = session.request(requestD, new j(this, requestD, requestStatistic));
    }

    public final Session h() {
        Session throwsException;
        SessionCenter sessionCenterC = c();
        HttpUrl httpUrlF = this.f246a.f275a.f();
        boolean zContainsNonDefaultPort = httpUrlF.containsNonDefaultPort();
        a.a.q.g gVar = this.f246a.f275a;
        RequestStatistic requestStatistic = gVar.f219f;
        if (gVar.j != 1 || !a.a.o.b.isSpdyEnabled() || this.f246a.f275a.f218e != 0 || zContainsNonDefaultPort) {
            return a(null, sessionCenterC, httpUrlF, zContainsNonDefaultPort);
        }
        HttpUrl httpUrlE = e(httpUrlF);
        try {
            throwsException = sessionCenterC.getThrowsException(httpUrlE, anet.channel.entity.c.f462a, 0L);
        } catch (NoAvailStrategyException unused) {
            return a(null, sessionCenterC, httpUrlF, zContainsNonDefaultPort);
        } catch (Exception unused2) {
            throwsException = null;
        }
        if (throwsException == null) {
            ThreadPoolExecutorFactory.submitPriorityTask(new h(this, sessionCenterC, httpUrlE, requestStatistic, httpUrlF, zContainsNonDefaultPort), ThreadPoolExecutorFactory.Priority.NORMAL);
            return null;
        }
        ALog.i("anet.NetworkTask", "tryGetSession", this.f246a.f277c, "Session", throwsException);
        requestStatistic.spdyRequestSend = true;
        return throwsException;
    }

    public final void i() {
        SessionCenter sessionCenterC = c();
        HttpUrl httpUrlF = this.f246a.f275a.f();
        boolean zContainsNonDefaultPort = httpUrlF.containsNonDefaultPort();
        a.a.q.g gVar = this.f246a.f275a;
        RequestStatistic requestStatistic = gVar.f219f;
        Request requestA = gVar.a();
        if (this.f246a.f275a.j != 1 || !a.a.o.b.isSpdyEnabled() || this.f246a.f275a.f218e != 0 || zContainsNonDefaultPort) {
            f(a(null, sessionCenterC, httpUrlF, zContainsNonDefaultPort), requestA);
            return;
        }
        sessionCenterC.asyncGet(e(httpUrlF), anet.channel.entity.c.f462a, 3000L, new i(this, requestStatistic, System.currentTimeMillis(), requestA, sessionCenterC, httpUrlF, zContainsNonDefaultPort));
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f252g) {
            return;
        }
        RequestStatistic requestStatistic = this.f246a.f275a.f219f;
        requestStatistic.f_refer = this.f250e;
        if (!NetworkStatusHelper.isConnected()) {
            if (a.a.o.b.isRequestDelayRetryForNoNetwork() && requestStatistic.statusCode != -200) {
                requestStatistic.statusCode = ErrorConstant.ERROR_NO_NETWORK;
                ThreadPoolExecutorFactory.submitScheduledTask(new g(this), 1000L, TimeUnit.MILLISECONDS);
                return;
            }
            if (ALog.isPrintLog(2)) {
                ALog.i("anet.NetworkTask", "network unavailable", this.f246a.f277c, "NetworkStatus", NetworkStatusHelper.getStatus());
            }
            this.f253h.set(true);
            this.f246a.a();
            requestStatistic.isDone.set(true);
            requestStatistic.statusCode = ErrorConstant.ERROR_NO_NETWORK;
            requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_NO_NETWORK);
            requestStatistic.rspEnd = System.currentTimeMillis();
            this.f246a.f276b.onFinish(new DefaultFinishEvent(ErrorConstant.ERROR_NO_NETWORK, (String) null, this.f246a.f275a.a()));
            return;
        }
        if (!a.a.o.b.isBgRequestForbidden() || !GlobalAppRuntimeInfo.isAppBackground() || AppLifecycle.lastEnterBackgroundTime <= 0 || AppLifecycle.isGoingForeground || System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime <= a.a.o.b.getBgForbidRequestThreshold() || a.a.o.b.isUrlInWhiteList(this.f246a.f275a.f()) || a.a.o.b.isBizInWhiteList(this.f246a.f275a.a().getBizId()) || this.f246a.f275a.a().isAllowRequestInBg()) {
            if (ALog.isPrintLog(2)) {
                k kVar = this.f246a;
                ALog.i("anet.NetworkTask", "exec request", kVar.f277c, "retryTimes", Integer.valueOf(kVar.f275a.f218e));
            }
            if (a.a.o.b.isGetSessionAsyncEnable()) {
                i();
                return;
            }
            try {
                Session sessionH = h();
                if (sessionH == null) {
                    return;
                }
                f(sessionH, this.f246a.f275a.a());
                return;
            } catch (Exception e2) {
                ALog.e("anet.NetworkTask", "send request failed.", this.f246a.f277c, e2, new Object[0]);
                return;
            }
        }
        this.f253h.set(true);
        this.f246a.a();
        if (ALog.isPrintLog(2)) {
            k kVar2 = this.f246a;
            ALog.i("anet.NetworkTask", "request forbidden in background", kVar2.f277c, AgooConstants.OPEN_URL, kVar2.f275a.f());
        }
        requestStatistic.isDone.set(true);
        requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG;
        requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG);
        requestStatistic.rspEnd = System.currentTimeMillis();
        this.f246a.f276b.onFinish(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, (String) null, this.f246a.f275a.a()));
        ExceptionStatistic exceptionStatistic = new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_FORBIDDEN_IN_BG, null, "rt");
        exceptionStatistic.host = this.f246a.f275a.f().host();
        exceptionStatistic.url = this.f246a.f275a.g();
        AppMonitor.getInstance().commitStat(exceptionStatistic);
    }
}
