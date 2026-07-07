package com.taobao.accs.internal;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.IChannelInit;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.g;
import com.taobao.accs.messenger.MessengerService;
import com.taobao.accs.net.w;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.f;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceImpl extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Service f10314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f10315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f10316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f10317e;

    public ServiceImpl(Service service) {
        super(service);
        this.f10317e = "unknown";
        this.f10314b = service;
        this.f10315c = service.getApplicationContext();
    }

    private void b(Intent intent) {
        Message.ReqType reqType;
        URL url;
        Message messageA;
        Message messageA2;
        int intExtra = intent.getIntExtra("command", -1);
        ALog.i("ServiceImpl", "handleCommand", "command", Integer.valueOf(intExtra));
        String stringExtra = intent.getStringExtra("packageName");
        String stringExtra2 = intent.getStringExtra(Constants.KEY_SERVICE_ID);
        String stringExtra3 = intent.getStringExtra(Constants.KEY_USER_ID);
        String stringExtra4 = intent.getStringExtra(Constants.KEY_APP_KEY);
        String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
        String stringExtra6 = intent.getStringExtra(Constants.KEY_TTID);
        intent.getStringExtra("sid");
        intent.getStringExtra(Constants.KEY_ANTI_BRUSH_COOKIE);
        if (intExtra == 201) {
            a(Message.a(true, 0), true);
            d();
        }
        if (intExtra <= 0 || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        com.taobao.accs.net.b bVarA = d.a(this.f10315c, stringExtra5, true);
        if (bVarA == null) {
            ALog.e("ServiceImpl", "no connection", Constants.KEY_CONFIG_TAG, stringExtra5, "command", Integer.valueOf(intExtra));
            return;
        }
        bVarA.a();
        if (intExtra != 1) {
            if (intExtra == 2) {
                ALog.e("ServiceImpl", "onHostStartCommand COMMAND_UNBIND_APP", new Object[0]);
                if (bVarA.j().e(stringExtra)) {
                    Message messageA3 = Message.a(bVarA, stringExtra);
                    ALog.i("ServiceImpl", stringExtra + " isAppUnbinded", new Object[0]);
                    bVarA.a(messageA3, AccsErrorCode.SUCCESS);
                    return;
                }
            } else if (intExtra == 5) {
                messageA2 = Message.a(stringExtra, stringExtra2);
            } else if (intExtra == 6) {
                messageA2 = Message.b(stringExtra, stringExtra2);
            } else if (intExtra == 3) {
                messageA2 = Message.c(stringExtra, stringExtra3);
            } else if (intExtra == 4) {
                messageA2 = Message.a(stringExtra);
            } else if (intExtra == 100) {
                byte[] byteArrayExtra = intent.getByteArrayExtra("data");
                String stringExtra7 = intent.getStringExtra(Constants.KEY_DATA_ID);
                String stringExtra8 = intent.getStringExtra(Constants.KEY_TARGET);
                String stringExtra9 = intent.getStringExtra(Constants.KEY_BUSINESSID);
                String stringExtra10 = intent.getStringExtra(Constants.KEY_EXT_TAG);
                try {
                    reqType = (Message.ReqType) intent.getSerializableExtra(Constants.KEY_SEND_TYPE);
                } catch (Exception unused) {
                    reqType = null;
                }
                if (byteArrayExtra != null) {
                    try {
                        url = new URL("https://" + ((w) bVarA).r());
                    } catch (Exception unused2) {
                        url = null;
                    }
                    ACCSManager.AccsRequest accsRequest = new ACCSManager.AccsRequest(stringExtra3, stringExtra2, byteArrayExtra, stringExtra7, stringExtra8, url, stringExtra9);
                    accsRequest.setTag(stringExtra10);
                    if (reqType == null) {
                        messageA = Message.a(bVarA, this.f10315c, stringExtra, accsRequest, false);
                    } else if (reqType == Message.ReqType.REQ) {
                        messageA = Message.a(bVarA, this.f10315c, stringExtra, Constants.TARGET_SERVICE_PRE, accsRequest, false);
                    }
                    messageA2 = messageA;
                }
            } else if (intExtra == 106) {
                intent.setAction(Constants.ACTION_RECEIVE);
                intent.putExtra("command", -1);
                g.a(this.f10315c, intent);
                return;
            }
            messageA2 = null;
        } else {
            if (!stringExtra.equals(this.f10315c.getPackageName())) {
                ALog.e("ServiceImpl", "handleCommand bindapp pkg error", new Object[0]);
                return;
            }
            messageA2 = Message.a(this.f10315c, stringExtra5, stringExtra4, intent.getStringExtra("app_sercet"), stringExtra, stringExtra6, intent.getStringExtra("appVersion"));
            bVarA.f10351a = stringExtra6;
            UtilityImpl.e(this.f10315c, stringExtra4);
            if (bVarA.j().d(stringExtra) && !intent.getBooleanExtra(Constants.KEY_FOUCE_BIND, false)) {
                ALog.i("ServiceImpl", stringExtra + " isAppBinded", new Object[0]);
                bVarA.a(messageA2, AccsErrorCode.SUCCESS);
                return;
            }
        }
        if (messageA2 == null) {
            ALog.e("ServiceImpl", "message is null", new Object[0]);
            bVarA.a(Message.a(stringExtra, intExtra), AccsErrorCode.PARAMETER_ERROR);
        } else {
            ALog.d("ServiceImpl", "try send message", new Object[0]);
            if (messageA2.e() != null) {
                messageA2.e().onSend();
            }
            bVarA.b(messageA2, true);
        }
    }

    private void c() {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.f10324a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.b>> it = d.f10324a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b();
        }
    }

    private void d() {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.f10324a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.b>> it = d.f10324a.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.accs.ut.a.c cVarC = it.next().getValue().c();
            if (cVarC != null) {
                cVarC.f10438h = this.f10316d;
                cVarC.a();
            }
        }
    }

    private void e() {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.f10324a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.b>> it = d.f10324a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().e();
        }
    }

    @Override // com.taobao.accs.internal.d
    public int a(Intent intent) {
        String action;
        Bundle extras;
        int i2 = 2;
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("ServiceImpl", "onHostStartCommand", MessengerService.INTENT, intent);
        }
        try {
            if (ALog.isPrintLog(ALog.Level.D) && intent != null && (extras = intent.getExtras()) != null) {
                for (String str : extras.keySet()) {
                    ALog.d("ServiceImpl", "onHostStartCommand", "key", str, " value", extras.get(str));
                }
            }
            int iC = f.c();
            if (iC > 3) {
                try {
                    ALog.e("ServiceImpl", "onHostStartCommand load SO fail 4 times, don't auto restart", new Object[0]);
                    AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_POINT_SOFAIL, UtilityImpl.a(iC), 0.0d);
                } catch (Throwable th) {
                    th = th;
                    try {
                        ALog.e("ServiceImpl", "onHostStartCommand", th, new Object[0]);
                    } finally {
                        AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
                    }
                }
            } else {
                i2 = 1;
            }
            action = intent == null ? null : intent.getAction();
        } catch (Throwable th2) {
            th = th2;
            i2 = 1;
        }
        if (!TextUtils.isEmpty(action)) {
            a(intent, action);
            return i2;
        }
        b();
        a(false, false);
        return i2;
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public void onDestroy() {
        super.onDestroy();
        ALog.e("ServiceImpl", "Service onDestroy", new Object[0]);
        UtilityImpl.a(this.f10315c, Constants.SP_KEY_SERVICE_END, System.currentTimeMillis());
        this.f10314b = null;
        this.f10315c = null;
        e();
        Process.killProcess(Process.myPid());
    }

    @Override // com.taobao.accs.internal.d, com.taobao.accs.base.IBaseService
    public boolean onUnbind(Intent intent) {
        return false;
    }

    private void a(Context context) {
        List<String> listM = UtilityImpl.m(context);
        ArrayList arrayList = new ArrayList();
        if (listM != null && listM.size() > 0) {
            for (int i2 = 0; i2 < listM.size(); i2++) {
                try {
                    Class<?> cls = Class.forName(listM.get(i2));
                    if (IChannelInit.class.isAssignableFrom(cls)) {
                        try {
                            ((IChannelInit) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0])).init(context);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        arrayList.add(listM.get(i2));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        if (arrayList.size() > 0) {
            UtilityImpl.a(context, arrayList);
        }
    }

    private void a() {
        ALog.d("ServiceImpl", "init start", new Object[0]);
        a(this.f10315c);
        GlobalClientInfo.getInstance(this.f10315c);
        AdapterGlobalClientInfo.mStartServiceTimes.incrementAndGet();
        this.f10316d = System.currentTimeMillis();
        this.f10317e = UtilityImpl.f(this.f10315c);
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i("ServiceImpl", "init", Constants.KEY_SDK_VERSION, Integer.valueOf(Constants.SDK_VERSION_CODE), "procStart", Integer.valueOf(AdapterGlobalClientInfo.mStartServiceTimes.intValue()));
        }
        UTMini.getInstance().commitEvent(66001, "START", UtilityImpl.f(), "PROXY");
        long jH = UtilityImpl.h(this.f10315c);
        ALog.d("ServiceImpl", "getServiceAliveTime", "aliveTime", Long.valueOf(jH));
        if (jH > 20000) {
            AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_SERVICE_ALIVE, "", jH / 1000);
        }
        UtilityImpl.a(this.f10315c, Constants.SP_KEY_SERVICE_START, System.currentTimeMillis());
        UTMini.getInstance().commitEvent(66001, "NOTIFY", UtilityImpl.k(this.f10315c));
    }

    private void a(Intent intent, String str) {
        ALog.d("ServiceImpl", "handleAction", "action", str);
        try {
            b();
            if (TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
                return;
            }
            if (TextUtils.equals(str, "android.net.conn.CONNECTIVITY_CHANGE")) {
                String strF = UtilityImpl.f(this.f10315c);
                boolean zG = UtilityImpl.g(this.f10315c);
                ALog.i("ServiceImpl", "network change:" + this.f10317e + " to " + strF, new Object[0]);
                if (zG) {
                    this.f10317e = strF;
                    c();
                    a(true, false);
                    UTMini.getInstance().commitEvent(66001, "CONNECTIVITY_CHANGE", strF, UtilityImpl.f(), "0");
                }
                if ("unknown".equals(strF)) {
                    c();
                    this.f10317e = strF;
                    return;
                }
                return;
            }
            if (TextUtils.equals(str, "android.intent.action.BOOT_COMPLETED")) {
                a(true, false);
                return;
            }
            if (TextUtils.equals(str, "android.intent.action.USER_PRESENT")) {
                ALog.d("ServiceImpl", "action android.intent.action.USER_PRESENT", new Object[0]);
                a(true, false);
            } else if (str.equals(Constants.ACTION_COMMAND)) {
                b(intent);
            }
        } catch (Throwable th) {
            ALog.e("ServiceImpl", "handleAction", th, new Object[0]);
        }
    }

    private synchronized void b() {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.f10324a;
        if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
            for (Map.Entry<String, com.taobao.accs.net.b> entry : d.f10324a.entrySet()) {
                com.taobao.accs.net.b value = entry.getValue();
                if (value == null) {
                    ALog.e("ServiceImpl", "tryConnect connection null", "appkey", value.i());
                    return;
                }
                ALog.i("ServiceImpl", "tryConnect", "appkey", value.i(), Constants.KEY_CONFIG_TAG, entry.getKey());
                if (value.k() && TextUtils.isEmpty(value.f10359i.getAppSecret())) {
                    ALog.e("ServiceImpl", "tryConnect secret is null", new Object[0]);
                } else {
                    value.a();
                }
            }
            return;
        }
        ALog.w("ServiceImpl", "tryConnect no connections", new Object[0]);
    }

    private void a(Message message, boolean z) {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.f10324a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.b>> it = d.f10324a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().b(message, z);
        }
    }

    private void a(boolean z, boolean z2) {
        ConcurrentHashMap<String, com.taobao.accs.net.b> concurrentHashMap = d.f10324a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, com.taobao.accs.net.b>> it = d.f10324a.entrySet().iterator();
        while (it.hasNext()) {
            com.taobao.accs.net.b value = it.next().getValue();
            value.a(z, z2);
            ALog.i("ServiceImpl", "ping connection", "appkey", value.i());
        }
    }
}
