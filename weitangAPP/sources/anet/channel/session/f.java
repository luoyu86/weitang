package anet.channel.session;

import anet.channel.RequestCb;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Request f572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RequestCb f573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RequestStatistic f574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f575d;

    public f(d dVar, Request request, RequestCb requestCb, RequestStatistic requestStatistic) {
        this.f575d = dVar;
        this.f572a = request;
        this.f573b = requestCb;
        this.f574c = requestStatistic;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f572a.f528a.sendBeforeTime = System.currentTimeMillis() - this.f572a.f528a.reqStart;
        b.a(this.f572a, new g(this));
    }
}
