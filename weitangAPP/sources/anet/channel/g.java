package anet.channel;

import anet.channel.entity.EventCb;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public class g implements EventCb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Session f478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SessionRequest f479b;

    public g(SessionRequest sessionRequest, Session session) {
        this.f479b = sessionRequest;
        this.f478a = session;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        ALog.d("awcn.SessionRequest", "Receive session event", null, "eventType", Integer.valueOf(i2));
        ConnEvent connEvent = new ConnEvent();
        if (i2 == 512) {
            connEvent.isSuccess = true;
        }
        SessionInfo sessionInfo = this.f479b.f346c;
        if (sessionInfo != null) {
            connEvent.isAccs = sessionInfo.isAccs;
        }
        StrategyCenter.getInstance().notifyConnEvent(this.f478a.getRealHost(), this.f478a.getConnStrategy(), connEvent);
    }
}
