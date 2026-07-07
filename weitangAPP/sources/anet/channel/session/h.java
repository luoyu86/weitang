package anet.channel.session;

import anet.channel.statist.SessionStatistic;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TnetSpdySession f577a;

    public h(TnetSpdySession tnetSpdySession) {
        this.f577a = tnetSpdySession;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f577a.y) {
            TnetSpdySession tnetSpdySession = this.f577a;
            ALog.e("awcn.TnetSpdySession", "send msg time out!", tnetSpdySession.p, "pingUnRcv:", Boolean.valueOf(tnetSpdySession.y));
            try {
                this.f577a.handleCallbacks(2048, null);
                SessionStatistic sessionStatistic = this.f577a.f331q;
                if (sessionStatistic != null) {
                    sessionStatistic.closeReason = "ping time out";
                }
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = false;
                connEvent.isAccs = this.f577a.I;
                StrategyCenter.getInstance().notifyConnEvent(this.f577a.f325d, this.f577a.k, connEvent);
                this.f577a.close(true);
            } catch (Exception unused) {
            }
        }
    }
}
