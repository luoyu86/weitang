package com.alibaba.sdk.android.push.noonesdk;

import android.app.Application;
import com.alibaba.sdk.android.push.util.DownloadUtil;

/* JADX INFO: loaded from: classes.dex */
public class PushInitConfig {
    private final String mAccsAppConnectHost;
    private final String mAccsSilentConnectHost;
    private final String mAppKey;
    private final String mAppSecret;
    private final Application mApplication;
    private final boolean mDisableChannelProcess;
    private final boolean mDisableChannelProcessHeartbeat;
    private final boolean mDisableForegroundCheck;
    private final DownloadUtil.OnLargeIconDownloadListener mLargeIconDownloadListener;
    private final long mLoopInterval;
    private final boolean mLoopStartChannel;
    private final String mPushHost;

    public static class Builder {
        private Application application;
        private DownloadUtil.OnLargeIconDownloadListener mLargeIconDownloadListener;
        private String appKey = null;
        private String appSecret = null;
        private boolean disableChannelProcess = false;
        private boolean disableChannelProcessHeartbeat = true;
        private boolean loopStartChannel = false;
        private long loopInterval = 300000;
        private boolean disableForegroundCheck = false;
        private String pushHost = null;
        private String accsAppConnectHost = null;
        private String accsSilentConnectHost = null;

        public Builder accsAppConnectHost(String str) {
            this.accsAppConnectHost = str;
            return this;
        }

        public Builder accsSilentConnectHost(String str) {
            this.accsSilentConnectHost = str;
            return this;
        }

        public Builder appKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder appSecret(String str) {
            this.appSecret = str;
            return this;
        }

        public Builder application(Application application) {
            this.application = application;
            return this;
        }

        public PushInitConfig build() {
            return new PushInitConfig(this);
        }

        @Deprecated
        public Builder disableChannelProcess(boolean z) {
            this.disableChannelProcess = z;
            return this;
        }

        @Deprecated
        public Builder disableChannelProcessHeartbeat(boolean z) {
            this.disableChannelProcessHeartbeat = z;
            return this;
        }

        public Builder disableForegroundCheck(boolean z) {
            this.disableForegroundCheck = z;
            return this;
        }

        public Builder largeIconDownloadListener(DownloadUtil.OnLargeIconDownloadListener onLargeIconDownloadListener) {
            this.mLargeIconDownloadListener = onLargeIconDownloadListener;
            return this;
        }

        public Builder loopInterval(long j) {
            this.loopInterval = j;
            return this;
        }

        public Builder loopStartChannel(boolean z) {
            this.loopStartChannel = z;
            return this;
        }

        public Builder pushHost(String str) {
            this.pushHost = str;
            return this;
        }
    }

    public PushInitConfig(Builder builder) {
        this.mApplication = builder.application;
        this.mAppKey = builder.appKey;
        this.mAppSecret = builder.appSecret;
        this.mDisableChannelProcess = builder.disableChannelProcess;
        this.mLoopStartChannel = builder.loopStartChannel;
        this.mLoopInterval = builder.loopInterval;
        this.mDisableForegroundCheck = builder.disableForegroundCheck;
        this.mDisableChannelProcessHeartbeat = builder.disableChannelProcessHeartbeat;
        this.mPushHost = builder.pushHost;
        this.mAccsAppConnectHost = builder.accsAppConnectHost;
        this.mAccsSilentConnectHost = builder.accsSilentConnectHost;
        this.mLargeIconDownloadListener = builder.mLargeIconDownloadListener;
    }

    public String getAccsAppConnectHost() {
        return this.mAccsAppConnectHost;
    }

    public String getAccsSilentConnectHost() {
        return this.mAccsSilentConnectHost;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public Application getApplication() {
        return this.mApplication;
    }

    public DownloadUtil.OnLargeIconDownloadListener getLargeIconDownloadListener() {
        return this.mLargeIconDownloadListener;
    }

    public long getLoopInterval() {
        return this.mLoopInterval;
    }

    public String getPushHost() {
        return this.mPushHost;
    }

    public boolean isDisableChannelProcess() {
        return this.mDisableChannelProcess;
    }

    public boolean isDisableChannelProcessHeartbeat() {
        return this.mDisableChannelProcessHeartbeat;
    }

    public boolean isDisableForegroundCheck() {
        return this.mDisableForegroundCheck;
    }

    public boolean isLoopStartChannel() {
        return this.mLoopStartChannel;
    }
}
