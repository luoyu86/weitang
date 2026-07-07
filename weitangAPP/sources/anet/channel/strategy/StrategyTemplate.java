package anet.channel.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class StrategyTemplate {
    public Map<String, ConnProtocol> templateMap = new ConcurrentHashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static StrategyTemplate f626a = new StrategyTemplate();
    }

    public static StrategyTemplate getInstance() {
        return a.f626a;
    }

    public ConnProtocol getConnProtocol(String str) {
        return this.templateMap.get(str);
    }

    public void registerConnProtocol(String str, ConnProtocol connProtocol) {
        if (connProtocol != null) {
            this.templateMap.put(str, connProtocol);
            try {
                IStrategyInstance strategyCenter = StrategyCenter.getInstance();
                if (strategyCenter instanceof g) {
                    ((g) strategyCenter).f650b.f611c.a(str, connProtocol);
                }
            } catch (Exception unused) {
            }
        }
    }
}
