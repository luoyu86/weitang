package com.taobao.accs.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import anet.channel.SessionCenter;
import com.alibaba.sdk.android.logger.ILog;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.AccsState;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.data.g;
import com.taobao.accs.net.j;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.AccsLogger;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.AppMonitorAdapter;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ACCSManagerImpl implements IACCSManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.taobao.accs.net.b f10309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f10310b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f10311c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ILog f10313e;

    public ACCSManagerImpl(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        GlobalClientInfo.f10249a = applicationContext;
        this.f10309a = new j(applicationContext, 1, str);
        this.f10312d = str;
        this.f10313e = AccsLogger.getLogger("ACCSMgrImpl_" + this.f10309a.m);
        ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new a(this, str, context), 64L, TimeUnit.MILLISECONDS);
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindApp(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        bindApp(context, str, "accs", str2, iAppReceiver);
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindService(Context context, String str) {
        this.f10313e.i("bindService", Constants.KEY_SERVICE_ID, str);
        if (a(context)) {
            a(context, 5, str, (String) null);
            return;
        }
        Intent intentA = a(context, 5);
        String strI = this.f10309a.i();
        if (TextUtils.isEmpty(strI)) {
            this.f10313e.e("appKey null");
            return;
        }
        intentA.putExtra(Constants.KEY_APP_KEY, strI);
        intentA.putExtra(Constants.KEY_SERVICE_ID, str);
        if (AdapterUtilityImpl.isTargetProcess(context)) {
            Message messageB = Message.b(this.f10309a, intentA);
            if (messageB.e() != null) {
                messageB.e().setDataId(messageB.f10273q);
                messageB.e().setMsgType(3);
                NetPerformanceMonitor netPerformanceMonitorE = messageB.e();
                URL url = messageB.f10269f;
                netPerformanceMonitorE.setHost(url != null ? url.toString() : "");
            }
            a(context, messageB, 5, false);
        } else {
            this.f10313e.w("bindService not target process, ignored");
        }
        this.f10309a.b(context.getApplicationContext());
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindUser(Context context, String str) {
        bindUser(context, str, false);
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean cancel(Context context, String str) {
        return this.f10309a.a(str);
    }

    @Override // com.taobao.accs.IACCSManager
    public void cleanLocalBindInfo() {
        this.f10309a.j().a();
    }

    @Override // com.taobao.accs.IACCSManager
    public void clearLoginInfo(Context context) {
        GlobalClientInfo.getInstance(context).clearLoginInfoImpl();
    }

    @Override // com.taobao.accs.IACCSManager
    public void disconnect() {
        this.f10309a.n();
    }

    @Override // com.taobao.accs.IACCSManager
    public void forceDisableService(Context context) {
    }

    @Override // com.taobao.accs.IACCSManager
    public void forceEnableService(Context context) {
    }

    @Override // com.taobao.accs.IACCSManager
    public Map<String, Boolean> forceReConnectChannel() throws Exception {
        SessionCenter.getInstance(this.f10309a.f10359i.getAppKey()).forceRecreateAccsSession();
        return getChannelState();
    }

    @Override // com.taobao.accs.IACCSManager
    public Map<String, Boolean> getChannelState() throws Exception {
        String strB = this.f10309a.b((String) null);
        HashMap map = new HashMap();
        map.put(strB, Boolean.FALSE);
        if (SessionCenter.getInstance(this.f10309a.f10359i.getAppKey()).getThrowsException(strB, 60000L) != null) {
            map.put(strB, Boolean.TRUE);
        }
        this.f10313e.i("getChannelState", map);
        return map;
    }

    @Override // com.taobao.accs.IACCSManager
    public int getLastConnectErrorCode() {
        return this.f10309a.m();
    }

    @Override // com.taobao.accs.IACCSManager
    public String getUserUnit() {
        return null;
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isChannelError(int i2) {
        return AccsErrorCode.isChannelError(i2);
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isConnected() {
        return this.f10309a.l();
    }

    @Override // com.taobao.accs.IACCSManager
    public boolean isNetworkReachable(Context context) {
        return UtilityImpl.g(context);
    }

    @Override // com.taobao.accs.IACCSManager
    public void reconnect() {
        this.f10309a.o();
    }

    @Override // com.taobao.accs.IACCSManager
    public void registerDataListener(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        GlobalClientInfo.getInstance(context).registerListener(str, accsAbstractDataListener);
    }

    @Override // com.taobao.accs.IACCSManager
    public void registerService(Context context, String str, String str2) {
        GlobalClientInfo.getInstance(context).registerService(str, str2);
    }

    @Override // com.taobao.accs.IACCSManager
    public void reset() {
        this.f10309a.p();
        try {
            SharedPreferences.Editor editorEdit = GlobalClientInfo.f10249a.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            editorEdit.clear();
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.taobao.accs.client.a.a().b(this.f10312d);
        this.f10311c = false;
    }

    @Override // com.taobao.accs.IACCSManager
    public void sendBusinessAck(String str, String str2, String str3, short s, String str4, Map<Integer, String> map) {
        this.f10309a.a();
        this.f10309a.b(Message.a(this.f10309a, str, str2, str3, true, s, str4, map), true);
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3) {
        return sendData(context, str, str2, bArr, str3, null);
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendPushResponse(Context context, ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        try {
            if (context == null || accsRequest == null) {
                this.f10313e.e("sendPushResponse input null", context, accsRequest, MediationConstant.KEY_EXTRA_INFO, extraInfo);
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "sendPushResponse null");
                return null;
            }
            AppMonitorAdapter.commitAlarmSuccess("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "push response total");
            if (TextUtils.isEmpty(this.f10309a.i())) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "sendPushResponse appkey null");
                this.f10313e.e("sendPushResponse appkey null", "dataid", accsRequest.dataId);
                return null;
            }
            if (TextUtils.isEmpty(accsRequest.dataId)) {
                synchronized (ACCSManagerImpl.class) {
                    this.f10310b++;
                    accsRequest.dataId = this.f10310b + "";
                }
            }
            if (extraInfo == null) {
                extraInfo = new TaoBaseService.ExtraInfo();
            }
            accsRequest.host = null;
            String packageName = context.getPackageName();
            extraInfo.fromPackage = packageName;
            this.f10313e.i("sendPushResponse", "host", extraInfo.fromHost, "pkg", packageName, Constants.KEY_DATA_ID, accsRequest.dataId);
            if (context.getPackageName().equals(extraInfo.fromPackage) && AdapterUtilityImpl.isTargetProcess(context)) {
                sendRequest(context, accsRequest, context.getPackageName(), true);
            }
        } catch (Throwable th) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "push response " + th.toString());
            this.f10313e.e("sendPushResponse", Constants.KEY_DATA_ID, accsRequest.dataId, th);
        }
        return null;
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendRequest(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.IACCSManager
    public void setLoginInfo(Context context, ILoginInfo iLoginInfo) {
        GlobalClientInfo.getInstance(context).setLoginInfoImpl(this.f10309a.m, iLoginInfo);
    }

    @Override // com.taobao.accs.IACCSManager
    @Deprecated
    public void setMode(Context context, int i2) {
        ACCSClient.setEnvironment(context, i2);
    }

    @Override // com.taobao.accs.IACCSManager
    public void setProxy(Context context, String str, int i2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        if (!TextUtils.isEmpty(str)) {
            editorEdit.putString(Constants.KEY_PROXY_HOST, str);
        }
        editorEdit.putInt(Constants.KEY_PROXY_PORT, i2);
        editorEdit.apply();
    }

    @Override // com.taobao.accs.IACCSManager
    public void startInAppConnection(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        startInAppConnection(context, str, null, str2, iAppReceiver);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unRegisterDataListener(Context context, String str) {
        GlobalClientInfo.getInstance(context).unregisterListener(str);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unRegisterService(Context context, String str) {
        GlobalClientInfo.getInstance(context).unRegisterService(str);
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindApp(Context context) {
        this.f10313e.i("unbindApp");
        this.f10311c = false;
        if (a(context)) {
            a(context, 2, (String) null, (String) null);
            return;
        }
        Intent intentA = a(context, 2);
        if (AdapterUtilityImpl.isTargetProcess(context)) {
            a(context, Message.a(this.f10309a, intentA), 2, false);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindService(Context context, String str) {
        this.f10313e.i("unbindService", Constants.KEY_SERVICE_ID, str);
        if (a(context)) {
            a(context, 6, str, (String) null);
            return;
        }
        Intent intentA = a(context, 6);
        String strI = this.f10309a.i();
        if (TextUtils.isEmpty(strI)) {
            this.f10313e.e("appKey null");
            return;
        }
        intentA.putExtra(Constants.KEY_APP_KEY, strI);
        intentA.putExtra(Constants.KEY_SERVICE_ID, str);
        if (AdapterUtilityImpl.isTargetProcess(context)) {
            a(context, Message.c(this.f10309a, intentA), 6, false);
        } else {
            this.f10313e.w("unbindService not target process, ignored");
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void unbindUser(Context context) {
        this.f10313e.i("unBindUse");
        if (a(context)) {
            a(context, 4, (String) null, (String) null);
            return;
        }
        Intent intentA = a(context, 4);
        String strI = this.f10309a.i();
        if (TextUtils.isEmpty(strI)) {
            this.f10313e.e("appKey null");
            return;
        }
        intentA.putExtra(Constants.KEY_APP_KEY, strI);
        if (AdapterUtilityImpl.isTargetProcess(context)) {
            a(context, Message.e(this.f10309a, intentA), 4, false);
        } else {
            this.f10313e.w("unBindUser not target process, ignored");
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void updateConfig(AccsClientConfig accsClientConfig) {
        com.taobao.accs.net.b bVar = this.f10309a;
        if (bVar instanceof j) {
            ((j) bVar).a(accsClientConfig);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindApp(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        if (context == null) {
            return;
        }
        this.f10311c = true;
        this.f10313e.d("bindApp", Constants.KEY_APP_KEY, str);
        Message messageA = Message.a(context.getPackageName(), 1);
        if (this.f10309a.k() && TextUtils.isEmpty(this.f10309a.f10359i.getAppSecret())) {
            this.f10313e.w("isSecurityOff and null secret");
            this.f10309a.a(messageA, AccsErrorCode.APPSECRET_NULL);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f10313e.w("appKey is null");
            this.f10309a.a(messageA, AccsErrorCode.APPKEY_NULL);
            return;
        }
        com.taobao.accs.net.b bVar = this.f10309a;
        bVar.f10351a = str3;
        bVar.f10352b = str;
        bVar.f10359i.getAppSecret();
        UtilityImpl.e(context, str);
        if (iAppReceiver != null) {
            com.taobao.accs.client.a.a().a(this.f10312d, com.taobao.accs.utl.c.a(iAppReceiver));
        }
        a(context, str, str3);
    }

    @Override // com.taobao.accs.IACCSManager
    public void bindUser(Context context, String str, boolean z) {
        try {
            this.f10313e.i("bindUser", "userId", str, TTDownloadField.TT_FORCE, Boolean.valueOf(z));
            if (a(context)) {
                a(context, 3, (String) null, (String) null);
                return;
            }
            Intent intentA = a(context, 3);
            String strI = this.f10309a.i();
            if (TextUtils.isEmpty(strI)) {
                this.f10313e.e("appkey null");
                return;
            }
            if (UtilityImpl.c(context) || z) {
                this.f10313e.d("force bind user");
                intentA.putExtra(Constants.KEY_FOUCE_BIND, true);
                z = true;
            }
            intentA.putExtra(Constants.KEY_APP_KEY, strI);
            intentA.putExtra(Constants.KEY_USER_ID, str);
            if (AdapterUtilityImpl.isTargetProcess(context)) {
                Message messageD = Message.d(this.f10309a, intentA);
                if (messageD.e() != null) {
                    messageD.e().setDataId(messageD.f10273q);
                    messageD.e().setMsgType(2);
                    NetPerformanceMonitor netPerformanceMonitorE = messageD.e();
                    URL url = messageD.f10269f;
                    netPerformanceMonitorE.setHost(url != null ? url.toString() : "");
                }
                a(context, messageD, 3, z);
            } else {
                this.f10313e.w("bindUser not target process, ignored");
            }
            this.f10309a.b(context.getApplicationContext());
        } catch (Throwable th) {
            this.f10313e.e("bindUser", th);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return sendData(context, str, str2, bArr, str3, str4, null);
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendRequest(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.IACCSManager
    public void startInAppConnection(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            com.taobao.accs.client.a.a().a(this.f10312d, com.taobao.accs.utl.c.a(iAppReceiver));
        }
        if (!AdapterUtilityImpl.isTargetProcess(context)) {
            this.f10313e.w("inapp only init in target process!");
            return;
        }
        this.f10313e.i("startInAppConnection", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!TextUtils.equals(this.f10309a.i(), str)) {
            com.taobao.accs.net.b bVar = this.f10309a;
            bVar.f10351a = str3;
            bVar.f10352b = str;
            bVar.f10359i.getAppSecret();
            UtilityImpl.e(context, str);
        }
        this.f10309a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2) {
        Intent intentA = a(context, 1);
        try {
            String str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
            boolean z = UtilityImpl.c(context) || UtilityImpl.utdidChanged(Constants.SP_FILE_NAME, context);
            if (z) {
                this.f10313e.d("force bindApp");
                intentA.putExtra(Constants.KEY_FOUCE_BIND, true);
            }
            intentA.putExtra(Constants.KEY_APP_KEY, str);
            intentA.putExtra(Constants.KEY_TTID, str2);
            intentA.putExtra("appVersion", str3);
            intentA.putExtra("app_sercet", this.f10309a.f10359i.getAppSecret());
            if (AdapterUtilityImpl.isTargetProcess(context)) {
                Message messageA = Message.a(this.f10309a, context, intentA);
                if (messageA.e() != null) {
                    messageA.e().setDataId(messageA.f10273q);
                    messageA.e().setMsgType(1);
                    NetPerformanceMonitor netPerformanceMonitorE = messageA.e();
                    URL url = messageA.f10269f;
                    netPerformanceMonitorE.setHost(url != null ? url.toString() : "");
                }
                a(context, messageA, 1, z);
            } else {
                this.f10313e.w("bindApp only allow in target process");
            }
            this.f10309a.b(context.getApplicationContext());
        } catch (Throwable th) {
            this.f10313e.e("bindApp exception", th);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return sendData(context, new ACCSManager.AccsRequest(str, str2, bArr, str3, str4, url, null));
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, ACCSManager.AccsRequest accsRequest, String str, boolean z) {
        try {
            if (accsRequest == null) {
                this.f10313e.e("sendRequest request null");
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, null, "1", "request null");
                return null;
            }
            if (!AdapterUtilityImpl.isTargetProcess(context)) {
                this.f10313e.e("sendRequest not in target process");
                return null;
            }
            if (TextUtils.isEmpty(accsRequest.dataId)) {
                synchronized (ACCSManagerImpl.class) {
                    this.f10310b++;
                    accsRequest.dataId = this.f10310b + "";
                }
            }
            if (TextUtils.isEmpty(this.f10309a.i())) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request appkey null");
                this.f10313e.e("sendRequest appkey null", Constants.KEY_DATA_ID, accsRequest.dataId);
                return null;
            }
            this.f10309a.a();
            if (str == null) {
                str = context.getPackageName();
            }
            Message messageA = Message.a(this.f10309a, context, str, Constants.TARGET_SERVICE_PRE, accsRequest, z);
            if (messageA.e() != null) {
                messageA.e().onSend();
            }
            this.f10309a.b(messageA, true);
        } catch (Throwable th) {
            if (accsRequest != null) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "request " + th.toString());
                this.f10313e.e("sendRequest", Constants.KEY_DATA_ID, accsRequest.dataId, th);
            }
        }
        return accsRequest.dataId;
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendData(Context context, ACCSManager.AccsRequest accsRequest) {
        try {
            if (!AdapterUtilityImpl.isTargetProcess(context)) {
                this.f10313e.e("sendData not in target process");
                return null;
            }
            if (accsRequest == null) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", "data null");
                this.f10313e.e("sendData dataInfo null");
                return null;
            }
            if (TextUtils.isEmpty(accsRequest.dataId)) {
                synchronized (ACCSManagerImpl.class) {
                    this.f10310b++;
                    accsRequest.dataId = this.f10310b + "";
                }
            }
            if (TextUtils.isEmpty(this.f10309a.i())) {
                AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "data appkey null");
                this.f10313e.e("sendData appkey null", Constants.KEY_DATA_ID, accsRequest.dataId);
                return null;
            }
            this.f10309a.a();
            Message messageA = Message.a(this.f10309a, context, context.getPackageName(), accsRequest);
            if (messageA.e() != null) {
                messageA.e().onSend();
            }
            this.f10309a.b(messageA, true);
        } catch (Throwable th) {
            AppMonitorAdapter.commitAlarmFail("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, accsRequest.serviceId, "1", "data " + th.toString());
            this.f10313e.e("sendData", Constants.KEY_DATA_ID, accsRequest.dataId, th);
        }
        return accsRequest.dataId;
    }

    private void a(Context context, Message message, int i2, boolean z) {
        boolean z2;
        this.f10309a.a();
        if (message == null) {
            this.f10313e.e("message is null");
            this.f10309a.a(Message.a(context.getPackageName(), i2), AccsErrorCode.PARAMETER_ERROR);
            return;
        }
        if (i2 != 1) {
            if (i2 == 2 && this.f10309a.j().e(message.f())) {
                this.f10313e.i("unbind app, already unbind");
                this.f10309a.a(message, AccsErrorCode.SUCCESS);
                z2 = false;
            }
            z2 = true;
        } else {
            String strF = message.f();
            if (this.f10309a.j().d(strF) && !z) {
                this.f10313e.i("bind app from cache");
                AccsState.getInstance().a(this.f10312d, AccsState.BIND_APP_FROM_CACHE, Boolean.TRUE);
                this.f10309a.a(message, AccsErrorCode.SUCCESS);
            } else if (!this.f10309a.j().f(strF) || z) {
                this.f10309a.j().c(strF);
                z2 = true;
            }
            z2 = false;
        }
        if (z2) {
            this.f10313e.i("sendControlMessage", "command", Integer.valueOf(i2));
            this.f10309a.b(message, true);
        }
    }

    @Override // com.taobao.accs.IACCSManager
    public String sendRequest(Context context, ACCSManager.AccsRequest accsRequest) {
        return sendRequest(context, accsRequest, null, true);
    }

    private boolean a(Context context) {
        com.taobao.accs.net.b bVar = this.f10309a;
        return bVar == null || !bVar.j().d(context.getPackageName());
    }

    private Intent a(Context context, int i2) {
        Intent intent = new Intent();
        intent.setAction(Constants.ACTION_COMMAND);
        intent.setClassName(context.getPackageName(), AdapterUtilityImpl.channelService);
        intent.putExtra("packageName", context.getPackageName());
        intent.putExtra("command", i2);
        intent.putExtra(Constants.KEY_APP_KEY, this.f10309a.f10352b);
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.f10312d);
        return intent;
    }

    private void a(Context context, int i2, String str, String str2) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(context.getPackageName());
        intent.putExtra("command", i2);
        intent.putExtra(Constants.KEY_SERVICE_ID, str);
        intent.putExtra(Constants.KEY_DATA_ID, str2);
        intent.putExtra(Constants.KEY_APP_KEY, this.f10309a.f10352b);
        intent.putExtra(Constants.KEY_CONFIG_TAG, this.f10312d);
        intent.putExtra(Constants.KEY_ERROR_OBJ, i2 == 2 ? AccsErrorCode.SUCCESS : AccsErrorCode.APP_NOT_BIND);
        g.a(context, intent);
    }
}
