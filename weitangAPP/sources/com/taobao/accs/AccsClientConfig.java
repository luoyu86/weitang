package com.taobao.accs;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.logger.ILog;
import com.alipay.sdk.m.u.i;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.AccsLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class AccsClientConfig {
    public static final String DEFAULT_CONFIG_TAG = "default";
    public static final int SECURITY_OFF = 2;
    public static final int SECURITY_OPEN = 1;
    public static final int SECURITY_TAOBAO = 0;
    private static Context mContext;
    private long loopInterval;
    private boolean mAccsHeartbeatEnable;
    private String mAppKey;
    private String mAppSecret;
    private String mAuthCode;
    private boolean mAutoUnit;
    private String mChannelHost;
    private boolean mChannelLoopStart;
    private int mChannelPubKey;
    private int mConfigEnv;
    private boolean mDisableChannel;
    private String mInappHost;
    private int mInappPubKey;
    private boolean mKeepalive;
    private boolean mQuickReconnect;
    private int mSecurity;
    private String mStoreId;
    private String mTag;
    private static final ILog LOGGER = AccsLogger.getLogger("AccsClientConfig");
    public static final String[] DEFAULT_CENTER_HOSTS = {"msgacs.m.taobao.com", "msgacs.wapa.taobao.com", "msgacs.waptest.taobao.com"};
    private static final String[] DEFAULT_CHANNEL_HOSTS = {"accscdn.m.taobao.com", "acs.wapa.taobao.com", "acs.waptest.taobao.com"};

    @Deprecated
    public static boolean loadedStaticConfig = true;

    @ENV
    public static int mEnv = 0;
    private static final Map<String, AccsClientConfig> mReleaseConfigs = new ConcurrentHashMap(1);
    private static final Map<String, AccsClientConfig> mPreviewConfigs = new ConcurrentHashMap(1);
    private static final Map<String, AccsClientConfig> mDebugConfigs = new ConcurrentHashMap(1);

    public static class Builder {
        private String mAppKey;
        private String mAppSecret;
        private String mAuthCode;
        private String mChannelHost;
        private String mInappHost;
        private String mStoreId;
        private String mTag;
        private int mInappPubKey = -1;
        private int mChannelPubKey = -1;
        private boolean mKeepalive = true;
        private boolean mAutoUnit = true;
        private int mConfigEnv = -1;
        private boolean mDisableChannel = false;
        private boolean mQuickReconnect = false;
        private boolean mAccsHeartbeatEnable = false;
        private boolean mChannelLoopStart = false;
        private long loopInterval = 300000;

        public AccsClientConfig build() throws AccsException {
            if (TextUtils.isEmpty(this.mAppKey)) {
                throw new AccsException("appkey null");
            }
            if (TextUtils.isEmpty(this.mAppSecret)) {
                throw new AccsException("appSecret null");
            }
            AccsClientConfig accsClientConfig = new AccsClientConfig();
            accsClientConfig.mAppKey = this.mAppKey;
            accsClientConfig.mAppSecret = this.mAppSecret;
            accsClientConfig.mAuthCode = this.mAuthCode;
            accsClientConfig.mKeepalive = this.mKeepalive;
            accsClientConfig.mAutoUnit = this.mAutoUnit;
            accsClientConfig.mInappPubKey = this.mInappPubKey;
            accsClientConfig.mChannelPubKey = this.mChannelPubKey;
            accsClientConfig.mInappHost = this.mInappHost;
            accsClientConfig.mChannelHost = this.mChannelHost;
            accsClientConfig.mTag = this.mTag;
            accsClientConfig.mStoreId = this.mStoreId;
            accsClientConfig.mConfigEnv = this.mConfigEnv;
            accsClientConfig.mDisableChannel = this.mDisableChannel;
            accsClientConfig.mQuickReconnect = this.mQuickReconnect;
            accsClientConfig.mAccsHeartbeatEnable = this.mAccsHeartbeatEnable;
            accsClientConfig.mChannelLoopStart = this.mChannelLoopStart;
            accsClientConfig.loopInterval = this.loopInterval;
            if (accsClientConfig.mConfigEnv < 0) {
                accsClientConfig.mConfigEnv = AccsClientConfig.mEnv;
            }
            accsClientConfig.mSecurity = 2;
            if (TextUtils.isEmpty(accsClientConfig.mInappHost)) {
                accsClientConfig.mInappHost = AccsClientConfig.DEFAULT_CENTER_HOSTS[accsClientConfig.mConfigEnv];
            }
            if (TextUtils.isEmpty(accsClientConfig.mChannelHost)) {
                accsClientConfig.mChannelHost = AccsClientConfig.DEFAULT_CHANNEL_HOSTS[accsClientConfig.mConfigEnv];
            }
            if (TextUtils.isEmpty(accsClientConfig.mTag)) {
                accsClientConfig.mTag = accsClientConfig.mAppKey;
            }
            int i2 = accsClientConfig.mConfigEnv;
            Map map = i2 != 1 ? i2 != 2 ? AccsClientConfig.mReleaseConfigs : AccsClientConfig.mDebugConfigs : AccsClientConfig.mPreviewConfigs;
            AccsClientConfig.LOGGER.d("build config", accsClientConfig);
            AccsClientConfig accsClientConfig2 = (AccsClientConfig) map.get(accsClientConfig.getTag());
            if (accsClientConfig2 != null) {
                AccsClientConfig.LOGGER.w("build cover", "old", accsClientConfig2, "new", accsClientConfig);
            }
            map.put(accsClientConfig.getTag(), accsClientConfig);
            return accsClientConfig;
        }

        public Builder loopChannelInterval(long j) {
            this.loopInterval = j;
            return this;
        }

        public Builder loopChannelStart(boolean z) {
            this.mChannelLoopStart = z;
            return this;
        }

        public Builder setAccsHeartbeatEnable(boolean z) {
            this.mAccsHeartbeatEnable = z;
            return this;
        }

        public Builder setAppKey(String str) {
            this.mAppKey = str;
            return this;
        }

        public Builder setAppSecret(String str) {
            this.mAppSecret = str;
            return this;
        }

        @Deprecated
        public Builder setAutoCode(String str) {
            this.mAuthCode = str;
            return this;
        }

        public Builder setAutoUnit(boolean z) {
            this.mAutoUnit = z;
            return this;
        }

        public Builder setChannelHost(String str) {
            this.mChannelHost = str;
            return this;
        }

        public Builder setChannelPubKey(int i2) {
            this.mChannelPubKey = i2;
            return this;
        }

        public Builder setConfigEnv(@ENV int i2) {
            this.mConfigEnv = i2;
            return this;
        }

        public Builder setDisableChannel(boolean z) {
            this.mDisableChannel = z;
            return this;
        }

        public Builder setInappHost(String str) {
            this.mInappHost = str;
            return this;
        }

        public Builder setInappPubKey(int i2) {
            this.mInappPubKey = i2;
            return this;
        }

        public Builder setKeepAlive(boolean z) {
            this.mKeepalive = z;
            return this;
        }

        public Builder setQuickReconnect(boolean z) {
            this.mQuickReconnect = z;
            return this;
        }

        public Builder setStoreId(String str) {
            this.mStoreId = str;
            return this;
        }

        public Builder setTag(String str) {
            this.mTag = str;
            return this;
        }
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface ENV {
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface SECURITY_TYPE {
    }

    @Deprecated
    public static AccsClientConfig getConfig(String str) {
        int i2 = mEnv;
        for (AccsClientConfig accsClientConfig : (i2 != 1 ? i2 != 2 ? mReleaseConfigs : mDebugConfigs : mPreviewConfigs).values()) {
            if (accsClientConfig.mAppKey.equals(str) && accsClientConfig.mConfigEnv == mEnv) {
                return accsClientConfig;
            }
        }
        LOGGER.e("getConfigByTag return null", Constants.KEY_APP_KEY, str);
        return null;
    }

    public static AccsClientConfig getConfigByTag(String str) {
        int i2 = mEnv;
        AccsClientConfig accsClientConfig = (i2 != 1 ? i2 != 2 ? mReleaseConfigs : mDebugConfigs : mPreviewConfigs).get(str);
        if (accsClientConfig == null) {
            LOGGER.w("getConfigByTag return null", Constants.KEY_CONFIG_TAG, str);
        }
        return accsClientConfig;
    }

    public static Context getContext() {
        Context context = mContext;
        if (context != null) {
            return context;
        }
        synchronized (AccsClientConfig.class) {
            Context context2 = mContext;
            if (context2 != null) {
                return context2;
            }
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object objInvoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                mContext = (Context) objInvoke.getClass().getMethod("getApplication", new Class[0]).invoke(objInvoke, new Object[0]);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return mContext;
        }
    }

    public static List<String> tags() {
        int i2 = mEnv;
        return new ArrayList((i2 != 1 ? i2 != 2 ? mReleaseConfigs : mDebugConfigs : mPreviewConfigs).keySet());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccsClientConfig accsClientConfig = (AccsClientConfig) obj;
        if (!this.mInappHost.equals(accsClientConfig.mInappHost) || this.mInappPubKey != accsClientConfig.mInappPubKey || !this.mChannelHost.equals(accsClientConfig.mChannelHost) || this.mChannelPubKey != accsClientConfig.mChannelPubKey || this.mSecurity != accsClientConfig.mSecurity || this.mConfigEnv != accsClientConfig.mConfigEnv || !this.mAppKey.equals(accsClientConfig.mAppKey) || this.mKeepalive != accsClientConfig.mKeepalive || this.mDisableChannel != accsClientConfig.mDisableChannel) {
            return false;
        }
        String str = this.mAuthCode;
        if (str == null ? accsClientConfig.mAuthCode != null : !str.equals(accsClientConfig.mAuthCode)) {
            return false;
        }
        String str2 = this.mAppSecret;
        if (str2 == null ? accsClientConfig.mAppSecret == null : str2.equals(accsClientConfig.mAppSecret)) {
            return this.mTag.equals(accsClientConfig.mTag);
        }
        return false;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getAppSecret() {
        return this.mAppSecret;
    }

    public String getAuthCode() {
        return this.mAuthCode;
    }

    public String getChannelHost() {
        return this.mChannelHost;
    }

    public int getChannelPubKey() {
        return this.mChannelPubKey;
    }

    public int getConfigEnv() {
        return this.mConfigEnv;
    }

    public boolean getDisableChannel() {
        return this.mDisableChannel;
    }

    public String getInappHost() {
        return this.mInappHost;
    }

    public int getInappPubKey() {
        return this.mInappPubKey;
    }

    public long getLoopInterval() {
        return this.loopInterval;
    }

    public int getSecurity() {
        return this.mSecurity;
    }

    public String getStoreId() {
        return this.mStoreId;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isAccsHeartbeatEnable() {
        return this.mAccsHeartbeatEnable;
    }

    public boolean isAutoUnit() {
        return this.mAutoUnit;
    }

    public boolean isChannelLoopStart() {
        return this.mChannelLoopStart;
    }

    public boolean isKeepalive() {
        return this.mKeepalive;
    }

    public boolean isQuickReconnect() {
        return this.mQuickReconnect;
    }

    public String toString() {
        return "AccsClientConfig{Tag=" + this.mTag + ", ConfigEnv=" + this.mConfigEnv + ", AppKey=" + this.mAppKey + ", AppSecret=" + this.mAppSecret + ", InappHost=" + this.mInappHost + ", ChannelHost=" + this.mChannelHost + ", Security=" + this.mSecurity + ", AuthCode=" + this.mAuthCode + ", InappPubKey=" + this.mInappPubKey + ", ChannelPubKey=" + this.mChannelPubKey + ", Keepalive=" + this.mKeepalive + ", AutoUnit=" + this.mAutoUnit + ", DisableChannel=" + this.mDisableChannel + ", QuickReconnect=" + this.mQuickReconnect + i.f5699d;
    }
}
