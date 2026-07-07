package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.StrategyStatObject;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.tom_roush.fontbox.ttf.OpenTypeScript;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class StrategyInfoHolder implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, StrategyTable> f609a = new LruStrategyMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile StrategyConfig f610b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f611c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final StrategyTable f612d = new StrategyTable(OpenTypeScript.UNKNOWN);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<String> f613e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile String f614f = "";

    public static class LruStrategyMap extends SerialLruCache<String, StrategyTable> {
        public LruStrategyMap() {
            super(3);
        }

        @Override // anet.channel.strategy.utils.SerialLruCache
        public boolean entryRemoved(Map.Entry<String, StrategyTable> entry) {
            anet.channel.strategy.utils.a.a(new f(this, entry));
            return true;
        }
    }

    private StrategyInfoHolder() {
        try {
            e();
            g();
        } catch (Throwable unused) {
        }
        f();
    }

    public static StrategyInfoHolder a() {
        return new StrategyInfoHolder();
    }

    private void e() {
        NetworkStatusHelper.addStatusChangeListener(this);
        this.f614f = a(NetworkStatusHelper.getStatus());
    }

    private void f() {
        Iterator<Map.Entry<String, StrategyTable>> it = this.f609a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().a();
        }
        synchronized (this) {
            if (this.f610b == null) {
                StrategyConfig strategyConfig = new StrategyConfig();
                strategyConfig.b();
                strategyConfig.a(this);
                this.f610b = strategyConfig;
            }
        }
    }

    private void g() {
        ALog.i("awcn.StrategyInfoHolder", RequestParameters.X_OSS_RESTORE, null, new Object[0]);
        String str = this.f614f;
        if (!AwcnConfig.isAsyncLoadStrategyEnable()) {
            if (!TextUtils.isEmpty(str)) {
                a(str, true);
            }
            this.f610b = (StrategyConfig) m.a("StrategyConfig", null);
            if (this.f610b != null) {
                this.f610b.b();
                this.f610b.a(this);
            }
        }
        anet.channel.strategy.utils.a.a(new d(this, str));
    }

    public void b() {
        NetworkStatusHelper.removeStatusChangeListener(this);
    }

    public void c() {
        synchronized (this) {
            for (StrategyTable strategyTable : this.f609a.values()) {
                if (strategyTable.f623d) {
                    StrategyStatObject strategyStatObject = new StrategyStatObject(1);
                    String str = strategyTable.f620a;
                    strategyStatObject.writeStrategyFileId = str;
                    m.a(strategyTable, str, strategyStatObject);
                    strategyTable.f623d = false;
                }
            }
            m.a(this.f610b.a(), "StrategyConfig", null);
        }
    }

    public StrategyTable d() {
        StrategyTable strategyTable = this.f612d;
        String str = this.f614f;
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f609a) {
                strategyTable = this.f609a.get(str);
                if (strategyTable == null) {
                    strategyTable = new StrategyTable(str);
                    this.f609a.put(str, strategyTable);
                }
            }
        }
        return strategyTable;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f614f = a(networkStatus);
        String str = this.f614f;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f609a) {
            if (!this.f609a.containsKey(str)) {
                anet.channel.strategy.utils.a.a(new e(this, str));
            }
        }
    }

    public void a(String str, boolean z) {
        synchronized (this.f613e) {
            if (this.f613e.contains(str)) {
                return;
            }
            this.f613e.add(str);
            StrategyStatObject strategyStatObject = null;
            if (z) {
                strategyStatObject = new StrategyStatObject(0);
                strategyStatObject.readStrategyFileId = str;
            }
            StrategyTable strategyTable = (StrategyTable) m.a(str, strategyStatObject);
            if (strategyTable != null) {
                strategyTable.a();
                synchronized (this.f609a) {
                    this.f609a.put(strategyTable.f620a, strategyTable);
                }
            }
            synchronized (this.f613e) {
                this.f613e.remove(str);
            }
            if (z) {
                strategyStatObject.isSucceed = strategyTable != null ? 1 : 0;
                AppMonitor.getInstance().commitStat(strategyStatObject);
            }
        }
    }

    private String a(NetworkStatusHelper.NetworkStatus networkStatus) {
        if (networkStatus.isWifi()) {
            String strMd5ToHex = StringUtils.md5ToHex(NetworkStatusHelper.getWifiBSSID());
            return "WIFI$" + (TextUtils.isEmpty(strMd5ToHex) ? "" : strMd5ToHex);
        }
        if (!networkStatus.isMobile()) {
            return "";
        }
        return networkStatus.getType() + "$" + NetworkStatusHelper.getApn();
    }

    public void a(l.d dVar) {
        int i2 = dVar.f686g;
        if (i2 != 0) {
            AmdcRuntimeInfo.updateAmdcLimit(i2, dVar.f687h);
        }
        d().update(dVar);
        this.f610b.a(dVar);
    }
}
