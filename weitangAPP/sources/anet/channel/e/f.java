package anet.channel.e;

import anet.channel.Session;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.EventCb;
import anet.channel.statist.Http3DetectStat;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IConnStrategy;

/* JADX INFO: loaded from: classes.dex */
public class f implements EventCb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IConnStrategy f451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f452b;

    public f(e eVar, IConnStrategy iConnStrategy) {
        this.f452b = eVar;
        this.f451a = iConnStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        ?? r5 = i2 != 1 ? 0 : 1;
        a.f437a.a(NetworkStatusHelper.getUniqueId(this.f452b.f450b), r5);
        session.close(false);
        Http3DetectStat http3DetectStat = new Http3DetectStat(a.f438b, this.f451a);
        http3DetectStat.ret = r5;
        AppMonitor.getInstance().commitStat(http3DetectStat);
    }
}
