package anet.channel.strategy;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class o implements Comparator<StrategyCollection> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(StrategyCollection strategyCollection, StrategyCollection strategyCollection2) {
        return strategyCollection.f599b != strategyCollection2.f599b ? (int) (strategyCollection.f599b - strategyCollection2.f599b) : strategyCollection.f598a.compareTo(strategyCollection2.f598a);
    }
}
