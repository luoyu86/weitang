package anet.channel;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventCb;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.StringUtils;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;

/* JADX INFO: loaded from: classes.dex */
public abstract class Session implements Comparable<Session> {
    public static ExecutorService v = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f322a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f326e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f327f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f328g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f329h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f330i;
    public ConnType j;
    public IConnStrategy k;
    public boolean m;
    public Runnable o;
    public final String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SessionStatistic f331q;
    public int r;
    public int s;
    private Future<?> x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<EventCb, Integer> f323b = new LinkedHashMap();
    private boolean w = false;
    public String l = null;
    public int n = 6;
    public boolean t = false;
    public boolean u = true;
    private List<Long> y = null;
    private long z = 0;

    public static class a {
        public static final int AUTHING = 3;
        public static final int AUTH_FAIL = 5;
        public static final int AUTH_SUCC = 4;
        public static final int CONNECTED = 0;
        public static final int CONNECTING = 1;
        public static final int CONNETFAIL = 2;
        public static final int DISCONNECTED = 6;
        public static final int DISCONNECTING = 7;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String[] f332a = {"CONNECTED", "CONNECTING", "CONNETFAIL", "AUTHING", "AUTH_SUCC", "AUTH_FAIL", "DISCONNECTED", "DISCONNECTING"};

        public static String a(int i2) {
            return f332a[i2];
        }
    }

    public Session(Context context, anet.channel.entity.a aVar) {
        boolean z = false;
        this.m = false;
        this.f322a = context;
        String strA = aVar.a();
        this.f326e = strA;
        this.f327f = strA;
        this.f328g = aVar.b();
        this.j = aVar.c();
        String strF = aVar.f();
        this.f324c = strF;
        this.f325d = strF.substring(strF.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.s = aVar.e();
        this.r = aVar.d();
        IConnStrategy iConnStrategy = aVar.f454a;
        this.k = iConnStrategy;
        if (iConnStrategy != null && iConnStrategy.getIpType() == -1) {
            z = true;
        }
        this.m = z;
        this.p = aVar.h();
        SessionStatistic sessionStatistic = new SessionStatistic(aVar);
        this.f331q = sessionStatistic;
        sessionStatistic.host = this.f325d;
    }

    public static void configTnetALog(Context context, String str, int i2, int i3) {
        SpdyAgent spdyAgent = SpdyAgent.getInstance(context, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        if (spdyAgent == null || !SpdyAgent.checkLoadSucc()) {
            ALog.e("agent null or configTnetALog load so fail!!!", null, "loadso", Boolean.valueOf(SpdyAgent.checkLoadSucc()));
        } else {
            spdyAgent.configLogFile(str, i2, i3);
        }
    }

    public void a() {
        Future<?> future;
        if (this.o == null || (future = this.x) == null) {
            return;
        }
        future.cancel(true);
    }

    public void checkAvailable() {
        ping(true);
    }

    public abstract void close();

    public void close(boolean z) {
        this.t = z;
        close();
    }

    public void connect() {
    }

    public IConnStrategy getConnStrategy() {
        return this.k;
    }

    public ConnType getConnType() {
        return this.j;
    }

    public String getHost() {
        return this.f324c;
    }

    public String getIp() {
        return this.f326e;
    }

    public int getPort() {
        return this.f328g;
    }

    public String getRealHost() {
        return this.f325d;
    }

    public abstract Runnable getRecvTimeOutRunnable();

    public String getUnit() {
        return this.l;
    }

    public void handleCallbacks(int i2, anet.channel.entity.b bVar) {
        v.submit(new b(this, i2, bVar));
    }

    public void handleResponseCode(Request request, int i2) {
        if (request.getHeaders().containsKey(HttpConstant.X_PV) && i2 >= 500 && i2 < 600) {
            synchronized (this) {
                if (this.y == null) {
                    this.y = new LinkedList();
                }
                if (this.y.size() < 5) {
                    this.y.add(Long.valueOf(System.currentTimeMillis()));
                } else {
                    long jLongValue = this.y.remove(0).longValue();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - jLongValue <= 60000) {
                        StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                        this.y.clear();
                    } else {
                        this.y.add(Long.valueOf(jCurrentTimeMillis));
                    }
                }
            }
        }
    }

    public void handleResponseHeaders(Request request, Map<String, List<String>> map) {
        try {
            if (map.containsKey(HttpConstant.X_SWITCH_UNIT)) {
                String singleHeaderFieldByKey = HttpHelper.getSingleHeaderFieldByKey(map, HttpConstant.X_SWITCH_UNIT);
                if (TextUtils.isEmpty(singleHeaderFieldByKey)) {
                    singleHeaderFieldByKey = null;
                }
                if (StringUtils.isStringEqual(this.l, singleHeaderFieldByKey)) {
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.z > 60000) {
                    StrategyCenter.getInstance().forceRefreshStrategy(request.getHost());
                    this.z = jCurrentTimeMillis;
                }
            }
        } catch (Exception unused) {
        }
    }

    public abstract boolean isAvailable();

    public synchronized void notifyStatus(int i2, anet.channel.entity.b bVar) {
        ALog.e("awcn.Session", "notifyStatus", this.p, "status", a.a(i2));
        if (i2 == this.n) {
            ALog.i("awcn.Session", "ignore notifyStatus", this.p, new Object[0]);
            return;
        }
        this.n = i2;
        if (i2 == 0) {
            handleCallbacks(1, bVar);
        } else if (i2 == 2) {
            handleCallbacks(256, bVar);
        } else if (i2 == 4) {
            this.l = StrategyCenter.getInstance().getUnitByHost(this.f325d);
            handleCallbacks(512, bVar);
        } else if (i2 == 5) {
            handleCallbacks(1024, bVar);
        } else if (i2 == 6) {
            onDisconnect();
            if (!this.w) {
                handleCallbacks(2, bVar);
            }
        }
    }

    public void onDisconnect() {
    }

    public void ping(boolean z) {
    }

    public void ping(boolean z, int i2) {
    }

    public void registerEventcb(int i2, EventCb eventCb) {
        Map<EventCb, Integer> map = this.f323b;
        if (map != null) {
            map.put(eventCb, Integer.valueOf(i2));
        }
    }

    public abstract Cancelable request(Request request, RequestCb requestCb);

    public void sendCustomFrame(int i2, byte[] bArr, int i3) {
    }

    public void setPingTimeout(int i2) {
        if (this.o == null) {
            this.o = getRecvTimeOutRunnable();
        }
        a();
        Runnable runnable = this.o;
        if (runnable != null) {
            this.x = ThreadPoolExecutorFactory.submitScheduledTask(runnable, i2, TimeUnit.MILLISECONDS);
        }
    }

    public String toString() {
        return "Session@[" + this.p + '|' + this.j + ']';
    }

    @Override // java.lang.Comparable
    public int compareTo(Session session) {
        return ConnType.compare(this.j, session.j);
    }
}
