package com.taobao.accs.net;

import anet.channel.entity.ConnType;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.HttpDispatcher;
import com.taobao.accs.utl.ALog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10375a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<IConnStrategy> f10376b = new ArrayList();

    public g(String str) {
        HttpDispatcher.getInstance().addListener(new h(this));
        a(str);
    }

    public List<IConnStrategy> a(String str) {
        List<IConnStrategy> connStrategyListByHost;
        if ((this.f10375a == 0 || this.f10376b.isEmpty()) && (connStrategyListByHost = StrategyCenter.getInstance().getConnStrategyListByHost(str)) != null && !connStrategyListByHost.isEmpty()) {
            this.f10376b.clear();
            for (IConnStrategy iConnStrategy : connStrategyListByHost) {
                ConnType connTypeValueOf = ConnType.valueOf(iConnStrategy.getProtocol());
                if (connTypeValueOf.getTypeLevel() == ConnType.TypeLevel.SPDY && connTypeValueOf.isSSL()) {
                    this.f10376b.add(iConnStrategy);
                }
            }
        }
        return this.f10376b;
    }

    public void b() {
        this.f10375a++;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("HttpDnsProvider", "updateStrategyPos StrategyPos:" + this.f10375a, new Object[0]);
        }
    }

    public int c() {
        return this.f10375a;
    }

    public void b(String str) {
        StrategyCenter.getInstance().forceRefreshStrategy(str);
    }

    public IConnStrategy a() {
        return a(this.f10376b);
    }

    public IConnStrategy a(List<IConnStrategy> list) {
        if (list != null && !list.isEmpty()) {
            int i2 = this.f10375a;
            if (i2 < 0 || i2 >= list.size()) {
                this.f10375a = 0;
            }
            return list.get(this.f10375a);
        }
        ALog.d("HttpDnsProvider", "strategies null or 0", new Object[0]);
        return null;
    }
}
