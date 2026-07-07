package anet.channel.strategy;

import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class StrategyList implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<IPConnStrategy> f615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<Integer, ConnHistoryItem> f616b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f617c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Comparator<IPConnStrategy> f618d;

    public interface Predicate<T> {
        boolean apply(T t);
    }

    public StrategyList() {
        this.f615a = new ArrayList();
        this.f616b = new SerialLruCache(40);
        this.f617c = false;
        this.f618d = null;
    }

    public void checkInit() {
        if (this.f615a == null) {
            this.f615a = new ArrayList();
        }
        if (this.f616b == null) {
            this.f616b = new SerialLruCache(40);
        }
        Iterator<Map.Entry<Integer, ConnHistoryItem>> it = this.f616b.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().d()) {
                it.remove();
            }
        }
        for (IPConnStrategy iPConnStrategy : this.f615a) {
            if (!this.f616b.containsKey(Integer.valueOf(iPConnStrategy.getUniqueId()))) {
                this.f616b.put(Integer.valueOf(iPConnStrategy.getUniqueId()), new ConnHistoryItem());
            }
        }
        Collections.sort(this.f615a, a());
    }

    public List<IConnStrategy> getStrategyList() {
        if (this.f615a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = null;
        for (IPConnStrategy iPConnStrategy : this.f615a) {
            ConnHistoryItem connHistoryItem = this.f616b.get(Integer.valueOf(iPConnStrategy.getUniqueId()));
            if (connHistoryItem == null || !connHistoryItem.c()) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(iPConnStrategy);
            } else {
                ALog.i("awcn.StrategyList", "strategy ban!", null, "strategy", iPConnStrategy);
            }
        }
        return linkedList == null ? Collections.EMPTY_LIST : linkedList;
    }

    public void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (!(iConnStrategy instanceof IPConnStrategy) || this.f615a.indexOf(iConnStrategy) == -1) {
            return;
        }
        this.f616b.get(Integer.valueOf(((IPConnStrategy) iConnStrategy).getUniqueId())).a(connEvent.isSuccess);
        Collections.sort(this.f615a, this.f618d);
    }

    public boolean shouldRefresh() {
        boolean z = true;
        boolean z2 = true;
        for (IPConnStrategy iPConnStrategy : this.f615a) {
            if (!this.f616b.get(Integer.valueOf(iPConnStrategy.getUniqueId())).b()) {
                if (iPConnStrategy.f595a == 0) {
                    z = false;
                }
                z2 = false;
            }
        }
        return (this.f617c && z) || z2;
    }

    public String toString() {
        return new ArrayList(this.f615a).toString();
    }

    public void update(l.b bVar) {
        Iterator<IPConnStrategy> it = this.f615a.iterator();
        while (it.hasNext()) {
            it.next().f597c = true;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < bVar.f676h.length; i3++) {
            int i4 = 0;
            while (true) {
                String[] strArr = bVar.f674f;
                if (i4 >= strArr.length) {
                    break;
                }
                a(strArr[i4], 1, bVar.f676h[i3]);
                i4++;
            }
            if (bVar.f675g != null) {
                this.f617c = true;
                int i5 = 0;
                while (true) {
                    String[] strArr2 = bVar.f675g;
                    if (i5 < strArr2.length) {
                        a(strArr2[i5], 0, bVar.f676h[i3]);
                        i5++;
                    }
                }
            } else {
                this.f617c = false;
            }
        }
        if (bVar.f677i != null) {
            while (true) {
                l.e[] eVarArr = bVar.f677i;
                if (i2 >= eVarArr.length) {
                    break;
                }
                l.e eVar = eVarArr[i2];
                String str = eVar.f688a;
                a(str, anet.channel.strategy.utils.c.c(str) ? -1 : 1, eVar.f689b);
                i2++;
            }
        }
        ListIterator<IPConnStrategy> listIterator = this.f615a.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().f597c) {
                listIterator.remove();
            }
        }
        Collections.sort(this.f615a, a());
    }

    private void a(String str, int i2, l.a aVar) {
        int iA = a(this.f615a, new j(this, aVar, str, ConnProtocol.valueOf(aVar)));
        if (iA != -1) {
            IPConnStrategy iPConnStrategy = this.f615a.get(iA);
            iPConnStrategy.cto = aVar.f663c;
            iPConnStrategy.rto = aVar.f664d;
            iPConnStrategy.heartbeat = aVar.f666f;
            iPConnStrategy.f595a = i2;
            iPConnStrategy.f596b = 0;
            iPConnStrategy.f597c = false;
            return;
        }
        IPConnStrategy iPConnStrategyA = IPConnStrategy.a(str, aVar);
        if (iPConnStrategyA != null) {
            iPConnStrategyA.f595a = i2;
            iPConnStrategyA.f596b = 0;
            if (!this.f616b.containsKey(Integer.valueOf(iPConnStrategyA.getUniqueId()))) {
                this.f616b.put(Integer.valueOf(iPConnStrategyA.getUniqueId()), new ConnHistoryItem());
            }
            this.f615a.add(iPConnStrategyA);
        }
    }

    public StrategyList(List<IPConnStrategy> list) {
        this.f615a = new ArrayList();
        this.f616b = new SerialLruCache(40);
        this.f617c = false;
        this.f618d = null;
        this.f615a = list;
    }

    private Comparator a() {
        if (this.f618d == null) {
            this.f618d = new k(this);
        }
        return this.f618d;
    }

    private static <T> int a(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return -1;
        }
        int i2 = 0;
        Iterator<T> it = collection.iterator();
        while (it.hasNext() && !predicate.apply(it.next())) {
            i2++;
        }
        if (i2 == collection.size()) {
            return -1;
        }
        return i2;
    }
}
