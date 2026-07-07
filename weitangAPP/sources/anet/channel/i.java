package anet.channel;

import anet.channel.SessionRequest;

/* JADX INFO: loaded from: classes.dex */
public class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Session f492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SessionRequest.a f493b;

    public i(SessionRequest.a aVar, Session session) {
        this.f493b = aVar;
        this.f492a = session;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            SessionRequest.a aVar = this.f493b;
            SessionRequest.this.a(aVar.f355c, this.f492a.getConnType().getType(), anet.channel.util.i.a(SessionRequest.this.f344a.f335c), (SessionGetCallback) null, 0L);
        } catch (Exception unused) {
        }
    }
}
