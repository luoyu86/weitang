package com.taobao.accs;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.internal.ACCSManagerImpl;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.Utils;
import java.io.Serializable;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class ACCSManager {
    private static final String TAG = "ACCSManager";
    public static Map<String, IACCSManager> mAccsInstances = new ConcurrentHashMap(2);
    public static String mDefaultAppKey = null;
    public static String mDefaultConfigTag = "default";
    public static int mEnv;
    public static Context sContext;

    private ACCSManager() {
    }

    @Deprecated
    public static void bindApp(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        if (TextUtils.isEmpty(mDefaultAppKey)) {
            throw new RuntimeException("old interface!!, please AccsManager.setAppkey() first!");
        }
        getManagerImpl(context).bindApp(context, mDefaultAppKey, str2, str3, iAppReceiver);
    }

    @Deprecated
    public static void bindService(Context context, String str) {
        getManagerImpl(context).bindService(context, str);
    }

    @Deprecated
    public static void bindUser(Context context, String str) {
        bindUser(context, str, false);
    }

    @Deprecated
    public static void clearLoginInfoImpl(Context context) {
        getManagerImpl(context).clearLoginInfo(context);
    }

    public static IACCSManager createAccsInstance(Context context, String str) {
        return new ACCSManagerImpl(context, str);
    }

    @Deprecated
    public static Map<String, Boolean> forceReConnectChannel(Context context) throws Exception {
        return getManagerImpl(context).forceReConnectChannel();
    }

    public static IACCSManager getAccsInstance(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str2)) {
            ALog.e(TAG, "getAccsInstance param null", Constants.KEY_CONFIG_TAG, str2);
            return null;
        }
        String str3 = str2 + "|" + AccsClientConfig.mEnv;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(TAG, "getAccsInstance", "key", str3);
        }
        IACCSManager iACCSManagerCreateAccsInstance = mAccsInstances.get(str3);
        if (iACCSManagerCreateAccsInstance == null) {
            synchronized (ACCSManager.class) {
                if (iACCSManagerCreateAccsInstance == null) {
                    try {
                        iACCSManagerCreateAccsInstance = createAccsInstance(context, str2);
                    } catch (Exception e2) {
                        ALog.e(TAG, "createAccsInstance error", e2.getMessage());
                    }
                    if (iACCSManagerCreateAccsInstance != null) {
                        mAccsInstances.put(str3, iACCSManagerCreateAccsInstance);
                    }
                }
            }
        }
        return iACCSManagerCreateAccsInstance;
    }

    public static String[] getAppKey(Context context) {
        try {
            String string = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString("appkey", null);
            ALog.i(TAG, "getAppKey:" + string, new Object[0]);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string.split("\\|");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static Map<String, Boolean> getChannelState(Context context) throws Exception {
        return getManagerImpl(context).getChannelState();
    }

    @Deprecated
    public static String getDefaultAppKey(Context context) {
        if (TextUtils.isEmpty(mDefaultAppKey)) {
            ALog.e(TAG, "old interface!!, please AccsManager.setAppkey() first!", new Object[0]);
            String spValue = Utils.getSpValue(context, Constants.SP_KEY_DEFAULT_APPKEY, null);
            mDefaultAppKey = spValue;
            if (TextUtils.isEmpty(spValue)) {
                mDefaultAppKey = "0";
            }
        }
        return mDefaultAppKey;
    }

    public static String getDefaultConfig(Context context) {
        return mDefaultConfigTag;
    }

    private static synchronized IACCSManager getManagerImpl(Context context) {
        return getAccsInstance(context, null, getDefaultConfig(context));
    }

    @Deprecated
    public static String getUserUnit(Context context) {
        return null;
    }

    @Deprecated
    public static boolean isChannelError(Context context, int i2) {
        return getManagerImpl(context).isChannelError(i2);
    }

    @Deprecated
    public static boolean isNetworkReachable(Context context) {
        return getManagerImpl(context).isNetworkReachable(context);
    }

    @Deprecated
    public static void registerDataListener(Context context, String str, AccsAbstractDataListener accsAbstractDataListener) {
        if (getManagerImpl(context) == null) {
            ALog.e(TAG, "getManagerImpl null, return", new Object[0]);
        } else {
            getManagerImpl(context).registerDataListener(context, str, accsAbstractDataListener);
        }
    }

    @Deprecated
    public static void registerService(Context context, String str, String str2) {
        getManagerImpl(context).registerService(context, str, str2);
    }

    @Deprecated
    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3) {
        return getManagerImpl(context).sendData(context, str, str2, bArr, str3);
    }

    @Deprecated
    public static String sendPushResponse(Context context, AccsRequest accsRequest, TaoBaseService.ExtraInfo extraInfo) {
        return getManagerImpl(context).sendPushResponse(context, accsRequest, extraInfo);
    }

    @Deprecated
    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return getManagerImpl(context).sendRequest(context, str, str2, bArr, str3, str4, url);
    }

    @Deprecated
    public static void setAppKey(Context context, String str, @AccsClientConfig.ENV int i2) {
        Utils.setAgooAppKey(context, str);
        Context applicationContext = context.getApplicationContext();
        sContext = applicationContext;
        mDefaultAppKey = str;
        Utils.setSpValue(applicationContext, Constants.SP_KEY_DEFAULT_APPKEY, str);
        mEnv = i2;
        AccsClientConfig.mEnv = i2;
    }

    @Deprecated
    public static void setDefaultConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.i(TAG, "setDefaultConfig", Constants.KEY_CONFIG_TAG, str);
        mDefaultConfigTag = str;
    }

    @Deprecated
    public static void setLoginInfoImpl(Context context, ILoginInfo iLoginInfo) {
        getManagerImpl(context).setLoginInfo(context, iLoginInfo);
    }

    @Deprecated
    public static void setMode(Context context, int i2) {
        mEnv = i2;
        getManagerImpl(context).setMode(context, i2);
    }

    @Deprecated
    public static void setProxy(Context context, String str, int i2) {
        getManagerImpl(context).setProxy(context, str, i2);
    }

    @Deprecated
    public static void setServiceListener(Context context, String str, IServiceReceiver iServiceReceiver) {
    }

    @Deprecated
    public static void startInAppConnection(Context context, String str, String str2, String str3, IAppReceiver iAppReceiver) {
        getManagerImpl(context).startInAppConnection(context, mDefaultAppKey, str2, str3, iAppReceiver);
    }

    @Deprecated
    public static void unRegisterDataListener(Context context, String str) {
        getManagerImpl(context).unRegisterDataListener(context, str);
    }

    @Deprecated
    public static void unbindApp(Context context) {
    }

    @Deprecated
    public static void unbindService(Context context, String str) {
        getManagerImpl(context).unbindService(context, str);
    }

    @Deprecated
    public static void unbindUser(Context context) {
        getManagerImpl(context).unbindUser(context);
    }

    @Deprecated
    public static void unregisterService(Context context, String str) {
        getManagerImpl(context).unRegisterService(context, str);
    }

    @Deprecated
    public static void bindUser(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(mDefaultAppKey)) {
            throw new RuntimeException("old interface!!, please AccsManager.setAppkey() first!");
        }
        getManagerImpl(context).bindUser(context, str, z);
    }

    @Deprecated
    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4, URL url) {
        return getManagerImpl(context).sendData(context, str, str2, bArr, str3, str4, url);
    }

    @Deprecated
    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3) {
        return sendRequest(context, str, str2, bArr, str3, null);
    }

    @Deprecated
    public static void startInAppConnection(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        startInAppConnection(context, mDefaultAppKey, "", str2, iAppReceiver);
    }

    @Deprecated
    public static String sendData(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return getManagerImpl(context).sendData(context, str, str2, bArr, str3, str4);
    }

    @Deprecated
    public static String sendRequest(Context context, String str, String str2, byte[] bArr, String str3, String str4) {
        return getManagerImpl(context).sendRequest(context, str, str2, bArr, str3, str4);
    }

    @Deprecated
    public static void bindApp(Context context, String str, String str2, IAppReceiver iAppReceiver) {
        bindApp(context, mDefaultAppKey, "", str2, iAppReceiver);
    }

    @Deprecated
    public static String sendData(Context context, AccsRequest accsRequest) {
        return getManagerImpl(context).sendData(context, accsRequest);
    }

    @Deprecated
    public static String sendRequest(Context context, AccsRequest accsRequest) {
        return getManagerImpl(context).sendRequest(context, accsRequest);
    }

    public static class AccsRequest implements Serializable {
        public String businessId;
        public byte[] data;
        public String dataId;
        public URL host;
        public boolean isUnitBusiness = false;
        public String serviceId;
        public String tag;
        public String target;
        public String targetServiceName;
        public int timeout;
        public String userId;

        public AccsRequest(String str, String str2, byte[] bArr, String str3, String str4, URL url, String str5) {
            this.userId = str;
            this.serviceId = str2;
            this.data = bArr;
            this.dataId = str3;
            this.target = str4;
            this.host = url;
            this.businessId = str5;
        }

        public void setBusinessId(String str) {
            this.businessId = str;
        }

        public void setHost(URL url) {
            this.host = url;
        }

        public void setIsUnitBusiness(boolean z) {
            this.isUnitBusiness = z;
        }

        public void setTag(String str) {
            this.tag = str;
        }

        public void setTarget(String str) {
            this.target = str;
        }

        public void setTargetServiceName(String str) {
            this.targetServiceName = str;
        }

        public void setTimeOut(int i2) {
            this.timeout = i2;
        }

        public AccsRequest(String str, String str2, byte[] bArr, String str3) {
            this.userId = str;
            this.serviceId = str2;
            this.data = bArr;
            this.dataId = str3;
        }
    }
}
