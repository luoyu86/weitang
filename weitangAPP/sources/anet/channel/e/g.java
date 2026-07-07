package anet.channel.e;

import anet.channel.entity.ConnType;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;

/* JADX INFO: loaded from: classes.dex */
public final class g implements IConnStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IConnStrategy f453a;

    public g(IConnStrategy iConnStrategy) {
        this.f453a = iConnStrategy;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.f453a.getConnectionTimeout();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return this.f453a.getHeartbeat();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.f453a.getIp();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return this.f453a.getIpSource();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return this.f453a.getIpType();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.f453a.getPort();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        this.f453a.getProtocol();
        return ConnProtocol.valueOf(ConnType.HTTP3_1RTT, null, null);
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.f453a.getReadTimeout();
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return this.f453a.getRetryTimes();
    }
}
