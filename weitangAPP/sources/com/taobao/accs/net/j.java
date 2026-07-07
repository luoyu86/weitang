package com.taobao.accs.net;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import anet.channel.DataFrameCb;
import anet.channel.IAuth;
import anet.channel.ISessionListener;
import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionInfo;
import anet.channel.request.Request;
import anet.channel.session.TnetSpdySession;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.logger.ILog;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsException;
import com.taobao.accs.AccsState;
import com.taobao.accs.ConnectionListener;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.AccsLogger;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j extends b implements DataFrameCb, ISessionListener {
    private boolean n;
    private long o;
    private ScheduledFuture<?> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ScheduledFuture<?> f10379q;
    private boolean r;
    private ErrorCode s;
    private final ILog t;
    private final Runnable u;
    private final Runnable v;
    private final Runnable w;
    private final Set<String> x;

    public static class a implements IAuth {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f10382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final b f10383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ILog f10384e;

        public a(b bVar, String str) {
            this.f10382c = bVar.d();
            this.f10380a = bVar.c("https://" + str + "/accs/");
            this.f10381b = bVar.f10353c;
            this.f10383d = bVar;
            this.f10384e = AccsLogger.getLogger(bVar.d());
        }

        @Override // anet.channel.IAuth
        public void auth(Session session, IAuth.AuthCallback authCallback) {
            this.f10384e.i("auth", "URL", this.f10380a);
            session.request(new Request.Builder().setUrl(this.f10380a).build(), new s(this, authCallback));
        }
    }

    public j(Context context, int i2, String str) {
        super(context, i2, str);
        this.n = true;
        this.o = 3600000L;
        this.r = false;
        this.s = null;
        this.u = new k(this);
        this.v = new l(this);
        q qVar = new q(this);
        this.w = qVar;
        this.x = Collections.synchronizedSet(new HashSet());
        ILog logger = AccsLogger.getLogger(d());
        this.t = logger;
        if (!OrangeAdapter.isTnetLogOff(true)) {
            String strD = UtilityImpl.d(this.f10354d, "inapp");
            logger.d("config tnet log path:" + strD);
            if (!TextUtils.isEmpty(strD)) {
                Session.configTnetALog(context, strD, UtilityImpl.TNET_FILE_SIZE, 5);
            }
        }
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag == null || !configByTag.isChannelLoopStart()) {
            logger.d("channel delay start");
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(qVar, 120000L, TimeUnit.MILLISECONDS);
        } else {
            logger.d("channel loop start");
            ThreadPoolExecutorFactory.getScheduledExecutor().scheduleWithFixedDelay(qVar, 120000L, configByTag.getLoopInterval(), TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f10359i.isAccsHeartbeatEnable()) {
            ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
            Runnable runnable = this.v;
            long j = this.o;
            this.p = scheduledExecutor.scheduleAtFixedRate(runnable, j, j, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        s();
        this.t.i("startReconnectTask");
        this.f10379q = ThreadPoolExecutorFactory.getScheduledExecutor().scheduleWithFixedDelay(this.u, 120L, 120L, TimeUnit.SECONDS);
    }

    private void s() {
        ScheduledFuture<?> scheduledFuture = this.f10379q;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f10379q = null;
        }
    }

    @Override // com.taobao.accs.net.b
    public void a(boolean z, boolean z2) {
    }

    @Override // com.taobao.accs.net.b
    public com.taobao.accs.ut.a.c c() {
        return null;
    }

    @Override // com.taobao.accs.net.b
    public void e() {
        this.t.e("shut down");
        this.n = false;
    }

    @Override // com.taobao.accs.net.b
    public boolean l() {
        return this.r;
    }

    @Override // com.taobao.accs.net.b
    public int m() {
        ErrorCode errorCode = this.s;
        if (errorCode != null) {
            return errorCode.getCodeInt();
        }
        return 0;
    }

    @Override // com.taobao.accs.net.b
    public void n() {
        try {
            SessionCenter sessionCenter = SessionCenter.getInstance(this.f10359i.getAppKey());
            if (sessionCenter == null) {
                return;
            }
            String inappHost = this.f10359i.getInappHost();
            sessionCenter.unregisterSessionInfo(inappHost);
            if (this.x.contains(inappHost)) {
                this.x.remove(inappHost);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.taobao.accs.net.b
    public void o() {
        this.t.i("reconnect begin");
        this.f10357g = false;
        a(this.f10354d);
        ThreadPoolExecutorFactory.getSendScheduledExecutor().execute(new r(this));
    }

    @Override // anet.channel.ISessionListener
    public void onConnectionChanged(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
        String stringExtra = intent.getStringExtra("host");
        ErrorCode errorCode = Constants.getErrorCode(intent);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        if (booleanExtra) {
            this.t.i("InAppConnection Available. last status", Boolean.valueOf(this.r));
            s();
            if (!this.r) {
                b(this.f10354d);
            }
        } else {
            if (errorCode.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt()) {
                errorCode = UtilityImpl.g(this.f10354d) ? AccsErrorCode.INAPP_CON_DISCONNECTED.copy().detail(AccsErrorCode.getAllDetails("lost connect")).build() : AccsErrorCode.NO_NETWORK.copy().detail(AccsErrorCode.getAllDetails("lost connect")).build();
            }
            this.t.e("InAppConnection Not Available ", BaseMonitor.COUNT_ERROR, errorCode);
            r();
        }
        this.r = booleanExtra;
        this.s = errorCode;
        if (errorCode == null || errorCode.getCodeInt() == AccsErrorCode.SUCCESS.getCodeInt()) {
            AccsState.getInstance().b(AccsState.CONNECTION_CHANGE, OperatorName.CLOSE_PATH + stringExtra + PDPageLabelRange.STYLE_LETTERS_LOWER + booleanExtra);
        } else {
            AccsState.getInstance().b(AccsState.CONNECTION_CHANGE, OperatorName.CLOSE_PATH + stringExtra + PDPageLabelRange.STYLE_LETTERS_LOWER + booleanExtra + OperatorName.CURVE_TO + errorCode.getCodeInt());
            AccsState.getInstance().b("re", Integer.valueOf(errorCode.getCodeInt()));
        }
        a(booleanExtra, errorCode);
    }

    @Override // anet.channel.DataFrameCb
    public void onDataReceive(TnetSpdySession tnetSpdySession, byte[] bArr, int i2, int i3) {
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new o(this, i3, i2, bArr, tnetSpdySession));
    }

    @Override // anet.channel.DataFrameCb
    public void onException(int i2, int i3, boolean z, String str) {
        this.t.e("onException", Constants.KEY_DATA_ID, Integer.valueOf(i2), "errorId", Integer.valueOf(i3), "needRetry", Boolean.valueOf(z), "detail", str);
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new p(this, i3, str, i2, z));
    }

    @Override // com.taobao.accs.net.b
    public synchronized void a() {
        this.t.d(RequestBannerParamBo.GET_SPLASH_TYPE);
        this.n = true;
        a(this.f10354d);
    }

    @Override // com.taobao.accs.net.b
    public void b() {
        this.f10356f = 0;
    }

    @Override // com.taobao.accs.net.b
    public String d() {
        return "InAppConn_" + this.m;
    }

    @Override // com.taobao.accs.net.b
    public void a(Message message, boolean z) {
        if (this.n && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size() <= 1000) {
                    long j = message.Q;
                    if (j <= 0) {
                        j = 1;
                    }
                    ScheduledFuture<?> scheduledFutureSchedule = ThreadPoolExecutorFactory.getSendScheduledExecutor().schedule(new m(this, message), j, TimeUnit.MILLISECONDS);
                    if (message.a() == 1 && message.O != null) {
                        if (message.c() && a(message.O)) {
                            this.f10355e.b(message);
                        }
                        this.f10355e.f10288a.put(message.O, scheduledFutureSchedule);
                    }
                    NetPerformanceMonitor netPerformanceMonitorE = message.e();
                    if (netPerformanceMonitorE != null) {
                        netPerformanceMonitorE.setDeviceId(UtilityImpl.getDeviceId(this.f10354d));
                        netPerformanceMonitorE.setConnType(this.f10353c);
                        netPerformanceMonitorE.onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                int size = ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size();
                ErrorCode errorCodeBuild = AccsErrorCode.MESSAGE_QUEUE_FULL.copy().detail("inapp " + size).build();
                this.f10355e.a(message, errorCodeBuild);
                this.t.e("send queue full", NotificationCompat.CATEGORY_ERROR, errorCodeBuild);
                return;
            } catch (Throwable th) {
                this.t.e("send error", th);
                this.f10355e.a(message, AccsErrorCode.SEND_LOCAL_EXCEPTION.copy().detail(AccsErrorCode.getExceptionInfo(th)).build());
                return;
            }
        }
        this.t.w("not running or msg null! " + this.n);
    }

    @Override // com.taobao.accs.net.b
    public void a(String str, boolean z, long j) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new n(this, str, j, z), j, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.net.b
    public void a(String str, boolean z, String str2) {
        Session session;
        try {
            Message messageB = this.f10355e.b(str);
            if (messageB != null && messageB.f10269f != null && (session = SessionCenter.getInstance(this.f10359i.getAppKey()).get(messageB.f10269f.toString(), 0L)) != null) {
                if (z) {
                    session.close(true);
                } else {
                    session.ping(true);
                }
            }
        } catch (Exception e2) {
            this.t.e("onTimeOut", e2);
        }
    }

    @Override // com.taobao.accs.net.b
    public boolean a(String str) {
        if (str == null) {
            return false;
        }
        ScheduledFuture<?> scheduledFuture = this.f10355e.f10288a.get(str);
        boolean zCancel = scheduledFuture != null ? scheduledFuture.cancel(false) : false;
        if (zCancel) {
            this.t.i("cancel", "customDataId", str);
        }
        return zCancel;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.t.e("onReceiveAccsHeartbeatResp response data is null");
            return;
        }
        this.t.i("onReceiveAccsHeartbeatResp", "data", jSONObject);
        try {
            int i2 = jSONObject.getInt("timeInterval");
            if (i2 == -1) {
                ScheduledFuture<?> scheduledFuture = this.p;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                }
            } else {
                long j = i2 * 1000;
                if (this.o != j) {
                    if (i2 == 0) {
                        j = 3600000;
                    }
                    this.o = j;
                    ScheduledThreadPoolExecutor scheduledExecutor = ThreadPoolExecutorFactory.getScheduledExecutor();
                    Runnable runnable = this.v;
                    long j2 = this.o;
                    this.p = scheduledExecutor.scheduleAtFixedRate(runnable, j2, j2, TimeUnit.MILLISECONDS);
                }
            }
        } catch (JSONException e2) {
            this.t.e("onReceiveAccsHeartbeatResp", e2);
        }
    }

    @Override // com.taobao.accs.net.b
    public void a(Context context) {
        try {
            if (this.f10357g) {
                return;
            }
            super.a(context);
            String inappHost = this.f10359i.getInappHost();
            boolean z = false;
            if (h() && this.f10359i.isKeepalive()) {
                z = true;
            } else {
                this.t.d("initAwcn close keep alive");
            }
            a(SessionCenter.getInstance(this.f10359i.getAppKey()), inappHost, z);
            this.f10357g = true;
            this.t.i("initAwcn success!");
        } catch (Throwable th) {
            this.t.e("initAwcn", th);
        }
    }

    public void a(SessionCenter sessionCenter, String str, boolean z) {
        if (this.x.contains(str)) {
            return;
        }
        SessionInfo sessionInfoCreate = SessionInfo.create(str, z, true, new a(this, str), null, this);
        sessionCenter.registerAccsSessionListener(this);
        sessionCenter.registerPublicKey(str, this.f10359i.getInappPubKey());
        sessionCenter.registerSessionInfo(sessionInfoCreate);
        this.x.add(str);
        this.t.i("registerSessionInfo", "host", str);
    }

    public void a(AccsClientConfig accsClientConfig) {
        if (accsClientConfig == null) {
            this.t.i("updateConfig null");
            return;
        }
        if (accsClientConfig.equals(this.f10359i)) {
            this.t.i("updateConfig not any changed");
            return;
        }
        try {
            boolean z = false;
            this.t.i("updateConfig", "old", this.f10359i, "new", accsClientConfig);
            String inappHost = this.f10359i.getInappHost();
            String inappHost2 = accsClientConfig.getInappHost();
            SessionCenter sessionCenter = SessionCenter.getInstance(this.f10359i.getAppKey());
            if (sessionCenter == null) {
                this.t.d("old session not exist, no need update");
                return;
            }
            sessionCenter.unregisterSessionInfo(inappHost);
            if (this.x.contains(inappHost)) {
                this.x.remove(inappHost);
            }
            String appKey = this.f10359i.getAppKey();
            this.f10359i = accsClientConfig;
            this.f10352b = accsClientConfig.getAppKey();
            this.m = this.f10359i.getTag();
            if (!appKey.equals(this.f10352b)) {
                sessionCenter = SessionCenter.getInstance(this.f10352b);
            }
            if (h() && this.f10359i.isKeepalive()) {
                z = true;
            } else {
                this.t.i("updateConfig close keepalive");
            }
            a(sessionCenter, inappHost2, z);
            this.t.i("updateConfig done");
        } catch (Throwable th) {
            this.t.e("updateConfig", th);
        }
    }

    private void a(boolean z, ErrorCode errorCode) {
        try {
            for (ConnectionListener connectionListener : ACCSClient.getAccsClient(this.m).getConnectionListeners()) {
                if (z) {
                    connectionListener.onConnect();
                } else {
                    connectionListener.onDisconnect(errorCode.getCodeInt(), errorCode.getMsg());
                }
            }
        } catch (AccsException e2) {
            e2.printStackTrace();
        }
    }
}
