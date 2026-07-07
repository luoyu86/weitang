package anet.channel.session;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.Config;
import anet.channel.DataFrameCb;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.entity.ConnType;
import anet.channel.heartbeat.HeartbeatManager;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.security.ISecurity;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.statist.SessionMonitor;
import anet.channel.statist.SessionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpHelper;
import anet.channel.util.Utils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.spdy.RequestPriority;
import org.android.spdy.SessionCb;
import org.android.spdy.SessionInfo;
import org.android.spdy.SpdyAgent;
import org.android.spdy.SpdyByteArray;
import org.android.spdy.SpdyDataProvider;
import org.android.spdy.SpdyErrorException;
import org.android.spdy.SpdyRequest;
import org.android.spdy.SpdySession;
import org.android.spdy.SpdySessionKind;
import org.android.spdy.SpdyVersion;
import org.android.spdy.SuperviseConnectInfo;
import org.android.spdy.SuperviseData;

/* JADX INFO: loaded from: classes.dex */
public class TnetSpdySession extends Session implements SessionCb {
    public long A;
    public int B;
    public DataFrameCb C;
    public IHeartbeat D;
    public IAuth E;
    public String F;
    public ISecurity G;
    private int H;
    private boolean I;
    public SpdyAgent w;
    public SpdySession x;
    public volatile boolean y;
    public long z;

    public class a extends anet.channel.session.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Request f560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private RequestCb f561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f562d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f563e = 0;

        public a(Request request, RequestCb requestCb) {
            this.f560b = request;
            this.f561c = requestCb;
        }

