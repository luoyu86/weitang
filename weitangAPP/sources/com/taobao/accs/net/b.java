package com.taobao.accs.net;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.Config;
import anet.channel.SessionCenter;
import anet.channel.entity.ConnType;
import anet.channel.entity.ENV;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsException;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static final int ACCS_RECEIVE_TIMEOUT = 40000;
    public static final int INAPP = 1;
    public static final int SERVICE = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f10354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.taobao.accs.data.d f10355e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.taobao.accs.client.c f10358h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AccsClientConfig f10359i;
    public String j;
    public String m;
    private Runnable o;
    private ScheduledFuture<?> p;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f10356f = 0;
    private long n = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f10357g = false;
    public String k = null;
    public LinkedHashMap<Integer, Message> l = new LinkedHashMap<Integer, Message>() { // from class: com.taobao.accs.net.BaseConnection$1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<Integer, Message> entry) {
            return size() > 10;
        }
    };

    public b(Context context, int i2, String str) {
        this.f10352b = "";
        this.f10353c = i2;
        this.f10354d = context.getApplicationContext();
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag == null) {
            ALog.e(d(), "BaseConnection config null!!", new Object[0]);
            try {
                configByTag = new AccsClientConfig.Builder().setAppKey(ACCSManager.getDefaultAppKey(context)).setTag(str).build();
            } catch (AccsException e2) {
                ALog.e(d(), "BaseConnection build config", e2, new Object[0]);
            }
        }
        this.m = configByTag.getTag();
        this.f10352b = configByTag.getAppKey();
        this.f10359i = configByTag;
        com.taobao.accs.data.d dVar = new com.taobao.accs.data.d(context, this);
        this.f10355e = dVar;
        dVar.f10289b = this.f10353c;
        ALog.d(d(), "new connection", new Object[0]);
    }

    public String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 4 ? "DISCONNECTED" : "DISCONNECTING" : "CONNECTING" : "CONNECTED";
    }

    public abstract void a();

    public abstract void a(Message message, boolean z);

    public void a(String str, boolean z, long j) {
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new c(this, str, j, z), j, TimeUnit.MILLISECONDS);
    }

    public abstract void a(String str, boolean z, String str2);

    public abstract void a(boolean z, boolean z2);

    public abstract boolean a(String str);

    public abstract void b();

    public void b(Message message, boolean z) {
        long jA = message.a() != 2 ? this.f10355e.f10291d.a(message.H, message.V) : 0L;
        if (jA == -1) {
            ALog.e(d(), "sendMessage ready server limit high", Constants.KEY_DATA_ID, message.f10273q);
            this.f10355e.a(message, AccsErrorCode.SERVIER_HIGH_LIMIT);
            return;
        }
        if (jA == -1000) {
            ALog.e(d(), "sendMessage ready server limit high for brush", Constants.KEY_DATA_ID, message.f10273q);
            this.f10355e.a(message, AccsErrorCode.SERVIER_HIGH_LIMIT_BRUSH);
            return;
        }
        if (jA > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.n;
            if (jCurrentTimeMillis > j) {
                message.Q = jA;
            } else {
                message.Q = (j + jA) - System.currentTimeMillis();
            }
            this.n = System.currentTimeMillis() + message.Q;
            ALog.e(d(), "sendMessage ready delayed", Constants.KEY_DATA_ID, message.f10273q, "type", Message.c.b(message.a()), "delay", Long.valueOf(message.Q));
        } else if ("accs".equals(message.H)) {
            ALog.i(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.f10273q, "type", Message.c.b(message.a()), "delay", Long.valueOf(message.Q));
        } else if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(d(), "sendMessage ready", Constants.KEY_DATA_ID, message.f10273q, "type", Message.c.b(message.a()), "delay", Long.valueOf(message.Q));
        }
        try {
            if (TextUtils.isEmpty(this.j)) {
                this.j = UtilityImpl.getDeviceId(this.f10354d);
            }
            if (message.g()) {
                this.f10355e.a(message, AccsErrorCode.REQ_TIME_OUT.copy().msg("重试或者延期时超时，不发送").detail(AccsErrorCode.getAllDetails(null)).build());
            } else {
                a(message, z);
            }
        } catch (RejectedExecutionException unused) {
            int size = ThreadPoolExecutorFactory.getSendScheduledExecutor().getQueue().size();
            this.f10355e.a(message, AccsErrorCode.MESSAGE_QUEUE_FULL.copy().detail(" " + size).build());
            ALog.e(d(), "sendMessage ready queue full", "size", Integer.valueOf(size));
        }
    }

    public abstract com.taobao.accs.ut.a.c c();

    public String c(String str) {
        String deviceId = UtilityImpl.getDeviceId(this.f10354d);
        try {
            deviceId = URLEncoder.encode(deviceId);
        } catch (Throwable th) {
            ALog.e(d(), "buildAuthUrl", th, new Object[0]);
        }
        String strA = UtilityImpl.a(i(), this.f10359i.getAppSecret(), UtilityImpl.getDeviceId(this.f10354d));
        StringBuilder sb = new StringBuilder(256);
        sb.append(str);
        sb.append("auth?1=");
        sb.append(deviceId);
        sb.append("&2=");
        sb.append(strA);
        sb.append("&3=");
        sb.append(i());
        if (this.k != null) {
            sb.append("&4=");
            sb.append(this.k);
        }
        sb.append("&5=");
        sb.append(this.f10353c);
        sb.append("&6=");
        sb.append(UtilityImpl.e(this.f10354d));
        sb.append("&7=");
        sb.append(UtilityImpl.b());
        sb.append("&8=");
        sb.append(this.f10353c == 1 ? "1.1.2" : Integer.valueOf(Constants.SDK_VERSION_CODE));
        sb.append("&9=");
        sb.append(System.currentTimeMillis());
        sb.append("&10=");
        sb.append(1);
        sb.append("&11=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append("&12=");
        sb.append(this.f10354d.getPackageName());
        sb.append("&13=");
        sb.append(UtilityImpl.i(this.f10354d));
        sb.append("&14=");
        sb.append(this.f10351a);
        sb.append("&15=");
        sb.append(UtilityImpl.b(Build.MODEL));
        sb.append("&16=");
        sb.append(UtilityImpl.b(Build.BRAND));
        sb.append("&17=");
        sb.append(Constants.SDK_VERSION_CODE);
        sb.append("&19=");
        sb.append(!k() ? 1 : 0);
        sb.append("&20=");
        sb.append(this.f10359i.getStoreId());
        return sb.toString();
    }

    public abstract String d();

    public void e() {
    }

    public void f() {
        if (this.o == null) {
            this.o = new d(this);
        }
        g();
        this.p = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(this.o, 40000L, TimeUnit.MILLISECONDS);
    }

    public void g() {
        ScheduledFuture<?> scheduledFuture = this.p;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public boolean h() {
        return true;
    }

    public String i() {
        return this.f10352b;
    }

    public com.taobao.accs.client.c j() {
        if (this.f10358h == null) {
            ALog.d(d(), "new ClientManager", Constants.KEY_CONFIG_TAG, this.m);
            this.f10358h = new com.taobao.accs.client.c(this.f10354d, this.m, this.f10359i.getInappHost(), this.f10352b);
        }
        return this.f10358h;
    }

    public boolean k() {
        return 2 == this.f10359i.getSecurity();
    }

    public abstract boolean l();

    public abstract int m();

    public abstract void n();

    public abstract void o();

    public void p() {
        com.taobao.accs.client.c cVar = this.f10358h;
        if (cVar != null) {
            cVar.a();
        }
        this.f10357g = false;
    }

    public boolean a(Message message, int i2) {
        int i3;
        boolean z = true;
        try {
            i3 = message.R;
        } catch (Throwable th) {
            th = th;
            z = false;
        }
        if (i3 > 3) {
            return false;
        }
        message.R = i3 + 1;
        message.Q = i2;
        ALog.e(d(), "reSend dataid:" + message.f10273q + " retryTimes:" + message.R, new Object[0]);
        b(message, true);
        try {
            if (message.e() != null) {
                message.e().take_date = 0L;
                message.e().to_tnet_date = 0L;
                NetPerformanceMonitor netPerformanceMonitorE = message.e();
                int i4 = message.R;
                netPerformanceMonitorE.retry_times = i4;
                if (i4 == 1) {
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, "total", 0.0d);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            ALog.e(d(), "reSend error", th, new Object[0]);
            this.f10355e.a(message, AccsErrorCode.SEND_LOCAL_EXCEPTION.copy().detail(AccsErrorCode.getExceptionInfo(th)).build());
        }
        return z;
        ALog.e(d(), "reSend error", th, new Object[0]);
        this.f10355e.a(message, AccsErrorCode.SEND_LOCAL_EXCEPTION.copy().detail(AccsErrorCode.getExceptionInfo(th)).build());
        return z;
    }

    public void a(Context context) {
        try {
            ENV env = ENV.ONLINE;
            int i2 = AccsClientConfig.mEnv;
            if (i2 == 2) {
                env = ENV.TEST;
                SessionCenter.switchEnvironment(env);
            } else if (i2 == 1) {
                env = ENV.PREPARE;
                SessionCenter.switchEnvironment(env);
            }
            try {
                AwcnConfig.setSendConnectInfoByService(false);
            } catch (Throwable unused) {
            }
            SessionCenter.init(context, new Config.Builder().setAppkey(this.f10352b).setAppSecret(this.f10359i.getAppSecret()).setAuthCode(this.f10359i.getAuthCode()).setEnv(env).setTag(this.f10359i.getAppKey()).build());
            String str = ConnType.PK_ACS;
            if (this.f10359i.getInappPubKey() == 10 || this.f10359i.getInappPubKey() == 11) {
                str = "open";
            }
            StrategyTemplate.getInstance().registerConnProtocol(this.f10359i.getInappHost(), ConnProtocol.valueOf(ConnType.HTTP2, ConnType.RTT_0, str, false));
        } catch (Throwable th) {
            ALog.e(d(), "initAwcn", th, new Object[0]);
        }
    }

    public void b(int i2) {
        if (i2 < 0) {
            ALog.e(d(), "reSendAck", Constants.KEY_DATA_ID, Integer.valueOf(i2));
            Message message = this.l.get(Integer.valueOf(i2));
            if (message != null) {
                a(message, 5000);
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_RESEND, BaseMonitor.COUNT_ACK, 0.0d);
            }
        }
    }

    public String b(String str) {
        String inappHost = this.f10359i.getInappHost();
        StringBuilder sb = new StringBuilder();
        sb.append("https://");
        sb.append(TextUtils.isEmpty(str) ? "" : str);
        sb.append(inappHost);
        String string = sb.toString();
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://");
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb2.append(str);
            sb2.append(inappHost);
            return sb2.toString();
        } catch (Throwable th) {
            ALog.e("InAppConnection", "getHost", th, new Object[0]);
            return string;
        }
    }

    public void a(Message message, ErrorCode errorCode) {
        this.f10355e.a(message, errorCode);
    }

    public void b(Context context) {
        try {
            ThreadPoolExecutorFactory.schedule(new e(this, context), 10000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            ALog.w(d(), "startChannelService", th, new Object[0]);
        }
    }
}
