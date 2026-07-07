package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class StrategyConfig implements Serializable {
    public static final String NO_RESULT = "No_Result";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SerialLruCache<String, String> f606a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f607b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient StrategyInfoHolder f608c = null;

    public StrategyConfig a() {
        StrategyConfig strategyConfig = new StrategyConfig();
        synchronized (this) {
            strategyConfig.f606a = new SerialLruCache<>(this.f606a, 256);
            strategyConfig.f607b = new ConcurrentHashMap(this.f607b);
            strategyConfig.f608c = this.f608c;
        }
        return strategyConfig;
    }

    public void b() {
        if (this.f606a == null) {
            this.f606a = new SerialLruCache<>(256);
        }
        if (this.f607b == null) {
            this.f607b = new ConcurrentHashMap();
        }
    }

    public String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f607b.get(str);
        }
        return str2;
    }

    public void a(StrategyInfoHolder strategyInfoHolder) {
        this.f608c = strategyInfoHolder;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public void a(l.d dVar) {
        if (dVar.f681b == null) {
            return;
        }
        synchronized (this) {
            TreeMap treeMap = null;
            int i2 = 0;
            while (true) {
                l.b[] bVarArr = dVar.f681b;
                if (i2 >= bVarArr.length) {
                    break;
                }
                l.b bVar = bVarArr[i2];
                if (bVar.j) {
                    this.f606a.remove(bVar.f669a);
                } else if (bVar.f672d != null) {
                    if (treeMap == null) {
                        treeMap = new TreeMap();
                    }
                    treeMap.put(bVar.f669a, bVar.f672d);
                } else {
                    if (!"http".equalsIgnoreCase(bVar.f671c) && !"https".equalsIgnoreCase(bVar.f671c)) {
                        this.f606a.put(bVar.f669a, NO_RESULT);
                    } else {
                        this.f606a.put(bVar.f669a, bVar.f671c);
                    }
                    if (!TextUtils.isEmpty(bVar.f673e)) {
                        this.f607b.put(bVar.f669a, bVar.f673e);
                    } else {
                        this.f607b.remove(bVar.f669a);
                    }
                }
                i2++;
            }
            if (treeMap != null) {
                for (Map.Entry entry : treeMap.entrySet()) {
                    String str = (String) entry.getValue();
                    if (this.f606a.containsKey(str)) {
                        this.f606a.put((String) entry.getKey(), this.f606a.get(str));
                    } else {
                        this.f606a.put((String) entry.getKey(), NO_RESULT);
                    }
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyConfig", "", null, "SchemeMap", this.f606a.toString());
            ALog.d("awcn.StrategyConfig", "", null, "UnitMap", this.f607b.toString());
        }
    }

    public String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !anet.channel.strategy.utils.c.c(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f606a.get(str);
            if (str2 == null) {
                this.f606a.put(str, NO_RESULT);
            }
        }
        if (str2 == null) {
            this.f608c.d().a(str, false);
        } else if (NO_RESULT.equals(str2)) {
            return null;
        }
        return str2;
    }
}
