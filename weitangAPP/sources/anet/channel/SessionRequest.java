package anet.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ConnType;
import anet.channel.entity.EventType;
import anet.channel.session.TnetSpdySession;
import anet.channel.statist.AlarmObject;
import anet.channel.statist.SessionConnStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class SessionRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SessionCenter f344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SessionInfo f346c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Session f348e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f352i;
    private String j;
    private volatile Future k;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f347d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f349f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap<SessionGetCallback, c> f350g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SessionConnStat f351h = null;
    private Object l = new Object();

    public interface IConnCb {
        void onDisConnect(Session session, long j, int i2);

        void onFailed(Session session, long j, int i2, int i3);

        void onSuccess(Session session, long j);
    }

    public class a implements IConnCb {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f353a = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Context f355c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<anet.channel.entity.a> f356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private anet.channel.entity.a f357e;

        public a(Context context, List<anet.channel.entity.a> list, anet.channel.entity.a aVar) {
            this.f355c = context;
            this.f356d = list;
            this.f357e = aVar;
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onDisConnect(Session session, long j, int i2) {
            SessionInfo sessionInfo;
            boolean zIsAppBackground = GlobalAppRuntimeInfo.isAppBackground();
            ALog.d("awcn.SessionRequest", "Connect Disconnect", this.f357e.h(), "session", session, "host", SessionRequest.this.a(), "appIsBg", Boolean.valueOf(zIsAppBackground), "isHandleFinish", Boolean.valueOf(this.f353a));
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.f345b.b(sessionRequest, session);
            if (this.f353a) {
                return;
            }
            this.f353a = true;
            if (session.t) {
                if (zIsAppBackground && ((sessionInfo = SessionRequest.this.f346c) == null || !sessionInfo.isAccs || AwcnConfig.isAccsSessionCreateForbiddenInBg())) {
                    ALog.e("awcn.SessionRequest", "[onDisConnect]app background, don't Recreate", this.f357e.h(), "session", session);
                    return;
                }
                if (!NetworkStatusHelper.isConnected()) {
                    ALog.e("awcn.SessionRequest", "[onDisConnect]no network, don't Recreate", this.f357e.h(), "session", session);
                    return;
                }
                try {
                    ALog.d("awcn.SessionRequest", "session disconnected, try to recreate session", this.f357e.h(), new Object[0]);
                    int accsReconnectionDelayPeriod = 10000;
                    SessionInfo sessionInfo2 = SessionRequest.this.f346c;
                    if (sessionInfo2 != null && sessionInfo2.isAccs) {
                        accsReconnectionDelayPeriod = AwcnConfig.getAccsReconnectionDelayPeriod();
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(new i(this, session), (long) (Math.random() * ((double) accsReconnectionDelayPeriod)), TimeUnit.MILLISECONDS);
                } catch (Exception unused) {
                }
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onFailed(Session session, long j, int i2, int i3) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "Connect failed", this.f357e.h(), "session", session, "host", SessionRequest.this.a(), "isHandleFinish", Boolean.valueOf(this.f353a));
            }
            if (SessionRequest.this.f349f) {
                SessionRequest.this.f349f = false;
                return;
            }
            if (this.f353a) {
                return;
            }
            this.f353a = true;
            SessionRequest sessionRequest = SessionRequest.this;
            sessionRequest.f345b.b(sessionRequest, session);
            if (!session.u || !NetworkStatusHelper.isConnected() || this.f356d.isEmpty()) {
                SessionRequest.this.c();
                SessionRequest.this.a(session, i2, i3);
                synchronized (SessionRequest.this.f350g) {
                    for (Map.Entry<SessionGetCallback, c> entry : SessionRequest.this.f350g.entrySet()) {
                        c value = entry.getValue();
                        if (value.f361b.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.removeScheduleTask(value);
                            entry.getKey().onSessionGetFail();
                        }
                    }
                    SessionRequest.this.f350g.clear();
                }
                return;
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "use next connInfo to create session", this.f357e.h(), "host", SessionRequest.this.a());
            }
            anet.channel.entity.a aVar = this.f357e;
            if (aVar.f455b == aVar.f456c && (i3 == -2003 || i3 == -2410)) {
                ListIterator<anet.channel.entity.a> listIterator = this.f356d.listIterator();
                while (listIterator.hasNext()) {
                    if (session.getIp().equals(listIterator.next().f454a.getIp())) {
                        listIterator.remove();
                    }
                }
            }
            if (anet.channel.strategy.utils.c.b(session.getIp())) {
                ListIterator<anet.channel.entity.a> listIterator2 = this.f356d.listIterator();
                while (listIterator2.hasNext()) {
                    if (anet.channel.strategy.utils.c.b(listIterator2.next().f454a.getIp())) {
                        listIterator2.remove();
                    }
                }
            }
            if (!this.f356d.isEmpty()) {
                anet.channel.entity.a aVarRemove = this.f356d.remove(0);
                SessionRequest sessionRequest2 = SessionRequest.this;
                Context context = this.f355c;
                sessionRequest2.a(context, aVarRemove, sessionRequest2.new a(context, this.f356d, aVarRemove), aVarRemove.h());
                return;
            }
            SessionRequest.this.c();
            SessionRequest.this.a(session, i2, i3);
            synchronized (SessionRequest.this.f350g) {
                for (Map.Entry<SessionGetCallback, c> entry2 : SessionRequest.this.f350g.entrySet()) {
                    c value2 = entry2.getValue();
                    if (value2.f361b.compareAndSet(false, true)) {
                        ThreadPoolExecutorFactory.removeScheduleTask(value2);
                        entry2.getKey().onSessionGetFail();
                    }
                }
                SessionRequest.this.f350g.clear();
            }
        }

        @Override // anet.channel.SessionRequest.IConnCb
        public void onSuccess(Session session, long j) {
            ALog.d("awcn.SessionRequest", "Connect Success", this.f357e.h(), "session", session, "host", SessionRequest.this.a());
            try {
                if (SessionRequest.this.f349f) {
                    SessionRequest.this.f349f = false;
                    session.close(false);
                    return;
                }
                SessionRequest sessionRequest = SessionRequest.this;
                sessionRequest.f345b.a(sessionRequest, session);
                SessionRequest.this.a(session);
                synchronized (SessionRequest.this.f350g) {
                    for (Map.Entry<SessionGetCallback, c> entry : SessionRequest.this.f350g.entrySet()) {
                        c value = entry.getValue();
                        if (value.f361b.compareAndSet(false, true)) {
                            ThreadPoolExecutorFactory.removeScheduleTask(value);
                            entry.getKey().onSessionGetSuccess(session);
                        }
                    }
                    SessionRequest.this.f350g.clear();
                }
            } catch (Exception e2) {
                ALog.e("awcn.SessionRequest", "[onSuccess]:", this.f357e.h(), e2, new Object[0]);
            } finally {
                SessionRequest.this.c();
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f358a;

        public b(String str) {
            this.f358a = null;
            this.f358a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SessionRequest.this.f347d) {
                ALog.e("awcn.SessionRequest", "Connecting timeout!!! reset status!", this.f358a, new Object[0]);
                SessionConnStat sessionConnStat = SessionRequest.this.f351h;
                sessionConnStat.ret = 2;
                sessionConnStat.totalTime = System.currentTimeMillis() - SessionRequest.this.f351h.start;
                if (SessionRequest.this.f348e != null) {
                    SessionRequest.this.f348e.u = false;
                    SessionRequest.this.f348e.close();
                    SessionRequest sessionRequest = SessionRequest.this;
                    sessionRequest.f351h.syncValueFromSession(sessionRequest.f348e);
                }
                AppMonitor.getInstance().commitStat(SessionRequest.this.f351h);
                SessionRequest.this.a(false);
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SessionGetCallback f360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public AtomicBoolean f361b = new AtomicBoolean(false);

        public c(SessionGetCallback sessionGetCallback) {
            this.f360a = null;
            this.f360a = sessionGetCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f361b.compareAndSet(false, true)) {
                ALog.e("awcn.SessionRequest", "get session timeout", null, new Object[0]);
                synchronized (SessionRequest.this.f350g) {
                    SessionRequest.this.f350g.remove(this.f360a);
                }
                this.f360a.onSessionGetFail();
            }
        }
    }

    public SessionRequest(String str, SessionCenter sessionCenter) {
        this.f352i = str;
        String strSubstring = str.substring(str.indexOf(HttpConstant.SCHEME_SPLIT) + 3);
        this.j = strSubstring;
        this.f344a = sessionCenter;
        this.f346c = sessionCenter.f339g.b(strSubstring);
        this.f345b = sessionCenter.f337e;
    }

    public synchronized void b(Context context, int i2, String str, SessionGetCallback sessionGetCallback, long j) {
        Session sessionA = this.f345b.a(this, i2);
        if (sessionA != null) {
            ALog.d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
            sessionGetCallback.onSessionGetSuccess(sessionA);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = anet.channel.util.i.a(null);
        }
        ALog.d("awcn.SessionRequest", "SessionRequest start", str, "host", this.f352i, "type", Integer.valueOf(i2));
        if (this.f347d) {
            ALog.d("awcn.SessionRequest", "session connecting", str, "host", a());
            if (b() == i2) {
                c cVar = new c(sessionGetCallback);
                synchronized (this.f350g) {
                    this.f350g.put(sessionGetCallback, cVar);
                }
                ThreadPoolExecutorFactory.submitScheduledTask(cVar, j, TimeUnit.MILLISECONDS);
            } else {
                sessionGetCallback.onSessionGetFail();
            }
            return;
        }
        a(true);
        this.k = ThreadPoolExecutorFactory.submitScheduledTask(new b(str), 45L, TimeUnit.SECONDS);
        SessionConnStat sessionConnStat = new SessionConnStat();
        this.f351h = sessionConnStat;
        sessionConnStat.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.isConnected()) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "network is not available, can't create session", str, "isConnected", Boolean.valueOf(NetworkStatusHelper.isConnected()));
            }
            c();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> listA = a(i2, str);
        if (listA.isEmpty()) {
            ALog.i("awcn.SessionRequest", "no avalible strategy, can't create session", str, "host", this.f352i, "type", Integer.valueOf(i2));
            c();
            throw new NoAvailStrategyException("no avalible strategy");
        }
        List<anet.channel.entity.a> listA2 = a(listA, str);
        try {
            anet.channel.entity.a aVarRemove = listA2.remove(0);
            a(context, aVarRemove, new a(context, listA2, aVarRemove), aVarRemove.h());
            c cVar2 = new c(sessionGetCallback);
            synchronized (this.f350g) {
                this.f350g.put(sessionGetCallback, cVar2);
            }
            ThreadPoolExecutorFactory.submitScheduledTask(cVar2, j, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            c();
        }
        return;
    }

    public void c() {
        a(false);
        synchronized (this.l) {
            this.l.notifyAll();
        }
    }

    public String a() {
        return this.f352i;
    }

    public void a(boolean z) {
        this.f347d = z;
        if (z) {
            return;
        }
        if (this.k != null) {
            this.k.cancel(true);
            this.k = null;
        }
        this.f348e = null;
    }

    private void c(Session session, int i2, String str) {
        SessionInfo sessionInfo = this.f346c;
        if (sessionInfo == null || !sessionInfo.isAccs) {
            return;
        }
        ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByCallBack", null, new Object[0]);
        Intent intent = new Intent("com.taobao.ACCS_CONNECT_INFO");
        intent.putExtra("command", 103);
        intent.putExtra("host", session.getHost());
        intent.putExtra(Constants.KEY_CENTER_HOST, true);
        boolean zIsAvailable = session.isAvailable();
        if (!zIsAvailable) {
            intent.putExtra("errorCode", i2);
            intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
        }
        intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, zIsAvailable);
        intent.putExtra(Constants.KEY_TYPE_INAPP, true);
        this.f344a.f340h.notifyListener(intent);
    }

    public synchronized void a(Context context, int i2, String str, SessionGetCallback sessionGetCallback, long j) {
        Session sessionA = this.f345b.a(this, i2);
        if (sessionA != null) {
            ALog.d("awcn.SessionRequest", "Available Session exist!!!", str, new Object[0]);
            if (sessionGetCallback != null) {
                sessionGetCallback.onSessionGetSuccess(sessionA);
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = anet.channel.util.i.a(null);
        }
        ALog.d("awcn.SessionRequest", "SessionRequest start", str, "host", this.f352i, "type", Integer.valueOf(i2));
        if (this.f347d) {
            ALog.d("awcn.SessionRequest", "session connecting", str, "host", a());
            if (sessionGetCallback != null) {
                if (b() == i2) {
                    c cVar = new c(sessionGetCallback);
                    synchronized (this.f350g) {
                        this.f350g.put(sessionGetCallback, cVar);
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(cVar, j, TimeUnit.MILLISECONDS);
                } else {
                    sessionGetCallback.onSessionGetFail();
                }
            }
            return;
        }
        a(true);
        this.k = ThreadPoolExecutorFactory.submitScheduledTask(new b(str), 45L, TimeUnit.SECONDS);
        SessionConnStat sessionConnStat = new SessionConnStat();
        this.f351h = sessionConnStat;
        sessionConnStat.start = System.currentTimeMillis();
        if (!NetworkStatusHelper.isConnected()) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "network is not available, can't create session", str, "isConnected", Boolean.valueOf(NetworkStatusHelper.isConnected()));
            }
            c();
            throw new RuntimeException("no network");
        }
        List<IConnStrategy> listA = a(i2, str);
        if (!listA.isEmpty()) {
            List<anet.channel.entity.a> listA2 = a(listA, str);
            try {
                anet.channel.entity.a aVarRemove = listA2.remove(0);
                a(context, aVarRemove, new a(context, listA2, aVarRemove), aVarRemove.h());
                if (sessionGetCallback != null) {
                    c cVar2 = new c(sessionGetCallback);
                    synchronized (this.f350g) {
                        this.f350g.put(sessionGetCallback, cVar2);
                    }
                    ThreadPoolExecutorFactory.submitScheduledTask(cVar2, j, TimeUnit.MILLISECONDS);
                }
            } catch (Throwable unused) {
                c();
            }
            return;
        }
        ALog.i("awcn.SessionRequest", "no avalible strategy, can't create session", str, "host", this.f352i, "type", Integer.valueOf(i2));
        c();
        throw new NoAvailStrategyException("no avalible strategy");
    }

    public void b(boolean z) {
        ALog.d("awcn.SessionRequest", "closeSessions", this.f344a.f335c, "host", this.f352i, "autoCreate", Boolean.valueOf(z));
        if (!z && this.f348e != null) {
            this.f348e.u = false;
            this.f348e.close(false);
        }
        List<Session> listA = this.f345b.a(this);
        if (listA != null) {
            for (Session session : listA) {
                if (session != null) {
                    session.close(z);
                }
            }
        }
    }

    public void a(Session session) {
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = "policy";
        alarmObject.arg = this.f352i;
        alarmObject.isSuccess = true;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        this.f351h.syncValueFromSession(session);
        SessionConnStat sessionConnStat = this.f351h;
        sessionConnStat.ret = 1;
        sessionConnStat.totalTime = System.currentTimeMillis() - this.f351h.start;
        AppMonitor.getInstance().commitStat(this.f351h);
    }

    public int b() {
        Session session = this.f348e;
        if (session != null) {
            return session.j.getType();
        }
        return -1;
    }

    private void b(Session session, int i2, String str) {
        SessionInfo sessionInfo;
        Context context = GlobalAppRuntimeInfo.getContext();
        if (context == null || (sessionInfo = this.f346c) == null || !sessionInfo.isAccs) {
            return;
        }
        ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, new Object[0]);
        try {
            Intent intent = new Intent(Constants.ACTION_RECEIVE);
            intent.setPackage(context.getPackageName());
            intent.setClassName(context, "com.taobao.accs.data.MsgDistributeService");
            intent.putExtra("command", 103);
            intent.putExtra("host", session.getHost());
            intent.putExtra(Constants.KEY_CENTER_HOST, true);
            boolean zIsAvailable = session.isAvailable();
            if (!zIsAvailable) {
                intent.putExtra("errorCode", i2);
                intent.putExtra(Constants.KEY_ERROR_DETAIL, str);
            }
            intent.putExtra(Constants.KEY_CONNECT_AVAILABLE, zIsAvailable);
            intent.putExtra(Constants.KEY_TYPE_INAPP, true);
            if (Build.VERSION.SDK_INT >= 26) {
                context.bindService(intent, new h(this, intent, context), 1);
            } else {
                context.startService(intent);
            }
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "sendConnectInfoToAccsByService", null, th, new Object[0]);
        }
    }

    public void a(Session session, int i2, int i3) {
        if (256 != i2 || i3 == -2613 || i3 == -2601) {
            return;
        }
        AlarmObject alarmObject = new AlarmObject();
        alarmObject.module = "networkPrefer";
        alarmObject.modulePoint = "policy";
        alarmObject.arg = this.f352i;
        alarmObject.errorCode = String.valueOf(i3);
        alarmObject.isSuccess = false;
        AppMonitor.getInstance().commitAlarm(alarmObject);
        SessionConnStat sessionConnStat = this.f351h;
        sessionConnStat.ret = 0;
        sessionConnStat.appendErrorTrace(i3);
        this.f351h.errorCode = String.valueOf(i3);
        this.f351h.totalTime = System.currentTimeMillis() - this.f351h.start;
        this.f351h.syncValueFromSession(session);
        AppMonitor.getInstance().commitStat(this.f351h);
    }

    private List<IConnStrategy> a(int i2, String str) {
        List<IConnStrategy> connStrategyListByHost = Collections.EMPTY_LIST;
        try {
            HttpUrl httpUrl = HttpUrl.parse(a());
            if (httpUrl == null) {
                return connStrategyListByHost;
            }
            connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(httpUrl.host());
            if (!connStrategyListByHost.isEmpty()) {
                boolean zEqualsIgnoreCase = "https".equalsIgnoreCase(httpUrl.scheme());
                boolean zB = anet.channel.util.c.b();
                ListIterator<IConnStrategy> listIterator = connStrategyListByHost.listIterator();
                while (listIterator.hasNext()) {
                    IConnStrategy next = listIterator.next();
                    ConnType connTypeValueOf = ConnType.valueOf(next.getProtocol());
                    if (connTypeValueOf != null) {
                        if (connTypeValueOf.isSSL() == zEqualsIgnoreCase && (i2 == anet.channel.entity.c.f464c || connTypeValueOf.getType() == i2)) {
                            if (zB && anet.channel.strategy.utils.c.b(next.getIp())) {
                                listIterator.remove();
                            }
                        }
                        listIterator.remove();
                    }
                }
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.SessionRequest", "[getAvailStrategy]", str, "strategies", connStrategyListByHost);
            }
        } catch (Throwable th) {
            ALog.e("awcn.SessionRequest", "", str, th, new Object[0]);
        }
        return connStrategyListByHost;
    }

    private List<anet.channel.entity.a> a(List<IConnStrategy> list, String str) {
        if (list.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            IConnStrategy iConnStrategy = list.get(i3);
            int retryTimes = iConnStrategy.getRetryTimes();
            for (int i4 = 0; i4 <= retryTimes; i4++) {
                i2++;
                anet.channel.entity.a aVar = new anet.channel.entity.a(a(), str + "_" + i2, iConnStrategy);
                aVar.f455b = i4;
                aVar.f456c = retryTimes;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, anet.channel.entity.a aVar, IConnCb iConnCb, String str) {
        ConnType connTypeC = aVar.c();
        if (context != null && !connTypeC.isHttpType()) {
            TnetSpdySession tnetSpdySession = new TnetSpdySession(context, aVar);
            tnetSpdySession.initConfig(this.f344a.f336d);
            tnetSpdySession.initSessionInfo(this.f346c);
            tnetSpdySession.setTnetPublicKey(this.f344a.f339g.c(this.j));
            this.f348e = tnetSpdySession;
        } else {
            this.f348e = new anet.channel.session.d(context, aVar);
        }
        ALog.i("awcn.SessionRequest", "create connection...", str, "Host", a(), "Type", aVar.c(), "IP", aVar.a(), "Port", Integer.valueOf(aVar.b()), "heartbeat", Integer.valueOf(aVar.g()), "session", this.f348e);
        a(this.f348e, iConnCb, System.currentTimeMillis());
        this.f348e.connect();
        SessionConnStat sessionConnStat = this.f351h;
        sessionConnStat.retryTimes++;
        sessionConnStat.startConnect = System.currentTimeMillis();
        SessionConnStat sessionConnStat2 = this.f351h;
        if (sessionConnStat2.retryTimes == 0) {
            sessionConnStat2.putExtra("firstIp", aVar.a());
        }
    }

    private void a(Session session, IConnCb iConnCb, long j) {
        if (iConnCb == null) {
            return;
        }
        session.registerEventcb(EventType.ALL, new f(this, iConnCb, j));
        session.registerEventcb(1792, new g(this, session));
    }

    public void a(String str) {
        ALog.d("awcn.SessionRequest", "reCreateSession", str, "host", this.f352i);
        b(true);
    }

    public void a(long j) throws InterruptedException, TimeoutException {
        ALog.d("awcn.SessionRequest", "[await]", null, "timeoutMs", Long.valueOf(j));
        if (j <= 0) {
            return;
        }
        synchronized (this.l) {
            long jCurrentTimeMillis = System.currentTimeMillis() + j;
            while (this.f347d) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (jCurrentTimeMillis2 >= jCurrentTimeMillis) {
                    break;
                } else {
                    this.l.wait(jCurrentTimeMillis - jCurrentTimeMillis2);
                }
            }
            if (this.f347d) {
                throw new TimeoutException();
            }
        }
    }

    public void a(Session session, int i2, String str) {
        if (AwcnConfig.isSendConnectInfoByService()) {
            b(session, i2, str);
        }
        c(session, i2, str);
    }
}