        private void a(SuperviseData superviseData, int i2, String str) {
            try {
                this.f560b.f528a.rspEnd = System.currentTimeMillis();
                if (this.f560b.f528a.isDone.get()) {
                    return;
                }
                if (i2 > 0) {
                    this.f560b.f528a.ret = 1;
                }
                this.f560b.f528a.statusCode = i2;
                this.f560b.f528a.msg = str;
                if (superviseData != null) {
                    this.f560b.f528a.rspEnd = superviseData.responseEnd;
                    this.f560b.f528a.sendBeforeTime = superviseData.sendStart - superviseData.requestStart;
                    RequestStatistic requestStatistic = this.f560b.f528a;
                    requestStatistic.sendDataTime = superviseData.sendEnd - requestStatistic.sendStart;
                    this.f560b.f528a.firstDataTime = superviseData.responseStart - superviseData.sendEnd;
                    this.f560b.f528a.recDataTime = superviseData.responseEnd - superviseData.responseStart;
                    this.f560b.f528a.sendDataSize = superviseData.bodySize + superviseData.compressSize;
                    this.f560b.f528a.recDataSize = this.f563e + ((long) superviseData.recvUncompressSize);
                    this.f560b.f528a.reqHeadInflateSize = superviseData.uncompressSize;
                    this.f560b.f528a.reqHeadDeflateSize = superviseData.compressSize;
                    this.f560b.f528a.reqBodyInflateSize = superviseData.bodySize;
                    this.f560b.f528a.reqBodyDeflateSize = superviseData.bodySize;
                    this.f560b.f528a.rspHeadDeflateSize = superviseData.recvCompressSize;
                    this.f560b.f528a.rspHeadInflateSize = superviseData.recvUncompressSize;
                    this.f560b.f528a.rspBodyDeflateSize = superviseData.recvBodySize;
                    this.f560b.f528a.rspBodyInflateSize = this.f563e;
                    if (this.f560b.f528a.contentLength == 0) {
                        this.f560b.f528a.contentLength = superviseData.originContentLength;
                    }
                    SessionStatistic sessionStatistic = TnetSpdySession.this.f331q;
                    sessionStatistic.recvSizeCount += (long) (superviseData.recvBodySize + superviseData.recvCompressSize);
                    sessionStatistic.sendSizeCount += (long) (superviseData.bodySize + superviseData.compressSize);
                }
            } catch (Exception unused) {
            }
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, SpdyByteArray spdyByteArray, Object obj) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyDataChunkRecvCB", this.f560b.getSeq(), "len", Integer.valueOf(spdyByteArray.getDataLength()), "fin", Boolean.valueOf(z));
            }
            this.f563e += (long) spdyByteArray.getDataLength();
            this.f560b.f528a.recDataSize += (long) spdyByteArray.getDataLength();
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
            if (this.f561c != null) {
                ByteArray byteArrayA = a.C0006a.f385a.a(spdyByteArray.getByteArray(), spdyByteArray.getDataLength());
                spdyByteArray.recycle();
                this.f561c.onDataReceive(byteArrayA, z);
            }
            TnetSpdySession.this.handleCallbacks(32, null);
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, Object obj) {
            this.f560b.f528a.firstDataTime = System.currentTimeMillis() - this.f560b.f528a.sendStart;
            this.f562d = HttpHelper.parseStatusCode(map);
            TnetSpdySession.this.H = 0;
            ALog.i("awcn.TnetSpdySession", "", this.f560b.getSeq(), "statusCode", Integer.valueOf(this.f562d));
            ALog.i("awcn.TnetSpdySession", "", this.f560b.getSeq(), "response headers", map);
            RequestCb requestCb = this.f561c;
            if (requestCb != null) {
                requestCb.onResponseCode(this.f562d, HttpHelper.cloneMap(map));
            }
            TnetSpdySession.this.handleCallbacks(16, null);
            this.f560b.f528a.contentEncoding = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Encoding");
            this.f560b.f528a.contentType = HttpHelper.getSingleHeaderFieldByKey(map, "Content-Type");
            this.f560b.f528a.contentLength = HttpHelper.parseContentLength(map);
            this.f560b.f528a.serverRT = HttpHelper.parseServerRT(map);
            TnetSpdySession.this.handleResponseCode(this.f560b, this.f562d);
            TnetSpdySession.this.handleResponseHeaders(this.f560b, map);
            IHeartbeat iHeartbeat = TnetSpdySession.this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        }

        @Override // anet.channel.session.a, org.android.spdy.Spdycb
        public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i2, Object obj, SuperviseData superviseData) {
            String msg;
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", "spdyStreamCloseCallback", this.f560b.getSeq(), "streamId", Long.valueOf(j), "errorCode", Integer.valueOf(i2));
            }
            if (i2 != 0) {
                this.f562d = ErrorConstant.ERROR_TNET_REQUEST_FAIL;
                msg = ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_REQUEST_FAIL, String.valueOf(i2));
                if (i2 != -2005) {
                    AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_TNET_EXCEPTION, msg, this.f560b.f528a, null));
                }
                ALog.e("awcn.TnetSpdySession", "spdyStreamCloseCallback error", this.f560b.getSeq(), "session", TnetSpdySession.this.p, "status code", Integer.valueOf(i2), "URL", this.f560b.getHttpUrl().simpleUrlString());
            } else {
                msg = "SUCCESS";
            }
            this.f560b.f528a.tnetErrorCode = i2;
            a(superviseData, this.f562d, msg);
            RequestCb requestCb = this.f561c;
            if (requestCb != null) {
                requestCb.onFinish(this.f562d, msg, this.f560b.f528a);
            }
            if (i2 == -2004) {
                if (!TnetSpdySession.this.y) {
                    TnetSpdySession.this.ping(true);
                }
                if (TnetSpdySession.e(TnetSpdySession.this) >= 2) {
                    ConnEvent connEvent = new ConnEvent();
                    connEvent.isSuccess = false;
                    connEvent.isAccs = TnetSpdySession.this.I;
                    StrategyCenter.getInstance().notifyConnEvent(TnetSpdySession.this.f325d, TnetSpdySession.this.k, connEvent);
                    TnetSpdySession.this.close(true);
                }
            }
        }
    }

    public TnetSpdySession(Context context, anet.channel.entity.a aVar) {
        super(context, aVar);
        this.y = false;
        this.A = 0L;
        this.H = 0;
        this.B = -1;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.I = false;
    }

    public static /* synthetic */ int e(TnetSpdySession tnetSpdySession) {
        int i2 = tnetSpdySession.H + 1;
        tnetSpdySession.H = i2;
        return i2;
    }

    @Override // org.android.spdy.SessionCb
    public void bioPingRecvCallback(SpdySession spdySession, int i2) {
    }

    @Override // anet.channel.Session
    public void close() {
        ALog.e("awcn.TnetSpdySession", "force close!", this.p, "session", this);
        notifyStatus(7, null);
        try {
            IHeartbeat iHeartbeat = this.D;
            if (iHeartbeat != null) {
                iHeartbeat.stop();
                this.D = null;
            }
            SpdySession spdySession = this.x;
            if (spdySession != null) {
                spdySession.closeSession();
            }
        } catch (Exception unused) {
        }
    }

    @Override // anet.channel.Session
    public void connect() {
        int xquicCongControl;
        int i2 = this.n;
        int i3 = 1;
        if (i2 == 1 || i2 == 0 || i2 == 4) {
            return;
        }
        try {
            if (this.w == null) {
                c();
            }
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(this.f326e)) {
                try {
                    this.f327f = anet.channel.util.c.a(this.f326e);
                } catch (Exception unused) {
                }
            }
            String strValueOf = String.valueOf(System.currentTimeMillis());
            ALog.e("awcn.TnetSpdySession", BaseMonitor.ALARM_POINT_CONNECT, this.p, "host", this.f324c, "ip", this.f327f, "port", Integer.valueOf(this.f328g), "sessionId", strValueOf, "SpdyProtocol,", this.j, "proxyIp,", this.f329h, "proxyPort,", Integer.valueOf(this.f330i));
            SessionInfo sessionInfo = new SessionInfo(this.f327f, this.f328g, this.f324c + "_" + this.F, this.f329h, this.f330i, strValueOf, this, this.j.getTnetConType());
            sessionInfo.setConnectionTimeoutMs((int) (((float) this.r) * Utils.getNetworkTimeFactor()));
            if (this.j.isPublicKeyAuto() || this.j.isH2S() || this.j.isHTTP3()) {
                sessionInfo.setCertHost(this.m ? this.f326e : this.f325d);
            } else {
                int i4 = this.B;
                if (i4 >= 0) {
                    sessionInfo.setPubKeySeqNum(i4);
                } else {
                    ConnType connType = this.j;
                    ISecurity iSecurity = this.G;
                    int tnetPublicKey = connType.getTnetPublicKey(iSecurity != null ? iSecurity.isSecOff() : true);
                    this.B = tnetPublicKey;
                    sessionInfo.setPubKeySeqNum(tnetPublicKey);
                }
            }
            if (this.j.isHTTP3() && (xquicCongControl = AwcnConfig.getXquicCongControl()) >= 0) {
                sessionInfo.setXquicCongControl(xquicCongControl);
            }
            SpdySession spdySessionCreateSession = this.w.createSession(sessionInfo);
            this.x = spdySessionCreateSession;
            if (spdySessionCreateSession.getRefCount() > 1) {
                ALog.e("awcn.TnetSpdySession", "get session ref count > 1!!!", this.p, new Object[0]);
                notifyStatus(0, new anet.channel.entity.b(1));
                b();
                return;
            }
            notifyStatus(1, null);
            this.z = System.currentTimeMillis();
            SessionStatistic sessionStatistic = this.f331q;
            if (TextUtils.isEmpty(this.f329h)) {
                i3 = 0;
            }
            sessionStatistic.isProxy = i3;
            SessionStatistic sessionStatistic2 = this.f331q;
            sessionStatistic2.isTunnel = "false";
            sessionStatistic2.isBackground = GlobalAppRuntimeInfo.isAppBackground();
            this.A = 0L;
        } catch (Throwable th) {
            notifyStatus(2, null);
            ALog.e("awcn.TnetSpdySession", "connect exception ", this.p, th, new Object[0]);
        }
    }

    @Override // anet.channel.Session
    public Runnable getRecvTimeOutRunnable() {
        return new h(this);
    }

    @Override // org.android.spdy.SessionCb
    public byte[] getSSLMeta(SpdySession spdySession) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            ALog.i("awcn.TnetSpdySession", "get sslticket host is null", null, new Object[0]);
            return null;
        }
        try {
            ISecurity iSecurity = this.G;
            if (iSecurity == null) {
                return null;
            }
            return iSecurity.getBytes(this.f322a, "accs_ssl_key2_" + domain);
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "getSSLMeta", null, th, new Object[0]);
            return null;
        }
    }

    public void initConfig(Config config) {
        if (config != null) {
            this.F = config.getAppkey();
            this.G = config.getSecurity();
        }
    }

    public void initSessionInfo(anet.channel.SessionInfo sessionInfo) {
        if (sessionInfo != null) {
            this.C = sessionInfo.dataFrameCb;
            this.E = sessionInfo.auth;
            if (sessionInfo.isKeepAlive) {
                this.f331q.isKL = 1L;
                this.t = true;
                IHeartbeat iHeartbeat = sessionInfo.heartbeat;
                this.D = iHeartbeat;
                boolean z = sessionInfo.isAccs;
                this.I = z;
                if (iHeartbeat == null) {
                    if (!z || AwcnConfig.isAccsSessionCreateForbiddenInBg()) {
                        this.D = HeartbeatManager.getDefaultHeartbeat();
                    } else {
                        this.D = HeartbeatManager.getDefaultBackgroundAccsHeartbeat();
                    }
                }
            }
        }
        if (AwcnConfig.isIdleSessionCloseEnable() && this.D == null) {
            this.D = new anet.channel.heartbeat.c();
        }
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        return this.n == 4;
    }

    @Override // anet.channel.Session
    public void onDisconnect() {
        this.y = false;
    }

    @Override // anet.channel.Session
    public void ping(boolean z) {
        ping(z, this.s);
    }

    @Override // org.android.spdy.SessionCb
    public int putSSLMeta(SpdySession spdySession, byte[] bArr) {
        String domain = spdySession.getDomain();
        if (TextUtils.isEmpty(domain)) {
            return -1;
        }
        try {
            ISecurity iSecurity = this.G;
            if (iSecurity == null) {
                return -1;
            }
            Context context = this.f322a;
            StringBuilder sb = new StringBuilder();
            sb.append("accs_ssl_key2_");
            sb.append(domain);
            return iSecurity.saveBytes(context, sb.toString(), bArr) ? 0 : -1;
        } catch (Throwable th) {
            ALog.e("awcn.TnetSpdySession", "putSSLMeta", null, th, new Object[0]);
            return -1;
        }
    }

    @Override // anet.channel.Session
    public Cancelable request(Request request, RequestCb requestCb) {
        int i2;
        String str;
        SpdyRequest spdyRequest;
        anet.channel.request.c cVar = anet.channel.request.c.NULL;
        RequestStatistic requestStatistic = request != null ? request.f528a : new RequestStatistic(this.f325d, null);
        requestStatistic.setConnType(this.j);
        if (requestStatistic.start == 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = jCurrentTimeMillis;
            requestStatistic.start = jCurrentTimeMillis;
        }
        requestStatistic.setIPAndPort(this.f327f, this.f328g);
        requestStatistic.ipRefer = this.k.getIpSource();
        requestStatistic.ipType = this.k.getIpType();
        requestStatistic.unit = this.l;
        if (request == null || requestCb == null) {
            if (requestCb != null) {
                requestCb.onFinish(-102, ErrorConstant.getErrMsg(-102), requestStatistic);
            }
            return cVar;
        }
        try {
            if (this.x == null || !((i2 = this.n) == 0 || i2 == 4)) {
                requestCb.onFinish(ErrorConstant.ERROR_SESSION_INVALID, ErrorConstant.getErrMsg(ErrorConstant.ERROR_SESSION_INVALID), request.f528a);
                return cVar;
            }
            if (this.m) {
                request.setDnsOptimize(this.f326e, this.f328g);
            }
            request.setUrlScheme(this.j.isSSL());
            URL url = request.getUrl();
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request URL", url.toString());
                ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request Method", request.getMethod());
                ALog.i("awcn.TnetSpdySession", "", request.getSeq(), "request headers", request.getHeaders());
            }
            if (TextUtils.isEmpty(this.f329h) || this.f330i <= 0) {
                str = "";
                spdyRequest = new SpdyRequest(url, request.getMethod(), RequestPriority.DEFAULT_PRIORITY, -1, request.getConnectTimeout());
            } else {
                str = "";
                spdyRequest = new SpdyRequest(url, url.getHost(), url.getPort(), this.f329h, this.f330i, request.getMethod(), RequestPriority.DEFAULT_PRIORITY, -1, request.getConnectTimeout(), 0);
            }
            spdyRequest.setRequestRdTimeoutMs(request.getReadTimeout());
            Map<String, String> headers = request.getHeaders();
            if (headers.containsKey("Host")) {
                HashMap map = new HashMap(request.getHeaders());
                String strRemove = map.remove("Host");
                if (this.m) {
                    strRemove = this.f326e;
                }
                map.put(":host", strRemove);
                spdyRequest.addHeaders(map);
            } else {
                spdyRequest.addHeaders(headers);
                spdyRequest.addHeader(":host", this.m ? this.f326e : request.getHost());
            }
            SpdyDataProvider spdyDataProvider = new SpdyDataProvider(request.getBodyBytes());
            request.f528a.sendStart = System.currentTimeMillis();
            RequestStatistic requestStatistic2 = request.f528a;
            requestStatistic2.processTime = requestStatistic2.sendStart - request.f528a.start;
            int iSubmitRequest = this.x.submitRequest(spdyRequest, spdyDataProvider, this, new a(request, requestCb));
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.TnetSpdySession", str, request.getSeq(), "streamId", Integer.valueOf(iSubmitRequest));
            }
            anet.channel.request.c cVar2 = new anet.channel.request.c(this.x, iSubmitRequest, request.getSeq());
            try {
                SessionStatistic sessionStatistic = this.f331q;
                sessionStatistic.requestCount++;
                sessionStatistic.stdRCount++;
                this.z = System.currentTimeMillis();
                IHeartbeat iHeartbeat = this.D;
                if (iHeartbeat != null) {
                    iHeartbeat.reSchedule();
                }
                return cVar2;
            } catch (SpdyErrorException e2) {
                e = e2;
                cVar = cVar2;
                if (e.SpdyErrorGetCode() == -1104 || e.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.p, new Object[0]);
                    notifyStatus(6, new anet.channel.entity.b(2));
                }
                requestCb.onFinish(ErrorConstant.ERROR_TNET_EXCEPTION, ErrorConstant.formatMsg(ErrorConstant.ERROR_TNET_EXCEPTION, String.valueOf(e.SpdyErrorGetCode())), requestStatistic);
                return cVar;
            } catch (Exception unused) {
                cVar = cVar2;
                requestCb.onFinish(-101, ErrorConstant.getErrMsg(-101), requestStatistic);
                return cVar;
            }
        } catch (SpdyErrorException e3) {
            e = e3;
        } catch (Exception unused2) {
        }
    }

    @Override // anet.channel.Session
    public void sendCustomFrame(int i2, byte[] bArr, int i3) {
        SpdySession spdySession;
        try {
            if (this.C == null) {
                return;
            }
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.p, Constants.KEY_DATA_ID, Integer.valueOf(i2), "type", Integer.valueOf(i3));
            if (this.n != 4 || (spdySession = this.x) == null) {
                ALog.e("awcn.TnetSpdySession", "sendCustomFrame", this.p, "sendCustomFrame con invalid mStatus:" + this.n);
                a(i2, ErrorConstant.ERROR_SESSION_INVALID, true, "session invalid");
                return;
            }
            if (bArr != null && bArr.length > 16384) {
                a(i2, ErrorConstant.ERROR_DATA_TOO_LARGE, false, null);
                return;
            }
            spdySession.sendCustomControlFrame(i2, i3, 0, bArr == null ? 0 : bArr.length, bArr);
            SessionStatistic sessionStatistic = this.f331q;
            sessionStatistic.requestCount++;
            sessionStatistic.cfRCount++;
            this.z = System.currentTimeMillis();
            IHeartbeat iHeartbeat = this.D;
            if (iHeartbeat != null) {
                iHeartbeat.reSchedule();
            }
        } catch (SpdyErrorException e2) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.p, e2, new Object[0]);
            a(i2, ErrorConstant.ERROR_TNET_EXCEPTION, true, "SpdyErrorException: " + e2.toString());
        } catch (Exception e3) {
            ALog.e("awcn.TnetSpdySession", "sendCustomFrame error", this.p, e3, new Object[0]);
            a(i2, -101, true, e3.toString());
        }
    }

    public void setTnetPublicKey(int i2) {
        this.B = i2;
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameFailCallback(SpdySession spdySession, Object obj, int i2, int i3) {
        ALog.e("awcn.TnetSpdySession", "spdyCustomControlFrameFailCallback", this.p, Constants.KEY_DATA_ID, Integer.valueOf(i2));
        a(i2, i3, true, "tnet error");
    }

    @Override // org.android.spdy.SessionCb
    public void spdyCustomControlFrameRecvCallback(SpdySession spdySession, Object obj, int i2, int i3, int i4, int i5, byte[] bArr) {
        ALog.e("awcn.TnetSpdySession", "[spdyCustomControlFrameRecvCallback]", this.p, "len", Integer.valueOf(i5), "frameCb", this.C);
        if (ALog.isPrintLog(1) && i5 < 512) {
            String str = "";
            for (byte b2 : bArr) {
                str = str + Integer.toHexString(b2 & 255) + " ";
            }
            ALog.e("awcn.TnetSpdySession", null, this.p, "str", str);
        }
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onDataReceive(this, bArr, i2, i3);
        } else {
            ALog.e("awcn.TnetSpdySession", "AccsFrameCb is null", this.p, new Object[0]);
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(-105, null, "rt"));
        }
        this.f331q.inceptCount++;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.TnetSpdySession", "ping receive", this.p, "Host", this.f324c, "id", Long.valueOf(j));
        }
        if (j < 0) {
            return;
        }
        this.y = false;
        this.H = 0;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.reSchedule();
        }
        handleCallbacks(128, null);
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i2) {
        ALog.e("awcn.TnetSpdySession", "spdySessionCloseCallback", this.p, " errorCode:", Integer.valueOf(i2));
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.stop();
            this.D = null;
        }
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e("awcn.TnetSpdySession", "session clean up failed!", null, e2, new Object[0]);
            }
        }
        if (i2 == -3516) {
            ConnEvent connEvent = new ConnEvent();
            connEvent.isSuccess = false;
            StrategyCenter.getInstance().notifyConnEvent(this.f325d, this.k, connEvent);
        }
        notifyStatus(6, new anet.channel.entity.b(2));
        if (superviseConnectInfo != null) {
            SessionStatistic sessionStatistic = this.f331q;
            sessionStatistic.requestCount = superviseConnectInfo.reused_counter;
            sessionStatistic.liveTime = superviseConnectInfo.keepalive_period_second;
            try {
                if (this.j.isHTTP3()) {
                    if (spdySession != null) {
                        ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionCloseCallback]", this.p, "connectInfo", spdySession.getConnectInfoOnDisConnected());
                    }
                    this.f331q.xqc0RttStatus = superviseConnectInfo.xqc0RttStatus;
                    this.f331q.retransmissionRate = superviseConnectInfo.retransmissionRate;
                    this.f331q.lossRate = superviseConnectInfo.lossRate;
                    this.f331q.tlpCount = superviseConnectInfo.tlpCount;
                    this.f331q.rtoCount = superviseConnectInfo.rtoCount;
                    this.f331q.srtt = superviseConnectInfo.srtt;
                }
            } catch (Exception unused) {
            }
        }
        SessionStatistic sessionStatistic2 = this.f331q;
        if (sessionStatistic2.errorCode == 0) {
            sessionStatistic2.errorCode = i2;
        }
        sessionStatistic2.lastPingInterval = (int) (System.currentTimeMillis() - this.z);
        AppMonitor.getInstance().commitStat(this.f331q);
        if (anet.channel.strategy.utils.c.b(this.f331q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f331q));
        }
        AppMonitor.getInstance().commitAlarm(this.f331q.getAlarmObject());
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        SessionStatistic sessionStatistic = this.f331q;
        sessionStatistic.connectionTime = superviseConnectInfo.connectTime;
        sessionStatistic.sslTime = superviseConnectInfo.handshakeTime;
        sessionStatistic.sslCalTime = superviseConnectInfo.doHandshakeTime;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        this.A = System.currentTimeMillis();
        notifyStatus(0, new anet.channel.entity.b(1));
        b();
        ALog.e("awcn.TnetSpdySession", "spdySessionConnectCB connect", this.p, "connectTime", Integer.valueOf(superviseConnectInfo.connectTime), "sslTime", Integer.valueOf(superviseConnectInfo.handshakeTime));
        if (this.j.isHTTP3()) {
            this.f331q.scid = superviseConnectInfo.scid;
            this.f331q.dcid = superviseConnectInfo.dcid;
            this.f331q.congControlKind = superviseConnectInfo.congControlKind;
            ALog.e("awcn.TnetSpdySession", "[HTTP3 spdySessionConnectCB]", this.p, "connectInfo", spdySession.getConnectInfoOnConnected());
        }
    }

    @Override // org.android.spdy.SessionCb
    public void spdySessionFailedError(SpdySession spdySession, int i2, Object obj) {
        if (spdySession != null) {
            try {
                spdySession.cleanUp();
            } catch (Exception e2) {
                ALog.e("awcn.TnetSpdySession", "[spdySessionFailedError]session clean up failed!", null, e2, new Object[0]);
            }
        }
        notifyStatus(2, new anet.channel.entity.b(256, i2, "tnet connect fail"));
        ALog.e("awcn.TnetSpdySession", null, this.p, " errorId:", Integer.valueOf(i2));
        SessionStatistic sessionStatistic = this.f331q;
        sessionStatistic.errorCode = i2;
        sessionStatistic.ret = 0;
        sessionStatistic.netType = NetworkStatusHelper.getNetworkSubType();
        AppMonitor.getInstance().commitStat(this.f331q);
        if (anet.channel.strategy.utils.c.b(this.f331q.ip)) {
            AppMonitor.getInstance().commitStat(new SessionMonitor(this.f331q));
        }
        AppMonitor.getInstance().commitAlarm(this.f331q.getAlarmObject());
    }

    @Override // anet.channel.Session
    public void ping(boolean z, int i2) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TnetSpdySession", "ping", this.p, "host", this.f324c, "thread", Thread.currentThread().getName());
        }
        if (z) {
            try {
                if (this.x == null) {
                    SessionStatistic sessionStatistic = this.f331q;
                    if (sessionStatistic != null) {
                        sessionStatistic.closeReason = "session null";
                    }
                    ALog.e("awcn.TnetSpdySession", this.f324c + " session null", this.p, new Object[0]);
                    close();
                    return;
                }
                int i3 = this.n;
                if (i3 == 0 || i3 == 4) {
                    handleCallbacks(64, null);
                    if (this.y) {
                        return;
                    }
                    this.y = true;
                    this.f331q.ppkgCount++;
                    this.x.submitPing();
                    if (ALog.isPrintLog(1)) {
                        ALog.d("awcn.TnetSpdySession", this.f324c + " submit ping ms:" + (System.currentTimeMillis() - this.z) + " force:" + z, this.p, new Object[0]);
                    }
                    setPingTimeout(i2);
                    this.z = System.currentTimeMillis();
                    IHeartbeat iHeartbeat = this.D;
                    if (iHeartbeat != null) {
                        iHeartbeat.reSchedule();
                    }
                }
            } catch (SpdyErrorException e2) {
                if (e2.SpdyErrorGetCode() == -1104 || e2.SpdyErrorGetCode() == -1103) {
                    ALog.e("awcn.TnetSpdySession", "Send request on closed session!!!", this.p, new Object[0]);
                    notifyStatus(6, new anet.channel.entity.b(2));
                }
                ALog.e("awcn.TnetSpdySession", "ping", this.p, e2, new Object[0]);
            } catch (Exception e3) {
                ALog.e("awcn.TnetSpdySession", "ping", this.p, e3, new Object[0]);
            }
        }
    }

    private void c() {
        SpdyAgent.enableDebug = false;
        this.w = SpdyAgent.getInstance(this.f322a, SpdyVersion.SPDY3, SpdySessionKind.NONE_SESSION);
        ISecurity iSecurity = this.G;
        if (iSecurity != null && !iSecurity.isSecOff()) {
            this.w.setAccsSslCallback(new j(this));
        }
        if (AwcnConfig.isTnetHeaderCacheEnable()) {
            return;
        }
        try {
            this.w.getClass().getDeclaredMethod("disableHeaderCache", new Class[0]).invoke(this.w, new Object[0]);
            ALog.i("awcn.TnetSpdySession", "tnet disableHeaderCache", null, new Object[0]);
        } catch (Exception e2) {
            ALog.e("awcn.TnetSpdySession", "tnet disableHeaderCache", null, e2, new Object[0]);
        }
    }

    public void b() {
        IAuth iAuth = this.E;
        if (iAuth != null) {
            iAuth.auth(this, new i(this));
            return;
        }
        notifyStatus(4, null);
        this.f331q.ret = 1;
        IHeartbeat iHeartbeat = this.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(this);
        }
    }

    private void a(int i2, int i3, boolean z, String str) {
        DataFrameCb dataFrameCb = this.C;
        if (dataFrameCb != null) {
            dataFrameCb.onException(i2, i3, z, str);
        }
    }
}
