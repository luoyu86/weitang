package anet.channel.strategy;

import anet.channel.strategy.StrategyList;
import anet.channel.strategy.l;

/* JADX INFO: loaded from: classes.dex */
public class j implements StrategyList.Predicate<IPConnStrategy> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l.a f656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ConnProtocol f658c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StrategyList f659d;

    public j(StrategyList strategyList, l.a aVar, String str, ConnProtocol connProtocol) {
        this.f659d = strategyList;
        this.f656a = aVar;
        this.f657b = str;
        this.f658c = connProtocol;
    }

    @Override // anet.channel.strategy.StrategyList.Predicate
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean apply(IPConnStrategy iPConnStrategy) {
        return iPConnStrategy.getPort() == this.f656a.f661a && iPConnStrategy.getIp().equals(this.f657b) && iPConnStrategy.protocol.equals(this.f658c);
    }
}
