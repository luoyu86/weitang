package a.a.w;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.HttpUrl;

/* JADX INFO: loaded from: classes.dex */
public class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SessionCenter f259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HttpUrl f260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RequestStatistic f261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ HttpUrl f262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ f f264f;

    public h(f fVar, SessionCenter sessionCenter, HttpUrl httpUrl, RequestStatistic requestStatistic, HttpUrl httpUrl2, boolean z) {
        this.f264f = fVar;
        this.f259a = sessionCenter;
        this.f260b = httpUrl;
        this.f261c = requestStatistic;
        this.f262d = httpUrl2;
        this.f263e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Session session = this.f259a.get(this.f260b, anet.channel.entity.c.f462a, 3000L);
        this.f261c.connWaitTime = System.currentTimeMillis() - jCurrentTimeMillis;
        this.f261c.spdyRequestSend = session != null;
        Session sessionA = this.f264f.a(session, this.f259a, this.f262d, this.f263e);
        f fVar = this.f264f;
        fVar.f(sessionA, fVar.f246a.f275a.a());
    }
}
