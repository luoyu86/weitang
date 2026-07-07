package a.a.w;

import anet.channel.Session;
import anet.channel.SessionCenter;
import anet.channel.SessionGetCallback;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class i implements SessionGetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RequestStatistic f265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Request f267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ SessionCenter f268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpUrl f269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f f271g;

    public i(f fVar, RequestStatistic requestStatistic, long j, Request request, SessionCenter sessionCenter, HttpUrl httpUrl, boolean z) {
        this.f271g = fVar;
        this.f265a = requestStatistic;
        this.f266b = j;
        this.f267c = request;
        this.f268d = sessionCenter;
        this.f269e = httpUrl;
        this.f270f = z;
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetFail() {
        ALog.e("anet.NetworkTask", "onSessionGetFail", this.f271g.f246a.f277c, AgooConstants.OPEN_URL, this.f265a.url);
        this.f265a.connWaitTime = System.currentTimeMillis() - this.f266b;
        f fVar = this.f271g;
        fVar.f(fVar.a(null, this.f268d, this.f269e, this.f270f), this.f267c);
    }

    @Override // anet.channel.SessionGetCallback
    public void onSessionGetSuccess(Session session) {
        ALog.i("anet.NetworkTask", "onSessionGetSuccess", this.f271g.f246a.f277c, "Session", session);
        this.f265a.connWaitTime = System.currentTimeMillis() - this.f266b;
        this.f265a.spdyRequestSend = true;
        this.f271g.f(session, this.f267c);
    }
}
