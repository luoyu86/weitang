package anet.channel;

import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.security.ISecurity;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class Config {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ENV f306d = ENV.ONLINE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ISecurity f307e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Config> f303a = new HashMap();
    public static final Config DEFAULT_CONFIG = new Builder().setTag("[default]").setAppkey("[default]").setEnv(ENV.ONLINE).build();

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ENV f310c = ENV.ONLINE;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f311d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f312e;

        public Config build() {
            if (TextUtils.isEmpty(this.f309b)) {
                throw new RuntimeException("appkey can not be null or empty!");
            }
            synchronized (Config.f303a) {
                for (Config config : Config.f303a.values()) {
                    if (config.f306d == this.f310c && config.f305c.equals(this.f309b)) {
                        ALog.w("awcn.Config", "duplicated config exist!", null, "appkey", this.f309b, "env", this.f310c);
                        if (!TextUtils.isEmpty(this.f308a)) {
                            Config.f303a.put(this.f308a, config);
                        }
                        return config;
                    }
                }
                Config config2 = new Config();
                config2.f305c = this.f309b;
                config2.f306d = this.f310c;
                if (TextUtils.isEmpty(this.f308a)) {
                    config2.f304b = StringUtils.concatString(this.f309b, "$", this.f310c.toString());
                } else {
                    config2.f304b = this.f308a;
                }
                if (TextUtils.isEmpty(this.f312e)) {
                    config2.f307e = anet.channel.security.c.a().createSecurity(this.f311d);
                } else {
                    config2.f307e = anet.channel.security.c.a().createNonSecurity(this.f312e);
                }
                synchronized (Config.f303a) {
                    Config.f303a.put(config2.f304b, config2);
                }
                return config2;
            }
        }

        public Builder setAppSecret(String str) {
            this.f312e = str;
            return this;
        }

        public Builder setAppkey(String str) {
            this.f309b = str;
            return this;
        }

        public Builder setAuthCode(String str) {
            this.f311d = str;
            return this;
        }

        public Builder setEnv(ENV env) {
            this.f310c = env;
            return this;
        }

        public Builder setTag(String str) {
            this.f308a = str;
            return this;
        }
    }

    public static Config getConfig(String str, ENV env) {
        synchronized (f303a) {
            for (Config config : f303a.values()) {
                if (config.f306d == env && config.f305c.equals(str)) {
                    return config;
                }
            }
            return null;
        }
    }

    public static Config getConfigByTag(String str) {
        Config config;
        synchronized (f303a) {
            config = f303a.get(str);
        }
        return config;
    }

    public String getAppkey() {
        return this.f305c;
    }

    public ENV getEnv() {
        return this.f306d;
    }

    public ISecurity getSecurity() {
        return this.f307e;
    }

    public String getTag() {
        return this.f304b;
    }

    public String toString() {
        return this.f304b;
    }
}
