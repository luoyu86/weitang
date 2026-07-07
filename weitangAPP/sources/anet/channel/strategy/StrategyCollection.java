package anet.channel.strategy;

import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.PolicyVersionStat;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class StrategyCollection implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile String f600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private StrategyList f603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient long f604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient boolean f605h;

    public StrategyCollection() {
        this.f603f = null;
        this.f599b = 0L;
        this.f600c = null;
        this.f601d = false;
        this.f602e = 0;
        this.f604g = 0L;
        this.f605h = true;
    }

    public synchronized void checkInit() {
        if (System.currentTimeMillis() - this.f599b > 172800000) {
            this.f603f = null;
            return;
        }
        StrategyList strategyList = this.f603f;
        if (strategyList != null) {
            strategyList.checkInit();
        }
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > this.f599b;
    }

    public synchronized void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        StrategyList strategyList = this.f603f;
        if (strategyList != null) {
            strategyList.notifyConnEvent(iConnStrategy, connEvent);
            if (!connEvent.isSuccess && this.f603f.shouldRefresh()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f604g > 60000) {
                    StrategyCenter.getInstance().forceRefreshStrategy(this.f598a);
                    this.f604g = jCurrentTimeMillis;
                }
            }
        }
    }

    public synchronized List<IConnStrategy> queryStrategyList() {
        if (this.f603f == null) {
            return Collections.EMPTY_LIST;
        }
        if (this.f605h) {
            this.f605h = false;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f598a, this.f602e);
            policyVersionStat.reportType = 0;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        return this.f603f.getStrategyList();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("\nStrategyList = ");
        sb.append(this.f599b);
        StrategyList strategyList = this.f603f;
        if (strategyList != null) {
            sb.append(strategyList.toString());
        } else if (this.f600c != null) {
            sb.append('[');
            sb.append(this.f598a);
            sb.append("=>");
            sb.append(this.f600c);
            sb.append(']');
        } else {
            sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return sb.toString();
    }

    public synchronized void update(l.b bVar) {
        l.e[] eVarArr;
        l.a[] aVarArr;
        this.f599b = System.currentTimeMillis() + (((long) bVar.f670b) * 1000);
        if (!bVar.f669a.equalsIgnoreCase(this.f598a)) {
            ALog.e("StrategyCollection", "update error!", null, "host", this.f598a, "dnsInfo.host", bVar.f669a);
            return;
        }
        int i2 = this.f602e;
        int i3 = bVar.l;
        if (i2 != i3) {
            this.f602e = i3;
            PolicyVersionStat policyVersionStat = new PolicyVersionStat(this.f598a, i3);
            policyVersionStat.reportType = 1;
            AppMonitor.getInstance().commitStat(policyVersionStat);
        }
        this.f600c = bVar.f672d;
        String[] strArr = bVar.f674f;
        if ((strArr != null && strArr.length != 0 && (aVarArr = bVar.f676h) != null && aVarArr.length != 0) || ((eVarArr = bVar.f677i) != null && eVarArr.length != 0)) {
            if (this.f603f == null) {
                this.f603f = new StrategyList();
            }
            this.f603f.update(bVar);
            return;
        }
        this.f603f = null;
    }

    public StrategyCollection(String str) {
        this.f603f = null;
        this.f599b = 0L;
        this.f600c = null;
        this.f601d = false;
        this.f602e = 0;
        this.f604g = 0L;
        this.f605h = true;
        this.f598a = str;
        this.f601d = DispatchConstants.isAmdcServerDomain(str);
    }
}
