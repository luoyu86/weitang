package com.taobao.accs;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.SessionCenter;
import anet.channel.entity.ENV;
import anet.channel.util.ALog;
import com.alibaba.sdk.android.logger.ILog;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.AccsLogger;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.Utils;
import com.taobao.accs.utl.c;
import com.taobao.accs.utl.i;
import com.taobao.accs.utl.k;
import com.taobao.accs.utl.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ACCSClient {
    private static final ILog DEFAULT_LOG = AccsLogger.getLogger("ACCSClient");
    public static Map<String, ACCSClient> mACCSClients = new ConcurrentHashMap(2);
    private static Context sContext;
    public IACCSManager mAccsManager;
    private AccsClientConfig mConfig;
    private final HashSet<ConnectionListener> mListeners = new HashSet<>();
    private final ILog mLog;

    public ACCSClient(AccsClientConfig accsClientConfig) {
        this.mConfig = accsClientConfig;
        this.mLog = AccsLogger.getLogger("ACCSClient" + accsClientConfig.getTag());
        this.mAccsManager = ACCSManager.getAccsInstance(sContext, accsClientConfig.getAppKey(), accsClientConfig.getTag());
    }

    public static void changeNetworkSdkLoggerToAccs() {
        DEFAULT_LOG.d("changeNetworkSdkLoggerToAccs");
        ALog.setLog(new k(new l(), i.a()));
    }

    @Deprecated
    public static void enableChannelProcess(Context context, boolean z) {
        UtilityImpl.a(context, z);
    }

    @Deprecated
    public static void enableChannelProcessHeartbeat(Context context, boolean z) {
    }

    public static synchronized ACCSClient getAccsClient(String str) throws AccsException {
        if (TextUtils.isEmpty(str)) {
            str = AccsClientConfig.DEFAULT_CONFIG_TAG;
            DEFAULT_LOG.w("getAccsClient with null tag, use default");
        }
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag == null) {
            DEFAULT_LOG.e("getAccsClient with null config, please init config first", Constants.KEY_CONFIG_TAG, str);
            throw new AccsException("configTag not exist");
        }
        ACCSClient aCCSClient = mACCSClients.get(str);
        if (aCCSClient != null) {
            if (!configByTag.equals(aCCSClient.mConfig)) {
                DEFAULT_LOG.w("getAccsClient update config", "old", aCCSClient.mConfig, "new", configByTag);
                aCCSClient.updateConfig(configByTag);
            }
            return aCCSClient;
        }
        DEFAULT_LOG.d("getAccsClient create client");
        ACCSClient aCCSClient2 = new ACCSClient(configByTag);
        mACCSClients.put(str, aCCSClient2);
        aCCSClient2.updateConfig(configByTag);
        return aCCSClient2;
    }

    public static synchronized String init(Context context, AccsClientConfig accsClientConfig) throws AccsException {
        if (context == null || accsClientConfig == null) {
            DEFAULT_LOG.e("init AccsClient params error", TTLiveConstants.CONTEXT_KEY, context, "config", accsClientConfig);
            throw new AccsException("init AccsClient params error");
        }
        GlobalClientInfo.getInstance(context);
        sContext = context.getApplicationContext();
        setCurrentProcessName(context);
        DEFAULT_LOG.d("init", "config", accsClientConfig);
        AccsState.getInstance().a("sv", "4.9.1-emas");
        changeNetworkSdkLoggerToAccs();
        try {
            AwcnConfig.setAccsSessionCreateForbiddenInBg(false);
        } catch (Throwable unused) {
        }
        return accsClientConfig.getTag();
    }

    public static void setCurrentProcessName(Context context) {
        try {
            GlobalAppRuntimeInfo.setCurrentProcess(AdapterUtilityImpl.getProcessName(context.getApplicationContext()));
        } catch (Throwable th) {
            DEFAULT_LOG.e("setCurrentProcess", th);
        }
        try {
            GlobalAppRuntimeInfo.setTargetProcess(AdapterUtilityImpl.getTargetProcess(context.getApplicationContext()));
        } catch (Throwable th2) {
            DEFAULT_LOG.e("setCurrentProcess", th2);
        }
    }

    public static synchronized void setEnvironment(Context context, @AccsClientConfig.ENV int i2) {
        if (i2 < 0 || i2 > 2) {
            try {
                DEFAULT_LOG.w("env invalid, reset to release", "env", Integer.valueOf(i2));
                i2 = 0;
            } finally {
                try {
                } finally {
                }
            }
        }
        int i3 = AccsClientConfig.mEnv;
        AccsClientConfig.mEnv = i2;
        if (i3 != i2 && AdapterUtilityImpl.isTargetProcess(context)) {
            DEFAULT_LOG.i("setEnvironment", "pre", Integer.valueOf(i3), "to", Integer.valueOf(i2));
            Utils.clearAllSharePreferences(context);
            Utils.clearAgooBindCache(context);
            Utils.killService(context);
            if (i2 == 2) {
                SessionCenter.switchEnvironment(ENV.TEST);
            } else if (i2 == 1) {
                SessionCenter.switchEnvironment(ENV.PREPARE);
            }
            Iterator<Map.Entry<String, ACCSClient>> it = mACCSClients.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    getAccsClient(it.next().getKey());
                } catch (AccsException e2) {
                    DEFAULT_LOG.e("setEnvironment update client", e2);
                }
            }
        }
    }

    private void updateConfig(AccsClientConfig accsClientConfig) {
        this.mConfig = accsClientConfig;
        IACCSManager accsInstance = ACCSManager.getAccsInstance(sContext, accsClientConfig.getAppKey(), accsClientConfig.getTag());
        this.mAccsManager = accsInstance;
        if (accsInstance != null) {
            accsInstance.updateConfig(accsClientConfig);
        }
    }

    public void addConnectionListener(ConnectionListener connectionListener) {
        if (connectionListener != null) {
            this.mListeners.add(connectionListener);
        }
    }

    public void bindApp(String str, IAppReceiver iAppReceiver) {
        if (this.mAccsManager != null) {
            Log.d("ACCS_TEST", "start to bindApp");
            this.mAccsManager.bindApp(sContext, this.mConfig.getAppKey(), this.mConfig.getAppSecret(), str, iAppReceiver);
        } else {
            this.mLog.e("bindApp mAccsManager null");
            Log.d("ACCS_TEST", "bindApp mAccsManager null");
            c.a(AccsErrorCode.ERROR_SHOULD_NEVER_HAPPEN.copy().detail("bindApp accs is null").build(), iAppReceiver, null);
        }
    }

    public void bindService(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("bindService mAccsManager null");
        } else {
            iACCSManager.bindService(sContext, str);
        }
    }

    public void bindUser(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("bindUser mAccsManager null");
        } else {
            iACCSManager.bindUser(sContext, str);
        }
    }

    public boolean cancel(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager != null) {
            return iACCSManager.cancel(sContext, str);
        }
        this.mLog.e("cancel mAccsManager null");
        return false;
    }

    public void cleanLocalBindInfo() {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("cleanLocalBindInfo mAccsManager null");
        } else {
            iACCSManager.cleanLocalBindInfo();
        }
    }

    public void clearLoginInfo() {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("clearLoginInfo mAccsManager null");
        } else {
            iACCSManager.clearLoginInfo(sContext);
        }
    }

    public void disconnect() {
        this.mAccsManager.disconnect();
    }

    public Map<String, Boolean> forceReConnectChannel() throws Exception {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager != null) {
            return iACCSManager.forceReConnectChannel();
        }
        this.mLog.e("forceReConnectChannel mAccsManager null");
        return null;
    }

    public Map<String, Boolean> getChannelState() throws Exception {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager != null) {
            return iACCSManager.getChannelState();
        }
        this.mLog.e("getChannelState mAccsManager null");
        return null;
    }

    public List<ConnectionListener> getConnectionListeners() {
        return new ArrayList(this.mListeners);
    }

    public int getLastConnectErrorCode() {
        return this.mAccsManager.getLastConnectErrorCode();
    }

    public boolean isChannelError(int i2) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager != null) {
            return iACCSManager.isChannelError(i2);
        }
        this.mLog.e("isChannelError mAccsManager null");
        return true;
    }

    public boolean isConnected() {
        return this.mAccsManager.isConnected();
    }

    public boolean isNetworkReachable() {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager != null) {
            return iACCSManager.isNetworkReachable(sContext);
        }
        this.mLog.e("isNetworkReachable mAccsManager null");
        return false;
    }

    public void reconnect() {
        this.mAccsManager.reconnect();
    }

    public void registerDataListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("registerDataListener mAccsManager null");
        } else {
            iACCSManager.registerDataListener(sContext, str, accsAbstractDataListener);
        }
    }

    public void registerService(String str, String str2) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("registerService mAccsManager null");
        } else {
            iACCSManager.registerService(sContext, str, str2);
        }
    }

    public void removeConnectionListener(ConnectionListener connectionListener) {
        if (connectionListener != null) {
            this.mListeners.remove(connectionListener);
        }
    }

    public void reset() {
        this.mAccsManager.reset();
    }

    public void sendBusinessAck(String str, String str2, String str3, short s, String str4, Map<Integer, String> map) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("sendBusinessAck mAccsManager null");
        } else {
            iACCSManager.sendBusinessAck(str, str2, str3, s, str4, map);
        }
    }

    public String sendData(ACCSManager.AccsRequest accsRequest) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager != null) {
            return iACCSManager.sendData(sContext, accsRequest);
        }
        this.mLog.e("sendData mAccsManager null");
        return null;
    }

    public String sendPushResponse(ACCSManager.AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager != null) {
            return iACCSManager.sendPushResponse(sContext, accsRequest, extraInfo);
        }
        this.mLog.e("sendPushResponse mAccsManager null");
        return null;
    }

    public String sendRequest(ACCSManager.AccsRequest accsRequest) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager != null) {
            return iACCSManager.sendRequest(sContext, accsRequest);
        }
        this.mLog.e("sendRequest mAccsManager null");
        return null;
    }

    public void setLoginInfo(ILoginInfo iLoginInfo) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("setLoginInfo mAccsManager null");
        } else {
            iACCSManager.setLoginInfo(sContext, iLoginInfo);
        }
    }

    public void startInAppConnection(String str, IAppReceiver iAppReceiver) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("startInAppConnection mAccsManager null");
        } else {
            iACCSManager.startInAppConnection(sContext, this.mConfig.getAppKey(), this.mConfig.getAppSecret(), str, iAppReceiver);
        }
    }

    public void unRegisterDataListener(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("unRegisterDataListener mAccsManager null");
        } else {
            iACCSManager.unRegisterDataListener(sContext, str);
        }
    }

    public void unRegisterService(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("unRegisterService mAccsManager null");
        } else {
            iACCSManager.unRegisterService(sContext, str);
        }
    }

    public void unbindService(String str) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("unbindService mAccsManager null");
        } else {
            iACCSManager.unbindService(sContext, str);
        }
    }

    public void unbindUser() {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("unbindUser mAccsManager null");
        } else {
            iACCSManager.unbindUser(sContext);
        }
    }

    public void bindUser(String str, boolean z) {
        IACCSManager iACCSManager = this.mAccsManager;
        if (iACCSManager == null) {
            this.mLog.e("bindUser mAccsManager null");
        } else {
            iACCSManager.bindUser(sContext, str, z);
        }
    }
}
