package com.alibaba.sdk.android.push.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import anet.channel.util.ALog;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.crashdefend.CrashDefendApi;
import com.alibaba.sdk.android.crashdefend.CrashDefendCallback;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.logger.LogLevel;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.IPushPermissionCallback;
import com.alibaba.sdk.android.push.notification.CPushMessage;
import com.alibaba.sdk.android.push.util.DownloadUtil;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.utl.AccsLogger;

/* JADX INFO: loaded from: classes.dex */
public class b implements CloudPushService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f4769a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f4770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f4771c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DownloadUtil.OnLargeIconDownloadListener f4774f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4772d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4773e = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f4775g = false;

    public static b a() {
        return f4769a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final Context context, final CommonCallback commonCallback) {
        AmsLogger.getImportantLogger().i("call register");
        com.alibaba.sdk.android.push.e.a.a().a(new CommonCallback() { // from class: com.alibaba.sdk.android.push.a.b.23
            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onFailed(String str, String str2) {
                commonCallback.onFailed(str, str2);
            }

            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onSuccess(String str) {
                commonCallback.onSuccess(str);
                b.this.f4770b.b(context);
            }
        });
        com.alibaba.sdk.android.push.c.a.a(context).a(com.alibaba.sdk.android.ams.common.b.c.a().a());
    }

    private boolean a(String str, CommonCallback commonCallback, Runnable runnable) {
        if (this.f4771c == null) {
            AmsLogger.getImportantLogger().e("please call PushServiceFactory.init first");
            if (commonCallback != null) {
                ErrorCode errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.u.copy().detail(str).build();
                commonCallback.onFailed(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
            }
            return false;
        }
        d();
        if (this.f4772d) {
            if (runnable == null) {
                return true;
            }
            runnable.run();
            return true;
        }
        AmsLogger.getImportantLogger().e("push disabled");
        if (commonCallback != null) {
            ErrorCode errorCodeBuild2 = com.alibaba.sdk.android.push.common.global.c.t.copy().detail(str).build();
            commonCallback.onFailed(errorCodeBuild2.getCode(), errorCodeBuild2.getMsg());
        }
        return false;
    }

    private void d() {
        if (this.f4770b != null || this.f4771c == null) {
            return;
        }
        this.f4770b = new a(this.f4771c);
    }

    public void a(Context context) {
        AmsLogger.getImportantLogger().i("Initialize Mobile Push service...");
        this.f4771c = context;
        if (this.f4770b == null) {
            this.f4770b = new a(context);
        }
        if (this.f4773e) {
            CrashDefendApi.registerCrashDefendSdk(context, "push", "3.10.1", 10, 5, new CrashDefendCallback() { // from class: com.alibaba.sdk.android.push.a.b.1
                @Override // com.alibaba.sdk.android.crashdefend.CrashDefendCallback
                public void onSdkClosed(int i2) {
                    AmsLogger.getImportantLogger().e("crash limit exceeds, close forever");
                    b.this.f4772d = false;
                }

                @Override // com.alibaba.sdk.android.crashdefend.CrashDefendCallback
                public void onSdkStart(int i2, int i3, int i4) {
                    b.this.f4772d = true;
                }

                @Override // com.alibaba.sdk.android.crashdefend.CrashDefendCallback
                public void onSdkStop(int i2, int i3, int i4, long j) {
                    AmsLogger.getImportantLogger().e("crash limit exceeds");
                    b.this.f4772d = false;
                }
            });
        }
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void addAlias(final String str, final CommonCallback commonCallback) {
        a("addAlias", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.29
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.b(str, commonCallback);
            }
        });
    }

    public DownloadUtil.OnLargeIconDownloadListener b() {
        return this.f4774f;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void bindAccount(final String str, final CommonCallback commonCallback) {
        a("bindAccount", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.24
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(str, commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void bindPhoneNumber(final String str, final CommonCallback commonCallback) {
        a("bindPhoneNumber", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.20
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.d(str, commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void bindTag(final int i2, final String[] strArr, final String str, final CommonCallback commonCallback) {
        a("bindTag", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.26
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(i2, strArr, str, commonCallback);
            }
        });
    }

    public boolean c() {
        return this.f4775g;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void checkPushChannelStatus(final CommonCallback commonCallback) {
        a("checkPushChannelStatus", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.16
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.f(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void clearNotifications() {
        a("clearNotifications", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.13
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.b();
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void clickMessage(final CPushMessage cPushMessage) {
        a("clickMessage", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.18
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(cPushMessage);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void closeDoNotDisturbMode() {
        a("closeDoNotDisturbMode", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(false);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void dismissMessage(final CPushMessage cPushMessage) {
        a("dismissMessage", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.17
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.b(cPushMessage);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public String getDeviceId() {
        if (a("getDeviceId", (CommonCallback) null, (Runnable) null)) {
            return this.f4770b.a();
        }
        return null;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public String getUTDeviceId() {
        if (a("getUTDeviceId", (CommonCallback) null, (Runnable) null)) {
            return this.f4770b.a(this.f4771c);
        }
        return null;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void listAliases(final CommonCallback commonCallback) {
        a("listAlias", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.b(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void listTags(final int i2, final CommonCallback commonCallback) {
        a("listTags", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.28
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(i2, commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void onAppStart() {
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public synchronized void register(final Context context, final CommonCallback commonCallback) {
        if (context != null) {
            a(com.taobao.agoo.a.a.c.JSON_CMD_REGISTER, commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.12
                @Override // java.lang.Runnable
                public void run() {
                    ALog.setUseTlog(false);
                    ACCSClient.changeNetworkSdkLoggerToAccs();
                    b.this.a(context, commonCallback);
                }
            });
            return;
        }
        AmsLogger.getImportantLogger().e("context null");
        if (commonCallback != null) {
            ErrorCode errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.f4884q.copy().detail("register context null").build();
            commonCallback.onFailed(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
        }
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void register(Context context, String str, String str2, CommonCallback commonCallback) {
        if (commonCallback != null) {
            ErrorCode errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.v.copy().msg("请使用PushServiceFactory.init(Context appContext, String appKey, String appSecret)动态设置appKey appSecret").build();
            commonCallback.onFailed(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
        }
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void removeAlias(final String str, final CommonCallback commonCallback) {
        a(com.taobao.agoo.a.a.a.JSON_CMD_REMOVEALIAS, commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.c(str, commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void requestNotificationPermission(Activity activity, int i2, IPushPermissionCallback iPushPermissionCallback) {
        if (Build.VERSION.SDK_INT < 33 || ContextCompat.checkSelfPermission(activity, "android.permission.POST_NOTIFICATIONS") != -1) {
            return;
        }
        if (!(ContextCompat.checkSelfPermission(activity, "android.permission.POST_NOTIFICATIONS") == -1)) {
            if (iPushPermissionCallback != null) {
                iPushPermissionCallback.onPushPermissionGranted();
            }
        } else if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, "android.permission.POST_NOTIFICATIONS")) {
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.POST_NOTIFICATIONS"}, i2);
        } else if (iPushPermissionCallback != null) {
            iPushPermissionCallback.onPushPermissionForbidden();
        }
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setAppSecret(final String str) {
        a("setAppSecret", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.c(str);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setAppkey(final String str) {
        a("setAppKey", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.10
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.b(str);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setBadgeNum(Context context, int i2) {
        com.alibaba.sdk.android.push.util.a.a(context, i2);
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setDebug(final boolean z) {
        a("setDebug", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.22
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.b(z);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setDoNotDisturb(final int i2, final int i3, final int i4, final int i5, final CommonCallback commonCallback) {
        a("setDoNotDisturb", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.5
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(i2, i3, i4, i5, commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setEnableCrashDefend(boolean z) {
        this.f4773e = z;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setLargeIconDownloadListener(DownloadUtil.OnLargeIconDownloadListener onLargeIconDownloadListener) {
        this.f4774f = onLargeIconDownloadListener;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setLogLevel(final int i2) {
        a("setLogLevel", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.4
            @Override // java.lang.Runnable
            public void run() {
                AmsLogger.log_level = i2;
                int i3 = 0;
                ALog.setUseTlog(false);
                ACCSClient.changeNetworkSdkLoggerToAccs();
                int i4 = i2;
                if (i4 == -1) {
                    AccsLogger.enable(false);
                    i3 = 5;
                } else {
                    if (i4 != 0 && i4 != 2 && i4 != 1) {
                        return;
                    }
                    AccsLogger.enable(true);
                    int i5 = i2;
                    if (i5 == 0) {
                        AccsLogger.setLevel(LogLevel.WARN);
                        i3 = 3;
                    } else {
                        if (i5 == 1) {
                            AccsLogger.setLevel(LogLevel.INFO);
                            ALog.setLevel(2);
                            return;
                        }
                        AccsLogger.setLevel(LogLevel.DEBUG);
                    }
                }
                ALog.setLevel(i3);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setNotificationLargeIcon(final Bitmap bitmap) {
        a("setNotificationLargeIcon", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.8
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(bitmap);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setNotificationShowInGroup(boolean z) {
        this.f4775g = z;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setNotificationSmallIcon(final int i2) {
        a("setNotificationSmallIcon", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.9
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(i2);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setNotificationSoundFilePath(final String str) {
        a("setNotificationSoundFilePath", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.7
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(str);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setPushIntentService(final Class cls) {
        a("setPushIntentService", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(cls);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void turnOffPushChannel(final CommonCallback commonCallback) {
        a("turnOffPushChannel", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.15
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.d(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void turnOnPushChannel(final CommonCallback commonCallback) {
        a("turnOnPushChannel", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.14
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.e(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void unbindAccount(final CommonCallback commonCallback) {
        a("unbindAccount", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.25
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.a(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void unbindPhoneNumber(final CommonCallback commonCallback) {
        a("unbindPhoneNumber", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.21
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.c(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void unbindTag(final int i2, final String[] strArr, final String str, final CommonCallback commonCallback) {
        a("unBindTag", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.a.b.27
            @Override // java.lang.Runnable
            public void run() {
                b.this.f4770b.b(i2, strArr, str, commonCallback);
            }
        });
    }
}
