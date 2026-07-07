package anet.channel.detect;

import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.l;

/* JADX INFO: loaded from: classes.dex */
public final class j implements IConnStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l.e f423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConnProtocol f424b;

    public j(l.e eVar, ConnProtocol connProtocol) {
        this.f423a = eVar;
        this.f424b = connProtocol;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.f423a.f689b.f663c;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return 0;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.f423a.f688a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return 2;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return 1;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.f423a.f689b.f661a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        return this.f424b;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.f423a.f689b.f664d;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return 0;
    }
}
