package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import c.a.a.a.a.m;
import com.alibaba.sdk.android.error.ErrorCode;
import com.aliyun.ams.emas.push.AgooInnerService;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.AccsException;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.Config;
import org.android.agoo.control.AgooFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class TaobaoRegister {
    private static final int EVENT_ID = 66001;
    public static final String PREFERENCES = "Agoo_AppStore";
    public static final String PROPERTY_APP_NOTIFICATION_CUSTOM_SOUND = "app_notification_custom_sound";
    public static final String PROPERTY_APP_NOTIFICATION_ICON = "app_notification_icon";
    public static final String PROPERTY_APP_NOTIFICATION_SOUND = "app_notification_sound";
    public static final String PROPERTY_APP_NOTIFICATION_VIBRATE = "app_notification_vibrate";
    private static final String SERVICEID = "agooSend";
    public static final String TAG = "TaobaoRegister";
    private static com.taobao.agoo.a.b mRequestListener;

    public static class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10490a;

        public /* synthetic */ a(String str, com.taobao.agoo.c cVar) {
            this(str);
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.b(str, str2, this.f10490a);
        }

        private a(String str) {
            this.f10490a = str;
        }
    }

    public interface b {
        byte[] a(String str, String str2);
    }

    public static class c implements b {
        private c() {
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.b(str, str2);
        }

        public /* synthetic */ c(com.taobao.agoo.c cVar) {
            this();
        }
    }

    public static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10492b;

        public /* synthetic */ d(String str, String str2, com.taobao.agoo.c cVar) {
            this(str, str2);
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.a(str, str2, this.f10491a, this.f10492b);
        }

        private d(String str, String str2) {
            this.f10491a = str;
            this.f10492b = str2;
        }
    }

    public static class e implements b {
        private e() {
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.a(str, str2);
        }

        public /* synthetic */ e(com.taobao.agoo.c cVar) {
            this();
        }
    }

    public static class f implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10493a;

        public f(String str) {
            this.f10493a = str;
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.a(str, str2, this.f10493a);
        }
    }

    public static class g implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10494a;

        public g(String str) {
            this.f10494a = str;
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.d(str, str2, this.f10494a);
        }
    }

    public static class h implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10495a;

        public h(String str) {
            this.f10495a = str;
        }

        @Override // com.taobao.agoo.TaobaoRegister.b
        public byte[] a(String str, String str2) {
            return com.taobao.agoo.a.a.a.c(str, str2, this.f10495a);
        }
    }

    private TaobaoRegister() {
        throw new UnsupportedOperationException();
    }

    public static synchronized void addAlias(Context context, String str, ICallback iCallback) {
        ALog.i(TAG, "addAlias", "alias", str);
        ICallback iCallbackCheckNull = checkNull(iCallback);
        if (context != null && str != null) {
            doAliasOperation("addAlias", context, iCallbackCheckNull, new a(str, null));
            return;
        }
        ErrorCode errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail("addAlias " + context + " " + str).build();
        iCallbackCheckNull.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
    }

    @Deprecated
    public static void bindAgoo(Context context, String str, String str2, CallBack callBack) {
        bindAgoo(context, null);
    }

    private static ICallback checkNull(ICallback iCallback) {
        return iCallback == null ? new ICallback() { // from class: com.taobao.agoo.TaobaoRegister.3
            @Override // com.taobao.agoo.ICallback
            public void onFailure(String str, String str2) {
            }

            @Override // com.taobao.agoo.ICallback
            public void onSuccess() {
            }
        } : iCallback;
    }

    public static void clearNotificationCreatedByAliyun(Context context) {
        c.a.a.a.a.e.a.a().a(context);
    }

    public static void clickMessage(Context context, String str, String str2) {
        AgooFactory.getInstance(context).clickMessage(context, str, str2);
    }

    public static void dismissMessage(Context context, String str, String str2) {
        AgooFactory.getInstance(context).dismissMessage(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doAliasOperation(String str, Context context, ICallback iCallback, b bVar) {
        ErrorCode errorCodeBuild;
        ALog.i(TAG, str, new Object[0]);
        String deviceToken = Config.getDeviceToken(context);
        String strB = Config.b(context);
        if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(deviceToken) || context == null) {
            if (iCallback != null) {
                if (context == null) {
                    errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail(str + " context is null").build();
                } else if (TextUtils.isEmpty(deviceToken)) {
                    errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail(str + " deviceId is null").build();
                } else {
                    errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail(str + " appKey is null").build();
                }
                iCallback.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
            }
            ALog.e(TAG, str + " param null", "appkey", strB, "deviceId", deviceToken, TTLiveConstants.CONTEXT_KEY, context);
            return;
        }
        try {
            if (mRequestListener == null) {
                mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
            }
            IACCSManager accsInstance = ACCSManager.getAccsInstance(context, strB, Config.d(context));
            if (!com.taobao.agoo.a.b.f10517b.b(context.getPackageName())) {
                if (iCallback != null) {
                    ErrorCode errorCode = com.taobao.agoo.a.AGOO_NOT_BIND;
                    iCallback.onFailure(errorCode.getCode(), errorCode.getMsg());
                    return;
                }
                return;
            }
            accsInstance.registerDataListener(context, "AgooDeviceCmd", mRequestListener);
            String strSendRequest = accsInstance.sendRequest(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", bVar.a(strB, deviceToken), null));
            if (!TextUtils.isEmpty(strSendRequest)) {
                if (iCallback != null) {
                    mRequestListener.f10518a.put(strSendRequest, iCallback);
                }
            } else if (iCallback != null) {
                ErrorCode errorCode2 = com.taobao.agoo.a.ACCS_CHECK_ERROR;
                iCallback.onFailure(errorCode2.getCode(), errorCode2.getMsg());
            }
        } catch (Throwable th) {
            ALog.e(TAG, str, th, new Object[0]);
        }
    }

    public static boolean isPushApi() {
        return AgooInnerService.class.getName().equals(AdapterGlobalClientInfo.mAgooCustomServiceName);
    }

    public static synchronized void listAlias(Context context, IListAliasCallback iListAliasCallback) {
        ALog.i(TAG, "listAlias", new Object[0]);
        ICallback iCallbackCheckNull = checkNull(iListAliasCallback);
        if (context != null) {
            doAliasOperation("listAlias", context, iCallbackCheckNull, new c(null));
        } else {
            ErrorCode errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail("listAlias context is null").build();
            iCallbackCheckNull.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
        }
    }

    public static void pingApp(Context context, String str, String str2, String str3, int i2) {
        AgooFactory.getInstance(context).getNotifyManager().pingApp(str, str2, str3, i2);
    }

    @Deprecated
    public static synchronized void register(Context context, String str, String str2, String str3, IRegister iRegister) throws AccsException {
        register(context, str, str, str2, str3, iRegister);
    }

    public static synchronized void removeAlias(final Context context, ICallback iCallback) {
        ALog.i(TAG, com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, new Object[0]);
        final ICallback iCallbackCheckNull = checkNull(iCallback);
        if (context != null) {
            doAliasOperation("removeAllAlias", context, new ICallback() { // from class: com.taobao.agoo.TaobaoRegister.5
                @Override // com.taobao.agoo.ICallback
                public void onFailure(String str, String str2) {
                    TaobaoRegister.doAliasOperation("listAlias", context, new IListAliasCallbackInner() { // from class: com.taobao.agoo.TaobaoRegister.5.1
                        @Override // com.taobao.agoo.ICallback
                        public void onFailure(String str3, String str4) {
                            ArrayList<String> arrayListA = com.taobao.agoo.b.a(context);
                            if (arrayListA == null || arrayListA.size() <= 0) {
                                ICallback iCallback2 = iCallbackCheckNull;
                                ErrorCode errorCode = com.taobao.agoo.a.REMOVE_ALIAS_FAIL_NO_ALIAS;
                                iCallback2.onFailure(errorCode.getCode(), errorCode.getMsg());
                                return;
                            }
                            String str5 = arrayListA.get(0);
                            String strA = com.taobao.agoo.b.a(context, str5);
                            if (strA == null || strA.isEmpty() || str5 == null) {
                                ICallback iCallback3 = iCallbackCheckNull;
                                ErrorCode errorCode2 = com.taobao.agoo.a.REMOVE_ALIAS_FAIL_NO_TOKEN;
                                iCallback3.onFailure(errorCode2.getCode(), errorCode2.getMsg());
                            } else {
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                ICallback iCallback4 = iCallbackCheckNull;
                                iCallback4.extra = str5;
                                TaobaoRegister.doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, context, iCallback4, new d(str5, strA, null));
                            }
                        }

                        @Override // com.taobao.agoo.IListAliasCallbackInner
                        public void onSuccess(Map<String, String> map) {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            TaobaoRegister.removeAliasInList(context, map, iCallbackCheckNull);
                        }
                    }, new c(null));
                }

                @Override // com.taobao.agoo.ICallback
                public void onSuccess() {
                    iCallbackCheckNull.onSuccess();
                }
            }, new e(null));
        } else {
            ErrorCode errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail("removeAlias before 2.4.x context is null").build();
            iCallbackCheckNull.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeAliasInList(Context context, Map<String, String> map, final ICallback iCallback) {
        if (map == null || map.size() == 0) {
            iCallback.onSuccess();
            return;
        }
        final ArrayList arrayList = new ArrayList(map.keySet());
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (final String str : map.keySet()) {
            doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, context, new ICallback() { // from class: com.taobao.agoo.TaobaoRegister.2
                @Override // com.taobao.agoo.ICallback
                public void onFailure(String str2, String str3) {
                    if (atomicBoolean.compareAndSet(false, true)) {
                        iCallback.onFailure(str2, str3);
                    }
                }

                @Override // com.taobao.agoo.ICallback
                public void onSuccess() {
                    arrayList.remove(str);
                    if (atomicBoolean.get() || arrayList.size() != 0) {
                        return;
                    }
                    iCallback.onSuccess();
                }
            }, new d(str, map.get(str), null));
        }
    }

    public static synchronized void removeAllAliasOnCurrentDevice(Context context, ICallback iCallback) {
        ALog.i(TAG, "removeAllAliasOnCurrentDevice ", new Object[0]);
        ICallback iCallbackCheckNull = checkNull(iCallback);
        if (context != null) {
            doAliasOperation("removeAllAliasOnCurrentDevice", context, iCallbackCheckNull, new e(null));
            return;
        }
        ErrorCode errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail("removeAllAliasOnCurrentDevice " + context).build();
        iCallbackCheckNull.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
    }

    public static synchronized void removeAllAliasOnCurrentDeviceAndAddThisAlias(Context context, String str, ICallback iCallback) {
        ALog.i(TAG, "removeAllAliasOnCurrentDeviceAndAddThisAlias alias : " + str, new Object[0]);
        ICallback iCallbackCheckNull = checkNull(iCallback);
        if (context != null && str != null) {
            doAliasOperation("removeAllAliasOnCurrentDeviceAndAddThisAlias", context, iCallbackCheckNull, new h(str));
            return;
        }
        ErrorCode errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail("removeAllAliasOnCurrentDeviceAndAddThisAlias context is null").build();
        iCallbackCheckNull.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
    }

    public static synchronized void removeAllDeviceOnThisAliasAndBindCurrentDevice(Context context, String str, ICallback iCallback) {
        ALog.i(TAG, "removeAllDeviceOnThisAliasAndBindCurrentDevice alias : " + str, new Object[0]);
        ICallback iCallbackCheckNull = checkNull(iCallback);
        if (context != null && str != null) {
            doAliasOperation("removeAllDeviceOnThisAliasAndBindCurrentDevice", context, iCallbackCheckNull, new f(str));
            return;
        }
        ErrorCode errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail("removeAllDeviceOnThisAliasAndBindCurrentDevice context is null").build();
        iCallbackCheckNull.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
    }

    public static void reset() {
        com.taobao.agoo.a.a aVar = com.taobao.agoo.a.b.f10517b;
        if (aVar != null) {
            aVar.a();
        }
        try {
            ACCSClient.getAccsClient(Config.f14935a).reset();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Config.a(GlobalClientInfo.getContext());
    }

    public static synchronized void resetDeviceAndAliasToOne2One(Context context, String str, ICallback iCallback) {
        ALog.i(TAG, "resetDeviceAndAliasToOne2One alias : " + str, new Object[0]);
        ICallback iCallbackCheckNull = checkNull(iCallback);
        if (context != null && str != null) {
            doAliasOperation("resetDeviceAndAliasToOne2One", context, iCallbackCheckNull, new g(str));
            return;
        }
        ErrorCode errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail("resetDeviceAndAliasToOne2One " + context + " " + str).build();
        iCallbackCheckNull.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
    }

    private static synchronized void sendSwitch(Context context, ICallback iCallback, boolean z) {
        String deviceToken;
        String strB;
        String deviceId;
        try {
            deviceToken = Config.getDeviceToken(context);
            strB = Config.b(context);
            deviceId = UtilityImpl.getDeviceId(context);
        } catch (Throwable th) {
            ALog.e(TAG, "sendSwitch", th, new Object[0]);
        }
        if (!TextUtils.isEmpty(strB) && context != null && (!TextUtils.isEmpty(deviceToken) || !TextUtils.isEmpty(deviceId))) {
            IACCSManager accsInstance = ACCSManager.getAccsInstance(context, strB, Config.d(context));
            if (mRequestListener == null) {
                mRequestListener = new com.taobao.agoo.a.b(context.getApplicationContext());
            }
            accsInstance.registerDataListener(context, "AgooDeviceCmd", mRequestListener);
            String strSendRequest = accsInstance.sendRequest(context, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", com.taobao.agoo.a.a.d.a(strB, deviceToken, deviceId, z), null));
            if (TextUtils.isEmpty(strSendRequest)) {
                if (iCallback != null) {
                    ErrorCode errorCode = com.taobao.agoo.a.ACCS_CHECK_ERROR;
                    iCallback.onFailure(errorCode.getCode(), errorCode.getMsg());
                }
            } else if (iCallback != null) {
                mRequestListener.f10518a.put(strSendRequest, iCallback);
            }
            return;
        }
        if (iCallback != null) {
            ErrorCode errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail("sendSwitch " + context + " " + strB + " " + deviceToken + " " + deviceId).build();
            iCallback.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
        }
        ALog.e(TAG, "sendSwitch param null", "appkey", strB, "deviceId", deviceToken, TTLiveConstants.CONTEXT_KEY, context, com.taobao.agoo.a.a.d.JSON_CMD_ENABLEPUSH, Boolean.valueOf(z));
    }

    public static synchronized void setAccsConfigTag(Context context, String str) {
        Config.f14935a = str;
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        if (configByTag == null) {
            throw new RuntimeException("accs config not exist!! please set accs config first!!");
        }
        ALog.i(TAG, "setAccsConfigTag", "config", configByTag.toString());
        AdapterGlobalClientInfo.mAuthCode = configByTag.getAuthCode();
        Config.setAgooAppKey(context, configByTag.getAppKey());
        AdapterUtilityImpl.mAgooAppSecret = configByTag.getAppSecret();
        Config.a(context, configByTag.getAppSecret());
        if (!TextUtils.isEmpty(AdapterUtilityImpl.mAgooAppSecret)) {
            AdapterGlobalClientInfo.mSecurityType = 2;
        }
        m.a(context);
    }

    public static void setAgooMsgReceiveService(String str) {
        AdapterGlobalClientInfo.mAgooCustomServiceName = str;
    }

    public static synchronized void setAlias(final Context context, final String str, ICallback iCallback) {
        ALog.i(TAG, "setAlias " + str, new Object[0]);
        final ICallback iCallbackCheckNull = checkNull(iCallback);
        if (context != null && str != null) {
            doAliasOperation("listAlias", context, new IListAliasCallbackInner() { // from class: com.taobao.agoo.TaobaoRegister.4
                @Override // com.taobao.agoo.ICallback
                public void onFailure(String str2, String str3) {
                    ICallback iCallback2 = iCallbackCheckNull;
                    String str4 = str;
                    iCallback2.extra = str4;
                    TaobaoRegister.doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_ADDALIAS, context, iCallback2, new a(str4, null));
                }

                @Override // com.taobao.agoo.IListAliasCallbackInner
                public void onSuccess(Map<String, String> map) {
                    TaobaoRegister.removeAliasInList(context, map, new ICallback() { // from class: com.taobao.agoo.TaobaoRegister.4.1
                        @Override // com.taobao.agoo.ICallback
                        public void onFailure(String str2, String str3) {
                            iCallbackCheckNull.onFailure(str2, str3);
                        }

                        @Override // com.taobao.agoo.ICallback
                        public void onSuccess() {
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            TaobaoRegister.doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_ADDALIAS, context, iCallbackCheckNull, new a(str, null));
                        }
                    });
                }
            }, new c(null));
            return;
        }
        ErrorCode errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail("setAlias " + context + " " + str).build();
        iCallbackCheckNull.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
    }

    @Deprecated
    public static void setBuilderSound(Context context, String str) {
    }

    public static void setDoNotDisturb(int i2, int i3, int i4, int i5, c.a.a.a.a.a aVar) {
        m.a(i2, i3, i4, i5, aVar);
    }

    public static void setDoNotDisturbMode(boolean z) {
        m.a(z);
    }

    public static void setEnv(Context context, @AccsClientConfig.ENV int i2) {
        ACCSClient.setEnvironment(context, i2);
    }

    @Deprecated
    public static void setNotificationIcon(Context context, int i2) {
    }

    @Deprecated
    public static void setNotificationSound(Context context, boolean z) {
    }

    @Deprecated
    public static void setNotificationVibrate(Context context, boolean z) {
    }

    public static void setPushMsgReceiveService(Class cls) {
        AdapterGlobalClientInfo.mAgooCustomServiceName = AgooInnerService.class.getName();
        m.a((Class<?>) cls);
    }

    public static void setReportPushArrive(c.a.a.a.a.d dVar) {
        m.a(dVar);
    }

    @Deprecated
    public static void unBindAgoo(Context context, String str, String str2, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void unbindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, false);
        UTMini.getInstance().commitEvent(EVENT_ID, "unregister", UtilityImpl.getDeviceId(context));
    }

    @Deprecated
    public static void unregister(Context context, CallBack callBack) {
        unbindAgoo(context, null);
    }

    public static void bindAgoo(Context context, ICallback iCallback) {
        sendSwitch(context, iCallback, true);
        UTMini.getInstance().commitEvent(EVENT_ID, "bindAgoo", UtilityImpl.getDeviceId(context));
    }

    public static void clickMessage(CPushMessage cPushMessage) {
        m.a(cPushMessage);
    }

    public static void dismissMessage(CPushMessage cPushMessage) {
        m.b(cPushMessage);
    }

    public static synchronized void register(Context context, String str, String str2, String str3, String str4, IRegister iRegister) throws AccsException {
        if (context != null) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                ALog.i(TAG, com.taobao.agoo.a.a.c.JSON_CMD_REGISTER, Constants.KEY_APP_KEY, str2, Constants.KEY_CONFIG_TAG, str);
                Context applicationContext = context.getApplicationContext();
                Config.f14935a = str;
                Config.setAgooAppKey(context, str2);
                AdapterUtilityImpl.mAgooAppSecret = str3;
                Config.a(context, str3);
                if (!TextUtils.isEmpty(str3)) {
                    AdapterGlobalClientInfo.mSecurityType = 2;
                }
                m.a(context);
                AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                if (configByTag == null) {
                    new AccsClientConfig.Builder().setAppKey(str2).setAppSecret(str3).setTag(str).build();
                } else {
                    AdapterGlobalClientInfo.mAuthCode = configByTag.getAuthCode();
                }
                IACCSManager accsInstance = ACCSManager.getAccsInstance(context, str2, str);
                accsInstance.bindApp(applicationContext, str2, str3, str4, new com.taobao.agoo.c(iRegister, applicationContext, accsInstance, str2, str4));
                return;
            }
        }
        ALog.e(TAG, "register params null", "appkey", str2, Constants.KEY_CONFIG_TAG, str);
    }

    public static synchronized void removeAlias(final Context context, final String str, ICallback iCallback) {
        ALog.i(TAG, "removeAlias " + str, new Object[0]);
        final ICallback iCallbackCheckNull = checkNull(iCallback);
        if (context != null && str != null) {
            doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, context, new ICallback() { // from class: com.taobao.agoo.TaobaoRegister.6
                @Override // com.taobao.agoo.ICallback
                public void onFailure(final String str2, final String str3) {
                    TaobaoRegister.doAliasOperation("listAlias", context, new IListAliasCallbackInner() { // from class: com.taobao.agoo.TaobaoRegister.6.1
                        @Override // com.taobao.agoo.ICallback
                        public void onFailure(String str4, String str5) {
                            iCallbackCheckNull.onFailure(str4, str5);
                        }

                        @Override // com.taobao.agoo.IListAliasCallbackInner
                        public void onSuccess(Map<String, String> map) {
                            String str4 = map.get(str);
                            if (str4 == null) {
                                iCallbackCheckNull.onFailure(str2, str3);
                            } else {
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                TaobaoRegister.doAliasOperation(com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, context, iCallbackCheckNull, new d(str, str4, null));
                            }
                        }
                    }, new c(null));
                }

                @Override // com.taobao.agoo.ICallback
                public void onSuccess() {
                    iCallbackCheckNull.onSuccess();
                }
            }, new d(str, null, 0 == true ? 1 : 0));
            return;
        }
        ErrorCode errorCodeBuild = com.taobao.agoo.a.INVALID_ARG.copy().detail("removeAlias " + context + " " + str).build();
        iCallbackCheckNull.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
    }
}
