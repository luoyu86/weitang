package com.alibaba.sdk.android.man;

import android.app.Application;
import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.MotuCrashReporter;
import com.alibaba.sdk.android.man.customperf.MANCustomPerformance;
import com.alibaba.sdk.android.man.util.EventCommitTool;
import com.alibaba.sdk.android.man.util.MANLog;
import com.alibaba.sdk.android.man.util.ToolKit;
import com.alibaba.sdk.android.man.util.UTWrapper;
import com.alibaba.sdk.android.utils.AMSConfigUtils;
import com.alibaba.sdk.android.utils.AlicloudTrackerManager;
import com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback;
import com.ut.mini.IUTApplication;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;

/* JADX INFO: loaded from: classes.dex */
public class MANAnalytics {
    private static final String PRODUCT = "man";
    private static final int crashLimitCount = 10;
    private static final int initTimeSecond = 5;
    public final String TAG;
    private String appVersion;
    private String channel;
    private volatile Boolean isEnabled;
    private Boolean turnOnDebug;

    public static class Singleton {
        public static MANAnalytics instance = new MANAnalytics();

        private Singleton() {
        }
    }

    public static MANAnalytics getInstance() {
        return Singleton.instance;
    }

    private void innerInit(Application application, Context context, final String str, final String str2) {
        if (this.appVersion.isEmpty()) {
            this.appVersion = ToolKit.getMetaDataAppVersion(context);
        }
        if (this.channel.isEmpty()) {
            this.channel = ToolKit.getMetaDataChannel(context);
        }
        UTWrapper.utInit(str, str2, application);
        UTAnalytics.getInstance().setAppApplicationInstance(application, new IUTApplication() { // from class: com.alibaba.sdk.android.man.MANAnalytics.2
            @Override // com.ut.mini.IUTApplication
            public String getUTAppVersion() {
                return MANAnalytics.this.appVersion;
            }

            @Override // com.ut.mini.IUTApplication
            public String getUTChannel() {
                return MANAnalytics.this.channel;
            }

            @Override // com.ut.mini.IUTApplication
            public IUTCrashCaughtListner getUTCrashCraughtListener() {
                return null;
            }

            @Override // com.ut.mini.IUTApplication
            public IUTRequestAuthentication getUTRequestAuthInstance() {
                return new UTBaseRequestAuthentication(str, str2, false);
            }

            @Override // com.ut.mini.IUTApplication
            public boolean isAliyunOsSystem() {
                return false;
            }

            @Override // com.ut.mini.IUTApplication
            public boolean isUTCrashHandlerDisable() {
                return true;
            }

            @Override // com.ut.mini.IUTApplication
            public boolean isUTLogEnable() {
                return MANAnalytics.this.turnOnDebug.booleanValue();
            }
        });
        MANTracker.getInstance().appKey = str;
        initMANInternal(context, str, this.appVersion);
        UTWrapper.commitDAUEvent(context);
    }

    private void setMetaDataChannel(Context context) {
        String metaDataChannel = ToolKit.getMetaDataChannel(context);
        if (metaDataChannel.equals("")) {
            return;
        }
        this.channel = metaDataChannel;
    }

    public MANTracker getDefaultTracker() {
        return MANTracker.getInstance();
    }

    public boolean init(Application application, Context context) {
        if (context == null || application == null) {
            MANLog.Loge("MAN_MANAnalytics", "MAN init failed, app context can't be null.");
            return false;
        }
        String appKey = AMSConfigUtils.getAppKey(context);
        String appSecret = AMSConfigUtils.getAppSecret(context);
        if (ToolKit.isNullOrEmpty(appKey)) {
            appKey = ToolKit.getMetaDataAppKey(context);
        }
        if (ToolKit.isNullOrEmpty(appSecret)) {
            appSecret = ToolKit.getMetaDataAppSecret(context);
        }
        if (ToolKit.isNullOrEmpty(appKey) || ToolKit.isNullOrEmpty(appSecret)) {
            MANLog.Loge("MAN_MANAnalytics", "MAN init failed, invalid appKey/appSecret.");
            return false;
        }
        init(application, context, appKey, appSecret);
        return true;
    }

