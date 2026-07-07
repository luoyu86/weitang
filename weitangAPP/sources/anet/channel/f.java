package anet.channel;

import anet.channel.SessionRequest;
import anet.channel.entity.EventCb;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public class f implements EventCb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SessionRequest.IConnCb f465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SessionRequest f467c;

    public f(SessionRequest sessionRequest, SessionRequest.IConnCb iConnCb, long j) {
        this.f467c = sessionRequest;
        this.f465a = iConnCb;
        this.f466b = j;
    }

    @Override // anet.channel.entity.EventCb
    public void onEvent(Session session, int i2, anet.channel.entity.b bVar) {
        if (session == null) {
            return;
        }
        int i3 = bVar == null ? 0 : bVar.f460b;
        String str = bVar == null ? "" : bVar.f461c;
        if (i2 == 2) {
            ALog.d("awcn.SessionRequest", null, session.p, "Session", session, "EventType", Integer.valueOf(i2), "Event", bVar);
            this.f467c.a(session, i3, str);
            SessionRequest sessionRequest = this.f467c;
            if (sessionRequest.f345b.c(sessionRequest, session)) {
                this.f465a.onDisConnect(session, this.f466b, i2);
                return;
            } else {
                this.f465a.onFailed(session, this.f466b, i2, i3);
                return;
            }
        }
        if (i2 == 256) {
            ALog.d("awcn.SessionRequest", null, session.p, "Session", session, "EventType", Integer.valueOf(i2), "Event", bVar);
            this.f465a.onFailed(session, this.f466b, i2, i3);
        } else {
            if (i2 != 512) {
                return;
            }
            ALog.d("awcn.SessionRequest", null, session.p, "Session", session, "EventType", Integer.valueOf(i2), "Event", bVar);
            this.f467c.a(session, 0, (String) null);
            this.f465a.onSuccess(session, this.f466b);
        }
    }
}
