package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.AppLifecycle;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class StrategyTable implements Serializable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Comparator<StrategyCollection> f619e = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile String f621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, Long> f622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient boolean f623d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HostLruCache f624f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile transient int f625g;

    public static class HostLruCache extends SerialLruCache<String, StrategyCollection> {
        public HostLruCache(int i2) {
            super(i2);
        }

        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyCollection> entry) {
            if (!entry.getValue().f601d) {
                return true;
            }
            Iterator<Map.Entry<String, StrategyCollection>> it = entrySet().iterator();
            while (it.hasNext()) {
                if (!it.next().getValue().f601d) {
                    it.remove();
                    return false;
                }
            }
            return false;
        }
    }

    public StrategyTable(String str) {
        this.f620a = str;
        a();
    }

    private void b() {
        if (HttpDispatcher.getInstance().isInitHostsChanged(this.f620a)) {
            for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                this.f624f.put(str, new StrategyCollection(str));
            }
        }
    }

    private void c() {
        try {
            if (HttpDispatcher.getInstance().isInitHostsChanged(this.f620a)) {
                TreeSet treeSet = null;
                synchronized (this.f624f) {
                    for (String str : HttpDispatcher.getInstance().getInitHosts()) {
                        if (!this.f624f.containsKey(str)) {
                            this.f624f.put(str, new StrategyCollection(str));
                            if (treeSet == null) {
                                treeSet = new TreeSet();
                            }
                            treeSet.add(str);
                        }
                    }
                }
                if (treeSet != null) {
                    a(treeSet);
                }
            }
        } catch (Exception e2) {
            ALog.e("awcn.StrategyTable", "checkInitHost failed", this.f620a, e2, new Object[0]);
        }
    }

    public void a() {
        if (this.f624f == null) {
            this.f624f = new HostLruCache(256);
            b();
        }
        Iterator<StrategyCollection> it = this.f624f.values().iterator();
        while (it.hasNext()) {
            it.next().checkInit();
        }
        ALog.i("awcn.StrategyTable", "strategy map", null, "size", Integer.valueOf(this.f624f.size()));
        this.f625g = GlobalAppRuntimeInfo.isTargetProcess() ? 0 : -1;
        if (this.f622c == null) {
            this.f622c = new ConcurrentHashMap();
        }
    }

    public String getCnameByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f624f) {
            strategyCollection = this.f624f.get(str);
        }
        if (strategyCollection != null && strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0) {
            a(str);
        }
        if (strategyCollection != null) {
            return strategyCollection.f600c;
        }
        return null;
    }

    public List<IConnStrategy> queryByHost(String str) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str) || !anet.channel.strategy.utils.c.c(str)) {
            return Collections.EMPTY_LIST;
        }
        c();
        synchronized (this.f624f) {
            strategyCollection = this.f624f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f624f.put(str, strategyCollection);
            }
        }
        if (strategyCollection.f599b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            a(str);
        }
        return strategyCollection.queryStrategyList();
    }

    public void update(l.d dVar) {
        String str;
        ALog.i("awcn.StrategyTable", "update strategyTable with httpDns response", this.f620a, new Object[0]);
        try {
            this.f621b = dVar.f680a;
            this.f625g = dVar.f685f;
            l.b[] bVarArr = dVar.f681b;
            if (bVarArr == null) {
                return;
            }
            synchronized (this.f624f) {
                for (l.b bVar : bVarArr) {
                    if (bVar != null && (str = bVar.f669a) != null) {
                        if (bVar.j) {
                            this.f624f.remove(str);
                        } else {
                            StrategyCollection strategyCollection = this.f624f.get(str);
                            if (strategyCollection == null) {
                                strategyCollection = new StrategyCollection(bVar.f669a);
                                this.f624f.put(bVar.f669a, strategyCollection);
                            }
                            strategyCollection.update(bVar);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            ALog.e("awcn.StrategyTable", "fail to update strategyTable", this.f620a, th, new Object[0]);
        }
        this.f623d = true;
        if (ALog.isPrintLog(1)) {
            StringBuilder sb = new StringBuilder("uniqueId : ");
            sb.append(this.f620a);
            sb.append("\n-------------------------domains:------------------------------------");
            ALog.d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
            synchronized (this.f624f) {
                for (Map.Entry<String, StrategyCollection> entry : this.f624f.entrySet()) {
                    sb.setLength(0);
                    sb.append(entry.getKey());
                    sb.append(" = ");
                    sb.append(entry.getValue().toString());
                    ALog.d("awcn.StrategyTable", sb.toString(), null, new Object[0]);
                }
            }
        }
    }

    private void b(Set<String> set) {
        TreeSet<StrategyCollection> treeSet = new TreeSet(f619e);
        synchronized (this.f624f) {
            treeSet.addAll(this.f624f.values());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (StrategyCollection strategyCollection : treeSet) {
            if (!strategyCollection.isExpired() || set.size() >= 40) {
                return;
            }
            strategyCollection.f599b = 30000 + jCurrentTimeMillis;
            set.add(strategyCollection.f598a);
        }
    }

    private void a(String str) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(str);
        a(treeSet);
    }

    public void a(String str, boolean z) {
        StrategyCollection strategyCollection;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f624f) {
            strategyCollection = this.f624f.get(str);
            if (strategyCollection == null) {
                strategyCollection = new StrategyCollection(str);
                this.f624f.put(str, strategyCollection);
            }
        }
        if (z || strategyCollection.f599b == 0 || (strategyCollection.isExpired() && AmdcRuntimeInfo.getAmdcLimitLevel() == 0)) {
            a(str);
        }
    }

    private void a(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        if ((GlobalAppRuntimeInfo.isAppBackground() && AppLifecycle.lastEnterBackgroundTime > 0) || !NetworkStatusHelper.isConnected()) {
            ALog.i("awcn.StrategyTable", "app in background or no network", this.f620a, new Object[0]);
            return;
        }
        int amdcLimitLevel = AmdcRuntimeInfo.getAmdcLimitLevel();
        if (amdcLimitLevel == 3) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f624f) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                StrategyCollection strategyCollection = this.f624f.get(it.next());
                if (strategyCollection != null) {
                    strategyCollection.f599b = 30000 + jCurrentTimeMillis;
                }
            }
        }
        if (amdcLimitLevel == 0) {
            b(set);
        }
        HttpDispatcher.getInstance().sendAmdcRequest(set, this.f625g);
    }

    public void a(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyCollection strategyCollection;
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyTable", "[notifyConnEvent]", null, "Host", str, "IConnStrategy", iConnStrategy, "ConnEvent", connEvent);
        }
        String str2 = iConnStrategy.getProtocol().protocol;
        if (ConnType.HTTP3.equals(str2) || ConnType.HTTP3_PLAIN.equals(str2)) {
            anet.channel.e.a.a(connEvent.isSuccess);
            ALog.e("awcn.StrategyTable", "enable http3", null, "uniqueId", this.f620a, "enable", Boolean.valueOf(connEvent.isSuccess));
        }
        if (!connEvent.isSuccess && anet.channel.strategy.utils.c.b(iConnStrategy.getIp())) {
            this.f622c.put(str, Long.valueOf(System.currentTimeMillis()));
            ALog.e("awcn.StrategyTable", "disable ipv6", null, "uniqueId", this.f620a, "host", str);
        }
        synchronized (this.f624f) {
            strategyCollection = this.f624f.get(str);
        }
        if (strategyCollection != null) {
            strategyCollection.notifyConnEvent(iConnStrategy, connEvent);
        }
    }

    public boolean a(String str, long j) {
        Long l = this.f622c.get(str);
        if (l == null) {
            return false;
        }
        if (l.longValue() + j >= System.currentTimeMillis()) {
            return true;
        }
        this.f622c.remove(str);
        return false;
    }
}