    public void initMANInternal(Context context, String str, String str2) {
        setMetaDataChannel(context);
        if (MotuCrashReporter.getInstance().enable(context, str, str2, null, null, null)) {
            MANLog.Logi("CrashReporter", "Turn on success.");
        } else {
            MANLog.Loge("CrashReporter", "Turn on fail.");
        }
    }

    public void sendCustomPerformance(MANCustomPerformance mANCustomPerformance) {
        if (!this.isEnabled.booleanValue()) {
            MANLog.Loge("MAN_MANAnalytics", "MAN init failed,can not work for now!");
        } else {
            if (mANCustomPerformance == null || mANCustomPerformance.getDuration() == -1 || ToolKit.isNullOrEmpty(mANCustomPerformance.getEventLabel())) {
                return;
            }
            EventCommitTool.commitCustomPerformanceEvent(mANCustomPerformance);
        }
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
        MotuCrashReporter.getInstance().setAppVersion(str);
        UTAnalytics.getInstance().setAppVersion(str);
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void turnOffAutoPageTrack() {
        if (this.isEnabled.booleanValue()) {
            UTPageHitHelper.getInstance().turnOffAutoPageTrack();
        } else {
            MANLog.Loge("MAN_MANAnalytics", "MAN init failed,can not work for now!");
        }
    }

    public void turnOffCrashReporter() {
        if (MotuCrashReporter.getInstance().turnoffCrashReporter()) {
            MANLog.Logi("CrashReporter", "Turn off success.");
        }
    }

    public void turnOnDebug() {
        this.turnOnDebug = Boolean.TRUE;
        MANLog.enableLog();
    }

    public void updateUserAccount(String str, String str2) {
        if (!this.isEnabled.booleanValue()) {
            MANLog.Loge("MAN_MANAnalytics", "MAN init failed,can not work for now!");
        } else {
            UTAnalytics.getInstance().updateUserAccount(str, str2);
            UTWrapper.commitUserEvent("2");
        }
    }

    public void userRegister(String str) {
        if (!this.isEnabled.booleanValue()) {
            MANLog.Loge("MAN_MANAnalytics", "MAN init failed,can not work for now!");
        } else {
            UTAnalytics.getInstance().userRegister(str);
            UTWrapper.commitUserEvent("1");
        }
    }

    private MANAnalytics() {
        this.appVersion = "";
        this.channel = "";
        this.turnOnDebug = Boolean.FALSE;
        this.TAG = "MAN_MANAnalytics";
        this.isEnabled = Boolean.TRUE;
    }

    public void init(Application application, Context context, String str, String str2) {
        if (context != null && application != null) {
            AlicloudTrackerManager.getInstance(application).registerCrashDefend(PRODUCT, a.f4678d, 10, 5, new SDKMessageCallback() { // from class: com.alibaba.sdk.android.man.MANAnalytics.1
                @Override // com.alibaba.sdk.android.utils.crashdefend.SDKMessageCallback
                public void crashDefendMessage(int i2, int i3) {
                    if (i2 > i3) {
                        MANAnalytics.this.isEnabled = Boolean.TRUE;
                        MANLog.Logd("MAN_MANAnalytics", "MAN init success.");
                    } else {
                        MANAnalytics.this.isEnabled = Boolean.FALSE;
                        MANLog.Loge("MAN_MANAnalytics", "MAN init failed,cause crashCount > limitCount!");
                    }
                    MANTracker.getInstance().setEnableStatus(MANAnalytics.this.isEnabled.booleanValue());
                    MANPageHitHelper.getInstance().setEnableStatus(MANAnalytics.this.isEnabled.booleanValue());
                }
            });
            if (this.isEnabled.booleanValue()) {
                MANLog.Logd("MAN_MANAnalytics", "isEnabled is true, so execute init function!");
                innerInit(application, context, str, str2);
                return;
            }
            return;
        }
        MANLog.Loge("MAN_MANAnalytics", "MAN init failed, app context can't be null.");
    }
}
