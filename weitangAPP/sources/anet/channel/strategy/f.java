package anet.channel.strategy;

import anet.channel.statist.StrategyStatObject;
import anet.channel.strategy.StrategyInfoHolder;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StrategyInfoHolder.LruStrategyMap f648b;

    public f(StrategyInfoHolder.LruStrategyMap lruStrategyMap, Map.Entry entry) {
        this.f648b = lruStrategyMap;
        this.f647a = entry;
    }

    @Override // java.lang.Runnable
    public void run() {
        StrategyTable strategyTable = (StrategyTable) this.f647a.getValue();
        if (strategyTable.f623d) {
            StrategyStatObject strategyStatObject = new StrategyStatObject(1);
            strategyStatObject.writeStrategyFileId = strategyTable.f620a;
            m.a((Serializable) this.f647a.getValue(), strategyTable.f620a, strategyStatObject);
            strategyTable.f623d = false;
        }
    }
}
