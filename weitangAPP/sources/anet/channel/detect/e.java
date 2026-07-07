package anet.channel.detect;

import anet.channel.AwcnConfig;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public class e implements IStrategyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f413a;

    public e(d dVar) {
        this.f413a = dVar;
    }

    @Override // anet.channel.strategy.IStrategyListener
    public void onStrategyUpdated(l.d dVar) {
        l.c[] cVarArr;
        int i2 = 0;
        ALog.i("anet.HorseRaceDetector", "onStrategyUpdated", null, new Object[0]);
        if (!AwcnConfig.isHorseRaceEnable() || (cVarArr = dVar.f682c) == null || cVarArr.length == 0) {
            return;
        }
        synchronized (this.f413a.f411a) {
            while (true) {
                l.c[] cVarArr2 = dVar.f682c;
                if (i2 < cVarArr2.length) {
                    l.c cVar = cVarArr2[i2];
                    this.f413a.f411a.put(cVar.f678a, cVar);
                    i2++;
                }
            }
        }
    }
}
