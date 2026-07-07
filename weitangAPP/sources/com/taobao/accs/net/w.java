package com.taobao.accs.net;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.strategy.IConnStrategy;
import anet.channel.util.HttpConstant;
import com.alibaba.sdk.android.error.ErrorCode;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.Spdycb;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* JADX INFO: loaded from: classes2.dex */
public class w extends b implements SessionCb, Spdycb {
    private final Object A;
    private long B;
    private long C;
    private long D;
    private long E;
    private int F;
    private String G;
    private SessionMonitor H;
    private com.taobao.accs.ut.a.c I;
    private boolean J;
    private String K;
    private boolean L;
    private g M;
    private String N;
    public ScheduledFuture<?> n;
    public String o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f10409q;
    public int r;
    private int s;
    private final LinkedList<Message> t;
    private a u;
    private boolean v;
    private String w;
    private String x;
    private SpdyAgent y;
    private SpdySession z;

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f10411b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f10413d;

        public a(String str) {
            super(str);
            this.f10413d = getName();
            this.f10410a = 0;
        }

        private void a(boolean z) {
            if (w.this.s == 1) {
                if (w.this.s != 1 || System.currentTimeMillis() - this.f10411b <= 5000) {
                    return;
                }
                this.f10410a = 0;
                return;
            }
            ALog.d(w.this.d(), "tryConnect", TTDownloadField.TT_FORCE, Boolean.valueOf(z));
            if (z) {
                this.f10410a = 0;
            }
            ALog.i(this.f10413d, "tryConnect", TTDownloadField.TT_FORCE, Boolean.valueOf(z), "failTimes", Integer.valueOf(this.f10410a));
            if (w.this.s != 1 && this.f10410a >= 4) {
                w.this.J = true;
                ALog.e(this.f10413d, "tryConnect fail", "maxTimes", 4);
                return;
            }
            if (w.this.s != 1) {
                if (w.this.f10353c == 1 && this.f10410a == 0) {
                    ALog.i(this.f10413d, "tryConnect in app, no sleep", new Object[0]);
                } else {
                    ALog.i(this.f10413d, "tryConnect, need sleep", new Object[0]);
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                w.this.K = "";
                if (this.f10410a == 3) {
                    w.this.M.b(w.this.r());
                }
                w.this.d((String) null);
                w.this.H.setRetryTimes(this.f10410a);
                if (w.this.s == 1) {
                    this.f10411b = System.currentTimeMillis();
                    return;
                }
                this.f10410a++;
                ALog.e(this.f10413d, "try connect fail, ready for reconnect", new Object[0]);
                a(false);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0062 A[Catch: all -> 0x04fa, TryCatch #14 {, blocks: (B:7:0x0027, B:9:0x0033, B:15:0x004d, B:17:0x0062, B:19:0x0074, B:21:0x007c, B:12:0x0047, B:13:0x004a), top: B:221:0x0027, inners: #0 }] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 1283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.w.a.run():void");
        }
    }

    public w(Context context, int i2, String str) {
        super(context, i2, str);
        this.s = 3;
        this.t = new LinkedList<>();
        this.v = true;
        this.y = null;
        this.z = null;
        this.A = new Object();
        this.F = -1;
        this.G = null;
        this.J = false;
        this.K = "";
        this.L = false;
        this.M = new g(r());
        w();
    }

    private int t() {
        boolean zK = k();
        if (AccsClientConfig.mEnv == 2) {
            return 0;
        }
        int channelPubKey = this.f10359i.getChannelPubKey();
        if (channelPubKey <= 0) {
            return zK ? 4 : 3;
        }
        ALog.i(d(), "getPublicKeyType use custom pub key", "pubKey", Integer.valueOf(channelPubKey));
        return channelPubKey;
    }

    private void u() {
        if (this.z == null) {
            c(3);
            return;
        }
        try {
            String strEncode = URLEncoder.encode(UtilityImpl.getDeviceId(this.f10354d));
            String strA = UtilityImpl.a(i(), this.f10359i.getAppSecret(), UtilityImpl.getDeviceId(this.f10354d));
            String strC = c(this.w);
            ALog.i(d(), "auth", AgooConstants.OPEN_URL, strC);
            this.x = strC;
            if (a(strEncode, i(), strA)) {
                new URL(strC);
                SpdyRequest spdyRequest = new SpdyRequest(new URL(strC), "GET", RequestPriority.DEFAULT_PRIORITY, MediationConstant.ErrorCode.ADN_INIT_FAIL, b.ACCS_RECEIVE_TIMEOUT);
                spdyRequest.setDomain(r());
                this.z.submitRequest(spdyRequest, new SpdyDataProvider((byte[]) null), r(), this);
                return;
            }
            ErrorCode errorCodeBuild = AccsErrorCode.SPDY_AUTH_PARAM_ERROR.copy().detail("device " + strEncode + " key " + i() + " sign " + strA).build();
            ALog.e(d(), "auth param error!", "code", errorCodeBuild);
            a(errorCodeBuild);
        } catch (Throwable th) {
            ALog.e(d(), "auth exception ", th, new Object[0]);
            a(AccsErrorCode.SPDY_AUTH_EXCEPTION.copy().detail(AccsErrorCode.getExceptionInfo(th)).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v() {
        if (this.f10353c == 1) {
            return;
        }
        this.B = System.currentTimeMillis();
        this.C = System.nanoTime();
        f.a(this.f10354d).a();
    }

    private void w() {
        try {
            SpdyAgent.enableDebug = true;
            this.y = SpdyAgent.getInstance(this.f10354d, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
            if (!SpdyAgent.checkLoadSucc()) {
                ALog.e(d(), "initClient", new Object[0]);
                com.taobao.accs.utl.f.b();
                return;
            }
            com.taobao.accs.utl.f.a();
            if (!k()) {
                this.y.setAccsSslCallback(new aa(this));
            }
            if (OrangeAdapter.isTnetLogOff(false)) {
                return;
            }
            String str = this.f10353c == 0 ? "service" : "inapp";
            ALog.d(d(), "into--[setTnetLogPath]", new Object[0]);
            String strD = UtilityImpl.d(this.f10354d, str);
            ALog.d(d(), "config tnet log path:" + strD, new Object[0]);
            if (TextUtils.isEmpty(strD)) {
                return;
            }
            this.y.configLogFile(strD, UtilityImpl.TNET_FILE_SIZE, 5);
        } catch (Throwable th) {
            ALog.e(d(), "initClient", th, new Object[0]);
        }
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i2) {
        ALog.w(d(), "bioPingRecvCallback uniId:" + i2, new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        return UtilityImpl.a(this.f10354d, this.f10352b, spdySession.getDomain());
    }

    @Override // com.taobao.accs.net.b
    public boolean h() {
        return false;
    }

    @Override // com.taobao.accs.net.b
    public boolean l() {
        return this.s == 1;
    }

    @Override // com.taobao.accs.net.b
    public int m() {
        return 0;
    }

    @Override // com.taobao.accs.net.b
    public void n() {
        q();
    }

    @Override // com.taobao.accs.net.b
    public void o() {
        a(true, false);
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        return UtilityImpl.a(this.f10354d, this.f10352b, spdySession.getDomain(), bArr);
    }

    public void q() {
        ALog.e(d(), " force close!", new Object[0]);
        try {
            this.z.closeSession();
            this.H.setCloseType(1);
        } catch (Exception unused) {
        }
        c(3);
    }

    public String r() {
        String channelHost = this.f10359i.getChannelHost();
        ALog.i(d(), "getChannelHost", "host", channelHost);
        return channelHost == null ? "" : channelHost;
    }

    public boolean s() {
        return this.v;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        b(i2);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        v();
        ALog.i(d(), "onFrame", "type", Integer.valueOf(i3), "len", Integer.valueOf(bArr.length));
        StringBuilder sb = new StringBuilder();
        if (ALog.isPrintLog(ALog.Level.D) && bArr.length < 512) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (byte b2 : bArr) {
                sb.append(Integer.toHexString(b2 & 255));
                sb.append(" ");
            }
            ALog.d(d(), ((Object) sb) + " log time:" + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        }
        if (i3 == 200) {
            try {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                this.f10355e.a(bArr);
                com.taobao.accs.ut.a.d dVarG = this.f10355e.g();
                if (dVarG != null) {
                    dVarG.f10442c = String.valueOf(jCurrentTimeMillis2);
                    dVarG.f10446g = this.f10353c == 0 ? "service" : "inapp";
                    dVarG.a();
                }
            } catch (Throwable th) {
                ALog.e(d(), "onDataReceive ", th, new Object[0]);
                UTMini.getInstance().commitEvent(66001, "SERVICE_DATA_RECEIVE", UtilityImpl.a(th));
            }
            ALog.d(d(), "try handle msg", new Object[0]);
            g();
        } else {
            ALog.e(d(), "drop frame", "len", Integer.valueOf(bArr.length));
        }
        ALog.d(d(), "spdyCustomControlFrameRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
        ALog.d(d(), "spdyDataChunkRecvCB", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i2, Object obj) {
        ALog.d(d(), "spdyDataRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i2, Object obj) {
        ALog.d(d(), "spdyDataSendCallback", new Object[0]);
    }

    @Override // org.android.spdy.Spdycb
    public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
        this.B = System.currentTimeMillis();
        this.C = System.nanoTime();
        try {
            Map<String, String> mapA = UtilityImpl.a(map);
            ALog.d("SilenceConn_", "spdyOnStreamResponse", "header", map);
            int i2 = Integer.parseInt(mapA.get(HttpConstant.STATUS));
            if (i2 == 200) {
                ALog.i(d(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(i2));
                c(1);
                String str = mapA.get("x-at");
                if (!TextUtils.isEmpty(str)) {
                    this.k = str;
                }
                SessionMonitor sessionMonitor = this.H;
                sessionMonitor.auth_time = sessionMonitor.connection_stop_date > 0 ? System.currentTimeMillis() - this.H.connection_stop_date : 0L;
                String str2 = this.f10353c == 0 ? "service" : "inapp";
                UTMini.getInstance().commitEvent(66001, "CONNECTED 200 " + str2, this.x, this.K, Integer.valueOf(Constants.SDK_VERSION_CODE), "0");
                AppMonitorAdapter.commitAlarmSuccess("accs", "auth", "");
            } else {
                ALog.e(d(), "spdyOnStreamResponse", "httpStatusCode", Integer.valueOf(i2));
                a(AccsErrorCode.NETWORKSDK_SPDY_RES_ERROR.copy().detail("channel code " + i2).build());
            }
        } catch (Exception e2) {
            ALog.e(d(), e2.toString(), new Object[0]);
            q();
            this.H.setCloseReason("exception");
        }
        ALog.d(d(), "spdyOnStreamResponse", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        ALog.d(d(), "spdyPingRecvCallback uniId:" + j, new Object[0]);
        if (j < 0) {
            return;
        }
        this.f10355e.b();
        f.a(this.f10354d).e();
        f.a(this.f10354d).a();
        this.H.onPingCBReceive();
        if (this.H.ping_rec_times % 2 == 0) {
            UtilityImpl.a(this.f10354d, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        }
    }

    @Override // org.android.spdy.Spdycb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j, Object obj) {
        ALog.d(d(), "spdyRequestRecvCallback", new Object[0]);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        ALog.e(d(), "spdySessionCloseCallback", "errorCode", Integer.valueOf(i2));
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e(d(), "session cleanUp has exception: " + e2, new Object[0]);
            }
        }
        c(3);
        this.H.onCloseConnect();
        if (this.H.getConCloseDate() > 0 && this.H.getConStopDate() > 0) {
            this.H.getConCloseDate();
            this.H.getConStopDate();
        }
        this.H.setCloseReason(this.H.getCloseReason() + "tnet error:" + i2);
        if (superviseConnectInfo != null) {
            this.H.live_time = superviseConnectInfo.keepalive_period_second;
        }
        AppMonitor.getInstance().commitStat(this.H);
        for (Message message : this.f10355e.e()) {
            if (message.e() != null) {
                message.e().setFailReason("session close");
                AppMonitor.getInstance().commitStat(message.e());
            }
        }
        String str = this.f10353c == 0 ? "service" : "inapp";
        ALog.d(d(), "spdySessionCloseCallback, conKeepTime:" + this.H.live_time + " connectType:" + str, new Object[0]);
        UTMini uTMini = UTMini.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("DISCONNECT CLOSE ");
        sb.append(str);
        uTMini.commitEvent(66001, sb.toString(), Integer.valueOf(i2), Long.valueOf(this.H.live_time), Integer.valueOf(Constants.SDK_VERSION_CODE), this.x, this.K);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        this.F = superviseConnectInfo.connectTime;
        int i2 = superviseConnectInfo.handshakeTime;
        ALog.i(d(), "spdySessionConnectCB", "sessionConnectInterval", Integer.valueOf(this.F), "sslTime", Integer.valueOf(i2), "reuse", Integer.valueOf(superviseConnectInfo.sessionTicketReused));
        u();
        this.H.setRet(true);
        this.H.onConnectStop();
        SessionMonitor sessionMonitor = this.H;
        sessionMonitor.tcp_time = this.F;
        sessionMonitor.ssl_time = i2;
        String str = this.f10353c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED " + str + " " + superviseConnectInfo.sessionTicketReused, String.valueOf(this.F), String.valueOf(i2), Integer.valueOf(Constants.SDK_VERSION_CODE), String.valueOf(superviseConnectInfo.sessionTicketReused), this.x, this.K);
        AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_POINT_CONNECT, "");
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e(d(), "session cleanUp has exception: " + e2, new Object[0]);
            }
        }
        a aVar = this.u;
        int i3 = aVar != null ? aVar.f10410a : 0;
        ALog.e(d(), "spdySessionFailedError", "retryTimes", Integer.valueOf(i3), "errorId", Integer.valueOf(i2));
        this.J = false;
        this.L = true;
        c(3);
        this.H.setFailReason(i2);
        this.H.onConnectStop();
        String str = this.f10353c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "DISCONNECT " + str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(Constants.SDK_VERSION_CODE), this.x, this.K);
        AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_CONNECT, "retrytimes:" + i3, i2 + "", "");
    }

    @Override // org.android.spdy.Spdycb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i2, Object obj, SuperviseData superviseData) {
        ALog.d(d(), "spdyStreamCloseCallback", new Object[0]);
        if (i2 != 0) {
            ALog.e(d(), "spdyStreamCloseCallback", "statusCode", Integer.valueOf(i2));
            a(AccsErrorCode.NETWORKSDK_SPDY_CLOSE_ERROR.copy().detail("channel code " + i2).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        SessionInfo sessionInfo;
        int i2 = this.s;
        if (i2 == 2 || i2 == 1) {
            return;
        }
        if (this.M == null) {
            this.M = new g(r());
        }
        List<IConnStrategy> listA = this.M.a(r());
        int port = Constants.PORT;
        if (listA == null || listA.size() <= 0) {
            if (str != null) {
                this.o = str;
            } else {
                this.o = r();
            }
            if (System.currentTimeMillis() % 2 == 0) {
                port = 80;
            }
            this.p = port;
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_DNS, "localdns", 0.0d);
            ALog.i(d(), "connect get ip from amdc fail!!", new Object[0]);
        } else {
            for (IConnStrategy iConnStrategy : listA) {
                if (iConnStrategy != null) {
                    ALog.i(d(), BaseMonitor.ALARM_POINT_CONNECT, "ip", iConnStrategy.getIp(), "port", Integer.valueOf(iConnStrategy.getPort()));
                }
            }
            if (this.L) {
                this.M.b();
                this.L = false;
            }
            IConnStrategy iConnStrategyA = this.M.a();
            this.o = iConnStrategyA == null ? r() : iConnStrategyA.getIp();
            if (iConnStrategyA != null) {
                port = iConnStrategyA.getPort();
            }
            this.p = port;
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_DNS, "httpdns", 0.0d);
            ALog.i(d(), "connect from amdc succ", "ip", this.o, "port", Integer.valueOf(this.p), "originPos", Integer.valueOf(this.M.c()));
        }
        if (Utils.isIPV6Address(this.o)) {
            this.w = "https://[" + this.o + "]:" + this.p + "/accs/";
        } else {
            this.w = "https://" + this.o + ":" + this.p + "/accs/";
        }
        ALog.i(d(), BaseMonitor.ALARM_POINT_CONNECT, "URL", this.w);
        this.N = String.valueOf(System.currentTimeMillis());
        if (this.H != null) {
            AppMonitor.getInstance().commitStat(this.H);
        }
        SessionMonitor sessionMonitor = new SessionMonitor();
        this.H = sessionMonitor;
        sessionMonitor.setConnectType(this.f10353c == 0 ? "service" : "inapp");
        if (this.y != null) {
            try {
                this.D = System.currentTimeMillis();
                this.E = System.nanoTime();
                this.f10409q = UtilityImpl.a(this.f10354d);
                this.r = UtilityImpl.b(this.f10354d);
                this.B = System.currentTimeMillis();
                this.H.onStartConnect();
                c(2);
                synchronized (this.A) {
                    try {
                        if (TextUtils.isEmpty(this.f10409q) || this.r < 0 || !this.J) {
                            ALog.i(d(), "connect normal", new Object[0]);
                            sessionInfo = new SessionInfo(this.o, this.p, r() + "_" + this.f10352b, null, 0, this.N, this, 4226);
                            this.K = "";
                        } else {
                            ALog.i(d(), BaseMonitor.ALARM_POINT_CONNECT, "proxy", this.f10409q, "port", Integer.valueOf(this.r));
                            sessionInfo = new SessionInfo(this.o, this.p, r() + "_" + this.f10352b, this.f10409q, this.r, this.N, this, 4226);
                            this.K = this.f10409q + ":" + this.r;
                        }
                        sessionInfo.setPubKeySeqNum(t());
                        sessionInfo.setConnectionTimeoutMs(b.ACCS_RECEIVE_TIMEOUT);
                        this.z = this.y.createSession(sessionInfo);
                        this.H.connection_stop_date = 0L;
                        this.A.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        this.J = false;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.taobao.accs.net.b
    public com.taobao.accs.ut.a.c c() {
        if (this.I == null) {
            this.I = new com.taobao.accs.ut.a.c();
        }
        com.taobao.accs.ut.a.c cVar = this.I;
        cVar.f10432b = this.f10353c;
        cVar.f10434d = this.t.size();
        this.I.f10439i = UtilityImpl.g(this.f10354d);
        com.taobao.accs.ut.a.c cVar2 = this.I;
        cVar2.f10436f = this.K;
        cVar2.f10431a = this.s;
        SessionMonitor sessionMonitor = this.H;
        cVar2.f10433c = sessionMonitor != null && sessionMonitor.getRet();
        this.I.j = s();
        com.taobao.accs.ut.a.c cVar3 = this.I;
        com.taobao.accs.data.d dVar = this.f10355e;
        cVar3.f10435e = dVar != null ? dVar.d() : 0;
        com.taobao.accs.ut.a.c cVar4 = this.I;
        cVar4.f10437g = this.x;
        return cVar4;
    }

    @Override // com.taobao.accs.net.b
    public void e() {
        super.e();
        this.v = false;
        ThreadPoolExecutorFactory.getScheduledExecutor().execute(new y(this));
        ALog.e(d(), "shut down", new Object[0]);
    }

    @Override // com.taobao.accs.net.b
    public void b() {
        this.J = false;
        this.f10356f = 0;
    }

    @Override // com.taobao.accs.net.b
    public void a() {
        this.v = true;
        ALog.d(d(), RequestBannerParamBo.GET_SPLASH_TYPE, new Object[0]);
        a(this.f10354d);
        if (this.u == null) {
            ALog.i(d(), "start thread", new Object[0]);
            a aVar = new a("NetworkThread_" + this.m);
            this.u = aVar;
            aVar.setPriority(2);
            this.u.start();
        }
        a(false, false);
    }

    @Override // com.taobao.accs.net.b
    public String b(String str) {
        return "https://" + this.f10359i.getChannelHost();
    }

    private synchronized void c(int i2) {
        ALog.i(d(), "notifyStatus start", "status", a(i2));
        if (i2 == this.s) {
            ALog.d(d(), "ignore notifyStatus", new Object[0]);
            return;
        }
        this.s = i2;
        if (i2 == 1) {
            f.a(this.f10354d).f();
            v();
            ScheduledFuture<?> scheduledFuture = this.n;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            synchronized (this.A) {
                try {
                    this.A.notifyAll();
                } catch (Exception unused) {
                }
            }
            synchronized (this.t) {
                try {
                    this.t.notifyAll();
                } catch (Exception unused2) {
                }
            }
            ALog.i(d(), "notifyStatus end", "status", a(i2));
        }
        if (i2 == 2) {
            ScheduledFuture<?> scheduledFuture2 = this.n;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(true);
            }
            ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new z(this, this.N), 120000L, TimeUnit.MILLISECONDS);
        } else if (i2 == 3) {
            ALog.w(d(), "notifyStatus", "status", a(i2));
            v();
            f.a(this.f10354d).d();
            synchronized (this.A) {
                try {
                    this.A.notifyAll();
                } catch (Exception unused3) {
                }
            }
            this.f10355e.a(AccsErrorCode.SPDY_CON_DISCONNECTED.copy().detail(com.taobao.accs.utl.i.a().b()).build());
            a(false, true);
        }
        ALog.i(d(), "notifyStatus end", "status", a(i2));
    }

    @Override // com.taobao.accs.net.b
    public void a(Message message, boolean z) {
        if (this.v && message != null) {
            try {
                if (ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size() <= 1000) {
                    ScheduledFuture<?> scheduledFutureSchedule = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new x(this, message, z), message.Q, TimeUnit.MILLISECONDS);
                    if (message.a() == 1 && message.O != null) {
                        if (message.c()) {
                            a(message.O);
                        }
                        this.f10355e.f10288a.put(message.O, scheduledFutureSchedule);
                    }
                    if (message.e() != null) {
                        message.e().setDeviceId(UtilityImpl.getDeviceId(this.f10354d));
                        message.e().setConnType(this.f10353c);
                        message.e().onEnterQueueData();
                        return;
                    }
                    return;
                }
                throw new RejectedExecutionException("accs");
            } catch (RejectedExecutionException unused) {
                int size = ThreadPoolExecutorFactory.getScheduledExecutor().getQueue().size();
                this.f10355e.a(message, AccsErrorCode.MESSAGE_QUEUE_FULL.copy().detail("channel " + size).build());
                ALog.e(d(), "send queue full count:" + size, new Object[0]);
                return;
            } catch (Throwable th) {
                ALog.e(d(), "send error", th, new Object[0]);
                this.f10355e.a(message, AccsErrorCode.SEND_LOCAL_EXCEPTION.copy().detail(AccsErrorCode.getExceptionInfo(th)).build());
                return;
            }
        }
        ALog.e(d(), "not running or msg null! " + this.v, new Object[0]);
    }

    @Override // com.taobao.accs.net.b
    public void a(boolean z, boolean z2) {
        ALog.d(d(), "try ping, force:" + z, new Object[0]);
        if (this.f10353c == 1) {
            ALog.d(d(), "INAPP, skip", new Object[0]);
        } else {
            b(Message.a(z, (int) (z2 ? Math.random() * 10.0d * 1000.0d : 0.0d)), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        if (message.t == null || this.t.size() == 0) {
            return;
        }
        for (int size = this.t.size() - 1; size >= 0; size--) {
            Message message2 = this.t.get(size);
            if (message2 != null && message2.t != null && message2.f().equals(message.f())) {
                switch (message.t.intValue()) {
                    case 1:
                    case 2:
                        if (message2.t.intValue() == 1 || message2.t.intValue() == 2) {
                            this.t.remove(size);
                        }
                        break;
                    case 3:
                    case 4:
                        if (message2.t.intValue() == 3 || message2.t.intValue() == 4) {
                            this.t.remove(size);
                        }
                        break;
                    case 5:
                    case 6:
                        if (message2.t.intValue() == 5 || message2.t.intValue() == 6) {
                            this.t.remove(size);
                        }
                        break;
                }
                ALog.d(d(), "clearRepeatControlCommand message:" + message2.t + "/" + message2.f(), new Object[0]);
            }
        }
        com.taobao.accs.data.d dVar = this.f10355e;
        if (dVar != null) {
            dVar.b(message);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            int r0 = com.taobao.accs.utl.Utils.getMode()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L9
            return r2
        L9:
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            r3 = 0
            if (r0 != 0) goto L1c
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L1c
            boolean r0 = android.text.TextUtils.isEmpty(r14)
            if (r0 == 0) goto Lae
        L1c:
            r0 = 3
            r11.c(r0)
            boolean r12 = android.text.TextUtils.isEmpty(r12)
            if (r12 == 0) goto L28
        L26:
            r0 = 1
            goto L36
        L28:
            boolean r12 = android.text.TextUtils.isEmpty(r13)
            if (r12 == 0) goto L30
            r0 = 2
            goto L36
        L30:
            boolean r12 = android.text.TextUtils.isEmpty(r14)
            if (r12 == 0) goto L26
        L36:
            com.taobao.accs.ut.monitor.SessionMonitor r12 = r11.H
            r12.setFailReason(r0)
            com.taobao.accs.ut.monitor.SessionMonitor r12 = r11.H
            r12.onConnectStop()
            int r12 = r11.f10353c
            if (r12 != 0) goto L47
            java.lang.String r12 = "service"
            goto L49
        L47:
            java.lang.String r12 = "inapp"
        L49:
            com.taobao.accs.net.w$a r13 = r11.u
            if (r13 == 0) goto L50
            int r13 = r13.f10410a
            goto L51
        L50:
            r13 = 0
        L51:
            com.taobao.accs.utl.UTMini r4 = com.taobao.accs.utl.UTMini.getInstance()
            r5 = 66001(0x101d1, float:9.2487E-41)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r6 = "DISCONNECT "
            r14.append(r6)
            r14.append(r12)
            java.lang.String r6 = r14.toString()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r13)
            r12 = 222(0xde, float:3.11E-43)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            java.lang.String[] r10 = new java.lang.String[r1]
            java.lang.String r12 = r11.x
            r10[r3] = r12
            java.lang.String r12 = r11.K
            r10[r2] = r12
            r4.commitEvent(r5, r6, r7, r8, r9, r10)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r14 = "retrytimes:"
            r12.append(r14)
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r0)
            java.lang.String r14 = ""
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            java.lang.String r0 = "accs"
            java.lang.String r1 = "connect"
            com.taobao.accs.utl.AppMonitorAdapter.commitAlarmFail(r0, r1, r12, r13, r14)
            r2 = 0
        Lae:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.net.w.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    @Override // com.taobao.accs.net.b
    public String d() {
        return "SilenceConn_" + this.m;
    }

    private void a(ErrorCode errorCode) {
        this.k = null;
        q();
        a aVar = this.u;
        int i2 = aVar != null ? aVar.f10410a : 0;
        this.H.setCloseReason("code not 200 is" + errorCode.getCodeInt());
        this.L = true;
        String str = this.f10353c == 0 ? "service" : "inapp";
        UTMini.getInstance().commitEvent(66001, "CONNECTED NO 200 " + str, errorCode, Integer.valueOf(i2), Integer.valueOf(Constants.SDK_VERSION_CODE), this.x, this.K);
        AppMonitorAdapter.commitAlarmFail("accs", "auth", "", errorCode + "", "");
    }

    @Override // com.taobao.accs.net.b
    public void a(String str, boolean z, String str2) {
        try {
            c(4);
            q();
            this.H.setCloseReason(str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.taobao.accs.net.b
    public boolean a(String str) {
        boolean z;
        String str2;
        synchronized (this.t) {
            z = true;
            int size = this.t.size() - 1;
            while (true) {
                if (size >= 0) {
                    Message message = this.t.get(size);
                    if (message != null && message.a() == 1 && (str2 = message.O) != null && str2.equals(str)) {
                        this.t.remove(size);
                        break;
                    }
                    size--;
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }

    @Override // com.taobao.accs.net.b
    public void a(Context context) {
        if (this.f10357g) {
            return;
        }
        super.a(context);
        GlobalAppRuntimeInfo.setBackground(false);
        this.f10357g = true;
        ALog.i(d(), "init awcn success!", new Object[0]);
    }
}
