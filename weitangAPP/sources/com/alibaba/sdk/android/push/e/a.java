package com.alibaba.sdk.android.push.e;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import anet.channel.AwcnConfig;
import anet.channel.util.AppLifecycle;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.ams.common.util.StringUtil;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.PushControlService;
import com.alibaba.sdk.android.push.common.util.AppInfoUtil;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.AccsState;
import com.taobao.accs.ConnectionListener;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoRegister;
import com.ut.device.UTDevice;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AmsLogger f4912e = AmsLogger.getLogger("MPS:AppRegister");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static a f4913f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final IntentFilter f4914g = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final IntentFilter f4915h = new IntentFilter("android.intent.action.USER_PRESENT");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile HandlerThreadC0071a<d> f4916a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final b f4920i = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f4917b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f4918c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f4919d = true;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.push.e.a$a, reason: collision with other inner class name */
    public class HandlerThreadC0071a<Token> extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f4927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Handler f4928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c<Token> f4929c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile int f4930d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4931e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Token f4933g;

        public HandlerThreadC0071a() {
            super("ConnectionWorker");
            this.f4930d = 0;
            this.f4931e = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Finally extract failed */
        public e a(Token token) {
            e eVar;
            Context contextA = com.alibaba.sdk.android.ams.common.a.a.a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    if (!com.alibaba.sdk.android.push.common.util.c.a(contextA.getApplicationContext())) {
                        this.f4931e = 2;
                        e eVar2 = new e(com.alibaba.sdk.android.push.common.global.c.f4875a);
                        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                        try {
                            a.f4912e.i("connState=" + this.f4931e + ";estimatedTime=" + jCurrentTimeMillis2 + ";response{msg: " + eVar2.a().getMsg() + ", code: " + eVar2.a().getCode() + com.alipay.sdk.m.u.i.f5699d, null, 1);
                        } catch (Exception e2) {
                            a.f4912e.e("ut log error", e2);
                        }
                        return eVar2;
                    }
                    if (this.f4931e == 0) {
                        a.f4912e.d("is debug：" + com.alibaba.sdk.android.push.common.global.b.d());
                        if (com.alibaba.sdk.android.push.common.global.b.d()) {
                            a.this.j();
                            a.this.i();
                        }
                        a(contextA);
                    }
                    if (com.alibaba.sdk.android.ams.common.a.a.f() && !com.alibaba.sdk.android.ams.common.a.a.b() && !com.alibaba.sdk.android.push.notification.e.a(contextA)) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        while (!com.alibaba.sdk.android.push.notification.e.a(contextA) && SystemClock.elapsedRealtime() - jElapsedRealtime < 10000) {
                            Thread.sleep(1000L);
                            a.f4912e.d("wait for app come to foreground");
                        }
                        try {
                            if (!com.alibaba.sdk.android.push.notification.e.a(contextA)) {
                                AwcnConfig.setIpv6Enable(false);
                                a.f4912e.d("APP is background, disable ipv6 test");
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    int i2 = this.f4931e;
                    if (i2 == 1) {
                        a.f4912e.d("accs init.");
                        e eVarB = b(contextA);
                        long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                        if (eVarB != null) {
                            try {
                                a.f4912e.i("connState=" + this.f4931e + ";estimatedTime=" + jCurrentTimeMillis3 + ";response{msg: " + eVarB.a().getMsg() + ", code: " + eVarB.a().getCode() + com.alipay.sdk.m.u.i.f5699d, null, 1);
                            } catch (Exception e3) {
                                a.f4912e.e("ut log error", e3);
                            }
                        }
                        return eVarB;
                    }
                    if (i2 == 2) {
                        a.f4912e.d("accs connected.setBindStop.");
                        eVar = null;
                    } else {
                        a.f4912e.e("cant entry this block...");
                        eVar = new e(com.alibaba.sdk.android.push.common.global.c.l);
                    }
                    long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis;
                    if (eVar != null) {
                        try {
                            a.f4912e.i("connState=" + this.f4931e + ";estimatedTime=" + jCurrentTimeMillis4 + ";response{msg: " + eVar.a().getMsg() + ", code: " + eVar.a().getCode() + com.alipay.sdk.m.u.i.f5699d, null, 1);
                        } catch (Exception e4) {
                            a.f4912e.e("ut log error", e4);
                        }
                    }
                    return eVar;
                } catch (com.alibaba.sdk.android.push.a.f e5) {
                    a.f4912e.d("Catch StopProcessException: " + e5.a() + " stack:" + Log.getStackTraceString(e5));
                    e eVar3 = new e(e5.a());
                    long jCurrentTimeMillis5 = System.currentTimeMillis() - jCurrentTimeMillis;
                    try {
                        a.f4912e.i("connState=" + this.f4931e + ";estimatedTime=" + jCurrentTimeMillis5 + ";response{msg: " + eVar3.a().getMsg() + ", code: " + eVar3.a().getCode() + com.alipay.sdk.m.u.i.f5699d, null, 1);
                    } catch (Exception e6) {
                        a.f4912e.e("ut log error", e6);
                    }
                    return eVar3;
                } catch (Throwable th) {
                    a.f4912e.d("Catch RuntimeException: " + th.getMessage());
                    e eVar4 = new e(com.alibaba.sdk.android.push.common.global.c.k.copy().msg(th.getMessage()).detail(Log.getStackTraceString(th)).build());
                    long jCurrentTimeMillis6 = System.currentTimeMillis() - jCurrentTimeMillis;
                    try {
                        a.f4912e.i("connState=" + this.f4931e + ";estimatedTime=" + jCurrentTimeMillis6 + ";response{msg: " + eVar4.a().getMsg() + ", code: " + eVar4.a().getCode() + com.alipay.sdk.m.u.i.f5699d, null, 1);
                    } catch (Exception e7) {
                        a.f4912e.e("ut log error", e7);
                    }
                    return eVar4;
                }
            } catch (Throwable th2) {
                System.currentTimeMillis();
                throw th2;
            }
        }

        private void a(Context context) throws com.alibaba.sdk.android.push.a.f {
            a.f4912e.d("load utdid: " + UTDevice.getUtdid(context));
            com.alibaba.sdk.android.ams.common.b.b bVarA = com.alibaba.sdk.android.ams.common.b.c.a();
            String strC = bVarA.c();
            a.f4912e.d("vip init.");
            String strB = bVarA.b();
            if (!StringUtil.isEmpty(strB) && !StringUtil.isBlank(strC) && strC.equals(UTDevice.getUtdid(context))) {
                AmsLogger.getImportantLogger().i("Got deviceId from preference: " + strB);
                this.f4931e = 1;
                return;
            }
            String strC2 = c();
            AmsLogger.getImportantLogger().i("Got deviceId from remote server: " + strC2);
            if (StringUtil.isEmpty(strC2)) {
                throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.f4881g.copy().msg("获取设备ID失败").detail("getDeviceIdFromServer").build());
            }
            bVarA.a(strC2);
            bVarA.b(UTDevice.getUtdid(context));
            this.f4931e = 1;
            AmsLogger.getImportantLogger().i("vip init success");
        }

        private e b(Context context) {
            String stateByKey;
            a.f4912e.d("initAccsChannel...");
            a.a.r.a.init(context.getApplicationContext());
            com.alibaba.sdk.android.ams.common.b.b bVarA = com.alibaba.sdk.android.ams.common.b.c.a();
            String strA = bVarA.a();
            String strD = bVarA.d();
            AmsLogger.getImportantLogger().i("register agoo appkey:" + strA);
            final com.alibaba.sdk.android.push.util.c cVar = new com.alibaba.sdk.android.push.util.c();
            final e[] eVarArr = {null};
            try {
                a.f4912e.d("init aliyun accs. context:" + context.getPackageName() + " -- appkey:" + strA);
                ACCSClient.getAccsClient("AliyunPush").cleanLocalBindInfo();
                AppLifecycle.onForeground();
                TaobaoRegister.register(context.getApplicationContext(), "AliyunPush", strA, strD, "aliyun", new IRegister() { // from class: com.alibaba.sdk.android.push.e.a.a.2
                    @Override // com.taobao.agoo.IRegister, com.taobao.agoo.ICallback
                    public void onFailure(String str, String str2) {
                        AmsLogger.getImportantLogger().i("agoo errorcode:" + str + ";errorMsg:" + str2);
                        eVarArr[0] = new e(com.alibaba.sdk.android.push.common.global.c.a(str, str2).detail(com.taobao.agoo.a.a.c.JSON_CMD_REGISTER).build());
                        cVar.a();
                    }

                    @Override // com.taobao.agoo.IRegister
                    public void onSuccess(String str) {
                        AmsLogger.getImportantLogger().i("agoo init success.");
                        HandlerThreadC0071a.this.f4931e = 2;
                        eVarArr[0] = new e(com.alibaba.sdk.android.push.common.global.c.f4875a);
                        cVar.a();
                    }
                });
            } catch (Throwable th) {
                a.f4912e.e("accs config failed", th);
                eVarArr[0] = new e(com.alibaba.sdk.android.push.common.global.c.k.copy().msg(th.getMessage()).detail(Log.getStackTraceString(th)).build());
                cVar.a();
            }
            if (!com.alibaba.sdk.android.push.common.util.c.a(context.getApplicationContext())) {
                a.this.f4919d = true;
                a.f4912e.d("not main process");
                return new e(com.alibaba.sdk.android.push.common.global.c.n);
            }
            a.f4912e.d("lock" + cVar.toString());
            cVar.a(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME);
            if (eVarArr[0] == null) {
                try {
                    stateByKey = AccsState.getInstance().getStateByKey("re");
                } catch (Exception unused) {
                    stateByKey = "accs time out";
                }
                eVarArr[0] = new e(com.alibaba.sdk.android.push.common.global.c.o.copy().msg(stateByKey).detail("connected:" + a.this.c()).build());
            }
            AmsLogger.getImportantLogger().d("register agoo result " + eVarArr[0].a());
            return eVarArr[0];
        }

        private String c() {
            com.alibaba.sdk.android.ams.common.b.b bVarA = com.alibaba.sdk.android.ams.common.b.c.a();
            String strG = com.alibaba.sdk.android.ams.common.a.a.g();
            Context contextA = com.alibaba.sdk.android.ams.common.a.a.a();
            HttpURLConnection httpURLConnection = null;
            try {
                try {
                    HashMap map = new HashMap();
                    map.put(Constants.KEY_APP_KEY, bVarA.a());
                    map.put("deviceId", UTDevice.getUtdid(contextA));
                    map.put("version", "3.10.1");
                    map.put("utdid", UTDevice.getUtdid(contextA));
                    map.put("os", "2");
                    map.put(AbsServerManager.PACKAGE_QUERY_BINDER, com.alibaba.sdk.android.ams.common.a.a.i());
                    try {
                        HttpURLConnection httpURLConnectionA = com.alibaba.sdk.android.ams.common.util.a.a(strG, com.alibaba.sdk.android.ams.common.util.c.a(map), "POST");
                        if (httpURLConnectionA == null) {
                            a.f4912e.e("failed to loadConfigFromRemote!");
                            throw new com.alibaba.sdk.android.push.common.util.a.a(com.alibaba.sdk.android.push.common.global.c.p.copy().msg("getDeviceId创建请求连接失败").build());
                        }
                        String strA = i.a(com.alibaba.sdk.android.push.common.util.a.d.CONFIG.a(), httpURLConnectionA);
                        httpURLConnectionA.disconnect();
                        return strA;
                    } catch (IOException e2) {
                        throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.p.copy().msg(e2.getMessage()).detail(Log.getStackTraceString(e2)).build());
                    }
                } catch (com.alibaba.sdk.android.push.a.f e3) {
                    throw e3;
                } catch (Throwable th) {
                    a.f4912e.w("loadConfigFromRemote failed! error:", th);
                    throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.k.copy().msg(th.getMessage()).detail(Log.getStackTraceString(th)).build());
                }
            } catch (Throwable th2) {
                if (0 != 0) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        }

        public synchronized void a() {
            Handler handler;
            this.f4930d = 0;
            if ((!a.this.f4919d || this.f4931e != 2) && (handler = this.f4927a) != null) {
                handler.sendMessage(handler.obtainMessage(1, this.f4933g));
            }
        }

        public void a(c<Token> cVar) {
            this.f4929c = cVar;
        }

        public synchronized boolean a(e eVar) {
            if (this.f4931e == 2 || this.f4930d >= 5) {
                return false;
            }
            a.f4912e.d("init retry:" + this.f4930d);
            this.f4930d = this.f4930d + 1;
            Handler handler = this.f4927a;
            if (handler != null) {
                handler.sendMessageDelayed(handler.obtainMessage(2, this.f4933g), ((int) Math.pow(3.0d, this.f4930d)) * 5000);
            }
            return true;
        }

        public void b() {
            this.f4927a.removeMessages(1);
            this.f4927a.removeMessages(2);
        }

        @Override // android.os.HandlerThread
        @SuppressLint({"HandlerLeak"})
        public void onLooperPrepared() {
            this.f4928b = new Handler(Looper.getMainLooper());
            this.f4927a = new Handler() { // from class: com.alibaba.sdk.android.push.e.a.a.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    final e eVarA;
                    int i2 = message.what;
                    if (i2 == 1 || i2 == 2) {
                        final Object obj = message.obj;
                        a.f4912e.d("Looping handleMessage: " + message.what);
                        if (message.what == 1) {
                            removeMessages(2);
                        }
                        if (a.this.f4919d || (eVarA = HandlerThreadC0071a.this.a(obj)) == null) {
                            return;
                        }
                        if (!HandlerThreadC0071a.this.a(eVarA) || HandlerThreadC0071a.this.f4930d <= 1) {
                            HandlerThreadC0071a.this.f4928b.post(new Runnable() { // from class: com.alibaba.sdk.android.push.e.a.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    HandlerThreadC0071a.this.f4929c.a((Token) obj, eVarA);
                                }
                            });
                        }
                    }
                }
            };
            a.f4912e.d("Looping Prepared.");
            a.this.f4917b = true;
            a();
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (intent.getBooleanExtra("noConnectivity", false)) {
                        a.f4912e.e("Network has lost");
                        return;
                    } else if (a.this.f4919d || !a.this.f4917b) {
                        return;
                    }
                } else if (!"android.intent.action.USER_PRESENT".equals(intent.getAction()) || !com.alibaba.sdk.android.push.common.util.a.a(context) || a.this.f4919d || !a.this.f4917b) {
                    return;
                }
                a.this.f4916a.a();
            }
        }
    }

    private a() {
    }

    public static a a() {
        if (f4913f == null) {
            synchronized (a.class) {
                if (f4913f == null) {
                    f4913f = new a();
                }
            }
        }
        return f4913f;
    }

    private void b(boolean z, long j) {
        Context contextA = com.alibaba.sdk.android.ams.common.a.a.a();
        final com.alibaba.sdk.android.ams.common.b.b bVarA = com.alibaba.sdk.android.ams.common.b.c.a();
        String strA = bVarA.a();
        AmsLogger.getImportantLogger().i("init agoo config appkey:" + strA);
        String strD = bVarA.d();
        if (com.alibaba.sdk.android.ams.common.a.a.f()) {
            try {
                AwcnConfig.setWifiInfoEnable(false);
            } catch (Throwable unused) {
            }
            try {
                AwcnConfig.setCarrierInfoEnable(false);
            } catch (Throwable unused2) {
            }
        }
        try {
            AwcnConfig.setAccsSessionCreateForbiddenInBg(false);
        } catch (Throwable unused3) {
        }
        try {
            TaobaoRegister.setEnv(contextA, 0);
            AccsClientConfig accsClientConfigBuild = new AccsClientConfig.Builder().setAppKey(strA).setAppSecret(strD).setTag("AliyunPush").setInappHost(com.alibaba.sdk.android.ams.common.a.a.d()).setChannelHost(com.alibaba.sdk.android.ams.common.a.a.e()).setAccsHeartbeatEnable(true).setConfigEnv(0).loopChannelStart(z).loopChannelInterval(j).build();
            TaobaoRegister.setAccsConfigTag(contextA, "AliyunPush");
            ACCSClient.init(contextA, accsClientConfigBuild);
            TaobaoRegister.setReportPushArrive(new c.a.a.a.a.d() { // from class: com.alibaba.sdk.android.push.e.a.1
                @Override // c.a.a.a.a.d
                public void reportPushArrive(Context context, String str, int i2) {
                    com.alibaba.sdk.android.push.c.a aVarA = com.alibaba.sdk.android.push.c.a.a(context);
                    if (aVarA != null) {
                        aVarA.a(bVarA.b(), str, i2);
                    }
                }
            });
        } catch (AccsException e2) {
            e2.printStackTrace();
        }
    }

    private void h() {
        Context contextA = com.alibaba.sdk.android.ams.common.a.a.a();
        if (com.alibaba.sdk.android.push.common.util.c.a(contextA)) {
            try {
                contextA.registerReceiver(this.f4920i, f4914g);
                contextA.registerReceiver(this.f4920i, f4915h);
            } catch (Exception e2) {
                f4912e.e("Fail to register broad", e2);
            }
        }
        if (AdapterUtilityImpl.isChannelProcess(contextA)) {
            com.alibaba.sdk.android.push.b.a.a(contextA);
            com.alibaba.sdk.android.push.b.a.a().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() throws com.alibaba.sdk.android.push.a.f {
        String strE = com.alibaba.sdk.android.ams.common.b.c.a().e();
        if (StringUtil.isEmpty(strE) || strE.length() > 32) {
            throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.r);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws com.alibaba.sdk.android.push.a.f {
        for (com.alibaba.sdk.android.push.common.global.a aVar : com.alibaba.sdk.android.push.common.global.a.values()) {
            if (!AppInfoUtil.isComponentExists(com.alibaba.sdk.android.ams.common.a.a.a(), aVar.a(), aVar.b())) {
                if (aVar.c()) {
                    throw new com.alibaba.sdk.android.push.a.f(com.alibaba.sdk.android.push.common.global.c.s.copy().msg(aVar.a() + "未配置").build());
                }
                f4912e.w("未配置" + aVar.a() + "; 建议配置,可有效提高推送到达率");
            }
        }
    }

    public synchronized void a(final CommonCallback commonCallback) {
        if (this.f4918c) {
            AmsLogger.getImportantLogger().d("Already startReg, skip.");
            if (commonCallback != null) {
                ErrorCode errorCode = com.alibaba.sdk.android.push.common.global.c.w;
                commonCallback.onFailed(errorCode.getCode(), errorCode.getMsg());
            }
            return;
        }
        this.f4918c = true;
        h();
        this.f4919d = false;
        if (this.f4916a != null) {
            try {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.f4916a.quitSafely();
                } else {
                    this.f4916a.quit();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f4916a = new HandlerThreadC0071a<>();
        this.f4916a.a(new c<d>() { // from class: com.alibaba.sdk.android.push.e.a.2
            @Override // com.alibaba.sdk.android.push.e.c
            public void a(d dVar, e eVar) {
                if (eVar.a().getCode().equals(com.alibaba.sdk.android.push.common.global.c.f4875a.getCode())) {
                    synchronized (a.class) {
                        a.this.f4919d = true;
                        a.this.f4917b = false;
                        a.this.f4916a.b();
                        a.this.f4916a.quit();
                        Context contextA = com.alibaba.sdk.android.ams.common.a.a.a();
                        if (com.alibaba.sdk.android.push.common.util.c.a(contextA)) {
                            try {
                                contextA.unregisterReceiver(a.this.f4920i);
                            } catch (Exception e3) {
                                a.f4912e.e("Fail to unregister broad", e3);
                            }
                        }
                    }
                }
                com.alibaba.sdk.android.push.e.b.a(commonCallback, eVar);
            }
        });
        this.f4916a.start();
        f4912e.d("getLooper called.");
    }

    public void a(final PushControlService.ConnectionChangeListener connectionChangeListener) {
        try {
            ACCSClient.getAccsClient("AliyunPush").addConnectionListener(new ConnectionListener() { // from class: com.alibaba.sdk.android.push.e.a.3
                @Override // com.taobao.accs.ConnectionListener
                public void onConnect() {
                    connectionChangeListener.onConnect();
                }

                @Override // com.taobao.accs.ConnectionListener
                public void onDisconnect(int i2, String str) {
                    ErrorCode errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.a(i2, str).build();
                    connectionChangeListener.onDisconnect(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
                }
            });
        } catch (AccsException e2) {
            e2.printStackTrace();
        }
    }

    public void a(boolean z, long j) {
        b(z, j);
    }

    public void b() {
        b(false, 0L);
    }

    public boolean c() {
        try {
            return ACCSClient.getAccsClient("AliyunPush").isConnected();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void d() {
        try {
            ACCSClient.getAccsClient("AliyunPush").reconnect();
        } catch (AccsException e2) {
            e2.printStackTrace();
        }
    }

    public void e() {
        TaobaoRegister.reset();
        this.f4918c = false;
    }

    public void f() {
        try {
            ACCSClient.getAccsClient("AliyunPush").disconnect();
        } catch (AccsException e2) {
            e2.printStackTrace();
        }
    }
}
