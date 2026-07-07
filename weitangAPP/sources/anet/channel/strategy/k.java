package anet.channel.strategy;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class k implements Comparator<IPConnStrategy> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StrategyList f660a;

    public k(StrategyList strategyList) {
        this.f660a = strategyList;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(IPConnStrategy iPConnStrategy, IPConnStrategy iPConnStrategy2) {
        int i2;
        int i3;
        ConnHistoryItem connHistoryItem = (ConnHistoryItem) this.f660a.f616b.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
        ConnHistoryItem connHistoryItem2 = (ConnHistoryItem) this.f660a.f616b.get(Integer.valueOf(iPConnStrategy2.getUniqueId()));
        int iA = connHistoryItem.a();
        int iA2 = connHistoryItem2.a();
        if (iA != iA2) {
            return iA - iA2;
        }
        if (iPConnStrategy.f595a != iPConnStrategy2.f595a) {
            i2 = iPConnStrategy.f595a;
            i3 = iPConnStrategy2.f595a;
        } else {
            i2 = iPConnStrategy.protocol.isHttp;
            i3 = iPConnStrategy2.protocol.isHttp;
        }
        return i2 - i3;
    }
}
