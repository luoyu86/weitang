package anet.channel.session;

import anet.channel.IAuth;
import anet.channel.heartbeat.IHeartbeat;
import anet.channel.statist.SessionStatistic;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public class i implements IAuth.AuthCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TnetSpdySession f578a;

    public i(TnetSpdySession tnetSpdySession) {
        this.f578a = tnetSpdySession;
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthFail(int i2, String str) {
        this.f578a.notifyStatus(5, null);
        SessionStatistic sessionStatistic = this.f578a.f331q;
        if (sessionStatistic != null) {
            sessionStatistic.closeReason = "Accs_Auth_Fail:" + i2;
            this.f578a.f331q.errorCode = (long) i2;
        }
        this.f578a.close();
    }

    @Override // anet.channel.IAuth.AuthCallback
    public void onAuthSuccess() {
        this.f578a.notifyStatus(4, null);
        this.f578a.z = System.currentTimeMillis();
        TnetSpdySession tnetSpdySession = this.f578a;
        IHeartbeat iHeartbeat = tnetSpdySession.D;
        if (iHeartbeat != null) {
            iHeartbeat.start(tnetSpdySession);
        }
        TnetSpdySession tnetSpdySession2 = this.f578a;
        SessionStatistic sessionStatistic = tnetSpdySession2.f331q;
        sessionStatistic.ret = 1;
        ALog.d("awcn.TnetSpdySession", "spdyOnStreamResponse", tnetSpdySession2.p, "authTime", Long.valueOf(sessionStatistic.authTime));
        TnetSpdySession tnetSpdySession3 = this.f578a;
        if (tnetSpdySession3.A > 0) {
            tnetSpdySession3.f331q.authTime = System.currentTimeMillis() - this.f578a.A;
        }
    }
}
