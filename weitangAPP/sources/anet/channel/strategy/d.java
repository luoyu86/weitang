package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.util.ALog;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StrategyInfoHolder f636b;

    public d(StrategyInfoHolder strategyInfoHolder, String str) {
        this.f636b = strategyInfoHolder;
        this.f635a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ALog.i("awcn.StrategyInfoHolder", "start loading strategy files", null, new Object[0]);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (AwcnConfig.isAsyncLoadStrategyEnable()) {
                ALog.i("awcn.StrategyInfoHolder", "load strategy async", null, new Object[0]);
                if (!TextUtils.isEmpty(this.f635a)) {
                    this.f636b.a(this.f635a, true);
                }
                StrategyConfig strategyConfig = (StrategyConfig) m.a("StrategyConfig", null);
                if (strategyConfig != null) {
                    strategyConfig.b();
                    strategyConfig.a(this.f636b);
                    synchronized (this.f636b) {
                        this.f636b.f610b = strategyConfig;
                    }
                }
            }
            File[] fileArrB = m.b();
            if (fileArrB == null) {
                return;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < fileArrB.length && i2 < 2; i3++) {
                File file = fileArrB[i3];
                if (!file.isDirectory()) {
                    String name = file.getName();
                    if (!name.equals(this.f635a) && !name.startsWith("StrategyConfig")) {
                        this.f636b.a(name, false);
                        i2++;
                    }
                }
            }
            ALog.i("awcn.StrategyInfoHolder", "end loading strategy files", null, "total cost", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        } catch (Exception unused) {
        }
    }
}
