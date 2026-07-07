package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class IPConnStrategy implements IConnStrategy, Serializable {
    public static final int SOURCE_AMDC = 0;
    public static final int SOURCE_CUSTOMIZED = 2;
    public static final int SOURCE_LOCAL_DNS = 1;
    public static final int TYPE_IP_TO_HOST = -1;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_STATIC_BANDWITDH = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f595a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f596b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient boolean f597c;
    public volatile int cto;
    public volatile int heartbeat;
    public final String ip;
    public final int port;
    public final ConnProtocol protocol;
    public volatile int retry;
    public volatile int rto;

    private IPConnStrategy(String str, int i2, ConnProtocol connProtocol, int i3, int i4, int i5, int i6) {
        this.ip = str;
        this.port = i2;
        this.protocol = connProtocol;
        this.cto = i3;
        this.rto = i4;
        this.retry = i5;
        this.heartbeat = i6;
    }

    public static IPConnStrategy a(String str, l.a aVar) {
        ConnProtocol connProtocolValueOf = ConnProtocol.valueOf(aVar);
        if (connProtocolValueOf == null) {
            return null;
        }
        return a(str, aVar.f661a, connProtocolValueOf, aVar.f663c, aVar.f664d, aVar.f665e, aVar.f666f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IPConnStrategy)) {
            return false;
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) obj;
        return this.port == iPConnStrategy.port && this.ip.equals(iPConnStrategy.ip) && this.protocol.equals(iPConnStrategy.protocol);
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.cto;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return this.heartbeat;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.ip;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return this.f596b;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return this.f595a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.port;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        return this.protocol;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.rto;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return this.retry;
    }

    public int getUniqueId() {
        return hashCode();
    }

    public int hashCode() {
        return ((((527 + this.ip.hashCode()) * 31) + this.port) * 31) + this.protocol.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        sb.append(this.ip);
        if (this.f595a == 0) {
            sb.append("(*)");
        }
        sb.append(' ');
        sb.append(this.port);
        sb.append(' ');
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    public static IPConnStrategy a(String str, int i2, ConnProtocol connProtocol, int i3, int i4, int i5, int i6) {
        if (TextUtils.isEmpty(str) || connProtocol == null || i2 <= 0) {
            return null;
        }
        return new IPConnStrategy(str, i2, connProtocol, i3, i4, i5, i6);
    }
}
